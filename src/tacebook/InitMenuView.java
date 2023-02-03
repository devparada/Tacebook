/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tacebook;

import java.util.Scanner;

/**
 * Esta clase se encarga de aportar toda la información del programa, como
 * funciones y numeros que indican opciones para el usuario.
 *
 * @author Alejandro Martínez Domínguez, Bilo Alejandro Martins González y Raúl
 * Parada de la Fuente
 */
public class InitMenuView {

    private InitMenuController initMenuController;

    /**
     *
     * @param initMenuController
     */
    public InitMenuView(InitMenuController initMenuController) {
        this.initMenuController = initMenuController;
    }

    /**
     * Este método enseña las opciones de login de usuario para que pueda
     * conectarse, registrar o salir de la aplicación.
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

    /**
     * Este método se encargará de avisar cuando los datos introducidos son
     * incorrectos.
     */
    public void showLoginErrorMessage() {
        System.out.println("Usuario o contrasinal incorrecto");
    }

    /**
     * Este método saca por pantalla el menu para registrarse, con opciones de
     * poner usuario, contraseña.
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
            if (!password.equals(confirmPassword)) {
                System.out.println("As contrasinais non coinciden");
            }
        } while (!password.equals(confirmPassword));
        System.out.println("Estado:");
        String status = scan.nextLine();

        initMenuController.createProfile(username, password, status);
    }

    /**
     * Este método se encarga de mostrar un mensaje cuando se intentan crear una
     * cuonta con un usuario que ya está en uso, avisando y pidiendo los datos
     * otra vez.
     *
     * @return
     */
    public String showNewNameMenu() {
        Scanner scan = new Scanner(System.in);

        System.out.println("O nome introducido xa está en uso");
        System.out.println("Introduce outro nome: ");
        String result = scan.next();
        return result;
    }
}
