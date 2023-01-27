/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tacebook;

import java.util.Scanner;

/**
 *
 * @author Alejandro Martínez Domínguez, Bilo Alejandro Martins González y Raúl
 * Parada de la Fuente
 */
public class ProfileView {

    private int postsShowed = 10;
    private ProfileController profileController;

    /**
     *
     * @param profileController
     */
    public ProfileView(ProfileController profileController) {
        this.profileController = profileController;
    }

    private void showProfileInfo(boolean ownProfile, Profile profile) {
        System.out.println("Username: " + profile.getName());
        System.out.println("Status: " + profile.getStatus());
    }

    private void changeStatus(boolean ownProfile, Profile profile) {
        if (ownProfile) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Actualiza tu status: ");
            String status = sc.nextLine();
            profileController.updateProfileStatus(status);
        } else {
            System.out.println("Esta opción solo se puede utilizar en tu propia biografia");
            showProfileMenu(profile);
        }

    }

    /**
     *
     * @param profile
     */
    public void showProfileMenu(Profile profile) {
        showProfileInfo(true, profile);
        changeStatus(true, profile);
        //a lo mejor se necesita meter algo más aqui !
    }

    /**
     *
     * @return
     */
    public int getPostsShowed() {
        return postsShowed;
    }

    /**
     *
     * @param postsShowed
     */
    public void setPostsShowed(int postsShowed) {
        this.postsShowed = postsShowed;
    }

}
