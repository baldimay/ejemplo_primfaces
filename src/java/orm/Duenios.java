/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package orm;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author may
 */
@Entity
@Table(name = "Duenios")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Duenios.findAll", query = "SELECT d FROM Duenios d"),
    @NamedQuery(name = "Duenios.findByIdDuenio", query = "SELECT d FROM Duenios d WHERE d.idDuenio = :idDuenio"),
    @NamedQuery(name = "Duenios.findByApellido", query = "SELECT d FROM Duenios d WHERE d.apellido = :apellido"),
    @NamedQuery(name = "Duenios.findByNombre", query = "SELECT d FROM Duenios d WHERE d.nombre = :nombre"),
    @NamedQuery(name = "Duenios.findByDir", query = "SELECT d FROM Duenios d WHERE d.dir = :dir"),
    @NamedQuery(name = "Duenios.findByTel", query = "SELECT d FROM Duenios d WHERE d.tel = :tel")})
public class Duenios implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_duenio")
    private Integer idDuenio;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "apellido")
    private String apellido;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 24)
    @Column(name = "nombre")
    private String nombre;
    @Size(max = 50)
    @Column(name = "dir")
    private String dir;
    @Size(max = 10)
    @Column(name = "tel")
    private String tel;

    public Duenios() {
    }

    public Duenios(Integer idDuenio) {
        this.idDuenio = idDuenio;
    }

    public Duenios(Integer idDuenio, String apellido, String nombre) {
        this.idDuenio = idDuenio;
        this.apellido = apellido;
        this.nombre = nombre;
    }

    public Integer getIdDuenio() {
        return idDuenio;
    }

    public void setIdDuenio(Integer idDuenio) {
        this.idDuenio = idDuenio;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDir() {
        return dir;
    }

    public void setDir(String dir) {
        this.dir = dir;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDuenio != null ? idDuenio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Duenios)) {
            return false;
        }
        Duenios other = (Duenios) object;
        if ((this.idDuenio == null && other.idDuenio != null) || (this.idDuenio != null && !this.idDuenio.equals(other.idDuenio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "orm.Duenios[ idDuenio=" + idDuenio + " ]";
    }
    
}
