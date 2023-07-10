/* Criando proc add cargo*/
CREATE PROCEDURE add_cargo(uuid_cargo uuid, atividade varchar(255),nome varchar(255),salario numeric(38, 2), status int4 )
LANGUAGE SQL
AS $$
INSERT INTO cargo VALUES (uuid_cargo, atividade ,nome ,salario, status);
$$;