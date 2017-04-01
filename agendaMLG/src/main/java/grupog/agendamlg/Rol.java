/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupog.agendamlg;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author sorak
 */
@Entity

public class Rol implements Serializable{
    
    @Embeddable
    public class Pk implements Serializable{
        private static final long serialVersionUID = 1L;
        @Column(nullable = false, updatable = false)
        private Long evento_pk;
        @Column(nullable = false, updatable = false)
        private Long usuario_pk;
        @Column(nullable = false, updatable = false)
        private Long tipo_rol_pk;
        
        public Pk(){
            
        }
        
        public Pk(Long evento_pk, Long usuario_pk, Long tipo_rol_pk) {
            this.evento_pk = evento_pk;
            this.usuario_pk = usuario_pk;
            this.tipo_rol_pk = tipo_rol_pk;
        }

        public Long getEvento_pk() {
            return evento_pk;
        }

        public void setEvento_pk(Long evento_pk) {
            this.evento_pk = evento_pk;
        }

        public Long getUsuario_pk() {
            return usuario_pk;
        }

        public void setUsuario_pk(Long usuario_pk) {
            this.usuario_pk = usuario_pk;
        }

        public Long getTipo_rol_pk() {
            return tipo_rol_pk;
        }

        public void setTipo_rol_pk(Long tipo_rol_pk) {
            this.tipo_rol_pk = tipo_rol_pk;
        }

        @Override
        public int hashCode() {
            int hash = 7;
            hash = 43 * hash + Objects.hashCode(this.evento_pk);
            hash = 43 * hash + Objects.hashCode(this.usuario_pk);
            hash = 43 * hash + Objects.hashCode(this.tipo_rol_pk);
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
            final Pk other = (Pk) obj;
            if (!Objects.equals(this.evento_pk, other.evento_pk)) {
                return false;
            }
            if (!Objects.equals(this.usuario_pk, other.usuario_pk)) {
                return false;
            }
            if (!Objects.equals(this.tipo_rol_pk, other.tipo_rol_pk)) {
                return false;
            }
            return true;
        }
    }
        
    @EmbeddedId
    private Pk pk;
    private static final long serialVersionUID = 1L;
    @ManyToOne(optional=true)
    @JoinColumn(name = "id_evento", insertable = false, updatable = false)
    private Evento evento;
    @ManyToOne(optional=true)
    @JoinColumn(name = "id_tipo_rol", insertable = false, updatable = false)
    private Tipo_Rol rol;
    @ManyToOne(optional=true)
    @JoinColumn(name = "id_usuario", insertable = false, updatable = false)
    private  Usuario usuario;

    public Pk getPk() {
        return pk;
    }

    public void setPk(Pk pk) {
        this.pk = pk;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    public Tipo_Rol getRol() {
        return rol;
    }

    public void setRol(Tipo_Rol rol) {
        this.rol = rol;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + Objects.hashCode(this.pk);
        hash = 89 * hash + Objects.hashCode(this.evento);
        hash = 89 * hash + Objects.hashCode(this.rol);
        hash = 89 * hash + Objects.hashCode(this.usuario);
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
        final Rol other = (Rol) obj;
        if (!Objects.equals(this.pk, other.pk)) {
            return false;
        }
        if (!Objects.equals(this.evento, other.evento)) {
            return false;
        }
        if (!Objects.equals(this.rol, other.rol)) {
            return false;
        }
        if (!Objects.equals(this.usuario, other.usuario)) {
            return false;
        }
        return true;
    }

    

    @Override
    public String toString() {
        return "Rol{" + "pk=" + pk + ", evento=" + evento + ", rol=" + rol + ", usuario=" + usuario + '}';
    }
        
        
    
    }
