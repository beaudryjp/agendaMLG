
package grupog.agendamlg;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
* Usuario.java
*
* Mar 31, 2017
* @author Jean Paul Beaudry
*/
@Entity
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name="nombre", nullable=false)
    private String nombre;
    @Column(name="apellidos", nullable=false)
    private String apellidos;
    @Column(name="email", nullable=false)
    private String email;
    @Column(name="email_notifier", nullable=false)
    private boolean email_notifier;
    @Column(name="password_hash", nullable=false)
    private String password_hash;
    @Column(name="sal", nullable=false)
    private String sal;
    private Long longitud;
    private Long latitud;
    @OneToMany(cascade=CascadeType.ALL)

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPassword() {
        return password_hash;
    }

    public void setPassword(String password) {
        this.password_hash = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getPos_h() {
        return longitud;
    }

    public void setPos_h(Long pos_h) {
        this.longitud = pos_h;
    }

    public Long getPos_v() {
        return latitud;
    }

    public void setPos_v(Long pos_v) {
        this.latitud = pos_v;
    }

    public boolean isNotificaciones() {
        return email_notifier;
    }

    public void setNotificaciones(boolean notificaciones) {
        this.email_notifier = notificaciones;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "grupog.agendamlg_jpa.Usuario[ id=" + id + " ]";
    }

}
