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

            String sql = "SELECT co.idCommande, co.dateCommande, co.heureCommande FROM " + Commande.class.getName() + " co " +
                    "INNER JOIN "+ Client.class.getName() +" cl on cl.idClient = co.client " +
                    "WHERE cl.nomClient = :nomClient " +
                    "OR cl.prenomClient = :prenomClient " +
                    "OR cl.telephoneClient = :telephoneClient";

            // Create Query object.
            Query<Commande> query = session.createQuery(sql, Commande.class);

            query.setParameter("nomClient", "Goncalves");
            query.setParameter("prenomClient", "Laura");
            query.setParameter("telephoneClient", "0785142618");

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

            String sql = "SELECT co.dateCommande, co.heureCommande FROM " + Commande.class.getName() + " co " +
                    "INNER JOIN "+ Client.class.getName() +" cl on cl.idClient = co.client " +
                    "WHERE cl.nomClient = :nomClient " +
                    "OR cl.prenomClient = :prenomClient " +
                    "OR cl.telephoneClient = :telephoneClient " +
                    "ORDER BY co.dateCommande DESC, co.heureCommande DESC, LIMIT (1)";

            // Create Query object.
            Query<Commande> query = session.createQuery(sql, Commande.class);

            query.setParameter("nomClient", "Ducoulombier");
            query.setParameter("prenomClient", "Thomas");
            query.setParameter("telephoneClient", "0695690715");

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
