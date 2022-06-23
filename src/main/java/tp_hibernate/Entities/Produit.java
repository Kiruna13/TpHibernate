package tp_hibernate.Entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "produit",
        uniqueConstraints = { @UniqueConstraint(columnNames = { "id_produit" }) })
public class Produit {

    private Integer id_produit;
    private String nom_produit;
    private Float prix;
    private Set<Commande> commandes = new HashSet<Commande>(0);


    public Produit() {
    }

    public Produit(Integer id_produit, String nom_produit, Float prix) {
        this.id_produit = id_produit;
        this.nom_produit = nom_produit;
        this.prix = prix;
    }

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "id_produit")
    public Integer getIdProduit() {
        return id_produit;
    }

    @Column(name = "nom_produit", nullable = false)
    public String getNomProduit() {
        return nom_produit;
    }

    public void setNomProduit(String nom_produit) {
        this.nom_produit = nom_produit;
    }

    @Column(name = "prix", nullable = false)
    public Float getPrix() {
        return prix;
    }

    public void setPrix(Float prix) {
        this.prix = prix;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "Produit")
    public Set<Commande> getCommandes() {
        return commandes;
    }

    public void setCommandes(Set<Commande> commandes) {
        this.commandes = commandes;
    }

}


