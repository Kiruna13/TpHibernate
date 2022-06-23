package tp_hibernate.Queries;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import tp_hibernate.Entities.Client;
import tp_hibernate.Entities.Commande;
import tp_hibernate.HibernateUtils;

import java.util.List;

public class RequetesCommande {
    SessionFactory factory = HibernateUtils.getSessionFactory();
    Session session = factory.getCurrentSession();

    public void allCommandesClient(){
        try {
            session.getTransaction().begin();

            String sql = "SELECT co.id_commande, co.date_commande, co.heure_commande FROM " + Commande.class.getName() + " co " +
                    "INNER JOIN "+ Client.class.getName() +" cl on cl.id_client = co.client " +
                    "WHERE cl.nom_client = :nom_client " +
                    "OR cl.prenom_client = :prenom_client " +
                    "OR cl.telephone_client = :telephone_client";

            // Create Query object.
            Query<Commande> query = session.createQuery(sql, Commande.class);

            query.setParameter("nom_client", "Goncalves");

            // Execute query.
            List<Commande> commandes = query.getResultList();

            for (Commande co : commandes) {
                System.out.println("Commandes client " + co.getDateCommande() + " : "
                        + co.getHeureCommande());
            }

            // Commit data.
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            // Rollback in case of an error occurred.
            session.getTransaction().rollback();
        }
    }

    public void lastCommandeClient(){
        try {
            session.getTransaction().begin();

            String sql = "SELECT co.date_commande, co.heure_commande FROM " + Commande.class.getName() + " co " +
                    "INNER JOIN "+ Client.class.getName() +" cl on cl.id_client = co.client " +
                    "WHERE cl.nom_client = :nom_client" +
                    "OR cl.prenom_client = :prenom_client " +
                    "OR cl.telephone_client = :telephone_client " +
                    "ORDER BY co.date_commande DESC, co.heure_commande DESC, LIMIT (1)";

            // Create Query object.
            Query<Commande> query = session.createQuery(sql, Commande.class);

            query.setParameter("nom_client", "Ducoulombier");

            // Execute query.
            List<Commande> commandes = query.getResultList();

            for (Commande co : commandes) {
                System.out.println("Dernière commande cliente " + co.getDateCommande() + " : "
                        + co.getHeureCommande());
            }

            // Commit data.
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            // Rollback in case of an error occurred.
            session.getTransaction().rollback();
        }
    }
}
