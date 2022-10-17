package com.ciclo3.reto.Controlador;

/*
 * @Author
 * Juan Diego Arenas Cuellar	juan.arenas.mt@usa.edu.co
 * Carlos Alberto Rey Ardila	carlos.rey.mt@usa.edu.co
 * Edgar Mauricio Abaunza Pinzon	edgar.abaunza.mt@usa.edu.co
 * Darly Fernanda Sandoval Plazas	darly.sandoval.mt@usa.edu.co
 * Adriana Feo Osma	adriana.feo.mt@usa.edu.co
 */

import com.ciclo3.reto.Entidades.Score;
import com.ciclo3.reto.Servicio.ScoreServicio;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class ScoreControlador {
    private ScoreServicio servicio;

    public ScoreControlador(ScoreServicio servicio){
        this.servicio = servicio;
    }

    @GetMapping("/api/Score/all")
    public List<Score> listaScore(){
        return servicio.listaScore();
    }

    @PostMapping("/api/Score/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Score save (@RequestBody Score score){
        return servicio.GuardarScore(score);
    }

    //Reto 4
    //Actualizar Score
    @PutMapping("/api/Score/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Score update(@RequestBody Score score){ return servicio.update(score);}

}
