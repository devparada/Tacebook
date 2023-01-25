/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tacebook;

/**
 *
 * @author Bilo Alejandro Martins González y Raúl Parada de la Fuente
 */
public class InitMenuController {

    private InitMenuView initMenuView = new InitMenuView();

    private void init() {
        while (!initMenuView.showLoginMenu()) {
            initMenuView.showLoginMenu();
        }
    }

    // !!
    public void login(String name, String password) {
        //ProfileController profileController = new ProfileController();
        
        System.out.println("SSSSSSSS");
        
//        if (ProfileDB.findByNameAndPassword(name, password, 0).getName().equals(name)) {
//            initMenuView.showLoginErrorMessage();
//        } else {
//            profileController.openSession();
//        }
    }

    public void register() {
        initMenuView.showRegisterMenu();
    }

    public void createProfile(String name, String password, String status) {
        //ProfileController profileController = new ProfileController();
        Profile profile = new Profile(name, password, status);
        ProfileDB.save(profile);
        //profileController.openSession();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        InitMenuController intiMenuController = new InitMenuController();
        intiMenuController.init();
    }

}
