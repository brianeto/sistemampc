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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Andres
 */
@Entity
@Table(name = "sectores_economicos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SectorEconomico.findAll", query = "SELECT s FROM SectorEconomico s")
    , @NamedQuery(name = "SectorEconomico.findById", query = "SELECT s FROM SectorEconomico s WHERE s.id = :id")
    , @NamedQuery(name = "SectorEconomico.findByNombre", query = "SELECT s FROM SectorEconomico s WHERE s.nombre = :nombre")})
public class SectorEconomico implements Serializable, Entidad {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nombre")
    private int nombre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sectorEconomicoId")
    private List<Empresa> empresaList;

    public SectorEconomico() {
    }

    public SectorEconomico(Integer id) {
        this.id = id;
    }

    public SectorEconomico(Integer id, int nombre) {
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

    public int getNombre() {
        return nombre;
    }

    public void setNombre(int nombre) {
        this.nombre = nombre;
    }

    @XmlTransient
    public List<Empresa> getEmpresaList() {
        return empresaList;
    }

    public void setEmpresaList(List<Empresa> empresaList) {
        this.empresaList = empresaList;
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
        if (!(object instanceof SectorEconomico)) {
            return false;
        }
        SectorEconomico other = (SectorEconomico) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "proyectompc.entidades.SectorEconomico[ id=" + id + " ]";
    }
    
}
