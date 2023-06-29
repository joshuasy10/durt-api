package org.CFT.api;

import org.CFT.client.FailedToCreateClientException;
import org.CFT.client.FailedToDeleteClientException;
import org.CFT.db.Client_Dao;
import org.CFT.cli.Client;
import org.CFT.client.FailedToGetClientException;


import java.sql.SQLException;
import java.util.List;

public class ClientService {
    private Client_Dao clientDao = new Client_Dao();

    public List<Client> getAllClients() throws FailedToGetClientException{
        try{
            List<Client> clientList = clientDao.getAllClient();
            return clientList;
        } catch(SQLException e) {
            System.err.println(e.getMessage());
            throw new FailedToGetClientException();
        }
    }

    public Client getClientByID(int id) throws ClientDoesNotExistException, FailedToGetClientException {
        try {
            Client client = clientDao.getClientByID(id);
            if(client == null){
                throw new ClientDoesNotExistException();
            }
            return client;
        } catch (SQLException e) {
            System.err.println(e.getMessage());

            throw new FailedToGetClientException();
        }
    }

    public int createCustomer(ClientRequest customer) throws FailedToCreateClientException, InvalidClientException {
        try {
            String validation = clientValidator.isValidCustomer(customer);
            if(validation != null){
                throw new InvalidClientException(validation);
            }
            int id = clientDao.createClient(client);

            if(id == -1){
                throw new FailedToCreateClientException();
            }

            return id;
        } catch(SQLException e) {
            System.err.println(e.getMessage());
            throw new FailedToCreateClientException();
        }
    }

    public void deleteClient(int id) throws ClientDoesNotExistException, FailedToDeleteClientException {
        try{
            Client clientToDelete = clientDao.getClientByID(id);

            if(clientToDelete == null){
                throw new ClientDoesNotExistException();
            }

            clientDao.deleteClient(id);
        } catch(SQLException e) {
            System.err.println(e.getMessage());

            throw new FailedToDeleteClientException();
        }
    }
}
