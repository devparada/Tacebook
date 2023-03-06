/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistence;

import model.Profile;

/**
 * Esta clase va acceder, filtrar y guardar los datos de nuestro programa en
 * función de los perfiles, que son aqui los objetos 'profile'
 *
 * @author Alejandro Martínez Domínguez, Bilo Alejandro Martins González y Raúl
 * Parada de la Fuente
 */
public class ProfileDB {

    /**
     * Este método percorre el arrayList profile de la clase TacebookDB,
     * haciendo un filtrado para obtener la cantidad de posts de cada
     * perfil.Hace una llamada al getter de nuestro arrayList, con solo llamar
     * el name, ya obtenemos como parametro el atributo que almancena la
     * cantidad de posts
     *
     * @param name nombre del perfil
     * @param numberOfPosts atributo que guarda la cantidad de posts del usario
     * @return profile
     * @throws persistence.PersistenceException
     */
    public static Profile findByName(String name, int numberOfPosts) throws PersistenceException {
        for (Profile profile : TacebookDB.getProfiles()) {
            if (profile.getName().equals(name)) {
                return profile;
            }
        }
        return null;
    }

    /**
     * Este método accede el arrayList profile de la clase TacebookDB para
     * buscar en la base de datos el nombre de usuario, la contraseña y la
     * cantidad de posts de ese perfil
     *
     * @param name nombre del perfil
     * @param password contraseña del usuario
     * @param numberOfPosts atributo que guarda la cantidad de posts del usario
     * @return
     * @throws persistence.PersistenceException
     */
    public static Profile findByNameAndPassword(String name, String password, int numberOfPosts) throws PersistenceException {
        //Enhanced for para percorrer todos los objetos profile de TacebookDB
        for (Profile profile : TacebookDB.getProfiles()) {
            /*
            Queremos encontrar no solo um nombre de usuario sino una 
            contraseña asociada a ese nombre, entonces dentro de la condicion 
            if debemos declarar como true si name y password a la vez 
            son true, es decir, si ya existen.
             */
            if (profile.getName().equals(name) && profile.getPassword().equals(password)) {
                /*
                Una vez percorrido todo el arrayList "profile", ya podemos 
                retornar nuestro objeto profile, ahora ya está filtrado
                 */
                return profile;
            }
        }
        return null;
    }

    /**
     * Este método accede el arrayList 'profile' de la clase TacebookDB y guarda
     * un nuevo perfil.
     *
     * @param profile perfil del arrayList
     * @throws persistence.PersistenceException
     */
    public static void save(Profile profile) throws PersistenceException {
        TacebookDB.getProfiles().add(profile);
    }

    /**
     * Este método actualiza el perfil.
     *
     * @param profile
     * @throws persistence.PersistenceException
     */
    public static void update(Profile profile) throws PersistenceException {
    }

    /**
     * Este método accede la lista de solicitudes de amistad y guarda las nuevas
     * solicitudes utilizando ese acceso.
     *
     * @param destProfile perfil que tienes tu cuando inicias el programa
     * @param sourceProfile perfil al que hacemos solicitud de amistad
     * @throws persistence.PersistenceException
     */
    public static void saveFrienshipRequest(Profile destProfile, Profile sourceProfile) throws PersistenceException {
        destProfile.getFriendshipRequests().add(sourceProfile);
    }

    /**
     * Este método accede la lista de solicitudes de amistad y elimina un pedido
     * de amistad
     *
     * @param destProfile perfil que tienes tu cuando inicias el programa
     * @param sourceProfile perfil al que hacemos solicitud de amistad
     * @throws persistence.PersistenceException
     */
    public static void removeFrienshipRequest(Profile destProfile, Profile sourceProfile) throws PersistenceException {
        destProfile.getFriendshipRequests().remove(sourceProfile);
    }

    /**
     * Este método coge un perfil1, accede la lista de amigos de perfil 1 y
     * añade el perfil2 y su utilidad es hacer con que los dos perfiles tengan
     * un vínculo de amistad dentro de la aplicación.
     *
     * @param profile1
     * @param profile2
     * @throws persistence.PersistenceException
     */
    public static void saveFriendship(Profile profile1, Profile profile2) throws PersistenceException {
        profile1.getFriends().add(profile2);
        profile2.getFriends().add(profile1);
    }
}
