SELECT column_name, 'SELECT table_name, COUNT(*) FROM  ALL_CONS_COLUMNS WHERE ' || column_name || ' = column_name GROUP BY 					     table_name;' AS sentencia 

    FROM ALL_CONS_COLUMNS 

    WHERE owner='PARRANDEROS' AND LENGTH(column_name) > 6; 