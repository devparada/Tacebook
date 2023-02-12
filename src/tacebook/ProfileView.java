/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tacebook;

import java.text.SimpleDateFormat;
import java.util.Scanner;

/**
 * Esta clase es el modelo de vista de nuestro programa, es la parte "visual"
 * frente al cliente, aqui se implementa todo tipo de menu, mensaje y metodos
 * para que trabajen en conjunto con los controladores
 *
 * @author Alejandro Martínez Domínguez, Bilo Alejandro Martins González y Raúl
 * Parada de la Fuente
 */
public class ProfileView {

    /**
     * El formato de la fecha
     */
    private SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy 'ás' HH:mm:ss");
    /**
     * Los posts a visualizar
     */
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

    /**
     * Este método hace con que el usuario vea el perfil de algun usuario o, su
     * propio perfil, sacando mensajes por pantalla.
     */
    // AVISO    
    /*
    Modificaremos tamén os métodos "showProfileInfo" para que mostre a información completa do perfil 
    (incluíndo publicacións, comentarios, solicitudes de amizade, amizades e mensaxes) e "showProfileMenu" 
    para que mostre todas as opcións e chame a un método distinto para cada opción que se escolla. Ademais, 
    engadiranse os seguintes métodos:
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
        /*
        ESTE BUCLE FOR PARECE QUE FUNCIONA (REVISAR)
         */
        for (int i = 0; i < profile.getPosts().size() && i < postsShowed; i++) {
            System.out.println("-> Post " + i);
            System.out.println("Depuracion: " + profile.getPosts().get(i).getComments().size());
            /*
            Bucle for para los comentarios del post
             */
            for (int j = 0; j < profile.getPosts().get(i).getComments().size(); j++) {
                System.out.println("Comentarios " + profile.getPosts().get(i).getComments().get(j).getText());
            }
            /*
            Bucle for para los likes del post
             */
            for (int j = 0; j < profile.getPosts().get(i).getProfileLikes().size(); j++) {
                System.out.println("Likes: " + profile.getPosts().get(i).getProfileLikes().get(j).getName());
            }
            System.out.println("Autor " + profile.getPosts().get(i).getAuthor().getName());
            /*
            Fecha del post con un formato determinado (formatter)
             */
            System.out.println("Data: " + formatter.format(profile.getPosts().get(i).getDate()));
            System.out.println("Texto " + profile.getPosts().get(i).getText());
        }
        System.out.println("Tu usuario: " + profile.getName());
        System.out.println("Tu estado: " + profile.getStatus());
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
            System.out.println("Actualiza o teu estado: ");
            String newStatus = scanner.next();
            profileController.updateProfileStatus(newStatus);
        } else {
            /*
            Si own profile es false, avisará que el estado solo se puede cambiar
            en su propia biografia.
             */
            System.out.println("Esta opción solo se pode utilizar no teu propio perfil");
            showProfileMenu(profile);
        }
    }

    /**
     * Este método llama al método showProfileInfo y entrega opciones al usuario
     *
     * @param profile
     */
    // AVISO    
    /*
    Modificaremos tamén os métodos "showProfileInfo" para que mostre a información completa do perfil 
    (incluíndo publicacións, comentarios, solicitudes de amizade, amizades e mensaxes) e "showProfileMenu" 
    para que mostre todas as opcións e chame a un método distinto para cada opción que se escolla. Ademais, 
    engadiranse os seguintes métodos:
     */
    public void showProfileMenu(Profile profile) {
        Scanner scan = new Scanner(System.in);

        showProfileInfo(true, profile);

        int select;

        do {
            System.out.println("Selecciona unha opcion:");
            System.out.println("1. Escribir unha nova publicacion");
            System.out.println("2. Comentar unha publicacion");
            System.out.println("3. Facer me gusta sobre unha publicacion");
            System.out.println("4. Ver a biografia dun amigo");
            System.out.println("5. Enviar unha solicitude de amizade");
            System.out.println("6. Aceptar unha solicitude de amizade");
            System.out.println("7. Rexeitar unha solicitude de amizade");
            System.out.println("8. Enviar unha mensaxe privada a un amigo");
            System.out.println("9. Ler unha mensaxe privada");
            System.out.println("10. Eliminar unha mensaxe privada");
            System.out.println("11. Ver publicacions anteriores");
            System.out.println("12. Cambiar o estado");
            System.out.println("13. Pechar a sesion");
            select = scan.nextInt();
            scan.nextLine();
        } while (select > 13);

        switch (select) {
            case 1:
                writeNewPost(scan, profile);
                break;
            case 2:
                commentPost(scan, profile);
                break;
            case 3:
                addLike(scan, profile);
                break;
            case 4:
                showBiography(true, scan, profile);
                break;
            case 5:
                sendFriendshipRequest(true, scan, profile);
                break;
            case 6:
                profileController.acceptFriendshipRequest(profile);
                break;
            case 7:
                profileController.acceptFriendshipRequest(profile);
                break;
            case 8:
                sendPrivateMessage(true, scan, profile);
                break;
            case 9:
                readPrivateMessage(true, scan, profile);
                break;
            case 10:
                deletePrivateMessage(true, scan, profile);
                break;
            case 11:
                showOldPosts(scan, profile);
                break;
            /*
            Si el usuario selecciona la opcion 12, que reciba un scanner para que
            pueda cambiar su estado.
             */
            case 12:
                changeStatus(true, scan, profile);
                break;
            /*
            Si el usuario selecciona la opcion 13, que simplemente cierre la 
            sesión y que salga del bucle.
             */
            case 13:
                break;
        }
    }

    /**
     * Este método pide al usuario un numero y lo devuelve
     *
     * @param text
     * @param maxNumber
     * @param scanner
     * @return Devuelve un número introducido por el usuario
     */
    private int selectElement(String text, int maxNumber, Scanner scanner) {
        int number;
        do {
            System.out.println(text);
            number = scanner.nextInt();
        } while (number > 0 && number < maxNumber - 1);
        return number;
    }

    /**
     * Este método pide el texto para crear una nueva publicacion
     *
     * @param scanner
     * @param profile
     */
    private void writeNewPost(Scanner scanner, Profile profile) {
        System.out.println("Introduce o texto da publicacion");
        String text = scanner.nextLine();
        profileController.newPost(text, profile);
    }

    /**
     * Este método introduce un comentario en un post
     *
     * @param scanner
     * @param profile
     */
    private void commentPost(Scanner scanner, Profile profile) {
        int position = selectElement("Introduce o numero da publicacion", profile.getPosts().size(), scanner);
        System.out.println("Introduce un texto");
        String text = scanner.nextLine();
        profileController.newComment(profile.getPosts().get(position), text);
    }

    /**
     * Este método hace que a una publicición un usuario le de like
     *
     * @param scanner
     * @param profile
     */
    private void addLike(Scanner scanner, Profile profile) {
        int position = selectElement("Introduce o numero da publicacion", profile.getPosts().size(), scanner);
        profileController.newLike(profile.getPosts().get(position));
    }

    /*
    ESTA INCOMPLETO (EN DESARROLLO)
     */
    private void showBiography(boolean ownProfile, Scanner scanner, Profile profile) {
        if (ownProfile) {
            System.out.println("Introduce o nome da sua amizade");
            String text = scanner.nextLine();
            profileController.setShownProfile(profile);
        } else {
            profileController.setShownProfile(profile);
        }
    }

    /*
    PUEDE QUE ESTÉ INCOMPLETO
     */
    private void sendFriendshipRequest(boolean ownProfile, Scanner scanner, Profile profile) {
        System.out.println("Introduce o nome do perfil");
        String nameProfile = scanner.nextLine();
        profileController.newFriendshipRequest(nameProfile);
    }

    /*
    PUEDE QUE ESTÉ INCOMPLETO
     */
    private void proccessFriendshipRequest(boolean ownProfile, Scanner scanner, Profile profile, boolean accept) {
        int position = selectElement("Introduce o numero da solicitude de amizade", profile.getFriendshipRequests().size(), scanner);
        if (accept) {
            profileController.acceptFriendshipRequest(profile.getFriendshipRequests().get(position));
        } else {
            profileController.rejectFriendshipRequest(profile.getFriendshipRequests().get(position));
        }
    }

    /*
    PUEDE QUE ESTÉ INCOMPLETO
     */
    private void sendPrivateMessage(boolean ownProfile, Scanner scanner, Profile profile) {
        if (ownProfile) {
            System.out.println("Introduce o nome do amigo");
            String nameFriend = scanner.nextLine();
            int position = selectElement(nameFriend, profile.getFriends().size(), scanner);
            System.out.println("Introduce o texto da mensaxe");
            String text = scanner.nextLine();
            profileController.newMessage(profile.getFriends().get(position), text);
        } else {
            System.out.println("Introduce o texto para enviarlle un mensaxe a este perfil");
            String text = scanner.nextLine();
            profileController.newMessage(profile, text);
        }
    }

    /*
    ESTA INCOMPLETO (POR HACER)
     */
    private void readPrivateMessage(boolean ownProfile, Scanner scanner, Profile profile) {
    }

    /**
     * Este método permite borrar un mensaje
     *
     * @param ownProfile
     * @param scanner
     * @param profile
     */
    private void deletePrivateMessage(boolean ownProfile, Scanner scanner, Profile profile) {
        int position = selectElement("Selecciona un mensaxe", profile.getMessages().size(), scanner);
        profileController.deleteMessage(profile.getMessages().get(position));
    }

    /**
     * Este método pregunta al usuario el número de posts a visualizar y recarga
     * el perfil
     *
     * @param scanner
     * @param profile
     */
    private void showOldPosts(Scanner scanner, Profile profile) {
        System.out.println("Introduce o numero de publicacions a visualizar");
        int number = scanner.nextInt();
        postsShowed = number;
        profileController.reloadProfile();
    }

    /**
     * Este método muestra un mensaje al usuario sobre que no se encontro un
     * perfil
     */
    public void showProfileNotFoundMessage() {
        System.out.println("O perfil que estas intentando buscar non existe");
    }

    /**
     * Este método muestra un mensaje al usuario sobre que no puedes dar like a
     * tu proia publicación
     */
    public void showCannotLikeOwnPostMessage() {
        System.out.println("Non podes dar like a tua propia publicacion");
    }

    /**
     * Este método muestra un mensaje al usuario sobre que no es posible dar
     * like a una publicación que ya distes
     */
    public void showAlreadyLikedPostMessage() {
        System.out.println("Non e posible dar like a unha publicacion que xa diste like");
    }

    /**
     * Este método muestra un mensaje al usuario sobre que ya eres amigo de
     * profileName
     *
     * @param profileName nombre de la persona
     */
    public void showIsAlreadyFriendMessage(String profileName) {
        System.out.println("Xa eres amigo de " + profileName);
    }

    /**
     * Este método muestra un mensaje al usuario sobre que ya tienes enviada una
     * solicitud de amistad a profileName
     *
     * @param profileName nombre de la persona
     */
    public void showExistsFrienshipRequestMessage(String profileName) {
        System.out.println("Xa tes unha solicitude de amizade enviada a " + profileName);
    }

    /**
     * Este método muestra un mensaje al usuario sobre que ya tienes una
     * solicitud de amistad con profileName
     *
     * @param profileName nombre de la persona
     */
    public void showDuplicateFrienshipRequestMessage(String profileName) {
        System.out.println("Xa tes unha peticion de amizade con " + profileName);
    }
}
