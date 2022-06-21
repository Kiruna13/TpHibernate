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

            produit = new Produit();
            produit.setNom("Zbigznah32Z");
            produit.setPrix(12.5f);

            session.persist(produit);

            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }

        System.out.println("Produit No: " + produit.getIdproduit());

    }

}