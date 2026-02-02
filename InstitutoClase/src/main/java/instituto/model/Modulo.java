/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package instituto.model;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Basic;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

/**
 *
 * @author guille
 */
@Entity
@Table(name = "tmodulo")
@NamedQueries({
    @NamedQuery(name = "Modulo.findAll", query = "SELECT m FROM Modulo m"),
    @NamedQuery(name = "Modulo.findByCodigoModulo", query = "SELECT m FROM Modulo m WHERE m.codigoModulo = :codigoModulo"),
    @NamedQuery(name = "Modulo.findByNombreModulo", query = "SELECT m FROM Modulo m WHERE m.nombreModulo = :nombreModulo"),
    @NamedQuery(name = "Modulo.findByCicloFormativo", query = "SELECT m FROM Modulo m WHERE m.cicloFormativo = :cicloFormativo")})
public class Modulo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codigo_modulo")
    private Integer codigoModulo;
    @Basic(optional = false)
    @Column(name = "nombre_modulo")
    private String nombreModulo;
    @Basic(optional = false)
    @Column(name = "ciclo_formativo")
    private String cicloFormativo;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "modulo", fetch = FetchType.EAGER)
    private List<InformeCurso> informeCursoList;

    public Modulo() {        
    }

    public Modulo(String nombreModulo, String cicloFormativo) {
        this.nombreModulo = nombreModulo;
        this.cicloFormativo = cicloFormativo;
    }

    public Modulo(Integer codigoModulo, String nombreModulo, String cicloFormativo, List<InformeCurso> informeCursoList) {
		super();
		this.codigoModulo = codigoModulo;
		this.nombreModulo = nombreModulo;
		this.cicloFormativo = cicloFormativo;
		this.informeCursoList = informeCursoList;
	}

	public Integer getCodigoModulo() {
        return codigoModulo;
    }

    public void setCodigoModulo(Integer codigoModulo) {
        this.codigoModulo = codigoModulo;
    }

    public String getNombreModulo() {
        return nombreModulo;
    }

    public void setNombreModulo(String nombreModulo) {
        this.nombreModulo = nombreModulo;
    }

    public String getCicloFormativo() {
        return cicloFormativo;
    }

    public void setCicloFormativo(String cicloFormativo) {
        this.cicloFormativo = cicloFormativo;
    }

    public List<InformeCurso> getInformeCursoList() {
        return informeCursoList;
    }

    public void setInformeCursoList(List<InformeCurso> informeCursoList) {
        this.informeCursoList = informeCursoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoModulo != null ? codigoModulo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Modulo)) {
            return false;
        }
        Modulo other = (Modulo) object;
        if ((this.codigoModulo == null && other.codigoModulo != null) || (this.codigoModulo != null && !this.codigoModulo.equals(other.codigoModulo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
	    StringBuilder informeCursos = new StringBuilder();
	    
	    // Recorrer la lista de pedidos y extraer sus IDs
	    for (InformeCurso ic : informeCursoList) {
	        if (informeCursos.length() > 0) {
	            informeCursos.append(" || ");
	        }
	        informeCursos.append(ic);
	    }
        return "Modulo{" + 
               "código=" + codigoModulo + 
               ", nombreModulo=" + nombreModulo + 
               ", cicloFormativo=" + cicloFormativo + 
               ", InformeCurso=[" + informeCursos.toString() + "]}";
    }

   
    
}
