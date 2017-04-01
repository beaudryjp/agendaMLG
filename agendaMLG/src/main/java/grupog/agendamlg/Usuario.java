
package grupog.agendamlg;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
* Usuario.java
*
* Mar 31, 2017
* @author Jean Paul Beaudry
*/
@Entity
@Table( uniqueConstraints = @UniqueConstraint(columnNames = {"email","pseudonimo","sal"}))
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_usuario;
    @Column(name="nombre", nullable=false)
    private String nombre;
    @Column(name="apellidos", nullable=false)
    private String apellidos;
    @Column(name="pseudonimo", nullable=false)
    private String pseudonimo;
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
    
    @OneToMany(cascade=CascadeType.ALL,orphanRemoval=true)
    private List<Comentario> comentarios;
    @OneToMany(cascade=CascadeType.ALL,orphanRemoval=true)
    private List <Notificacion> notificaciones;
    @ManyToMany
    @JoinTable(name="jn_megusta_id",joinColumns=@JoinColumn(name="user_fk"),inverseJoinColumns=@JoinColumn(name="megusta_fk"))
    private Set<Usuario> megusta;
    @ManyToMany
    @JoinTable(name="jn_sigue_id",joinColumns=@JoinColumn(name="user_fk"),inverseJoinColumns=@JoinColumn(name="sigue_fk"))
    private Set<Usuario> sigue;
    @ManyToMany
    @JoinTable(name="jn_asiste_id",joinColumns=@JoinColumn(name="user_fk"),inverseJoinColumns=@JoinColumn(name="asiste_fk"))
    private Set<Usuario> asiste;
    
   

    public Long getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Long id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getPseudonimo() {
        return pseudonimo;
    }

    public void setPseudonimo(String pseudonimo) {
        this.pseudonimo = pseudonimo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isEmail_notifier() {
        return email_notifier;
    }

    public void setEmail_notifier(boolean email_notifier) {
        this.email_notifier = email_notifier;
    }

    public String getPassword_hash() {
        return password_hash;
    }

    public void setPassword_hash(String password_hash) {
        this.password_hash = password_hash;
    }

    public String getSal() {
        return sal;
    }

    public void setSal(String sal) {
        this.sal = sal;
    }

    public Long getLongitud() {
        return longitud;
    }

    public void setLongitud(Long longitud) {
        this.longitud = longitud;
    }

    public Long getLatitud() {
        return latitud;
    }

    public void setLatitud(Long latitud) {
        this.latitud = latitud;
    }

    public List<Comentario> getComentarios() {
        return comentarios;
    }

    public void setComentarios(List<Comentario> comentarios) {
        this.comentarios = comentarios;
    }

    public List<Notificacion> getNotificaciones() {
        return notificaciones;
    }

    public void setNotificaciones(List<Notificacion> notificaciones) {
        this.notificaciones = notificaciones;
    }

    public Set<Usuario> getMegusta() {
        return megusta;
    }

    public void setMegusta(Set<Usuario> megusta) {
        this.megusta = megusta;
    }

    public Set<Usuario> getSigue() {
        return sigue;
    }

    public void setSigue(Set<Usuario> sigue) {
        this.sigue = sigue;
    }

    public Set<Usuario> getAsiste() {
        return asiste;
    }

    public void setAsiste(Set<Usuario> asiste) {
        this.asiste = asiste;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + Objects.hashCode(this.id_usuario);
        hash = 37 * hash + Objects.hashCode(this.pseudonimo);
        hash = 37 * hash + Objects.hashCode(this.email);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Usuario other = (Usuario) obj;
        if (!Objects.equals(this.pseudonimo, other.pseudonimo)) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        if (!Objects.equals(this.id_usuario, other.id_usuario)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Usuario{" + "id_usuario=" + id_usuario + ", nombre=" + nombre + ", apellidos=" + apellidos + ", pseudonimo=" + pseudonimo + ", email=" + email + ", email_notifier=" + email_notifier + ", password_hash=" + password_hash + ", sal=" + sal + ", longitud=" + longitud + ", latitud=" + latitud + ", comentarios=" + comentarios + ", notificaciones=" + notificaciones + ", megusta=" + megusta + ", sigue=" + sigue + ", asiste=" + asiste + '}';
    }

    


}
