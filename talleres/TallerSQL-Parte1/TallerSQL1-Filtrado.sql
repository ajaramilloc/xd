
//INICIO PUNTO 1

SELECT nombre, n#_Bares_Presupuesto_Alto, n#_Bares_Presupuesto_Bajo
FROM (SELECT ciudad as c1, COUNT(presupuesto) n#_Bares_Presupuesto_Alto
      FROM Bares
      WHERE presupuesto = 'Alto'
      GROUP BY ciudad) T1 
        RIGHT OUTER JOIN 
     (SELECT ciudad as nombre, COUNT(presupuesto) n#_Bares_Presupuesto_Bajo
      FROM Bares
      WHERE presupuesto = 'Bajo'
      GROUP BY ciudad) T2 ON T1.c1=T2.nombre;
      
//FIN PUNTO 1


//INICIO PUNTO 2

SELECT nombre_bar, horario_bar, tipo, COUNT(*) as cantidad
FROM (SELECT Bares.nombre as nombre_bar, Frecuentan.horario as horario_bar, idx, tipo
      FROM (Bares INNER JOIN Frecuentan ON Bares.id=Frecuentan.id_Bar) 
           INNER JOIN 
           (SELECT Bebedores.id as idx, Bebedores.ciudad as ciudad_bebedor, tipo
            FROM (Bebedores INNER JOIN Gustan ON Bebedores.id=Gustan.id_Bebedor) 
                  INNER JOIN 
                 (SELECT Bebidas.id as id_bebidax, Tipo_bebida.nombre as tipo
                  FROM Bebidas INNER JOIN Tipo_bebida ON Bebidas.tipo=Tipo_bebida.id
                  WHERE Tipo_bebida.nombre = 'vino tinto') ON Gustan.id_Bebida=id_bebidax) ON Frecuentan.id_Bebedor=idx
      WHERE Bares.ciudad <> ciudad_bebedor)
GROUP BY nombre_bar, horario_bar, tipo
ORDER BY nombre_bar;

//FIN PUNTO 2


//INICIO PUNTO 3

SELECT *
FROM (SELECT id as id_Bebe, nombre as nombre_bebe, ciudad, COUNT(id)+1 as apariciones
      FROM (Bebedores INNER JOIN Gustan ON Bebedores.id= Gustan.id_Bebedor) INNER JOIN Frecuentan ON Bebedores.id=Frecuentan.id_Bebedor
      GROUP BY id, nombre, ciudad
      ORDER BY apariciones DESC, ciudad ASC)
WHERE ROWNUM <= 10;

//FIN PUNTO 3


//INICIO PUNTO 4

SELECT *
FROM (SELECT Bares.ciudad, COUNT(*) as cantBares
      FROM (((SELECT Bebidas.id as id_dBebida
              FROM Bebidas INNER JOIN Tipo_Bebida ON Bebidas.tipo=Tipo_Bebida.id
              WHERE Tipo_Bebida.nombre='vino tinto' AND (Bebidas.grado_alcohol>=8 AND Bebidas.grado_alcohol<=12)
              ORDER BY Bebidas.id)
                 INNER JOIN Sirven ON id_dBebida=Sirven.id_bebida) INNER JOIN Bares ON Bares.id=Sirven.id_Bar)
      GROUP BY Bares.ciudad
      ORDER BY cantBares DESC)
WHERE ROWNUM = 1;
        
//FIN PUNTO 4



//INICIO PUNTO 5

SELECT B.id, B.Nombre, TB.nombre, COUNT(G.Id_bebida) as NumGustos   

FROM Bebidas B, Gustan G, Frecuentan V, Bares Ba, Bebedores Br, Tipo_Bebida TB   

WHERE B.id = G.id_Bebida   

    AND G.id_Bebedor = V.id_Bebedor   

    AND V.id_Bar = Ba.Id   

    AND V.id_Bebedor = Br.Id   

    AND B.Tipo = TB.Id   

    AND Br.Ciudad != Ba.Ciudad   

    AND B.Grado_Alcohol > 0  

GROUP BY B.id, B.Nombre, TB.nombre   

ORDER BY NumGustos DESC   

FETCH FIRST 10 ROWS ONLY; 

//FIN PUNTO 5



//INICIO PUNTO 6

SELECT bares.Ciudad, bares.Nombre AS NombreBar, COUNT(sirven.id_Bebida) AS NumBebidas 

FROM Bares, Sirven, Bebidas 

WHERE bares.Id = sirven.id_Bar AND sirven.id_Bebida = bebidas.Id 

AND bares.Presupuesto = 'Alto' 

AND bebidas.Grado_Alcohol > 10 

GROUP BY bares.Ciudad, bares.Nombre 

HAVING COUNT(sirven.id_Bebida) BETWEEN 5 AND 10 

ORDER BY bares.Ciudad, bares.Nombre, NumBebidas; 

//FIN PUNTO 6


