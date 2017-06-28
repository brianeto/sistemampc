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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Andres
 */
@Entity
@Table(name = "telefonos_clientes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TelefonoCliente.findAll", query = "SELECT t FROM TelefonoCliente t")
    , @NamedQuery(name = "TelefonoCliente.findById", query = "SELECT t FROM TelefonoCliente t WHERE t.id = :id")
    , @NamedQuery(name = "TelefonoCliente.findByNumero", query = "SELECT t FROM TelefonoCliente t WHERE t.numero = :numero")})
public class TelefonoCliente implements Serializable, Entidad {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "numero")
    private String numero;
    @JoinColumn(name = "cliente_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Cliente clienteId;
    @JoinColumn(name = "tipo_telefono_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private TipoTelefono tipoTelefonoId;

    public TelefonoCliente() {
    }

    public TelefonoCliente(Integer id) {
        this.id = id;
    }

    public TelefonoCliente(Integer id, String numero) {
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

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Cliente getClienteId() {
        return clienteId;
    }

    public void setClienteId(Cliente clienteId) {
        this.clienteId = clienteId;
    }

    public TipoTelefono getTipoTelefonoId() {
        return tipoTelefonoId;
    }

    public void setTipoTelefonoId(TipoTelefono tipoTelefonoId) {
        this.tipoTelefonoId = tipoTelefonoId;
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
        if (!(object instanceof TelefonoCliente)) {
            return false;
        }
        TelefonoCliente other = (TelefonoCliente) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "proyectompc.entidades.TelefonoCliente[ id=" + id + " ]";
    }
    
}
