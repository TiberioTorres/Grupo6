package Reto3Ciclo3.Reto3Ciclo3.repositorio;

import Reto3Ciclo3.Reto3Ciclo3.modelo.Message;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioMessage {
    
    @Autowired
    private InterfaceMessage crud;
    
    public List<Message> getAll(){
        return (List<Message>)crud.findAll();
    }
    
    public Optional <Message> getMessageId(int id){
        return crud.findById(id);
    }
    
    public Message save(Message message){
        return crud.save(message);
    }
}
