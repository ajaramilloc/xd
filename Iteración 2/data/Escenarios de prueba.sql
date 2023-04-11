

///////////////// INICIO OPERADOR_HOTEL ///////////////////////////

//Restricciones Unicidad
INSERT INTO USUARIO_OPERADOR (usuario, contrasena) VALUES ('UsuarioOperador4', 'ContrasenaOperador4');
INSERT INTO USUARIO_OPERADOR (usuario, contrasena) VALUES ('UsuarioOperador5', 'ContrasenaOperador5');

INSERT INTO OPERADOR_HOTEL (identificacion, registroCamara, registroSuperintendencia, nombre, ubicacion, usuario) 
VALUES (11101, 1234, 4321, 'Hotel las villas', 'Calle 97 #11', 'UsuarioOperador4');

INSERT INTO OPERADOR_HOTEL (identificacion, registroCamara, registroSuperintendencia, nombre, ubicacion, usuario) 
VALUES (11101, 4567, 7654, 'Hotel las rosas', 'Calle 67 #13', 'UsuarioOperador5');

//Restricciones integridad FK
INSERT INTO USUARIO_OPERADOR (usuario, contrasena) VALUES ('UsuarioOperador6', 'ContrasenaOperador6');

INSERT INTO OPERADOR_HOTEL (identificacion, registroCamara, registroSuperintendencia, nombre, ubicacion, usuario) 
VALUES (11102, 6789, 9876, 'Hotel las flores', 'Calle 63 #70', 'UsuarioOperador6');

INSERT INTO OPERADOR_HOTEL (identificacion, registroCamara, registroSuperintendencia, nombre, ubicacion, usuario) 
VALUES (11103, 3465, 5643, 'Hotel las uvas', 'Calle 43 #75', 'UsuarioOperador7');

///////////////// FIN OPERADOR_HOTEL ///////////////////////////



///////////////// INICIO OPERADOR_HOSTAL ///////////////////////////

//Restricciones Unicidad
INSERT INTO USUARIO_OPERADOR (usuario, contrasena) VALUES ('UsuarioOperador7', 'ContrasenaOperador7');
INSERT INTO USUARIO_OPERADOR (usuario, contrasena) VALUES ('UsuarioOperador8', 'ContrasenaOperador8');

INSERT INTO OPERADOR_HOSTAL (identificacion, registroCamara, registroSuperintendencia, nombre, ubicacion, horaApertura, horaCierre, usuario) 
VALUES (11103, 1367, 7631, 'Hostal Roca', 'Calle 66 #13', '8 AM', '8 PM', 'UsuarioOperador7');

INSERT INTO OPERADOR_HOSTAL (identificacion, registroCamara, registroSuperintendencia, nombre, ubicacion, horaApertura, horaCierre, usuario) 
VALUES (11103, 7765, 5677, 'Hostal Montana', 'Calle 71 #34', '6 AM', '6 PM', 'UsuarioOperador8');

//Restricciones integridad FK
INSERT INTO USUARIO_OPERADOR (usuario, contrasena) VALUES ('UsuarioOperador9', 'ContrasenaOperador9');

INSERT INTO OPERADOR_HOSTAL (identificacion, registroCamara, registroSuperintendencia, nombre, ubicacion, horaApertura, horaCierre, usuario) 
VALUES (11104, 8789, 9878, 'Hostal Agua', 'Calle 44 #10', '7 AM', '7 PM', 'UsuarioOperador9');

INSERT INTO OPERADOR_HOTEL (identificacion, registroCamara, registroSuperintendencia, nombre, ubicacion, usuario) 
VALUES (11105, 1256, 6521, 'Hotel Rio', 'Calle 11 #99', 'UsuarioOperador10');

///////////////// FIN OPERADOR_HOSTAL ///////////////////////////



///////////////// INICIO OPERADOR_EMPRESA_VIVIENDA ///////////////////////////

