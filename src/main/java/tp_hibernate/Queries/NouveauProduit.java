package tp_hibernate.Queries;

import tp_hibernate.Entities.Produit;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import tp_hibernate.HibernateUtils;

public class NouveauProduit {

    public void addProduit() {

        SessionFactory factory = HibernateUtils.getSessionFactory();

        Session session = factory.getCurrentSession();
        Produit produit = null;

        try {
            session.getTransaction().begin();

            produit = new Produit();
            produit.setNomProduit("Zbigznah32Z");
            produit.setPrix(12.5f);

            session.persist(produit);

            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }

        System.out.println("Produit No: " + produit.getIdProduit());

    }

}