package RoosterSysteem.model.persoon;

public abstract class Persoon {

    private String voornaam;
    private String achternaam;
    private String adres;
    private String plaats;
    private String email;
    private int telefoonNummer;

    public Persoon() {
    }

    public Persoon(String voornaam, String achternaam, String adres, String plaats, String wachtwoord, String gebruikersnaam, String email, int telefoonNummer) {
        this.voornaam = voornaam;
        this.achternaam = achternaam;
        this.adres = adres;
        this.plaats = plaats;
        this.email = email;
        this.telefoonNummer = telefoonNummer;
    }

    public String getVoornaam() {
        return this.voornaam;
    }

    protected String getAchternaam() {
        return this.achternaam;
    }

    public String getAdres() {
        return adres;
    }

    public String getPlaats() {
        return plaats;
    }

    public String getEmail() {
        return email;
    }

    public int getTelefoonNummer() {
        return telefoonNummer;
    }

    public void setVoornaam(String voornaam) {
        this.voornaam = voornaam;
    }

    public void setAchternaam(String achternaam) {
        this.achternaam = achternaam;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

    public void setPlaats(String plaats) {
        this.plaats = plaats;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTelefoonNummer(int telefoonNummer) {
        this.telefoonNummer = telefoonNummer;
    }
}
