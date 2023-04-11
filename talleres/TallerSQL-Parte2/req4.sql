SELECT T2.table_name AS NombreTabla, T2.column_name AS NombreColumna, T2.data_type AS TipoDeDato, COALESCE(T1.constraint_name, 'NO TIENE') AS NombreRestriccion, 	T2.nullable AS PermiteNulos 

FROM( (SELECT * 

    	 FROM ALL_CONS_COLUMNS 

       WHERE owner='PARRANDEROS') T1  

            RIGHT OUTER JOIN  

       (SELECT * 

        FROM ALL_TAB_COLUMNS 

        WHERE owner='PARRANDEROS') T2 ON (T1.table_name=T2.table_name AND T1.column_name=T2.column_name) ) 

ORDER BY NombreTabla, NombreColumna, NombreRestriccion; 