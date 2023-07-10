sELECT *  FROM unid_trabalho ut ORDER BY random() LIMIT 5000000000000


SELECT sum(pg_column_size(t.*)) as filesize, count(*) as filerow FROM funcionario as t;

select f.nome, f.cpf, f.salario, f.dt_contratacao  from funcionario f 