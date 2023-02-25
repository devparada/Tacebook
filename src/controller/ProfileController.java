/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import view.ProfileView;
import persistence.ProfileDB;
import persistence.MessageDB;
import persistence.CommentDB;
import java.util.Date;
import model.Comment;
import model.Message;
import model.Post;
import persistence.PostDB;
import model.Profile;
import persistence.PersistenceException;
import view.GUIProfileView;
import view.TextProfileView;

/**
 * Esta es la clase controladora que se junta al modelo de vista, está clase
 * entrega funcionalidad a los métodos reloadProfile, getPostsShowed,
 * openSession, updateProfileStatus.
 *
 * @author Alejandro Martínez Domínguez, Bilo Alejandro Martins González y Raúl
 * Parada de la Fuente
 */
public class ProfileController {

    private boolean textMode;

    /**
     * El perfil que se está visualizando (puede coincidir o no con el perfil
     * que ha iniciado sesión)
     */
    private Profile shownProfile;
    /**
     * Mantiene la referencia al objecto vista (ProfileView)
     */
    private ProfileView profileView;
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
    public ProfileController(boolean textMode) {    
        this.textMode = textMode;
        if (textMode) {
            profileView = (ProfileView)new TextProfileView(this);
        } else {
            profileView = (ProfileView)new GUIProfileView(this);
//            profileView = (ProfileView)new GUIProfileView();
        }
    }

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

    /**
     * Getter de profileView
     *
     * @return
     */
    public ProfileView getProfileView() {
        return profileView;
    }

    /**
     * Getter de sessionProfile
     *
     * @return
     */
    public Profile getSessionProfile() {
        return sessionProfile;
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
        try {
            shownProfile = ProfileDB.findByName(shownProfile.getName(), getPostsShowed());
        } catch (PersistenceException e) {
            proccessPersistenceException(e);

        }
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
        this.profileView.showProfileMenu(this.shownProfile);
    }

    /**
     * Este método actualiza el atributo status del perfil, guardando los
     * cambios en la clase ProfileDB y en seguida llamará al metodo
     * reloadProfile para actualizar todo el perfil.
     *
     * @param newStatus
     */
    public void updateProfileStatus(String newStatus) {
        try {
            sessionProfile.setStatus(newStatus);
            ProfileDB.update(this.sessionProfile);
        } catch (PersistenceException e) {
            proccessPersistenceException(e);

        }
        reloadProfile();
    }

    /**
     * Método que crea un nuevo post
     *
     * @param text
     * @param destProfile
     */
    public void newPost(String text, Profile destProfile) {
        try {
            Post post = new Post(destProfile.getPosts().size(), new Date(), text, destProfile, destProfile);

            PostDB.save(post);
        } catch (PersistenceException e) {
            proccessPersistenceException(e);

        }
        reloadProfile();
    }

    /**
     * Método que agrega un nuevo comentario en un post
     *
     * @param post
     * @param commentText
     */
    public void newComment(Post post, String commentText) {
        try {
//Creamos date ya pasando como parametro en creacion del objeto comment,
            //aun que puede ser que falten cositas aqui
            Comment comment = new Comment(0, new Date(), commentText, this.sessionProfile, post);
            CommentDB.save(comment);
        } catch (PersistenceException e) {
            proccessPersistenceException(e);

        }
        reloadProfile();
    }

    /**
     * Método que fai un like
     *
     * @param post
     */
    public void newLike(Post post) {
        try {
            boolean saveLike = true;
            if (!sessionProfile.getName().equals(post.getAuthor().getName())) {
                for (Profile profLike : post.getProfileLikes()) {
                    if (sessionProfile.getName().equals(profLike.getName())) {
                        saveLike = false;
                    }
                }
                if (saveLike) {
                    PostDB.saveLike(post, sessionProfile);
                } else {
                    profileView.showAlreadyLikedPostMessage();
                }
            } else {
                profileView.showCannotLikeOwnPostMessage();
            }
        } catch (PersistenceException e) {
            proccessPersistenceException(e);

        }

        reloadProfile();
    }

