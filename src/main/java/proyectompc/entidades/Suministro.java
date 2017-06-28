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
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
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
@Table(name = "suministros")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Suministro.findAll", query = "SELECT s FROM Suministro s")
    , @NamedQuery(name = "Suministro.findById", query = "SELECT s FROM Suministro s WHERE s.id = :id")
    , @NamedQuery(name = "Suministro.findByNombre", query = "SELECT s FROM Suministro s WHERE s.nombre = :nombre")})
public class Suministro implements Serializable, Entidad {

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
    @Lob
    @Size(max = 65535)
    @Column(name = "descripcion")
    private String descripcion;
    @ManyToMany(mappedBy = "suministroList")
    private List<Mantenimiento> mantenimientoList;
    @JoinColumn(name = "tipo_suministro_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private TipoSuministro tipoSuministroId;
    @JoinColumn(name = "sistema_vehiculo_id", referencedColumnName = "id")
    @ManyToOne
    private SistemaVehiculo sistemaVehiculoId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "suministroId")
    private List<ProveedorSuministro> proveedorSuministroList;

    public Suministro() {
    }

    public Suministro(Integer id) {
        this.id = id;
    }

    public Suministro(Integer id, String nombre) {
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @XmlTransient
    public List<Mantenimiento> getMantenimientoList() {
        return mantenimientoList;
    }

    public void setMantenimientoList(List<Mantenimiento> mantenimientoList) {
        this.mantenimientoList = mantenimientoList;
    }

    public TipoSuministro getTipoSuministroId() {
        return tipoSuministroId;
    }

    public void setTipoSuministroId(TipoSuministro tipoSuministroId) {
        this.tipoSuministroId = tipoSuministroId;
    }

    public SistemaVehiculo getSistemaVehiculoId() {
        return sistemaVehiculoId;
    }

    public void setSistemaVehiculoId(SistemaVehiculo sistemaVehiculoId) {
        this.sistemaVehiculoId = sistemaVehiculoId;
    }

    @XmlTransient
    public List<ProveedorSuministro> getProveedorSuministroList() {
        return proveedorSuministroList;
    }

    public void setProveedorSuministroList(List<ProveedorSuministro> proveedorSuministroList) {
        this.proveedorSuministroList = proveedorSuministroList;
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
        if (!(object instanceof Suministro)) {
            return false;
        }
        Suministro other = (Suministro) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "proyectompc.entidades.Suministro[ id=" + id + " ]";
    }
    
}
