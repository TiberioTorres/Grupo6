
package Reto3Ciclo3.Reto3Ciclo3.web;
import Reto3Ciclo3.Reto3Ciclo3.modelo.Category;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import Reto3Ciclo3.Reto3Ciclo3.servicio.ServiciosCategory;
import java.util.Optional;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@RestController
@RequestMapping("/api/Category")


@CrossOrigin(origins ="*", methods={RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})

public class ControllerCategory {
    
    @Autowired
    private ServiciosCategory serviciosCategory;
    
    @GetMapping("/all")
    public List<Category> getCategory(){
        return serviciosCategory.getAll();
    }
    @GetMapping("/{id}")
    public Optional<Category> getCategoryIndividual (@PathVariable("id") int id){
        return serviciosCategory.getCategoryId(id);
    }
    
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Category save (@RequestBody Category categoria){
        return serviciosCategory.save(categoria);
    }
    
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Category update (@RequestBody Category categoria){
    return serviciosCategory.update(categoria);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean deleteCategory (@PathVariable("id") int id){
    return serviciosCategory.deleteCategory(id);
    }
}


































