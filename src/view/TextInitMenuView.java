/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import java.util.Scanner;
import controller.InitMenuController;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;

/**
 * Esta clase se encarga de aportar toda la información del programa, como
 * funciones y numeros que indican opciones para el usuario.
 *
 * @author Alejandro Martínez Domínguez, Bilo Alejandro Martins González y Raúl
 * Parada de la Fuente
 */
public class TextInitMenuView {

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
    public TextInitMenuView(InitMenuController initMenuController) {
        this.initMenuController = initMenuController;
    }

    /**
     * Este método enseña las opciones de login de usuario para que pueda
     * conectarse, registrar o salir de la aplicación.
     *
     * @return
     */
    public boolean showLoginMenu() {
        String username, password;
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("VERSION TEXTO");
        System.out.println("[ Bienvenido al Tacebook ]");
        System.out.println("Escolle unha opción:");
        System.out.println("1. Iniciar sesión");
        System.out.println("2. Crear un novo perfil");
        System.out.println("3. Saír da aplicación");

        int select = readNumber(scanner);
        switch (select) {

            case 1:
                System.out.println("Introduce o nome do usuario:");
                username = scanner.nextLine();
                if (System.console() != null) {
                    password = new String(System.console().readPassword());
                } else {
                    password = scanner.nextLine();
                }
                this.initMenuController.login(username, password);
                return true;

            case 2:
                this.initMenuController.register();
                return true;

            case 3:
                return true;
        }
        if (select != 1 || select != 2 || select != 3) {
            System.out.println("Debes introducir un numero de 1 a 3");
            System.out.println("\n");
            System.out.println("\n");
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

        System.out.println("Introduce o nome de usuario que desexa crear");
        username = scan.nextLine();
        do {
            System.out.println("Introduce o contrasinal");
            password = scan.nextLine();
            System.out.println("Confirme Contrasinal");
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

    private int readNumber(Scanner scanner) {
        try {
            int number = scanner.nextInt();;
            scanner.nextLine();
            return number;
        } catch (NoSuchElementException e) {
            System.out.println("Debe introducir un número.");
            scanner.nextLine(); // Ler a nova linha pendente
            return readNumber(scanner); // Chamada recursiva para ler novamente
        }
    }

    public void showConnectionErrorMessage() {
        System.out.println("Erro na conexión co almacén de datos!");
    }

    public void showReadErrorMessage() {
        System.out.println("Erro na lectura de datos!");
    }

    public void showWriteErrorMessage() {
        System.out.println("Erro na escritura dos datos!");
    }
}
