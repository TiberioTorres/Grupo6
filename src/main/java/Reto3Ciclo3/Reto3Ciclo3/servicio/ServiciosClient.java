
package Reto3Ciclo3.Reto3Ciclo3.servicio;

import Reto3Ciclo3.Reto3Ciclo3.modelo.Client;
import Reto3Ciclo3.Reto3Ciclo3.repositorio.RepositorioClient;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiciosClient {
    
    @Autowired
    private RepositorioClient metodosCrud;
    public List<Client> getAll(){
        return metodosCrud.getAll();
    }
    
    public Optional<Client> getClientId(int id){
        return metodosCrud.getClientId(id);
    }
    
    public Client save(Client client){
        if(client.getIdClient()==null){
            return metodosCrud.save(client);
        }else{
            Optional<Client> evt=metodosCrud.getClientId(client.getIdClient());
            if(evt.isEmpty()){
                return metodosCrud.save(client);       
            }else{
                return client;
            }
        }      
    }    
}
