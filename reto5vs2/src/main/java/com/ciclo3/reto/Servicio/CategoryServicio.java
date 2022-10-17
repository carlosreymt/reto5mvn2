package com.ciclo3.reto.Servicio;

/*
 * @Author
 * Juan Diego Arenas Cuellar	juan.arenas.mt@usa.edu.co
 * Carlos Alberto Rey Ardila	carlos.rey.mt@usa.edu.co
 * Edgar Mauricio Abaunza Pinzon	edgar.abaunza.mt@usa.edu.co
 * Darly Fernanda Sandoval Plazas	darly.sandoval.mt@usa.edu.co
 * Adriana Feo Osma	adriana.feo.mt@usa.edu.co
 */

import com.ciclo3.reto.Entidades.Category;
import com.ciclo3.reto.Repositorio.CategoryRepositorio;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryServicio {
    private CategoryRepositorio repositorio;

    public CategoryServicio(CategoryRepositorio repositorio){
        this.repositorio = repositorio;
    }

    //Consultar todas las categorias. ALL
    public List<Category> listaCategory(){
        return (List<Category>) repositorio.findAll();
    }

    //Consultar una categoria por ID
    public Optional<Category> buscarCategory(int id){
        return repositorio.findById(id);
    }

    //Guardar una categoria
    public Category GuardarCategory(Category category){
        if(category.getId() == null){
            return repositorio.save(category);
        }
        else{
            return category;
        }
    }

    //Actualizar Categoria
    public Category update(Category category){
        if(category.getId() != null)
        {
            Optional<Category> infoRegistro = repositorio.findById(category.getId());
            if(infoRegistro.isPresent()){

                if(category.getName() != null){
                    infoRegistro.get().setName(category.getName());
                }

                if(category.getDescription() != null){
                    infoRegistro.get().setDescription(category.getDescription());
                }

                if(category.getLibs() != null){
                    infoRegistro.get().setLibs(category.getLibs());
                }
                repositorio.save(infoRegistro.get());
                return infoRegistro.get();
            }
            else {
                return category;
            }
        }
        else {
            return category;
        }
    }

    //Borrar categoria
    public boolean delete(int id){
        boolean resultado = false;
        Optional<Category> category = repositorio.findById(id);

        if(category.isPresent()){
            repositorio.delete(category.get());
            resultado = true;
        }
        return resultado;
    }

}
