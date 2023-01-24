/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tacebook;

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

        String username;
        String password;

        int select;

        do {
            System.out.println("1.");
            System.out.println("2");
            System.out.println("3");
            select = scan.nextInt();
        } while (select > 3);

        switch (select) {
            case 1:
                System.out.println("Usuario");
                username = scan.nextLine();
                System.out.println("Contrasinal");
                password = scan.nextLine();
                initMenuController.login(username, password);
                break;
            case 2:
                showRegisterMenu();
                break;
            case 3:
                System.out.println("Queres sair da aplicacion:");
                char option = scan.nextLine().toLowerCase().charAt(0);

                if (option == 'S') {
                    return true;
                }
                break;
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
