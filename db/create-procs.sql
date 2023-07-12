-- Criando proc add cargo
CREATE PROCEDURE add_cargo(uuid_cargo uuid, atividade varchar(255),nome varchar(255),salario numeric(38, 2), status int4 )
LANGUAGE SQL
AS $$
INSERT INTO cargo VALUES (uuid_cargo, atividade ,nome ,salario, status);
$$;


-- Criando function para buscar cargos com salario >= parm 
CREATE OR REPLACE FUNCTION cargos_atv_sl_maior( sl numeric)
  RETURNS TABLE (nome   varchar(255)   --  OUT           
               , salarioBase numeric)  -- OUT
  LANGUAGE plpgsql AS
$func$
BEGIN
   RETURN QUERY
   SELECT c.nome
        , c.salario_base AS salarioBase                 -- column alias
   FROM  (
      SELECT c.nome, c.salario_base
      FROM   cargo c
      WHERE  c.salario_base >= sl and   c.status = 1   
      ) c
   ORDER  BY salarioBase DESC;                  
END
$func$;

-- chamando function
SELECT * FROM cargos_atv_sl_maior(2000);