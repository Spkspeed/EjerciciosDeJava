/*
 1.- Cargar todos los alumnos de BaseTest 20 File 20 y SQL 20
 2.- Borrar ListaAlumnosExcelentes y mover el mapeo a ListaAlumnos
 3.- Mapear Docente ManyToOne a Clase
 4.- Mapear Preceptor en Clase averiguar como hacerlo
 */
INSERT INTO Clase (id, nombre_Clase) VALUES
  (8, 'ClaseA'),
  (9, 'ClaseB'),
  (10, 'ClaseC');
INSERT INTO Alumno (id, nombre, apellido, nacionalidad, edad, clase_id) VALUES
  (1, 'Roberto', 'Luz', 'Argentino', 19, 8),
  (2, 'Carlos', 'Fuentes', 'Argentino', 12, 8),
  (3, 'Julio', 'Cruz', 'Argentino', 22, 8),
  (4, 'Robin', 'Soliz', 'Argentino', 19, 8),
  (5, 'Alexander', 'Luz', 'Suecia', 19, 8),
  (6, 'Carolina', 'Fuentes', 'Argentino', 12, 8),
  (7, 'Julio', 'Cruz', 'Argentino', 22, 8),
  (8, 'Carlos', 'Soliz', 'Argentino', 19, 9),
  (9, 'Antonio', 'Salieri', 'Italiano', 19, 9),
  (10, 'Carlos', 'Fuentes', 'Argentino', 28, 9),
  (11, 'Julio', 'Cruz', 'Argentino', 22, 9),
  (12, 'Edmond ', 'Dantes', 'Italiano', 25, 9),
  (13, 'Roberto', 'Luz', 'Argentino', 21, 9),
  (14, 'Carlos', 'Fuentes', 'Argentino', 12, 10),
  (15, 'Julio', 'Cruz', 'Europeo', 22, 10),
  (16, 'Robin', 'Cruz', 'Argentino', 18, 10),
  (17, 'Nadia', 'Quilmes', 'Argentina', 19, 10),
  (18, 'Marcelo', 'Tineli', 'Argentino', 12, 10),
  (19, 'Nahuel', 'Cruz', 'Argentino', 22, 10),
  (20, 'Roberto', 'Soliz', 'Argentino', 19, 10);
INSERT INTO Preceptor (id, nombre, apellido, nacionalidad) VALUES
  (5, 'Carto', 'Luz', 'Argentino'),
  (6, 'Robin', 'Hood', 'Argentino'),
  (7, 'Carlos', 'Cruz', 'Argentino');
INSERT INTO Docente (id, nombre, apellido, nacionalidad, docentes_id) VALUES
  (8, 'Carto', 'Luz', 'Argentino',8),
  (9, 'Robin', 'Hood', 'Argentino',9),
  (10, 'Carlos', 'Cruz', 'Argentino',10);