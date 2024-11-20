package org.miage.models.accounts;

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
    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public abstract void displayMenu();

    @Override
    public String toString() {
        return this.getClass().getSimpleName()+": " + this.idUser;
    }
}
