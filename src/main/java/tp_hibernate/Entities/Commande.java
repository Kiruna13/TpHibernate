package tp_hibernate.Entities;

import javax.persistence.*;
import java.sql.Time;
import java.util.Date;


@Entity
@Table(name = "commande",
        uniqueConstraints = { @UniqueConstraint(columnNames = { "id_commande" }) })
public class Commande {

    private Integer id_commande;
    private Date date_commande;
    private Time heure_commande;
    private Produit article;
    private Client client;

    public Commande() {
    }

    public Commande(Integer id_commande, Date date_commande, Time heure_commande, Produit article, Client client) {
        this.id_commande = id_commande;
        this.date_commande = date_commande;
        this.heure_commande = heure_commande;
        this.article = article;
        this.client = client;
    }

    @Id
    @Column(name = "id_commande")
    public Integer getIdCommande() {
        return id_commande;
    }

    public void setIdcommande(Integer id_commande) {
        this.id_commande = id_commande;
    }

    @Column(name = "date_commande", nullable = false)
    public Date getDateCommande() {
        return date_commande;
    }

    public void setDateCommande(Date date_commande) {
        this.date_commande = date_commande;
    }

    @Column(name = "heure_commande", nullable = false)
    public Time getHeureCommande() {
        return heure_commande;
    }

    public void setHeureCommande(Time heure_commande) {
        this.heure_commande = heure_commande;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "article")
    public Produit getArticle() {
        return article;
    }

    public void setArticle(Produit article) {
        this.article = article;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client")
    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}


