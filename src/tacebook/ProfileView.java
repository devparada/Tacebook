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
        if (ownProfile) {
            System.out.println("Estás vendo o teu propio perfil");
        } else {
            System.out.println("Estás vendo o perfil de " + profile.getName());
        }
        System.out.println("Username: " + profile.getName());
        System.out.println("Status: " + profile.getStatus());
    }

    private void changeStatus(boolean ownProfile, Scanner scanner, Profile profile) {
        if (ownProfile) {
            System.out.println("Actualiza tu status: ");
            String newStatus = scanner.next();
            profileController.updateProfileStatus(newStatus);
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
        Scanner scan = new Scanner(System.in);

        showProfileInfo(true, profile);

        int select;

        do {
            System.out.println("1. Cambiar estado");
            System.out.println("2. Sair da aplicacion");
            select = scan.nextInt();
            scan.nextLine();
        } while (select > 2);

        switch (select) {
            case 1:
                changeStatus(true, scan, profile);
                break;
            case 2:
                break;
            //a lo mejor se necesita meter algo más aqui !
        }
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
