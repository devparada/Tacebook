/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistence;

import model.Comment;

/**
 *
 * Esta clase almacena un comentario de la lista de comentarios del post de
 * destino
 *
 * @author Alejandro Martínez Domínguez, Bilo Alejandro Martins González y Raúl
 * Parada de la Fuente
 */
public class CommentDB {

    /**
     * Este método guarda el comentario añadiendolo al arraylist de comentarios,
     * haciendo primero un target al post, luego añadiendo al arraylist.
     *
     * @param comment
     * @throws persistence.PersistenceException
     */
    public static void save(Comment comment) throws PersistenceException {
        comment.getPost().getComments().add(0, comment);
    }
}
