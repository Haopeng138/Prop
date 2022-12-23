package Dominio.Utils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Scanner;

import Dominio.Estructura.Documento;

public class IOHelper {


    /**
     * Método para crear un documento
     *
     * @param documento El documento que queremos importar
     * @return el documento en forma de la clase Documento
     * @throws Exception si el formato de documento es incorrecto
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
     * Método para crear un documento de formato xml
     *
     * @param documento El documento que queremos crear
     * @return El documento en forma de la clase Documento
     * @throws Exception si falta algún campo de documento
     */
    private static Documento createFromXML(File documento) throws Exception {
        String content = Files.readString(documento.toPath());
        int startAutor = content.indexOf("<Autor>");
        int endAutor = content.indexOf("</Autor>");
        String autor = "";
        if (startAutor != -1 && endAutor != -1) {
            autor = content.substring(startAutor + 8, endAutor).trim();
        }
        int startTitulo = content.indexOf("<Titulo>");
        int endTitulo = content.indexOf("</Titulo>");
        String titulo = "";
        if (startTitulo != -1 && endTitulo != -1) {
            titulo = content.substring(startTitulo + 8, endTitulo).trim();
        }
        int startContenido = content.indexOf("<Contenido>");
        int endContenido = content.indexOf("</Contenido>");
        String contenido = "";
        if (startContenido != -1 && endContenido != -1) {
            contenido = content.substring(startContenido + 11, endContenido).trim();
        }

        if (autor == "" || titulo == "") {
            throw new Exception("There is a missing tag");
        }
        return new Documento(autor, titulo, contenido);
    }

    public static void main(String[] args) {
        try {
            createFromXML(new File("C:\\Users\\mique\\Desktop\\file.xml"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Método de crear un documento del formato txt
     *
     * @param documento El documento que queremos crear
     * @return El documento en forma de la clase Documento
     * @throws IOException si falta algún campo del documento
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

    /**
     * Método de exportar un documento en el formato de xml o txt
     *
     * @param doc   El documento que queremos exportar
     * @param path  El directori donde exportarlo
     * @param name  El nombre del fichero
     * @throws Exception si el formato es inválido
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
     * Método para exportar el documento en formato txt
     *
     * @param doc   El documento que queremos exportar
     * @param path  El directorio donde exportarlo
     * @param name  El nombre del fichero
     * @throws IOException si falta algún campo de documento
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
     * Método de exportar el documento en formato xml
     *
     * @param doc   El documento que queremos exportar
     * @param path  El directorio donde exportarlo
     * @param name  El nombre del fichero
     * @throws IOException si falta algún campo de documento
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

