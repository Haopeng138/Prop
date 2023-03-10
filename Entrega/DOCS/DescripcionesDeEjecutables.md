# Descripciones de los ejecutables:

## Ejecutable de Driver de Autor

- Objeto de la prueba: En este ejecutable incluye los siguientes casos de uso principalmente: crear un autor, mostrar el nombre del autor, modificar el nombre delautor y comprovar
  la existencia de un autor. La única clase usada es la de Autor.
- Driver usado en esta prueba es el Driver_Autor. Este driver tiene la principal función en la creación, la modificación y la comprovación de un autor.
- Solo hemos incluido el fichero Autor.java para este ejecutable.
- Usando diferentes valores para comprobar el bien funcionamiento del ejecutable. Para cada opción, al principio hemos introducido los valores que pueden causar excepción para ver
  que realmente es lo que ocurre. Y también la forma que se pueda procesar de manera correcta. Además de esto, el ejecutable se trata de prueba de caja negra, ya que no consideramos
  la lógica interna del sistema.
- En cada caso, si el nombre introducido es nulo se salta la excepción, en caso contrario, se procesa la opción elegida.
- Después de ejecutarse el ejecutable se crea un .jar del driver de Autor, seguidamente ejecutamos este driver y seguimos las instrucciones que muestra por la pantella.


## Ejecutable de Driver de Documento

- Objeto: En este ejecutable de driver de Documento usamos los casos de uso de Crear Documento, Modificar Documento (concretamente puede ser autor, título o contenido), la finalidad
  es comprobar que cumple los casos de uso. Además de usar la clase de Documento, hemos usado la de Título y Autor para que se añadiese un nuevo documento con un título y autor único,
  es decir, cada documento tendría un conjunto de autores y título distinto, aquí también se comprueba que el autor y el título ya están creados.
- Driver utilizado es el de Documento, tiene la misión de comprobar que un documento se puede añadir correctamente y modificarlo adecuadamente.
- Los ficheros utilizados son los de Autor.java, Título.java y Documento.java donde se guarda las clases Autor, Título y Documento, respectivamente. Estos ficheros son imprescidible
  para que el funcionamiento sea correcto.
- Hemos probado con un conjunto de autores y título con su contenido, modificar del documento su título, autor y contenido con valores iguales o distintos para ver que funcionen correctamente,
  el objetivo principal es ver que podemos añadir y modificar un documento sin dar ningún error esperado, por ejemplo, imprimir un documento que no existe o modificar un documento con
  mismo valores que tenían o modificar el documento sin haber creado. Aquí solo llama a otras clases que hacen las funciones que tocan sin saber como gestionarlas (caja negra).
- En cada caso, si el documento introducido no está bien formado se sale la excepción, en el contrario, se procesa la opción escogida.
- Una vez, ejecutado el ejecutable, se crea un .jar del driver de Documento, luego ejecutamos este driver y seguir las instrucciones que imprime por la pantalla.


## Ejecutable de Driver de Documentos

- Objeto: En este ejecutable de driver de Documentos usamos los casos de uso de Crear Documento, Cargar Documento, Eliminar Documento, Modificar Documento, la finalidad es comprobar que
  cumple los casos de uso. Además de utilizar la clase de Documentos, hemos usado la de Documento, donde ya contiene las clases de Autor y Título para que se pueda añadir un conjunto de
  documentos con un conjunto de autores y título único y el contenido, aquí también se comprueba que no puede tener dos documentos con el mismo autor y título.
- Driver utilizado es el de Documentos, tiene la misión de comprobar que los documentos se pueden crear, cargar, eliminar, modificar y comparar la similitud entre ellos correctamente,
  es decir, podemos gestionar los documentos con sus índices correspondientes.
- Los ficheros utilizados son los de Autor.java, Título.java, Documento.java y Documentos.java donde se guarda las clases Autor, Título, Documento y Documentos, respectivamente. Estos
  ficheros son imprescindible para que el funcionamiento sea correcto.
- Hemos probado con un conjunto de autores y títulos con su contenido, modificar de cada documento su contenido con valores iguales o distintos (modifican solo algunas palabras) para ver
  que funcionen correctamente (generar correctamente los TFs e IDFs), el objetivo principal es ver que podemos añadir, eliminar, cargar y modificar un documento sin dar ningún error
  esperado, además de esto ver que se actualizan bien los TFs e IDFs de los documentos, ya que con TF-IDF veamos la similitud entre los documentos, está entre 0 i 1, 0 significa que no
  tiene nada de similitud y 1 tiene el contenido igual. Aquí solo llama a otras clases que hacen las funciones que tocan sin saber como gestionarlas (caja negra).
