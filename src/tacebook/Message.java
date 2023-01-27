/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tacebook;

import java.util.Date;

/**
 *
 * @author Alejandro Martínez Domínguez, Bilo Alejandro Martins González y Raúl
 * Parada de la Fuente
 */
public class Message {

    private int id;
    private String text;
    private Date date;
    private boolean read;

    /**
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
    public boolean isRead() {
        return read;
    }

    /**
     *
     * @param read
     */
    public void setRead(boolean read) {
        this.read = read;
    }

}
