package RoosterSysteem.WebServices;

import RoosterSysteem.Model.mRooster.MRooster;
import RoosterSysteem.Model.persoon.Medewerker;
import RoosterSysteem.Service.MRoosterService;
import RoosterSysteem.Service.MedewerkerService;
import RoosterSysteem.Service.ServiceProvider;

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
    @Path("/medewerker/ophalen")
    @Produces("application/json")
    public String roosterOphalen(String jsonBody) {
        JsonObject lJsonObjectIn = (JsonObject) Json.createReader(new ByteArrayInputStream(jsonBody.getBytes())).read();
        String naam = lJsonObjectIn.getString("naam");
        String datum = lJsonObjectIn.getString("datum");
        String[] parts = naam.split(" ", 2);
        String voornaam = parts[0];
        String achternaam = parts[1];

        Medewerker medewerker = mservice.getMedewerker(voornaam, achternaam);
        JsonArrayBuilder lJsonArrayBuilder = Json.createArrayBuilder();
        JsonObjectBuilder lJsonObjectBuilder = Json.createObjectBuilder();
        lJsonObjectBuilder.add("naam", naam);
        for (MRooster m : service.getMedewerkerRooster(medewerker)) {
            if (m.getWeekNummer().equals(datum) && m.getDag().equals("maandag")) {
                lJsonObjectBuilder
                        .add("mabegintijdh", m.getBeginTijd().getHour())
                        .add("mabegintijdm", m.getBeginTijd().getMinute())
                        .add("maeindtijdh", m.getEindTijd().getHour())
                        .add("maeindtijdm", m.getEindTijd().getMinute())
                        .add("mapauzeh", m.getPauze().getHour())
                        .add("mapauzem", m.getPauze().getMinute());
                break;
            }
        }
        for (MRooster m : service.getMedewerkerRooster(medewerker)) {
            if (m.getWeekNummer().equals(datum) && m.getDag().equals("dinsdag")) {
                lJsonObjectBuilder
                        .add("dibegintijdh", m.getBeginTijd().getHour())
                        .add("dibegintijdm", m.getBeginTijd().getMinute())
                        .add("dieindtijdh", m.getEindTijd().getHour())
                        .add("dieindtijdm", m.getEindTijd().getMinute())
                        .add("dipauzeh", m.getPauze().toString())
                        .add("dipauzem", m.getPauze().getMinute());
                break;
            }

        }
        for (MRooster m : service.getMedewerkerRooster(medewerker)) {
            if (m.getWeekNummer().equals(datum) && m.getDag().equals("woensdag")) {
                lJsonObjectBuilder
                        .add("wobegintijdh", m.getBeginTijd().getHour())
                        .add("wobegintijdm", m.getBeginTijd().getMinute())
                        .add("woeindtijdh", m.getEindTijd().getHour())
                        .add("woeindtijdm", m.getEindTijd().getMinute())
                        .add("wopauzeh", m.getPauze().toString())
                        .add("wopauzem", m.getPauze().getMinute());
                break;
            }
        }
        for (MRooster m : service.getMedewerkerRooster(medewerker)) {
            if (m.getWeekNummer().equals(datum) && m.getDag().equals("donderdag")) {
                lJsonObjectBuilder
                        .add("dobegintijdh", m.getBeginTijd().getHour())
                        .add("dobegintijdm", m.getBeginTijd().getMinute())
                        .add("doeindtijdh", m.getEindTijd().getHour())
                        .add("doeindtijdm", m.getEindTijd().getMinute())
                        .add("dopauzeh", m.getPauze().toString())
                        .add("dopauzem", m.getPauze().getMinute());
                break;
            }
        }
        for (MRooster m : service.getMedewerkerRooster(medewerker)) {
            if (m.getWeekNummer().equals(datum) && m.getDag().equals("vrijdag")) {
                lJsonObjectBuilder
                        .add("vrbegintijdh", m.getBeginTijd().getHour())
                        .add("vrbegintijdm", m.getBeginTijd().getMinute())
                        .add("vreindtijdh", m.getEindTijd().getHour())
                        .add("vreindtijdm", m.getEindTijd().getMinute())
                        .add("vrpauzeh", m.getPauze().toString())
                        .add("vrpauzem", m.getPauze().getMinute());
                break;
            }
        }
        for (MRooster m : service.getMedewerkerRooster(medewerker)) {
            if (m.getWeekNummer().equals(datum) && m.getDag().equals("zaterdag")) {
                lJsonObjectBuilder
                        .add("zabegintijdh", m.getBeginTijd().getHour())
                        .add("zabegintijdm", m.getBeginTijd().getMinute())
                        .add("zaeindtijdh", m.getEindTijd().getHour())
                        .add("zaeindtijdm", m.getEindTijd().getMinute())
                        .add("zapauzeh", m.getPauze().toString())
                        .add("zapauzem", m.getPauze().getMinute());
                break;
            }
        }
        for (MRooster m : service.getMedewerkerRooster(medewerker)) {
            if (m.getWeekNummer().equals(datum) && m.getDag().equals("zondag")) {
                lJsonObjectBuilder
                        .add("zobegintijdh", m.getBeginTijd().getHour())
                        .add("zobegintijdm", m.getBeginTijd().getMinute())
                        .add("zoeindtijdh", m.getEindTijd().getHour())
                        .add("zoeindtijdm", m.getEindTijd().getMinute())
                        .add("zopauzeh", m.getPauze().toString())
                        .add("zopauzem", m.getPauze().getMinute());

                break;
            }
        }
        lJsonArrayBuilder.add(lJsonObjectBuilder);
        String lJsonOutStr = lJsonArrayBuilder.build().toString();
        return lJsonOutStr;
    }

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
                } else if (weeknummer < 10) {
                    datum = jaartal + "-W" + weeknummer;
                }
                MRooster m = new MRooster(medewerker, datum, dag.toLowerCase(), LocalTime.parse(begintijd), LocalTime.parse(eindtijd), LocalTime.parse("00:30"), false, medewerker.getVoornaam(), medewerker.getAchternaam());
                for (MRooster mr : service.getMedewerkerRooster(medewerker)) {
                    if (mr.getWeekNummer().equals(datum)
                            && mr.getDag().equals(dag)) {
                        service.updateMRooster(m);
                        match = false;
                        break;
                    } else {
                        match = true;
                    }
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
                lJsonObjectBuilder
                        .add("mavoornaam", m.getVoornaam())
                        .add("maachternaam", m.getAchternaam())
                        .add("mabegintijd", m.getBeginTijd().toString())
                        .add("maeindtijd", m.getEindTijd().toString())
                        .add("mapauze", m.getPauze().toString());
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
                lJsonObjectBuilder
                        .add("divoornaam", m.getVoornaam())
                        .add("diachternaam", m.getAchternaam())
                        .add("dibegintijd", m.getBeginTijd().toString())
                        .add("dieindtijd", m.getEindTijd().toString())
                        .add("dipauze", m.getPauze().toString());
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
                lJsonObjectBuilder
                        .add("wovoornaam", m.getVoornaam())
                        .add("woachternaam", m.getAchternaam())
                        .add("wobegintijd", m.getBeginTijd().toString())
                        .add("woeindtijd", m.getEindTijd().toString())
                        .add("wopauze", m.getPauze().toString());
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
                lJsonObjectBuilder
                        .add("dovoornaam", m.getVoornaam())
                        .add("doachternaam", m.getAchternaam())
                        .add("dobegintijd", m.getBeginTijd().toString())
                        .add("doeindtijd", m.getEindTijd().toString())
                        .add("dopauze", m.getPauze().toString());
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
                lJsonObjectBuilder
                        .add("vrvoornaam", m.getVoornaam())
                        .add("vrachternaam", m.getAchternaam())
                        .add("vrbegintijd", m.getBeginTijd().toString())
                        .add("vreindtijd", m.getEindTijd().toString())
                        .add("vrpauze", m.getPauze().toString());
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
                lJsonObjectBuilder
                        .add("zavoornaam", m.getVoornaam())
                        .add("zaachternaam", m.getAchternaam())
                        .add("zabegintijd", m.getBeginTijd().toString())
                        .add("zaeindtijd", m.getEindTijd().toString())
                        .add("zapauze", m.getPauze().toString());
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
                lJsonObjectBuilder
                        .add("zovoornaam", m.getVoornaam())
                        .add("zoachternaam", m.getAchternaam())
                        .add("zobegintijd", m.getBeginTijd().toString())
                        .add("zoeindtijd", m.getEindTijd().toString())
                        .add("zopauze", m.getPauze().toString());
                lJsonArrayBuilder.add(lJsonObjectBuilder);
            }
        }

        String lJsonOutStr = lJsonArrayBuilder.build().toString();
        return lJsonOutStr;
    }

}


