package tp_hibernate.Queries;

import org.hibernate.cfg.Configuration;
import tp_hibernate.HibernateUtils;
import tp_hibernate.Entities.Client;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class NouveauClient {
    public void addClient() {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();;

        Session session = factory.getCurrentSession();
        Client client = null;
        
        try {
            session.getTransaction().begin();

            client = new Client();
            client.setNomClient("Milos");
            client.setPrenomClient("Ricardo");
            client.setTelephoneClient("0636426996");

            session.persist(client);

            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }

        assert client != null;
        System.out.println("Nom dernier client: " + client.getNomClient());
    }
}
