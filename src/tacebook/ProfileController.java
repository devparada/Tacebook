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

    public ProfileController(ProfileView profileView) {
        this.profileView = profileView;
    }

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

    }

    /**
     *
     * @param newStatus
     */
    public void updateProfileStatus(String newStatus) {

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
     * @param profileView
     */
    public void setProfileView(ProfileView profileView) {
        this.profileView = profileView;
    }

    /**
     *
     * @return
     */
    public Profile getSessionProfile() {
        return sessionProfile;
    }

    /**
     *
     * @param sessionProfile
     */
    public void setSessionProfile(Profile sessionProfile) {
        this.sessionProfile = sessionProfile;
    }

}
