/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupog.agendamlg;


import java.io.Serializable;
import java.util.Objects;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;



/**
 *
 * @author sorak
 */

@Entity
@Table( uniqueConstraints = @UniqueConstraint(columnNames = {"nombre_privilegio"}))
public class Privilegio implements Serializable{
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_privilegio;
    private String nombre_privilegio;
    private String descripcion;


    
 
    @ManyToMany
    private Set<Tipo_Rol> roles;

    public Long getId_privilegio() {
        return id_privilegio;
    }

    public void setId_privilegio(Long id_privilegio) {
        this.id_privilegio = id_privilegio;
    }

    public String getNombre_privilegio() {
        return nombre_privilegio;
    }

    public void setNombre_privilegio(String nombre_privilegio) {
        this.nombre_privilegio = nombre_privilegio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Set<Tipo_Rol> getRoles() {
        return roles;
    }

    public void setRoles(Set<Tipo_Rol> roles) {
        this.roles = roles;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.id_privilegio);
        hash = 97 * hash + Objects.hashCode(this.nombre_privilegio);
        hash = 97 * hash + Objects.hashCode(this.descripcion);
        hash = 97 * hash + Objects.hashCode(this.roles);
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
        final Privilegio other = (Privilegio) obj;
        if (!Objects.equals(this.nombre_privilegio, other.nombre_privilegio)) {
            return false;
        }
        if (!Objects.equals(this.descripcion, other.descripcion)) {
            return false;
        }
        if (!Objects.equals(this.id_privilegio, other.id_privilegio)) {
            return false;
        }
        if (!Objects.equals(this.roles, other.roles)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Privilegio{" + "id_privilegio=" + id_privilegio + ", nombre_privilegio=" + nombre_privilegio + ", descripcion=" + descripcion + ", roles=" + roles + '}';
    }

    
    
    
}
