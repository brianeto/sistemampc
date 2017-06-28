/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectompc.entidades;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Andres
 */
@Entity
@Table(name = "ordenes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Orden.findAll", query = "SELECT o FROM Orden o")
    , @NamedQuery(name = "Orden.findById", query = "SELECT o FROM Orden o WHERE o.id = :id")
    , @NamedQuery(name = "Orden.findByFechaRegistro", query = "SELECT o FROM Orden o WHERE o.fechaRegistro = :fechaRegistro")
    , @NamedQuery(name = "Orden.findByPlazoMaximo", query = "SELECT o FROM Orden o WHERE o.plazoMaximo = :plazoMaximo")
    , @NamedQuery(name = "Orden.findByFechaEntrega", query = "SELECT o FROM Orden o WHERE o.fechaEntrega = :fechaEntrega")
    , @NamedQuery(name = "Orden.findByTotal", query = "SELECT o FROM Orden o WHERE o.total = :total")})
public class Orden implements Serializable, Entidad {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_registro")
    @Temporal(TemporalType.DATE)
    private Date fechaRegistro;
    @Basic(optional = false)
    @NotNull
    @Column(name = "plazo_maximo")
    @Temporal(TemporalType.DATE)
    private Date plazoMaximo;
    @Column(name = "fecha_entrega")
    @Temporal(TemporalType.DATE)
    private Date fechaEntrega;
    @Column(name = "total")
    private Long total;
    @JoinColumn(name = "empleado_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Empleado empleadoId;
    @JoinColumn(name = "prioridad_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Prioridad prioridadId;
    @JoinColumn(name = "estado_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Estado estadoId;

    public Orden() {
    }

    public Orden(Integer id) {
        this.id = id;
    }

    public Orden(Integer id, Date fechaRegistro, Date plazoMaximo) {
        this.id = id;
        this.fechaRegistro = fechaRegistro;
        this.plazoMaximo = plazoMaximo;
    }

    @Override
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public Date getPlazoMaximo() {
        return plazoMaximo;
    }

    public void setPlazoMaximo(Date plazoMaximo) {
        this.plazoMaximo = plazoMaximo;
    }

    public Date getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(Date fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public Empleado getEmpleadoId() {
        return empleadoId;
    }

    public void setEmpleadoId(Empleado empleadoId) {
        this.empleadoId = empleadoId;
    }

    public Prioridad getPrioridadId() {
        return prioridadId;
    }

    public void setPrioridadId(Prioridad prioridadId) {
        this.prioridadId = prioridadId;
    }

    public Estado getEstadoId() {
        return estadoId;
    }

    public void setEstadoId(Estado estadoId) {
        this.estadoId = estadoId;
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
        if (!(object instanceof Orden)) {
            return false;
        }
        Orden other = (Orden) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "proyectompc.entidades.Orden[ id=" + id + " ]";
    }
    
}