- En cada caso, si el documento introducido no está bien formado se sala la excepción, en el contrario, se procesa la opción elegida.
- Una vez, ejecutado el ejecutable, se crea un .jar del driver de Documentos, luego ejecutamos este driver y seguir las instrucciones que imprime por la pantalla.

## Ejecutable de Driver de Título

- Objeto de la prueba: Los objetos que intervienen en este ejecutable son los casos de uso siguientes: crear un título, mostrar el título y modificar el título. La única clase que
  interviene es la de Titulo.
- Driver usado en esta prueba es el Driver_Titulo, cuyo función principal es crear, mostrar y modificar un título de un documento.
- El fichero necesario para este ejecutable es el Titulo.java, es el único necesario.
- Hemos probado por diferentes valores para comprobar que funcione correctamente el nuestro ejecutable, para crear y modificar un título. Esta prueba se trata de una de caja negra,
  sin consideración la lógica interior del sistema.
- Para cada opción, si el título introducido es nulo se salta la excepción, en caso contrario, se procesa correctamente la opción elegida.
- Después de ejecutarse el ejecutable se crea un .jar del driver de Título, seguidamente ejecutamos este driver y seguimos las instrucciones que muestra por la pantella.

## Ejecutable de Driver de Búsqueda

- Objeto: En este ejectuable de driver de Búsquedas usamos los casos de uso de Crear Documento, Alta expresión, Búsqueda por prefijo, Listar por similitud, Listar por expresión booleana, la finalidad
  es comprobar que cumple los casos de uso. Además de usar la clase de Controlador de Búsquedad, hemos usado la de Libreria, formado por Documentos y Autores, la de Expresión, la de búsqueda por
  prefijo, la de búsqueda por similitud, la de búsqueda por expresión, hemos utilizado casi todas las clases que tenemos del proyecto, también comprueba que se puede añadir un conjunto de documentos
  con un conjunto de autores y título único y un contenido cualquier, y se comprueba	que no puede tener dos documentos con el mismo autor y título.
- Driver utilizado es el de búsquedas, tiene la misión de comprobar que las búsquedas por prefijo, similitud o expresión booleana dan resultados correctos.
- Los ficheros utilizados son los de Autor.java, Título.java, Documento.java, Documentos.java, Autores.java, Libreria.java, Expresion.java, ControladorExpresiones.java, Parser.java, BusquedaPorExpresion.java,
  BusquedaPorPrefijo.java, BusquedaPorSimilitud.java y ControladorBusqueda.java, donde se guarda las clases Autor, Título, Documento, Documentos, Autores, Libreria (Autores + Documentos), Parser, Expresión,
  Búsqueda por Similitud, Búsqueda por Expresión, Búsqueda por prefijo. Estos ficheros son imprescindible para que el funcionamiento sea correcto. Además, tenemos un fichero de juegos de prueba, el Einput001.txt
- Hemos probado con un conjunto de documentos con contenidos similares o distintos entre ellos, la finalidad de este juego de prueba es ver que se puede hacer las búsquedas correctamente, es decir, que nos dan
  resultados favorables (como los habíamos planteado) que sigue las restricciones. Aquí solo llama a otras clases que hacen las funciones que tocan sin saber como gestionarlas (caja negra).
- En cada caso, si el documento introducido no está bien formado o la expresión booleana está incorrecta se sala la excepción, en el contrario, se procesa la opción elegida.
- Una vez, ejecutado el ejecutable, se crea un .jar del driver de Búsquedas, luego ejecutamos este driver y seguir las instrucciones que imprime por la pantalla.


## Ejecutable de test AutorTest

- Objeto de la prueba: En esta prueba solo usamos la clase de Autor.
- Solo usamos el AutorTest.java, ya que el test es sobre esta clase.
- Con igual y diferente nombres de autores para comprobar, principalmente, que no haya dos o más autores con el mismo nombre. Se trata de una prueba de caja negra, ya que no sabemos como se gestiona las funciones
  interiores del sistema.
- Para tener éxito el test de Autor es necesario que el nombre introducido no sea nulo. Si no, se lanza una excepción por la pantalla.
- La funcionalidad de este test es comprobar que todos los nombres de autores son diferentes entre ellos, es decir, un nombre de autor es único entre todos.


## Ejecutable de test AutoresTest

