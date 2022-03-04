package tienda;

import java.util.Scanner;
import tienda.servicios.ServicioFabricante;
import tienda.servicios.ServicioProducto;

public class Main {
    
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in).useDelimiter("\n");
        ServicioProducto servicioProducto = new ServicioProducto();
        ServicioFabricante servicioFabricante = new ServicioFabricante();
        int opcion;
        boolean bandera = true;
        String pregunta;
        
        System.out.println("Bienvenido a la tienda. Por favor seleccione una opcion del menú");
        menu();
        
        while(bandera){
            System.out.print("Opcion: ");
            opcion = input.nextInt();
            switch(opcion){
                case 1:
                    System.out.println("\nEl resultado de la búsqueda es:");
                    servicioProducto.opcion1();
                    System.out.println("10 para mostrar el menú");
                    break;

                case 2:
                    System.out.println("\nEl resultado de la búsqueda es:");
                    servicioProducto.opcion2();
                    System.out.println("10 para mostrar el menú");
                    break;

                case 3:
                    System.out.println("\nEl resultado de la búsqueda es:");
                    servicioProducto.opcion3();
                    System.out.println("10 para mostrar el menú");
                    break;

                case 4:
                    System.out.println("\nEl resultado de la búsqueda es:");
                    servicioProducto.opcion4();
                    System.out.println("10 para mostrar el menú");
                    break;

                case 5:
                    System.out.println("\nEl resultado de la búsqueda es:");
                    servicioProducto.opcion5();
                    System.out.println("10 para mostrar el menú");
                    break;

                case 6:
                    System.out.println("\nSe mostrará la lista de fabricantes");
                    servicioFabricante.opcion9();
                    System.out.println("¿El fabricante del nuevo producto está en la lista de fabricnates? [S]i o [N]o");
                    pregunta = input.next();
                    
                    if(pregunta.startsWith("S") || pregunta.startsWith("s")){
                        servicioProducto.opcion6();
                        System.out.println("10 para mostrar el menú");
                    }else{
                        System.out.println("Por favor le pediremos los datos del nuevo fabricante");
                        servicioFabricante.opcion7();
                        servicioProducto.opcion6();
                        System.out.println("10 para mostrar el menú");
                    }
                    break;

                case 7:
                    servicioFabricante.opcion7();
                    System.out.println("10 para mostrar el menú");
                    break;

                case 8:
                    System.out.println("\n¿Sabe que producto va a modificar? [S]i o [N]o");
                    pregunta = input.next();
                    
                    if(pregunta.startsWith("S") || pregunta.startsWith("s")){
                        servicioProducto.opcion8();
                        System.out.println("10 para mostrar el menú");
                    }else{
                        System.out.println("Se mostrará el listado de productos");
                        servicioProducto.opcion1();
                        servicioProducto.opcion8();
                        System.out.println("10 para mostrar el menú");
                    }
                    break;

                case 9:
                    System.out.println("\nEl resultado de la búsqueda es:");
                    servicioFabricante.opcion9();
                    System.out.println("10 para mostrar el menú");
                    break;

                case 10:
                    menu();
                    break;

                case 11:
                    System.out.println("El programa se cerrara. ¡Qué tenga un buen día!");
                    bandera = false;
                    break;

                default:
                    System.out.println("Opcion incorrecta. Intente nuevamente");
            }
        }
        
    }
    
    private static void menu(){
        System.out.println("1- Mostrar el nombre de todos los productos que hay en la base de datos");
        System.out.println("2- Mostrar los nombres y los precios de todos los productos");
        System.out.println("3- Mostrar productos que tengan un precio de 120 a 202");
        System.out.println("4- Mostrar todos los productos portátiles");
        System.out.println("5- Mostrar el producto más barato");
        System.out.println("6- Ingresar un producto a la base de datos");
        System.out.println("7- Ingresar un fabricante a la base de datos");
        System.out.println("8- Editar un producto a seleccion");
        System.out.println("9- Mostrar todos los fabricantes");
        System.out.println("10- Volver a mostrar el menú");
        System.out.println("11- SALIR");
    }
    
}
