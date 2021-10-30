
package Reto3Ciclo3.Reto3Ciclo3.repositorio;

import Reto3Ciclo3.Reto3Ciclo3.modelo.Reservation;
import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


public interface InterfaceReservation extends CrudRepository<Reservation,Integer> {
    
    
    public List<Reservation> findAllByStatus (String status); 
    
    
public List<Reservation> findAllByStartDateAfterAndStartDateBefore(Date dateOne, Date dateTwo);
    
    
// SELECT clientid, COUNT(*) AS total FROM reservacion group by clientid order by desc;
@Query ("SELECT c.client, COUNT(c.client) from Reservation AS c group by c.client order by COUNT(c.client)DESC")
public List<Object[]> countTotalReservationByClient();

}
