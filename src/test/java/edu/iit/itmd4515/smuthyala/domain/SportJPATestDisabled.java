package edu.iit.itmd4515.smuthyala.domain;


import edu.iit.itmd4515.smuthyala.domain.Sport;
import edu.iit.itmd4515.smuthyala.domain.SportType;
import java.util.logging.Logger;
import javax.persistence.Persistence;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.Test;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author sanjayreddy
 */
public class SportJPATestDisabled extends AbstractJPATest{
    
    private static final Logger LOG = Logger.getLogger(SportJPATestDisabled.class.getName());
    
    @Test
    public void create(){
        
        //create an entity
        Sport create = new Sport("create sport",SportType.RUGBY);
        
        tx.begin();
        em.persist(create);
        tx.commit();
        
        //assert successful creation by reading it back
        
        Sport readBackFromDatabaseToVerifyCreate = 
                em.createQuery("Select s from Sport s where s.leagueName= 'create sport'", Sport.class).getSingleResult();
        
        assertEquals("create sport", readBackFromDatabaseToVerifyCreate.getLeagueName());
        
        LOG.info("Create test case:" + readBackFromDatabaseToVerifyCreate.getLeagueName());
        
        //cleanup
        tx.begin();
        em.remove(create);
        tx.commit();
        
    }
    
    @Test
    public void read(){
        Sport readBackFromDatabaseToVerfiyRead = em.createQuery("Select s from Sport s where s.leagueName = 'Test sport'", Sport.class).getSingleResult();
        
        LOG.info("Read test case: " + readBackFromDatabaseToVerfiyRead.getLeagueName());
        
        assertNotNull(readBackFromDatabaseToVerfiyRead);
        assertEquals("Test sport", readBackFromDatabaseToVerfiyRead.getLeagueName());
    }
    
    @Test
    public void update(){
        //we can work with the beforeEach test data
        Sport test = em.createQuery("Select s from Sport s where s.leagueName = 'Test sport'", Sport.class).getSingleResult();
        
        //make an update and write it to the database.
        tx.begin();
        test.setType(SportType.SOCCER);
        tx.commit();
        
        //read it back from the database.
        Sport readBackFromDatabaseToVerifyChange = 
                em.createQuery("Select s from Sport s where s.leagueName = 'Test sport'", Sport.class).getSingleResult();
        
        LOG.info("Update test case:" + readBackFromDatabaseToVerifyChange.getType());
        
        //assert change was succefull
        assertEquals(SportType.SOCCER, readBackFromDatabaseToVerifyChange.getType());
        
    }
    
    @Test
    public void delete(){
        Sport test =  new Sport("Test Delete",SportType.HANDBALL);
        tx.begin();
        em.persist(test);
        tx.commit();
        
        assertNotNull(test.getSportId());
        LOG.info("Delete test case: " + test.toString());
        
        tx.begin();
        em.remove(test);
        tx.commit();
        
        Sport checkIfSportDeleted = em.find(Sport.class, test.getSportId());
        assertNull(checkIfSportDeleted);
        
    }
    
}
