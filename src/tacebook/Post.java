
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tacebook;

import java.util.ArrayList;
import java.util.Date;

/**
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
     *
     * @param id
     * @param date
     * @param text
     * @param profileLikes
     * @param author
     * @param profile
     * @param comments
     */
    public Post(int id, Date date, String text, ArrayList<Profile> profileLikes, ArrayList<Profile> author, ArrayList<Profile> profile, ArrayList<Comment> comments) {
        this.id = id;
        this.date = date;
        this.text = text;
        this.profileLikes = profileLikes;
        this.author = author;
        this.profile = profile;
        this.comments = comments;
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
    public ArrayList<Profile> getProfileLikes() {
        return profileLikes;
    }

    /**
     *
     * @param profileLikes
     */
    public void setProfileLikes(ArrayList<Profile> profileLikes) {
        this.profileLikes = profileLikes;
    }

    /**
     *
     * @return
     */
    public ArrayList<Profile> getAuthor() {
        return author;
    }

    /**
     *
     * @param author
     */
    public void setAuthor(ArrayList<Profile> author) {
        this.author = author;
    }

    /**
     *
     * @return
     */
    public ArrayList<Profile> getProfile() {
        return profile;
    }

    /**
     *
     * @param profile
     */
    public void setProfile(ArrayList<Profile> profile) {
        this.profile = profile;
    }

    /**
     *
     * @return
     */
    public ArrayList<Comment> getComments() {
        return comments;
    }

    /**
     *
     * @param comments
     */
    public void setComments(ArrayList<Comment> comments) {
        this.comments = comments;
    }

}
