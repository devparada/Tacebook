/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tacebook;

/**
 *
 * @author Bilo Alejandro Martins Gonzalez
 */
public class PostDB {

    /**
     *
     * @param post
     */
    public static void save(Post post) {
       post.getProfile().getPosts().add(0, post);
        
    }

    /**
     *
     * @param post
     * @param profile
     */
    public static void saveLike(Post post, Profile profile) {

    }
}
