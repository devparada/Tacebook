/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tacebook;

import java.util.Locale;
import java.util.Scanner;

/**
 *
 * @author Bilo Alejandro Martins González y Raúl Parada de la Fuente
 */
public class InitMenuView {

    // !!
    public boolean showLoginMenu() {
        Scanner scan = new Scanner(System.in);
        InitMenuController initMenuController = new InitMenuController();

        System.out.println("Usuario");
        String username = scan.nextLine();
        System.out.println("Contrasinal");
        String password = scan.nextLine();

        initMenuController.login(username, password);
        initMenuController.register();

        System.out.println("Queres sair da aplicacion:");
        char option = scan.nextLine().toLowerCase().charAt(0);
        
        if (option == 'S') {
            return true;
        }

        return false;
    }

    // !!
    public void showLoginErrorMessage() {
        System.out.println("Usuario o contrasinal incorrecto");
    }

    // !!
    public void showRegisterMenu() {
        Scanner scan = new Scanner(System.in);

        String username;
        String password;
        String confirmPassword;

        System.out.println("Usuario");
        username = scan.nextLine();
        do {
            System.out.println("Contrasinal");
            password = scan.nextLine();
            System.out.println("Confirmar Contrasinal");
            confirmPassword = scan.nextLine();
        } while (!password.equals(confirmPassword));
        System.out.println("Estado:");
        String status = scan.nextLine();

        InitMenuController initMenuController = new InitMenuController();
        initMenuController.createProfile(username, password, status);
    }

    // !!
    public String showNewNameMenu() {
        return "";
    }
}
