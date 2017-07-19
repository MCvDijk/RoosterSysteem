package RoosterSysteem.WebServices;

import RoosterSysteem.Model.mRooster.MRooster;
import RoosterSysteem.Model.persoon.Medewerker;
import RoosterSysteem.Service.MRoosterService;
import RoosterSysteem.Service.MedewerkerService;
import RoosterSysteem.Service.ServiceProvider;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.format.ISODateTimeFormat;

import javax.json.*;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.ByteArrayInputStream;
import java.time.LocalTime;

@Path("/rooster")
public class MRoosterResource {
    private MRoosterService service = ServiceProvider.getmRoosterService();
    private MedewerkerService mservice = ServiceProvider.getMedewerkerService();

    @POST
    @Path("/medewerker/opslaan")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Response clientroosterOpslaan(@FormParam("dag") String dag,
                                         @FormParam("date") String week,
                                         @FormParam("begintijd") String begintijd1,
                                         @FormParam("eindtijd") String eindtijd1,
                                         @FormParam("vast") String vast,
                                         @FormParam("medewerkers") String naam) {
        String[] parts = naam.split(" ", 2);
        String voornaam = parts[0];
        String achternaam = parts[1];
        String partbegintijd1 = begintijd1.substring(0, 2);
        String partbegintijd2 = begintijd1.substring(2);
        String begintijd = partbegintijd1 + ":" + partbegintijd2;
        String parteindtijd1 = eindtijd1.substring(0, 2);
        String parteindtijd2 = eindtijd1.substring(2);
        String eindtijd = parteindtijd1 + ":" + parteindtijd2;
        Medewerker medewerker = mservice.getMedewerker(voornaam, achternaam);
        boolean match = false;
        if (vast == null) {
            MRooster m = new MRooster(medewerker, week, dag.toLowerCase(), LocalTime.parse(begintijd), LocalTime.parse(eindtijd), LocalTime.parse("00:30"), false, medewerker.getVoornaam(), medewerker.getAchternaam());
            for (MRooster mr : service.getMedewerkerRooster(medewerker)) {
                if (mr.getWeekNummer().equals(week)
                        && mr.getDag().equals(dag.toLowerCase())) {
                    service.updateMRooster(m);
                    match = false;
                    break;
                } else {
                    match = true;
                }
            }
            if (service.getMedewerkerRooster(medewerker).size() == 0) {
                match = true;
            }
            if (match) {
                service.writeMRooster(m);
            }

        } else if (vast.equals("on")) {
            String[] delen = week.split("-");
            String jaar = delen[0];
            String weeknr = delen[1];
            weeknr = weeknr.replace("W", "");
            int weeknummer = Integer.parseInt(weeknr);
            weeknummer = weeknummer - 1;
            String datum = "";
            int jaartal = Integer.parseInt(jaar);
            for (int i = 0; i < 52; i++) {
                weeknummer = weeknummer + 1;
                if (weeknummer > 52) {
                    jaartal = jaartal + 1;
                    weeknummer = 1;
                }
                if (weeknummer < 10) {
                    datum = jaartal + "-W" + 0 + weeknummer;
                } else if (weeknummer > 9) {
                    datum = jaartal + "-W" + weeknummer;
                }
                MRooster m = new MRooster(medewerker, datum, dag.toLowerCase(), LocalTime.parse(begintijd), LocalTime.parse(eindtijd), LocalTime.parse("00:30"), false, medewerker.getVoornaam(), medewerker.getAchternaam());
                for (MRooster mr : service.getMedewerkerRooster(medewerker)) {
                    if (mr.getWeekNummer().equals(datum)
                            && mr.getDag().equals(dag.toLowerCase())) {
                        service.updateMRooster(m);
                        match = false;
                        break;
                    } else {
                        match = true;
                    }
                }
                if (service.getMedewerkerRooster(medewerker).size() == 0) {
                    match = true;
                }
                if (match) {
                    service.writeMRooster(m);
                    match = false;
                }

            }
        }
        return Response.ok().build();
    }

