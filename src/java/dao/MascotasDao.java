/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import orm.Mascota;

/**
 *
 * @author may
 */
@Stateless
public class MascotasDao {

    @PersistenceContext
    EntityManager em;
    
    public List<Mascota> ListarMascotas(){
        Query q;
        q = em.createQuery("SELECT m FROM Mascota m");
        return q.getResultList();
    }
    
    public List<Mascota> ListarMascotas(String nombre){
        Query q;
        q = em.createQuery("SELECT m FROM Mascota m WHERE m.nombre LIKE :nombre");
        q.setParameter("nombre", nombre);
        return  q.getResultList();
    }
    
    
}
