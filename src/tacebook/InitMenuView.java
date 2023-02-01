/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tacebook;

import java.util.Scanner;

/**
 *
 * @author Alejandro Martínez Domínguez, Bilo Alejandro Martins González y Raúl
 * Parada de la Fuente
 */
public class InitMenuView {

    private InitMenuController initMenuController;

    public InitMenuView(InitMenuController initMenuController) {
        this.initMenuController = initMenuController;
    }

    /**
     *
     * @return
     */
    public boolean showLoginMenu() {
        Scanner scan = new Scanner(System.in);

        String username;
        String password;

        int select;

        do {
            System.out.println("1. Iniciar sesion");
            System.out.println("2. Registrarse");
            System.out.println("3. Sair da aplicacion");
            select = scan.nextInt();
            scan.nextLine();
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
                return true;
        }

        return false;
    }

    // !!
    /**
     *
     */
    public void showLoginErrorMessage() {
        System.out.println("Usuario o contrasinal incorrecto");
    }

    // !!
    /**
     *
     */
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

        initMenuController.createProfile(username, password, status);
    }

    /*
    Este método falla la verificación if falta por completar está incompleto este método.
     */
    /**
     *
     * @return
     */
    public String showNewNameMenu() {
        Scanner scan = new Scanner(System.in);

        String result = "";
        
        for (int i = 0; i < TacebookDB.getProfiles().size(); i++) {
            if ("S".equals(TacebookDB.getProfiles().get(i).getName())) {
                System.out.println("O nome introducido xa está en uso");
                System.out.println("Introduce outre nome: ");
                result = scan.next();
                return result;
            }
        }
    return result;
    }
}
