package com.eduardo.crud.Service;


import com.eduardo.crud.Model.Client;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClientService {

    private String name;
    protected List<Client> list;
    private Client client;
    private int id;

    public ClientService() {
        this.name = null;
        this.list = new ArrayList<>();
    }

    public void insert(Client client) {
        client.setId(id++);
        list.add(client);
    }

    public Client getClientById(int id) throws Exception {
        for (Client c : this.list){
            if(c.getId() != id){
                throw new Exception("Client doesn't exist");
            }else{
                return c;
            }
        }
        return null;
    }

    public List<Client> getClients(){
        return list;
    }

    public Client delete(int id) throws Exception{
        for(Client c : this.list){
            if(c.getId() == id){
                this.list.remove(c);
                return c;
            }else{
                throw new Exception("Client doesn't exist");
            }
        }
        return null;
    }



    public Client update(Client client, int id) throws Exception {
        List<Client> clients = this.getClients();
        ModelMapper mp = new ModelMapper();
        for(Client c : clients){
            if(c.getId() == id){
                client.setId(id);
                mp.map(client,c);
                return c;
            }
        }
        throw new Exception("ID doesn't found");
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Client> getList() {
        return list;
    }

    public void setList(List<Client> list) {
        this.list = list;
    }
}
