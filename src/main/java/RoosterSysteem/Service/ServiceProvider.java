package RoosterSysteem.Service;


public class ServiceProvider {
    private static mRoosterService worldService = new mRoosterService();

    public static mRoosterService getWorldService() {
        return worldService;
    }
}