/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tacebook;

/**
 *
 * @author Bilo Alejandro Martins González y Raúl Parada de la Fuente
 */
public class ProfileDB {

    //!!!Revisar puede que esté mal!!!
    public static Profile findByName(String name, int numberOfPosts) {
        for (Profile profile : TacebookDB.getProfiles()) {
            if (profile.getName().equals(name)) {
                return profile;
            }
        }
        return null;
    }

    /*
    TODO: este metodo pide el nombre y la contraseña, pero al llamar al nombre,
    probé utilizar el metodo findbyname, que retorna nombre, puede que sirva y 
    puede que no, por lo tanto este comentario lo hice para avisar que si falla 
    algo, seguramente hay que cambiar algo de caracter name, en la condicion if 
    por ejemplo
     */
    public static Profile findByNameAndPassword(String name, String password, int numberOfPosts) {
        for (Profile profile : TacebookDB.getProfiles()) {
            if (profile.getName().equals(findByName(name, numberOfPosts))) {

            }
        }
        return null;
    }

    /*
    TODO: No sé se está bien, por lo cual HACE FALTA REVISAR Y SEGURAMENTE 
    CAMBIAR ALGO EN ESTE MÉTODO. Por que? Pues porque estoy confuso si este 
    metodo carece de un arraylist que hay que crear para esta clase, o si hay 
    que llamar al arraylist de TacebookDB(es lo que hice yo) y guardarlo alli, 
    fijate que como es de otra clase y es un arraylist de otra clase privado, 
    tuve que utilizar su getter (getProfiles) para entonces llamar al .add
    y pasar como parametro el profile :)
    
    REVISA BIEN ESTO
    */
    public static void save(Profile profile){
        TacebookDB.getProfiles().add(profile);
    }
    
    public static void update(Profile profile){
    
    }
    
}
