package Reto3Ciclo3.Reto3Ciclo3.repositorio;

import Reto3Ciclo3.Reto3Ciclo3.modelo.Reservation;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioReservation {
    @Autowired
    private InterfaceReservation crud;
    
    
    public List<Reservation> getAll(){
        return (List<Reservation>)crud.findAll();
    }
    
    public Optional <Reservation> getReservationId(int id){
        return crud.findById(id);
    }
    
    public Reservation save(Reservation reservation){
        return crud.save(reservation);
    }
}
