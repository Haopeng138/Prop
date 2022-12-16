# Descripción

## Miembros:

Puig Turon Miquel

Hang Yao

Lin Haopeng

Lu Xin

## Mails:

haopeng.lin@estudiantat.upc.edu

xin.lu@estudiantat.upc.edu

@estudiantat.upc.edu

nombre@estudiantat.upc.edu

---

# DESCRIPCIONES DE EJECUTABLES:

## EJECUTABLE DE AUTOR:

Objeto de la prueba:
  En este ejecutable incluye los siguientes casos de uso principalmente: crear un autor, mostrar el nombre del autor, modificar el nombre del
  autor y comprovar la existencia de un autor.
  Clase: Autor.

- Driver:
  Nombre: Driver_Autor.
  Descripción: Este driver tiene la principal función en la creación, la modificación y la comprovación de un autor.

- Ficheros de datos necesarios:
  Sólo hemos incluido el fichero Autor.java para este ejecutable.

- Valores estudiados:
  Usando diferentes valores para comprovar el bien funcionamiento del ejecutable. Para cada opción, al principio hemos introducido
  los valores que pueden causar excepción para ver que realmente es lo que ocurre. Y también la forma que se pueda procesar de
  manera correcta. Además de esto, el ejecutable se trata de prueba de caja negra, ya que no consideramos la lógica interna del sistema.

- Efectos estudiados:
  En cada caso, si el nombre introducido es nulo se salta la excepción, en caso contrario, se procesa la opción elegida.

- Operativa:
  Después de ejecutarse el ejecutable se crea un .jar del driver de Autor, seguidamente ejecutamos este driver y seguimos las instrucciones
  que muestra por la pantella.


## EJECUTABLE DE TÍTULO:

- Objeto de la prueba:
  Los objetos que intervienen en este ejecutable son los casos de uso siguientes: crear un título, mostrar el título y modificar el título.
  Clase: Titulo.

- Driver:
  Nombre: Driver_Titulo.
  Descripción: Función princial de crear, mostrar y modificar un título de un documento.

- Ficheros de datos necesarios:
  El fichero necesario para este ejecutable es el Titulo.java, es el único necesario.

- Valores estudiados:
  Hemos probado por diferentes valores para comprobar que funcione correctamente el nuestro ejecutable, para crear y modificar un título.
  Esta prueba se trata de una de caja negra, sin consideración la lógica interior del sistema.

- Efectos estudiados:
  Para cada opción, si el título introducido es nulo se salta la excepción, en caso contrario, se procesa correctamente la opción elegida.

- Operativa:
  Después de ejecutarse el ejecutable se crea un .jar del driver de Título, seguidamente ejecutamos este driver y seguimos las instrucciones
  que muestra por la pantella.


---

# DESCRIPCIONES DE EJECUTABLES TEST:

## EJECUTABLE DE AUTOR_TEST:

- Objeto de la prueba:
  En esta prueba solo usamos la clase de Autor.

- Ficheros de datos necesarios:
  Solo usamos el AutorTest.java ya que el test es sobre esta clase.

- Valores estudiados:
  Con igual y diferente nombre de autores para comprobar, principalmente, que no haya dos o más autores con el mismo nombre. Se trata de una
  prueba de caja negra, ya que no sabemos como se gestiona las funciones interiores del sistema.

- Efectos estudiados:
  Para tener éxito el test de Autor es necesario que el nombre introducido no sea nulo. Si no, se lanza una excepción por la pantalla.

- Operativa:
  La funcionalidad de este test es comprobar que todos los nombres de autores son diferentes entre ellos, es decir, un nombre de autor
  es único entre todos.


## EJECUTABLE DE DOCUMENTO_TEST:

- Objeto de la prueba:
  Esta prueba únicamente incluye la clase de Documento como objeto principal.

- Ficheros de datos necesarios:
  Para el test de Documento solo es necesario el fichero DocumentoTest.java.

- Valores estudiados:
  Para comprobar que los códigos implementados de Documento funcionen correctamente, hemos usado diferentes valores para ver si pasa el test.
  También tenemos diferentes funciones para comprobar la correctesa despúes de modificar el nombre del autor, el título y el contenido del
  documento. Es un tipo de prueba de caja negra, porque no consideramos la lógica interior del sistema.

- Efectos estudiados:
  Para tener éxito el test, es necesario que ningun campo del documento sea nulo.
  Si al modificar un elemento del documento resulta que queda igual como lo tenia, el test imprime una excepción por la pantalla, indicando
  que no habido ningun cambio respecto el original. En el caso contrario, podemos decir que ha procesado correctamente la petición.

- Operativa:
  La funcionalidad principal de este test es comprobar la correctesa de la modificación del elemento de documento y de la existencia de un conjunto
  de palabra en el dicho documento.


## EJECUTABLE DE TITULO_TEST:

- Objeto de la prueba:
  En esta prueba hemos usado la clase de Título como objeto del test.

- Ficheros de datos necesarios:
  Para este test solo hemos incluido el fichero TituloTest.java.

- Valores estudiados:
  Para comprobar que los códigos funcionen bien, hemos comprovado con diferentes valores de títulos con el objetivo de ver se pasa correctamente
  el test implementado. Esta prueba se trata de una prueba de caja negra, ya que no sabemos como se gestiona las funciones internas del sistema.

- Efectos estudiados:
  Una de las condiciones para tener éxito el test es que el título no debe ser nulo.

- Operativa:
  La funcionalidad de este test es comprobar que todos los nombres de títulos son diferentes entre ellos.


## EJECUTABLE DE BUSQUEDA_POR_PREFIJO_TEST:

- Objeto de la prueba:
  Esta prueba incluimos las clases Autor y Autores como objeto principal.

- Ficheros de datos necesarios:
  Para este test es necesario los ficheros Autor.java, Autores.java y BusquedaPorPrefijo.java.

- Valores estudiados:
  Hemos introducido varios nombres de autores, algunos con ciertas similitud de comenzar con el mismo prefijo, con el objetivo de comprobar que
  el código implementado funciona correctamente. Se trata de un tipo de prueba de caja negra, ya que no tenemos en cuenta la lógica interna del
  sistema.

- Efectos estudiados:
  El test saltará la excepción si no ha encontrado todos los autores que tienen el nombre con el prefijo dado, si ha introducido un prefijo nulo
  o si ha buscado por un prefijo que no hay ningun nombre de autor que comience con ello. En el caso contrario, se procesa correctamente el código.

- Operativa:
  La funcionalidad principal de este test es comprobar la correctesa en la búsqueda de los nombres de autores por un prefijo dado.