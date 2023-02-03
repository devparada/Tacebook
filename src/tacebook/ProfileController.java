/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tacebook;

/**
 * Esta es la clase controladora que se junta al modelo de vista, está clase
 * entrega funcionalidad a los métodos reloadProfile,
 * getPostsShowed,openSession, updateProfileStatus.
 *
 * @author Alejandro Martínez Domínguez, Bilo Alejandro Martins González y Raúl
 * Parada de la Fuente
 */
public class ProfileController {

    private Profile shownProfile;
    private ProfileView profileView;

    public Profile getShownProfile() {
        return shownProfile;
    }

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

    /*
    Este es el constructor de la clase, que inicializa el modelo de vista para 
    que todos los metodos tengan usabilidad y conectividad
     */
    public ProfileController() {
        profileView = new ProfileView(this);
    }

    /**
     * Este método te entrega la cantidad de posts que se van a mostrar al
     * usuario
     *
     * @return
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
    
    public void newPost(String text, Profile destProfile){
        
        reloadProfile();
    }
    
    public void newComment(Post post, String commentText){
        
        reloadProfile();
    }
    
    public void newLike(Post post){
        
        reloadProfile();
    }
    
    public void newFriendshipRequest(String profileName){
        
        reloadProfile();
    }
    
    public void acceptFriendshipRequest(Profile sourceProfile){
        
        reloadProfile();
    }
    
    public void rejectFriendshipRequest(Profile sourceProfile){
        
        reloadProfile();
    }
    
    public void newMessage(Profile destProfile, String text){
        
        reloadProfile();
    }
    
    public void deleteMessage(Message message){
        
        reloadProfile();
    }
    
    public void markMessageAsRead(Message message){
        
        reloadProfile();
    }
    
    public void replyMessage(Message message, String text){
        
        reloadProfile();
    }
    
}