//Restricciones Unicidad
INSERT INTO USUARIO_OPERADOR (usuario, contrasena) VALUES ('UsuarioOperador10', 'ContrasenaOperador10');
INSERT INTO USUARIO_OPERADOR (usuario, contrasena) VALUES ('UsuarioOperador11', 'ContrasenaOperador11');

INSERT INTO OPERADOR_EMPRESA_VIVIENDA (identificacion, registroCamara, registroSuperintendencia, nombre, nit, usuario) 
VALUES (11105, 3443, 4343, 'Empresa Vivienda Uno', 1290892, 'UsuarioOperador10');

INSERT INTO OPERADOR_EMPRESA_VIVIENDA (identificacion, registroCamara, registroSuperintendencia, nombre, nit, usuario) 
VALUES (11105, 1092, 2901, 'Empresa Vivienda Dos', 3109312, 'UsuarioOperador11');

//Restricciones integridad FK

INSERT INTO OPERADOR_EMPRESA_VIVIENDA (identificacion, registroCamara, registroSuperintendencia, nombre, nit, usuario) 
VALUES (11106, 1092, 2901, 'Empresa Vivienda Dos', 3109312, 'UsuarioOperador11');

INSERT INTO OPERADOR_EMPRESA_VIVIENDA (identificacion, registroCamara, registroSuperintendencia, nombre, nit, usuario) 
VALUES (11107, 1576, 6751, 'Empresa Vivienda tres', 8772463, 'UsuarioOperador12');

///////////////// FIN OPERADOR_EMPRESA_VIVIENDA ///////////////////////////



///////////////// INICIO USUARIO_OPERADOR ///////////////////////////

//Restricciones Unicidad
INSERT INTO USUARIO_OPERADOR (usuario, contrasena) VALUES ('UsuarioOperador12', 'ContrasenaOperador12');
INSERT INTO USUARIO_OPERADOR (usuario, contrasena) VALUES ('UsuarioOperador12', 'ContrasenaOperador13');

///////////////// FIN USUARIO_OPERADOR ///////////////////////////



///////////////// INICIO USUARIO_PERSONA ///////////////////////////

//Restricciones Unicidad
INSERT INTO USUARIO_PERSONA (usuario, contrasena, carnetUniandes, vinculacion, esOperador) 
VALUES ('UsuarioPersona4', 'ContrasenaPersona4', 202110564, 'Estudiante', 'false');

INSERT INTO USUARIO_PERSONA (usuario, contrasena, carnetUniandes, vinculacion, esOperador) 
VALUES ('UsuarioPersona4', 'ContrasenaPersona5', 202110786, 'Profesor', 'true');

//Restricciones sobre CK
INSERT INTO USUARIO_PERSONA (usuario, contrasena, carnetUniandes, vinculacion, esOperador) 
VALUES ('UsuarioPersona5', 'ContrasenaPersona5', 202110786, 'Profesor', 'true');

INSERT INTO USUARIO_PERSONA (usuario, contrasena, carnetUniandes, vinculacion, esOperador) 
VALUES ('UsuarioPersona6', 'ContrasenaPersona6', 9021345, 'profe', 'true');

///////////////// FIN USUARIO_PERSONA ///////////////////////////



///////////////// INICIO OFERTA_VIVIENDA_COMUNIDAD ///////////////////////////

//Restricciones Unicidad
INSERT INTO OFERTAS_ALOJAMIENTO (id, tipoOferta, operador) VALUES (10101, 'OfertaViviendaComunidad','UsuarioOperador10');

INSERT INTO OFERTA_VIVIENDA_COMUNIDAD(id, costo, numHabitaciones, ubicacion, menaje, seguroArrendamiento, operador, capacidad, fechaInicio, fechaFin) 
VALUES (10101, 900000, 3, 'Calle 47 #33', 'Menaje 1', 2031209, 'UsuarioOperador10', 4, '12/07/23', '12/08/23');

INSERT INTO OFERTA_VIVIENDA_COMUNIDAD(id, costo, numHabitaciones, ubicacion, menaje, seguroArrendamiento, operador, capacidad, fechaInicio, fechaFin) 
VALUES (10101, 120000, 4, 'Calle 61 #14', 'Menaje 2', 9872343, 'UsuarioOperador10', 5, '12/07/23', '12/08/23');

