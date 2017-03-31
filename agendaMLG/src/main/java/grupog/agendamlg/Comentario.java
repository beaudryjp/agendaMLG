
package grupog.agendamlg;

import java.io.Serializable;
import java.sql.Time;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
* Comentario.java
*
* Mar 31, 2017
* @author Jean Paul Beaudry
*/
@Entity
public class Comentario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_comment;
    private String mensaje;
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Temporal(TemporalType.TIME)
    private Time hora;
    @ManyToOne
    private Evento evento;
    @ManyToOne
    private Usuario usuario;

    public Long getId() {
        return id_comment;
    }

    public void setId(Long id) {
        this.id_comment = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id_comment != null ? id_comment.hashCode() : 0);
        return hash;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Time getHora() {
        return hora;
    }

    public void setHora(Time hora) {
        this.hora = hora;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Comentario)) {
            return false;
        }
        Comentario other = (Comentario) object;
        if ((this.id_comment == null && other.id_comment != null) || (this.id_comment != null && !this.id_comment.equals(other.id_comment))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "grupog.agendamlg_jpa.Comentario[ id=" + id_comment + " ]";
    }

}
