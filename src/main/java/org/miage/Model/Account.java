package org.miage.Model;

public abstract class Account {
    protected String nomUtilisateur;
    protected String motDePasse;

    public Account(String nomUtilisateur, String motDePasse) {
        this.nomUtilisateur = nomUtilisateur;
        this.motDePasse = motDePasse;
    }

    public String getNomUtilisateur() {
        return nomUtilisateur;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public abstract void afficherMenu();
}
