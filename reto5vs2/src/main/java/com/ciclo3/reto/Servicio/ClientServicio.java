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
import com.ciclo3.reto.Repositorio.ClientRepositorio;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ClientServicio {
    private ClientRepositorio repositorio;

    public ClientServicio(ClientRepositorio repositorio){
        this.repositorio = repositorio;
    }

    public List<Client> listaClient() {
        return (List<Client>) repositorio.findAll();
    }

    public Optional<Client> buscarClient(int id){
        return repositorio.findById(id);
    }

    public Client GuardarClient(Client client){
        if(client.getIdClient() == null){
            return repositorio.save(client);
        }
        else{
            return client;
        }
    }

    //Actualiza Client
    public Client update(Client client) {
        if (client.getIdClient() != null) {
            Optional<Client> infoRegistro = repositorio.findById(client.getIdClient());
            if (infoRegistro.isPresent()) {

                if (client.getName() != null) {
                    infoRegistro.get().setName(client.getName());
                }

                if (client.getEmail() != null) {
                    infoRegistro.get().setEmail(client.getEmail());
                }

                if (client.getPassword() != null) {
                    infoRegistro.get().setPassword(client.getPassword());
                }

                if (client.getAge() != null) {
                    infoRegistro.get().setAge(client.getAge());
                }

                repositorio.save(infoRegistro.get());
                return infoRegistro.get();
            } else {
                return client;
            }
        } else {
            return client;
        }
    }

    //Borrar
    public boolean delete(int id){
        boolean resultado = false;
        Optional<Client> client = repositorio.findById(id);

        if(client.isPresent()){
            repositorio.delete(client.get());
            resultado = true;
        }
        return resultado;
    }
}
