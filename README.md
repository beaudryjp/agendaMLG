# agendaMLG
La aplicación agendaMLG para el Diario Sur - SII 

# Cambio Base de datos (2/4/2017)
Se ha cambiado la base de datos a diariosur(estaba por defecto en sample), en Services -> Java DB hay que crear la base de datos "diariosur" con los siguientes datos de acceso:
URL: jdbc:derby://localhost:1527/diariosur
Usuario: agenda
Contraseña: 9cx#7QjyTWXO

Esto se ha hecho porque al usar la base de datos "sample" sale un error parecido a:
Caused by: ERROR XCL47: Use of 'SEQUENCES' requires database to be upgraded from version 10.5 to version 10.6 or later.

# Cambio de EclipseLink a Hibernate  (2/4/2017)
Se ha cambiado el motor de persistencia de EclipseLink a Hibernate
