package RoosterSysteem.Service;


import RoosterSysteem.Model.gebruiker.Gebruiker;

public class ServiceProvider {
    private static ClientService clientService = new ClientService();
    private static MedewerkerService medewerkerService = new MedewerkerService();
    private static MRoosterService mRoosterService = new MRoosterService();
    private static CRoosterService cRoosterService = new CRoosterService();
    private static SchoolService schoolService = new SchoolService();
    private static GebruikerService gebruikerService = new GebruikerService();

    public static ClientService getClientService() {
        return clientService;
    }

    public static MedewerkerService getMedewerkerService() {
        return medewerkerService;
    }

    public static MRoosterService getmRoosterService() {
        return mRoosterService;
    }

    public static CRoosterService getcRoosterService() {
        return cRoosterService;
    }

    public static SchoolService getSchoolService() {
        return schoolService;
    }

    public static GebruikerService getGebruikerService(){return gebruikerService;}
}