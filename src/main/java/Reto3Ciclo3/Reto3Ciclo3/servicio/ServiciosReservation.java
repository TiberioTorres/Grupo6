
package Reto3Ciclo3.Reto3Ciclo3.servicio;

import Reto3Ciclo3.Reto3Ciclo3.modelo.Reservation;
import Reto3Ciclo3.Reto3Ciclo3.repositorio.RepositorioReservation;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiciosReservation {
    @Autowired
    private RepositorioReservation metodosCrud;
    
    public List<Reservation> getAll(){
        return metodosCrud.getAll();
    }
    
    public Optional<Reservation> getReservationId(int id){
        return metodosCrud.getReservationId(id);
    }
    
    public Reservation save(Reservation reservation){
        if(reservation.getIdReservation()==null){
            return metodosCrud.save(reservation);
        }else{
            Optional<Reservation> evt=metodosCrud.getReservationId(reservation.getIdReservation());
            if(evt.isEmpty()){
                return metodosCrud.save(reservation);
            }else{
                return reservation;
            }
        }
    }
}
