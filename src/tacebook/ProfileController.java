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

    private ProfileView profileView = new ProfileView(this);
    private Profile sessionProfile;

    /**
     *
     * @return
     */
    public int getPostsShowed() {
        return profileView.getPostsShowed();
    }

    /**
     *
     */
    public void reloadProfile() {
        sessionProfile = ProfileDB.findByName(sessionProfile.getName(), getPostsShowed());
        profileView.showProfileMenu(sessionProfile);
    }

    /**
     *
     * @param sessionProfile
     */
    public void openSession(Profile sessionProfile) {
        profileView.showProfileMenu(sessionProfile);
    }

    /*
    Este método falla al actualizar el estado de un perfil debido a que el perfil es null en los parametros.
     */
    /**
     *
     * @param newStatus
     */
    public void updateProfileStatus(String newStatus) {
        //sessionProfile = new Profile(profileView.);
        //sessionProfile = ProfileDB.findByName(sessionProfile.getName(), getPostsShowed());
        sessionProfile.setStatus(newStatus);
        ProfileDB.save(sessionProfile);
        reloadProfile();
    }

    /**
     *
     * @return
     */
    public ProfileView getProfileView() {
        return profileView;
    }

    /**
     *
     * @return
     */
    public Profile getSessionProfile() {
        return sessionProfile;
    }

}
