package org.example.Businesslogic;
import org.example.DataAccess.ClientDAO;
import org.example.Model.Client;


public class ClientBLL {
    /***
     * Method that applies insert method from class ClientDao
     * @param client the client for witch the method applies
     * @return return the method call
     */
    public int insertClient(Client client)
    {
        return ClientDAO.insert(client);
    }

    /***
     * Method that applies, delete method from class ClientDAO
     * @param client_id the client id for witch the method applies
     * @return return the method call
     */
     public int deleteClient(int client_id)
    {
        return ClientDAO.deleteClient(client_id);
    }

    /***
     * Method that applies edit method from class ClientDAO
     * @param client the client for witch the method applies
     */
    public void editClient(Client client)
    {
       ClientDAO.edit(client);
    }

    /***
     * Method that applies findbyid method from class ClientDAO
     * @param clientId the client id for witch the method applies
     * @return return the method call
     */
     public Client findById(int clientId){ return ClientDAO.findById(clientId);
     }
}
