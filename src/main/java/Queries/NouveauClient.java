package Queries;

import Entities.Client;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class NouveauClient {
    public static void main(String[] args) {

        SessionFactory factory = HibernateUtils.getSessionFactory();

        Session session = factory.getCurrentSession();
        Client client = null;
        
        try {
            session.getTransaction().begin();

            client = new Client();
            client.setNom("Milos");
            client.setPrenom("Ricardo");
            client.setTelephone("0636426996");

            session.persist(client);

            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }

        assert client != null;
        System.out.println("Nom dernier client: " + client.getNom());
    }
}
