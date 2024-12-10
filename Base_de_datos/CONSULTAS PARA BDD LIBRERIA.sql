USE libreria;

SELECT * FROM autor;

SELECT * FROM libro;

/*CONSULTAS CON JOINS DE FORMA GENERAL*/
SELECT *
FROM autor /*TABLA PAPA*/ JOIN libro /* TABLA HIJO*/ ON autor.autor_id /*CAMPO EN TABLA PAPA PARA RELACIONAR*/ = libro.fk_autor_id /*CAMPO EN TABLA HIJA PARA RELACIONAR*/;

/*CONSULTAS CON JOINS Y COLUMNAS QUE SE NECESITE ENTRE DOS TABLAS*/
SELECT 
autor.nombre,
autor.sexo,
autor.nacionalidad,
libro.idlibro,
libro.titulo,
libro.editorial
FROM autor JOIN libro ON autor.autor_id = libro.fk_autor_id;
/*WHERE autor.sexo = 'M'
AND autor.nacionalidad = 'ESPAÑOL' ;*/

/*PRUEBAS*/
