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
@Table(name = "preguntas_secretas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PreguntaSecreta.findAll", query = "SELECT p FROM PreguntaSecreta p")
    , @NamedQuery(name = "PreguntaSecreta.findById", query = "SELECT p FROM PreguntaSecreta p WHERE p.id = :id")
    , @NamedQuery(name = "PreguntaSecreta.findByPregunta", query = "SELECT p FROM PreguntaSecreta p WHERE p.pregunta = :pregunta")})
public class PreguntaSecreta implements Serializable, Entidad {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "pregunta")
    private String pregunta;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "preguntaSecretaId")
    private List<Usuario> usuarioList;

    public PreguntaSecreta() {
    }

    public PreguntaSecreta(Integer id) {
        this.id = id;
    }

    public PreguntaSecreta(Integer id, String pregunta) {
        this.id = id;
        this.pregunta = pregunta;
    }

    @Override
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPregunta() {
        return pregunta;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

    @XmlTransient
    public List<Usuario> getUsuarioList() {
        return usuarioList;
    }

    public void setUsuarioList(List<Usuario> usuarioList) {
        this.usuarioList = usuarioList;
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
        if (!(object instanceof PreguntaSecreta)) {
            return false;
        }
        PreguntaSecreta other = (PreguntaSecreta) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "proyectompc.entidades.PreguntaSecreta[ id=" + id + " ]";
    }
    
}