    @POST
    @Path("/maandag/medewerkers/ophalen")
    @Produces("application/json")
    public String roostersMaandagOphalen(String jsonBody) {
        JsonObject lJsonObjectIn = (JsonObject) Json.createReader(new ByteArrayInputStream(jsonBody.getBytes())).read();
        String datum = lJsonObjectIn.getString("date");

        JsonArrayBuilder lJsonArrayBuilder = Json.createArrayBuilder();

        for (MRooster m : service.getAllMRooster()) {
            if (datum.equals(m.getWeekNummer()) && m.getDag().equals("maandag")) {
                JsonObjectBuilder lJsonObjectBuilder = Json.createObjectBuilder();
                Medewerker medewerker = mservice.getMedewerker(m.getVoornaam(), m.getAchternaam());
                String ziek = "nee";
                if(m.isZiek() == true){
                    ziek = "ja";
                }
                lJsonObjectBuilder
                        .add("naam", medewerker.getVolledigeNaam(m.getVoornaam(), m.getAchternaam()))
                        .add("begintijd", m.getBeginTijd().toString())
                        .add("eindtijd", m.getEindTijd().toString())
                        .add("pauze", m.getPauze().toString())
                        .add("ziek", ziek);
                lJsonArrayBuilder.add(lJsonObjectBuilder);
            }
        }

        String lJsonOutStr = lJsonArrayBuilder.build().toString();
        return lJsonOutStr;
    }

    @POST
    @Path("/dinsdag/medewerkers/ophalen")
    @Produces("application/json")
    public String roostersDinsdagOphalen(String jsonBody) {
        JsonObject lJsonObjectIn = (JsonObject) Json.createReader(new ByteArrayInputStream(jsonBody.getBytes())).read();
        String datum = lJsonObjectIn.getString("date");

        JsonArrayBuilder lJsonArrayBuilder = Json.createArrayBuilder();

        for (MRooster m : service.getAllMRooster()) {
            if (datum.equals(m.getWeekNummer()) && m.getDag().equals("dinsdag")) {
                JsonObjectBuilder lJsonObjectBuilder = Json.createObjectBuilder();
                Medewerker medewerker = mservice.getMedewerker(m.getVoornaam(), m.getAchternaam());
                String ziek = "nee";
                if(m.isZiek() == true){
                    ziek = "ja";
                }
                lJsonObjectBuilder
                        .add("naam", medewerker.getVolledigeNaam(m.getVoornaam(), m.getAchternaam()))
                        .add("begintijd", m.getBeginTijd().toString())
                        .add("eindtijd", m.getEindTijd().toString())
                        .add("pauze", m.getPauze().toString())
                        .add("ziek", ziek);
                lJsonArrayBuilder.add(lJsonObjectBuilder);
            }

        }


        String lJsonOutStr = lJsonArrayBuilder.build().toString();
        return lJsonOutStr;
    }

    @POST
    @Path("/woensdag/medewerkers/ophalen")
    @Produces("application/json")
    public String roostersWoensdagOphalen(String jsonBody) {
        JsonObject lJsonObjectIn = (JsonObject) Json.createReader(new ByteArrayInputStream(jsonBody.getBytes())).read();
        String datum = lJsonObjectIn.getString("date");

        JsonArrayBuilder lJsonArrayBuilder = Json.createArrayBuilder();

        for (MRooster m : service.getAllMRooster()) {
            if (datum.equals(m.getWeekNummer()) && m.getDag().equals("woensdag")) {
                JsonObjectBuilder lJsonObjectBuilder = Json.createObjectBuilder();
                Medewerker medewerker = mservice.getMedewerker(m.getVoornaam(), m.getAchternaam());
                String ziek = "nee";
                if(m.isZiek() == true){
                    ziek = "ja";
                }
                lJsonObjectBuilder
                        .add("naam", medewerker.getVolledigeNaam(m.getVoornaam(), m.getAchternaam()))
                        .add("begintijd", m.getBeginTijd().toString())
                        .add("eindtijd", m.getEindTijd().toString())
                        .add("pauze", m.getPauze().toString())
                        .add("ziek", ziek);
                lJsonArrayBuilder.add(lJsonObjectBuilder);
            }
        }

        String lJsonOutStr = lJsonArrayBuilder.build().toString();
        return lJsonOutStr;
    }

