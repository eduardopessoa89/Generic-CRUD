package com.eduardo.crud.Controllers;


import com.eduardo.crud.Model.Client;
import com.eduardo.crud.Service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Crud {


    @Autowired
    private ClientService service;

    String name;

    /**
     * @param client, Recebe um JSON
     * @return
     */
    @RequestMapping(value = "/crud/create", method = RequestMethod.POST)
    public ResponseEntity<?> createClient(Client client){
        service.insert(client);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @RequestMapping(value = "/crud/update/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> update(@RequestBody Client client, @PathVariable("id") int id) throws Exception{
        service.update(client, id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/crud/list", method = RequestMethod.GET)
    public ResponseEntity<List<?>> list(){
        List<Client> clients = service.getClients();
        return new ResponseEntity<>(clients, HttpStatus.OK);
    }

    @RequestMapping(value = "/crud/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> delete(@PathVariable("id") int id) throws Exception {
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }



}
