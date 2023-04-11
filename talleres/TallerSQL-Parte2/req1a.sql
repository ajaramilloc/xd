SELECT nombreTablaFinal AS NombreTabla, COALESCE(numCol, 0) AS NumColumnas, COALESCE(numNull, 0) AS NumColsNull, COALESCE(numFK, 0) AS NumColsFKs  

FROM (((SELECT TABLE_NAME AS nombreTablaFinal, COUNT(NULLABLE) numCol 

        FROM (SELECT * 

              FROM ALL_TAB_COLUMNS 

              WHERE owner='PARRANDEROS') 

        GROUP BY TABLE_NAME) T1 

       	FULL OUTER JOIN 

       (SELECT TABLE_NAME AS nombreTabla, COALESCE(COUNT(NULLABLE), 0) as numNull 

        FROM (SELECT * 

              FROM ALL_TAB_COLUMNS 

              WHERE owner='PARRANDEROS' AND NULLABLE = 'Y') 

        GROUP BY TABLE_NAME) T2 ON T1.nombreTablaFinal=T2.nombreTabla) 

       	FULL OUTER JOIN 

       (SELECT TABLE_NAME AS nombreTabla, COUNT(*) AS numFk 

        FROM (SELECT * 

              FROM ALL_CONS_COLUMNS 

              WHERE owner='PARRANDEROS' AND CONSTRAINT_NAME LIKE 'FK%') 

        GROUP BY TABLE_NAME) T3 ON NOMBRETABLAFINAL=T3.NOMBRETABLA) 

ORDER BY NombreTabla; 