    @POST
    @Path("/donderdag/medewerkers/ophalen")
    @Produces("application/json")
    public String roostersDonderdagOphalen(String jsonBody) {
        JsonObject lJsonObjectIn = (JsonObject) Json.createReader(new ByteArrayInputStream(jsonBody.getBytes())).read();
        String datum = lJsonObjectIn.getString("date");

        JsonArrayBuilder lJsonArrayBuilder = Json.createArrayBuilder();

        for (MRooster m : service.getAllMRooster()) {
            if (datum.equals(m.getWeekNummer()) && m.getDag().equals("donderdag")) {
                JsonObjectBuilder lJsonObjectBuilder = Json.createObjectBuilder();
                Medewerker medewerker = mservice.getMedewerker(m.getVoornaam(), m.getAchternaam());
                String ziek = "nee";
                if(m.isZiek() == true){
                    ziek = "ja";
                }
                lJsonObjectBuilder
                        .add("naam", medewerker.getVolledigeNaam(m.getVoornaam(), m.getAchternaam()))
                        .add("begintijd", m.getBeginTijd().toString())
                        .add("eindtijd", m.getEindTijd().toString())
                        .add("pauze", m.getPauze().toString())
                        .add("ziek", ziek);
                lJsonArrayBuilder.add(lJsonObjectBuilder);
            }
        }


        String lJsonOutStr = lJsonArrayBuilder.build().toString();
        return lJsonOutStr;
    }

    @POST
    @Path("/vrijdag/medewerkers/ophalen")
    @Produces("application/json")
    public String roostersVrijdagOphalen(String jsonBody) {
        JsonObject lJsonObjectIn = (JsonObject) Json.createReader(new ByteArrayInputStream(jsonBody.getBytes())).read();
        String datum = lJsonObjectIn.getString("date");

        JsonArrayBuilder lJsonArrayBuilder = Json.createArrayBuilder();


        for (MRooster m : service.getAllMRooster()) {
            if (datum.equals(m.getWeekNummer()) && m.getDag().equals("vrijdag")) {
                JsonObjectBuilder lJsonObjectBuilder = Json.createObjectBuilder();
                Medewerker medewerker = mservice.getMedewerker(m.getVoornaam(), m.getAchternaam());
                String ziek = "nee";
                if(m.isZiek() == true){
                    ziek = "ja";
                }
                lJsonObjectBuilder
                        .add("naam", medewerker.getVolledigeNaam(m.getVoornaam(), m.getAchternaam()))
                        .add("begintijd", m.getBeginTijd().toString())
                        .add("eindtijd", m.getEindTijd().toString())
                        .add("pauze", m.getPauze().toString())
                        .add("ziek", ziek);
                lJsonArrayBuilder.add(lJsonObjectBuilder);
            }
        }

        String lJsonOutStr = lJsonArrayBuilder.build().toString();
        return lJsonOutStr;
    }

    @POST
    @Path("/zaterdag/medewerkers/ophalen")
    @Produces("application/json")
    public String roostersZaterdagOphalen(String jsonBody) {
        JsonObject lJsonObjectIn = (JsonObject) Json.createReader(new ByteArrayInputStream(jsonBody.getBytes())).read();
        String datum = lJsonObjectIn.getString("date");

        JsonArrayBuilder lJsonArrayBuilder = Json.createArrayBuilder();


        for (MRooster m : service.getAllMRooster()) {
            if (datum.equals(m.getWeekNummer()) && m.getDag().equals("zaterdag")) {
                JsonObjectBuilder lJsonObjectBuilder = Json.createObjectBuilder();
                Medewerker medewerker = mservice.getMedewerker(m.getVoornaam(), m.getAchternaam());
                String ziek = "nee";
                if(m.isZiek() == true){
                    ziek = "ja";
                }
                lJsonObjectBuilder
                        .add("naam", medewerker.getVolledigeNaam(m.getVoornaam(), m.getAchternaam()))
                        .add("begintijd", m.getBeginTijd().toString())
                        .add("eindtijd", m.getEindTijd().toString())
                        .add("pauze", m.getPauze().toString())
                        .add("ziek", ziek);
                lJsonArrayBuilder.add(lJsonObjectBuilder);
            }
        }


        String lJsonOutStr = lJsonArrayBuilder.build().toString();
        return lJsonOutStr;
    }

