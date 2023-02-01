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
 *
 * Esta clase es el modelo de vista de nuestro programa, es la parte "visual"
 * frente al cliente, aqui se implementa todo tipo de menu, mensaje y metodos
 * para que trabajen en conjunto con los controladores
 */
public class ProfileView {

    private int postsShowed = 10;
    private ProfileController profileController;

    /**
     * Este constructor se inicia pasando como parametro el objeto "profile
     * controler" para que la interfaz tenga interacción y comunicación con las
     * demas clases
     *
     * @param profileController
     */
    public ProfileView(ProfileController profileController) {
        this.profileController = profileController;
    }

    /**
     * Este método hace con que el usuario vea el perfil de algun usuario o, su
     * propio perfil, sacando mensajes por pantalla.
     */
    private void showProfileInfo(boolean ownProfile, Profile profile) {
        /*
        Si está mirando su proprio perfil, entonces le damos una condicion 
        verdadera, que será llamada de ownprofile
         */
        if (ownProfile) {
            //aquí avisará que está mirando su propio perfil
            System.out.println("Estás vendo o teu propio perfil");
        } else {
            /*
            Pero si ownprofile es false, significa que esta mirando un perfil 
            por lo cual indicamos ese perfil llamando a getname y getstatus
             */
            System.out.println("Estás vendo o perfil de " + profile.getName());
        }
        System.out.println("Username: " + profile.getName());
        System.out.println("Status: " + profile.getStatus());
    }

    /**
     * Este método permite que el usuario cambie de estado. Si own profile es
     * false, avisará que el estado solo se puede cambiar en su propia biografia
     */
    private void changeStatus(boolean ownProfile, Scanner scanner, Profile profile) {
        /*
        Si ownprofile es true, indica que el usuario está intentando cambiar su 
        propio estado, por lo cual el método sacará un scanner pidiendo los 
        datos.
         */
        if (ownProfile) {
            System.out.println("Actualiza tu status: ");
            String newStatus = scanner.next();
            profileController.updateProfileStatus(newStatus);
        } else {
            /*
            Si own profile es false, avisará que el estado solo se puede cambiar
            en su propia biografia.
             */
            System.out.println("Esta opción solo se puede utilizar en tu propia biografia");
            showProfileMenu(profile);
        }
    }

    /**
     * Este método llama al método showProfileInfo y entrega opciones al
     * usuario. Las opciones serán cambiar de estado o cerrar sessión.
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
            /*
            Si el usuario selecciona la opcion 1, que reciba un scanner para que
            pueda cambiar su estado.
             */
            case 1:
                changeStatus(true, scan, profile);
                break;
            /*
            Si el usuario selecciona la opcion 2, que simplemente cierre la 
            sesión y que salga del bucle.
             */
            case 2:
                break;
        }
    }

    /**
     * Método getter del atributo postsShowed.
     *
     * @return postsShowed
     */
    public int getPostsShowed() {
        return postsShowed;
    }

    /**
     * Método setter del atributo postsShowed
     *
     * @param postsShowed cantidad de posts a mostrar.
     */
    public void setPostsShowed(int postsShowed) {
        this.postsShowed = postsShowed;
    }

}
