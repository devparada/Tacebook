/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tacebook;

import java.util.Date;

/**
 * Esta es la clase controladora que se junta al modelo de vista, está clase
 * entrega funcionalidad a los métodos reloadProfile, getPostsShowed,
 * openSession, updateProfileStatus.
 *
 * @author Alejandro Martínez Domínguez, Bilo Alejandro Martins González y Raúl
 * Parada de la Fuente
 */
public class ProfileController {

    private Profile shownProfile;
    private ProfileView profileView;

    /**
     * Getter de shownProfile
     *
     * @return
     */
    public Profile getShownProfile() {
        return shownProfile;
    }

    /**
     * Setter de shownProfile
     *
     * @param shownProfile
     */
    public void setShownProfile(Profile shownProfile) {
        this.shownProfile = shownProfile;
        reloadProfile();
    }

    //AVISO
    /*
    Precisamente neste método "reloadProfile" cambiaremos o código para que en lugar de almacenar o perfil no atributo "sessionProfile" 
    o garde no atributo "shownProfile", e sexa ese atributo o que se lle pase ao obxecto da vista. No método "openSession" faremos algo 
    similar, xa que o obxecto perfil que recibamos como parámetro o almacenaremos tanto en "sessionProfile" como en "shownProfile" 
    (xa que o perfil que se ve por defecto é o propio), e será o atributo "shownProfile" o que lle pasemos como parámetro ao obxecto 
    da vista.
     */
    private Profile sessionProfile;

    /**
     * Este es el constructor de la clase, que inicializa el modelo de vista
     * para que todos los métodos tengan usabilidad y conectividad
     */
    public ProfileController() {
        profileView = new ProfileView(this);
    }

    /**
     * Este método te entrega la cantidad de posts que se van a mostrar al
     * usuario
     *
     * @return Devuelve el número de posts
     */
    public int getPostsShowed() {
        return profileView.getPostsShowed();
    }

    /**
     * Este método obtiene un objeto del perfil que está conectado en la sesión,
     * llama al menu y lo muestra por pantalla.
     */
    public void reloadProfile() {
        shownProfile = ProfileDB.findByName(shownProfile.getName(), getPostsShowed());
        profileView.showProfileMenu(shownProfile);
    }

    /**
     * Abre sesión con un perfil, guarda el objeto profile e llama al método de
     * vista showProfileMenu.
     *
     * @param sessionProfile
     */
    public void openSession(Profile sessionProfile) {
        this.sessionProfile = sessionProfile;
        shownProfile = sessionProfile;
        profileView.showProfileMenu(shownProfile);
    }

    /**
     * Este método actualiza el atributo status del perfil, guardando los
     * cambios en la clase ProfileDB y en seguida llamará al metodo
     * reloadProfile para actualizar todo el perfil.
     *
     * @param newStatus
     */
    public void updateProfileStatus(String newStatus) {
        sessionProfile.setStatus(newStatus);
        ProfileDB.save(sessionProfile);
        reloadProfile();
    }

    /**
     * Método getter de profile view
     *
     * @return
     */
    public ProfileView getProfileView() {
        return profileView;
    }

    /**
     * Método getter de sessionprofile
     *
     * @return
     */
    public Profile getSessionProfile() {
        return sessionProfile;
    }

    /**
     * Método que crea un novo post
     *
     * @param text
     * @param destProfile
     */
    public void newPost(String text, Profile destProfile) {

        Date date = new Date(); // Objeto Date para usar en el constructor

        // Parche al crear el objeto currentPost (Revisar)
        Post currentPost = new Post(0, date, text, destProfile, destProfile);

        PostDB postDB = new PostDB();

        postDB.save(currentPost); // Se guarda post en la base de datos

        reloadProfile();
    }

    /**
     * Método que agrega un novo comentario nun post
     *
     * @param post
     * @param commentText
     */
    public void newComment(Post post, String commentText) {
       
    }

