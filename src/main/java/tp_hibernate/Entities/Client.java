package tp_hibernate.Entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "client",
        uniqueConstraints = { @UniqueConstraint(columnNames = { "id_client" }) })
public class Client {

    private Integer id_client;
    private String nom_client;
    private String prenom_client;
    private String telephone_client;
    private Set<Commande> commandes = new HashSet<Commande>(0);

    public Client() {
    }

    public Client(Integer id_client, String nom_client, String prenom_client, String telephone_client) {
        this.id_client = id_client;
        this.nom_client = nom_client;
        this.prenom_client = prenom_client;
        this.telephone_client = telephone_client;
    }

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "id_client")
    public Integer getIdClient() {
        return id_client;
    }

    @Column(name = "nom_client", length = 20, nullable = false)
    public String getNomClient() {
        return nom_client;
    }

    public void setNomClient(String nom_client) {
        this.nom_client = nom_client;
    }

    @Column(name = "prenom_client", nullable = false)
    public String getPrenomClient() {
        return prenom_client;
    }

    public void setPrenomClient(String prenom_client) {
        this.prenom_client = prenom_client;
    }

    @Column(name = "telephone_client")
    public String getTelephoneClient() {
        return telephone_client;
    }

    public void setTelephoneClient(String telephone_client) {
        this.telephone_client = telephone_client;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "client")
    public Set<Commande> getCommandes() {
        return commandes;
    }

    public void setCommandes(Set<Commande> commandes) {
        this.commandes = commandes;
    }



}


