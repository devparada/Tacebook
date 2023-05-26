/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import controller.InitMenuController;
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
     */
    @Override
    public void showLoginMenu() {
        JLabel lblUsuario = new JLabel("Usuario");
        JTextField txtUsuario = new JTextField();
        JLabel lblContrasena = new JLabel("Contraseña");
        JPasswordField txtContrasena = new JPasswordField();
        String[] options = {"Iniciar Sesión", "Rexistrarse", "Saír"};
        Object[] labelsOptions = {lblUsuario, txtUsuario, lblContrasena, txtContrasena};
        int seleccion = JOptionPane.showOptionDialog(null, labelsOptions, "Selector de opciones", 0, JOptionPane.WARNING_MESSAGE, null, options, null);
        switch (seleccion) {
            // Iniciar sesion
            case 0:
                String name = txtUsuario.getText();
                String password = new String(txtContrasena.getPassword());
                initMenuController.login(name, password);
                break;

            // Rexistrarse    
            case 1:
                initMenuController.register();
                break;

            // Saír
            case 2:
                break;
        }
    }

    /**
     * Este método se encargará de avisar cuando los datos introducidos son
     * incorrectos
     */
    @Override
    public void showLoginErrorMessage() {
        JOptionPane.showMessageDialog(null, "Usuario o contrasinal incorrecto");
    }

    /**
     * Este método saca por pantalla el menú para registrarse, con opciones de
     * poner usuario y contraseña
     */
    @Override
    public void showRegisterMenu() {
        //Aqui crearemos todo el tema del layout y interfaz
        JLabel lblUsuario = new JLabel("Nome de usuario");
        JTextField txtUsuario = new JTextField();
        JLabel lblContrasena = new JLabel("Contrasinal");
        JPasswordField txtContrasena = new JPasswordField();
        JLabel lblConfCon = new JLabel("Confirmar contrasinal");
        JPasswordField txtContrasenConfirmar = new JPasswordField();
        JLabel lblEstado = new JLabel("Estado");
        JTextField txtEstado = new JTextField();
        String[] options = {"Aceptar", "Cancelar"};
        Object[] labelsOptions = {lblUsuario, txtUsuario, lblContrasena, txtContrasena, lblConfCon, txtContrasenConfirmar, lblEstado, txtEstado};

        //Aqui ya empieza la parte lógica de verdad, con un sistema de confirmacion de contraseña.
        boolean passwordsMatch = false;
        while (!passwordsMatch) {
            int selectedOption = JOptionPane.showOptionDialog(null, labelsOptions, "Rexistrarse", -1, -1, null, options, null);
            if (selectedOption == 1) {
                showLoginMenu();
                return;
            }
            passwordsMatch = new String(txtContrasena.getPassword()).equals(new String(txtContrasenConfirmar.getPassword()));
            if (!passwordsMatch) {
                JOptionPane.showMessageDialog(null, "Os contrasinais non coinciden!", "Erro nos datos", JOptionPane.WARNING_MESSAGE);
            }
        }
        initMenuController.createProfile(txtUsuario.getText(), new String(txtContrasena.getPassword()), txtEstado.getText());
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
        JOptionPane.showMessageDialog(null, "Erro na conexion co almacen de datos!");
    }

    /**
     * Este método muestra un error de lectura de datos
     */
    @Override
    public void showReadErrorMessage() {
        JOptionPane.showMessageDialog(null, "Erro na lectura de datos!");

    }

    /**
     * Este método muestra un error de escritura de los datos
     */
    @Override
    public void showWriteErrorMessage() {
        JOptionPane.showMessageDialog(null, "Erro na escritura dos datos!");

    }
}
