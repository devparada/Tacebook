/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Date;

/**
 *
 * Esta clase guardará todos los mensajes y metodos que se relacionen con los
 * mensajes
 *
 * @author Alejandro Martínez Domínguez, Bilo Alejandro Martins González y Raúl
 * Parada de la Fuente
 */
public class Message {

    private int id;
    private String text;
    private Date date;
    private boolean read;
    private Profile sourceProfile;
    private Profile destProfile;

    /**
     * Constructor de la clase Message
     *
     * @param id
     * @param text
     * @param date
     * @param read
     * @param sourceProfile
     * @param destProfile
     */
    public Message(int id, String text, Date date, boolean read, Profile sourceProfile, Profile destProfile) {
        this.id = id;
        this.text = text;
        this.date = date;
        this.read = read;
        this.sourceProfile = sourceProfile;
        this.destProfile = destProfile;
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
     * Getter del booleano read que comprueba si el usuario ha visto el post
     *
     * @return
     */
    public boolean isRead() {
        return read;
    }

    /**
     * Setter del booleano read para definir si lo ha leído o no
     *
     * @param read
     */
    public void setRead(boolean read) {
        this.read = read;
    }

    /**
     * Getter de sourceProfile
     *
     * @return
     */
    public Profile getSourceProfile() {
        return sourceProfile;
    }

    /**
     * Setter de sourceProfile
     *
     * @param sourceProfile
     */
    public void setSourceProfile(Profile sourceProfile) {
        this.sourceProfile = sourceProfile;
    }

    /**
     * Getter de destProfile
     *
     * @return
     */
    public Profile getDestProfile() {
        return destProfile;
    }

    /**
     * Setter de destProfile
     *
     * @param destProfile
     */
    public void setDestProfile(Profile destProfile) {
        this.destProfile = destProfile;
    }

}
