/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tacebook;

import java.util.ArrayList;
import java.util.Date;

/**
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
     *
     * @param id
     * @param date
     * @param text
     * @param sourceProfile
     * @param post
     */
    public Comment(int id, Date date, String text, ArrayList<Profile> sourceProfile, ArrayList<Post> post) {
        this.id = id;
        this.date = date;
        this.text = text;
        this.sourceProfile = sourceProfile;
        this.post = post;
    }

    /**
     *
     * @return
     */
    public int getId() {
        return id;
    }

    /**
     *
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     *
     * @return
     */
    public Date getDate() {
        return date;
    }

    /**
     *
     * @param date
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     *
     * @return
     */
    public String getText() {
        return text;
    }

    /**
     *
     * @param text
     */
    public void setText(String text) {
        this.text = text;
    }

    /**
     *
     * @return
     */
    public ArrayList<Profile> getSourceProfile() {
        return sourceProfile;
    }

    /**
     *
     * @param sourceProfile
     */
    public void setSourceProfile(ArrayList<Profile> sourceProfile) {
        this.sourceProfile = sourceProfile;
    }

    /**
     *
     * @return
     */
    public ArrayList<Post> getPost() {
        return post;
    }

    /**
     *
     * @param post
     */
    public void setPost(ArrayList<Post> post) {
        this.post = post;
    }

}