    /**
     * Método que crea una nueva solicitud de amistad. MÉTODO INCOMPLETO, FALTA
     * COMPROBACIONES PREVIAS
     *
     * @param profileName
     */
    public void newFriendshipRequest(String profileName) {
        try {
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
                        return;
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
                        return;
                    }
                }
                /*
            Este bucle hace exactamente lo mismo que el de arriba, pero con 
            solicitudes de amistad, comprueba que YA ENVIASTE una solicitud de 
            amistad.
                 */
                for (Profile friendshipRequest : this.sessionProfile.getFriendshipRequests()) {
                    if (friendshipRequest.getName().equals(profileName)) {
                        this.profileView.showExistsFrienshipRequestMessage(profileName);
                        reloadProfile();
                        return;
                    }
                }
                ProfileDB.saveFrienshipRequest(destProfile, this.sessionProfile);
            }
        } catch (PersistenceException e) {
            proccessPersistenceException(e);

        }
        reloadProfile();
    }

    /**
     * Método que elimina la solicitud de amistad, y guarda la amistad entre los
     * dos usuarios
     *
     * @param sourceProfile
     */
    public void acceptFriendshipRequest(Profile sourceProfile) {

        try {
            ProfileDB.removeFrienshipRequest(this.sessionProfile, sourceProfile);

            ProfileDB.saveFriendship(this.sessionProfile, sourceProfile);
        } catch (PersistenceException e) {
            proccessPersistenceException(e);

        }
        reloadProfile();
    }

    /**
     * Método que simplemente elimina la solicitud
     *
     * @param sourceProfile
     */
    public void rejectFriendshipRequest(Profile sourceProfile) {
        try {
            ProfileDB.removeFrienshipRequest(this.sessionProfile, sourceProfile);
        } catch (PersistenceException e) {
            proccessPersistenceException(e);

        }
        reloadProfile();
    }

    /**
     * Este método guarda un mensaje en clase de persistencia
     *
     * @param destProfile
     * @param text
     */
    public void newMessage(Profile destProfile, String text) {
        try {
            //Message message = new Message(0, text, new Date(), false);
            Message message = new Message(0, text, new Date(), false, this.sessionProfile, destProfile);
            MessageDB.save(message);
        } catch (PersistenceException e) {
            proccessPersistenceException(e);

        }
        reloadProfile();
    }

    /**
     * Este metodo elimina un mensaje de la clase de persistencia.
     *
     * @param message
     */
    public void deleteMessage(Message message) {
        try {
            MessageDB.remove(message);
        } catch (PersistenceException e) {
            proccessPersistenceException(e);

        }
        reloadProfile();
    }

    /**
     * Este método actualiza el estado del mensaje, marcandolo como leído y
     * actualiza la clase de persistencia
     *
     * @param message
     */
    public void markMessageAsRead(Message message) {
        try {
            message.setRead(true);
            MessageDB.update(message);
        } catch (PersistenceException e) {
            proccessPersistenceException(e);

        }
        reloadProfile();
    }

    /**
     * Este método marca el estado como leído y en seguida abre un scanner para
     * contestar el mensaje
     *
     * @param message
     * @param text
     */
    public void replyMessage(Message message, String text) {
        try {
            message.setRead(true);
            MessageDB.update(message);
            newMessage(message.getSourceProfile(), text);
        } catch (PersistenceException e) {
            proccessPersistenceException(e);

        }
    }

    /**
     * Este método hace acceso a las clases de persistencia para lanzar
     * excepciones, como tenemos 3 casos de los cuales consideramos excepciones
     * de cada tipo, utilizaremos un switch para controlar mejor la llamada a
     * esos metodos que avisan la excepcion en concreto.
     */
    private void proccessPersistenceException(PersistenceException ex) {
        switch (ex.getCode()) {
            //connection error vale 0, asi que ocupara el case 0
            case 0:
                profileView.showConnectionErrorMessage();

            //cannot_read ocupa el case 1, asi que 1.
            case 1:
                profileView.showReadErrorMessage();

            //Y write error equivale a 2
            case 2:
                profileView.showWriteErrorMessage();
        }
        reloadProfile();
    }

}
