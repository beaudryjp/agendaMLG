
package grupog.agendamlg;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
* Main.java
*
* Mar 23, 2017
* @author Jean Paul Beaudry & Javier Aguilera Puerta
*/
public class Main {
    public static void main(String[] string) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("agendaMLG");
        EntityManager em = emf.createEntityManager();
        
        em.getTransaction().begin();
        
        //Creamos provincia y localidad del evento
        
        Provincia provincia = new Provincia();
        provincia.setId_provincia(1L);
        provincia.setNombre("Málaga");
        
        Localidad localidad = new Localidad();localidad.setId_localidad(1L);
        localidad.setNombre("Málaga");
        localidad.setProvincia(provincia);
//        
//        Evento evento1 = new Evento();
//        evento1.setPrecio("gratis");
//        evento1.setFecha_inicio(new Date(2017,4,3));
//        evento1.setFecha_fin(new Date(2017,8,3));
//        evento1.setHorario("10am - 20pm");
//        evento1.setTitulo("Murakami");
//        evento1.setLatitud(36.7135979);
//        evento1.setLongitud(-4.42488000000003);
//        
//        Evento evento2 = new Evento();
//        evento1.setPrecio("10 euros");
//        evento1.setFecha_inicio(new Date(2017,5,15));
//        evento1.setFecha_fin(new Date(2017,6,15));
//        evento1.setHorario("18pm - 24pm");
//        evento1.setTitulo("El Bosco: Vida y Obra");
//        evento1.setLatitud(36.7135979);
//        evento1.setLongitud(-4.42488000000003);
//
//        Destinatario destinatario1=new Destinatario();
//        destinatario1.setDescripcion("niño");
//        Destinatario destinatario2=new Destinatario();
//        destinatario2.setDescripcion("adolescente");
//        Destinatario destinatario3=new Destinatario();
//        destinatario3.setDescripcion("adulto");
//        Destinatario destinatario4=new Destinatario();
//        destinatario4.setDescripcion("anciano");
//        Destinatario destinatario5=new Destinatario();
//        destinatario5.setDescripcion("todos");
//        
//        
//        Set <Destinatario> destinatarios = new TreeSet<>();
//        destinatarios.add(destinatario2);
//        destinatarios.add(destinatario3);
//        destinatarios.add(destinatario4);
//        evento1.setDestinatario(destinatarios);
//        evento2.setDestinatario(destinatarios);
//        
//        Etiqueta etiqueta1 = new Etiqueta();
//        Etiqueta etiqueta2 = new Etiqueta();
//        Etiqueta etiqueta3 = new Etiqueta();
//        Etiqueta etiqueta4 = new Etiqueta();
//        etiqueta1.setNombre("literatura");
//        etiqueta2.setNombre("arte");
//        etiqueta3.setNombre("escuela_flamenca");
//        etiqueta4.setNombre("japonesa");
//        
//        Set <Etiqueta> etiquetas_literatura = new TreeSet<>();
//        Set <Etiqueta> etiquetas_arte = new TreeSet<>();
//        
//        etiquetas_literatura.add(etiqueta1);
//        etiquetas_literatura.add(etiqueta4);
//        etiquetas_literatura.add(etiqueta2);
//        etiquetas_literatura.add(etiqueta3);
//        
//        evento1.setEtiqueta(etiquetas_literatura);
//        evento2.setEtiqueta(etiquetas_arte);
//        
//        Comentario comentario1 = new Comentario();
//        comentario1.setMensaje("Po");
//        Comentario comentario2 = new Comentario();
//        comentario2.setMensaje("Murakami's Bingo");
//        Comentario comentario3 = new Comentario();
//        comentario3.setMensaje("CAT");
//        Comentario comentario4 = new Comentario();
//        comentario4.setMensaje("Me gusta el jardín de las delicias");
//        
//        List <Comentario> comentarios_murakami=new ArrayList<>();
//        List <Comentario> comentarios_el_bosco=new ArrayList<>();
//        comentarios_murakami.add(comentario1);
//        comentarios_murakami.add(comentario2);
//        comentarios_murakami.add(comentario3);
//        comentarios_el_bosco.add(comentario4);
//        
//        evento1.setComentarios(comentarios_murakami);
//        evento2.setComentarios(comentarios_el_bosco);
//        
//        Usuario usuario1 = new Usuario();
//        Usuario usuario2 = new Usuario();
//        
//        Set <Evento> eventos_malaga= new TreeSet<>();
//        
//        usuario1.setNombre("Javier");
//        usuario1.setApellidos("Aguilera Puerta");
//        usuario1.setEmail("jaguilerapuerta@gmail.com");
//        usuario1.setSal("notnull");
//        usuario1.setPassword_hash(("pass"+usuario1.getSal()).hashCode()+"");
//        usuario1.setEmail_notifier(false);
//        usuario1.setLatitud(36.7384747);
//        usuario1.setLongitud(-4.4195087);
//        usuario1.setPseudonimo("kafkaphoenix");
//        
//        usuario2.setNombre("Marie");
//        usuario2.setApellidos("Poppo po");
//        usuario2.setEmail("popopo@poppo.po");
//        usuario2.setSal("notnull");
//        usuario2.setPassword_hash(("pass"+usuario2.getSal()).hashCode()+"");
//        usuario2.setEmail_notifier(false);
//        usuario2.setLatitud(35.6985448);
//        usuario2.setLongitud(139.7699039);
//        usuario2.setPseudonimo("poppo po?");
//
//        usuario1.setMegusta(eventos_malaga);
//        usuario1.setAsiste(eventos_malaga);
//        usuario1.setSigue(eventos_malaga);
//        
//        usuario2.setAsiste(eventos_malaga);
//        usuario2.setSigue(eventos_malaga);
//        
//        Privilegio privilegio1 = new Privilegio();
//        Privilegio privilegio2 = new Privilegio();
//        Privilegio privilegio3 = new Privilegio();
//        privilegio1.setNombre_privilegio("crear");
//        privilegio1.setDescripcion("Puede crear eventos");
//        privilegio2.setNombre_privilegio("modificar");
//        privilegio2.setDescripcion("Puede modificar eventos");
//        privilegio3.setNombre_privilegio("eliminar");
//        
//        Set <Privilegio> privilegios_redactor = new TreeSet<>();
//        Set <Privilegio> privilegios_usuario = new TreeSet<>();
//        Set <Privilegio> privilegios_validado = new TreeSet<>();
//        privilegios_redactor.add(privilegio1);
//        privilegios_redactor.add(privilegio2);
//        privilegios_redactor.add(privilegio3);
//        privilegios_validado.add(privilegio1);
//        
//        Tipo_Rol redactor = new Tipo_Rol();
//        redactor.setPrivilegios(privilegios_redactor);
//        redactor.setNombre_rol("redactor");
//        Tipo_Rol usuario = new Tipo_Rol();
//        usuario.setPrivilegios(privilegios_usuario);
//        usuario.setNombre_rol("usuario");
//        Tipo_Rol validado = new Tipo_Rol();
//        validado.setPrivilegios(privilegios_validado);
//        validado.setNombre_rol("validado");
//        
//        Rol rol = new Rol();
//        rol.setRol(usuario);
//        rol.setUsuario(usuario1);
//        rol.setEvento(evento1);
//        
//        Rol rol2 = new Rol();
//        rol2.setRol(usuario);
//        rol2.setUsuario(usuario1);
//        rol2.setEvento(evento2);
//        
//        Rol rol3 = new Rol();
//        rol3.setRol(usuario);
//        rol3.setUsuario(usuario2);
//        rol3.setEvento(evento1);
//        
//        Rol rol4 = new Rol();
//        rol4.setRol(usuario);
//        rol4.setUsuario(usuario2);
//        rol4.setEvento(evento2);
//        
        em.merge(provincia);
        em.merge(localidad);
//        em.merge(comentario1);
//        em.merge(comentario2);
//        em.merge(comentario3);
//        em.merge(comentario4);
//        em.merge(comentarios_el_bosco);
//        em.merge(comentarios_murakami);
//        em.merge(destinatario1);
//        em.merge(destinatario2);
//        em.merge(destinatario3);
//        em.merge(destinatario4);
//        em.merge(destinatario5);
//        em.merge(destinatarios);
//        em.merge(etiqueta1);
//        em.merge(etiqueta2);
//        em.merge(etiqueta3);
//        em.merge(etiqueta4);
//        em.merge(etiquetas_arte);
//        em.merge(etiquetas_literatura);
//        em.merge(evento1);
//        em.merge(evento2);
//        em.merge(eventos_malaga);
//        em.merge(privilegio1);
//        em.merge(privilegio2);
//        em.merge(privilegio3);
//        em.merge(privilegios_redactor);
//        em.merge(privilegios_usuario);
//        em.merge(privilegios_validado);
//        em.merge(redactor);
//        em.merge(rol);
//        em.merge(rol2);
//        em.merge(rol3);
//        em.merge(rol4);
//        em.merge(usuario);
//        em.merge(usuario1);
//        em.merge(usuario2);
//        em.merge(validado);
        
        
        em.getTransaction().commit();
        
        em.close();
        emf.close();

    }
}
