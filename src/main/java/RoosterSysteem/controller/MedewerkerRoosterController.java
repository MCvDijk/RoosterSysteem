package RoosterSysteem.controller;

import RoosterSysteem.model.RS;
import RoosterSysteem.model.mRooster.MRooster;
import RoosterSysteem.model.persoon.Medewerker;
import RoosterSysteem.sql.CRoosterDAO;
import RoosterSysteem.sql.MRoosterDAO;
import RoosterSysteem.sql.MedewerkerDAO;


import javax.json.*;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.awt.*;
import java.io.ByteArrayInputStream;
import java.time.LocalTime;
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
            if (volnaam.equals(naam)) {
                voornaam = data_jsonobject.getString("voornaam");
                achternaam = data_jsonobject.getString("achternaam");
                break;
            }

        }
        Medewerker medewerker = informatieSysteem.getMedewerker(voornaam, achternaam);
        ArrayList<MRooster> mRoosters = informatieSysteem.getmRoosters();
        JsonArrayBuilder lJsonArrayBuilder = Json.createArrayBuilder();
        JsonObjectBuilder lJsonObjectBuilder = Json.createObjectBuilder();
        lJsonObjectBuilder.add("naam", naam);
        for (MRooster m : mRoosters) {
            if (m.getMedewerker().equals(medewerker) && m.getWeekNummer().equals(datum) && m.getDag().equals("maandag")) {
                lJsonObjectBuilder
                        .add("mabegintijdh", m.getBeginTijd().getHour())
                        .add("mabegintijdm", m.getBeginTijd().getMinute())
                        .add("maeindtijdh", m.getEindTijd().getHour())
                        .add("maeindtijdm", m.getEindTijd().getMinute())
                        .add("mapauzeh", m.getPauze().getHour())
                        .add("mapauzem", m.getPauze().getMinute());
                if (m.isVast() == true) {
                    lJsonObjectBuilder.add("mavast", "Checked");
                } else {
                    lJsonObjectBuilder.add("mavast", "Checked");
                }
                break;
            }
        }
        for (MRooster m : mRoosters) {
            if (m.getMedewerker().equals(medewerker) && m.getWeekNummer().equals(datum) && m.getDag().equals("dinsdag")) {
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
        for (MRooster m : mRoosters) {
            if (m.getMedewerker().equals(medewerker) && m.getWeekNummer().equals(datum) && m.getDag().equals("woensdag")) {
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
        for (MRooster m : mRoosters) {
            if (m.getMedewerker().equals(medewerker) && m.getWeekNummer().equals(datum) && m.getDag().equals("donderdag")) {
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
        for (MRooster m : mRoosters) {
            if (m.getMedewerker().equals(medewerker) && m.getWeekNummer().equals(datum) && m.getDag().equals("vrijdag")) {
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
        for (MRooster m : mRoosters) {
            if (m.getMedewerker().equals(medewerker) && m.getWeekNummer().equals(datum) && m.getDag().equals("zaterdag")) {
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
        for (MRooster m : mRoosters) {
            if (m.getMedewerker().equals(medewerker) && m.getWeekNummer().equals(datum) && m.getDag().equals("zondag")) {
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
        System.out.println(lJsonOutStr);
        return lJsonOutStr;
    }


    @POST
    @Path("/medewerkers/opslaan")
    @Produces("application/json")
    public String opslaan(String jsonBody) {
        MRoosterDAO medewerkerRoosterDAO = new MRoosterDAO();
        JsonObject lJsonObjectIn = (JsonObject) Json.createReader(new ByteArrayInputStream(jsonBody.getBytes())).read();
        String naam = lJsonObjectIn.getString("naam");
        JsonArray data = lJsonObjectIn.getJsonArray("rooster");
        String[] parts = naam.split(" ", 2);
        String voornaam = parts[0];
        String achternaam = parts[1];
        Medewerker medewerker = informatieSysteem.getMedewerker(voornaam, achternaam);
        ArrayList<MRooster> rooster = informatieSysteem.getMRoosterMedewerker(medewerker);


        for (int i = 0; i < data.size(); i++) {
            JsonObject data_jsonobject = data.getJsonObject(i);
            System.out.println("miss hier");
            System.out.println(data_jsonobject);
            if (data_jsonobject.containsKey("begintijd")
                    && data_jsonobject.containsKey("eindtijd")) {
                String dag = data_jsonobject.getString("dag");
                String weeknummer = data_jsonobject.getString("weeknr");
                String begintijd = data_jsonobject.getString("begintijd");
                String pauze = "00:30";
                String eindtijd = data_jsonobject.getString("eindtijd");

                if (!begintijd.equals("") || !eindtijd.equals("")) {
                    System.out.println("ja kom op");
                    if (rooster.size() == 0) {
                        MRooster mRooster = new MRooster(
                                medewerker, weeknummer, dag, LocalTime.parse(begintijd.replaceAll("\\s", "") + ":00"), LocalTime.parse(eindtijd.replaceAll("\\s", "") + ":00"), LocalTime.parse(pauze + ":00"), false, medewerker.getVoornaam(), medewerker.getAchternaam(), false);
                        medewerkerRoosterDAO.writeMedewerkerRooster(mRooster);
                    } else {
                        for (MRooster mr : rooster) {
                            if (!mr.getWeekNummer().equals(weeknummer)
                                    && !mr.getDag().equals(dag)) {
                                System.out.println("ik ben hier");

                                MRooster mRooster = new MRooster(
                                        medewerker, weeknummer, dag, LocalTime.parse(begintijd.replaceAll("\\s", "") + ":00"), LocalTime.parse(eindtijd.replaceAll("\\s", "") + ":00"), LocalTime.parse(pauze + ":00"), false, medewerker.getVoornaam(), medewerker.getAchternaam(), false);
                                medewerkerRoosterDAO.writeMedewerkerRooster(mRooster);

                            }
                        }

                    }

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



