create sequence alohAndes_sequence;

CREATE TABLE Operador_Hotel
(
	identificacion NUMERIC(5,0),
	registroCamara NUMERIC(10,0) NOT NULL UNIQUE,
	registroSuperintendencia NUMERIC(10,0) NOT NULL UNIQUE,
	nombre VARCHAR2(30 BYTE) NOT NULL,
	ubicacion VARCHAR2(30 BYTE) NOT NULL UNIQUE,
	usuario VARCHAR2(50 BYTE) NOT NULL UNIQUE,
	CONSTRAINT Operador_Hotel_PK PRIMARY KEY (identificacion) 
);


CREATE TABLE Operador_Hostal
(
	identificacion NUMERIC(5,0),
	registroCamara NUMERIC(10,0) NOT NULL UNIQUE,
	registroSuperintendencia NUMERIC(10,0) NOT NULL UNIQUE,
	nombre VARCHAR2(30 BYTE) NOT NULL,
	ubicacion VARCHAR2(30 BYTE) NOT NULL UNIQUE,
	horaApertura VARCHAR2(30 BYTE) NOT NULL,
	horaCierre VARCHAR2(30 BYTE) NOT NULL,
	usuario VARCHAR2(50 BYTE) NOT NULL UNIQUE,
	CONSTRAINT Operador_Hostal_PK PRIMARY KEY (identificacion)  
);


CREATE TABLE Operador_Empresa_Vivienda
(
	identificacion NUMERIC(5,0),
	registroCamara NUMERIC(10,0) NOT NULL UNIQUE,
	registroSuperintendencia NUMERIC(10,0) NOT NULL UNIQUE,
	nombre VARCHAR2(30 BYTE) NOT NULL,
	nit NUMERIC(10,0) NOT NULL UNIQUE,
	usuario VARCHAR2(50 BYTE) NOT NULL UNIQUE,
	CONSTRAINT Operador_Empresa_Vivienda_PK PRIMARY KEY (identificacion)  
);


CREATE TABLE Usuario_Operador
(
	usuario VARCHAR2(30 BYTE),
	contrasena VARCHAR2(50 BYTE) NOT NULL,
	CONSTRAINT Usuario_Operador_PK PRIMARY KEY (usuario)
);

ALTER TABLE Operador_Hotel
	ADD CONSTRAINT FK_Operador_Hotel_Usuario_Operador FOREIGN KEY(usuario) REFERENCES Usuario_Operador(usuario)
ENABLE;

ALTER TABLE Operador_Hostal
	ADD CONSTRAINT FK_Operador_Hostal_Usuario_Operador FOREIGN KEY(usuario) REFERENCES Usuario_Operador(usuario)
ENABLE;

ALTER TABLE Operador_Empresa_Vivienda
	ADD CONSTRAINT FK_Operador_Empresa_Vivienda_Usuario_Operador FOREIGN KEY(usuario) REFERENCES Usuario_Operador(usuario)
ENABLE;


CREATE TABLE Usuario_Persona
(
	usuario VARCHAR2(30 BYTE),
	contrasena VARCHAR2(50 BYTE) NOT NULL,
	carnetUniandes NUMERIC(9,0) NOT NULL UNIQUE,
	vinculacion VARCHAR2(50 BYTE) NOT NULL,
	esOperador VARCHAR2(10 BYTE) NOT NULL,
	CONSTRAINT Usuario_Persona_PK PRIMARY KEY (usuario)
);

ALTER TABLE Usuario_Persona
	ADD CONSTRAINT CK_Usuario_Persona_Vinculacion CHECK (vinculacion in ('Estudiante', 'Profesor', 'Empleado', 'Egresado', 'AsistenteEvento', 'Pariente', 'ProfesorVisitante'))
ENABLE;

ALTER TABLE Usuario_Persona
	ADD CONSTRAINT CK_UsuarioPersona_esOperador CHECK (esOperador in ('true', 'false'))
ENABLE;


CREATE TABLE Ofertas_Alojamiento
(
	id NUMERIC(5,0),
	tipoOferta VARCHAR2(50 BYTE),
	operador VARCHAR2(50 BYTE),
	CONSTRAINT Ofertas_Alojamiento_PK PRIMARY KEY (id)
);

ALTER TABLE Ofertas_Alojamiento
	ADD CONSTRAINT CK_Tipo_Oferta CHECK (tipoOferta in ('OfertaApartamento', 'OfertaViviendaComunidad', 'OfertaViviendaPropia', 'OfertaHabitacion'))
ENABLE;

ALTER TABLE Ofertas_Alojamiento
	ADD CONSTRAINT FK_Ofertas_Alojamiento_Usuario_Operador FOREIGN KEY(operador) REFERENCES Usuario_Operador(usuario)
ENABLE;


