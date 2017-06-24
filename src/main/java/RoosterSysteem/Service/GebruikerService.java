package RoosterSysteem.Service;


import RoosterSysteem.Model.gebruiker.Gebruiker;
import RoosterSysteem.Persistence.DAO.BaseDAO;
import RoosterSysteem.Persistence.DAO.GebruikerDAO;


public class GebruikerService {
    private GebruikerDAO dao = BaseDAO.getGebruikerDAO();

    public Gebruiker getGebruiker(String gebruikersnaam, String password){
        return dao.getGebruiker(gebruikersnaam,password);
    }


}
