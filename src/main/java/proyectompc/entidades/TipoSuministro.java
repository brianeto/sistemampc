/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectompc.entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Andres
 */
@Entity
@Table(name = "tipos_suministros")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoSuministro.findAll", query = "SELECT t FROM TipoSuministro t")
    , @NamedQuery(name = "TipoSuministro.findById", query = "SELECT t FROM TipoSuministro t WHERE t.id = :id")
    , @NamedQuery(name = "TipoSuministro.findByNombre", query = "SELECT t FROM TipoSuministro t WHERE t.nombre = :nombre")})
public class TipoSuministro implements Serializable, Entidad {

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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoSuministroId")
    private List<Suministro> suministroList;

    public TipoSuministro() {
    }

    public TipoSuministro(Integer id) {
        this.id = id;
    }

    public TipoSuministro(Integer id, String nombre) {
        this.id = id;
        this.nombre = nombre;
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

    @XmlTransient
    public List<Suministro> getSuministroList() {
        return suministroList;
    }

    public void setSuministroList(List<Suministro> suministroList) {
        this.suministroList = suministroList;
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
        if (!(object instanceof TipoSuministro)) {
            return false;
        }
        TipoSuministro other = (TipoSuministro) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "proyectompc.entidades.TipoSuministro[ id=" + id + " ]";
    }
    
}
