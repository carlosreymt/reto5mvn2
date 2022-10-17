package com.ciclo3.reto.Servicio;

/*
 * @Author
 * Juan Diego Arenas Cuellar	juan.arenas.mt@usa.edu.co
 * Carlos Alberto Rey Ardila	carlos.rey.mt@usa.edu.co
 * Edgar Mauricio Abaunza Pinzon	edgar.abaunza.mt@usa.edu.co
 * Darly Fernanda Sandoval Plazas	darly.sandoval.mt@usa.edu.co
 * Adriana Feo Osma	adriana.feo.mt@usa.edu.co
 */

import com.ciclo3.reto.Entidades.Admin;
import com.ciclo3.reto.Repositorio.AdminRepositorio;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class AdminServicio {
    private AdminRepositorio repositorio;

    public AdminServicio(AdminRepositorio repositorio){
        this.repositorio = repositorio;
    }

    public List<Admin> listaAdmin(){
        return (List<Admin>) repositorio.findAll();
    }

    public Optional<Admin> buscarAdmin(int id){
        return repositorio.findById(id);
    }

    public Admin GuardarAdmin(Admin admin){
        if(admin.getIdAdmin() == null){
            return repositorio.save(admin);
        }
        else{
            return admin;
        }
    }

    //Reto4
    //Actualizar
    public Admin update(Admin admin){
        if(admin.getIdAdmin() != null)
        {
            Optional<Admin> infoRegistro = repositorio.findById(admin.getIdAdmin());
            if(infoRegistro.isPresent()){

                if(admin.getEmail() != null){
                    infoRegistro.get().setEmail(admin.getEmail());
                }

                if(admin.getPassword() != null){
                    infoRegistro.get().setPassword(admin.getPassword());
                }

                if(admin.getName() != null){
                    infoRegistro.get().setName(admin.getName());
                }

                repositorio.save(infoRegistro.get());
                return infoRegistro.get();
            }
            else {
                return admin;
            }
        }
        else {
            return admin;
        }
    }

    //Borrar
    public boolean delete(int id){
        boolean resultado = false;
        Optional<Admin> admin = repositorio.findById(id);

        if(admin.isPresent()){
            repositorio.delete(admin.get());
            resultado = true;
        }
        return resultado;
    }


}
