package com.ciclo3.reto.Controlador;

/*
 * @Author
 * Juan Diego Arenas Cuellar	juan.arenas.mt@usa.edu.co
 * Carlos Alberto Rey Ardila	carlos.rey.mt@usa.edu.co
 * Edgar Mauricio Abaunza Pinzon	edgar.abaunza.mt@usa.edu.co
 * Darly Fernanda Sandoval Plazas	darly.sandoval.mt@usa.edu.co
 * Adriana Feo Osma	adriana.feo.mt@usa.edu.co
 */

import com.ciclo3.reto.Entidades.Admin;
import com.ciclo3.reto.Servicio.AdminServicio;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
public class AdminControlador {
    private AdminServicio servicio;

    public AdminControlador(AdminServicio servicio){
        this.servicio = servicio;
    }

    @GetMapping("/api/Admin/all")
    public List<Admin> listaAdmin(){
        return servicio.listaAdmin();
    }

    @PostMapping("/api/Admin/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Admin save (@RequestBody Admin admin){
        return servicio.GuardarAdmin(admin);
    }

    @GetMapping("/api/Admin/{id}")
    public Optional<Admin> buscarAdmin(@PathVariable("id") int id){
        return servicio.buscarAdmin(id);
    }

    //Reto 4
    //Actualizar
    @PutMapping("/api/Admin/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Admin update(@RequestBody Admin admin){ return servicio.update(admin);}

    //Borrar
    @DeleteMapping("/api/Admin/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int id){return servicio.delete(id);}


}
