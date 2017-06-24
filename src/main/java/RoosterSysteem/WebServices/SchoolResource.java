package RoosterSysteem.WebServices;

import RoosterSysteem.Model.school.School;
import RoosterSysteem.Service.SchoolService;
import RoosterSysteem.Service.ServiceProvider;

import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObjectBuilder;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/school")
public class SchoolResource {
    private SchoolService service = ServiceProvider.getSchoolService();

    @GET
    @Path("/scholen/ophalen")
    @Produces("application/json")
    public String scholenOphalen(){
        JsonArrayBuilder arrayBuilder = Json.createArrayBuilder();

        for (School s : service.getAllScholen()) {
            arrayBuilder.add(schoolToJson(s));
        }
        String result = arrayBuilder.build().toString();
        System.out.println(result);
        return result ;
    }
    private JsonObjectBuilder schoolToJson(School s) {
        return Json.createObjectBuilder()
                .add("naam", s.getNaam());
    }

    @POST
    @Path("/registreren")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Response schoolRegistreren(@FormParam("naam") String naam,
                                      @FormParam("adres") String adres,
                                      @FormParam("plaats") String plaats,
                                      @FormParam("telefoonnummer") int telefoonnummer){
        try {
            School s = new School(naam,adres,plaats,telefoonnummer);
            service.writeSchool(s);
            return Response.ok().build();

        } catch (Exception e) {
            return Response.status(500).build();
        }
    }
}

