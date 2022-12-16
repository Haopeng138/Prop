
OUT = out
JFLAGS = -d
JC = javac

classes: estructura expresion logica utils

estructura:
	$(JC) $(JFLAGS) $(OUT) -cp src src/Dominio/Estructura/*.java

expresion:
	$(JC) $(JFLAGS) $(OUT) -cp src src/Dominio/Expresion/*.java

logica:
	$(JC) $(JFLAGS) $(OUT) -cp src src/Dominio/Logica/*.java

utils:
	$(JC) $(JFLAGS) $(OUT) -cp src src/Dominio/Utils/*.java

COMPILADOS=\
	Dominio/*/*.class\
	Dominio/*.class

all : classes
	cd $(OUT); \
	jar cvfe ../Driver_Autor.jar Dominio.Estructura.Driver_Autor $(COMPILADOS) | echo java -jar Driver_Autor.jar > ../Driver_Autor.sh
	cd $(OUT); \
	jar cvfe ../Driver_Titulo.jar Dominio.Estructura.Driver_Titulo $(COMPILADOS) | echo java -jar Driver_Titulo > ../Driver_Titulo.sh
	cd $(OUT); \
	jar cvfe ../Driver_Documento.jar Dominio.Estructura.Driver_Documento $(COMPILADOS) | echo java -jar Driver_Documento > ../Driver_Documento.sh
	cd $(OUT); \
	jar cvfe ../Driver_Documentos.jar Dominio.Estructura.Driver_Documentos $(COMPILADOS) | echo java -jar Driver_Documentos > ../Driver_Documentos.sh
	cd $(OUT); \
	jar cvfe ../Driver_Busqueda.jar Dominio.Logica.Driver_busqueda $(COMPILADOS) | echo java -jar Driver_Busqueda > ../Driver_Busqueda.sh


default:all

clean:
	rm -r $(OUT)
	rm *.jar
	rm *.sh