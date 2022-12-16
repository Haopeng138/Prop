# Descripción Diagrama Inteficie

## Controlador Interficie
Solo tiene que haber una única instancia de este controlador
El controlador de interficie tiene todas las funcionalidades del controlador de dominio, además de tener el deber de inicializar el controlador de dominio y la ventana principal (FramePrincipal)

### Métodos:
- public ControladorInterficie(): Iniciar el controlador de dominio que a su vez inicia las estructuras de datos necesarios para el funcionamiento de la aplicación 

- public void iniciar(): Abrir la ventana principal(framePrincipal) , esta ventana principal será la única clase de la parte de vistas que se conectará con el controlador de interficie

- Resto de funcionalidades: Son llamadas al controlador de dominio, hacen la misma función solo que toda la parte lógica se recae en el controlador de dominio, y el controlador de interficie solo se encarga de llamarlo.

## Frame Principal:
Es la ventana principal de la aplicación donde se puede distinguir diferentes componentes pero antes explicaremos sus métodos:

### Métodos:
- public void getAlias(): Obtiene todas las alia guardadas 

- public void getDocumentos(): Obtiene todos los documentos guardados

- public void autorlist(ArrayList<String>): Dado un array de autores visualiza todo en el panel de items (se explicará más abajo que es el panel items)

- public void contentlist(String): Visualiza el "contenido" dado en el panel de items

- public void titulolist(ArrayList<String>): Dado un array de titulos visualiza todo en el panel de items

- public void documentlist(ArrayList<documentHeader>): Dado un array de documentos visualiza todo en el panel de items 

- public void salir(): Salir de la aplicación

## Componentes de frame principal:
La ventana principal tiene varios componentes:

### PanelSelectBusquedas:
#### Atributos:
- listaDeSeleccion (JCombobox): Contiene las 5 opciones de búsquedas 

#### Métodos:
- public void select(): Después de seleccionar uno, renderiza el panel de búsquedas según la opción seleccionada

### PanelDeBusquedas:
Contiene 5 clases diferentes

### ListarPorAutor:
#### Atributos:
- NombreAutor(JTextField): el nombre del autor

#### Métodos:
- public void buscar(): Renderiza el panel de items(ItemTitulo) según los titulos encontrados por el nombre de autor introducido

### ListarPorAutorYTitulo:
#### Atributos:
- NombreAutor(JTextField): el nombre del autor
- Titulo(JTextField): el nombre del título

#### Métodos:
- public void buscar(): Renderiza el panel de items(ItemContent) según un contenido de un autor y título introducido

### ListarPorPrefijo:
#### Atributos:
- NombreAutor(JTextField): el nombre del autor 

#### Métodos:
- public void buscar(): Renderiza el panel de items(ItemAutor) según los autores que tengas el mismo prefijo que lo introducido

### ListarPorExpresion:
#### Atributos:
- ListAlias(JCombobox): el conjunto de alias creadas
- Alias(JTextField): la alia nueva de una expresión nueva
- Expresion(JTextField): la nueva expresión

#### Métodos:
- public void buscar(): Renderiza el panel de items(ItemDocumento) según los documentos que cumple la expresión 

- public void guardar(): Abre una venta secundaria para asignar una alia a la expresión que hay en ese momento 

### ListarPorSimilitud():
#### Atributos: 
- Autor(JTextField): el nombre del autor de un documento
- Titulo(JTextField): el nombre del título de un documento
- K(JTextField): el número exacto de documentos más similares

#### Métodos:
- public void buscar(): Renderiza el panel de items(ItemDocumento) según los documentos que cumple que son los más similares


---

### PanelItems:
Es el contenedor donde se visualiza la información de los diferentes items

### ItemDocument:
Contiene el nombre del autor y el titulo de un documento

#### Atributos: 
- NombreAutor(JLabel): el nombre del autor
- Titulo(JLabel): el nombre del título

#### Métodos:
- public void ver(): Abre una ventana secundaria para visualizar toda la información de un documento

- public void borrar(): Elimina el documento

### ItemAutor:
Contiene el nombre del autor
#### Atributos:
- NombreAutor(JTextField): el nombre del autor

#### Métodos:
- public void verSusObras(): Renderiza el panel de items(itemTitulo) según el autor

### ItemContent:
Contiene el contenido del documento
#### Atributos:
- Contenido(JTextArea): el contendio de un documento

#### Métodos:
- public void Editar(): Modifica el contenido del documento

### ItemTitulo:
Contiene el titulo de un documento
#### Atributos:
- Titulo(JLabel): el título de un documento

#### Métodos:
- public void ver(): Abre una ventana secundaria con toda la info del documento 

- public void borrar(): Elimina el titulo(consecuentemente el documento)

### ItemAlia:
Contiene la alia con su expresión asociada 
#### Atributos: 
- Alia(JTextField): 
### public void eliminar():

Eliminar la alia con su expresión asociada

### public void modificar():
[comment]: <> (//TODO)



## ItemDocumentoCompleto:

Contiene toda la información de un documento : autor, título y contenido

### public void eliminar():

Eliminar el documento

### public void exportar():

Exportar el documento como xml y txt 

### public void guardar():

Almacenar los cambios realizados

## PanelDirectory

Contiene dos carpetas , una de todos los documentos y otra de todas las alia

### public void selectAlia():

Según la alia seleccionada renderiza el panel item(itemAlia) 

### public void selectDoc():

Según el documento seleccionado renderiza el panel item(itemDocumentoCompleto)

## Menu

Contiene dos menus diferentes

## File

### public void NuevoDocumento():

Abre una ventana secundaria para crear un documento

### public void cargar():

Carga un archivo .txt o .xml que cumple con los formatos


## Alias 

### public void AñadirAlias():


### public void ModificarAlias():


### public void EliminarAlias():


---

//TODO: 

# Ventanas secundarias

## VentanaNuevoDocumento

## VentanaDocumentoInfo

## VentanaAliaExpresion

## VentanaAñadirAlia

## VentanaEliminaAlia

## VentanaModificarAlia
