
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
    
    public Category update(Category categoria){
        if(categoria.getId()!=null){
            Optional<Category>g=metodosCrud.getCategoryId(categoria.getId());
            if(!g.isEmpty()){
                if(categoria.getName()!=null){
                    g.get().setName(categoria.getName());
                }
                if(categoria.getDescription()!=null){
                    g.get().setDescription(categoria.getDescription());
                }
                return metodosCrud.save(g.get());
            }
        }
        return categoria;
    }
    
    public boolean deleteCategory(int id){
        Optional<Category> c=getCategoryId(id);
        if(!c.isEmpty()){
            metodosCrud.delete(c.get());
            return true;
        }
        return false;
    }
    
}































