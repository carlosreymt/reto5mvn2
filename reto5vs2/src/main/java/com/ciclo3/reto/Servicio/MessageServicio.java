package com.ciclo3.reto.Servicio;

/*
  @Author
 * Juan Diego Arenas Cuellar	juan.arenas.mt@usa.edu.co
 * Carlos Alberto Rey Ardila	carlos.rey.mt@usa.edu.co
 * Edgar Mauricio Abaunza Pinzon	edgar.abaunza.mt@usa.edu.co
 * Darly Fernanda Sandoval Plazas	darly.sandoval.mt@usa.edu.co
 * Adriana Feo Osma	adriana.feo.mt@usa.edu.co
 */

import com.ciclo3.reto.Entidades.Message;
import com.ciclo3.reto.Repositorio.MessageRepositorio;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class MessageServicio {
    private MessageRepositorio repositorio;

    public MessageServicio(MessageRepositorio repositorio){
        this.repositorio = repositorio;
    }

    public List<Message> listaMessage(){
        return (List<Message>) repositorio.findAll();
    }

    public Optional<Message> buscarMessage(int id){
        return repositorio.findById(id);
    }

    public Message GuardarMessage(Message message){
        if(message.getIdMessage() == null){
            return repositorio.save(message);
        }
        else{
            return message;
        }
    }

    //Reto 4
    public Message update(Message message){
        if(message.getIdMessage() != null)
        {
            Optional<Message> infoRegistro = repositorio.findById(message.getIdMessage());
            if(infoRegistro.isPresent()){

                if(message.getMessageText() != null){
                    infoRegistro.get().setMessageText(message.getMessageText());
                }

                repositorio.save(infoRegistro.get());
                return infoRegistro.get();
            }
            else {
                return message;
            }
        }
        else {
            return message;
        }
    }

    //Borrar
    public boolean delete(int id){
        boolean resultado = false;
        Optional<Message> message = repositorio.findById(id);

        if(message.isPresent()){
            repositorio.delete(message.get());
            resultado = true;
        }
        return resultado;
    }
}
