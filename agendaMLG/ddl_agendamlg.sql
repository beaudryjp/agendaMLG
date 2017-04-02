create sequence hibernate_sequence start with 1 increment by 1
create table Comentario (id_comentario bigint not null, fecha date, hora time, mensaje varchar(255), evento_id_evento bigint, usuario_id_usuario bigint, primary key (id_comentario))
create table Destinatario (id_destinatario bigint not null, descripcion varchar(255) not null, primary key (id_destinatario))
create table Etiqueta (id_etiqueta bigint not null, nombre varchar(255) not null, primary key (id_etiqueta))
create table Evento (id_evento bigint not null, descripcion varchar(255) not null, fecha_fin date, fecha_inicio date not null, horario varchar(255), latitud double, longitud double, precio varchar(255), titulo varchar(255), localidad_id_localidad bigint, primary key (id_evento))
create table Evento_Rol (Evento_id_evento bigint not null, rol_evento_pk bigint not null, rol_tipo_rol_pk bigint not null, rol_usuario_pk bigint not null, primary key (Evento_id_evento, rol_evento_pk, rol_tipo_rol_pk, rol_usuario_pk))
create table jn_asiste_id (id_usuario bigint not null, id_evento bigint not null, primary key (id_usuario, id_evento))
create table jn_comentarios_id (id_evento bigint not null, id_comentario bigint not null)
create table jn_destinatario_id (id_evento bigint not null, id_destinatario bigint not null, primary key (id_evento, id_destinatario))
create table jn_etiqueta_id (id_evento bigint not null, id_etiqueta bigint not null, primary key (id_evento, id_etiqueta))
create table jn_megusta_id (id_usuario bigint not null, id_evento bigint not null, primary key (id_usuario, id_evento))
create table jn_notificaciones_id (id_evento bigint not null, id_notificacion bigint not null)
create table jn_sigue_id (id_usuario bigint not null, id_evento bigint not null, primary key (id_usuario, id_evento))
create table Localidad (id_localidad bigint not null, nombre varchar(255) not null, provincia_id_provincia bigint, primary key (id_localidad))
create table Notificacion (id_notificacion bigint not null, fecha date, hora time, mensaje varchar(255), evento_id_evento bigint, usuario_id_usuario bigint, primary key (id_notificacion))
create table Privilegio (id_privilegio bigint not null, descripcion varchar(255), nombre_privilegio varchar(255), primary key (id_privilegio))
create table Privilegio_Tipo_Rol (Privilegio_id_privilegio bigint not null, roles_id_rol bigint not null, primary key (Privilegio_id_privilegio, roles_id_rol))
create table privilegios_rol (id_rol bigint not null, id_privilegio bigint not null, primary key (id_rol, id_privilegio))
create table Provincia (id_provincia bigint not null, nombre varchar(255) not null, primary key (id_provincia))
create table Rol (evento_pk bigint not null, tipo_rol_pk bigint not null, usuario_pk bigint not null, id_evento bigint, id_tipo_rol bigint, id_usuario bigint, primary key (evento_pk, tipo_rol_pk, usuario_pk))
create table Tipo_Rol (id_rol bigint not null, nombre_rol varchar(255) not null, primary key (id_rol))
create table Tipo_Rol_Rol (Tipo_Rol_id_rol bigint not null, rol_evento_pk bigint not null, rol_tipo_rol_pk bigint not null, rol_usuario_pk bigint not null, primary key (Tipo_Rol_id_rol, rol_evento_pk, rol_tipo_rol_pk, rol_usuario_pk))
create table Usuario (id_usuario bigint not null, apellidos varchar(255) not null, email varchar(255) not null, email_notifier boolean not null, latitud double, longitud double, nombre varchar(255) not null, password_hash varchar(255) not null, pseudonimo varchar(255) not null, sal varchar(255) not null, primary key (id_usuario))
create table Usuario_Comentario (Usuario_id_usuario bigint not null, comentarios_id_comentario bigint not null)
create table Usuario_Notificacion (Usuario_id_usuario bigint not null, notificaciones_id_notificacion bigint not null)
create table Usuario_Rol (Usuario_id_usuario bigint not null, rol_evento_pk bigint not null, rol_tipo_rol_pk bigint not null, rol_usuario_pk bigint not null, primary key (Usuario_id_usuario, rol_evento_pk, rol_tipo_rol_pk, rol_usuario_pk))
create unique index UK2sjbycku5b4t3jqhi2g5gmr30 on Destinatario (descripcion)
create unique index UKije0j9xo5bv710qs724e9r3un on Etiqueta (nombre)
alter table Evento_Rol add constraint UK_rfss70qjsdw5y8dgx9ub7nw29 unique (rol_evento_pk, rol_tipo_rol_pk, rol_usuario_pk)
alter table jn_comentarios_id add constraint UK_7g2o2ots9n8k8qj5gscj6w9oi unique (id_comentario)
alter table jn_notificaciones_id add constraint UK_4y9n1gcb6tj6vox08g1fcuiml unique (id_notificacion)
create unique index UK5cxvsj9bb8rxa6uvt6oh7kahq on Localidad (nombre)
create unique index UKd1cf8lk1el2dtgoto044it93v on Privilegio (nombre_privilegio)
create unique index UK8mf2hn9jl0ilqosl320daxen6 on Provincia (nombre)
create unique index UKbngpv5vj41nlfg48cyhxodsl7 on Tipo_Rol (nombre_rol)
alter table Tipo_Rol_Rol add constraint UK_1reammrrn5vp62lyc7xp5p54j unique (rol_evento_pk, rol_tipo_rol_pk, rol_usuario_pk)
create unique index UKp2n8frvlleaccfkhl6ea1csyn on Usuario (email, pseudonimo, sal)
alter table Usuario_Comentario add constraint UK_f60d62tcpd4i615w55bi7299a unique (comentarios_id_comentario)
alter table Usuario_Notificacion add constraint UK_tiyymu90gk1cl2a422fj9dvqk unique (notificaciones_id_notificacion)
alter table Usuario_Rol add constraint UK_7i6mm3dbg0i5p5swy1c4qu2su unique (rol_evento_pk, rol_tipo_rol_pk, rol_usuario_pk)
alter table Comentario add constraint FKgmk41wggq7acr5cin4y6petdr foreign key (evento_id_evento) references Evento
alter table Comentario add constraint FKq2utsndscehnpau990r39jlgg foreign key (usuario_id_usuario) references Usuario
alter table Evento add constraint FK56opiht2l9kwnn8dax44cru9g foreign key (localidad_id_localidad) references Localidad
alter table Evento_Rol add constraint FK616lp5ewpj1err2yakorhhwu8 foreign key (rol_evento_pk, rol_tipo_rol_pk, rol_usuario_pk) references Rol
alter table Evento_Rol add constraint FK456nha1p92dg076kjgh0dg2c2 foreign key (Evento_id_evento) references Evento
alter table jn_asiste_id add constraint FKovbsrolbousftowmxb09rx6m5 foreign key (id_evento) references Evento
alter table jn_asiste_id add constraint FKibsvj08cy6cmv51d1wdcx5jwl foreign key (id_usuario) references Usuario
alter table jn_comentarios_id add constraint FK3k1qhp4v45uoqm8nkaykx1ngr foreign key (id_comentario) references Comentario
alter table jn_comentarios_id add constraint FKpwwkvvej5bpsklunm6mvik337 foreign key (id_evento) references Evento
alter table jn_destinatario_id add constraint FK9amxm8d403yft4astl2qjb3tu foreign key (id_destinatario) references Destinatario
alter table jn_destinatario_id add constraint FK4d7f76lcbl4ns95qfy8dsohmf foreign key (id_evento) references Evento
alter table jn_etiqueta_id add constraint FKkynorwdijmpyv1utmu0py9ax4 foreign key (id_etiqueta) references Etiqueta
alter table jn_etiqueta_id add constraint FK9aijur6g9lccsi7fb6hega1hr foreign key (id_evento) references Evento
alter table jn_megusta_id add constraint FKsv6e8tl6af3r3wfyj7ig6tf1u foreign key (id_evento) references Evento
alter table jn_megusta_id add constraint FKa52g9ffuufl77w57q9e5u3sf1 foreign key (id_usuario) references Usuario
alter table jn_notificaciones_id add constraint FK486syap1s5jap40gfow7pwvw9 foreign key (id_notificacion) references Notificacion
alter table jn_notificaciones_id add constraint FKbp6k5qsbo9knc133imhpk3as2 foreign key (id_evento) references Evento
alter table jn_sigue_id add constraint FKs8kjpmi65fsicwu74lvpe5n83 foreign key (id_evento) references Evento
alter table jn_sigue_id add constraint FKb2vamopaeeuc2ifmrwhw7slhp foreign key (id_usuario) references Usuario
alter table Localidad add constraint FKf8uibl8ose2ibp6pps8jsqpqi foreign key (provincia_id_provincia) references Provincia
alter table Notificacion add constraint FKf584afdtx8glf5nnjsytid5kl foreign key (evento_id_evento) references Evento
alter table Notificacion add constraint FKpkjtdox8eey9m5e7yecp80kxo foreign key (usuario_id_usuario) references Usuario
alter table Privilegio_Tipo_Rol add constraint FKeh1pwtmt6e6dhgl07n45inwme foreign key (roles_id_rol) references Tipo_Rol
alter table Privilegio_Tipo_Rol add constraint FKcfy45sqafcmes6g1lum99ulfs foreign key (Privilegio_id_privilegio) references Privilegio
alter table privilegios_rol add constraint FK4jdwsmdf957efshnevgw9u15m foreign key (id_privilegio) references Privilegio
alter table privilegios_rol add constraint FKm197qdeyarw3iujgsq8c5bg73 foreign key (id_rol) references Tipo_Rol
alter table Rol add constraint FKo57y11q1icwglpphrhc7tf8rx foreign key (id_evento) references Evento
alter table Rol add constraint FKr0vd0d343vemyhv373xgn4n8n foreign key (id_tipo_rol) references Tipo_Rol
alter table Rol add constraint FKip45yoh6nxkeknw6rwt9elqcs foreign key (id_usuario) references Usuario
alter table Tipo_Rol_Rol add constraint FKb3coq46nlwsy100nc1pj4idn8 foreign key (rol_evento_pk, rol_tipo_rol_pk, rol_usuario_pk) references Rol
alter table Tipo_Rol_Rol add constraint FK2qark6rldimhygsxpjxe95v4n foreign key (Tipo_Rol_id_rol) references Tipo_Rol
alter table Usuario_Comentario add constraint FKnx59dirmr7krgevevccl4y3gl foreign key (comentarios_id_comentario) references Comentario
alter table Usuario_Comentario add constraint FKlbxl5q1m8qb9hqnvjhsynx3hb foreign key (Usuario_id_usuario) references Usuario
alter table Usuario_Notificacion add constraint FKrd5lua2v1143hns7pv5000hr9 foreign key (notificaciones_id_notificacion) references Notificacion
alter table Usuario_Notificacion add constraint FKm2lsgu9dc2xijhl06eevxgojo foreign key (Usuario_id_usuario) references Usuario
alter table Usuario_Rol add constraint FK1q2vpxxoy272u3b731pfs1pcw foreign key (rol_evento_pk, rol_tipo_rol_pk, rol_usuario_pk) references Rol
alter table Usuario_Rol add constraint FKlwghipgyki7gidd0fi132ifsu foreign key (Usuario_id_usuario) references Usuario
