package org.miage.models.accounts;

import com.fasterxml.jackson.annotation.*;
import org.miage.models.Store;

public class Admin extends User {

    private Store store;

    @JsonCreator
    public Admin(@JsonProperty("idUser") String nomUtilisateur, @JsonProperty("password") String motDePasse) {
        super(nomUtilisateur, motDePasse);
        store = new Store();
    }

    public Admin(String nomUtilisateur, String motDePasse, Store store) {
        super(nomUtilisateur, motDePasse);
        this.store = store;
    }

    public void deleteAccount(User compte) {
        this.store.deleteAccount(compte);
        System.out.println("Compte " + compte.getIdUser() + " supprimé.");
    }

    public void modifyAccount(int index, String name, String password) {
        this.store.getUserList().get(index).setIdUser(name);
        this.store.getUserList().get(index).setPassword(password);
    }

    @Override
    public void displayMenu() {
        System.out.println("Menu Administrateur : \n1.Supprimer un compte\n2.Modifier un compte\n");
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public Store getStore() {
        return store;
    }
}
