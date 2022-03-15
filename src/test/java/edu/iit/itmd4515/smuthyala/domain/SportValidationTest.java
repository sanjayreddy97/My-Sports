package edu.iit.itmd4515.smuthyala.domain;


import edu.iit.itmd4515.smuthyala.domain.Sport;
import edu.iit.itmd4515.smuthyala.domain.SportType;
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
public class SportValidationTest {
     private static Validator validator;
    
     @BeforeAll
    public static void beforeAll(){
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }
    
    @BeforeEach
    public void beforeEach(){}
    
    // test methods execute test cases, and we asset pass/fail.
    @Test
    public void testLongLeagueName(){
        Sport s = new Sport("Test Too Long leagueName",SportType.BASKETBALL);
        
        Set<ConstraintViolation<Sport>> violations = validator.validate(s);
        
        for(ConstraintViolation<Sport> violation : violations){
            System.out.println(violation.toString());
        }
        
       assertEquals(1, violations.size());
       assertEquals("size must be between 1 and 20", violations.iterator().next().getMessage());
    }
    
    
    @AfterEach
    public void afterEach(){}
    
    @AfterAll
    public static void afterAll(){}
}
