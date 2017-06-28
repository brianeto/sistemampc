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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Andres
 */
@Entity
@Table(name = "clientes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cliente.findAll", query = "SELECT c FROM Cliente c")
    , @NamedQuery(name = "Cliente.findById", query = "SELECT c FROM Cliente c WHERE c.id = :id")
    , @NamedQuery(name = "Cliente.findByHashCliente", query = "SELECT c FROM Cliente c WHERE c.hashCliente = :hashCliente")
    , @NamedQuery(name = "Cliente.findByNumeroCedula", query = "SELECT c FROM Cliente c WHERE c.numeroCedula = :numeroCedula")
    , @NamedQuery(name = "Cliente.findByNombres", query = "SELECT c FROM Cliente c WHERE c.nombres = :nombres")
    , @NamedQuery(name = "Cliente.findByApellidos", query = "SELECT c FROM Cliente c WHERE c.apellidos = :apellidos")
    , @NamedQuery(name = "Cliente.findByCorreoElectronico", query = "SELECT c FROM Cliente c WHERE c.correoElectronico = :correoElectronico")
    , @NamedQuery(name = "Cliente.findByFechaNacimiento", query = "SELECT c FROM Cliente c WHERE c.fechaNacimiento = :fechaNacimiento")
    , @NamedQuery(name = "Cliente.findByFechaRegistro", query = "SELECT c FROM Cliente c WHERE c.fechaRegistro = :fechaRegistro")})
public class Cliente implements Serializable, Entidad {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 40)
    @Column(name = "hashCliente")
    private String hashCliente;
    @Size(min = 8, max = 13, message = "Este campo requiere de mínimo 8 caracteres y máximo 14")
    @Pattern(regexp = "^[0-9]+$", message = "Este campo solo perite valores númericos.")
    @Column(name = "numero_cedula")
    private String numeroCedula;
    @Size(min = 2, max = 50, message = "Campo nombre vacío, mínimo 2 caracteres")
    @Pattern(regexp = "^[a-zA-Z ]+$", message = "Este campo no permite números ni caracteres especiales")
    @Column(name = "nombres")
    private String nombres;
    @Size(min = 2, max = 50, message = "Campo apellido vacío, mínimo 2 caracteres")
    @Pattern(regexp = "^[a-zA-Z ]+$", message = "Este campo no permite números ni caracteres especiales")
    @Column(name = "apellidos")
    private String apellidos;
    @Size(max = 150)
    @Pattern(regexp = "[\\w\\.-]*[a-zA-Z0-9_]@[\\w\\.-]*[a-zA-Z0-9]\\.[a-zA-Z][a-zA-Z\\.]*[a-zA-Z]+", message = "Correo electrónico no válido.")
    @Column(name = "correo_electronico")
    private String correoElectronico;
    @Column(name = "fecha_nacimiento")
    @Temporal(TemporalType.DATE)
    private Date fechaNacimiento;
    @Column(name = "fecha_registro")
    @Temporal(TemporalType.DATE)
    private Date fechaRegistro;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "clienteId")
    private List<TelefonoCliente> telefonoClienteList;
    @JoinColumn(name = "usuario_id", referencedColumnName = "id")
    @OneToOne(optional = false)
    private Usuario usuarioId;
    @OneToMany(mappedBy = "clienteId")
    private List<Vehiculo> vehiculoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "clienteId")
    private List<CalificacionEmpleado> calificacionEmpleadoList;

    public Cliente() {
    }

    public Cliente(Integer id) {
        this.id = id;
    }

    @Override
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getHashCliente() {
        return hashCliente;
    }

    public void setHashCliente(String hashCliente) {
        this.hashCliente = hashCliente;
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

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
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
    public List<TelefonoCliente> getTelefonoClienteList() {
        return telefonoClienteList;
    }

    public void setTelefonoClienteList(List<TelefonoCliente> telefonoClienteList) {
        this.telefonoClienteList = telefonoClienteList;
    }

    public Usuario getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Usuario usuarioId) {
        this.usuarioId = usuarioId;
    }

    @XmlTransient
    public List<Vehiculo> getVehiculoList() {
        return vehiculoList;
    }

    public void setVehiculoList(List<Vehiculo> vehiculoList) {
        this.vehiculoList = vehiculoList;
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
        if (!(object instanceof Cliente)) {
            return false;
        }
        Cliente other = (Cliente) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "proyectompc.entidades.Cliente[ id=" + id + " ]";
    }
    
}
