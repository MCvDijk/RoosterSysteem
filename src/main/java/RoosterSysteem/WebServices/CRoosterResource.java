package RoosterSysteem.WebServices;

import RoosterSysteem.Model.cRooster.CRooster;
import RoosterSysteem.Model.persoon.Client;
import RoosterSysteem.Service.*;

import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.ByteArrayInputStream;
import java.sql.Time;
import java.time.LocalTime;

@Path("/rooster")
public class CRoosterResource {
    private CRoosterService service = ServiceProvider.getcRoosterService();
    private ClientService cservice = ServiceProvider.getClientService();

    @POST
    @Path("/client/opslaan")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Response clientroosterOpslaan(@FormParam("dag") String dag,
                                         @FormParam("aankomst") String aankomst,
                                         @FormParam("aankomsttijd") String aankomsttijd1,
                                         @FormParam("vertrek") String vertrek,
                                         @FormParam("vertrektijd") String vertrektijd1,
                                         @FormParam("slapen") String slaap,
                                         @FormParam("vast") String vast,
                                         @FormParam("client") String naam,
                                         @FormParam("date") String date) {
        String[] parts = naam.split(" ", 2);
        String voornaam = parts[0];
        String achternaam = parts[1];
        String partaankomst1 = aankomsttijd1.substring(0,2);
        String partaankomst2 = aankomsttijd1.substring(2);
        String aankomsttijd = partaankomst1 + ":" + partaankomst2;
        String parvertrektijd1 = vertrektijd1.substring(0,2);
        String partvertrektijd2 = vertrektijd1.substring(2);
        String vertrektijd = parvertrektijd1 + ":" + partvertrektijd2;
        System.out.println(vertrektijd);
        System.out.println(aankomsttijd);


        boolean slapen = false;
        if (slaap != null) {
            slapen = true;
        }

        Client client = cservice.getClient(voornaam, achternaam);
        CRooster c = new CRooster(client, date, dag.toLowerCase(), aankomst, LocalTime.parse(aankomsttijd), vertrek, LocalTime.parse(vertrektijd), slapen, false, client.getVoornaam(), client.getAchternaam());
        service.writeCRooster(c);
        return Response.ok().build();
    }
    @POST
    @Path("/maandag/clienten/ophalen")
    @Produces("application/json")
    public String roosterMaandagOphalen(String jsonBody){
        JsonObject lJsonObjectIn = (JsonObject) Json.createReader(new ByteArrayInputStream(jsonBody.getBytes())).read();
        String datum = lJsonObjectIn.getString("date");

        JsonArrayBuilder lJsonArrayBuilder = Json.createArrayBuilder();

        for (CRooster c : service.getAllCRooster()) {
            if (datum.equals(c.getWeekNummer()) && c.getDag().equals("maandag")) {
                JsonObjectBuilder lJsonObjectBuilder = Json.createObjectBuilder();
                Client client = cservice.getClient(c.getVoornaam(),c.getAchternaam());
                lJsonObjectBuilder
                        .add("naam", client.getVolledigeNaam(c.getVoornaam(),c.getAchternaam()))
                        .add("aankomst", c.getAankomst())
                        .add("aankomsttijd", c.getAankomstTijd().toString())
                        .add("vertrek", c.getVertrek())
                        .add("vertrektijd", c.getVertrekTijd().toString())
                        .add("slapen", c.isSlapen())
                        .add("medicatie", client.getMedicijn());
                lJsonArrayBuilder.add(lJsonObjectBuilder);
            }
        }

        String lJsonOutStr = lJsonArrayBuilder.build().toString();
        System.out.println(lJsonOutStr);
        return lJsonOutStr;
    }
    @POST
    @Path("/dinsdag/clienten/ophalen")
    @Produces("application/json")
    public String roosterDinsdagophalen(String jsonBody){
        JsonObject lJsonObjectIn = (JsonObject) Json.createReader(new ByteArrayInputStream(jsonBody.getBytes())).read();
        String datum = lJsonObjectIn.getString("date");

        JsonArrayBuilder lJsonArrayBuilder = Json.createArrayBuilder();

        for (CRooster c : service.getAllCRooster()) {
            if (datum.equals(c.getWeekNummer()) && c.getDag().equals("dinsdag")) {
                JsonObjectBuilder lJsonObjectBuilder = Json.createObjectBuilder();
                Client client = cservice.getClient(c.getVoornaam(),c.getAchternaam());
                lJsonObjectBuilder
                        .add("naam", client.getVolledigeNaam(c.getVoornaam(),c.getAchternaam()))
                        .add("aankomst", c.getAankomst())
                        .add("aankomsttijd", c.getAankomstTijd().toString())
                        .add("vertrek", c.getVertrek())
                        .add("vertrektijd", c.getVertrekTijd().toString())
                        .add("slapen", c.isSlapen())
                        .add("medicatie", client.getMedicijn());
                lJsonArrayBuilder.add(lJsonObjectBuilder);
            }
        }

        String lJsonOutStr = lJsonArrayBuilder.build().toString();
        return lJsonOutStr;
    }
    @POST
    @Path("/woensdag/clienten/ophalen")
    @Produces("application/json")
    public String roosterWoensdagOphalen(String jsonBody){
        JsonObject lJsonObjectIn = (JsonObject) Json.createReader(new ByteArrayInputStream(jsonBody.getBytes())).read();
        String datum = lJsonObjectIn.getString("date");

        JsonArrayBuilder lJsonArrayBuilder = Json.createArrayBuilder();

        for (CRooster c : service.getAllCRooster()) {
            if (datum.equals(c.getWeekNummer()) && c.getDag().equals("woensdag")) {
                JsonObjectBuilder lJsonObjectBuilder = Json.createObjectBuilder();
                Client client = cservice.getClient(c.getVoornaam(),c.getAchternaam());
                lJsonObjectBuilder
                        .add("naam", client.getVolledigeNaam(c.getVoornaam(),c.getAchternaam()))
                        .add("aankomst", c.getAankomst())
                        .add("aankomsttijd", c.getAankomstTijd().toString())
                        .add("vertrek", c.getVertrek())
                        .add("vertrektijd", c.getVertrekTijd().toString())
                        .add("slapen", c.isSlapen())
                        .add("medicatie", client.getMedicijn());
                lJsonArrayBuilder.add(lJsonObjectBuilder);
            }
        }

        String lJsonOutStr = lJsonArrayBuilder.build().toString();
        return lJsonOutStr;
    }
    @POST
    @Path("/donderdag/clienten/ophalen")
    @Produces("application/json")
    public String roosterDonderdagOphalen(String jsonBody){
        JsonObject lJsonObjectIn = (JsonObject) Json.createReader(new ByteArrayInputStream(jsonBody.getBytes())).read();
        String datum = lJsonObjectIn.getString("date");

        JsonArrayBuilder lJsonArrayBuilder = Json.createArrayBuilder();

        for (CRooster c : service.getAllCRooster()) {
            if (datum.equals(c.getWeekNummer()) && c.getDag().equals("donderdag")) {
                JsonObjectBuilder lJsonObjectBuilder = Json.createObjectBuilder();
                Client client = cservice.getClient(c.getVoornaam(),c.getAchternaam());
                lJsonObjectBuilder
                        .add("naam", client.getVolledigeNaam(c.getVoornaam(),c.getAchternaam()))
                        .add("aankomst", c.getAankomst())
                        .add("aankomsttijd", c.getAankomstTijd().toString())
                        .add("vertrek", c.getVertrek())
                        .add("vertrektijd", c.getVertrekTijd().toString())
                        .add("slapen", c.isSlapen())
                        .add("medicatie", client.getMedicijn());
                lJsonArrayBuilder.add(lJsonObjectBuilder);
            }
        }

        String lJsonOutStr = lJsonArrayBuilder.build().toString();
        return lJsonOutStr;
    }
    @POST
    @Path("/vrijdag/clienten/ophalen")
    @Produces("application/json")
    public String roosterVrijdagOphalen(String jsonBody){
        JsonObject lJsonObjectIn = (JsonObject) Json.createReader(new ByteArrayInputStream(jsonBody.getBytes())).read();
        String datum = lJsonObjectIn.getString("date");

        JsonArrayBuilder lJsonArrayBuilder = Json.createArrayBuilder();

        for (CRooster c : service.getAllCRooster()) {
            if (datum.equals(c.getWeekNummer()) && c.getDag().equals("vrijdag")) {
                JsonObjectBuilder lJsonObjectBuilder = Json.createObjectBuilder();
                Client client = cservice.getClient(c.getVoornaam(),c.getAchternaam());
                lJsonObjectBuilder
                        .add("naam", client.getVolledigeNaam(c.getVoornaam(),c.getAchternaam()))
                        .add("aankomst", c.getAankomst())
                        .add("aankomsttijd", c.getAankomstTijd().toString())
                        .add("vertrek", c.getVertrek())
                        .add("vertrektijd", c.getVertrekTijd().toString())
                        .add("slapen", c.isSlapen())
                        .add("medicatie", client.getMedicijn());
                lJsonArrayBuilder.add(lJsonObjectBuilder);
            }
        }

        String lJsonOutStr = lJsonArrayBuilder.build().toString();
        return lJsonOutStr;
    }
    @POST
    @Path("/zaterdag/clienten/ophalen")
    @Produces("application/json")
    public String roosterZaterdagOphalen(String jsonBody){
        JsonObject lJsonObjectIn = (JsonObject) Json.createReader(new ByteArrayInputStream(jsonBody.getBytes())).read();
        String datum = lJsonObjectIn.getString("date");

        JsonArrayBuilder lJsonArrayBuilder = Json.createArrayBuilder();

        for (CRooster c : service.getAllCRooster()) {
            if (datum.equals(c.getWeekNummer()) && c.getDag().equals("zaterdag")) {
                JsonObjectBuilder lJsonObjectBuilder = Json.createObjectBuilder();
                Client client = cservice.getClient(c.getVoornaam(),c.getAchternaam());
                lJsonObjectBuilder
                        .add("naam", client.getVolledigeNaam(c.getVoornaam(),c.getAchternaam()))
                        .add("aankomst", c.getAankomst())
                        .add("aankomsttijd", c.getAankomstTijd().toString())
                        .add("vertrek", c.getVertrek())
                        .add("vertrektijd", c.getVertrekTijd().toString())
                        .add("slapen", c.isSlapen())
                        .add("medicatie", client.getMedicijn());
                lJsonArrayBuilder.add(lJsonObjectBuilder);
            }
        }

        String lJsonOutStr = lJsonArrayBuilder.build().toString();
        return lJsonOutStr;
    }
    @POST
    @Path("/zondag/clienten/ophalen")
    @Produces("application/json")
    public String roosterZondagOphalen(String jsonBody){
        JsonObject lJsonObjectIn = (JsonObject) Json.createReader(new ByteArrayInputStream(jsonBody.getBytes())).read();
        String datum = lJsonObjectIn.getString("date");

        JsonArrayBuilder lJsonArrayBuilder = Json.createArrayBuilder();

        for (CRooster c : service.getAllCRooster()) {
            if (datum.equals(c.getWeekNummer()) && c.getDag().equals("zondag")) {
                JsonObjectBuilder lJsonObjectBuilder = Json.createObjectBuilder();
                Client client = cservice.getClient(c.getVoornaam(),c.getAchternaam());
                lJsonObjectBuilder
                        .add("naam", client.getVolledigeNaam(c.getVoornaam(),c.getAchternaam()))
                        .add("aankomst", c.getAankomst())
                        .add("aankomsttijd", c.getAankomstTijd().toString())
                        .add("vertrek", c.getVertrek())
                        .add("vertrektijd", c.getVertrekTijd().toString())
                        .add("slapen", c.isSlapen())
                        .add("medicatie", client.getMedicijn());
                lJsonArrayBuilder.add(lJsonObjectBuilder);
            }
        }

        String lJsonOutStr = lJsonArrayBuilder.build().toString();
        return lJsonOutStr;
    }
}