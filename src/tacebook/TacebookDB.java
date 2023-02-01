/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tacebook;

import java.util.ArrayList;

/**
 * @author Alejandro Martínez Domínguez, Bilo Alejandro Martins González y Raúl
 * Parada de la Fuente
 *
 * Esta clase garda unicamente un arrayList de obxectos "profile" da clase
 * "Profile". Esta é a clase de persistencia de datos, para almacenar todos os
 * cambios.
 */
public class TacebookDB {

    /**
     * Este é o arraylist que gardará todos os perfiles.
     */
    private static ArrayList<Profile> profiles = new ArrayList<>();

    /**
     * Este método é o getter do arrayList profiles, este método é crucial para
     * traballar coas outras clases, porque con el vamos sempre facer chamadas a
     * este arrayList para recibir e entregar datos.
     *
     * @return o obxecto profile
     */
    public static ArrayList<Profile> getProfiles() {
        return profiles;
    }

}
