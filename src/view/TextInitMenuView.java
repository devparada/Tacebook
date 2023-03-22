/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import java.util.Scanner;
import controller.InitMenuController;
import java.util.NoSuchElementException;

/**
 *
 * Esta clase se encarga de aportar toda la información del programa, como
 * funciones y numeros que indican opciones para el usuario.
 *
 * @author Alejandro Martínez Domínguez, Bilo Alejandro Martins González y Raúl
 * Parada de la Fuente
 */
public class TextInitMenuView implements InitMenuView {

    /**
     * Mantiene la referencia al objecto controlador (InitMenuController)
     */
    private InitMenuController initMenuController;

    /**
     *
     * Este es el constructor de la clase TextInitMenuView
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
    @Override
    public boolean showLoginMenu() {
        String username, password;
        Scanner scanner = new Scanner(System.in);

        int select = 0;

        do {
            System.out.println("VERSION TEXTO");
            System.out.println("[ Bienvenido al Tacebook ]");
            System.out.println("Escolle unha opcion:");
            System.out.println("1. Iniciar sesion");
            System.out.println("2. Crear un novo perfil");
            System.out.println("3. Sair da aplicacion");

            select = readNumber(scanner);

            if (select < 1 || select > 3) {
                System.out.println("Debes introducir un numero de 1 a 3");
                System.out.println("\n");
                System.out.println("\n");
            }
        } while (select < 1 || select > 3);

        switch (select) {
            case 1:
                System.out.println("Introduce o nome do usuario:");
                username = scanner.nextLine();
                System.out.println("Introduce a contrasinal:");
                if (System.console() != null) {
                    password = new String(System.console().readPassword());
                } else {
                    password = scanner.nextLine();
                }
                this.initMenuController.login(username, password);
                break;
            case 2:
                this.initMenuController.register();
                break;
            case 3:
                return true;
        }

        return false;
    }

    /**
     * Este método se encargará de avisar cuando los datos introducidos son
     * incorrectos
     */
    @Override
    public void showLoginErrorMessage() {
        System.out.println("Usuario o contrasinal incorrecto");
    }

    /**
     * Este método saca por pantalla el menú para registrarse, con opciones de
     * poner usuario y contraseña
     */
    @Override
    public void showRegisterMenu() {
        Scanner scan = new Scanner(System.in);

        String username;
        String password;
        String confirmPassword;

        System.out.println("Introduce o nome de usuario que desexa crear:");
        username = scan.nextLine();
        do {
            System.out.println("Introduce o contrasinal:");
            password = scan.nextLine();
            System.out.println("Confirme o contrasinal:");
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
     * otra vez
     *
     * @return Devuelve el nombre introducido por el usuario
     */
    @Override
    public String showNewNameMenu() {
        Scanner scan = new Scanner(System.in);

        System.out.println("O nome introducido xa esta en uso");
        System.out.println("Introduce outro nome: ");
        String result = scan.next();
        return result;
    }

    /**
     * Este método muestra un error de conexión con el almacen de datos
     */
    @Override
    public void showConnectionErrorMessage() {
        System.out.println("Erro na conexion co almacen de datos!");
    }

    /**
     * Este método muestra un error de lectura de datos
     */
    @Override
    public void showReadErrorMessage() {
        System.out.println("Erro na lectura de datos!");
    }

    /**
     * Este método muestra un error de escritura de los datos
     */
    @Override
    public void showWriteErrorMessage() {
        System.out.println("Erro na escritura dos datos!");
    }

    /**
     * Este método lee un numero y si no es un numero se vuelve a llamar a sí
     * mismo
     *
     * @param scanner el scanner que se utiliza
     * @return Devuelve un número una vez comprobado que es un número
     */
    private int readNumber(Scanner scanner) {
        int number;
        try {
            number = scanner.nextInt();
            scanner.nextLine();
        } catch (NoSuchElementException e) {
            System.out.println("Debes introducir un numero");
            scanner = new Scanner(System.in);
            return readNumber(scanner); // Llamada recursiva para leer nuevamente
        }
        return number;
    }

}
