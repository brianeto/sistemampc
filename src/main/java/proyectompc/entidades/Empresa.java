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
@Table(name = "empresas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Empresa.findAll", query = "SELECT e FROM Empresa e")
    , @NamedQuery(name = "Empresa.findById", query = "SELECT e FROM Empresa e WHERE e.id = :id")
    , @NamedQuery(name = "Empresa.findByRazonSocial", query = "SELECT e FROM Empresa e WHERE e.razonSocial = :razonSocial")
    , @NamedQuery(name = "Empresa.findByHashEmpresa", query = "SELECT e FROM Empresa e WHERE e.hashEmpresa = :hashEmpresa")
    , @NamedQuery(name = "Empresa.findByDireccion", query = "SELECT e FROM Empresa e WHERE e.direccion = :direccion")
    , @NamedQuery(name = "Empresa.findBySitioWeb", query = "SELECT e FROM Empresa e WHERE e.sitioWeb = :sitioWeb")})
public class Empresa implements Serializable, Entidad {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 2, max = 80, message = "Campo razón social vacío, mínimo 2 caracteres")
    @Pattern(regexp = "^[a-zA-Z ]+$", message = "Este campo no permite números ni caracteres especiales")
    @Column(name = "razon_social")
    private String razonSocial;
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "hashEmpresa")
    private String hashEmpresa;
    @Basic(optional = false)
    @NotNull
    @Size(min = 8, max = 120, message = "Campo dirección vacío, mínimo 2 caracteres")
    @Column(name = "direccion")
    private String direccion;
    @Size(max = 200)
    @Column(name = "sitio_web")
    private String sitioWeb;
    @OneToMany(mappedBy = "empresaId")
    private List<Vehiculo> vehiculoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empresaId")
    private List<TelefonoEmpresa> telefonoEmpresaList;
    @JoinColumn(name = "sector_economico_id", referencedColumnName = "id"   )
    @ManyToOne(optional = false)
    private SectorEconomico sectorEconomicoId;
    @JoinColumn(name = "usuario_id", referencedColumnName = "id")
    @OneToOne(optional = false)
    private Usuario usuarioId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empresaId")
    private List<ContactoEmpresa> contactoEmpresaList;

    public Empresa() {
    }

    public Empresa(Integer id) {
        this.id = id;
    }

    public Empresa(Integer id, String hashEmpresa, String razonSocial, String direccion) {
        this.id = id;
        this.razonSocial = razonSocial;
        this.direccion = direccion;
        this.hashEmpresa = hashEmpresa;
    }

    @Override
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getHashEmpresa() {
        return hashEmpresa;
    }

    public void setHashEmpresa(String hashEmpresa) {
        this.hashEmpresa = hashEmpresa;
    }

    public String getSitioWeb() {
        return sitioWeb;
    }

    public void setSitioWeb(String sitioWeb) {
        this.sitioWeb = sitioWeb;
    }

    @XmlTransient
    public List<Vehiculo> getVehiculoList() {
        return vehiculoList;
    }

    public void setVehiculoList(List<Vehiculo> vehiculoList) {
        this.vehiculoList = vehiculoList;
    }

    @XmlTransient
    public List<TelefonoEmpresa> getTelefonoEmpresaList() {
        return telefonoEmpresaList;
    }

    public void setTelefonoEmpresaList(List<TelefonoEmpresa> telefonoEmpresaList) {
        this.telefonoEmpresaList = telefonoEmpresaList;
    }

    public SectorEconomico getSectorEconomicoId() {
        return sectorEconomicoId;
    }

    public void setSectorEconomicoId(SectorEconomico sectorEconomicoId) {
        this.sectorEconomicoId = sectorEconomicoId;
    }

    public Usuario getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Usuario usuarioId) {
        this.usuarioId = usuarioId;
    }

    @XmlTransient
    public List<ContactoEmpresa> getContactoEmpresaList() {
        return contactoEmpresaList;
    }

    public void setContactoEmpresaList(List<ContactoEmpresa> contactoEmpresaList) {
        this.contactoEmpresaList = contactoEmpresaList;
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
        if (!(object instanceof Empresa)) {
            return false;
        }
        Empresa other = (Empresa) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "proyectompc.entidades.Empresa[ id=" + id + " ]";
    }

}
