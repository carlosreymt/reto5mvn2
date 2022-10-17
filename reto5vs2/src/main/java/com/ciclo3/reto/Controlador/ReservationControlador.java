package com.ciclo3.reto.Controlador;

/*
 * @Author
 * Juan Diego Arenas Cuellar	juan.arenas.mt@usa.edu.co
 * Carlos Alberto Rey Ardila	carlos.rey.mt@usa.edu.co
 * Edgar Mauricio Abaunza Pinzon	edgar.abaunza.mt@usa.edu.co
 * Darly Fernanda Sandoval Plazas	darly.sandoval.mt@usa.edu.co
 * Adriana Feo Osma	adriana.feo.mt@usa.edu.co
 */

import com.ciclo3.reto.Entidades.DTO.TotalPorClient;
import com.ciclo3.reto.Entidades.DTO.TotalPorEstado;
import com.ciclo3.reto.Entidades.Reservation;
import com.ciclo3.reto.Servicio.ReservationServicio;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
public class ReservationControlador {

    private ReservationServicio servicio;

    public ReservationControlador(ReservationServicio servicio){
        this.servicio = servicio;
    }

    @GetMapping("/api/Reservation/all")
    public List<Reservation> listaReservation(){
        return servicio.listaReservation();
    }

    @PostMapping("/api/Reservation/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation save (@RequestBody Reservation reservation){
        return servicio.GuardarReservation(reservation);
    }

    @GetMapping("/api/Reservation/{id}")
    public Optional<Reservation> buscarReservation(@PathVariable("id") int id){
        return servicio.buscarReservation(id);
    }

    //Reto 4
    //Actualizar
    @PutMapping("/api/Reservation/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation update(@RequestBody Reservation reservation){ return servicio.update(reservation);}

    //Borrar
    @DeleteMapping("/api/Reservation/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean deleteCategory(@PathVariable("id") int id){return servicio.delete(id);}

    //Reto 5
    //Reporte Reservas entre fechas
    @GetMapping("/api/Reservation/report-dates/{fecha1}/{fecha2}")
    public List<Reservation> getReporteReservasEntreFechas(@PathVariable("fecha1") String fecha1 ,@PathVariable("fecha2") String fecha2){
        return servicio.getReporteReservasEntreFechas(fecha1,fecha2);
    }

    //Reporte Reservas por Estado
    @GetMapping("/api/Reservation/report-status")
    public TotalPorEstado getReporteReservasPorEstado(){
        return servicio.getReporteReservasPorEstado();
    }

    //Reporte Reservas por Cliente
    @GetMapping("/api/Reservation/report-clients")
    public List<TotalPorClient> getReporteTotalPorCliente(){
        return servicio.getTotalReservasPorCliente();
    }

}
