/*
 1.- Cargar todos los alumnos de BaseTest 20 File 20 y SQL 20
 2.- Borrar ListaAlumnosExcelentes y mover el mapeo a ListaAlumnos
 3.- Mapear Docente ManyToOne a Clase
 4.- Mapear Preceptor en Clase averiguar como hacerlo
 */
INSERT INTO Clase (id, nombre_clase) VALUES
  (8, 'ClaseA'),
  (9, 'ClaseB'),
  (10, 'ClaseC');
INSERT INTO Alumno (id, nombre, apellido, nacionalidad, edad, clase_id) VALUES
  (1, 'Roberto', 'Luz', 'Argentino', 19, 8),
  (2, 'Carlos', 'Fuentes', 'Argentino', 12, 8),
  (3, 'Julio', 'Cruz', 'Argentino', 22, 8),
  (4, 'Robin', 'Soliz', 'Argentino', 19, 8);
INSERT INTO Preceptor (id, nombre, apellido, nacionalidad) VALUES
  (5, 'Carto', 'Luz', 'Argentino'),
  (6, 'Robin', 'Hood', 'Argentino'),
  (7, 'Carlos', 'Cruz', 'Argentino');
