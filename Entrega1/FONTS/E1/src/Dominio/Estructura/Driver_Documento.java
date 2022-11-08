package Dominio.Estructura;

import java.util.Scanner;

public class Driver_Documento {
    public static void main(String[] args) {
        System.out.println("Driver de documento");
        System.out.println(" ");
        int opt;
        Documento documento = new Documento();

        do {
            System.out.println(" ----------------- ");
            System.out.println(" Menu ");
            System.out.println("0- Salir");
            System.out.println("1- Crear Documento");
            System.out.println("2- Obtener informaciones del documento");
            System.out.println("3- Modificar autor");
            System.out.println("4- Modificar titulo");
            System.out.println("5- Modificar contenido");
            System.out.println(" ----------------- ");
            System.out.println("Introduce tu opción");
            Scanner scanopt = new Scanner(System.in);
            opt = scanopt.nextInt();
            Scanner scan = new Scanner(System.in);
            switch (opt){
                case 0:
                    break;
                case 1:
                    String autor,titulo,contenido;
                    System.out.println(" Introduce autor , titulo y contenido del documento ");
                    System.out.println("Autor:");
                    autor = scan.nextLine();
                    System.out.println("Titulo:");
                    titulo = scan.nextLine();
                    System.out.println("Contenido:");
                    contenido = scan.nextLine();
                    documento = new Documento(autor,titulo,contenido);
                    break;
                case 2:
                    System.out.println(" Mostrando información de los documentos ");
                    System.out.println(" --------------------- ");
                    if (documento.getContenido() != null){
                        System.out.println("Autor: "+ documento.getAutor());
                        System.out.println("Titulo: " + documento.getTitulo());
                        System.out.println("Contenido: " +documento.getContenido());
                    }else {
                        System.out.println("No se ha creado el documento ");
                    }
                    break;
                case 3:
                    System.out.println(" Introduce el nuevo nombre ");
                    documento.setContenido(scan.nextLine());
                    break;
                case 4:
                    System.out.println(" Introduce el nuevo titulo ");
                    documento.setTitulo(scan.nextLine());
                    break;
                case 5:
                    System.out.println(" El contenido antiguo és :\n "+documento.getContenido());
                    documento.setContenido(scan.nextLine());
                    break;
            }
        }while (opt != 0);

    }
}
