/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import view.TextInitMenuView;
import persistence.ProfileDB;
import model.Profile;
import persistence.PersistenceException;
import view.GUIInitMenuView;
import view.InitMenuView;

/**
 *
 * Esta clase tendrá el método main para hacer la llamada al menú, cuidará de
 * toda la parte de funcionabilidad, para que todos los botones con numeros y
 * opciones funcionen como deben.
 *
 * @author Alejandro Martínez Domínguez, Bilo Alejandro Martins González y Raúl
 * Parada de la Fuente
 */
public class InitMenuController {

    /**
     * Mantiene la referencia al objecto vista (initMenuView)
     */
    private InitMenuView initMenuView;
    /**
     * Booleano que es true si está en modo texto y false si está en modo GUI
     */
    private boolean textMode;

    /**
     * Constructor da clase InitMenuController
     *
     * @param textMode
     */
    public InitMenuController(boolean textMode) {
        this.textMode = textMode;
        if (textMode) {
            this.initMenuView = (InitMenuView) new TextInitMenuView(this);
        } else {
            this.initMenuView = (InitMenuView) new GUIInitMenuView(this);
        }
    }

    /**
     * Este método inicia el programa llamando al metodo que saca el menu por
     * pantalla
     */
    private void init() {
        this.initMenuView.showLoginMenu();
    }

    /**
     * Este método crea un objeto de la clase ProfileController y intentará
     * iniciar sesión con usuário y contraseña y buscará si hay algun perfil
     * registrado
     *
     * @param name
     * @param password
     */
    public void login(String name, String password) {
        try {
            ProfileController profileController = new ProfileController(this.textMode);
            Profile profile = ProfileDB.findByNameAndPassword(name, password, profileController.getPostsShowed());
            if (profile == null) {
                this.initMenuView.showLoginErrorMessage();
            } else {
                profileController.openSession(profile);
            }
        } catch (PersistenceException ex) {
            this.proccessPersistenceException(ex);
        }
        this.initMenuView.showLoginMenu();
    }

    /**
     * Este método llama al modelo de vista para sacar por pantalla las opciones
     * de registrar una nueva cuenta
     */
    public void register() {
        initMenuView.showRegisterMenu();
    }

    /**
     * Este es el método que realizará en registro de un nuevo perfil en la
     * aplicación
     *
     * @param name
     * @param password
     * @param status
     */
    public void createProfile(String name, String password, String status) {
        try {
            Profile exactProfile;
            do {
                if ((exactProfile = ProfileDB.findByName(name, 0)) == null) {
                    continue;
                }
                name = this.initMenuView.showNewNameMenu();
            } while (exactProfile != null);
            Profile newProfile = new Profile(name, password, status);
            ProfileDB.save(newProfile);
            new ProfileController(this.textMode).openSession(newProfile);
        } catch (PersistenceException ex) {
            this.proccessPersistenceException(ex);
        }
        this.initMenuView.showLoginMenu();

//        try {
//            Profile exactProfile;
//            do {
//                if (exactProfile) {
//                    
//                }
//            // Comprobamos que o nome non estea repetido
//            while (ProfileDB.findByName(name, 0) != null) {
//                name = initMenuView.showNewNameMenu();
//            }
//
//            // Creamos o perfil e gardamos
//            Profile profile = new Profile(name, password, status);
//            ProfileDB.save(profile);
//
//            // Abrimos a sesion do usuario
//            ProfileController profileController = new ProfileController(textMode);
//            profileController.openSession(profile);
//        } catch (PersistenceException e) {
//            proccessPersistenceException(e);
//
//        }
    }

    /**
     * Este es el método main
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        boolean textMode = (args.length == 1 && args[0].equals("text"));
        InitMenuController initMenuController = new InitMenuController(textMode);
        initMenuController.init();
    }

    /**
     * Este método procesa una excepción de persistencia en función del código
     * de excepción
     *
     * @param e la excepción
     */
    private void proccessPersistenceException(PersistenceException e) {
        /*
        Como tenemos 3 tipos de errores, lo mas adecuado es utilizar un switch
        para poder controlar cada situación, ademas, es necesario el uso de 
        switch porque lo que hace la llamada a cada uno de estos 3 metodos es 
        atributo "code", que se utiliza como identificador para cada uno de ellos
         */
        switch (e.getCode()) {

            // Identificador del método showConnectionErrorMessage
            case 0:
                this.initMenuView.showConnectionErrorMessage();
                break;

            // Identificador del método showReadErrorMessage
            case 1:
                this.initMenuView.showReadErrorMessage();
                break;

            // Identificador del método showWriteErrorMessage
            case 2:
                this.initMenuView.showWriteErrorMessage();
                break;
        }
    }

}
