/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectompc.entidades;

import java.io.Serializable;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Andres
 */
@Entity
@Table(name = "contactos_empresas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ContactoEmpresa.findAll", query = "SELECT c FROM ContactoEmpresa c")
    , @NamedQuery(name = "ContactoEmpresa.findById", query = "SELECT c FROM ContactoEmpresa c WHERE c.id = :id")
    , @NamedQuery(name = "ContactoEmpresa.findByNombreCompleto", query = "SELECT c FROM ContactoEmpresa c WHERE c.nombreCompleto = :nombreCompleto")
    , @NamedQuery(name = "ContactoEmpresa.findByCorreoElectronico", query = "SELECT c FROM ContactoEmpresa c WHERE c.correoElectronico = :correoElectronico")})
public class ContactoEmpresa implements Serializable, Entidad {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(max = 250)
    @Pattern(regexp = "^[^0-9]{5,40}+$", message = "Este campo no permite números ni caracteres especiales, mínimo 5 caracteres")
    @Column(name = "nombre_completo")
    private String nombreCompleto;
    @Basic(optional = false)
    @NotNull
    @Size(max = 150)
    @Pattern(regexp = "[\\w\\.-]*[a-zA-Z0-9_]@[\\w\\.-]*[a-zA-Z0-9]\\.[a-zA-Z][a-zA-Z\\.]*[a-zA-Z]+", message = "Correo electrónico no válido.")
    @Column(name = "correo_electronico")
    private String correoElectronico;
    @Basic(optional = false)
    @NotNull
    @Size(max = 150)
    @Pattern(regexp = "[0-9]{7,}+$", message = "Este campo solo perite valores númericos, mínimo 7 caracteres.")
    @Column(name = "numero_telefono")
    private String numeroTelefono;
    @JoinColumn(name = "empresa_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Empresa empresaId;

    public ContactoEmpresa() {
    }

    public ContactoEmpresa(Integer id) {
        this.id = id;
    }

    public ContactoEmpresa(Integer id, String nombreCompleto, String correoElectronico, String numeroTelefono) {
        this.id = id;
        this.nombreCompleto = nombreCompleto;
        this.correoElectronico = correoElectronico;
        this.numeroTelefono = numeroTelefono;
    }

    @Override
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getNumeroTelefono() {
        return numeroTelefono;
    }

    public void setNumeroTelefono(String numeroTelefono) {
        this.numeroTelefono = numeroTelefono;
    }
    
    public Empresa getEmpresaId() {
        return empresaId;
    }

    public void setEmpresaId(Empresa empresaId) {
        this.empresaId = empresaId;
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
        if (!(object instanceof ContactoEmpresa)) {
            return false;
        }
        ContactoEmpresa other = (ContactoEmpresa) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "proyectompc.entidades.ContactoEmpresa[ id=" + id + " ]";
    }
    
}
