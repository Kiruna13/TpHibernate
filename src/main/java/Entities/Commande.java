package Entities;

import javax.persistence.*;
import java.sql.Time;
import java.util.Date;


@Entity
@Table(name = "Client",
        uniqueConstraints = { @UniqueConstraint(columnNames = { "IdCommande" }) })
public class Commande {

    private Integer IdCommande;
    private Date Date;
    private Time Heure;
    private Produit Article;
    private Client Client;

    public Commande() {
    }

    public Commande(Integer IdCommande, Date Date, Time Heure, Produit Article, Client Client) {
        this.IdCommande = IdCommande;
        this.Date = Date;
        this.Heure = Heure;
        this.Article = Article;
        this.Client = Client;
    }

    @Id
    @Column(name = "Id_Commande")
    public Integer getIdClient() {
        return IdCommande;
    }

    public void setIdClient(Integer IdCommande) {
        this.IdCommande = IdCommande;
    }

    @Column(name = "Date", nullable = false)
    public Date getDate() {
        return Date;
    }

    public void setDate(Date Date) {
        this.Date = Date;
    }

    @Column(name = "Heure", nullable = false)
    public Time getHeure() {
        return Heure;
    }

    public void setHeure(Time Heure) {
        this.Heure = Heure;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Id_Produit")
    public Produit getArticle() {
        return Article;
    }

    public void setArticle(Produit Article) {
        this.Article = Article;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Id_Client")
    public Client getClient() {
        return Client;
    }

    public void setClient(Client Client) {
        this.Client = Client;
    }
}


