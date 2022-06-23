package tp_hibernate.Entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "Produit",
        uniqueConstraints = { @UniqueConstraint(columnNames = { "IdProduit" }) })
public class Produit {

    private Integer Id_Produit;
    private String Nom;
    private Float Prix;
    private Set<Commande> commandes = new HashSet<Commande>(0);


    public Produit() {
    }

    public Produit(Integer Id_Produit, String Nom, Float Prix) {
        this.Id_Produit = Id_Produit;
        this.Nom = Nom;
        this.Prix = Prix;
    }

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "Id_Produit")
    public Integer getIdproduit() {
        return Id_Produit;
    }


    @Column(name = "Nom", nullable = false)
    public String getNom() {
        return Nom;
    }

    public void setNom(String Nom) {
        this.Nom = Nom;
    }

    @Column(name = "Prix", nullable = false)
    public Float getPrix() {
        return Prix;
    }

    public void setPrix(Float Prix) {
        this.Prix = Prix;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "Produit")
    public Set<Commande> getCommandes() {
        return commandes;
    }

    public void setCommandes(Set<Commande> commandes) {
        this.commandes = commandes;
    }

}


