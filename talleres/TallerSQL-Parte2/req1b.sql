SELECT t.TABLE_NAME AS NombreTabla,  

       (SELECT COUNT(*) FROM ALL_TAB_COLUMNS WHERE OWNER='PARRANDEROS' AND TABLE_NAME = t.TABLE_NAME) AS NumColumnas,  

       (SELECT COUNT(*) FROM ALL_TAB_COLUMNS WHERE OWNER='PARRANDEROS' AND TABLE_NAME = t.TABLE_NAME AND NULLABLE = 'Y') AS NumColsNull,  

       (SELECT COUNT(*) FROM ALL_CONS_COLUMNS WHERE OWNER='PARRANDEROS' AND CONSTRAINT_NAME LIKE 'FK%' AND TABLE_NAME = t.TABLE_NAME) AS NumColsFKs  

FROM ALL_TABLES t  

WHERE t.OWNER='PARRANDEROS'  

ORDER BY NombreTabla; 