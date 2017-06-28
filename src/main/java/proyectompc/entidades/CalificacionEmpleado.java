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
@Table(name = "calificaciones_empleados")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CalificacionEmpleado.findAll", query = "SELECT c FROM CalificacionEmpleado c")
    , @NamedQuery(name = "CalificacionEmpleado.findById", query = "SELECT c FROM CalificacionEmpleado c WHERE c.id = :id")
    , @NamedQuery(name = "CalificacionEmpleado.findByCalificacion", query = "SELECT c FROM CalificacionEmpleado c WHERE c.calificacion = :calificacion")
    , @NamedQuery(name = "CalificacionEmpleado.findByFechaRegistro", query = "SELECT c FROM CalificacionEmpleado c WHERE c.fechaRegistro = :fechaRegistro")})
public class CalificacionEmpleado implements Serializable, Entidad {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "calificacion")
    private int calificacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_registro")
    @Temporal(TemporalType.DATE)
    private Date fechaRegistro;
    @JoinColumn(name = "estado_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Estado estadoId;
    @JoinColumn(name = "empleado_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Empleado empleadoId;
    @JoinColumn(name = "cliente_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Cliente clienteId;

    public CalificacionEmpleado() {
    }

    public CalificacionEmpleado(Integer id) {
        this.id = id;
    }

    public CalificacionEmpleado(Integer id, int calificacion, Date fechaRegistro) {
        this.id = id;
        this.calificacion = calificacion;
        this.fechaRegistro = fechaRegistro;
    }

    @Override
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(int calificacion) {
        this.calificacion = calificacion;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public Estado getEstadoId() {
        return estadoId;
    }

    public void setEstadoId(Estado estadoId) {
        this.estadoId = estadoId;
    }

    public Empleado getEmpleadoId() {
        return empleadoId;
    }

    public void setEmpleadoId(Empleado empleadoId) {
        this.empleadoId = empleadoId;
    }

    public Cliente getClienteId() {
        return clienteId;
    }

    public void setClienteId(Cliente clienteId) {
        this.clienteId = clienteId;
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
        if (!(object instanceof CalificacionEmpleado)) {
            return false;
        }
        CalificacionEmpleado other = (CalificacionEmpleado) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "proyectompc.entidades.CalificacionEmpleado[ id=" + id + " ]";
    }
    
}
