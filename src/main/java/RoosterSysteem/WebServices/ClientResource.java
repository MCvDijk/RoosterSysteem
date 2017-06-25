package RoosterSysteem.WebServices;

import RoosterSysteem.Model.cRooster.CRooster;
import RoosterSysteem.Model.persoon.Client;
import RoosterSysteem.Model.persoon.Medewerker;
import RoosterSysteem.Model.school.School;
import RoosterSysteem.Service.*;

import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.ByteArrayInputStream;

@Path("/client")
public class ClientResource {

    private ClientService service = ServiceProvider.getClientService();
    private CRoosterService cservice = ServiceProvider.getcRoosterService();
    private SchoolService Sservice = ServiceProvider.getSchoolService();

    @GET
    @Path("/clienten/ophalen")
    @Produces("application/json")
    public String ophalen() {
        JsonArrayBuilder arrayBuilder = Json.createArrayBuilder();

        for (Client c : service.getClienten()) {
            arrayBuilder.add(clientToJson(c));
        }
        return arrayBuilder.build().toString();
    }


    private JsonObjectBuilder clientToJson(Client c) {
        return Json.createObjectBuilder()
                .add("naam", c.getVolledigeNaam(c.getVoornaam(), c.getAchternaam()));
    }

    @POST
    @Path("/registreren")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Response clientRegistreren(@FormParam("voornaam") String voornaam,
                                      @FormParam("achternaam") String achternaam,
                                      @FormParam("adres") String adres,
                                      @FormParam("plaats") String plaats,
                                      @FormParam("medicijnen") String medicijnen,
                                      @FormParam("verzorger") String verzorger,
                                      @FormParam("telefoonnummer") long telefoonnummer,
                                      @FormParam("email") String email,
                                      @FormParam("scholen") String school) {
        try {
            Client c = new Client(voornaam,achternaam,adres, plaats, email, telefoonnummer, medicijnen, verzorger, Sservice.getSchool(school));
            service.writeClient(c);
            return Response.ok().build();
        } catch (Exception e) {
            return Response.status(500).build();
        }
    }
    @POST
    @Path("/stats/ophalen")
    @Produces("application/json")
    public String clientStatsOphalen(String jsonBody) {
        JsonObject lJsonObjectIn = (JsonObject) Json.createReader(new ByteArrayInputStream(jsonBody.getBytes())).read();
        JsonArrayBuilder lJsonArrayBuilder = Json.createArrayBuilder();
        JsonObjectBuilder lJsonObjectBuilder = Json.createObjectBuilder();
        String naam = lJsonObjectIn.getString("name");
        System.out.println(naam);
        String[] parts = naam.split(" ", 2);
        String voornaam = parts[0];
        String achternaam = parts[1];
        Client client = service.getClient(voornaam,achternaam);
        double aantalDagen = 0;
        double aanwezig = 0;
        double afwezig = 0;
        int totaalUren = 0;
        int urenaanwezig = 0;
        int urenafwezig = 0;

        for(CRooster c : cservice.getClientRooster(client)){
            if(c.isAfwezig() == false){
                aanwezig++;
                aantalDagen++;
                urenaanwezig = urenaanwezig + c.getUrenPerDag();
                totaalUren = totaalUren + c.getUrenPerDag();
            }

            else if (c.isAfwezig() == true){
                afwezig++;
                aantalDagen++;
                urenafwezig = urenafwezig + c.getUrenPerDag();
                totaalUren = totaalUren + c.getUrenPerDag();
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