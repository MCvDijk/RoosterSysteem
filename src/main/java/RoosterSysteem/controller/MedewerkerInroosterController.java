package RoosterSysteem.controller;

import RoosterSysteem.Model.persoon.Medewerker;


import javax.json.*;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.util.ArrayList;


@Path("/persoon")
public class MedewerkerInroosterController {

    @POST
    @Path("/medewerkers/ophalen")
    @Produces("application/json")
    public String ophalen() {
        ArrayList<Medewerker> medewerkers = informatieSysteem.getDeMedewerkers();
        JsonArrayBuilder JsonArrayBuilder = Json.createArrayBuilder();

        for (Medewerker medewerker : medewerkers) {
            String voornaam = medewerker.getVoornaam();
            String achternaam = medewerker.getAchternaam();

            JsonObjectBuilder jsonObjectBuilderMedewerker = Json.createObjectBuilder();
            String naam = voornaam+ " " + achternaam;
            jsonObjectBuilderMedewerker.add("naam", naam).add("voornaam", voornaam).add("achternaam", achternaam);

            JsonArrayBuilder.add(jsonObjectBuilderMedewerker);
        }

        String lJsonOutStr = JsonArrayBuilder.build().toString();
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
