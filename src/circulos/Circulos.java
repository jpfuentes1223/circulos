package circulos;

import clases.Circulo;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Circulos {

    //declaracion de datos
    private static final List<Circulo> circulos = new ArrayList<>();
    private static final double MINIMO = 0.01;

    public static void main(String[] args) {

        //instrucciones y mensajes
        
        System.out.println("Bienvenido, este es un programa que crea una lista\n"
                + "de circulos de radios aleatorios hasta que exista uno de radio\n"
                + "menor de 0.01 (sin incluirlo), podras ordenar la lista tomando\n"
                + "como base el radio de los circulos de forma ascendente o\n"
                + "descendente, podras ordenar la lista tantas veces como quieras\n"
                + "o incluso crear una lista nueva.\n\n");
        
        //inicializacion de metodos principales
        
        Circulos app = new Circulos();
        boolean bucle_general = true;
        
        
        while (bucle_general) {

            //repite el programa indefinidas veces a decisión del usuario
            app.start();
            if (entradaDato("¿Desea crear otra lista? Si: 1 / No:0 ") == 0) {
                bucle_general = false;
            }

        }

    }

    public void start() {

        //programa general*************************************************
        boolean bucle_random = true;

        //creacion de la lista
        while (bucle_random) {
            double radio_random = Math.random();
            if (radio_random < MINIMO) {
                bucle_random = false;
                continue;
            }
            var c1 = new Circulo(radio_random);
            circulos.add(c1);
        }

        //ordenar y mostrar la lista (permite ordenar repetidas veces a decision del usuario)
        boolean bucle_mostrar = true;
        while (bucle_mostrar) {
            ordena_muestra_lista();
            if (entradaDato("Desea ordenar la lisra de nuevo? Si: 1 / No: 0.") == 0) {
                bucle_mostrar = false;
            }
        }
    }

    public static void ordena_muestra_lista() {

        //ordena y muestra la lista por orden de radio de forma ascendente o descendente
        System.out.println("Ordena la lista, introduce una respuesta.");
        boolean bucle_order = true;
        while (bucle_order) {

            switch (entradaDato("Orden ascendente: 1 / Orden descendente: 0")) {
                case 1:
                    ordenar_por(Circulo.Atributo.ASC);
                    bucle_order = false;
                    break;
                case 0:
                    ordenar_por(Circulo.Atributo.DESC);
                    bucle_order = false;
                    break;
                default:
                    System.err.println("Introduce una respuesta Valida.");
            }
        }
        muestra_circulos();
    }

    public static void muestra_circulos() {

        //muestra la lista de circulos
        for (int i = 0; i < circulos.size(); i++) {
            System.out.println("Circulo numero " + (i + 1) + ": " + circulos.get(i));
        }
    }

    public static void ordenar_por(Circulo.Atributo atr) {

        //recibe un atributo para ordenar la lista de forma asc o desc
        switch (atr) {
            case ASC:
                circulos.sort(Comparator.comparing(Circulo::getRadio));
                break;
            case DESC:
                circulos.sort(Comparator.comparing(Circulo::getRadio));
                Collections.reverse(circulos);
                break;
        }
    }

    public static int entradaDato(String titulo) {

        //metodo para obtener respuesta del usuario(1/0)
        Scanner lector = new Scanner(System.in);
        int dato = 0;
        boolean bucle = true;
        while (bucle) {

            System.out.println(titulo);

            if (lector.hasNextInt()) {

                dato = lector.nextInt();
                bucle = false;
            } else {
                System.err.println("introduce un valor entero");
                lector.next();
            }
        }

        return dato;
    }

}
