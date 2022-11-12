# Casos de usos

---
## Crear Documento
### Actor: Usuario
### Comportamiento:
    1. El usuario introduce el auto,título y contenido
    2. El sistema crea el documento correspondiente
### Errores:
    1. Ya existe un documento con la misma pareja, autor y título
    2. Si falta alguno de los tres campos el sistema informa del error
### Cursos alternativos:
    1. Se informa de la existencia de un documento con la pareja: autor y título. Y no deja crear el documento
    2. Se informa de la falta del campo para que el usuario lo complete

---
## Cargar Documento
### Actor: Usuario
### Comportamiento:
    1. El usuario selecciona un documento
    2. El sistema importa el documento correspondiente
### Errores:
    1. Ya existe un documento con la misma pareja:autor y título
    2. No se puede leer el documento debido a que el formato no es aceptado
### Cursos alternativos:
    1. Se informa de la existencia de un documento con la pareja: título, autor, y no deja importar el documento
    2. Se informa que el formato del documento no está aceptado, y no deja importar el documento

---
## Eliminar Documento
### Actor: Usuario
### Comportamiento:
    1. El usuario indica el documento a eliminar
    2. El sistema borra el documento correspondiente

---
## Guardar Documento
### Actor: Usuario

---
## Modificar Documento
### Actor:Usuario
### Comportamiento:
    1. El usuario modifica el documento
### Error:
    1- No se ha guardado el documento y se ha cerrado el programa
### CURSOS ALTERNATIVOS:
    1. No se guarda el documento y se queda en el último fecha de modificación

---
## Búsqueda por autor
### Actor:Usuario
### Comportamiento:
    1. El usuario elige el nombre de un autor
    2. El sistema devuelve una lista de títulos

---
## Búsqueda por prefijo
### Actor: Usuario
### Comportamiento:
    1. El usuario informa un prefijo, que puede ser nulo
    2. El sistema devuelve una lista que tienn el mismo prefijo y los lista
### Errores
    1. El prefijo está sintacticamente incorrecto 
### Cursos alternativo:
    1. El sistema informa del error y no devuelve nada
---
## Búsqueda por autor y título
### Actor: Usuario
### Comportamiento:
    1. El usuario informa un autor y un título
    2. El sistema devuelve el documento con el título y autot indicado
### Errores:
    1a. No existe el autor
    1b. No existe el título
### Cursos alternativos:
    1. El sistema informa del error y no devuelve nada
---
## Listar por similitud
### Actor: Usuario
### Comportamiento: 
    1. El usuario informa un documento(D) y un número (K)
    2. El sistema devuelve los K documentos más parecidos al documento D
### Errores: 
    1. El número K es superior a los números de documentos que hay al sistema
### Cursos alternativos:
    1. El sistema informa del error Crea

---
## Listar por expresión booleana
### Actor: Usuario
### Comportamiento:
    1. El usuario informa de la expresión booleana
    2. El sistema valida los valores y devuelve una lista de autores de los documentos que satisfacen la condición booleana
### Errores:
    1. Si la expresión está sintácticamente incorrecta
### Cursos alternativos:
    1. El sistema informa del error 

---
## Alta expresión
### Autor: Usuario
### Comportamiento:
    1. El usuario informa de la expresión booleana y le asigna una alia
    2. El sistema valida los valores y dar de alta la expresión booleana indicada el usuario
### Errores:
    2a. La expresión está sintácticamente incorrecta
    2b. Ya existe la expresión 
### Cursos alternativos:
    2a. El sistema informa del error
    2b. El sistema informa del error 

---
## Baja expresión
### Actor: Usuario
### Comportamiento:
    1. El usuario informa de la expresión booleana
    2. El sistema valida los valores y dar de baja la expresión indicada por usuario

---
## Modificación expresión
### Actor: Usuario
### Comportamiento:
    1. El usuario informa de la alia de la expresión booleana que quiere modificar 
    2. EL sistema encuentra la expresión a modificar
    3. El usuario introduce la expresión modificada
    4. El sistema valida los valore modificados y guarda la expresión
### Errores:
    4. La expresión está sintácticamente incorrecta
### Cursos alternativos:
    4 El sistema informa del error, y no se modifica la expresion
