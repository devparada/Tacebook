/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tacebook;

/**
 *
 * @author Alejandro Martínez Domínguez, Bilo Alejandro Martins González y Raúl
 * Parada de la Fuente
 */
public class InitMenuController {

    private InitMenuView initMenuView = new InitMenuView(this);

    private void init() {
        while (!initMenuView.showLoginMenu()) {
            initMenuView.showLoginMenu();
        }
    }

    // !!
    /**
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
     *
     */
    public void register() {
        initMenuView.showRegisterMenu();
    }

    /**
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
        }

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        InitMenuController intiMenuController = new InitMenuController();
        intiMenuController.init();
    }

}
