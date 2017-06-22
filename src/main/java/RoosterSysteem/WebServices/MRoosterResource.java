package RoosterSysteem.WebServices;

import RoosterSysteem.Model.mRooster.MRooster;
import RoosterSysteem.Model.persoon.Medewerker;
import RoosterSysteem.Service.MRoosterService;
import RoosterSysteem.Service.MedewerkerService;
import RoosterSysteem.Service.ServiceProvider;

import javax.json.*;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.io.ByteArrayInputStream;

/**
 * Created by slettebak on 22-Jun-17.
 */
@Path("/Rooster")
public class MRoosterResource {
    private MRoosterService service = ServiceProvider.getmRoosterService();
    private MedewerkerService mservice = ServiceProvider.getMedewerkerService();

    @GET
    @Path("/medewerkers/ophalen")
    @Produces("application/json")
    public String ophalen(String jsonBody) {
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
        for (MRooster m : service.getAllMRooster()) {
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
        for (MRooster m : service.getAllMRooster()) {
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
        for (MRooster m : service.getAllMRooster()) {
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
        for (MRooster m : service.getAllMRooster()) {
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
        for (MRooster m : service.getAllMRooster()) {
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
        for (MRooster m : service.getAllMRooster()) {
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
        for (MRooster m : service.getAllMRooster()) {
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
}
