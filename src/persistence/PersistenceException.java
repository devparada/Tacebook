/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistence;

/**
 *
 * @author Bilo Alejandro Martins Gonzalez
 */
public class PersistenceException extends Exception {

    private int code;
    public static final int CONECTION_ERROR = 0;
    public static final int CANNOT_READ = 1;
    public static final int CANNOT_WRITE = 2;

    public PersistenceException(int code, String message) {
        super(message);
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

}
