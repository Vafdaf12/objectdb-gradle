package odb.gradle;

import javax.persistence.Persistence;

public class App {
    public static void main(String[] args) {
        // Creates a DB file at db/points.odb
        var emf = Persistence.createEntityManagerFactory("objectdb:db/points.odb");
        var em = emf.createEntityManager();

        em.getTransaction().begin();
        for (int i = 0; i < 20; i++) {
            var p = new Point(i, i);
            em.persist(p);
        }
        em.getTransaction().commit();

        // Find the number of Point objects in the database:
        var q1 = em.createQuery("SELECT COUNT(p) FROM Point p");
        System.out.println("Total Points: " + q1.getSingleResult());

        // Find the average X value:
        var q2 = em.createQuery("SELECT AVG(p.x) FROM Point p");
        System.out.println("Average X: " + q2.getSingleResult());

        // Retrieve all the Point objects from the database:
        var query = em.createQuery("SELECT p FROM Point p", Point.class);
        var results = query.getResultList();
        for (Point p : results) {
            System.out.println(p);
        }

        // Close the database connection:
        em.close();
        emf.close();
    }
}