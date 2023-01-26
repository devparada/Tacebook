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
public class ProfileController {

    private ProfileView profileView;
    private Profile sessionProfile;

    /**
     * puede ser que este constructor esté mal, una alternativa seria sacar
     * estos parametros y dejarlo algo como esto:
     *
     * public ProfileController() { profileWiew = new ProfileView(this); }
     */
    public ProfileController(ProfileView profileView) {
        this.profileView = profileView;
    }

    public int getPostsShowed() {
        return 0;
    }

    public void reloadProfile() {

    }

    public void openSession(Profile sessionProfile) {

    }

    public void updateProfileStatus(String newStatus) {

    }

}
