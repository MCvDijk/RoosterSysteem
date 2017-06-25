package RoosterSysteem.WebServices;

import RoosterSysteem.Model.mRooster.MRooster;
import RoosterSysteem.Model.persoon.Medewerker;
import RoosterSysteem.Service.MRoosterService;
import RoosterSysteem.Service.MedewerkerService;
import RoosterSysteem.Service.ServiceProvider;

import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.ByteArrayInputStream;

@Path("/medewerker")
public class MedewerkerResource {
    private MedewerkerService service = ServiceProvider.getMedewerkerService();
    private MRoosterService mservice = ServiceProvider.getmRoosterService();

    @POST
    @Path("/registreren")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Response schoolRegistreren(@FormParam("voornaam") String voornaam,
                                      @FormParam("achternaam") String achternaam,
                                      @FormParam("adres") String adres,
                                      @FormParam("plaats") String plaats,
                                      @FormParam("telefoonnummer") long telefoonnummer,
                                      @FormParam("email") String email){
        try {

            Medewerker m = new Medewerker(voornaam,achternaam,adres,plaats,email,telefoonnummer);
            service.writeMedewerker(m);
            return Response.ok().build();

        } catch (Exception e) {
            return Response.status(500).build();
        }
    }

    @GET
    @Path("/medewerkers/ophalen")
    @Produces("application/json")
    public String ophalen() {
        JsonArrayBuilder arrayBuilder = Json.createArrayBuilder();

        for (Medewerker m : service.getAllMedewerkers()) {
            arrayBuilder.add(MedewerkerToJson(m));
        }
        return arrayBuilder.build().toString();
    }


    private JsonObjectBuilder MedewerkerToJson(Medewerker m) {
        return Json.createObjectBuilder()
                .add("naam", m.getVolledigeNaam(m.getVoornaam(),m.getAchternaam()));
    }

    @POST
    @Path("/stats/ophalen")
    @Produces("application/json")
    public String medewerkerStatsOphalen(String jsonBody) {
        JsonObject lJsonObjectIn = (JsonObject) Json.createReader(new ByteArrayInputStream(jsonBody.getBytes())).read();
        JsonArrayBuilder lJsonArrayBuilder = Json.createArrayBuilder();
        JsonObjectBuilder lJsonObjectBuilder = Json.createObjectBuilder();
        String naam = lJsonObjectIn.getString("name");
        System.out.println(naam);
        String[] parts = naam.split(" ", 2);
        String voornaam = parts[0];
        String achternaam = parts[1];
        Medewerker medewerker = service.getMedewerker(voornaam,achternaam);
        double aantalDagen = 0;
        double aanwezig = 0;
        double afwezig = 0;
        int totaalUren = 0;
        int urenaanwezig = 0;
        int urenafwezig = 0;

        for(MRooster m : mservice.getMedewerkerRooster(medewerker)){
            if(m.isZiek() == false){
                aanwezig++;
                aantalDagen++;
                urenaanwezig = urenaanwezig + m.getGewerktPerDag();
                totaalUren = totaalUren + m.getGewerktPerDag();
            }

            else if (m.isZiek() == true){
                afwezig++;
                aantalDagen++;
                urenafwezig = urenafwezig + m.getGewerktPerDag();
                totaalUren = totaalUren + m.getGewerktPerDag();
            }
        }
        System.out.println(totaalUren);
        System.out.println(urenaanwezig);
        System.out.println(urenafwezig);
        int aanwezigheid = (int)((aanwezig/aantalDagen)*100);
        int afwezigheid = (int)((afwezig/aantalDagen)*100);
        int aantalurenaanwezig = urenaanwezig/100;
        int aantalurenafwezig = urenafwezig/100;
        int aantaltotaaluren = totaalUren/100;
        int urenaanwezigheid = (int)(((double)urenaanwezig/totaalUren)*100);
        int urenafwezigheid = (int)(((double)urenafwezig/totaalUren)*100);
        lJsonObjectBuilder
                .add("totaaldagen", aantalDagen)
                .add("dagenaanwezigheid", aanwezigheid)
                .add("dagenaanweizg", aanwezig)
                .add("totaaldagenafwezig", afwezig )
                .add("dagenafwezig", afwezigheid)
                .add("totaaluren", aantaltotaaluren)
                .add("urenaanwezigheid", urenaanwezigheid)
                .add("urenaanwezig",aantalurenaanwezig)
                .add("totaalurenafwezig",urenafwezigheid)
                .add("urenafwezig", aantalurenafwezig);

        lJsonArrayBuilder.add(lJsonObjectBuilder);
        String lJsonOutStr = lJsonArrayBuilder.build().toString();
        System.out.println(lJsonOutStr);
        return lJsonOutStr;

    }
}
