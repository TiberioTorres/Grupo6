
package Reto3Ciclo3.Reto3Ciclo3.servicio;

import Reto3Ciclo3.Reto3Ciclo3.modelo.ContadorClientes;
import Reto3Ciclo3.Reto3Ciclo3.modelo.Reservation;
import Reto3Ciclo3.Reto3Ciclo3.modelo.StatusReservas;
import Reto3Ciclo3.Reto3Ciclo3.repositorio.RepositorioReservation;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 *
 * @Tiberio
 * @version 1.1
 */
@Service
public class ServiciosReservation {
     /**
     * creación de variable de tipo Repositorio con la anotación
     */
    @Autowired
    private RepositorioReservation metodosCrud;
     /**
     * metodo para obtener todos los datos de la tabla reservaciones
     * @return List de clase Reservacion
     */
    public List<Reservation> getAll(){
        return metodosCrud.getAll();
    }
     /**
     * metodo para obtener dato de la tabla reservaciones por Id
     * @param reservationId
     * @return Optional de clase Reservacion
     */
    
    public Optional<Reservation> getReservationId(int id){
        return metodosCrud.getReservationId(id);
    }
     
    /**
     * metodo para registrar valores en la tabla reservaciones
     * @param reservation
     * @return valor de calse Reservacion
     */
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
     
     /* Metodo para adquirir status
     * @return StatusReservas
     */
    
    public StatusReservas reporteStatusServicio() {
        List<Reservation> completed = metodosCrud.ReservacionStatusRepositorio("completed");
        List<Reservation> cancelled = metodosCrud.ReservacionStatusRepositorio("cancelled");
        return new StatusReservas(completed.size(), cancelled.size());

    }
     /**
     * Metodo para el reporte de tiempo
     * @param datoA
     * @param datoB
     * @return ListaReservaciones
     */
    
    public List<Reservation> reporteTiempoServicio(String datoA, String datoB) {
        SimpleDateFormat parser = new SimpleDateFormat("yyyy-MM-dd");
        Date datoUno = new Date();
        Date datoDos = new Date();
        try {
            datoUno = parser.parse(datoA);
            datoDos = parser.parse(datoB);
        } catch (ParseException evt) {
            evt.printStackTrace();
        }
        if (datoUno.before(datoDos)) {
            return metodosCrud.ReservacionTiempoRepositorio(datoUno, datoDos);
        } else {
            return new ArrayList<>();
        }
    }

     /* metodo para reporte de clientes
     * @return listaClientes
     */
    public List<ContadorClientes> reporteClientesServicio() {
        return metodosCrud.getClientesRepositorio();
    }
}
