# Estructuras de datos

## ControladorDeDominio
El controlador de dominio guarda instancia de objetos y no estructuras de datos por su naturaleza. Funciona como una interfaz.

## Logica
En la parte de logica, no hay estructuras de datos, hay los algoritmos con los que trabajar con ellas.

## Libreria
_Autores_: *Se mantiene la estructura de datos usada*

Hemos elegido usar un TreeMap para mantener el orden de los autores, podria ser un ``HashMap`` entonces insertar, borrar y consultar costaria `O(1)` pero para hacer busqueda por prefijo, tendria coste lineal en autores `O(#autores)`.

Los autores se almacenan en un ``TreeMap<Autor, HashMap<Titulo, Integer>>``


Eligiendo un TreeMap: insertar, borrar y consultar es `O(log(#autores))`, pero la busqueda por prefijo se reduce tambien a `O(log(#autores))`.

El Coste espacial es lineal en autores `O(#autores)`

_Autor_: *no tiene ED*

_Titulo_: *no tiene ED*
		
_Documentos_: *Se mantienen las estructuras de datos usadas*

Inicialmente pensamos en usar un `HashMap`, con la llave siendo autor, titulo y el valor es el contenido, pero ya que usamos un indice, podemos conseguir acceder por indice con el mismo coste.

Los documentos se guardan en un ``ArrayList<Documento>``. Se busca por indice a traves de la libreria que busca el indice en autores, asi que accediendo por indice, busqueda y modificacion tienen coste `O(1)`, y insertar en un arrayList es coste amortizado `O(1)`.

El coste espacial es lineal en documentos `O(#documentos)`

_frecResult_: *se mantiene la estructura de datos usada*

Hemos decidido añadir una cache de resultados de similitud, para reducir el tiempo de queries repetidas a casi `O(1)`.

Los calculos intermedios de similitud se guardan en un ``ArrayList<ArrayList<InfoModificado>>`` llamada frecResult. Es una Matriz diagonal inferior que sirve como cache. El coste de busqueda y modificacion por indice es de `O(1)`.

Se inserta una fila de tamaño #documentos - 1 cada vez que se inserta un documento. El coste espacial (todas las parejas de documentos / 2 - # documentos), es asintoticamente `O(#documentos^2)`

_tf_: *se mantiene la estructura de datos usada*

Para calcular el _tf_, mantenemos un vector de frecuencia de palabras, ``ArrayList<HashMap<String, Double>>`` llamado tf.Cada vector de frecuencia se implementa con un HashMap, con coste de busqueda, insercion y modificacion de palabras `O(1)`.

El coste espacial es de `O(#documentos*(#numPalabras/documento))`

_contidf_: *se mantiene la estructura de datos usada*

Podria no existir, pero entonces al calcular el idf, tendriamos que recorrer todos los vectores de palabras subiendo de `O(#palabras)` a `O(#palabras*(#documentos))`

Para calcular el _idf_, mantenemos un ``HashMap<String, Double>`` llamado contidf. Es el vector de palabras de todos los documentos. Análisi equivalente a tf.


## Expresiones

_expresiones_: *se mantiene la estructura de datos usada*

Las expresiones se guardan en un ``HashMap<String, Expresion>``. Es el formato mas apropiado dado que accedemos por el alias de la expresion. 

El coste usando un HashMap para guardar expresiones, insertar, borrar y modificar es `O(1)`.

El coste espacial es lineal en expresiones `O(#expresiones)`.
		
_Expresiones_: *no tiene ED*

## Utils

El arbol binario i el parseNode se usan para mantener el resultado de parsear una expresion. Inspirados por como funciona un compilador/interpretador, que usan un lexer para pasar de string a tokens, y un parser para pasar de tokens a un AST, nosotros debido a la simplicidad de las expresiones, juntamos el lexer y el parser creando directamente el arbol binario de parseNodes.

_BinTree_: *se ha añadido explicacion*

El arbol binario es una implementacion basica. Tiene un valor _val_ de tipo generico, un arbol binario llamado _left_, que es su hijo izquierdo, y otro arbol binario llamado _right_, que es su hijo derecho.

_ParseNode_: *se ha añadido explicacion*

El tipo de datos que se usara con el arbol binario generico para el parser. Los nodos pueden ser de tipo operador (AND, OR NOT), de tipo contain (aray de string) o de tipo match (string).

_DocumentHeader_: *se mantiene la estructura de datos usada*

Se ha implementado para simplificar el flujo de datos.

Abstraccion de la llave primaria de un documento. Para buscar en la libreria, a traves de autor y titulo, se usa el DocumentHeader, que es un wrapper de estos.