/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tacebook;

/**
 * Esta clase tendrá el método main para hacer la llamada al menú, cuidará de
 * toda la parte de funcionabilidad, para que todos los botones con numeros y
 * opciones funcionen como deben.
 *
 * @author Alejandro Martínez Domínguez, Bilo Alejandro Martins González y Raúl
 * Parada de la Fuente
 */
public class InitMenuController {

    private InitMenuView initMenuView = new InitMenuView(this);

    /**
     * Este método inicia el programa llamando al metodo que saca el menu por
     * pantalla
     */
    private void init() {
        while (!initMenuView.showLoginMenu()) {
            initMenuView.showLoginMenu();
        }
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
        ProfileController profileController = new ProfileController();
        Profile profile = ProfileDB.findByNameAndPassword(name, password, profileController.getPostsShowed());

        if (profile == null) {
            initMenuView.showLoginErrorMessage();
        } else {
            System.out.println("Bienvenido una vez más a Tacebook!");
            profileController.openSession(profile);
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
        Profile profile = new Profile(name, password, status);
        ProfileDB.save(profile);
        ProfileController profileController = new ProfileController();
        profileController.openSession(profile);
        while (ProfileDB.findByName(name, 0) == null) {
            name = initMenuView.showNewNameMenu();
            profile.setName(name);
        }

        ProfileDB.save(profile);
        profileController.openSession(profile);
    }

    /**
     * Este es el método main
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        InitMenuController intiMenuController = new InitMenuController();
        intiMenuController.init();
    }

}
