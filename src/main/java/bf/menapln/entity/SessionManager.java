/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bf.menapln.entity;

/**
 *
 * @author LENOVO
 */
public class SessionManager {
    private static SessionManager instance;
    private User user;
    private boolean loggedIn;

    private SessionManager() {
        // Constructeur privé pour empêcher l'instanciation directe
    }

    public static SessionManager getInstance() {
        if (instance == null) {
            instance = new SessionManager();
        }
        return instance;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    public boolean isLoggedIn() {
        return loggedIn;
    }

    public void login(User user) {
        this.user = user;
        this.loggedIn = true;
    }

    public void logout() {
        this.user = null;
        this.loggedIn = false;
    }
}
