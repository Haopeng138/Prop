package Dominio.Logica;

import Dominio.Estructura.Autor;
import Dominio.Estructura.Autores;
import Dominio.Estructura.Documento;
import Dominio.Estructura.Documentos;
import Dominio.Expresion.Expresion;
import Dominio.Expresion.ExpresionException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FilenameFilter;
import java.util.*;

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
                    String exp = "";
                    while (!valido){
                        try {
                            exp = scan.nextLine();
                            Expresion e = new Expresion(exp);
                            valido = true;
                        }catch (ExpresionException error){
                            System.out.println(error.getMessage());
                            System.out.println("Vuelve a introducir la expresion");
                        }
                        Set<Documento> resExp = ControladorBusqueda.buscarPorExpresion(exp);
                        for (Iterator<Documento> it = resExp.iterator(); it.hasNext(); ) {
                            Documento d = it.next();
                            System.out.println("Autor : " + d.getAutor());
                            System.out.println("Titulo : "+ d.getTitulo());
                            System.out.println("Contenido : "+ d.getContenido());
                            System.out.println();
                        }
                        System.out.println("Los documentos con la expresión " + exp);
                    }

                    break;
                case 2:
                    System.out.println("Busqueda por prefijo ");
                    System.out.println("Introduce un prefijo ");
                    String pre;
                    pre = scan.nextLine();
                    ArrayList<Autor> resAutores = new ArrayList<>();
                    TreeSet<Autor> autores = Autores.getOrderedAutores();
                    resAutores = ControladorBusqueda.buscarPorPrefijo(autores,pre);
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
                    ArrayList<Documento> resDocs = new ArrayList<>();
                    Documento d = documentos.getDocumentByAutorTitle(autor, titulo);
                    resDocs = ControladorBusqueda.buscarPorSimilitud(d, K);
                    for (int i = 0; i < resDocs.size(); ++i) {
                        String a = resDocs.get(i).getAutor();
                        String t = resDocs.get(i).getTitulo();
                        System.out.println("Autor: " + a + " con su libro " + t);
                    }
                    System.out.println("Los documentos más similiares escrito");
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
