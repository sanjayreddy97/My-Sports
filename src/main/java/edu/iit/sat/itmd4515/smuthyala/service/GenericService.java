/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.iit.sat.itmd4515.smuthyala.service;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * General service class for all the service classes.
 * @author smuthyala
 */
 /**
 * @param <T>
 */
public abstract class GenericService<T> {
    
    /**
     *
     */
    @PersistenceContext(name ="itmd4515PU")
    protected EntityManager em;
    
    /**
     *
     */
    protected final Class<T> entityClass;

    /**
     *
     * @param entityClass
     */
    public GenericService(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    //CRUD operations

    /**
     *
     * @param entity
     */
    public void create(T entity){
        em.persist(entity);
    }
    
    /**
     *
     * @param id
     * @return
     */
    public T read(Long id){
        return em.find(entityClass, id);
    }
    
    /**
     *
     * @param entity
     */
    public void update(T entity){
        em.merge(entity);
    }
    
    /**
     *
     * @param entity
     */
    public void delete(T entity){
        em.remove(em.merge(entity));
    }
    
    /**
     *
     * @return
     */
    abstract public List<T> findAll();
}
