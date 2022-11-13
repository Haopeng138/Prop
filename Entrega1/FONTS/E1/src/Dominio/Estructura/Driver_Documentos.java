package Dominio.Estructura;

import java.util.Scanner;

public class Driver_Documentos {
    public static void main(String[] args) {
        Documentos documentos = new Documentos();
        System.out.println("Driver Documentos");
        System.out.println(" ");
        int opt;
        String autor, titulo, contenido;
        do {
            System.out.println(" ----------------- ");
            System.out.println(" Menu ");
            System.out.println("0- Salir");
            System.out.println("1- Añadir Documento");
            System.out.println("2- Cargar Docuemento");
            System.out.println("3- Eliminar Documento");
            System.out.println("4- Modificar Documento");
            System.out.println("5- Mostrar Documento");
            System.out.println(" ----------------- ");
            System.out.println("Introduce tu opción");
            Scanner scanopt = new Scanner(System.in);
            opt = scanopt.nextInt();
            Scanner scan = new Scanner(System.in);
            switch (opt) {
                case 0:
                    break;
                case 1:
                    System.out.println(" Introduce autor , titulo y contenido del documento ");
                    System.out.println("Autor:");
                    autor = scan.nextLine();
                    System.out.println("Titulo:");
                    titulo = scan.nextLine();
                    System.out.println("Contenido:");
                    contenido = scan.nextLine();
                    Documento d = new Documento(autor, titulo, contenido);
                    documentos.add(d);
                    System.out.println("Documento creado ");
                    break;
                case 2:
                    System.out.println(" Selecciona el fichero // Funcionalidad en construcción");
                    break;
                case 3:
                    System.out.println(" Introduce el auto y titulo del documento que quieres eliminar");
                    System.out.println("Autor: ");
                    autor = scan.nextLine();
                    System.out.println("Titulo: ");
                    titulo = scan.nextLine();
                    /* documentos.removeByAutorTitle(autor,titulo); */

                    break;
                case 4:
                    System.out.println("Introduce el autor y titulo del documento que quieres modificar ");
                    System.out.println("Autor :");
                    autor = scan.nextLine();
                    System.out.println("Titulo :");
                    titulo = scan.nextLine();
                    // todo revisar la función getContentByAutorTitle(autor,titulo)
                    /*
                     * System.out.println("Contenido original : "+
                     * documentos.getContentByAutorTitle(autor,titulo));
                     */
                    System.out.println("");
                    System.out.println("Escriba su nuevo contenido :");
                    contenido = scan.nextLine();
                    /* documentos.modifyContent(autor,titulo,contenido); */
                    break;
                case 5:
                    System.out.println(" Mostrando los documentos");
                    /*
                     * ArrayList<Documento> listdoc = documentos.getDocumentos();
                     * for(Documento dc : listdoc){
                     * System.out.println(" --------------------- ");
                     * System.out.println("Autor: "+ dc.getAutor());
                     * System.out.println("Titulo: " + dc.getTitulo());
                     * System.out.println("Contenido: " +dc.getContenido());
                     * }
                     */
                    break;
                default:
                    System.err.println("\t Opción inexistente");
                    break;
            }
        } while (opt != 0);
    }
}
