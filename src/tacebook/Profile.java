/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tacebook;

import java.util.ArrayList;

/**
 *
 * @author Alejandro Martínez Domínguez, Bilo Alejandro Martins González y Raúl
 * Parada de la Fuente
 */
public class Profile {

    private String name;
    private String password;
    private String status;
    private ArrayList<Post> posts = new ArrayList<>();
    private ArrayList<Message> messages = new ArrayList<>();
    private ArrayList<Profile> friends = new ArrayList<>();
    private ArrayList<Profile> friendshipRequests = new ArrayList<>();

    /**
     * Constructor de la clase profile
     *
     * @param name
     * @param password
     * @param status
     */
    public Profile(String name, String password, String status) {
        this.name = name;
        this.password = password;
        this.status = status;
    }

    /**
     * Método getter de name
     *
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * Setter de name
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * getter de password
     *
     * @return
     */
    public String getPassword() {
        return password;
    }

    /**
     * setter de pasword
     *
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * getter de status
     *
     * @return
     */
    public String getStatus() {
        return status;
    }

    /**
     * setter de status
     *
     * @param status
     */
    public void setStatus(String status) {
        this.status = status;
    }

}
