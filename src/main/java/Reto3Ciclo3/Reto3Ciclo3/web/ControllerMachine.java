
package Reto3Ciclo3.Reto3Ciclo3.web;
import Reto3Ciclo3.Reto3Ciclo3.modelo.Machine;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping; 
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import Reto3Ciclo3.Reto3Ciclo3.servicio.ServiciosMachine;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/api/Machine")


@CrossOrigin(origins ="*", methods= {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})

public class ControllerMachine {
    
    @Autowired    
    private ServiciosMachine serviciosMachine;
    
    @GetMapping("/all")
    public List<Machine> getMachine(){
        return serviciosMachine.getAll();
    }
    
    @GetMapping("/{id}")
    public Optional<Machine> getMachineIndividual(@PathVariable("idReservation")int id){
        return serviciosMachine.getMachineId(id);
    }
    
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Machine save (@RequestBody Machine machine){
        return serviciosMachine.save(machine);
    }
    
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Machine update (@RequestBody Machine categoria){
    return serviciosMachine.update(categoria);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean deleteCategoryIndividual (@PathVariable("id") int id){
    return serviciosMachine.deleteMachine(id);
    }
}
