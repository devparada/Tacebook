/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistence;

import model.Message;

/**
 * Esta clase almacena y elimina un mensaje de la lista de mensajes del perfil
 * de destino
 *
 * @author Alejandro Martínez Domínguez, Bilo Alejandro Martins González y Raúl
 * Parada de la Fuente
 */
public class MessageDB {

    /**
     * Este método añade al perfil destino el ArrayList, y pone el message en
     * primera posición de modo que se vea primero los mensajes más recientes
     *
     * @param message el mensaje que se almacena
     * @throws persistence.PersistenceException
     */
    public static void save(Message message) throws PersistenceException{
        message.getDestProfile().getMessages().add(0, message);
    }

    /**
     * Este método actualiza los mensajes
     *
     * @param message el mensaje que se actualiza
     * @throws persistence.PersistenceException
     */
    public static void update(Message message) throws PersistenceException{
        // De momento este método non fai nada
    }

    /**
     * Este método elimina el mensaje del perfil destino
     *
     * @param message el mensaje que se elimina
     * @throws persistence.PersistenceException
     */
    public static void remove(Message message) throws PersistenceException{
        message.getDestProfile().getMessages().remove(message);
    }
}
