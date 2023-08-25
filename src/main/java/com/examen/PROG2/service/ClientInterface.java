package com.examen.PROG2.service;

import com.examen.PROG2.model.Client;

import java.util.List;

public interface ClientInterface {
    List <Client> getAllClient();
    void insertClient(Client client);
    Client findById(int id);
    void updateClient(Client client, int id);

    void deleteClient(int id);

}
