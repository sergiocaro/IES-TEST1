package instituto.model;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tinformescurso")
public class InformeCurso implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id")
    private Integer id;

    @JoinColumn(name = "alumno_id", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.EAGER)
    private Alumno alumno;  // Changed from Integer idAlumno

    @JoinColumn(name = "modulo_codigo", referencedColumnName = "codigo_modulo")
    @ManyToOne(fetch = FetchType.EAGER)
    private Modulo modulo;  // Changed from Integer idModulo

    // Update constructors
    public InformeCurso() {
    }

    public InformeCurso(Integer id, Alumno alumno, Modulo modulo) {
        this.id = id;
        this.alumno = alumno;
        this.modulo = modulo;
    }

    public InformeCurso(Alumno alumno, Modulo modulo) {
        this.alumno = alumno;
        this.modulo = modulo;
    }

    // Update getters and setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public Modulo getModulo() {
        return modulo;
    }

    public void setModulo(Modulo modulo) {
        this.modulo = modulo;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, alumno, modulo);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        InformeCurso other = (InformeCurso) obj;
        return Objects.equals(id, other.id) 
               && Objects.equals(alumno, other.alumno)
               && Objects.equals(modulo, other.modulo);
    }

    @Override
    public String toString() {
        return "InformeCurso [id=" + id +"]";
    }
}