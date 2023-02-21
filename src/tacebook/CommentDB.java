/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tacebook;

/**
 *
 * @author Alejandro Martínez Domínguez, Bilo Alejandro Martins González y Raúl
 * Parada de la Fuente
 */
public class CommentDB {  
    /**
     *
     * @param comment
     */
    public static void save(Comment comment){
        //Seguramente esto necesite un cambio/mejora, tener esto en cuenta!!
        comment.getPost().get(0).getComments().add(0, comment);
    }
    
}
