package Dominio.Utils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import Dominio.Estructura.Documento;

public class IOHelper {

    /**
     * @param documento El documento a importar
     */
    public static Documento create(File documento) throws Exception {
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

    /**
     * @param documento El documento en formato XML a importar
     */
    private static Documento createFromXML(File documento) throws Exception {
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

    /**
     * @param documento El documento en formato txt a importar
     */
    private static Documento createFromTxT(File documento) throws IOException {
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

    /**
     * @param doc  El documento a exportar
     * @param path El path al que exportarlo
     * @param name El nombre que dar al documento
     */
    public static void export(Documento doc, File path, String name) throws Exception {
        String extension = "";
        int i = name.toString().lastIndexOf('.');
        if (i > 0) {
            extension = name.toString().substring(i + 1);
        }
        if (extension.equals("txt")) {
            exportToTxT(doc, path, name);
            return;
        } else if (extension.equals("xml")) {
            exportToXML(doc, path, name);
            return;
        } else
            throw new Exception("Invalid document format");
    }

    /**
     * @param doc  El documento a exportar
     * @param path El path al que exportarlo
     * @param name El nombre que dar al documento
     */
    private static void exportToTxT(Documento doc, File path, String name) throws IOException {
        File file = new File(path, name);
        try (FileWriter myWriter = new FileWriter(file)) {
            myWriter.write(doc.getAutor() + '\n');
            myWriter.write(doc.getTitulo() + '\n');
            myWriter.write(doc.getContenido());
        }
    }

    /**
     * @param doc  El documento a exportar
     * @param path El path al que exportarlo
     * @param name El nombre que dar al documento
     */
    private static void exportToXML(Documento doc, File path, String name) throws IOException {
        File file = new File(path, name);
        try (FileWriter myWriter = new FileWriter(file)) {
            myWriter.write("<Autor>" + doc.getAutor() + "</Autor>" + '\n');
            myWriter.write("<Titulo>" + doc.getTitulo() + "<Titulo>" + '\n');
            myWriter.write("<Contenido>" + doc.getContenido() + "<Contenido>");
        }
    }
}
