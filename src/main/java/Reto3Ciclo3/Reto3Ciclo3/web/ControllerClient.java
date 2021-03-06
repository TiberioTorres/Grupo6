
package Reto3Ciclo3.Reto3Ciclo3.web;
import Reto3Ciclo3.Reto3Ciclo3.modelo.Client;
import Reto3Ciclo3.Reto3Ciclo3.servicio.ServiciosClient;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/Client")


@CrossOrigin(origins ="*", methods= {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})

public class ControllerClient {
    
    @Autowired
    private ServiciosClient serviciosClient;
    
    @GetMapping("/all")
    public List<Client> getClient(){
        return serviciosClient.getAll();
    }
    
    @GetMapping("/{id}")
    public Optional<Client> getClientIndividual(@PathVariable("id") int id){
        return serviciosClient.getClientId(id);
    }
    
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Client save (@RequestBody Client client){
        return serviciosClient.save(client);
    }
    
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Client update (@RequestBody Client categoria){
    return serviciosClient.update(categoria);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean deleteClient (@PathVariable("id") int id){
    return serviciosClient.deleteClient(id);
    }
}
