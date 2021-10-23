
package Reto3Ciclo3.Reto3Ciclo3.repositorio;

import Reto3Ciclo3.Reto3Ciclo3.modelo.Message;
import org.springframework.data.repository.CrudRepository;


public interface InterfaceMessage extends CrudRepository<Message,Integer> {
    
}
