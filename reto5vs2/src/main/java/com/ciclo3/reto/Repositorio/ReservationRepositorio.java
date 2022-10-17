package com.ciclo3.reto.Repositorio;

/*
 * @Author
 * Juan Diego Arenas Cuellar	juan.arenas.mt@usa.edu.co
 * Carlos Alberto Rey Ardila	carlos.rey.mt@usa.edu.co
 * Edgar Mauricio Abaunza Pinzon	edgar.abaunza.mt@usa.edu.co
 * Darly Fernanda Sandoval Plazas	darly.sandoval.mt@usa.edu.co
 * Adriana Feo Osma	adriana.feo.mt@usa.edu.co
 */


import com.ciclo3.reto.Entidades.Reservation;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.*;


@Repository
public interface ReservationRepositorio extends CrudRepository<Reservation, Integer> {

    //Reto 5
    //Reservas entre fechas. Fech de inicio entre fechas dadas
    public List<Reservation> findAllByStartDateAfterAndDevolutionDateBefore(Date FechaIni, Date FechaFin);

    //Reservas por estado
    public List<Reservation> findAllByStatus(String status);


    //Total Reservas por cliente
    @Query("select A.client , count(A.client) from Reservation AS A group by A.client order by count(A.client) desc")
    public List<Object[]> getTotalReservationsByClient();


}
