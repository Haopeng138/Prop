package Dominio.Logica;

import Dominio.Estructura.Documento;
import Dominio.Estructura.Documentos;
import Dominio.Expresion.Expresion;
import Dominio.Expresion.ExpresionException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FilenameFilter;
import java.util.Scanner;

public class Driver_busqueda {
    public static void main(String[] args) throws FileNotFoundException {
        Documentos documentos = new Documentos();
        File folder = new File("Entrega1/FONTS/E1/JuegosDePrueba/Estructura");
        File []files = listoffiles(folder,"Einput",".txt");
        iniciarDocumentos(documentos,files);
        int opt;

        do{
            System.out.println(" -------------- ");
            System.out.println(" Menu ");
            System.out.println(" 0- Salir ");
            System.out.println(" 1- Busqueda por expresion ");
            System.out.println(" 2- Busqueda por prefijo ");
            System.out.println(" 3- Busqueda por similitud ");
            System.out.println(" 4- Mostrar documentos ");
            Scanner scanopt = new Scanner(System.in);
            opt = scanopt.nextInt();
            Scanner scan = new Scanner(System.in);
            switch (opt){
                case 0:
                    break;
                case 1:
                    System.out.println("Busqueda por expresion ");
                    System.out.println("Introduce una expresion ");
                    boolean valido = false;
                    String exp;
                    while (!valido){
                        try {
                            exp = scan.nextLine();
                            Expresion e = new Expresion(exp);
                            valido = true;
                        }catch (ExpresionException error){
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
                    break;
                case 3:
                    System.out.println("Busqueda por similitud ");
                    System.out.println("Introduce el autor y titulo del documento");
                    System.out.println("Autor : ");
                    String autor = scan.nextLine();
                    System.out.println("Titulo : ");
                    String titulo = scan.nextLine();
                    break;

                case 4:
                    System.out.println("Mostrando los documentos");
                    mostrarDocumentos(documentos);
                    break;
                default:
                    System.out.println("\t Opciones inexistentes");

            }

        }while (opt!=0);

    }

    public static File [] listoffiles(File folder,String startpattern,String endpattern){
        File [] files =  folder.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.startsWith(startpattern) & name.endsWith(endpattern);
            }
        });
        return files;
    }

    public static void iniciarDocumentos(Documentos documentos , File[] files) throws FileNotFoundException {
        for (File fileEntry : files) {
            Scanner scan = new Scanner(fileEntry);
            while (scan.hasNext()){
                String autor = scan.nextLine();
                String titulo = scan.nextLine();
                String contenido = scan.nextLine();
                Documento d = new Documento(autor,titulo,contenido);
                documentos.add(d);
            }
        }
    }

    public static void mostrarDocumentos(Documentos documentos){
        for (Documento d: documentos.getDocumentos()){
            System.out.println("Autor : " + d.getAutor());
            System.out.println("Titulo : "+ d.getTitulo());
            System.out.println("Contenido : "+ d.getContenido());
        }
    }



}
