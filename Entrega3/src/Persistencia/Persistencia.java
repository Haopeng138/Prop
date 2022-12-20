package Persistencia;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.Scanner;

public class Persistencia {

    /**
     * @param documentos  Los documentos a persistir
     * @param expresiones Las expresiones a persistir
     */
    public static void persist(String[][] documentos, HashMap<String, String> expresiones) throws IOException {

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
    public static HashMap<String, String> recoverExpresiones() throws FileNotFoundException {
        File exprF = new File(getDirectory(), "expresiones");
        HashMap<String, String> expresiones = new HashMap<>();

        try (Scanner reader = new Scanner(exprF)) {
            while (reader.hasNextLine()) {
                String[] expresion = reader.nextLine().trim().split("|");
                expresiones.put(expresion[0], expresion[1]);
            }
        }
        exprF.delete();

        return expresiones;
    }

    /**
     * @return Los documentos a recuperar
     */
    public static String[][] recoverDocumentos() throws IOException {
        File[] fileDocuments = getDirectory().listFiles();
        String[][] documentos = new String[fileDocuments.length][3];

        for (int i = 0; i < documentos.length; i++) {
            String[] header = fileDocuments[i].getName().trim().split("|");
            String content = Files.readString(fileDocuments[i].toPath());
            documentos[i][0] = header[0];
            documentos[i][1] = header[1];
            documentos[i][2] = content;
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
    private static void persistDocumentos(String[][] documentos, File directory) {

        for (String[] documento : documentos) {
            String autor = documento[0];
            String titulo = documento[1];
            String contenido = documento[2];
            createFile(autor, titulo, contenido, directory);
        }
    }

    /**
     * @param expresiones Las expresiones a persistir
     * @param directory   El directorio donde crear el fichero
     */
    private static void persistExpresiones(HashMap<String, String> expresiones, File directory) throws IOException {
        File f = new File(directory, "expresiones");
        try (FileWriter writer = new FileWriter(f)) {
            expresiones.forEach((alias, expresion) -> {
                try {
                    writer.write(alias + '|' + expresion + '\n');
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