//Restricciones integridad FK
INSERT INTO OFERTAS_ALOJAMIENTO (id, tipoOferta, operador) VALUES (10102, 'OfertaViviendaComunidad','UsuarioOperador11');

INSERT INTO OFERTA_VIVIENDA_COMUNIDAD(id, costo, numHabitaciones, ubicacion, menaje, seguroArrendamiento, operador, capacidad, fechaInicio, fechaFin) 
VALUES (10102, 120000, 4, 'Calle 61 #14', 'Menaje 2', 9872343, 'UsuarioOperador11', 5, '12/07/23', '12/08/23');

INSERT INTO OFERTA_VIVIENDA_COMUNIDAD(id, costo, numHabitaciones, ubicacion, menaje, seguroArrendamiento, operador, capacidad, fechaInicio, fechaFin) 
VALUES (10103, 500000, 3, 'Calle 19 #10', 'Menaje 3', 3821971, 'UsuarioOperador15', 3, '12/07/23', '12/08/23');

///////////////// FIN OFERTA_VIVIENDA_COMUNIDAD ///////////////////////////



///////////////// INICIO OFERTA_VIVIENDA_PROPIA ///////////////////////////

//Restricciones Unicidad
INSERT INTO OFERTAS_ALOJAMIENTO (id, tipoOferta, operador) VALUES (10103, 'OfertaViviendaPropia','UsuarioOperador10');

INSERT INTO OFERTA_VIVIENDA_PROPIA(id, costo, comidas, accesoCocina, banoPrivado, habIndividual, costoServicios, esquema, operador, capacidad, fechaInicio, fechaFin)
VALUES (10103, 700000, 'true', 'false', 'true', 'false', 230000, 'Esquema1', 'UsuarioOperador10', 3, '12/07/23', '12/08/23');

INSERT INTO OFERTA_VIVIENDA_PROPIA(id, costo, comidas, accesoCocina, banoPrivado, habIndividual, costoServicios, esquema, operador, capacidad, fechaInicio, fechaFin)
VALUES (10103, 850000, 'true', 'true', 'true', 'false', 300000, 'Esquema2', 'UsuarioOperador10', 5, '12/07/23', '12/08/23');

//Restricciones integridad FK
INSERT INTO OFERTAS_ALOJAMIENTO (id, tipoOferta, operador) VALUES (10104, 'OfertaViviendaPropia','UsuarioOperador11');
INSERT INTO OFERTAS_ALOJAMIENTO (id, tipoOferta, operador) VALUES (10106, 'OfertaViviendaPropia','UsuarioOperador12');

INSERT INTO OFERTA_VIVIENDA_PROPIA(id, costo, comidas, accesoCocina, banoPrivado, habIndividual, costoServicios, esquema, operador, capacidad, fechaInicio, fechaFin)
VALUES (10104, 850000, 'true', 'true', 'true', 'false', 300000, 'Esquema2', 'UsuarioOperador11', 5, '12/07/23', '12/08/23');

INSERT INTO OFERTA_VIVIENDA_PROPIA(id, costo, comidas, accesoCocina, banoPrivado, habIndividual, costoServicios, esquema, operador, capacidad, fechaInicio, fechaFin)
VALUES (10106, 470000, 'true', 'false', 'false', 'false', 180000, 'Esquema3', 'UsuarioOperador15', 2, '12/07/23', '12/08/23');

///////////////// FIN OFERTA_VIVIENDA_COMUNIDAD ///////////////////////////



///////////////// INICIO OFERTA_APARTAMENTO ///////////////////////////

//Restricciones Unicidad
INSERT INTO OFERTAS_ALOJAMIENTO (id, tipoOferta, operador) VALUES (10107, 'OfertaApartamento','UsuarioOperador11');

INSERT INTO APARTAMENTO (numero, conjunto, direccion, amoblado, dueno) VALUES (604, 'Altos del bronx', 'Calle 19 #23', 'true', 'UsuarioOperador11');

