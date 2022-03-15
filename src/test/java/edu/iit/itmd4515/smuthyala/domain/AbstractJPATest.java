/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.iit.itmd4515.smuthyala.domain;

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
        
        Sport test =  new Sport("Test sport",SportType.HANDBALL);
        tx.begin();
        em.persist(test);
        tx.commit();
    }
    
    @AfterEach
    public void afterEach(){
        Sport test = em.createQuery("Select s from Sport s where s.leagueName= 'Test sport'", Sport.class).getSingleResult();
        
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
