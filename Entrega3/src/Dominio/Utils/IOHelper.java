package Dominio.Utils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
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
            // TODO Auto-generated catch block
            e.printStackTrace();
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