    /**
     * Método que fai un like
     *
     * @param post
     */
    //!!!! Puede que necesite revision este método, en principio pinta guay
    public void newLike(Post post) {
        //condicion if para avisar que no podemos dar like a nuestra propia 
        //publicacion
        if (post.getAuthor().getName().equals(this.sessionProfile.getName())) {
            this.profileView.showCannotLikeOwnPostMessage();
        } else{
            //ahora hacemos comprobación para ver que el perfil no esta dando 
            //like más de una vez en cualquier otro post
            for (Profile profileLike : post.getProfileLikes()) {
                if (profileLike.getName().equals(this.sessionProfile.getName())) {
                } else {
                    this.profileView.showAlreadyLikedPostMessage();
                    return;
                }
            }
        }
        reloadProfile();
    }

    /**
     * Método que crea unha nova solicitude de amizade. MÉTODO INCOMPLETO, FALTA
     * COMPROBACIONES PREVIAS
     *
     * @param profileName
     */
    public void newFriendshipRequest(String profileName) {
        Profile destProfile = ProfileDB.findByName(profileName, 0);
        if (destProfile == null) {
            this.profileView.showProfileNotFoundMessage();
        } else {
            /*
            aqui se comprueba si el perfil destino ya nos tiene en la lista
            de amigos. Apuntamos el perfil destino en un bucle forE y miramos 
            toda la lista de amigos, en seguida con un IF hacemos verificación
            para la posible situacion
             */
            for (Profile friend : destProfile.getFriends()) {
                if (friend.getName().equals(this.sessionProfile.getName())) {
                    this.profileView.showIsAlreadyFriendMessage(profileName);
                    reloadProfile();
                    //no estoy seguro pero a lo mejor falta un return; aqui
                }
            }
            /*
            Este bucle hace una comprobacion para ver si el perfil destino y 
            nuestro perfil ya son amigls, si lo son, llama al metodo 
            showduplicatemiverga, para decir que ya sois amigos
             */
            for (Profile friendshipRequest : destProfile.getFriendshipRequests()) {
                if (friendshipRequest.getName().equals(this.sessionProfile.getName())) {
                    this.profileView.showDuplicateFrienshipRequestMessage(profileName);
                    reloadProfile();
                    //no estoy seguro pero a lo mejor falta un return; aqui
                }
            }
            /*
            Este bucle hace exactamente lo mismo que el de arriba, pero con 
            solicitudes de amistad, comprueba que YA ENVIASTE un pedido de 
            amistad.
             */
            for (Profile friendshipRequest : this.sessionProfile.getFriendshipRequests()) {
                if (friendshipRequest.getName().equals(profileName)) {
                    this.profileView.showExistsFrienshipRequestMessage(profileName);
                    reloadProfile();
                    //no estoy seguro pero a lo mejor falta un return; aqui
                }
            }
            ProfileDB.saveFrienshipRequest(destProfile, this.sessionProfile);
        }
        reloadProfile();
    }

    /**
     * Método que elimina a solicitude de amizade, e garda a amizade entre os
     * dous usuarios.
     *
     * @param sourceProfile
     */
    public void acceptFriendshipRequest(Profile sourceProfile) {
        ProfileDB.removeFrienshipRequest(this.sessionProfile, sourceProfile);
        ProfileDB.saveFriendship(this.sessionProfile, sourceProfile);
        reloadProfile();
    }

    /**
     * Método que simplemente elimina a solicitude.
     *
     * @param sourceProfile
     */
    public void rejectFriendshipRequest(Profile sourceProfile) {
        ProfileDB.removeFrienshipRequest(this.sessionProfile, sourceProfile);
        reloadProfile();
    }

    /**
     *
     * @param destProfile
     * @param text
     */
    //!!!! No estoy seguro con este método, puede que no esté 100% bien.
    public void newMessage(Profile destProfile, String text) {
        Message message = new Message(0, text, new Date(), false);
        MessageDB.save(message);
        reloadProfile();
    }

    /**
     *
     * @param message
     */
    public void deleteMessage(Message message) {
        MessageDB.remove(message);
        reloadProfile();
    }

    /**
     *
     * @param message
     */
    public void markMessageAsRead(Message message) {
        message.setRead(true);
        MessageDB.update(message);
        reloadProfile();
    }

    /**
     *
     * @param message
     * @param text
     */
    public void replyMessage(Message message, String text) {
        message.setRead(true);
        MessageDB.update(message);
        newMessage(message.getSourceProfile(), text);
    }

}
