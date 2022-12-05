package Dominio.Utils;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Scanner;

import Dominio.Estructura.Documento;

public class DocumentoFromFile {

    public static Documento create(Path documento) throws Exception {
        String extension = "";
        int i = documento.toString().lastIndexOf('.');
        if (i > 0) {
            extension = documento.toString().substring(i + 1);
        }
        if (extension.equals("txt")) {
            return createFromTxT(documento);
        } else if (extension.equals("xml")) {
            return createFromXML(documento);
        } else
            throw new Exception("Invalid document format");

    }

    private static Documento createFromXML(Path documento) throws Exception {
        try (Scanner file = new Scanner(documento)) {
            String autor = "";
            String titulo = "";
            String contenido = "";
            Boolean autorFound = false;
            Boolean tituloFound = false;
            Boolean contenidoFound = false;
            while (file.hasNextLine()) {
                String line = file.nextLine();
                if (line.startsWith("<Autor>") && !autorFound) {
                    autorFound = true;
                    autor = getTextBetweenTags("Autor", line, file);
                } else if (line.startsWith("<Titulo>") && !tituloFound) {
                    tituloFound = true;
                    titulo = getTextBetweenTags("Titulo", line, file);
                } else if (line.startsWith("<Contenido>") && !contenidoFound) {
                    contenidoFound = true;
                    contenido = getTextBetweenTags("Contenido", line, file);
                } else
                    throw new Exception("Unrecognized tag");
            }
            if (!autorFound || !tituloFound || !contenidoFound) {
                throw new Exception("There is a missing tag");
            }
            return new Documento(autor, titulo, contenido);
        }
    }

    private static String getTextBetweenTags(String tag, String line, Scanner file) {
        int start = line.indexOf('>') + 1;
        if (line.endsWith("</" + tag + ">")) {
            int end = line.lastIndexOf('<');
            return line.substring(start, end);
        }
        String text = line.substring(start) + '\n';
        line = file.nextLine();
        while (!line.endsWith("</" + tag + ">")) {
            text += line + '\n';
            line = file.nextLine();
        }
        int end = line.lastIndexOf('<');
        text += line.substring(0, end);
        return text;
    }

    private static Documento createFromTxT(Path documento) throws IOException {
        try (Scanner file = new Scanner(documento)) {
            String autor = file.nextLine();
            String titulo = file.nextLine();
            String contenido = "";
            while (file.hasNextLine()) {
                contenido += file.nextLine() + "\n";
            }

            return new Documento(autor, titulo, contenido);
        }
    }

}
