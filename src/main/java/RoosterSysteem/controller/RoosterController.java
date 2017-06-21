package RoosterSysteem.controller;

import RoosterSysteem.Model.RS;
import RoosterSysteem.Model.mRooster.MRooster;


import javax.json.*;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.io.ByteArrayInputStream;
import java.util.ArrayList;


@Path("/rooster")
public class RoosterController {
    private RS informatieSysteem = RS.getInstance();

    @POST
    @Path("/rooster/ophalen")
    @Produces("application/json")
    public String ophalen(String jsonBody) {
        JsonObject lJsonObjectIn = (JsonObject) Json.createReader(new ByteArrayInputStream(jsonBody.getBytes())).read();
        String datum = lJsonObjectIn.getString("datum");

        ArrayList<MRooster> mRoosters = informatieSysteem.getmRoosters();
        JsonArrayBuilder lJsonArrayBuilder = Json.createArrayBuilder();
        JsonObjectBuilder lJsonObjectBuilder = Json.createObjectBuilder();
        for (MRooster m : mRoosters) {
            if (datum.equals(m.getWeekNummer()) && m.getDag().equals("maandag")) {
                lJsonObjectBuilder
                        .add("mavoornaam", m.getVoornaam())
                        .add("maachternaam", m.getAchternaam())
                        .add("mabegintijd", m.getBeginTijd().toString())
                        .add("maeindtijd", m.getEindTijd().toString())
                        .add("mapauze", m.getPauze().toString());
            }
        }
        for (MRooster m : mRoosters) {
            if (datum.equals(m.getWeekNummer()) && m.getDag().equals("dinsdag")) {
                lJsonObjectBuilder
                        .add("divoornaam", m.getVoornaam())
                        .add("diachternaam", m.getAchternaam())
                        .add("dibegintijd", m.getBeginTijd().toString())
                        .add("dieindtijd", m.getEindTijd().toString())
                        .add("dipauze", m.getPauze().toString());
            }

        }
        for (MRooster m : mRoosters) {
            if (datum.equals(m.getWeekNummer()) && m.getDag().equals("woensdag")) {
                lJsonObjectBuilder
                        .add("wovoornaam", m.getVoornaam())
                        .add("woachternaam", m.getAchternaam())
                        .add("wobegintijd", m.getBeginTijd().toString())
                        .add("woeindtijd", m.getEindTijd().toString())
                        .add("wopauze", m.getPauze().toString());
            }
        }
        for (MRooster m : mRoosters) {
            if (datum.equals(m.getWeekNummer()) && m.getDag().equals("donderdag")) {
                lJsonObjectBuilder
                        .add("dovoornaam", m.getVoornaam())
                        .add("doachternaam", m.getAchternaam())
                        .add("dobegintijd", m.getBeginTijd().toString())
                        .add("doeindtijd", m.getEindTijd().toString())
                        .add("dopauze", m.getPauze().toString());
            }
        }
        for (MRooster m : mRoosters) {
            if (datum.equals(m.getWeekNummer()) && m.getDag().equals("vrijdag")) {
                lJsonObjectBuilder
                        .add("vrvoornaam", m.getVoornaam())
                        .add("vrachternaam", m.getAchternaam())
                        .add("vrbegintijd", m.getBeginTijd().toString())
                        .add("vreindtijd", m.getEindTijd().toString())
                        .add("vrpauze", m.getPauze().toString());
            }
        }
        for (MRooster m : mRoosters) {
            if (datum.equals(m.getWeekNummer()) && m.getDag().equals("zaterdag")) {
                lJsonObjectBuilder
                        .add("zavoornaam", m.getVoornaam())
                        .add("zaachternaam", m.getAchternaam())
                        .add("zabegintijd", m.getBeginTijd().toString())
                        .add("zaeindtijd", m.getEindTijd().toString())
                        .add("zapauze", m.getPauze().toString());
            }
        }
        for (MRooster m : mRoosters) {
            if (datum.equals(m.getWeekNummer()) && m.getDag().equals("zondag")) {
                lJsonObjectBuilder
                        .add("zovoornaam", m.getVoornaam())
                        .add("zoachternaam", m.getAchternaam())
                        .add("zobegintijd", m.getBeginTijd().toString())
                        .add("zoeindtijd", m.getEindTijd().toString())
                        .add("zopauze", m.getPauze().toString());
            }
        }
        lJsonArrayBuilder.add(lJsonObjectBuilder);
        String lJsonOutStr = lJsonArrayBuilder.build().toString();
        System.out.println(lJsonOutStr);
        return lJsonOutStr;
    }

}

