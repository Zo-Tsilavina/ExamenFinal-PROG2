package com.examen.PROG2.controller;

import com.examen.PROG2.model.Client;
import com.examen.PROG2.repository.ClientDAO;
import com.examen.PROG2.service.ClientInterface;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Client")
public class ClientController {
    private final ClientInterface clientInterface;

    public ClientController(ClientInterface clientInterface) {
        this.clientInterface = clientInterface;
    }

    @GetMapping("/getAllClient")
    public List<Client> getAllClient(){
        return clientInterface.getAllClient();
    }

    @PostMapping("/insertClient")
    public void insertClient(@RequestBody  Client client){
        clientInterface.insertClient(client);
    }

    @GetMapping("/{id}")
    public Client findById(@PathVariable int id){
        return clientInterface.findById(id);
    }

    @PutMapping("/updateClient/{id}")
    public void updateClient(@RequestBody Client client , @PathVariable int id){
        clientInterface.updateClient(client, id);
    }

    @DeleteMapping("/deleteClient/{id}")
    public void deleteClient(@PathVariable int id){
        clientInterface.deleteClient(id);
    }
}
