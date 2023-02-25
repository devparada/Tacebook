/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import view.TextInitMenuView;
import persistence.TacebookDB;
import persistence.ProfileDB;
import java.util.Date;
import model.Post;
import model.Profile;
import persistence.PersistenceException;

/**
 * Esta clase tendrá el método main para hacer la llamada al menú, cuidará de
 * toda la parte de funcionabilidad, para que todos los botones con numeros y
 * opciones funcionen como deben.
 *
 * @author Alejandro Martínez Domínguez, Bilo Alejandro Martins González y Raúl
 * Parada de la Fuente
 */
public class InitMenuController {
 
    private boolean textMode;

    public boolean isTextMode() {
        return textMode;
    }

    public void setTextMode(boolean textMode) {
        this.textMode = textMode;
    }

    private TextInitMenuView initMenuView = new TextInitMenuView(this);

    /**
     * Este método inicia el programa llamando al metodo que saca el menu por
     * pantalla
     */
    private void init() {
        do {
            initMenuView.showLoginMenu();
        } while (!initMenuView.showLoginMenu());
    }

    /**
     * Este método crea un objeto de la clase ProfileController y intentará
     * iniciar sesión con usuário y contraseña y buscará si hay algun perfil
     * registrado.
     *
     * @param name
     * @param password
     */
    public void login(String name, String password) {
        try {
            ProfileController profileController = new ProfileController(textMode);
            Profile profile = ProfileDB.findByNameAndPassword(name, password, profileController.getPostsShowed());

            if (profile == null) {
                initMenuView.showLoginErrorMessage();
            } else {
                System.out.println("Benvido unha vez mais a Tacebook!");
                profileController.openSession(profile);
            }
        } catch (PersistenceException e) {
            proccessPersistenceException(e);
        }
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
            // Comprobamos que o nome non estea repetido
            while (ProfileDB.findByName(name, 0) != null) {
                name = initMenuView.showNewNameMenu();
            }

            // Creamos o perfil e gardamos
            Profile profile = new Profile(name, password, status);
            ProfileDB.save(profile);

            // Abrimos a sesion do usuario
            ProfileController profileController = new ProfileController(textMode);
            profileController.openSession(profile);
        } catch (PersistenceException e) {
            proccessPersistenceException(e);

        }
    }

    /**
     * Este es el método main
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         boolean textMode = (args.length == 1 && args[0].equals("text"));
         InitMenuController initMenuController = new InitMenuController();
         initMenuController.init();
    }

    private void proccessPersistenceException(PersistenceException e) {
        //Como tenemos 3 tipos de erroroes, lo mas adecuado es utilizar un switch
        //para poder controlar cada situacioón, ademas, es necesario el uso de 
        //switch porque lo que hace la llamada a cada uno de estos 3 metodos es 
        //atributo "code", que se utiliza como identificador para cada uno de ellos.
        switch (e.getCode()) {

            //identificador del metodo showConnectionErrorMessage
            case 0:
                this.initMenuView.showConnectionErrorMessage();
                break;

            //identificador del metodo showReadErrorMessage
            case 1:
                this.initMenuView.showReadErrorMessage();
                break;

            //identificador del metodo showWriteErrorMessage
            case 2:
                this.initMenuView.showWriteErrorMessage();
                break;
        }
    }

}
