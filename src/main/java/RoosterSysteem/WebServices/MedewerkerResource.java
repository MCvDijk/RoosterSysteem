package RoosterSysteem.WebServices;

import RoosterSysteem.Model.persoon.Medewerker;
import RoosterSysteem.Service.MedewerkerService;
import RoosterSysteem.Service.ServiceProvider;

import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObjectBuilder;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/medewerker")
public class MedewerkerResource {
    private MedewerkerService service = ServiceProvider.getMedewerkerService();

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
}

