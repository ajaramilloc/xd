SELECT table_name as NombreTabla, data_type AS TipoDeDato, COUNT (*) AS NumColsTipoDato, ROUND(AVG(avg_col_len), 2) AS PromedioLongitudCol 

FROM ( (SELECT * 

        FROM ALL_TAB_COLUMNS 

        WHERE owner='PARRANDEROS') ) 

GROUP BY table_name, data_type 

ORDER BY NombreTabla, TipoDeDato, NumColsTipoDato;