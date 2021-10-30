package Reto3Ciclo3.Reto3Ciclo3.repositorio;

import Reto3Ciclo3.Reto3Ciclo3.modelo.Client;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioClient {
    @Autowired
    private InterfaceClient crud;
    
    public List<Client> getAll(){
        return (List<Client>)crud.findAll();
    }
    
    public Optional <Client> getClientId(int id){
        return crud.findById(id);
    }
    
    public Client save(Client client){
        return crud.save(client);
    }
        public void delete(Client client){
        crud.delete(client);
    }
}
