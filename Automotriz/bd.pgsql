--create database Automotriz;

-- INICIA SELECCIÓN

CREATE TABLE TRABAJADORES(
    Id_t SERIAL NOT NULL,
    Nombre character varying(254) NOT NULL,
    Direccion character varying(254) NOT NULL,
    --Empresa character varying(100) NOT NULL,
    Ventas int NOT NULL,
    CONSTRAINT PK_TRABAJADORES PRIMARY KEY (Id_t));


CREATE TABLE VEHICULOS(
    Id_vehiculo SERIAL NOT NULL,
    Nombre character varying(254) NOT NULL,
    Empresa character varying(254) NOT NULL,
    Cantidad int NOT NULL,
    CONSTRAINT PK_VEHICULOS PRIMARY KEY (Id_vehiculo));

CREATE TABLE VENTA(
    Id_venta SERIAL NOT NULL,
    Id_t int NOT NULL,
    Id_vehiculo int NOT NULL,
    Cantidad_vendidas int not null,
    CONSTRAINT PK_VENTAS PRIMARY KEY (Id_venta),
    CONSTRAINT FK_TRABAJADORES
    FOREIGN KEY(Id_t) 
	REFERENCES TRABAJADORES(Id_t),
    CONSTRAINT FK_VEHICULOS
    FOREIGN KEY(Id_vehiculo) 
	REFERENCES VEHICULOS(Id_vehiculo));

-- REGISTRAR VENTA

create function SP_ventasAlta() returns Trigger
as
$$
begin 
update TRABAJADORES set ventas = ventas+new.Cantidad_vendidas where Id_t=new.Id_t;
update VEHICULOS set Cantidad = Cantidad-new.Cantidad_vendidas where Id_vehiculo=new.Id_vehiculo;
return new;
End
$$
language plpgsql;

create trigger TR_ventasAlta after insert on VENTA
for each row
execute procedure SP_ventasAlta();



-- ELIMINAR VENTA

create function SP_ventasBaja() returns Trigger
as
$$
begin 
update TRABAJADORES set ventas = ventas-old.Cantidad_vendidas where Id_t=old.Id_t;
update VEHICULOS set Cantidad = Cantidad+old.Cantidad_vendidas where Id_vehiculo=old.Id_vehiculo;
return new;
End
$$
language plpgsql;

create trigger TR_ventasBaja after DELETE on VENTA
for each row
execute procedure SP_ventasBaja();


--DATOS DE RELLENO
INSERT INTO TRABAJADORES (Nombre, Direccion, Ventas) VALUES ('Adrian Jimenez Sanchez', 'Ayala, Mor.',0);
INSERT INTO VEHICULOS (Nombre, Empresa, Cantidad) VALUES ('SENTRA 2020', 'NISSAN',10);
INSERT INTO VENTAS (Id_t, Id_vehiculo) VALUES (1,1);






-- AQUI TERMINA LA SELECCION





--  AUXILIARES

select * from trabajadores;
select*from ventas;

drop table ventas;
drop table vehiculos;
drop table trabajadores;

--DROP TRIGGER TR_ventasBaja ON VENTAS;
--DROP FUNCTION SP_ventasBaja;
--DROP TRIGGER TR_ventasAlta ON VENTAS;
--DROP FUNCTION SP_ventasAlta;
