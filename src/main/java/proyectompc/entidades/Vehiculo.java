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
import javax.persistence.Lob;
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
@Table(name = "vehiculos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Vehiculo.findAll", query = "SELECT v FROM Vehiculo v")
    , @NamedQuery(name = "Vehiculo.findById", query = "SELECT v FROM Vehiculo v WHERE v.id = :id")
    , @NamedQuery(name = "Vehiculo.findByModelo", query = "SELECT v FROM Vehiculo v WHERE v.modelo = :modelo")
    , @NamedQuery(name = "Vehiculo.findByMatricula", query = "SELECT v FROM Vehiculo v WHERE v.matricula = :matricula")
    , @NamedQuery(name = "Vehiculo.findByColor", query = "SELECT v FROM Vehiculo v WHERE v.color = :color")
    , @NamedQuery(name = "Vehiculo.findByKilometraje", query = "SELECT v FROM Vehiculo v WHERE v.kilometraje = :kilometraje")})
public class Vehiculo implements Serializable, Entidad {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "modelo")
    private int modelo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "matricula")
    private String matricula;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "color")
    private String color;
    @Basic(optional = false)
    @NotNull
    @Column(name = "kilometraje")
    private int kilometraje;
    @Lob
    @Size(max = 65535)
    @Column(name = "descripcion")
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "vehiculoId")
    private List<Mantenimiento> mantenimientoList;
    @JoinColumn(name = "tipo_vehiculo_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private TipoVehiculo tipoVehiculoId;
    @JoinColumn(name = "tipo_combustible_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private TipoCombustible tipoCombustibleId;
    @JoinColumn(name = "marca_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private MarcaVehiculo marcaId;
    @JoinColumn(name = "cliente_id", referencedColumnName = "id")
    @ManyToOne
    private Cliente clienteId;
    @JoinColumn(name = "empresa_id", referencedColumnName = "id")
    @ManyToOne
    private Empresa empresaId;

    public Vehiculo() {
    }

    public Vehiculo(Integer id) {
        this.id = id;
    }

    public Vehiculo(Integer id, int modelo, String matricula, String color, int kilometraje) {
        this.id = id;
        this.modelo = modelo;
        this.matricula = matricula;
        this.color = color;
        this.kilometraje = kilometraje;
    }

    @Override
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getModelo() {
        return modelo;
    }

    public void setModelo(int modelo) {
        this.modelo = modelo;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getKilometraje() {
        return kilometraje;
    }

    public void setKilometraje(int kilometraje) {
        this.kilometraje = kilometraje;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @XmlTransient
    public List<Mantenimiento> getMantenimientoList() {
        return mantenimientoList;
    }

    public void setMantenimientoList(List<Mantenimiento> mantenimientoList) {
        this.mantenimientoList = mantenimientoList;
    }

    public TipoVehiculo getTipoVehiculoId() {
        return tipoVehiculoId;
    }

    public void setTipoVehiculoId(TipoVehiculo tipoVehiculoId) {
        this.tipoVehiculoId = tipoVehiculoId;
    }

    public TipoCombustible getTipoCombustibleId() {
        return tipoCombustibleId;
    }

    public void setTipoCombustibleId(TipoCombustible tipoCombustibleId) {
        this.tipoCombustibleId = tipoCombustibleId;
    }

    public MarcaVehiculo getMarcaId() {
        return marcaId;
    }

    public void setMarcaId(MarcaVehiculo marcaId) {
        this.marcaId = marcaId;
    }

    public Cliente getClienteId() {
        return clienteId;
    }

    public void setClienteId(Cliente clienteId) {
        this.clienteId = clienteId;
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
        if (!(object instanceof Vehiculo)) {
            return false;
        }
        Vehiculo other = (Vehiculo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "proyectompc.entidades.Vehiculo[ id=" + id + " ]";
    }
    
}