- Objeto:En este ejecutable, usamos la clase de Autor y Autores, ya que la clase Autor está reutilizada a la clase Autores, por tanto, es un test unitario de la clase Autores.
- Los ficheros usados son AutoresTest.java, Autor.java y Autores.java, ya que el test solo se efectúa en la clase de Autores.
- Para cada función, hemos probado algunos ejemplos para ver si se puede pasar el test, es decir, los resultados de los tests dan resultados favorables. Principalmente, es ver que no hay dos autores con el mismo
  nombre o eliminar un autor que no existe o añadir uno que ya estaba. Es una caja negra, ya que no sabe como se gestiona las funciones.
- Para tener éxito el test de Autores es necesario que los autores tengan nombres distintos.
- El funcionamiento principal del ejecutable es testear todas las funciones que hay en él para que todos se pueden pasar.


## Ejecutable de test DocumentoTest

- Objeto de la prueba: Esta prueba únicamente incluye la clase de Documento como objeto principal.
- Para el test de Documento solo es necesario el fichero DocumentoTest.java.
- Para comprobar que los códigos implementados de Documento funcionen correctamente, hemos usado diferentes valores para ver si pasa el test. También tenemos diferentes funciones para comprobar la corrección después
  de modificar el nombre del autor, el título y el contenido del documento. Es un tipo de prueba de caja negra, porque no consideramos la lógica interior del sistema.
- Para tener éxito el test, es necesario que ningún campo del documento sea nulo. Si al modificar un elemento del documento resulta que queda igual como lo tenía, el test imprime una excepción por la pantalla, indicando
  que no habido ningún cambio respecto el original. En el caso contrario, podemos decir que ha procesado correctamente la petición.
- La funcionalidad principal de este test es comprobar la corrección de la modificación del elemento de documento y de la existencia de un conjunto de palabras en el dicho documento.

## Ejecutable de test DocumentosTest

- Objeto: En este ejecutable, usamos la clase de Documento y Documentos, ya que la clase Documento está reutilizada a la clase Documentos, por tanto, es un test unitario de la clase Documentos.
- Los ficheros usados son Documento.java, Documentos.java, DocumentosTest.java, donde contiene la clase Documento, Documentos respectivamente.
- Para cada función de la Clase DocumentosTest, hemos probado con algunos ejemplos que se puedan añadir, eliminar y modificar los documentos sin saltar ninguna excepción, además también se comprueba que la similitud
  entre los documentos esté bien calculada. La finalidad de esto es tener los documentos bien creados, listos para ser eliminados o modificados o consultados, para que esto funcione bien usamos el Test para comprobarlos.
  Es una caja negra, ya que no sabe como se gestiona las funciones.
- Para tener éxito este test, cada documento debe tener un conjunto de Autor+Titulo distinto o introducir un índice de documento existente, sino se saldrían excepciones.
- El funcionamiento principal del ejecutable es testear todas las funciones que hay en él para que todos se pueden pasar.

## Ejecutable de test TituloTest

- Objeto de la prueba: En esta prueba hemos usado la clase de Título como objeto del test.
- Para este test solo hemos incluido el fichero TituloTest.java.
- Para comprobar que los códigos funcionen bien, hemos comprobado con diferentes valores de títulos con el objetivo de ver se pasa correctamente el test implementado. Esta prueba se trata de una prueba
  de caja negra, ya que no sabemos como se gestiona las funciones internas del sistema.
- Una de las condiciones para tener éxito el test es que el título no debe ser nulo.
- La funcionalidad de este test es comprobar que todos los nombres de títulos son diferentes entre ellos.


# Ejecutable de test ExpresionTest

- Objeto: En este ejecutable usamos la clase de Expresion, ya que es un test unitario de la clase Expresion.
- Los ficheros utilizados son Expresion.java y ExpresionTest.java, donde contiene la clase de Expresion.
- Para cada función de la clase ExpresionTest, testeamos que la expresión se puede añadir y modificar correctamente, es decir, no se puede introducir una expresión inválida, por ejemplo una expresión
  incorrecta o falta algunos brackets, etc. Es una caja negra, ya que no sabe como se gestiona las funciones.
- Para tener éxito el test, es necesario que la expresión sea correcta sintácticamente, en el contrario nos indicaría que no lo está.
- El funcionamiento principal del ejecutable es testear todas las funciones que hay en él para que todos se pueden pasar.


Ejecutable de test ParserTest

- Objeto: En este ejecutable usamos la clase de Expresion, ParserNode ya que es un test unitario de la clase Parser que comprueba que el árbol formado por las expresiones esté bien lógicamente y
  sintácticamente.
