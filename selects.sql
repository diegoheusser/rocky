/*Busca todos os pesquisadores*/
SELECT * FROM usuario WHERE tipousuarioid = 2;

/*Busca todos os itens*/
SELECT 
	i.itemid as id,
	i.descricao as description,
	CONCAT(g.identificador,
		s.identificador,
		c.identificador,
		p.identificador,
		i.identificador
	) as identifier
FROM 
	item as i inner join produto as p on i.produtoid = p.produtoid
	inner join classe as c on p.classeid = c.classeid 
	inner join subgrupo as s on c.subgrupoid = s.subgrupoid
	inner join grupo as g on s.grupoid = g.grupoid;

/*Busca todas as fontes*/
SELECT * FROM fonte;

/*Busca todos os controles em aberto*/
SELECT * FROM pesquisacontrole where aberto = 1;

/*Busca as ultimas pesquisa de uma determinada fonte*/
SELECT *
FROM pesquisa
WHERE 
	ano = ? 
	AND mes = ?
	AND semana = ?;
	
