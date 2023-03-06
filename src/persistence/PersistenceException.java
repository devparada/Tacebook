/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistence;

/**
 *
 * Esta clase extiende de Exception y representa una excepción que se puede
 * producir en una operación de persistencia
 *
 * @author Alejandro Martínez Domínguez, Bilo Alejandro Martins González y Raúl
 * Parada de la Fuente
 */
public class PersistenceException extends Exception {

    private int code;
    public static final int CONECTION_ERROR = 0;
    public static final int CANNOT_READ = 1;
    public static final int CANNOT_WRITE = 2;

    /**
     * Constructor de la clase PersistenceException
     *
     * @param message
     * @param code
     */
    public PersistenceException(String message, int code) {
        super(message);
        this.code = code;
    }

    /**
     * Getter de code
     *
     * @return
     */
    public int getCode() {
        return code;
    }

    /**
     * Setter de code
     *
     * @param code
     */
    public void setCode(int code) {
        this.code = code;
    }

}
