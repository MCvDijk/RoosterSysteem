package RoosterSysteem.model.persoon;

/**
 * Created by slettebak on 19-Jun-17.
 */
public class Medewerker extends Persoon {
    public Medewerker() {
    }

    public Medewerker(String voornaam, String achternaam, String adres, String plaats, String wachtwoord, String gebruikersnaam, String email, int telefoonNummer) {
        super(voornaam, achternaam, adres, plaats, wachtwoord, gebruikersnaam, email, telefoonNummer);
    }
}
