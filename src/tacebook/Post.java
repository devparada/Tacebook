
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tacebook;

import java.util.ArrayList;
import java.util.Date;

/**
 * Esta clase guardará todos los atributos y métodos que se relacionan con los
 * posts.
 *
 * @author Alejandro Martínez Domínguez, Bilo Alejandro Martins González y Raúl
 * Parada de la Fuente
 */
public class Post {

    private int id;
    private Date date;
    private String text;
    private ArrayList<Profile> profileLikes;
    private ArrayList<Profile> author;
    private ArrayList<Profile> profile;
    private ArrayList<Comment> comments;

    /**
     * Este es el constructor de la clase Post
     *
     * @param id
     * @param date
     * @param text
     */
    public Post(int id, Date date, String text) {
        this.id = id;
        this.date = date;
        this.text = text;
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
     * Getter de ProfileLikes
     *
     * @return
     */
    public ArrayList<Profile> getProfileLikes() {
        return profileLikes;
    }

    /**
     * Setter de ProfileLikes
     *
     * @param profileLikes
     */
    public void setProfileLikes(ArrayList<Profile> profileLikes) {
        this.profileLikes = profileLikes;
    }

    /**
     * Array list profile que guarda los autores (perfiles que publicaron el
     * post)
     *
     * @return author
     */
    public ArrayList<Profile> getAuthor() {
        return author;
    }

    /**
     * Setter de author
     *
     * @param author
     */
    public void setAuthor(ArrayList<Profile> author) {
        this.author = author;
    }

    /**
     * Array list profile que recibe el perfil de los autores.
     *
     * @return
     */
    public ArrayList<Profile> getProfile() {
        return profile;
    }

    /**
     * Setter de profile
     *
     * @param profile
     */
    public void setProfile(ArrayList<Profile> profile) {
        this.profile = profile;
    }

    /**
     * Getter de comments
     *
     * @return
     */
    public ArrayList<Comment> getComments() {
        return comments;
    }

    /**
     * Setter de coments
     *
     * @param comments
     */
    public void setComments(ArrayList<Comment> comments) {
        this.comments = comments;
    }

}
