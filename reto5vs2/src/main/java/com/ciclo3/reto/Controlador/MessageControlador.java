package com.ciclo3.reto.Controlador;

/*
 * @Author
 * Juan Diego Arenas Cuellar	juan.arenas.mt@usa.edu.co
 * Carlos Alberto Rey Ardila	carlos.rey.mt@usa.edu.co
 * Edgar Mauricio Abaunza Pinzon	edgar.abaunza.mt@usa.edu.co
 * Darly Fernanda Sandoval Plazas	darly.sandoval.mt@usa.edu.co
 * Adriana Feo Osma	adriana.feo.mt@usa.edu.co
 */

import com.ciclo3.reto.Entidades.Message;
import com.ciclo3.reto.Servicio.MessageServicio;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
public class MessageControlador {

    private MessageServicio servicio;

    public MessageControlador(MessageServicio servicio){
        this.servicio = servicio;
    }

    @GetMapping("/api/Message/all")
    public List<Message> listaMessage(){
        return servicio.listaMessage();
    }

    @PostMapping("/api/Message/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Message save (@RequestBody Message message){
        return servicio.GuardarMessage(message);
    }

    @GetMapping("/api/Message/{id}")
    public Optional<Message> buscarMessage(@PathVariable("id") int id){
        return servicio.buscarMessage(id);
    }

    //Reto 4
    //Actualizar
    @PutMapping("/api/Message/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Message update(@RequestBody Message message){ return servicio.update(message);}

    //Borrar
    @DeleteMapping("/api/Message/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int id){return servicio.delete(id);}
}
