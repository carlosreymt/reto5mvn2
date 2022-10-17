package com.ciclo3.reto.Servicio;

/*
 * @Author
 * Juan Diego Arenas Cuellar	juan.arenas.mt@usa.edu.co
 * Carlos Alberto Rey Ardila	carlos.rey.mt@usa.edu.co
 * Edgar Mauricio Abaunza Pinzon	edgar.abaunza.mt@usa.edu.co
 * Darly Fernanda Sandoval Plazas	darly.sandoval.mt@usa.edu.co
 * Adriana Feo Osma	adriana.feo.mt@usa.edu.co
 */

import com.ciclo3.reto.Entidades.Lib;
import com.ciclo3.reto.Repositorio.LibRepositorio;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class LibServicio {
    private LibRepositorio repositorio;

    public LibServicio(LibRepositorio repositorio){this.repositorio = repositorio;}

    public List<Lib> listaLib(){
        return (List<Lib>) repositorio.findAll();
    }

    public Optional<Lib> buscarLib(int id){
        return repositorio.findById(id);
    }

    public Lib GuardarLib(Lib lib){
        if(lib.getId() == null){
            return repositorio.save(lib);
        }
        else{
            return lib;
        }
    }

    //Reto 4
    //Actualizar
    public Lib update(Lib lib){
        if(lib.getId() != null)
        {
            Optional<Lib> infoRegistro = repositorio.findById(lib.getId());
            if(infoRegistro.isPresent()){

                if(lib.getTarget() != null){
                    infoRegistro.get().setTarget(lib.getTarget());
                }

                if(lib.getName() != null){
                    infoRegistro.get().setName(lib.getName());
                }

                if(lib.getDescription() != null){
                    infoRegistro.get().setDescription(lib.getDescription());
                }

                if(lib.getCapacity() != null){
                    infoRegistro.get().setCapacity(lib.getCapacity());
                }

                repositorio.save(infoRegistro.get());
                return infoRegistro.get();
            }
            else {
                return lib;
            }
        }
        else {
            return lib;
        }
    }


    //Borrar
    public boolean delete(int id){
        boolean resultado = false;
        Optional<Lib> lib = repositorio.findById(id);

        if(lib.isPresent()){
            repositorio.delete(lib.get());
            resultado = true;
        }
        return resultado;
    }
}