CREATE TABLE Oferta_Vivienda_Comunidad
(
	id NUMERIC(5,0),
	costo INT NOT NULL,
	numHabitaciones INT NOT NULL,
	ubicacion VARCHAR2(30 BYTE) NOT NULL,
	menaje VARCHAR2(30 BYTE) NOT NULL,
	seguroArrendamiento NUMERIC(10, 0) NOT NULL,
	operador VARCHAR2(30 BYTE) NOT NULL,
	capacidad INT NOT NULL,
	fechaInicio DATE NOT NULL,
	fechaFin DATE NOT NULL,
	CONSTRAINT Oferta_Vivienda_Comunidad_PK PRIMARY KEY (id)
);

ALTER TABLE Oferta_Vivienda_Comunidad
	ADD CONSTRAINT FK_Oferta_Vivienda_Comunidad_Ofertas_Alojamiento FOREIGN KEY(id) REFERENCES Ofertas_Alojamiento(id)
ENABLE;

ALTER TABLE Oferta_Vivienda_Comunidad
	ADD CONSTRAINT FK_Oferta_Vivienda_Comunidad_Usuario_Operador FOREIGN KEY(operador) REFERENCES Usuario_Operador(usuario)
ENABLE;


CREATE TABLE Oferta_Vivienda_Propia
(
	id NUMERIC(5,0),
	costo INT NOT NULL,
	comidas VARCHAR2(10 BYTE) NOT NULL,
	accesoCocina VARCHAR2(10 BYTE) NOT NULL,
	banoPrivado VARCHAR2(10 BYTE) NOT NULL,
	habIndividual VARCHAR2(10 BYTE) NOT NULL,
	costoServicios INT NOT NULL,
	esquema VARCHAR2(50 BYTE) NOT NULL,
	operador VARCHAR2(30 BYTE) NOT NULL,
	capacidad INT NOT NULL,
	fechaInicio DATE NOT NULL,
	fechaFin DATE NOT NULL,
	CONSTRAINT Oferta_Vivienda_Propia_PK PRIMARY KEY (id)
);

ALTER TABLE Oferta_Vivienda_Propia
	ADD CONSTRAINT FK_Oferta_Vivienda_Propia_Ofertas_Alojamiento FOREIGN KEY(id) REFERENCES Ofertas_Alojamiento(id)
ENABLE;

ALTER TABLE Oferta_Vivienda_Propia
	ADD CONSTRAINT FK_Oferta_Vivienda_Propia_Usuario_Operador FOREIGN KEY(operador) REFERENCES Usuario_Operador(usuario)
ENABLE;


CREATE TABLE Oferta_Apartamento
(
	id NUMERIC(5,0),
	costo INT NOT NULL,
	serviciosIncluidos VARCHAR2(10 BYTE) NOT NULL,
	tv VARCHAR2(10 BYTE) NOT NULL,
	internet VARCHAR2(10 BYTE) NOT NULL,
	administracion VARCHAR2(10 BYTE) NOT NULL,
	capacidad INT NOT NULL,
	numeroApartamento NUMERIC(5,0) NOT NULL UNIQUE,
	conjuntoApartamento VARCHAR2(50 BYTE) NOT NULL UNIQUE,
	direccionApartamento VARCHAR2(50 BYTE) NOT NULL UNIQUE,
	operador VARCHAR2(30 BYTE) NOT NULL,
	fechaInicio DATE NOT NULL,
	fechaFin DATE NOT NULL,
	CONSTRAINT Oferta_Apartamento_PK PRIMARY KEY (id)
);

ALTER TABLE Oferta_Apartamento
	ADD CONSTRAINT FK_Oferta_Apartamento_Ofertas_Alojamiento FOREIGN KEY(id) REFERENCES Ofertas_Alojamiento(id)
ENABLE;

ALTER TABLE Oferta_Apartamento
	ADD CONSTRAINT FK_Oferta_Apartamento_Usuario_Operador FOREIGN KEY(operador) REFERENCES Usuario_Operador(usuario)
ENABLE;


CREATE TABLE Reserva
(
	id NUMERIC(5,0),
	fechaInicio DATE NOT NULL,
	cliente VARCHAR2(30 BYTE) NOT NULL,
	ofertaAsociada NUMERIC(5,0),
	duracion INT NOT NULL,
	fechaRegistro DATE NOT NULL,
	ocupacion INT NOT NULL,
	CONSTRAINT Reserva_PK PRIMARY KEY (id)
);

ALTER TABLE Reserva
	ADD CONSTRAINT FK_Reserva_Usuario_Persona FOREIGN KEY(cliente) REFERENCES Usuario_Persona(usuario)
ENABLE;

ALTER TABLE Reserva
	ADD CONSTRAINT FK_Reserva_Ofertas_Alojamiento FOREIGN KEY(ofertaAsociada) REFERENCES Ofertas_Alojamiento(id)
ENABLE;

CREATE TABLE Contrato 
( 
    id INT,  
	valor INT NOT NULL,  
	meses INT NOT NULL,  
	ofertaAsociada INT NOT NULL,  
	operador VARCHAR(255) NOT NULL,  
	cliente VARCHAR(255) NOT NULL,  
	noches INT NOT NULL,
 	CONSTRAINT Contrato_PK PRIMARY KEY (id)
); 

