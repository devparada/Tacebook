/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import java.util.Scanner;
import controller.InitMenuController;
import java.util.InputMismatchException;

/**
 * Esta clase se encarga de aportar toda la información del programa, como
 * funciones y numeros que indican opciones para el usuario.
 *
 * @author Alejandro Martínez Domínguez, Bilo Alejandro Martins González y Raúl
 * Parada de la Fuente
 */
public class InitMenuView {

    /**
     * Mantiene la referencia al objecto controlador (InitMenuController)
     */
    private InitMenuController initMenuController;

    /**
     *
     * Este es el constructor de la clase InitMenuView
     *
     * @param initMenuController mantiene la referencia al objecto controlador
     * (InitMenuController)
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
        System.out.println("Bienvenido al Tacebook");
        String username;
        String password;
        int select = 0;

        do {
            System.out.println("Menu principal");
            System.out.println("1. Iniciar sesion");
            System.out.println("2. Registrarse");
            System.out.println("3. Sair da aplicacion");
            //aqui queremos capturar un error para que el usuario introduzca
//            numeros, si el usuario no introduce ninguno de los numeros 
//                    informados o incluso si introduce una letra, capturamos 
//                            la excepcion avisando que los datos introducidos 
//                                    son incorrectos
            try {
                select = scan.nextInt();
                scan.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Debes introducir un numero de los indicados.");
                scan.nextLine(); // Limpia el búfer del escáner
                continue;
            }

            if (select != 1 || select != 2 || select != 3) {
                System.out.println("Debes introducir un numero de los indicados.");
                showLoginMenu();
            }
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
     * Este método saca por pantalla el menú para registrarse, con opciones de
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
     * @return Devuelve el nombre introducido por el usuario
     */
    public String showNewNameMenu() {
        Scanner scan = new Scanner(System.in);

        System.out.println("O nome introducido xa está en uso");
        System.out.println("Introduce outro nome: ");
        String result = scan.next();
        return result;
    }
}