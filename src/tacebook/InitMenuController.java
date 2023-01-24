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

    private InitMenuView initMenuView;
    
    private void init() {
    }

    // !!
    public void login(String name, String password) {
        ProfileController profileController = new ProfileController();
    }

    public void register() {
    }

    public void createProfile(String name, String password, String status) {
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        InitMenuController intiMenuController = new InitMenuController();
        intiMenuController.init();
    }

}
