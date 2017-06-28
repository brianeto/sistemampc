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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Andres
 */
@Entity
@Table(name = "proveedores_suministros")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProveedorSuministro.findAll", query = "SELECT p FROM ProveedorSuministro p")
    , @NamedQuery(name = "ProveedorSuministro.findById", query = "SELECT p FROM ProveedorSuministro p WHERE p.id = :id")
    , @NamedQuery(name = "ProveedorSuministro.findByPrecio", query = "SELECT p FROM ProveedorSuministro p WHERE p.precio = :precio")})
public class ProveedorSuministro implements Serializable, Entidad {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "precio")
    private Long precio;
    @JoinColumn(name = "proveedor_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Proveedor proveedorId;
    @JoinColumn(name = "suministro_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Suministro suministroId;

    public ProveedorSuministro() {
    }

    public ProveedorSuministro(Integer id) {
        this.id = id;
    }

    @Override
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getPrecio() {
        return precio;
    }

    public void setPrecio(Long precio) {
        this.precio = precio;
    }

    public Proveedor getProveedorId() {
        return proveedorId;
    }

    public void setProveedorId(Proveedor proveedorId) {
        this.proveedorId = proveedorId;
    }

    public Suministro getSuministroId() {
        return suministroId;
    }

    public void setSuministroId(Suministro suministroId) {
        this.suministroId = suministroId;
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
        if (!(object instanceof ProveedorSuministro)) {
            return false;
        }
        ProveedorSuministro other = (ProveedorSuministro) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "proyectompc.entidades.ProveedorSuministro[ id=" + id + " ]";
    }
    
}
