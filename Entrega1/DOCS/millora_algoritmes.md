# Algoritmos


## ControladorDeDominio
El controlador de dominio no tiene algoritmos por su naturaleza. Funciona como una interfaz.

## Logica

- _BusquedaPorExpresion_: *Se ha añadido la explicacion del parser y el arbol binario.*

Hemos decidido resolverlo recursivamente debido a la elegancia del codigo y simplicidad de implementarlo.

Evalua recursivament el arbol binario buscando en el indice los documentos que cumplen los predicados siguientes:

Si el nodo es de tipo OPERATOR: 
- AND -> devuelve la interseccion entre el resultado de buscar en ambos hijos. 
- OR -> devuelve la union entre el resultado de buscar en ambos hijos
- NOT -> devuelve la diferencia entre el conjunto actual de documentos y el resultado de buscar en su hijo

Si el nodo es de tipo MATCH \<text>: se devuelve los documentos de los que \<text> sea substring.

Si el nodo es de tipo CONTAIN \<[palabras*]>: se devuelve los documentos que contengan todas las \<[palabras*]>

_En pseudocodigo:_

```
buscar(bTree, libreria) -> [DocumentHeader] {
    return buscarRec(bTree, libreria.getIndice())
}
```

```
buscarRec(bTree, indice) -> [DocumentHeader] {
    switch(bTree) {
        case AND -> {
			return intersection (buscarRec(bTree.left, indice), buscarRec(bTree.right, indice))
		}
        case OR -> {
			return union (buscarRec(bTree.left, indice), buscarRec(bTree.right, indice))
		}
        case NOT -> {
			return substractFrom (indice, buscarRec(bTree.left, indice))
		}
        case MATCH text -> {
			return indice.getMatch(text)
		}
        case CONTAIN [palabras*] -> {
			return indice.getContain([palabras*])
		}
    }
}
```

- _BusquedaPorPrefijo_: *Igual que en la entrega 1*

Dado un treeMap, usamos el metodo provisto para conseguir los resultados entre dos strings. No tenia sentido implementar otro metodo.

Calcula el siguiente string que ya no cumple el prefijo dado, y devuelve todos los autores de los dados que estan entre el prefijo y este siguiente string. Se ayuda de la funcion auxiliar computeNextPrefix(prefix). Esta funcion añade 1 a prefix, consiguiendo el siguiente valor que ya no cumple el prefijo

```
buscar(autores, prefix) -> [Autor] {
	nextPrefix := computeNextPrefix(prefix)
	return autores.between(prefix, nextPrefix)
}
```
```
computeNextPrefix(prefix) -> String {
	return (prefix + 1)
}
```
- _BusquedaPorSimilitud_: *Igual que en la entrega 1*

Dado que se consigue el valor de similitud por consulta, simplemente va preguntando, y ordena para devolver los k primeros.

Coge el indice de documentos de la libreria, y para
cada uno de los documentos que no sean el documento dado, consigue su similitud. Va guardando la informacion en un array de Similitud, que funciona como cache. Finalmente ordena los documentos por similitud y devuelve los k primeros.

```
buscar(header, K, libreria) -> [DocumentHeader] {
	res := []
	for each (autor, title) in index {
		toCompare := (autor, title)
		similitud = libreria.computeSimilarity(header, toCompare)
		res.add(similitud, toCompare)
	}
    sort(res)
	return first_k(k, res)
}
```

## Libreria

El calculo de _tf-idf_ se podria implementar en la parte de logica, pero lo hemos implementado aqui por simplicidad. En un refactor seguramente lo moveriamos.

En la libreria hay muchas clases CRUD y de tipos de datos. Documentos tambien es la encargada de calcular el metodo de similitud _tf-idf_.

Documentos, aparte de la gestion CRUD de documentos, es la clase encargada de calcular los vectores para el _tf-idf_, y calcular la similitud. 
El algoritmo usado para ello es el _tf-idf_: para cada documento se tiene su _tf_ (vector de palabras), y se tiene el _contidf_ (vector de palabras de todos los documentos), asi que con el medodo generarSimilitud(indice1, indice2) se encarga de mirar en la cache si ya esta calculado y devolverlo, o si no, calcularlo con la formula del _tf-idf_:
$$
similitud = tf*idf
$$
, donde 
$$ tf = frecPalabra$$
$$idf = numDocumentos / numDocumentos \  que \  tienen \  palabra$$

Generar similitud, a partir de los dos vectores resultantes
del tf-idf, calcula la norma de cada vector, su producto escalar y devuelve el producto escalar normalizado, es decir 
$$
coseno angulo = v1*v2/(|v1||v2|)
$$.
En caso de que el contenido de un documento este repetido en todos los documentos se divide por zero y devuelve NaN, lo creemos improbable.

```
generarSimilitudEntreDocs(docIndice, docSim) -> Float {
	s1 := tf.get(docIndice)
	s2 := tf.get(docSim)
	if (frecResult(docIndice, docSim).modif) {
		return frecResult(docIndice, docSim).result
	}
	resultat := intersect(s1, s2)
	frecResult(docIndice, docSim).update(resultat)
	return resultat
}
```

## Expresiones

El controlador de expresiones es en general una clase CRUD. Pero en ella, hay el parser, que se encarga de generar el arbol binario que sera recorrido en la busqueda por expresion.

_Parser_: *Explicacion del funcionamiento añadida*

Hemos decidido generar un AST implementado como arbol binario con los nodos explicados en las estructuras de datos. Su creacion es descendiente hasta que encontramos una operacion logica (AND, OR), que entonces lo resolvemos recursivamente por elegancia y simplicidad al implementarlo.

El parser va leyendo caracteres. Si encuentra:
- '|' ('&') -> devuelve un nodo de tipo OR (AND) como raiz, pone el arbol actual como hijo izquierdo, y el resultado de parsear el resto de string en el hijo derecho.
- '!' -> devuelve un nodo de tipo NOT con el resultado de parsear el resto del string como hijo izquierdo. 
- '(' -> pone en el nodo actual el resultado de parsear el contenido hasta encontrar el siguiente ')'.
- '"' ('{') -> pone en el nodo actual un nodo MATCH (CONTAIN) con los valores que resulten de parsear el contenido hasta encontrar el siguiente '"' ('}')
- ' ' -> Ignora el espacio, y sigue parseando

_En pseudocodigo:_

```
parse(expr) -> BinaryTree<ParseNode> {
    ptr := 0
	root := new BinaryTree<ParseNode>
	currNode := root
	while ptr < len(expr) {
		c := expr.charAt(ptr)
		switch (c) {
			case '|' -> {
				return (OR_NODE, root, parse(expr.from(ptr + 1)))
			}
			case '&' -> {
				return (AND_NODE, root, parse(expr.from(ptr + 1)))
			}
			case '!' -> {
				currNode = (NOT_NODE, new BinaryTree, null)
				currNode = currNode.left
			}
			case '(' -> {
				nextPtr := findNext(expr.from(ptr + 1), ')')
				currNode = parse(expr.fromTo(ptr + 1, nextPtr))
			}
			case '{' -> {
				nextPtr := findNext(expr.from(ptr + 1), '}')
				currNode.val = (CONTAIN_NODE, getWords(ptr + 1, nextPtr))
			}
			case '"' -> {
				nextPtr := findNext(expr.from(ptr + 1), '"')
				currNode.val = (MATCH_NODE, expr.fromTo(ptr + 1, nextPtr))
			}
			case ' ' -> {
				No_op
			}
		}
	}
}