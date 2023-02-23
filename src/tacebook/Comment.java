/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tacebook;

import java.util.ArrayList;
import java.util.Date;

/**
 * Esta es la clase Comment, que guardará todos los datos relacionados a
 * comentarios.
 *
 * @author Alejandro Martínez Domínguez, Bilo Alejandro Martins González y Raúl
 * Parada de la Fuente
 */
public class Comment {

    private int id;
    private Date date;
    private String text;
    private ArrayList<Profile> sourceProfile;
    private ArrayList<Post> post;

    /**
     * Este es el constructor de la clase Comment
     *
     * @param id
     * @param date
     * @param text
     */
    public Comment(int id, Date date, String text) {
        this.id = id;
        this.date = date;
        this.text = text;
        sourceProfile = new ArrayList<>();
        post = new ArrayList<>();
    }

    /**
     * Getter de id
     *
     * @return
     */
    public int getId() {
        return id;
    }

    /**
     * Setter de id
     *
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Getter de date
     *
     * @return
     */
    public Date getDate() {
        return date;
    }

    /**
     * Setter de date
     *
     * @param date
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * Getter de text
     *
     * @return
     */
    public String getText() {
        return text;
    }

    /**
     * Setter de text
     *
     * @param text
     */
    public void setText(String text) {
        this.text = text;
    }

    /**
     * Getter de sourceProfile
     *
     * @return
     */
    public ArrayList<Profile> getSourceProfile() {
        return sourceProfile;
    }

    /**
     * Setter de sourceProfile
     *
     * @param sourceProfile
     */
    public void setSourceProfile(ArrayList<Profile> sourceProfile) {
        this.sourceProfile = sourceProfile;
    }

    /**
     * Getter de post
     *
     * @return
     */
    public ArrayList<Post> getPost() {
        return post;
    }

    /**
     * Setter de post
     *
     * @param post
     */
    public void setPost(ArrayList<Post> post) {
        this.post = post;
    }

}
