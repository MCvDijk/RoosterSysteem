package RoosterSysteem.WebServices;

import RoosterSysteem.Model.persoon.Client;
import RoosterSysteem.Model.persoon.Medewerker;
import RoosterSysteem.Model.school.School;
import RoosterSysteem.Service.ClientService;
import RoosterSysteem.Service.MedewerkerService;
import RoosterSysteem.Service.SchoolService;
import RoosterSysteem.Service.ServiceProvider;

import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObjectBuilder;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/client")
public class ClientResource {

    private ClientService service = ServiceProvider.getClientService();
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
}