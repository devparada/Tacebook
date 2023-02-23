/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tacebook;

import java.util.Date;

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
        ProfileController profileController = new ProfileController();
        Profile profile = ProfileDB.findByNameAndPassword(name, password, profileController.getPostsShowed());

        if (profile == null) {
            initMenuView.showLoginErrorMessage();
        } else {
            System.out.println("Benvido unha vez mais a Tacebook!");
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
        // Comprobamos que o nome non estea repetido
        while (ProfileDB.findByName(name, 0) != null) {
            name = initMenuView.showNewNameMenu();
        }

        // Creamos o perfil e gardamos
        Profile profile = new Profile(name, password, status);
        ProfileDB.save(profile);

        // Abrimos a sesion do usuario
        ProfileController profileController = new ProfileController();
        profileController.openSession(profile);
    }

    /**
     * Este es el método main
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Profile miguel = new Profile("miguel", "", "ben");
        Profile ainhoa = new Profile("ainhoa", "", "ben");
        Profile sandra = new Profile("garnet.va", "", "ben");
        Profile bilinho = new Profile("bilinho", "", "soy brasileiro");

     
            TacebookDB.getProfiles().add(miguel);
            TacebookDB.getProfiles().add(ainhoa);
            TacebookDB.getProfiles().add(sandra);
            TacebookDB.getProfiles().add(bilinho);

        

        miguel.getFriends().add(ainhoa);
        ainhoa.getFriends().add(miguel);
        sandra.getFriends().add(ainhoa);
        sandra.getFriends().add(miguel);
        miguel.getFriends().add(sandra);
        ainhoa.getFriends().add(sandra);
        ainhoa.getFriends().add(sandra);
        bilinho.getFriends().add(sandra);
        bilinho.getFriends().add(ainhoa);
        bilinho.getFriends().add(miguel);
        miguel.getFriends().add(bilinho);
        ainhoa.getFriends().add(bilinho);
        sandra.getFriends().add(bilinho);

//        miguel.getPosts().add(new Post(0, new Date(), "hola", miguel, miguel));
//        ainhoa.getPosts().add(new Post(0, new Date(), "hola", ainhoa, ainhoa));
//        sandra.getPosts().add(new Post(0, new Date(), "hola", sandra, sandra));
        bilinho.getPosts().add(new Post(0, new Date(), "Soy buenísimo", bilinho, bilinho));
        InitMenuController intiMenuController = new InitMenuController();
        intiMenuController.init();
    }

}
