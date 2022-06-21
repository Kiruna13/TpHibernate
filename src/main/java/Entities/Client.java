package Entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "Client",
        uniqueConstraints = { @UniqueConstraint(columnNames = { "IdClient" }) })
public class Client {

    private Integer Id_Client;
    private String Nom;
    private String Prenom;
    private String Telephone;
    private Set<Commande> commandes = new HashSet<Commande>(0);

    public Client() {
    }

    public Client(Integer Id_Client, String Nom, String Prenom, String Telephone) {
        this.Id_Client = Id_Client;
        this.Nom = Nom;
        this.Prenom = Prenom;
        this.Telephone = Telephone;
    }

    @Id
    @Column(name = "Id_Client")
    public Integer getIdClient() {
        return Id_Client;
    }

    public void setIdClient(Integer Id_Client) {
        this.Id_Client = Id_Client;
    }

    @Column(name = "Nom", length = 20, nullable = false)
    public String getDeptNo() {
        return Nom;
    }

    public void setNom(String Nom) {
        this.Nom = Nom;
    }

    @Column(name = "Prenom", nullable = false)
    public String getDeptName() {
        return Prenom;
    }

    public void setPrenom(String Prenom) {
        this.Prenom = Prenom;
    }

    @Column(name = "Telephone")
    public String getTelephone() {
        return Telephone;
    }

    public void setTelephone(String Telephone) {
        this.Telephone = Telephone;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "Client")
    public Set<Commande> getCommandes() {
        return commandes;
    }

    public void setCommandes(Set<Commande> commandes) {
        this.commandes = commandes;
    }



}


