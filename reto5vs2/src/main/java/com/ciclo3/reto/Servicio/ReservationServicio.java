package com.ciclo3.reto.Servicio;

/*
 * @Author
 * Juan Diego Arenas Cuellar	juan.arenas.mt@usa.edu.co
 * Carlos Alberto Rey Ardila	carlos.rey.mt@usa.edu.co
 * Edgar Mauricio Abaunza Pinzon	edgar.abaunza.mt@usa.edu.co
 * Darly Fernanda Sandoval Plazas	darly.sandoval.mt@usa.edu.co
 * Adriana Feo Osma	adriana.feo.mt@usa.edu.co
 */


import com.ciclo3.reto.Entidades.Client;
import com.ciclo3.reto.Entidades.DTO.TotalPorClient;
import com.ciclo3.reto.Entidades.DTO.TotalPorEstado;
import com.ciclo3.reto.Entidades.Reservation;
import com.ciclo3.reto.Repositorio.ReservationRepositorio;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;


@Service
public class ReservationServicio {

    private ReservationRepositorio repositorio;

    public ReservationServicio(ReservationRepositorio repositorio){
        this.repositorio = repositorio;
    }

    public List<Reservation> listaReservation(){
        return (List<Reservation>) repositorio.findAll();
    }

    public Optional<Reservation> buscarReservation(int id){
        return repositorio.findById(id);
    }

    public Reservation GuardarReservation(Reservation reservation){
        if(reservation.getIdReservation() == null){
            return repositorio.save(reservation);
        }
        else{
            return reservation;
        }
    }

    //Reto 4
    //Actualizar

    public Reservation update(Reservation reservation) {
        if (reservation.getIdReservation() != null) {
            Optional<Reservation> infoRegistro = repositorio.findById(reservation.getIdReservation());
            if (infoRegistro.isPresent()) {
                if (reservation.getStartDate() != null) {
                    infoRegistro.get().setStartDate(reservation.getStartDate());
                }
                if (reservation.getDevolutionDate() != null) {
                    infoRegistro.get().setDevolutionDate(reservation.getDevolutionDate());
                }
                if (reservation.getStatus() != null) {
                    infoRegistro.get().setStatus(reservation.getStatus());
                }

                repositorio.save(infoRegistro.get());
                return infoRegistro.get();

            } else {
                return reservation;
            }
        } else {
            return reservation;
        }
    }

    //Borrar
    public boolean delete(int id){
        boolean resultado = false;
        Optional<Reservation> reservation = repositorio.findById(id);

        if(reservation.isPresent()){
            repositorio.delete(reservation.get());
            resultado = true;
        }
        return resultado;
    }


    //Reto 5 - Reportes
    //Reporte Reservas entre fechas
    public List<Reservation> getReservasEntreFechas(Date FechaIni, Date FechaFin){
        return repositorio.findAllByStartDateAfterAndDevolutionDateBefore(FechaIni,FechaIni);
    }

    //Reservas Por estado
    public List<Reservation> getReservasPorEstado(String status){
        return repositorio.findAllByStatus(status);
    }

    //Reporte Reservas Total por Cliente
    public List<TotalPorClient> getTotalReservasPorCliente(){
        List<TotalPorClient> infoRegistro = new ArrayList<>();
        List<Object[]> reporte = repositorio.getTotalReservationsByClient();

        //Recorrer el resultado del Query
        for(int i=0 ;i<reporte.size();i++){
            infoRegistro.add(new TotalPorClient((Long) reporte.get(i)[1],(Client) reporte.get(i)[0]));
        }

        return infoRegistro;
    }


    //Validacion para el reporte final entre fechas. Convertir dato fecha String a Date y dar formato requerido
    public List<Reservation> getReporteReservasEntreFechas(String FechaIni, String FechaFin){
        SimpleDateFormat ConvertirFecha = new SimpleDateFormat("yyyy-MM-dd");

        Date FechaI = new Date();
        Date FechaF = new Date();

        //capturar posibles errores
        try{
            FechaI = ConvertirFecha.parse(FechaIni);
            FechaF = ConvertirFecha.parse(FechaFin);

        } catch (ParseException exception){
            exception.printStackTrace();
        }

        //Validar orden de las fechas para el reporte
        if(FechaI.before(FechaF)){
            return repositorio.findAllByStartDateAfterAndDevolutionDateBefore(FechaI,FechaF);
        }
        else{
            return new ArrayList<>();
        }
    }

    //Reporte de reservas por estado
    public TotalPorEstado getReporteReservasPorEstado(){
        List<Reservation> completed = repositorio.findAllByStatus("completed");
        List<Reservation> cancelled = repositorio.findAllByStatus("cancelled");

        //Total de cada estado
        int cantidadCompletadas = completed.size();
        int cantidadCanceladas = cancelled.size();

        return new TotalPorEstado((long) cantidadCompletadas,(long) cantidadCanceladas);
    }

    //Reporte de Reservas por cliente
    public List<Object[]> getReporteTotalPorCliente(){
        return repositorio.getTotalReservationsByClient();
    }
}
