package org.CFT.api;

import org.CFT.client.ClientDoesNotExistException;
import org.CFT.client.FailedToCreateClientException;
import org.CFT.client.FailedToDeleteClientException;
import org.CFT.cli.ClientRequest;
import org.CFT.client.*;
import org.CFT.db.ClientDao;
import org.CFT.core.ClientValidator;
import org.CFT.cli.Client;


import java.sql.SQLException;
import java.util.List;

public class ClientService {
    private ClientDao clientDao = new ClientDao();
    private ClientValidator clientValidator = new ClientValidator();

    public List<Client> getAllClients() throws FailedToGetClientException{
        try{
            List<Client> clientList = clientDao.getAllClients();
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

    public int createClient(ClientRequest client) throws FailedToCreateClientException, InvalidClientException {
        try {
            String validation = clientValidator.isValidClient(client);
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

    public void updateClient(ClientRequest client, int id) throws FailedToUpdateClientException, ClientDoesNotExistException, InvalidClientException {
        try{
            String validation = clientValidator.isValidClient(client);
            if(validation != null){
                throw new InvalidClientException(validation);
            }

            Client clientToUpdate = clientDao.getClientByID(id);

            if(clientToUpdate == null){
                throw new ClientDoesNotExistException();
            }

            clientDao.updateClient(id, client);
        } catch(SQLException e) {
            System.err.println(e.getMessage());

            throw new FailedToUpdateClientException();
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
