/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mum.edu.cs.cs490.mycompany.dao;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;

/**
 *
 * @author bOyunchimeg
 */
public abstract class GenericDAO<T> {
    
    @PersistenceContext
    private EntityManager em;
    
    private Class<T> entityClass;

    public GenericDAO(Class<T> entityClass) {
        this.entityClass = entityClass;
    }
    
    public boolean save(T entity){
        try{
            em.persist(entity);
        }catch(Exception ex){
            ex.printStackTrace();
            
            return false;
        }
        
        return true;
    }
    
    public void delete(Object id, Class<T> ref){
        T entityToRemove = em.getReference(ref, id);
        
        em.remove(entityToRemove);
    }
    
    public void update(T entity){
        em.merge(entity);
    }
    
    public List<T> getAll(){
        CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        
        cq.select(cq.from(entityClass));
        
        return em.createQuery(cq).getResultList();
    }
    
    public T getObject(Object id, Class<T> ref){
        return em.find(ref, id);
    }
    
    protected T findOneResult(String namedQuery, Map<String, Object> parameters) {
        T result = null;
 
        try {
            Query query = em.createNamedQuery(namedQuery);
 
            // Method that will populate parameters if they are passed not null and empty
            if (parameters != null && !parameters.isEmpty()) {
                populateQueryParameters(query, parameters);
            }
 
            // fetching result in here
            result = (T) query.getSingleResult();
 
        } catch (Exception e) {
            System.out.println("Error while running query: " + e.getMessage());
            e.printStackTrace();
        }
 
        return result;
    }
 
    private void populateQueryParameters(Query query, Map<String, Object> parameters) {
 
        for (Entry<String, Object> entry : parameters.entrySet()) {
            query.setParameter(entry.getKey(), entry.getValue());
        }
    }
    
}
