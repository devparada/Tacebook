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

        Date date = new Date(); // Objeto Date para usar en el constructor

        Comment currentComment = new Comment(0, date, commentText);

        CommentDB commentDB = new CommentDB(); // Objeto CommentDB

        commentDB.save(currentComment); // Se guarda comentario en la base de datos

        reloadProfile(); // Reload
    }

    /**
     * Método que fai un like
     *
     * @param post
     */
    public void newLike(Post post) {

        PostDB postDB = new PostDB();

        // Si no es el autor del post, y no le ha dado like, se guarda un nuevo like en postDB.
        if (post.getAuthor() != sessionProfile || !post.getProfileLikes().contains(sessionProfile)) {
            postDB.saveLike(post, sessionProfile);
            reloadProfile();
        }

    }

    /**
     * Método que crea unha nova solicitude de amizade. MÉTODO INCOMPLETO, FALTA
     * COMPROBACIONES PREVIAS
     *
     * @param profileName
     */
    public void newFriendshipRequest(String profileName) {

        ProfileDB profileDB = new ProfileDB();

        profileDB.saveFrienshipRequest(shownProfile, sessionProfile);

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
