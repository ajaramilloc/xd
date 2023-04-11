SELECT table_name AS NombreTabla, column_name AS NombreColsPK, data_type AS TipoDeDato 

FROM ( (SELECT * 

        FROM ALL_TAB_COLUMNS 

        WHERE owner='PARRANDEROS') 

        	NATURAL INNER JOIN 

       (SELECT * 

        FROM ALL_CONS_COLUMNS 

        WHERE owner='PARRANDEROS') ) 

WHERE constraint_name LIKE 'PK%' 

ORDER BY NombreTabla, NombreColsPK; 