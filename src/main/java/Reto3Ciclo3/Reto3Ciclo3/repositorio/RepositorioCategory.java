package Reto3Ciclo3.Reto3Ciclo3.repositorio;

import Reto3Ciclo3.Reto3Ciclo3.modelo.Category;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class RepositorioCategory {
   @Autowired 
    private InterfaceCategory crud;
    
   public List<Category> getAll(){
        return  (List<Category>)crud.findAll();
    }

    public Optional <Category> getCategoryId(int id){
        return crud.findById(id);
    }
    
    public Category save(Category category){
        return crud.save(category);
    }
    
    public void delete(Category cat){
        crud.delete(cat);
    }
}
