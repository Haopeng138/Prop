package Dominio.Estructura;

import java.util.Scanner;

public class Driver_Autor {
    public static void main(String[] args) {
        System.out.println(" Driver de autor ");
        System.out.println(" ");
        int opt;
        Scanner optscan = new Scanner(System.in);
        Autor autor = new Autor();
        do {
            System.out.println(" ----------------- ");
            System.out.println(" Menu ");
            System.out.println("0- Salir");
            System.out.println("1- Crear Autor");
            System.out.println("2- Mostrar Autor");
            System.out.println("3- Modificar Autor");
            System.out.println("4- Comparar autor lexicograficamente");
            System.out.println(" ----------------- ");
            System.out.println("Introduce tu opción");
            Scanner scanautor = new Scanner(System.in);
            opt = optscan.nextInt();
            switch (opt) {
                case 0:
                    break;
                case 1:
                    autor = new Autor(scanautor.nextLine());
                    break;
                case 2:
                    if (autor.getName() != null) {
                        System.out.println("Autor : " + autor.getName());
                    } else {
                        System.out.println("No se ha creado el autor");
                    }
                    break;
                case 3:
                    if (autor.getName() != null) {
                        System.out.println("Introduce el nuevo nombre del autor :");
                        autor.setName(scanautor.nextLine());
                    } else {
                        System.out.println("No se ha creado el autor");
                    }
                    break;
                case 4:
                    if (autor.getName() != null) {
                        System.out.println("Introduce el nombre del autor que vas a comparar");
                        Autor autor1 = new Autor(scanautor.nextLine());
                        if (autor.compareTo(autor1) == 0) {
                            System.out.println("Son iguales");
                        } else {
                            System.out.println("Son diferentes");
                        }
                    }
                    break;

            }
        } while (opt != 0);
    }
}