- Los ficheros usados son Expresion.java, ParseNode.java, BinaryTree.java, que contiene la clase de Expresion, de ParserNode y de BinaryTree, respectivamente.
- Para las funciones de este Test, tenemos que asegurar que el árbol formado por una expresión es correcta, por ejemplo, la expresión "{p1 p2 p3} & (hola adéu | (!pep))". Si no está bien formada, ya
  no podremos encontrar el resultado mediante ese árbol. Por tanto, generamos un árbol con una expresión y luego testear si el nodo se coincide con el que habíamos planteado.
  Es una caja negra, ya que no sabe como se gestiona las funciones.
- Para tener éxito el test, es necesario que el árbol esté bien formado para poder consultar sus nodos de forma correcta.
- El funcionamiento principal del ejecutable es testear todas las funciones que hay en él para que todos se pueden pasar.


## Ejecutable de test BusquedaPorExpresionTest

- Objeto: En este ejecutable utilizamos la clase de Expresion, ParserNode, DocumentHeader(Autor+Título), Libreria(Autores+Documentos) y BusquedaPorExpresion ya que estamos haciendo un test unitario
  de una búsqueda por los documentos.
- Los ficheros disponibles son Expresion.java, ParserNode.java, BinaryTree.java, Libreria.java (clase Autores y Documentos), DocumentHeader.java (clase Autor y Título) y BusquedaPorExpresion.java,
  que contiene la clase Expresion, de ParserNode, de BinaryTree, de Libreria, de DocumentHeader y de BusquedaPorExpresion, respectivamente.
- Para la función de la búsqueda, introducimos previamente unos documentos válidos, luego de eses documentos darlos una expresión para comprobar que funcionen correctamente, es decir, debe listar
  los documentos que cumplen la expresión dada (su restrición). La finalidad es encontrar aquellos documentos que cumplen las restricciones de la expresión booleana. Es una caja negra, ya que no sabe
  como se gestiona las funciones.
- Para tener el test con éxito, es necesario que los documentos y la expresión estén bien formados, además tener en cuenta de no obtener documentos que no cumplen la expresión booleana.
- El funcionamiento principal del ejecutable es testear todas las funciones que hay en él para que todos se pueden pasar.

## Ejecutable de test BusquedaPorPrefijoTest

- Objeto de la prueba: Esta prueba incluimos las clases Autor y Autores como objeto principal.
- Para este test es necesario los ficheros Autor.java, Autores.java y BusquedaPorPrefijo.java.
- Hemos introducido varios nombres de autores, algunos con ciertas similitudes de comenzar con el mismo prefijo, con el objetivo de comprobar que
  el código implementado funciona correctamente. Se trata de un tipo de prueba de caja negra, ya que no tenemos en cuenta la lógica interna del sistema.
- El test saltará la excepción si no ha encontrado todos los autores que tienen el nombre con el prefijo dado, si ha introducido un prefijo nulo
  o si ha buscado por un prefijo que no hay ningún nombre de autor que comience con ello. En el caso contrario, se procesa correctamente el código.
- La funcionalidad principal de este test es comprobar la corrección en la búsqueda de los nombres de autores por un prefijo dado.


## Ejecutable de test BusquedaPorSimilitudTest

- Objeto: En este ejecutable usamos la clase de DocumentHeader(Autor+Título), Libreria(Autores+Documentos) y BusquedaPorSimilitud porque estamos haciendo un test unitario de una búsqueda
  por los documentos, donde tiene que encontrar documentos parecidos a un cierto documento.
- Los ficheros utilizados son Libreria.java (clase Autores y Documentos), DocumentHeader.java (clase Autor y Título) y BusquedaPorSimilitud.java, que contiene la clase de Libreria, de DocumentHeader
  y de BusquedaPorSimilitud, respectivamente.
- Para la función de búsqueda por similitud, añadimos unos documentos válidos para poder calcular sus TF-IDFs, luego es simplemente escoger uno de los documentos, comparar con los otros para ver la similitud entre ellos y
  devolver los más parecidos. El objetivo principal es tener los TF-IDFs de cada palabra de cada documento bien calculado, así nos facilita mucho a la hora de consultar la similitud.
  Es una caja negra, ya que no sabe como se gestiona las funciones.
- Para tener el test con éxito, es necesario que los documentos estén bien formados y tener los TF-IDF bien calculados de cada documento para poder encontrar la similitud entre los documentos de forma
  correcta (como hemos planteado).
- El funcionamiento principal del ejecutable es testear todas las funciones que hay en él para que todos se pueden pasar.