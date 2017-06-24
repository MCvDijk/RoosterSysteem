package RoosterSysteem.WebServices;

import RoosterSysteem.Model.gebruiker.Gebruiker;
import RoosterSysteem.Persistence.DAO.GebruikerDAO;
import RoosterSysteem.Service.GebruikerService;
import RoosterSysteem.Service.ServiceProvider;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.crypto.MacProvider;


import javax.json.Json;
import javax.json.JsonObjectBuilder;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.security.Key;
import java.util.Calendar;

@Path("/authentication")
public class AuthenticationResource {
    final static public Key key = MacProvider.generateKey();
    private GebruikerService service = ServiceProvider.getGebruikerService();

    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces("application/json")
    public Response authenticateUser(@FormParam("username") String username,
                                   @FormParam("password") String password) {
        JsonObjectBuilder job = Json.createObjectBuilder();
// Get user from database
        try {

            Gebruiker g = service.getGebruiker(username.toLowerCase(), password);
// Check if user is active
            if (g.getRole() == null) { throw new IllegalArgumentException("No user found!"); }
// If match, issue token
            Calendar expiration = Calendar.getInstance();
            expiration.add(Calendar.MINUTE, 30);
            String token = Jwts.builder()
                    .setSubject(username)
                    .claim("role", g.getRole())
                    .setExpiration(expiration.getTime())
                    .signWith(SignatureAlgorithm.HS512, key)
                    .compact();

            return Response.ok(token).build();

        } catch (JwtException | IllegalArgumentException e) {
            return Response.status(Response.Status.UNAUTHORIZED).build();
        }
    }
}