INSERT INTO OFERTA_APARTAMENTO (id, costo, serviciosIncluidos, tv, internet, administracion, capacidad, numeroApartamento, conjuntoApartamento, direccionApartamento, operador, 
fechaInicio, fechaFin) VALUES (10107, 2400000, 'true', 'false', 'true', 'false', 7, 604, 'Altos del bronx', 'Calle 19 #23', 'UsuarioOperador11', '12/07/23', '12/11/23');

INSERT INTO OFERTA_APARTAMENTO (id, costo, serviciosIncluidos, tv, internet, administracion, capacidad, numeroApartamento, conjuntoApartamento, direccionApartamento, operador, 
fechaInicio, fechaFin) VALUES (10107, 1850000, 'true', 'true', 'true', 'true', 6, 1101, 'Altos del barrio', 'Calle 80 #11', 'UsuarioOperador11', '12/07/23', '12/11/23');

//Restricciones integridad FK
INSERT INTO OFERTAS_ALOJAMIENTO (id, tipoOferta, operador) VALUES (10108, 'OfertaApartamento','UsuarioOperador12');
INSERT INTO OFERTAS_ALOJAMIENTO (id, tipoOferta, operador) VALUES (10111, 'OfertaApartamento','UsuarioOperador12');

INSERT INTO APARTAMENTO (numero, conjunto, direccion, amoblado, dueno) VALUES (1101, 'Altos del barrio', 'Calle 80 #11', 'true', 'UsuarioOperador12');
INSERT INTO APARTAMENTO (numero, conjunto, direccion, amoblado, dueno) VALUES (1102, 'Altos del sin', 'Calle 76 #33', 'true', 'UsuarioOperador12');

INSERT INTO OFERTA_APARTAMENTO (id, costo, serviciosIncluidos, tv, internet, administracion, capacidad, numeroApartamento, conjuntoApartamento, direccionApartamento, operador, 
fechaInicio, fechaFin) VALUES (10108, 1850000, 'true', 'true', 'true', 'true', 6, 1101, 'Altos del barrio', 'Calle 80 #11', 'UsuarioOperador12', '12/07/23', '12/10/23');

INSERT INTO OFERTA_APARTAMENTO (id, costo, serviciosIncluidos, tv, internet, administracion, capacidad, numeroApartamento, conjuntoApartamento, direccionApartamento, operador, 
fechaInicio, fechaFin) VALUES (10111, 1670000, 'true', 'false', 'false', 'true', 6, 1107, 'Altos del mar', 'Calle 86 #9', 'UsuarioOperador17', '12/10/23', '12/11/23');

///////////////// FIN OFERTA_APARTAMENTO ///////////////////////////



///////////////// INICIO OFERTAS_ALOJAMIENTO ///////////////////////////

//Restricciones Unicidad
INSERT INTO OFERTAS_ALOJAMIENTO (id, tipoOferta, operador) VALUES (10112, 'OfertaApartamento','UsuarioOperador11');
INSERT INTO OFERTAS_ALOJAMIENTO (id, tipoOferta, operador) VALUES (10112, 'OfertaViviendaPropia','UsuarioOperador12');

//Restricciones integridad FK
INSERT INTO OFERTAS_ALOJAMIENTO (id, tipoOferta, operador) VALUES (10116, 'OfertaApartamento','UsuarioOperador12');
INSERT INTO OFERTAS_ALOJAMIENTO (id, tipoOferta, operador) VALUES (10117, 'OfertaDeApartamento','UsuarioOperador19');

//Restricciones integridad CK
INSERT INTO OFERTAS_ALOJAMIENTO (id, tipoOferta, operador) VALUES (10113, 'OfertaApartamento','UsuarioOperador12');
INSERT INTO OFERTAS_ALOJAMIENTO (id, tipoOferta, operador) VALUES (10114, 'OfertaDeApartamento','UsuarioOperador12');

///////////////// FIN OFERTAS_ALOJAMIENTO ///////////////////////////