    @POST
    @Path("/zondag/medewerkers/ophalen")
    @Produces("application/json")
    public String roostersZondagOphalen(String jsonBody) {
        JsonObject lJsonObjectIn = (JsonObject) Json.createReader(new ByteArrayInputStream(jsonBody.getBytes())).read();
        String datum = lJsonObjectIn.getString("date");

        JsonArrayBuilder lJsonArrayBuilder = Json.createArrayBuilder();

        for (MRooster m : service.getAllMRooster()) {
            if (datum.equals(m.getWeekNummer()) && m.getDag().equals("zondag")) {
                JsonObjectBuilder lJsonObjectBuilder = Json.createObjectBuilder();
                Medewerker medewerker = mservice.getMedewerker(m.getVoornaam(), m.getAchternaam());
                String ziek = "nee";
                if(m.isZiek() == true){
                    ziek = "ja";
                }
                lJsonObjectBuilder
                        .add("naam", medewerker.getVolledigeNaam(m.getVoornaam(), m.getAchternaam()))
                        .add("begintijd", m.getBeginTijd().toString())
                        .add("eindtijd", m.getEindTijd().toString())
                        .add("pauze", m.getPauze().toString())
                        .add("ziek", ziek);
                lJsonArrayBuilder.add(lJsonObjectBuilder);
            }
        }

        String lJsonOutStr = lJsonArrayBuilder.build().toString();
        return lJsonOutStr;
    }

    @POST
    @Path("/medewerker/ophalen")
    @Produces("application/json")
    public String medewerkerRoosterOphalen(String jsonBody) {
        JsonObject lJsonObjectIn = (JsonObject) Json.createReader(new ByteArrayInputStream(jsonBody.getBytes())).read();
        String datum = lJsonObjectIn.getString("date");
        String naam = lJsonObjectIn.getString("name");
        String[] parts = naam.split(" ", 2);
        String voornaam = parts[0];
        String achternaam = parts[1];
        Medewerker medewerker = mservice.getMedewerker(voornaam,achternaam);
        JsonArrayBuilder lJsonArrayBuilder = Json.createArrayBuilder();

        for (MRooster m : service.getMedewerkerRooster(medewerker)) {
            if (datum.equals(m.getWeekNummer())) {
                JsonObjectBuilder lJsonObjectBuilder = Json.createObjectBuilder();
                String ziek = "nee";
                if(m.isZiek() == true){
                    ziek = "ja";
                }
                lJsonObjectBuilder
                        .add("dag", m.getDag())
                        .add("begintijd", m.getBeginTijd().toString())
                        .add("eindtijd", m.getEindTijd().toString())
                        .add("pauze", m.getPauze().toString())
                        .add("ziek", ziek);
                lJsonArrayBuilder.add(lJsonObjectBuilder);
            }
        }

        String lJsonOutStr = lJsonArrayBuilder.build().toString();
        return lJsonOutStr;
    }

    @POST
    @Path("/medewerker/ziek")
    @Produces("application/json")
    public Response medewerkerafwezig(String jsonBody){
        JsonObject lJsonObjectIn = (JsonObject) Json.createReader(new ByteArrayInputStream(jsonBody.getBytes())).read();
        String datum = lJsonObjectIn.getString("date");
        String status = lJsonObjectIn.getString("status");
        String[] list = status.split(",");
        String afwezig = list[0].toLowerCase();
        String naam = list[1];
        String dag = list[2];
        String[] parts = naam.split(" ", 2);
        String voornaam = parts[0];
        String achternaam = parts[1];
        Medewerker m  = mservice.getMedewerker(voornaam,achternaam);


        if(afwezig.equals("nee")){
            MRooster mr = service.getOneMedewerkerRooster(m,datum,dag);
            mr.setZiek(true);
            service.updateMRooster(mr);
        }
        else if(afwezig.equals("ja")){
            MRooster mr = service.getOneMedewerkerRooster(m,datum,dag);
            mr.setZiek(false);
            service.updateMRooster(mr);
        }

        return Response.ok().build();
    }


}