package RoosterSysteem.Service;

import RoosterSysteem.Model.persoon.Client;
import RoosterSysteem.Persistence.sql.BaseDAO;
import RoosterSysteem.Persistence.sql.ClientDAO;


import java.util.List;

public class ClientService {
    private ClientDAO dao = BaseDAO.getClientDAO();

    public List<Client> getClienten (){return dao.getClienten();}

    public void writeClient(Client c){dao.writeDAO(c);}

    public void updateClient(Client c){
        dao.updateDAO(c);
    }

    public void deleteClient(Client c){
        dao.deleteDAO(c);
    }
}
