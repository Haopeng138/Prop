package Persistencia;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Scanner;

import Dominio.Estructura.Autor;
import Dominio.Estructura.Libreria;
import Dominio.Estructura.Titulo;
import Dominio.Expresion.ControladorExpresiones;
import Dominio.Expresion.ExpresionException;

public class Persistencia {

    /**
     * @param libreria     la libreria con los documentos a persistir
     * @param cExpresiones El controlador de expresiones con la expresiones a
     *                     persistir
     */
    public static void persist(Libreria libreria, ControladorExpresiones cExpresiones) throws IOException {

        File directory = getDirectory();

        persistDocumentos(libreria, directory);

        persistExpresiones(cExpresiones, directory);

    }

    /**
     * @param libreria     la libreria a la que recuperar los documentos
     * @param cExpresiones El controlador al que recuperar las expresiones
     */
    public static void recoverState(Libreria libreria, ControladorExpresiones cExpresiones)
            throws IOException {
        File directory = getDirectory();

        // it is important that expresiones are recovered first, as if it is not the
        // case, expresiones will try to be recovered as a document

        recoverExpresiones(cExpresiones, directory);

        recoverDocumentos(libreria, directory);

    }

    private static File getDirectory() {
        File directory = new File("persistence");

        if (!directory.exists()) {
            directory.mkdir();
        }
        return directory;
    }

    /**
     * @param libreria  la libreria con los documentos a persistir
     * @param directory El directorio al que crear los ficheros
     */
    private static void persistDocumentos(Libreria libreria, File directory) {
        ArrayList<Autor> autores = libreria.getAutores();
        autores.forEach(a -> libreria.getTitles(a.getName()).forEach(t -> {
            createFile(a, t, libreria, directory);
        }));
    }

    /**
     * @param a         El nombre del autor
     * @param t         El titulo
     * @param libreria  La libreria en la que buscar el documento
     * @param directory El directorio donde crear el fichero
     */
    private static void createFile(Autor a, Titulo t, Libreria libreria, File directory) {
        String autor = a.getName();
        String titulo = t.getName();
        File f = new File(directory, autor + '|' + titulo);
        try {
            f.createNewFile();
            try (FileWriter writer = new FileWriter(f)) {
                writer.write(libreria.getContent(autor, titulo));
            }
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }

    /**
     * @param cExpresiones El controlador con las expresiones
     * @param directory    El directorio donde crear el fichero
     */
    private static void persistExpresiones(ControladorExpresiones cExpresiones, File directory) throws IOException {
        File f = new File(directory, "expresiones");
        try (FileWriter writer = new FileWriter(f)) {
            cExpresiones.getExpresiones().forEach((a, e) -> {
                try {
                    writer.write(a + '|' + e.getExpresion() + '\n');
                } catch (IOException e1) {
                    throw new RuntimeException();
                }
            });
        }
    }

    /**
     * @param cExpresiones El controlador en el que recuperar las expresiones
     * @param directory    El directorio des del que recuperar las expresiones
     */
    private static void recoverExpresiones(ControladorExpresiones cExpresiones, File directory)
            throws FileNotFoundException {
        File exprF = new File(directory, "expresiones");
        try (Scanner reader = new Scanner(exprF)) {
            while (reader.hasNextLine()) {
                String[] expresion = reader.nextLine().split("|");
                try {
                    cExpresiones.add(expresion[0], expresion[1]);
                } catch (ExpresionException e) {
                    // This can't happen.
                }

            }
        }
        exprF.delete();
    }

    /**
     * @param libreria  La libreria en la que buscar el documento
     * @param directory El directorio des del que recuperar las expresiones
     */
    private static void recoverDocumentos(Libreria libreria, File directory) throws IOException {
        File[] documents = directory.listFiles();

        for (File document : documents) {
            String[] header = document.getName().split("|");
            String content = Files.readString(document.toPath());
            libreria.createDocumento(header[0], header[1], content);
            document.delete();
        }

    }
}