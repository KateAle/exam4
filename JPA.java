package ru.itmo.ex4;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;


public class JPA {
    public static void main(String[] args) {
        try (EntityManagerFactory emf = Persistence.createEntityManagerFactory("groups");
             EntityManager manager = emf.createEntityManager()) {

            Mountain mount01 = new Mountain("Everest", "China", 8_848.86);
            Mountain mount02 = new Mountain("Montblanc", "France", 4_810);
            Mountain mount03 = new Mountain("Ararat", "Turkey", 5_165);


            Climber climber01 = new Climber("Fill Grey", "Bern, Switzerland");
            Climber climber02 = new Climber("Chris Smith", "Edinburgh, Scotland");
            Climber climber03 = new Climber("Alexander Roy", "Amsterdam, Netherlands");
            Climber climber04 = new Climber("Oleg Smirnov", "Kazan, Russia");
            Climber climber05 = new Climber("John Park", "Helsinki, Finland");
            Climber climber06 = new Climber("David Crown", "Cairo, Egypt");
            Climber climber07 = new Climber("Nik West", "Prague, Czech");

            Group group01 = new Group(mount01,"2023-05-02","2023-05-12", false);

            Group group02 = new Group(mount02,"2023-06-02","2023-06-12", false);

            Group group03 = new Group(mount03,"2023-07-02","2023-07-12", true);

            manager.getTransaction().begin();
            manager.persist(group01);
            manager.persist(climber01);
            manager.getTransaction().commit();

            //System.out.println(manager.find(Climber.class, climber02).getAddress());

        }

    }
}
