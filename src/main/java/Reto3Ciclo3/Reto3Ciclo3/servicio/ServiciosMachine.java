
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
}
