
OUT = out
JFLAGS = -d
JC = javac

all: estructura expresion logica utils

estructura:
	$(JC) $(JFLAGS) $(OUT) -cp src src/Dominio/Estructura/*.java

expresion:
	$(JC) $(JFLAGS) $(OUT) -cp src src/Dominio/Expresion/*.java

logica:
	$(JC) $(JFLAGS) $(OUT) -cp src src/Dominio/Logica/*.java

utils:
	$(JC) $(JFLAGS) $(OUT) -cp src src/Dominio/Utils/*.java

default:all



clean:
	rm -r $(OUT)