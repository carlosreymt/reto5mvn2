package com.ciclo3.reto.Controlador;

/*
 * @Author
 * Juan Diego Arenas Cuellar	juan.arenas.mt@usa.edu.co
 * Carlos Alberto Rey Ardila	carlos.rey.mt@usa.edu.co
 * Edgar Mauricio Abaunza Pinzon	edgar.abaunza.mt@usa.edu.co
 * Darly Fernanda Sandoval Plazas	darly.sandoval.mt@usa.edu.co
 * Adriana Feo Osma	adriana.feo.mt@usa.edu.co
 */

import com.ciclo3.reto.Entidades.Category;
import com.ciclo3.reto.Servicio.CategoryServicio;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
public class CategoryControlador {
    private CategoryServicio servicio;

    public CategoryControlador(CategoryServicio servicio){
        this.servicio = servicio;
    }

    @GetMapping("/api/Category/all")
    public List<Category> listaCategory(){
        return servicio.listaCategory();
    }

    @PostMapping("/api/Category/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Category save (@RequestBody Category category){
        return servicio.GuardarCategory(category);
    }

    @GetMapping("/api/Category/{id}")
    public Optional<Category> buscarCategory(@PathVariable("id") int id){
        return servicio.buscarCategory(id);
    }

    //Reto 4
    //Actualizar
    @PutMapping("/api/Category/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Category update(@RequestBody Category category){ return servicio.update(category);}

    //Borrar
    @DeleteMapping("/api/Category/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean deleteCategory(@PathVariable("id") int id){return servicio.delete(id);}

}
