
package Reto3Ciclo3.Reto3Ciclo3.servicio;

import Reto3Ciclo3.Reto3Ciclo3.repositorio.RepositorioMachine;
import Reto3Ciclo3.Reto3Ciclo3.modelo.Machine;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiciosMachine {
    @Autowired
    private RepositorioMachine metodosCrud;
    
    public List<Machine> getAll(){
        return metodosCrud.getAll();
    }
    
    public Optional<Machine> getMachineId(int id){
        return metodosCrud.getMachineId(id);
    }
    
    public Machine save(Machine machine){
        if(machine.getId()==null){
            return metodosCrud.save(machine);
        }else{
            Optional<Machine> evt=metodosCrud.getMachineId(machine.getId());
            if(evt.isEmpty()){
                return metodosCrud.save(machine);
            }else{
            return machine;
            }
        }
    }
        public Machine update(Machine machine){
        if(machine.getId()!=null){
            Optional<Machine>g=metodosCrud.getMachineId(machine.getId());
            if(!g.isEmpty()){
                if(machine.getName()!=null){
                    g.get().setName(machine.getName());
                }
                if(machine.getBrand()!=null){
                    g.get().setBrand(machine.getBrand());
                }   
                if(machine.getYear()!=null){
                    g.get().setYear(machine.getYear());
                }
                if(machine.getDescription()!=null){
                    g.get().setDescription(machine.getDescription());
                }
                return metodosCrud.save(g.get());
            }
        }
        return machine;
    }
    
    public boolean deleteMachine(int id){
        Optional<Machine> c=getMachineId(id);
        if(!c.isEmpty()){
            metodosCrud.delete(c.get());
            return true;
        }
        return false;
    }
}
