/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.MascotasDao;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.event.ActionEvent;
import javax.faces.event.AjaxBehaviorEvent;
import orm.Mascota;

/**
 *
 * @author may
 */
@ManagedBean
@RequestScoped
public class MascotasController {

   private List<Mascota> listaMascotas;
   private Mascota mascotas;
   
   private String titulo;
   private String nomBuscar;
   
   @EJB
    MascotasDao mDao;
    
    
    public MascotasController() {
        mascotas = new Mascota();
    }
    
    public List<Mascota> getListMascotas()
    {
        if(listaMascotas == null)
        {
            listaMascotas = mDao.ListarMascotas();
        }
        return listaMascotas;
    }
    
    public void setListaMascotas(List<Mascota> listaMascotas)
    {
        this.listaMascotas = listaMascotas;
    }
    
    public Mascota getMascotas()
    {
        return mascotas;
    }
    
    public void setMascota(Mascota mascotas)
    {
        this.mascotas = mascotas;
    }
    
    public String doIndex()
    {
        return "index";
    }
    
    public String doNuevo()
    {
        titulo = "Nueva Mascota";
        mascotas = new Mascota();
        return "nuevo";
    }
    
    public String doEditar(Mascota m)
    {
        mascotas = m;
        titulo = "Editar Mascota";
        return  "nuevo";
    }
    
    public void doBuscar(AjaxBehaviorEvent e)
    {
        listaMascotas = mDao.ListarMascotas(nomBuscar);
    }
    
    public void doVerNuevo(ActionEvent actionEvent)
    {
        mascotas = new Mascota();
    }
    
    public void doGuardar(ActionEvent event)
    {
        
    }
   
    
    
}
