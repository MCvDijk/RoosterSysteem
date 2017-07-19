package RoosterSysteem.WebServices;

import RoosterSysteem.Model.gebruiker.Gebruiker;
import RoosterSysteem.Service.GebruikerService;
import RoosterSysteem.Service.ServiceProvider;
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
    public String authenticateUser(@FormParam("username") String username,
                                   @FormParam("password") String password) {
        JsonObjectBuilder job = Json.createObjectBuilder();
// Get user from database
        try {

            Gebruiker g = service.getGebruiker(username.toLowerCase(), password);
// Check if user is active
            if (g.getRole() == null) { throw new IllegalArgumentException("No user found!"); }
// If match, issue token
            if (password.equals(g.getWachtwoord())) {
                Calendar expiration = Calendar.getInstance();
                expiration.add(Calendar.MINUTE, 30);
                String token = Jwts.builder()
                        .setSubject(username)
                        .claim("role", g.getRole())
                        .setExpiration(expiration.getTime())
                        .signWith(SignatureAlgorithm.HS512, key)
                        .compact();
                job.add("token",token);
                job.add("role", g.getRole());
            }
            return job.build().toString();

        } catch (JwtException | IllegalArgumentException e) {
            job.add("message","Gebruikersnaam of wachtwoord incorrect");
            return job.build().toString();
        }
    }
}