package org.miage.Model;

public abstract class User {
    protected String idUser;
    protected String password;

    public User(String idUser, String password) {
        this.idUser = idUser;
        this.password = password;
    }

    public String getIdUser() {
        return idUser;
    }

    public String getPassword() {
        return password;
    }

    public abstract void afficherMenu();
}
