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
public class Comment {

    private int id;
    private Date date;
    private String text;
    private ArrayList<Profile> sourceProfile;
    private ArrayList<Post> post;

    public Comment(int id, Date date, String text, ArrayList<Profile> sourceProfile, ArrayList<Post> post) {
        this.id = id;
        this.date = date;
        this.text = text;
        this.sourceProfile = sourceProfile;
        this.post = post;
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

    public ArrayList<Profile> getSourceProfile() {
        return sourceProfile;
    }

    public void setSourceProfile(ArrayList<Profile> sourceProfile) {
        this.sourceProfile = sourceProfile;
    }

    public ArrayList<Post> getPost() {
        return post;
    }

    public void setPost(ArrayList<Post> post) {
        this.post = post;
    }

}
