package Dominio.Logica;

import Dominio.ControladorDominio;
import Dominio.Estructura.*;
import Dominio.Expresion.ExpresionException;
import Dominio.Utils.DocumentHeader;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FilenameFilter;
import java.util.*;

public class Driver_busqueda {
    static ControladorDominio dominio = new ControladorDominio();

    public static void main(String[] args) throws FileNotFoundException {
        File folder = new File("../../../Entrega1/FONTS/E1/JuegosDePrueba/Estructura");

        /*String basedir = System.getProperties().get("user.dir").toString();
        File folder = new File(basedir + "/Entrega1/FONTS/E1/JuegosDePrueba/Estructura");
        System.out.println(folder.getAbsolutePath());*/
        //System.out.println("Primero :"+folder.getAbsolutePath());
        File[] files = listoffiles(folder, "Einput001", ".txt");
        iniciarDocumentos(files);
        if (files == null){
            folder = new File("./");
            files = listoffiles(folder, "Einput001", ".txt");
            //System.out.println("Segundo :"+folder.getAbsolutePath());
            iniciarDocumentos(files);
        }


        int opt;
        do {
            System.out.println(" -------------- ");
            System.out.println(" Menu ");
            System.out.println(" 0- Salir ");
            System.out.println(" 1- Busqueda por expresion ");
            System.out.println(" 2- Busqueda por prefijo ");
            System.out.println(" 3- Busqueda por similitud ");
            Scanner scanopt = new Scanner(System.in);
            opt = scanopt.nextInt();
            Scanner scan = new Scanner(System.in);
            switch (opt) {
                case 0:
                    break;
                case 1:
                    System.out.println("Busqueda por expresion ");
                    String alias;
                    System.out.println("Introduce tu alias");
                    alias = scan.nextLine();
                    System.out.println("Introduce una expresion ");
                    boolean valido = false;
                    String exp;
                    while (!valido) {
                        try {
                            exp = scan.nextLine();
                            dominio.addExpresion(alias, exp);
                            valido = true;
                            ArrayList<String[]> resExp = dominio.busquedaPorExpresion(alias);
                            for (int i = 0; i < resExp.size(); ++i) {
                                // TODO review
                                /*DocumentHeader d = resExp.get(i);
                                System.out.println("Autor : " + d.getAutor());
                                System.out.println("Titulo : " + d.getTitulo());*/
                                System.out.println();
                            }
                            System.out.println("Los documentos con la expresión " + exp);
                        } catch (ExpresionException error) {
                            System.out.println(error.getMessage());
                            System.out.println("Vuelve a introducir la expresion");
                        }
                    }
                    break;
                case 2:

                    System.out.println("Busqueda por prefijo ");
                    System.out.println("Introduce un prefijo ");
                    String pre;
                    pre = scan.nextLine();
                    ArrayList<String> resAutores = dominio.obtenerAutoresPrefijo(pre);
                    for (int i = 0; i < resAutores.size(); ++i) {
                        String autor = String.valueOf(resAutores.get(i));
                        System.out.println(autor);
                    }
                    System.out.println("Los autores con el mismo prefijo");
                    break;

                case 3:
                    System.out.println("Busqueda por similitud ");
                    System.out.println("Introduce el autor y titulo del documento");
                    System.out.println("Autor : ");
                    String autor = scan.nextLine();
                    System.out.println("Titulo : ");
                    String titulo = scan.nextLine();
                    System.out.println("La K : ");
                    int K = Integer.parseInt(scan.nextLine());
                    ArrayList<String[]> resDocs = dominio.busquedaPorSimilitud(autor, titulo, K);
                    for (int i = 0; i < resDocs.size(); ++i) {
                        String a = resDocs.get(i)[0];
                        String t = resDocs.get(i)[1];
                        System.out.println("Autor: " + a + " con su libro " + t);
                    }
                    System.out.println("Los documentos más similiares escrito");
                    break;
                default:
                    System.out.println("\t Opciones inexistentes");

            }

        } while (opt != 0);

    }

    public static File[] listoffiles(File folder, String startpattern, String endpattern) {
        File[] files = folder.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.startsWith(startpattern) & name.endsWith(endpattern);
            }
        });
        return files;
    }

    public static void iniciarDocumentos(File[] files) throws FileNotFoundException {
        try{
            for (File fileEntry : files) {
                Scanner scan = new Scanner(fileEntry);
                while (scan.hasNext()) {
                    String autor = scan.nextLine();
                    String titulo = scan.nextLine();
                    String contenido = scan.nextLine();
                    dominio.createDocumento(autor, titulo, contenido);
                }
            }
        }catch (Exception ignored){
            //System.out.println("Pasando ");
        }

    }

}
