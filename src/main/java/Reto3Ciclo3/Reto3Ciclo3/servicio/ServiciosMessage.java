
package Reto3Ciclo3.Reto3Ciclo3.servicio;

import Reto3Ciclo3.Reto3Ciclo3.modelo.Message;
import Reto3Ciclo3.Reto3Ciclo3.repositorio.RepositorioMessage;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiciosMessage {
    @Autowired
    private RepositorioMessage metodosCrud;
    
    public List<Message> getAll(){
        return metodosCrud.getAll();
    }
    
    public Optional<Message> getMessageId(int id){
        return metodosCrud.getMessageId(id);
    }
    
    public Message save(Message message){
        if(message.getIdMessage()==null){
            return metodosCrud.save(message);
        }else{
            Optional<Message> evt=metodosCrud.getMessageId(message.getIdMessage());
            if(evt.isEmpty()){
                return metodosCrud.save(message);
            }else{
                return message;
            }
        }
    }
}
