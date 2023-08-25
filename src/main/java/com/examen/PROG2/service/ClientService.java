package com.examen.PROG2.service;


import com.examen.PROG2.model.Client;
import com.examen.PROG2.repository.ClientDAO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService implements ClientInterface{
    private final ClientDAO clientDAO;

    public ClientService(ClientDAO clientDAO) {
        this.clientDAO = clientDAO;
    }

    @Override
    public List<Client> getAllClient() {
        return clientDAO.getAllClient();
    }

    @Override
    public void insertClient(Client client){
        clientDAO.insertClient(client);
    }

    @Override
    public Client findById(int id) {
        return clientDAO.findById(id);
    }
    @Override
    public void updateClient(Client client , int id){
        clientDAO.updateClient(client, id);
    }
    @Override
    public void deleteClient(int id){
        clientDAO.deleteClient(id);
    }
}
