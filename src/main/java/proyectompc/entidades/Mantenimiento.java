/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectompc.entidades;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Andres
 */
@Entity
@Table(name = "mantenimientos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Mantenimiento.findAll", query = "SELECT m FROM Mantenimiento m")
    , @NamedQuery(name = "Mantenimiento.findById", query = "SELECT m FROM Mantenimiento m WHERE m.id = :id")
    , @NamedQuery(name = "Mantenimiento.findByTotal", query = "SELECT m FROM Mantenimiento m WHERE m.total = :total")
    , @NamedQuery(name = "Mantenimiento.findByFechaRegistro", query = "SELECT m FROM Mantenimiento m WHERE m.fechaRegistro = :fechaRegistro")})
public class Mantenimiento implements Serializable, Entidad {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "total")
    private Long total;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_registro")
    @Temporal(TemporalType.DATE)
    private Date fechaRegistro;
    @JoinTable(name = "mantenimientos_suministos", joinColumns = {
        @JoinColumn(name = "mantenimiento_id", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "suministro_id", referencedColumnName = "id")})
    @ManyToMany
    private List<Suministro> suministroList;
    @JoinTable(name = "mantenimientos_sistemas", joinColumns = {
        @JoinColumn(name = "mantenimiento_id", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "sistema_vehiculo_id", referencedColumnName = "id")})
    @ManyToMany
    private List<SistemaVehiculo> sistemaVehiculoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "mantenimientoId")
    private List<MantenimientoDocumento> mantenimientoDocumentoList;
    @JoinColumn(name = "vehiculo_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Vehiculo vehiculoId;
    @JoinColumn(name = "empleado_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Empleado empleadoId;

    public Mantenimiento() {
    }

    public Mantenimiento(Integer id) {
        this.id = id;
    }

    public Mantenimiento(Integer id, String descripcion, Date fechaRegistro) {
        this.id = id;
        this.descripcion = descripcion;
        this.fechaRegistro = fechaRegistro;
    }

    @Override
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    @XmlTransient
    public List<Suministro> getSuministroList() {
        return suministroList;
    }

    public void setSuministroList(List<Suministro> suministroList) {
        this.suministroList = suministroList;
    }

    @XmlTransient
    public List<SistemaVehiculo> getSistemaVehiculoList() {
        return sistemaVehiculoList;
    }

    public void setSistemaVehiculoList(List<SistemaVehiculo> sistemaVehiculoList) {
        this.sistemaVehiculoList = sistemaVehiculoList;
    }

    @XmlTransient
    public List<MantenimientoDocumento> getMantenimientoDocumentoList() {
        return mantenimientoDocumentoList;
    }

    public void setMantenimientoDocumentoList(List<MantenimientoDocumento> mantenimientoDocumentoList) {
        this.mantenimientoDocumentoList = mantenimientoDocumentoList;
    }

    public Vehiculo getVehiculoId() {
        return vehiculoId;
    }

    public void setVehiculoId(Vehiculo vehiculoId) {
        this.vehiculoId = vehiculoId;
    }

    public Empleado getEmpleadoId() {
        return empleadoId;
    }

    public void setEmpleadoId(Empleado empleadoId) {
        this.empleadoId = empleadoId;
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
        if (!(object instanceof Mantenimiento)) {
            return false;
        }
        Mantenimiento other = (Mantenimiento) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "proyectompc.entidades.Mantenimiento[ id=" + id + " ]";
    }
    
}
