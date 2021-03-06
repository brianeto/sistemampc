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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Andres
 */
@Entity
@Table(name = "telefonos_empresas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TelefonoEmpresa.findAll", query = "SELECT t FROM TelefonoEmpresa t")
    , @NamedQuery(name = "TelefonoEmpresa.findById", query = "SELECT t FROM TelefonoEmpresa t WHERE t.id = :id")
    , @NamedQuery(name = "TelefonoEmpresa.findByNumero", query = "SELECT t FROM TelefonoEmpresa t WHERE t.numero = :numero")})
public class TelefonoEmpresa implements Serializable, Entidad {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "numero")
    private int numero;
    @JoinColumn(name = "tipo_telefono_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private TipoTelefono tipoTelefonoId;
    @JoinColumn(name = "empresa_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Empresa empresaId;

    public TelefonoEmpresa() {
    }

    public TelefonoEmpresa(Integer id) {
        this.id = id;
    }

    public TelefonoEmpresa(Integer id, int numero) {
        this.id = id;
        this.numero = numero;
    }

    @Override
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public TipoTelefono getTipoTelefonoId() {
        return tipoTelefonoId;
    }

    public void setTipoTelefonoId(TipoTelefono tipoTelefonoId) {
        this.tipoTelefonoId = tipoTelefonoId;
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
        if (!(object instanceof TelefonoEmpresa)) {
            return false;
        }
        TelefonoEmpresa other = (TelefonoEmpresa) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "proyectompc.entidades.TelefonoEmpresa[ id=" + id + " ]";
    }
    
}
