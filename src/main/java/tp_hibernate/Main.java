package tp_hibernate;

import tp_hibernate.Queries.NouveauClient;
import tp_hibernate.Queries.NouveauProduit;
import tp_hibernate.Queries.RequetesCommande;

public class Main {
    public static void main(String[] args) {
        //new NouveauProduit().addProduit();
        //new NouveauClient().addClient();
        new RequetesCommande().allCommandesClient();
        //new RequetesCommande().lastCommandeClient();
    }
}
