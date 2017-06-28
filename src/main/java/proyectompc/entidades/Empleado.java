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
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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
@Table(name = "empleados")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Empleado.findAll", query = "SELECT e FROM Empleado e")
    , @NamedQuery(name = "Empleado.findById", query = "SELECT e FROM Empleado e WHERE e.id = :id")
    , @NamedQuery(name = "Empleado.findByNumeroCedula", query = "SELECT e FROM Empleado e WHERE e.numeroCedula = :numeroCedula")
    , @NamedQuery(name = "Empleado.findByNombres", query = "SELECT e FROM Empleado e WHERE e.nombres = :nombres")
    , @NamedQuery(name = "Empleado.findByApellidos", query = "SELECT e FROM Empleado e WHERE e.apellidos = :apellidos")
    , @NamedQuery(name = "Empleado.findByFechaNacimiento", query = "SELECT e FROM Empleado e WHERE e.fechaNacimiento = :fechaNacimiento")
    , @NamedQuery(name = "Empleado.findByFechaRegistro", query = "SELECT e FROM Empleado e WHERE e.fechaRegistro = :fechaRegistro")})
public class Empleado implements Serializable, Entidad {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "numero_cedula")
    private String numeroCedula;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nombres")
    private String nombres;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "apellidos")
    private String apellidos;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_nacimiento")
    @Temporal(TemporalType.DATE)
    private Date fechaNacimiento;
    @Column(name = "fecha_registro")
    @Temporal(TemporalType.DATE)
    private Date fechaRegistro;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empleadoId")
    private List<Mantenimiento> mantenimientoList;
    @JoinColumn(name = "usuario_id", referencedColumnName = "id")
    @OneToOne(optional = false)
    private Usuario usuarioId;
    @JoinColumn(name = "rol_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Rol rolId;
    @JoinColumn(name = "estado_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Estado estadoId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empleadoId")
    private List<Orden> ordenList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empleadoId")
    private List<CalificacionEmpleado> calificacionEmpleadoList;

    public Empleado() {
    }

    public Empleado(Integer id) {
        this.id = id;
    }

    public Empleado(Integer id, String numeroCedula, String nombres, String apellidos, Date fechaNacimiento) {
        this.id = id;
        this.numeroCedula = numeroCedula;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.fechaNacimiento = fechaNacimiento;
    }

    @Override
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumeroCedula() {
        return numeroCedula;
    }

    public void setNumeroCedula(String numeroCedula) {
        this.numeroCedula = numeroCedula;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    @XmlTransient
    public List<Mantenimiento> getMantenimientoList() {
        return mantenimientoList;
    }

    public void setMantenimientoList(List<Mantenimiento> mantenimientoList) {
        this.mantenimientoList = mantenimientoList;
    }

    public Usuario getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Usuario usuarioId) {
        this.usuarioId = usuarioId;
    }

    public Rol getRolId() {
        return rolId;
    }

    public void setRolId(Rol rolId) {
        this.rolId = rolId;
    }

    public Estado getEstadoId() {
        return estadoId;
    }

    public void setEstadoId(Estado estadoId) {
        this.estadoId = estadoId;
    }

    @XmlTransient
    public List<Orden> getOrdenList() {
        return ordenList;
    }

    public void setOrdenList(List<Orden> ordenList) {
        this.ordenList = ordenList;
    }

    @XmlTransient
    public List<CalificacionEmpleado> getCalificacionEmpleadoList() {
        return calificacionEmpleadoList;
    }

    public void setCalificacionEmpleadoList(List<CalificacionEmpleado> calificacionEmpleadoList) {
        this.calificacionEmpleadoList = calificacionEmpleadoList;
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
        if (!(object instanceof Empleado)) {
            return false;
        }
        Empleado other = (Empleado) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "proyectompc.entidades.Empleado[ id=" + id + " ]";
    }
    
}
