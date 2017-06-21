package RoosterSysteem.Persistence.sql;


public class BaseDAO {
    private static ClientDAO clientDAO = new ClientDAO();
    private static CRoosterDAO cRoosterDAO = new CRoosterDAO();
    private static MedewerkerDAO medewerkerDAO = new MedewerkerDAO();
    private static MRoosterDAO mRoosterDAO = new MRoosterDAO();
    private static SchoolDAO schoolDAO = new SchoolDAO();

    public static CRoosterDAO getCRoosterDAO(){
        return cRoosterDAO;
    }

    public static ClientDAO getClientDAO(){
        return clientDAO;
    }

    public static MedewerkerDAO getMedewerkerDAO(){
        return medewerkerDAO;
    }

    public static MRoosterDAO getMRoosterDAO(){
        return mRoosterDAO;
    }

    public static SchoolDAO getSchoolDAO(){
        return schoolDAO;
    }
}
