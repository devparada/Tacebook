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
        this.sessionProfile = sessionProfile;
        profileWiew.showProfileMenu(this.sessionProfile);
    }
//    public void openSession(Profile sessionProfile) {
//
//        profileView.showProfileMenu(sessionProfile);
//    }

    /**
     *
     * @param newStatus
     */
    public void updateProfileStatus(String newStatus) {
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
