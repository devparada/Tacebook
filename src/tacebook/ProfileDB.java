/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tacebook;

/**
 * Esta clase va acceder, filtrar y guardar los datos de nuestro programa en
 * función de los perfiles, que son aqui los objetos 'profile'. Para su
 * funcionalidad utilizaremos los metodos findByName, findByNameAndPassword,
 * save y update.
 *
 * @author Alejandro Martínez Domínguez, Bilo Alejandro Martins González y Raúl
 * Parada de la Fuente
 */
public class ProfileDB {

    /**
     * Este método percorre el arrayList profile de la clase TacebookDB,
     * haciendo un filtrado para obtener la cantidad de posts de cada perfil,
     * haciendo llamada al getter de nuestro arrayList, con solo llamar el name,
     * ya obtenemos como parametro el atributo que almancena la cantidad de
     * posts
     *
     * @param name nnombre del perfil (la persona en concreto)
     * @param numberOfPosts atributo que guarda la cantidad de posts del usario
     * @return profile
     */
    public static Profile findByName(String name, int numberOfPosts) {
        for (Profile profile : TacebookDB.getProfiles()) {
            if (profile.getName().equals(name)) {
                return profile;
            }
        }
        return null;
    }

    /*
    Este metodo, igual que findByName pero, con operador and porque quieres mas 
    datos, implementaremos la recuperacion de profile pero con name, password y 
    number of posts
     */

    /**
     *
     * @param name
     * @param password
     * @param numberOfPosts
     * @return
     */

    public static Profile findByNameAndPassword(String name, String password, int numberOfPosts) {
        //Enhanced for para percorrer todos los objetos profile de TacebookDB
        for (Profile profile : TacebookDB.getProfiles()) {
            //Es exactamente los mismo que el otro método pero añadiendo un 
            //operador && para hacer llamada a getPassword
            if (profile.getName().equals(name) && profile.getPassword().equals(password)) {
                //Una vez percorrido todo el arrayList "profile", ya podemos 
                //retornar nuestro objeto profile, ahora ya está filtrado
                return profile;
            }
        }
        return null;
    }

    /**
     * Este método guarda el perfil en el arraylist profile de la clase
     * TacebookDB, entonces todo lo que tiene que hacer es una llamada al
     * arraylist con el metodo getter, lo accedemos y añadimos el nuevo
     * 'profile'
     *
     * @param profile perfil del arrayList
     */
    public static void save(Profile profile) {
        TacebookDB.getProfiles().add(profile);
    }

    /**
     * Este método de momento no hace nada, dejaré el javadoc añadido para ya
     * tener esto en cuenta, aun que puede que sea necesario añadir algum param
     * o return, ya veremos..
     * @param profile
     */
    public static void update(Profile profile) {

    }

}
