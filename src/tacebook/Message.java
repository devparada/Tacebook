/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tacebook;

import java.util.Date;

/**
 * Esta clase guardará todos los mensajes y metodos que se relacionen con las
 * mensajes.
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
     * Este es el constructor de la clase Message
     *
     * @param id
     * @param text
     * @param date
     * @param read
     */
    public Message(int id, String text, Date date, boolean read) {
        this.id = id;
        this.text = text;
        this.date = date;
        this.read = read;
    }

    /**
     * getter de id
     *
     * @return
     */
    public int getId() {
        return id;
    }

    /**
     * setter de id
     *
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * getter de text
     *
     * @return
     */
    public String getText() {
        return text;
    }

    /**
     * setter de text
     *
     * @param text
     */
    public void setText(String text) {
        this.text = text;
    }

    /**
     * getter de date
     *
     * @return
     */
    public Date getDate() {
        return date;
    }

    /**
     * setter de date
     *
     * @param date
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * método booleano que comproueba si el usuario ha visto el post.
     *
     * @return
     */
    public boolean isRead() {
        return read;
    }

    /**
     * setter del metodo read para definir si lo ha leído o no.
     *
     * @param read
     */
    public void setRead(boolean read) {
        this.read = read;
    }

    public Profile getSourceProfile() {
        return sourceProfile;
    }

    public void setSourceProfile(Profile sourceProfile) {
        this.sourceProfile = sourceProfile;
    }

    public Profile getDestProfile() {
        return destProfile;
    }

    public void setDestProfile(Profile destProfile) {
        this.destProfile = destProfile;
    }

}
