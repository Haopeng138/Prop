package Dominio.Estructura;

import java.util.Scanner;

public class Driver_Titulo {
    public static void main(String[] args) {
        System.out.println(" Driver de autor ");
        System.out.println(" --------------- ");
        int opt;
        Scanner optscan = new Scanner(System.in);
        Titulo titulo = new Titulo();
        do {
            System.out.println(" ----------------- ");
            System.out.println(" Menu ");
            System.out.println("0- Salir");
            System.out.println("1- Crear Titulo");
            System.out.println("2- Mostrar Titulo");
            System.out.println("3- Modificar Titulo");
            System.out.println(" ----------------- ");
            System.out.println("Introduce tu opción");
            Scanner scanTitulo = new Scanner(System.in);
            opt = optscan.nextInt();
            switch (opt){
                case 0:
                    break;
                case 1:
                    System.out.println("Introduce nuevo titulo");
                    titulo = new Titulo(scanTitulo.nextLine());
                    break;
                case 2:
                    if(titulo.getName()==null){
                        System.out.println("No se ha creado el titulo");
                    }else {
                        System.out.println("Titulo : "+ titulo.getName());
                    }
                    break;
                case 3:
                    if(titulo.getName()==null){
                        System.out.println("No se ha creado el titulo");
                    }else {
                        System.out.println("Introduce el nuevo titulo: ");
                        titulo.setName(scanTitulo.nextLine());
                    }
                    break;

            }

        }while (opt!=0);
    }
}
