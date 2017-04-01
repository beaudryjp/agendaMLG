
package grupog.agendamlg;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
* Main.java
*
* Mar 23, 2017
* @author Jean Paul Beaudry & Javier Aguilera Puerta
*/
public class Main {
    public static void main(String[] string) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("agendaMLG");
        EntityManager em = emf.createEntityManager();
//        em.getTransaction().begin();
//        Provincia p = new Provincia();
//        p.setId_provincia(1L);
//        p.setNombre("Málaga");
//        Localidad l = new Localidad();
//        l.setId_localidad(1L);
//        l.setNombre("Nerja");
//        l.setProvincia(p);
//        em.persist(p);
//        em.persist(l);
//        em.getTransaction().commit();
        em.close();
        emf.close();

    }
}
