package Reto3Ciclo3.Reto3Ciclo3.repositorio;

import Reto3Ciclo3.Reto3Ciclo3.modelo.Machine;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioMachine {
    @Autowired
    private InterfaceMachine crud;
            
       
    public List<Machine> getAll(){
        return  (List<Machine>)crud.findAll();
    }

    public Optional <Machine> getMachineId(int id){
        return crud.findById(id);
    }
    
    public Machine save(Machine machine){
        return crud.save(machine);
    }
    
    public void delete(Machine machine){
        crud.delete(machine);
    }
}