ALTER TABLE Contrato  
	ADD CONSTRAINT FK_Oferta_Asociada_Contrato FOREIGN KEY (ofertaAsociada) REFERENCES Ofertas_Alojamiento(id)
ENABLE;  

ALTER TABLE Contrato
	ADD CONSTRAINT FK_operador_Contrato FOREIGN KEY (operador) REFERENCES Usuario_Operador(usuario)
ENABLE;  

ALTER TABLE Contrato
	ADD CONSTRAINT FK_cliente_Contrato FOREIGN KEY (cliente) REFERENCES Usuario_Persona(usuario) 
ENABLE; 


CREATE TABLE Oferta_Habitacion 
(
	id INT,  
	costo INT NOT NULL,  
	tipo VARCHAR(255) NOT NULL,  
	tamano VARCHAR(255) NOT NULL,  	
	piso INT NOT NULL,   
	categoria VARCHAR(255) NOT NULL,  
	fechaInicio DATE NOT NULL, 
	fechaFin DATE NOT NULL, 
	menaje VARCHAR(255) NOT NULL, 
	operador VARCHAR(255) NOT NULL,
	capacidad INT,
	CONSTRAINT Oferta_Habitacion_PK PRIMARY KEY (id)
);

ALTER TABLE Oferta_Habitacion
	ADD CONSTRAINT FK_Operador_Oferta_Habitacion FOREIGN KEY (operador) REFERENCES Usuario_Operador(usuario)
ENABLE; 

ALTER TABLE Oferta_Habitacion
	ADD CONSTRAINT CK_tipo_Oferta_Habitacion CHECK (tipo IN ('Estandar', 'Suite', 'Semisuite')) 
ENABLE; 

ALTER TABLE Oferta_Habitacion
	ADD CONSTRAINT CK_categoria_Oferta_Habitacion CHECK (categoria IN ('Hotel', 'Hostal', 'ViviendaPropia', 'EmpresaViviendaUniversitaria'))
ENABLE; 


CREATE TABLE Servicio 
( 
	nombre VARCHAR(50),  
	proveedor VARCHAR(100),  
	indice NUMERIC(4, 2) NOT NULL,   
	capacidad INT NOT NULL,   
	costoAdicional INT,
 	CONSTRAINT Servicio_PK PRIMARY KEY (nombre, proveedor)
); 

ALTER TABLE Servicio
	ADD CONSTRAINT CK_Proveedor_Servicio CHECK (proveedor IN ('Hotel', 'Hostal', 'ViviendaPropia', 'EmpresaViviendaUniversitaria')) 
ENABLE;


CREATE TABLE Apartamento 
( 
	numero INT,   
	conjunto VARCHAR(255),  
	direccion VARCHAR(255),  
	amoblado VARCHAR(255) NOT NULL,   
	dueno VARCHAR(255) NOT NULL,
	CONSTRAINT PK_Apartamento PRIMARY KEY (numero, conjunto, direccion)
); 

ALTER TABLE Apartamento
	ADD CONSTRAINT FK_dueno_Apartamento FOREIGN KEY (dueno) REFERENCES Usuario_Operador(usuario)  
ENABLE;

ALTER TABLE Oferta_Apartamento
	ADD CONSTRAINT FK_numeroApartamento_Oferta_Apartamento FOREIGN KEY(numeroApartamento, conjuntoApartamento, direccionApartamento) REFERENCES Apartamento(numero, conjunto, direccion)
ENABLE;


CREATE TABLE Prestaciones_Hotel 
( 
	id INT,   
	servicio VARCHAR(255) NOT NULL,  
	proveedor VARCHAR(255) NOT NULL,
	CONSTRAINT PK_Prestaciones_Hotel PRIMARY KEY (id)
); 

ALTER TABLE Prestaciones_Hotel
	ADD CONSTRAINT FK_servicio_Proveedor_Hotel FOREIGN KEY (servicio, proveedor) REFERENCES Servicio(nombre, proveedor)
ENABLE;


CREATE TABLE Prestaciones_Hostal 
( 
	id INT,   
	servicio VARCHAR(255) NOT NULL,  
	Proveedor VARCHAR(255) NOT NULL,
	CONSTRAINT PK_Prestaciones_Hostal PRIMARY KEY (id)
); 

ALTER TABLE Prestaciones_Hostal
	ADD CONSTRAINT FK_servicio_Hostal FOREIGN KEY (servicio, proveedor) REFERENCES Servicio(nombre, proveedor)
ENABLE; 


CREATE TABLE Prestaciones_Empresa 
( 
	id INT,   
	servicio VARCHAR(255) NOT NULL,  
	proveedor VARCHAR(255) NOT NULL,
	CONSTRAINT PK_Prestaciones_Empresa PRIMARY KEY (id)
); 

ALTER TABLE Prestaciones_Empresa
	ADD CONSTRAINT FK_servicio_Empresa FOREIGN KEY (servicio, proveedor) REFERENCES Servicio(nombre, proveedor)
ENABLE;

COMMIT;

