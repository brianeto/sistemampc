/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectompc.entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Andres
 */
@Entity
@Table(name = "mantenimientos_documentos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MantenimientoDocumento.findAll", query = "SELECT m FROM MantenimientoDocumento m")
    , @NamedQuery(name = "MantenimientoDocumento.findById", query = "SELECT m FROM MantenimientoDocumento m WHERE m.id = :id")
    , @NamedQuery(name = "MantenimientoDocumento.findByNombre", query = "SELECT m FROM MantenimientoDocumento m WHERE m.nombre = :nombre")
    , @NamedQuery(name = "MantenimientoDocumento.findByDireccion", query = "SELECT m FROM MantenimientoDocumento m WHERE m.direccion = :direccion")})
public class MantenimientoDocumento implements Serializable, Entidad {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "direccion")
    private String direccion;
    @JoinColumn(name = "mantenimiento_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Mantenimiento mantenimientoId;

    public MantenimientoDocumento() {
    }

    public MantenimientoDocumento(Integer id) {
        this.id = id;
    }

    public MantenimientoDocumento(Integer id, String nombre, String direccion) {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
    }

    @Override
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Mantenimiento getMantenimientoId() {
        return mantenimientoId;
    }

    public void setMantenimientoId(Mantenimiento mantenimientoId) {
        this.mantenimientoId = mantenimientoId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MantenimientoDocumento)) {
            return false;
        }
        MantenimientoDocumento other = (MantenimientoDocumento) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "proyectompc.entidades.MantenimientoDocumento[ id=" + id + " ]";
    }
    
}
