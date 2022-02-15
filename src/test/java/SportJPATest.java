
import edu.iit.itmd4515.smuthyala.domain.Sport;
import edu.iit.itmd4515.smuthyala.domain.SportType;
import java.time.LocalDate;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author sanjayreddy
 */
public class SportJPATest {
    private static final Logger LOG = Logger.getLogger(SportJPATest.class.getName());
    
    
    private static EntityManagerFactory emf;
    private EntityManager em;
    private EntityTransaction tx;
    
    @BeforeAll
    public static void beforeAll(){
        emf = Persistence.createEntityManagerFactory("itmd4515testPU");
    }
    
    @BeforeEach
    public void beforeEach(){
        em = emf.createEntityManager();
        tx = em.getTransaction();
        
        Sport test =  new Sport("Test sport", LocalDate.of(2019,6,2),LocalDate.of(2019,9,24),SportType.BASEBALL);
        tx.begin();
        em.persist(test);
        tx.commit();
    }
    
    @Test
    public void create(){
        
        //create an entity
        Sport create = new Sport("create sport", LocalDate.of(2021,8,2),LocalDate.of(2021,10,30),SportType.RUGBY);
        
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
        Sport test =  new Sport("Test Delete", LocalDate.of(2009,3,2),LocalDate.of(2009,6,12),SportType.HANDBALL);
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
