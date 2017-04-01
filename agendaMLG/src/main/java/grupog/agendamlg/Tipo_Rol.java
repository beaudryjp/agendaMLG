
package grupog.agendamlg;

import java.io.Serializable;
import java.util.Objects;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
* RolTipo.java
*
* Mar 31, 2017
* @author Jean Paul Beaudry
*/
@Entity
@Table( uniqueConstraints = @UniqueConstraint(columnNames = {"nombre_rol"}))
public class Tipo_Rol implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_rol;
    @Column(name="nombre_rol", nullable=false)
    private String nombre_rol;
    @ManyToMany
    @JoinTable(
      name = "privilegios_rol",
      joinColumns = @JoinColumn(
      name="id_rol"),
      inverseJoinColumns=@JoinColumn(
      name="id_privilegio"))
    private Set<Privilegio> privilegios;

    public Long getId_rol() {
        return id_rol;
    }

    public void setId_rol(Long id) {
        this.id_rol = id;
    }

    public String getNombre_rol() {
        return nombre_rol;
    }

    public void setNombre_rol(String nombre_rol) {
        this.nombre_rol = nombre_rol;
    }

    public Set<Privilegio> getPrivilegios() {
        return privilegios;
    }

    public void setPrivilegios(Set<Privilegio> privilegios) {
        this.privilegios = privilegios;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 61 * hash + Objects.hashCode(this.id_rol);
        hash = 61 * hash + Objects.hashCode(this.nombre_rol);
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
        final Tipo_Rol other = (Tipo_Rol) obj;
        if (!Objects.equals(this.nombre_rol, other.nombre_rol)) {
            return false;
        }
        if (!Objects.equals(this.id_rol, other.id_rol)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Tipo_Rol{" + "id_rol=" + id_rol + ", nombre_rol=" + nombre_rol + ", privilegios=" + privilegios + '}';
    }

    
    

}
