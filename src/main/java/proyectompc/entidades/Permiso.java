/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectompc.entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
@Table(name = "permisos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Permiso.findAll", query = "SELECT p FROM Permiso p")
    , @NamedQuery(name = "Permiso.findById", query = "SELECT p FROM Permiso p WHERE p.id = :id")
    , @NamedQuery(name = "Permiso.findByMenu", query = "SELECT p FROM Permiso p WHERE p.menu = :menu")
    , @NamedQuery(name = "Permiso.findByNombre", query = "SELECT p FROM Permiso p WHERE p.nombre = :nombre")
    , @NamedQuery(name = "Permiso.findByUrl", query = "SELECT p FROM Permiso p WHERE p.url = :url")
    , @NamedQuery(name = "Permiso.findByIcono", query = "SELECT p FROM Permiso p WHERE p.icono = :icono")})
public class Permiso implements Serializable, Entidad {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "menu")
    private Boolean menu;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "url")
    private String url;
    @Size(max = 100)
    @Column(name = "icono")
    private String icono;
    @ManyToMany(mappedBy = "permisoList")
    private List<Rol> rolList;
    @OneToMany(mappedBy = "permisoId")
    private List<Permiso> permisoList;
    @JoinColumn(name = "permiso_id", referencedColumnName = "id")
    @ManyToOne
    private Permiso permisoId;

    public Permiso() {
    }

    public Permiso(Integer id) {
        this.id = id;
    }

    public Permiso(Integer id, String nombre, String url) {
        this.id = id;
        this.nombre = nombre;
        this.url = url;
    }

    @Override
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getMenu() {
        return menu;
    }

    public void setMenu(Boolean menu) {
        this.menu = menu;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getIcono() {
        return icono;
    }

    public void setIcono(String icono) {
        this.icono = icono;
    }

    @XmlTransient
    public List<Rol> getRolList() {
        return rolList;
    }

    public void setRolList(List<Rol> rolList) {
        this.rolList = rolList;
    }

    @XmlTransient
    public List<Permiso> getPermisoList() {
        return permisoList;
    }

    public void setPermisoList(List<Permiso> permisoList) {
        this.permisoList = permisoList;
    }

    public Permiso getPermisoId() {
        return permisoId;
    }

    public void setPermisoId(Permiso permisoId) {
        this.permisoId = permisoId;
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
        if (!(object instanceof Permiso)) {
            return false;
        }
        Permiso other = (Permiso) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "proyectompc.entidades.Permiso[ id=" + id + " ]";
    }
    
}
