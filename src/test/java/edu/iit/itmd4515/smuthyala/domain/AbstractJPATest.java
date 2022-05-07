/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.iit.itmd4515.smuthyala.domain;

import java.time.LocalDate;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

/**
 *
 * @author sanjayreddy
 */
public class AbstractJPATest {
    protected static EntityManagerFactory emf;
    protected EntityManager em;
    protected EntityTransaction tx;
    
    @BeforeAll
    public static void beforeAll(){
        emf = Persistence.createEntityManagerFactory("itmd4515testPU");
    }
    
    @BeforeEach
    public void beforeEach(){
        em = emf.createEntityManager();
        tx = em.getTransaction();
        
        League l = new League(SportType.CRICKET, "League_Test", LocalDate.of(2013, 5,10), LocalDate.of(2013, 8,21),120000);
        tx.begin();
        em.persist(l);
        tx.commit();
    }
    
    @AfterEach
    public void afterEach(){
        League test = em.createQuery("Select l from League l where l.leagueName= 'League_Test'", League.class).getSingleResult();
        
        tx.begin();
        em.remove(test);
        tx.commit();
        
        em.close();
    }
    
    @AfterAll
    public static void afterAll(){
        emf.close();
    }
}
