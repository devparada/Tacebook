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

    private InitMenuView initMenuView;

    public InitMenuController(InitMenuView initMenuView) {
        this.initMenuView = initMenuView;
    }

    InitMenuController() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private void init() {
        while (!initMenuView.showLoginMenu()) {
        }
    }

    public void login(String name, String password) {
        Profile p = ProfileDB.findByNameAndPassword(name, password, controller.getPostsShowed());
        if (p == null) {
            initMenuView.showLoginErrorMessage();
        } else {
            controller.openSession(p);
        }
    }        

public void login (String name, String password){

}

//        ProfileController profilecontrol = new ProfileController(initMenuView);
//        Profile profile = ProfileDB.findByNameAndPassword(name, password, 0);
//        if (profile == null) {
//            
//        }


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
       
    }

}
