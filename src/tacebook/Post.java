
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tacebook;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Bilo Alejandro Martins González y Raúl Parada de la Fuente
 */
public class Post {

    private int id;
    private Date date;
    private String text;
    private ArrayList<Profile> profileLikes;
    private ArrayList<Profile> author;
    private ArrayList<Profile> profile;
    private ArrayList<Comment> comments;

    public Post(int id, Date date, String text, ArrayList<Profile> profileLikes, ArrayList<Profile> author, ArrayList<Profile> profile, ArrayList<Comment> comments) {
        this.id = id;
        this.date = date;
        this.text = text;
        this.profileLikes = profileLikes;
        this.author = author;
        this.profile = profile;
        this.comments = comments;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public ArrayList<Profile> getProfileLikes() {
        return profileLikes;
    }

    public void setProfileLikes(ArrayList<Profile> profileLikes) {
        this.profileLikes = profileLikes;
    }

    public ArrayList<Profile> getAuthor() {
        return author;
    }

    public void setAuthor(ArrayList<Profile> author) {
        this.author = author;
    }

    public ArrayList<Profile> getProfile() {
        return profile;
    }

    public void setProfile(ArrayList<Profile> profile) {
        this.profile = profile;
    }

    public ArrayList<Comment> getComments() {
        return comments;
    }

    public void setComments(ArrayList<Comment> comments) {
        this.comments = comments;
    }

}
