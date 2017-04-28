package grupog.agendamlg;

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

        //Provincia
        Provincia provincia = new Provincia();
        provincia.setNombre("Málaga");
                
        //Localidad
        Localidad localidad = new Localidad();
        localidad.setNombre("Málaga");
        localidad.setProvincia(provincia);
        
        Set<Localidad> localidades = new TreeSet<>();
        localidades.add(localidad);
        provincia.setLocalidades(localidades);
        
        
        Destinatario destinatario1=new Destinatario();
        destinatario1.setDescripcion("niño");
        Destinatario destinatario2=new Destinatario();
        destinatario2.setDescripcion("adolescente");
        Destinatario destinatario3=new Destinatario();
        destinatario3.setDescripcion("adulto");
        Destinatario destinatario4=new Destinatario();
        destinatario4.setDescripcion("anciano");
        Destinatario destinatario5=new Destinatario();
        destinatario5.setDescripcion("todos");
        
        
        Etiqueta etiqueta1 = new Etiqueta();
        Etiqueta etiqueta2 = new Etiqueta();
        Etiqueta etiqueta3 = new Etiqueta();
        Etiqueta etiqueta4 = new Etiqueta();
        etiqueta1.setNombre("literatura");
        etiqueta2.setNombre("arte");
        etiqueta3.setNombre("escuela_flamenca");
        etiqueta4.setNombre("japonesa");
        
        //Usuario
        Usuario usuario1 = new Usuario();
        Usuario usuario2 = new Usuario();
        usuario1.setNombre("Javier");
        usuario1.setApellidos("Aguilera Puerta");
        usuario1.setEmail("jaguilerapuerta@gmail.com");
        usuario1.setSal("notnull");
        usuario1.setPassword_hash(("pass"+usuario1.getSal()).hashCode()+"");
        usuario1.setEmail_notifier(false);
        usuario1.setLatitud(36.7384747);
        usuario1.setLongitud(-4.4195087);
        usuario1.setPseudonimo("kafkaphoenix");
        usuario1.setRol_usuario(Usuario.Tipo_Rol.REDACTOR);
        usuario2.setNombre("Marie");
        usuario2.setApellidos("Poppo po");
        usuario2.setEmail("popopo@poppo.po");
        usuario2.setSal("notnull");
        usuario2.setPassword_hash(("pass"+usuario2.getSal()).hashCode()+"");
        usuario2.setEmail_notifier(false);
        usuario2.setLatitud(35.6985448);
        usuario2.setLongitud(139.7699039);
        usuario2.setPseudonimo("poppo po?");
        usuario2.setRol_usuario(Usuario.Tipo_Rol.VALIDADO);
        
        //Evento
        Evento evento1 = new Evento();
        evento1.setPrecio("gratis");
        evento1.setFecha_inicio(new Date(2017,4,3));
        evento1.setFecha_fin(new Date(2017,8,3));
        evento1.setHorario("10am - 20pm");
        evento1.setTitulo("Murakami");
        evento1.setLatitud(36.7135979);
        evento1.setLongitud(-4.42488000000003);
        evento1.setDescripcion("evento1");
        evento1.setLocalidad(localidad);
        Evento evento2 = new Evento();
        evento2.setPrecio("10 euros");
        evento2.setFecha_inicio(new Date(2017,5,15));
        evento2.setFecha_fin(new Date(2017,6,15));
        evento2.setHorario("18pm - 24pm");
        evento2.setTitulo("El Bosco: Vida y Obra");
        evento2.setLatitud(36.7135979);
        evento2.setLongitud(-4.42488000000003);
        evento2.setDescripcion("evento2");
        evento2.setLocalidad(localidad);
        
        Set <Evento> eventos_malaga= new TreeSet<>();
        eventos_malaga.add(evento2);
        usuario1.setMegusta(eventos_malaga);
        usuario1.setAsiste(eventos_malaga);
        usuario1.setSigue(eventos_malaga);
        
        usuario2.setAsiste(eventos_malaga);
        usuario2.setSigue(eventos_malaga);
        
        Set <Destinatario> destinatarios = new TreeSet<>();
        destinatarios.add(destinatario2);
        destinatarios.add(destinatario3);
        destinatarios.add(destinatario4);
        evento1.setDestinatario(destinatarios);
        evento2.setDestinatario(destinatarios);
        
        
        Set <Etiqueta> etiquetas_literatura = new TreeSet<>();
        Set <Etiqueta> etiquetas_arte = new TreeSet<>();
        
        etiquetas_literatura.add(etiqueta1);
        etiquetas_literatura.add(etiqueta4);
        etiquetas_literatura.add(etiqueta2);
        etiquetas_literatura.add(etiqueta3);
        
        evento1.setEtiqueta(etiquetas_literatura);
        evento2.setEtiqueta(etiquetas_arte);
        
        Comentario comentario1 = new Comentario();
        comentario1.setEvento(evento1);
        comentario1.setUsuario(usuario2);
        comentario1.setMensaje("Po");
        Comentario comentario2 = new Comentario();
        comentario2.setEvento(evento1);
        comentario2.setUsuario(usuario2);
        comentario2.setMensaje("Murakami's Bingo");
        Comentario comentario3 = new Comentario();
        comentario3.setEvento(evento1);
        comentario3.setUsuario(usuario2);
        comentario3.setMensaje("CAT");
        Comentario comentario4 = new Comentario();
        comentario4.setEvento(evento2);
        comentario4.setUsuario(usuario2);
        comentario4.setMensaje("Me gusta el jardín de las delicias");
           
        List <Comentario> comentarios_user=new ArrayList<>();
        List <Comentario> comentarios_murakami=new ArrayList<>();
        List <Comentario> comentarios_el_bosco=new ArrayList<>();
        comentarios_murakami.add(comentario1);
        comentarios_murakami.add(comentario2);
        comentarios_murakami.add(comentario3);
        comentarios_el_bosco.add(comentario4);
        comentarios_user.add(comentario1);
        comentarios_user.add(comentario2);
        comentarios_user.add(comentario3);
        comentarios_user.add(comentario4);

        usuario2.setComentarios(comentarios_user);
        evento1.setComentarios(comentarios_murakami);
        evento2.setComentarios(comentarios_el_bosco);
        
        Notificacion notificacion1 = new Notificacion();
        notificacion1.setEvento(evento1);
        notificacion1.setUsuario(usuario1);
        notificacion1.setMensaje("prueba");
        
        List <Notificacion> event_notificaciones = new ArrayList<>();
        event_notificaciones.add(notificacion1);
        
        evento1.setNotificaciones(event_notificaciones);
        
        List<Notificacion> user_notificaciones = new ArrayList<>();
        user_notificaciones.add(notificacion1);
        usuario1.setNotificaciones(user_notificaciones);
       
        
        em.persist(provincia);
        em.persist(localidad);
        em.persist(destinatario1);
        em.persist(destinatario2);
        em.persist(destinatario3);
        em.persist(destinatario4);
        em.persist(destinatario5);
        em.persist(etiqueta1);
        em.persist(etiqueta2);
        em.persist(etiqueta3);
        em.persist(etiqueta4);
        em.persist(usuario1);
        em.persist(usuario2);
        em.persist(evento1);
        em.persist(evento2);
        em.persist(comentario1);
        em.persist(comentario2);
        em.persist(comentario3);
        em.persist(comentario4);
        em.persist(notificacion1);

        em.getTransaction().commit();
        
        em.close();
        emf.close();

    }
}