package edu.iit.itmd4515.smuthyala.domain;


import edu.iit.itmd4515.smuthyala.domain.League;
import java.time.LocalDate;
import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
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
public class LeagueValidationTest {
     private static Validator validator;
    
    /**
     *
     */
    @BeforeAll
    public static void beforeAll(){
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }
    
    /**
     *
     */
    @BeforeEach
    public void beforeEach(){}
    
    // test methods execute test cases, and we asset pass/fail.

    /**
     *
     */
    @Test
    public void testLongLeagueName(){
        League l = new League(SportType.CRICKET, "Test league too long name", LocalDate.of(2013, 5,10), LocalDate.of(2013, 8,21),120000);
        
        Set<ConstraintViolation<League>> violations = validator.validate(l);
        
        for(ConstraintViolation<League> violation : violations){
            System.out.println(violation.toString());
        }
        
       assertEquals(1, violations.size());
       assertEquals("size must be between 1 and 20", violations.iterator().next().getMessage());
    }
    
    /**
     *
     */
    @AfterEach
    public void afterEach(){}
    
    /**
     *
     */
    @AfterAll
    public static void afterAll(){}
}
