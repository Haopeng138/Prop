package Persistencia;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.Scanner;

import Dominio.Estructura.Documento;
import Dominio.Expresion.Expresion;
import Dominio.Expresion.ExpresionException;

public class Persistencia {

    /**
     * @param documentos  Los documentos a persistir
     * @param expresiones Las expresiones a persistir
     */
    public static void persist(Documento[] documentos, HashMap<String, Expresion> expresiones) throws IOException {

        File directory = getDirectory();

        persistDocumentos(documentos, directory);

        persistExpresiones(expresiones, directory);

    }

    /**
     * This method should be called before recoverDocumentos, because the file is
     * deleted at the end
     * 
     * @return Las expresiones a recuperar
     */
    public static HashMap<String, Expresion> recoverExpresiones() throws FileNotFoundException {
        File exprF = new File(getDirectory(), "expresiones");
        HashMap<String, Expresion> expresiones = new HashMap<>();

        try (Scanner reader = new Scanner(exprF)) {
            while (reader.hasNextLine()) {
                String[] expresion = reader.nextLine().trim().split("|");
                try {
                    expresiones.put(expresion[0], new Expresion(expresion[1]));
                } catch (ExpresionException e) {
                    // This can't happen, as the expressions saved must have been checked before
                }

            }
        }
        exprF.delete();

        return expresiones;
    }

    /**
     * @return Los documentos a recuperar
     */
    public static Documento[] recoverDocumentos() throws IOException {
        File[] fileDocuments = getDirectory().listFiles();
        Documento[] documentos = new Documento[fileDocuments.length];

        for (int i = 0; i < documentos.length; i++) {
            String[] header = fileDocuments[i].getName().trim().split("|");
            String content = Files.readString(fileDocuments[i].toPath());
            documentos[i] = new Documento(header[0], header[1], content);
            fileDocuments[i].delete();
        }
        return documentos;
    }

    private static File getDirectory() {
        File directory = new File("persistence");

        if (!directory.exists()) {
            directory.mkdir();
        }
        return directory;
    }

    /**
     * @param documentos Los documentos a persistir
     * @param directory  El directorio al que crear los ficheros
     */
    private static void persistDocumentos(Documento[] documentos, File directory) {
        for (Documento documento : documentos) {
            String autor = documento.getAutor();
            String titulo = documento.getTitulo();
            String contenido = documento.getContenido();
            createFile(autor, titulo, contenido, directory);
        }
    }

    /**
     * @param expresiones Las expresiones a persistir
     * @param directory   El directorio donde crear el fichero
     */
    private static void persistExpresiones(HashMap<String, Expresion> expresiones, File directory) throws IOException {
        File f = new File(directory, "expresiones");
        try (FileWriter writer = new FileWriter(f)) {
            expresiones.forEach((alias, expresion) -> {
                try {
                    writer.write(alias + '|' + expresion.getExpresion() + '\n');
                } catch (IOException e1) {
                    throw new RuntimeException();
                }
            });
        }
    }

    /**
     * @param autor     El nombre del autor
     * @param titulo    El titulo
     * @param contenido El contenido del documento
     * @param directory El directorio donde crear el fichero
     */
    private static void createFile(String autor, String titulo, String contenido, File directory) {
        File f = new File(directory, autor + '|' + titulo);
        try {
            f.createNewFile();
            try (FileWriter writer = new FileWriter(f)) {
                writer.write(contenido);
            }
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }
}