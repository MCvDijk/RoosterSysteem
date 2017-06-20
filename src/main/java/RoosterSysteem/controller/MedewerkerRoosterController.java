package RoosterSysteem.controller;

import RoosterSysteem.model.RS;
import RoosterSysteem.model.mRooster.MRooster;
import RoosterSysteem.model.persoon.Medewerker;


import javax.json.*;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.io.ByteArrayInputStream;
import java.util.ArrayList;


@Path("/rooster")
public class MedewerkerRoosterController {
    private RS informatieSysteem = RS.getInstance();

    @POST
    @Path("/medewerkers/ophalen")
    @Produces("application/json")
    public String ophalen(String jsonBody) {
        JsonObject lJsonObjectIn = (JsonObject) Json.createReader(new ByteArrayInputStream(jsonBody.getBytes())).read();
        String naam = lJsonObjectIn.getString("naam");
        String datum = lJsonObjectIn.getString("datum");
        JsonArray data = lJsonObjectIn.getJsonArray("data");
        String voornaam = "";
        String achternaam = "";

        for (int i = 0; i < data.size(); i++) {
            JsonObject data_jsonobject = data.getJsonObject(i);
            String volnaam = data_jsonobject.getString("naam");
            if (volnaam.equals(naam)){
                voornaam = data_jsonobject.getString("voornaam");
                achternaam = data_jsonobject.getString("achternaam");
                break;
            }

        }
        Medewerker medewerker = informatieSysteem.getMedewerker(voornaam,achternaam);
        System.out.println(medewerker.getVoornaam());
        ArrayList<MRooster> mRoosters = informatieSysteem.getmRoosters();
        JsonArrayBuilder lJsonArrayBuilder = Json.createArrayBuilder();
        for(MRooster m : mRoosters){
            if (m.getMedewerker().equals(medewerker) && m.getWeekNummer().equals(datum) && m.getDag().equals("maandag")){
                JsonObjectBuilder lJsonObjectBuilder = Json.createObjectBuilder();
                lJsonObjectBuilder
                        .add("mabegintijdh", m.getBeginTijd().getHour())
                        .add("mabegintijdm",m.getBeginTijd().getMinute())
                        .add("maeindtijdh", m.getEindTijd().getHour())
                        .add("maeindtijdm",m.getEindTijd().getMinute())
                        .add("mavast", m.isVast())
                        .add("mapauzeh", m.getPauze().getHour())
                        .add("mapauzem",m.getPauze().getMinute());
                lJsonArrayBuilder.add(lJsonObjectBuilder);
                break;
            }
        }
        for(MRooster m : mRoosters){
            if (m.getMedewerker().equals(medewerker) && m.getWeekNummer().equals(datum) && m.getDag().equals("dinsdag")){
                JsonObjectBuilder lJsonObjectBuilder = Json.createObjectBuilder();
                lJsonObjectBuilder
                        .add("dibegintijdh", m.getBeginTijd().getHour())
                        .add("dibegintijdm",m.getBeginTijd().getMinute())
                        .add("dieindtijdh", m.getEindTijd().getHour())
                        .add("dieindtijdm",m.getEindTijd().getMinute())
                        .add("divast", m.isVast())
                        .add("dipauzeh", m.getPauze().toString())
                        .add("dipauzem",m.getPauze().getMinute());
                lJsonArrayBuilder.add(lJsonObjectBuilder);
                break;
            }

        }
        for(MRooster m : mRoosters){
            if (m.getMedewerker().equals(medewerker) && m.getWeekNummer().equals(datum) && m.getDag().equals("woensdag")){
                JsonObjectBuilder lJsonObjectBuilder = Json.createObjectBuilder();
                lJsonObjectBuilder
                        .add("wobegintijdh", m.getBeginTijd().getHour())
                        .add("wobegintijdm",m.getBeginTijd().getMinute())
                        .add("woeindtijdh", m.getEindTijd().getHour())
                        .add("woeindtijdm",m.getEindTijd().getMinute())
                        .add("wovast", m.isVast())
                        .add("wopauzeh", m.getPauze().toString())
                        .add("wopauzem",m.getPauze().getMinute());
                lJsonArrayBuilder.add(lJsonObjectBuilder);
                break;
            }
        }
        for(MRooster m : mRoosters){
            if (m.getMedewerker().equals(medewerker) && m.getWeekNummer().equals(datum) && m.getDag().equals("donderdag")){
                JsonObjectBuilder lJsonObjectBuilder = Json.createObjectBuilder();
                lJsonObjectBuilder
                        .add("dobegintijdh", m.getBeginTijd().getHour())
                        .add("dobegintijdm",m.getBeginTijd().getMinute())
                        .add("doeindtijdh", m.getEindTijd().getHour())
                        .add("doeindtijdm",m.getEindTijd().getMinute())
                        .add("dovast", m.isVast())
                        .add("dopauzeh", m.getPauze().toString())
                        .add("dopauzem",m.getPauze().getMinute());
                lJsonArrayBuilder.add(lJsonObjectBuilder);
                break;
            }
        }
        for(MRooster m : mRoosters){
            if (m.getMedewerker().equals(medewerker) && m.getWeekNummer().equals(datum) && m.getDag().equals("vrijdag")){
                JsonObjectBuilder lJsonObjectBuilder = Json.createObjectBuilder();
                lJsonObjectBuilder
                        .add("vrbegintijdh", m.getBeginTijd().getHour())
                        .add("vrbegintijdm",m.getBeginTijd().getMinute())
                        .add("vreindtijdh", m.getEindTijd().getHour())
                        .add("vreindtijdm",m.getEindTijd().getMinute())
                        .add("vrvast", m.isVast())
                        .add("vrpauzeh", m.getPauze().toString())
                        .add("vrpauzem",m.getPauze().getMinute());
                lJsonArrayBuilder.add(lJsonObjectBuilder);
                break;
            }
        }
        for(MRooster m : mRoosters){
            if (m.getMedewerker().equals(medewerker) && m.getWeekNummer().equals(datum) && m.getDag().equals("zaterdag")){
                JsonObjectBuilder lJsonObjectBuilder = Json.createObjectBuilder();
                lJsonObjectBuilder
                        .add("zabegintijdh", m.getBeginTijd().getHour())
                        .add("zabegintijdm",m.getBeginTijd().getMinute())
                        .add("zaeindtijdh", m.getEindTijd().getHour())
                        .add("zaeindtijdm",m.getEindTijd().getMinute())
                        .add("zavast", m.isVast())
                        .add("zapauzeh", m.getPauze().toString())
                        .add("zapauzem",m.getPauze().getMinute());
                lJsonArrayBuilder.add(lJsonObjectBuilder);
                break;
            }
        }
        for(MRooster m : mRoosters){
            if (m.getMedewerker().equals(medewerker) && m.getWeekNummer().equals(datum) && m.getDag().equals("zondag")){
                JsonObjectBuilder lJsonObjectBuilder = Json.createObjectBuilder();
                lJsonObjectBuilder
                        .add("zobegintijdh", m.getBeginTijd().getHour())
                        .add("zobegintijdm",m.getBeginTijd().getMinute())
                        .add("zoeindtijdh", m.getEindTijd().getHour())
                        .add("zoeindtijdm",m.getEindTijd().getMinute())
                        .add("zovast", m.isVast())
                        .add("zopauzeh", m.getPauze().toString())
                        .add("zopauzem",m.getPauze().getMinute());
                lJsonArrayBuilder.add(lJsonObjectBuilder);
                break;
            }
        }


        String lJsonOutStr = lJsonArrayBuilder.build().toString();
        System.out.println(lJsonOutStr);
        return lJsonOutStr;
    }
}

  /*  @POST
    @Path("/medestudenten/opslaan")
    @Produces("application/json")
    public String opslaan(String jsonBody) {
        JsonObject lJsonObjectIn = (JsonObject) Json.createReader(new ByteArrayInputStream(jsonBody.getBytes())).read();
        String lGebruikersnaam = lJsonObjectIn.getString("username");
        Student lStudent = informatieSysteem.getStudent(lGebruikersnaam);
        StudentDAO studentDAO = new StudentDAO();

        // Het lJsonObjectIn bevat niet enkel strings maar ook een heel (Json) array van Json-objecten.
        // in dat Json-object zijn telkens het studentnummer en een indicatie of
        // de student tot het zelfde team hoort opgenomen.

        // Het Json-array heeft als naam: "groupMembers"
        JsonArray lGroepMembers_jArray = lJsonObjectIn.getJsonArray("groupMembers");
        if (lGroepMembers_jArray != null) {
            // bepaal op basis van de huidige tijd een unieke string
            Calendar lCal = Calendar.getInstance();
            long lMilliSeconds = lCal.getTimeInMillis();
            String lGroepId = String.valueOf(lMilliSeconds);

            lStudent.setGroepId(lGroepId);
            for (int i = 0; i < lGroepMembers_jArray.size(); i++) {
                JsonObject lGroepMember_jsonObj = lGroepMembers_jArray.getJsonObject(i);
                int lStudentNummer = lGroepMember_jsonObj.getInt("id");
                boolean lZelfdeGroep = lGroepMember_jsonObj.getBoolean("sameGroup");
                if (lZelfdeGroep) {
                    Student lGroepStudent = informatieSysteem.getStudent(lStudentNummer);
                    lGroepStudent.setGroepId(lGroepId);
                    studentDAO.updateStudent(lGroepStudent);
                }
            }
        }

        JsonObjectBuilder lJob = Json.createObjectBuilder();
        lJob.add("errorcode", 0);
        // nothing to return use only errorcode to signal: ready!
        String lJsonOutStr = lJob.build().toString();
        return lJsonOutStr; // terug naar de Polymer-GUI!
    }
}
*/
