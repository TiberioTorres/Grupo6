
package Reto3Ciclo3.Reto3Ciclo3.repositorio;

import Reto3Ciclo3.Reto3Ciclo3.modelo.Reservation;
import org.springframework.data.repository.CrudRepository;


public interface InterfaceReservation extends CrudRepository<Reservation,Integer> {
    
}
