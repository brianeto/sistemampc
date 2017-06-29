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
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Andres
 */
@Entity
@Table(name = "usuarios")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u")
    , @NamedQuery(name = "Usuario.findById", query = "SELECT u FROM Usuario u WHERE u.id = :id")
    , @NamedQuery(name = "Usuario.findByRespuestaPreguntaSecreta", query = "SELECT u FROM Usuario u WHERE u.respuestaPreguntaSecreta = :respuestaPreguntaSecreta")
    , @NamedQuery(name = "Usuario.findByUsuario", query = "SELECT u FROM Usuario u WHERE u.usuario = :usuario")
    , @NamedQuery(name = "Usuario.findByClave", query = "SELECT u FROM Usuario u WHERE u.clave = :clave")
    , @NamedQuery(name = "Usuario.findByHashUser", query = "SELECT u FROM Usuario u WHERE u.hashUser = :hashUser")})
public class Usuario implements Serializable, Entidad {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Pattern(regexp = "^[a-zA-Z0-9 ]+$", message = "Este campo no permite caracteres especiales.")
    @Column(name = "respuesta_pregunta_secreta")
    private String respuestaPreguntaSecreta;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Pattern(regexp = "^[a-zA-Z]{9,}+$", message = "Este campo solo permite letras con un mínimo de 9 caracteres.")
    @Column(name = "usuario")
    private String usuario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 180)
    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}+$", message = "Contraseña requerida, mínimo 8 caracteres con un número.")
    @Column(name = "clave")
    private String clave;
    @Size(max = 40)
    @Column(name = "hashUser")
    private String hashUser;
    @JoinColumn(name = "estado_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Estado estadoId;
    @JoinColumn(name = "tipo_usuario_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private TipoUsuario tipoUsuarioId;
    @JoinColumn(name = "pregunta_secreta_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private PreguntaSecreta preguntaSecretaId;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "usuarioId")
    private Cliente cliente;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "usuarioId")
    private Empleado empleado;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "usuarioId")
    private Empresa empresa;

    public Usuario() {
    }

    public Usuario(Integer id) {
        this.id = id;
    }

    public Usuario(Integer id, String respuestaPreguntaSecreta, String usuario, String clave) {
        this.id = id;
        this.respuestaPreguntaSecreta = respuestaPreguntaSecreta;
        this.usuario = usuario;
        this.clave = clave;
    }

    @Override
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRespuestaPreguntaSecreta() {
        return respuestaPreguntaSecreta;
    }

    public void setRespuestaPreguntaSecreta(String respuestaPreguntaSecreta) {
        this.respuestaPreguntaSecreta = respuestaPreguntaSecreta;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getHashUser() {
        return hashUser;
    }

    public void setHashUser(String hashUser) {
        this.hashUser = hashUser;
    }

    public Estado getEstadoId() {
        return estadoId;
    }

    public void setEstadoId(Estado estadoId) {
        this.estadoId = estadoId;
    }

    public TipoUsuario getTipoUsuarioId() {
        return tipoUsuarioId;
    }

    public void setTipoUsuarioId(TipoUsuario tipoUsuarioId) {
        this.tipoUsuarioId = tipoUsuarioId;
    }

    public PreguntaSecreta getPreguntaSecretaId() {
        return preguntaSecretaId;
    }

    public void setPreguntaSecretaId(PreguntaSecreta preguntaSecretaId) {
        this.preguntaSecretaId = preguntaSecretaId;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public Empresa getEmpresaList() {
        return empresa;
    }

    public void setEmpresaList(Empresa empresa) {
        this.empresa = empresa;
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
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "proyectompc.entidades.Usuario[ id=" + id + " ]";
    }
    
}
