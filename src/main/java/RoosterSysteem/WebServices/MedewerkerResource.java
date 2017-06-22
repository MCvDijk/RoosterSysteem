package RoosterSysteem.WebServices;

import RoosterSysteem.Model.persoon.Medewerker;
import RoosterSysteem.Service.MedewerkerService;
import RoosterSysteem.Service.ServiceProvider;

import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObjectBuilder;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/medewerker")
public class MedewerkerResource {
    private MedewerkerService service = ServiceProvider.getMedewerkerService();

    @GET
    @Path("/medewerkers/ophalen")
    @Produces("application/json")
    public String ophalen() {
        JsonArrayBuilder arrayBuilder = Json.createArrayBuilder();

        for (Medewerker m : service.getAllMedewerkers()) {
            arrayBuilder.add(MedewerkerToJson(m));
        }
        System.out.println( arrayBuilder.build().toString());
        return arrayBuilder.build().toString();
    }


    private JsonObjectBuilder MedewerkerToJson(Medewerker m) {
        return Json.createObjectBuilder()
                .add("naam", m.getVolledigeNaam(m.getVoornaam(),m.getAchternaam()));
    }
}

