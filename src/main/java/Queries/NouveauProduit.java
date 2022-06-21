package Queries;

import java.util.Date;

import Entities.Produit;
import org.hibernate.Session;
import org.hibernate.SessionFactory;



public class NouveauProduit {

    public static void main(String[] args) {

        SessionFactory factory = HibernateUtils.getSessionFactory();

        Session session = factory.getCurrentSession();
        Produit produit = null;

        try {
            session.getTransaction().begin();

            // Create transient object
            produit = new Produit();
            produit.setNom("Zbigznah32Z");
            produit.setPrix(12.5f);


            // Using persist(..)
            // Now 'emp' is managed by Hibernate.
            // it has Persistent status.
            // No action at this time with DB.
            session.persist(produit);


            // At this step the data is pushed to the DB.
            // Execute Insert statement.
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }

        // After the session is closed (commit, rollback, close)
        // Objects 'emp', 'dept' became the Detached objects.
        // It is no longer in the control of the session.
        System.out.println("Produit No: " + produit.getIdproduit());

    }

}