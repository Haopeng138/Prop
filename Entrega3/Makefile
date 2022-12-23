
OUT = out
JFLAGS = -d
JC = javac

classes: estructura expresion logica utils persistencia interficie vistas vbusquedas vitems vventsecundaria entrega3

estructura:
	$(JC) $(JFLAGS) $(OUT) -cp src src/Dominio/Estructura/*.java

expresion:
	$(JC) $(JFLAGS) $(OUT) -cp src src/Dominio/Expresion/*.java

logica:
	$(JC) $(JFLAGS) $(OUT) -cp src src/Dominio/Logica/*.java

utils:
	$(JC) $(JFLAGS) $(OUT) -cp src src/Dominio/Utils/*.java

persistencia:
	$(JC) $(JFLAGS) $(OUT) -cp src src/Persistencia/*.java

interficie:
	$(JC) $(JFLAGS) $(OUT) -cp src src/Interficie/*.java

vistas:
	$(JC) $(JFLAGS) $(OUT) -cp src src/Interficie/vistas/*.java

vbusquedas:
	$(JC) $(JFLAGS) $(OUT) -cp src src/Interficie/vistas/Busquedas/*.java

vitems:
	$(JC) $(JFLAGS) $(OUT) -cp src src/Interficie/vistas/Items/*.java

vventsecundaria:
	$(JC) $(JFLAGS) $(OUT) -cp src src/Interficie/vistas/VentanaSecundaria/*.java

entrega3:
	$(JC) $(JFLAGS) $(OUT) -cp src src/Entrega3.java

COMPILADOS=\
	Dominio/*/*.class\
	Dominio/*.class\
	Persistencia/*.class\
	Interficie/*.class\
	Interficie/*/*/*.class\
	*.class\

all : classes
	cd $(OUT); \
	jar cvfe ../Entrega3.jar Entrega3 $(COMPILADOS)


default:all

clean:
	rm -r $(OUT)
	rm *.jar
