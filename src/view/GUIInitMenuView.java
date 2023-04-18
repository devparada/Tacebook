/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import controller.InitMenuController;
import java.util.NoSuchElementException;
import java.util.Scanner;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * Esta clase hace lo mismo que TextInitMenuView pero mostrando en los menús el
 * texto "Versión GUI"
 *
 * @author Alejandro Martínez Domínguez, Bilo Alejandro Martins González y Raúl
 * Parada de la Fuente
 */
public class GUIInitMenuView implements InitMenuView {

    /**
     * Mantiene la referencia al objecto controlador (InitMenuController)
     */
    private InitMenuController initMenuController;

    /**
     *
     * Este es el constructor de la clase GUIInitMenuView
     *
     * @param initMenuController mantiene la referencia al objecto controlador
     * (InitMenuController)
     */
    public GUIInitMenuView(InitMenuController initMenuController) {
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
        JLabel lblUsuario = new JLabel("Usuario");
        JTextField txtUsuario = new JTextField();
        JLabel lblContrasena = new JLabel("Contraseña");
        JPasswordField txtContrasena = new JPasswordField();
        String[] options = {"Iniciar Sesión", "Rexistrarse", "Saír"};
        Object[] labelsOptions = {lblUsuario, txtUsuario, lblContrasena, txtContrasena};
        int seleccion = JOptionPane.showOptionDialog(null, labelsOptions, "Selector de opciones", 0, 2, null, options, options[0]);

        switch (seleccion) {
            //Iniciar sesion
            case 0:
                String name = txtUsuario.getText();
                String password = new String(txtContrasena.getPassword());
                initMenuController.login(name, password);
                break;

            //Rexistrarse    
            case 1:
                initMenuController.register();
                break;

            //Sair
            case 2:
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

        JLabel lblUsuario = new JLabel("Usuario");
        JTextField txtUsuario = new JTextField();
        JLabel lblContrasena = new JLabel("Contraseña");
        JPasswordField txtContrasena = new JPasswordField();
        JLabel lblConfCon = new JLabel("ConfCont");
        JTextField txtConfCon = new JTextField();
        JLabel lblEstado = new JLabel("Estado");
        JPasswordField txtEstado = new JPasswordField();
        String[] options = {"Iniciar Sesión", "Rexistrarse", "Saír"};
        Object[] labelsOptions = {lblUsuario, txtUsuario, lblContrasena, txtContrasena, lblConfCon, txtConfCon, lblEstado, txtEstado};
        int seleccion = JOptionPane.showOptionDialog(null, labelsOptions, "Selector de opciones", 0, 4, null, options, options[0]);
//        Scanner scan = new Scanner(System.in);
//
//        String username;
//        String password;
//        String confirmPassword;
//
//        System.out.println("Introduce o nome de usuario que desexa crear:");
//        username = scan.nextLine();
//        do {
//            System.out.println("Introduce o contrasinal:");
//            password = scan.nextLine();
//            System.out.println("Confirme o contrasinal:");
//            confirmPassword = scan.nextLine();
//            if (!password.equals(confirmPassword)) {
//                System.out.println("As contrasinais non coinciden");
//            }
//        } while (!password.equals(confirmPassword));
//        System.out.println("Estado:");
//        String status = scan.nextLine();
//
//        initMenuController.createProfile(username, password, status);
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
