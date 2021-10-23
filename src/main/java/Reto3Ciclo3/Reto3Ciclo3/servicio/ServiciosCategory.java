
package Reto3Ciclo3.Reto3Ciclo3.servicio;

import Reto3Ciclo3.Reto3Ciclo3.modelo.Category;
import Reto3Ciclo3.Reto3Ciclo3.repositorio.RepositorioCategory;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiciosCategory {
     @Autowired
    private RepositorioCategory metodosCrud;
    
    public List<Category> getAll(){
        return metodosCrud.getAll();
    }
    
    public Optional<Category> getCategoryId(int id){
        return metodosCrud.getCategoryId(id);
    }
    
    public Category save(Category category){
        if(category.getId()==null){
            return metodosCrud.save(category);
        }else{
            Optional<Category> evt=metodosCrud.getCategoryId(category.getId());
            if(evt.isEmpty()){
                return metodosCrud.save(category);
            }else{
            return category;
            }
        }
    }   
}































