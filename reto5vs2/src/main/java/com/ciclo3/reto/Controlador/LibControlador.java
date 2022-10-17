package com.ciclo3.reto.Controlador;

/*
 * @Author
 * Juan Diego Arenas Cuellar	juan.arenas.mt@usa.edu.co
 * Carlos Alberto Rey Ardila	carlos.rey.mt@usa.edu.co
 * Edgar Mauricio Abaunza Pinzon	edgar.abaunza.mt@usa.edu.co
 * Darly Fernanda Sandoval Plazas	darly.sandoval.mt@usa.edu.co
 * Adriana Feo Osma	adriana.feo.mt@usa.edu.co
 */

import com.ciclo3.reto.Entidades.Lib;
import com.ciclo3.reto.Servicio.LibServicio;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
public class LibControlador {
    private LibServicio servicio;

    public LibControlador(LibServicio servicio){
        this.servicio = servicio;
    }

    @GetMapping("/api/Lib/all")
    public List<Lib> listaLib(){
        return servicio.listaLib();
    }

    @PostMapping("/api/Lib/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Lib save (@RequestBody Lib lib){
        return servicio.GuardarLib(lib);
    }

    @GetMapping("/api/Lib/{id}")
    public Optional<Lib> buscarLib(@PathVariable("id") int id){
        return servicio.buscarLib(id);
    }


    //Reto 4
    //Actualizar
    @PutMapping("/api/Lib/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Lib update(@RequestBody Lib lib){ return servicio.update(lib);}

    //Borrar
    @DeleteMapping("/api/Lib/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int id){return servicio.delete(id);}
}
