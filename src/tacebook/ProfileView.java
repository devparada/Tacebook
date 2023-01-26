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

    public ProfileView(ProfileController profileController) {
        this.profileController = profileController;
    }

    private void showProfileInfo(boolean ownProfile, Profile profile) {
        System.out.println("Username: " + profile.getName());
        System.out.println("Status: " + profile.getStatus());
    }

    private void changeStatus(boolean ownProfile, Scanner scanner, Profile profile) {
        System.out.println("Escribe como quieres cambiar tu status");
        Scanner sc = new Scanner(System.in);

    }

    public void showProfileMenu(Profile profile) {
    }

    public int getPostsShowed() {
        return postsShowed;
    }

    public void setPostsShowed(int postsShowed) {
        this.postsShowed = postsShowed;
    }

}
