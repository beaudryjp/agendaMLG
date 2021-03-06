
package grupog.agendamlg;

import com.google.common.collect.ComparisonChain;
import java.io.Serializable;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
* Evento.java
*
* Mar 31, 2017
* @author Jean Paul Beaudry
*/
@Entity
public class Evento implements Serializable, Comparable{

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_evento;
    private String titulo;
    @Column(name="descripcion", nullable=false)
    private String descripcion;
    @Column(name="fecha_inicio", nullable=false)
    @Temporal(TemporalType.DATE)
    private Date fecha_inicio;
    @Temporal(TemporalType.DATE)
    private Date fecha_fin;
    private String horario;
    private String precio;
    private double longitud;
    private double latitud;
    
    @OneToMany(cascade=CascadeType.ALL)
    @JoinTable(name="jn_comentarios_id",joinColumns=@JoinColumn(name="id_evento"),inverseJoinColumns=@JoinColumn(name="id_comentario"))
    private List<Comentario> comentarios;
    @ManyToMany
    @JoinTable(name="jn_etiqueta_id",joinColumns=@JoinColumn(name="id_evento"),inverseJoinColumns=@JoinColumn(name="id_etiqueta"))
    private Set<Etiqueta> etiqueta;
    @ManyToOne
    private Localidad localidad;
    @OneToMany(cascade=CascadeType.ALL)
    @JoinTable(name="jn_notificaciones_id",joinColumns=@JoinColumn(name="id_evento"),inverseJoinColumns=@JoinColumn(name="id_notificacion"))
    private List <Notificacion> notificaciones;
    @ManyToMany(mappedBy="megusta")
    private Set<Usuario> megusta;
    @ManyToMany(mappedBy="sigue")
    private Set<Usuario> sigue;
    @ManyToMany(mappedBy="asiste")
    private Set<Usuario> asiste;
    
//    @OneToMany
//    //@JoinTable(name="jn_rol_id",joinColumns=@JoinColumn(name="id_evento"),inverseJoinColumns=@JoinColumn(name="pk"))
//    private Set<Rol> rol;
    
    @ManyToMany
    @JoinTable(name="jn_destinatario_id",joinColumns=@JoinColumn(name="id_evento"),inverseJoinColumns=@JoinColumn(name="id_destinatario"))
    private Set<Destinatario> destinatario;

    public Set<Destinatario> getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(Set<Destinatario> destinatario) {
        this.destinatario = destinatario;
    }
    
    
    public String getHorario() {
        return horario;
    }

    public void setHorario(String horarios) {
        this.horario = horarios;
    }
   
    
    public Long getId_evento() {
        return id_evento;
    }

    public void setId_evento(Long id_evento) {
        this.id_evento = id_evento;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(Date fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public Date getFecha_fin() {
        return fecha_fin;
    }

    public void setFecha_fin(Date fecha_fin) {
        this.fecha_fin = fecha_fin;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public double getLongitud() {
        return longitud;
    }

    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }

    public double getLatitud() {
        return latitud;
    }

    public void setLatitud(double latitud) {
        this.latitud = latitud;
    }

    public List<Comentario> getComentarios() {
        return comentarios;
    }

    public void setComentarios(List<Comentario> comentarios) {
        this.comentarios = comentarios;
    }

    public Set<Etiqueta> getEtiqueta() {
        return etiqueta;
    }

    public void setEtiqueta(Set<Etiqueta> etiqueta) {
        this.etiqueta = etiqueta;
    }

    public Localidad getLocalidad() {
        return localidad;
    }

    public void setLocalidad(Localidad localidad) {
        this.localidad = localidad;
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
        int hash = 0;
        hash += (id_evento != null ? id_evento.hashCode() : 0);
        return hash;
    }
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id_evento fields are not set
        if (!(object instanceof Evento)) {
            return false;
        }
        Evento other = (Evento) object;
        if ((this.id_evento == null && other.id_evento != null) || (this.id_evento != null && !this.id_evento.equals(other.id_evento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Evento{" + "id_evento=" + id_evento + ", titulo=" + titulo + ", descripcion=" + descripcion + ", fecha_inicio=" + fecha_inicio + ", fecha_fin=" + fecha_fin + ", horario=" + horario + ", precio=" + precio + ", longitud=" + longitud + ", latitud=" + latitud + '}';
    }

    @Override
    public int compareTo(Object o) {
        Evento e2 = (Evento)o;
        return ComparisonChain.start()
                .compare(this.getTitulo(), e2.getTitulo())
                .compare(this.getLocalidad(), e2.getLocalidad())
                .compare(this.getFecha_inicio(), e2.getFecha_inicio())
                .compare(this.getFecha_fin(), e2.getFecha_fin())
                .result(); 
    }

}
