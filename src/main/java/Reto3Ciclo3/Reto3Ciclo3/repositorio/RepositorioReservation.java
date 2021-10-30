package Reto3Ciclo3.Reto3Ciclo3.repositorio;

import Reto3Ciclo3.Reto3Ciclo3.modelo.Client;
import Reto3Ciclo3.Reto3Ciclo3.modelo.ContadorClientes;
import Reto3Ciclo3.Reto3Ciclo3.modelo.Reservation;
import java.util.ArrayList;
import java.util.Date;
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
    public void delete(Reservation reservation){
        crud.delete(reservation); 
    }
    

    public List<Reservation> ReservacionStatusRepositorio (String status){
         return crud.findAllByStatus(status);
     }
     
     public List<Reservation> ReservacionTiempoRepositorio (Date a, Date b){
         return crud.findAllByStartDateAfterAndStartDateBefore(a, b);
     
     }
     
     public List<ContadorClientes> getClientesRepositorio(){
         List<ContadorClientes> res = new ArrayList<>();
         List<Object[]> report = crud.countTotalReservationByClient();
         for(int i=0; i<report.size(); i++){
             res.add(new ContadorClientes((Long)report.get(i)[1],(Client) report.get(i)[0]));
         }
         return res;
     }

    
    
}
