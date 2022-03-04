package tienda.servicios;

import java.util.List;
import java.util.Scanner;
import tienda.entidades.Producto;
import tienda.persistencia.ProductoDAO;

public class ServicioProducto {
    private Scanner input = new Scanner(System.in).useDelimiter("\n");
    private ProductoDAO daoP = new ProductoDAO();
    
    public void opcion1() throws Exception{
        int i = 1;
        List<Producto> listaP = daoP.mostrarProductos();
        
        for (Producto producto : listaP) {
            System.out.println("Producto " + i);
            i++;
            System.out.println("Codigo:" + producto.getCodigo() + "; Nombre: " + producto.getNombre() + 
                    "; Precio: " + producto.getPrecio() + "; Codigo del fabricante: " + producto.getCodigo_fabricante() + "\n");
        }
    }
    
    public void opcion2() throws Exception{
        int i = 1;
        List<Producto> listaP = daoP.mostrarNombrePrecio();
        
        for (Producto producto : listaP) {
            System.out.println("Producto " + i);
            i++;
            System.out.println("Nombre: " + producto.getNombre() + 
                    "; Precio: " + producto.getPrecio() + "\n");
        }
    }
    
    public void opcion3() throws Exception{
        int i = 1;
        List<Producto> listaP = daoP.mostrarProductosEntrePrecio();
        
        for (Producto producto : listaP) {
            System.out.println("Producto " + i);
            i++;
            System.out.println("Codigo:" + producto.getCodigo() + "; Nombre: " + producto.getNombre() + 
                    "; Precio: " + producto.getPrecio() + "; Codigo del fabricante: " + producto.getCodigo_fabricante() + "\n");
        }
    }
    
    public void opcion4() throws Exception{
        int i = 1;
        List<Producto> listaP = daoP.mostrarProductoPorNombre("portatil");
        
        for (Producto producto : listaP) {
            System.out.println("Producto " + i);
            i++;
            System.out.println("Codigo:" + producto.getCodigo() + "; Nombre: " + producto.getNombre() + 
                    "; Precio: " + producto.getPrecio() + "; Codigo del fabricante: " + producto.getCodigo_fabricante() + "\n");
        }
    }
    
    public void opcion5() throws Exception{
        int i = 1;
        List<Producto> listaP = daoP.mostrarProductoMasBarato();
        
        for (Producto producto : listaP) {
            System.out.println("Producto " + i);
            i++;
            System.out.println("Nombre: " + producto.getNombre() + 
                    "; Precio: " + producto.getPrecio() + "\n");
        }
    }
    
    public void opcion6() throws Exception{
        Producto producto = new Producto();
        
        System.out.println("Para ingresar un producto debe de completar los siguientes datos"
                + " sobre el producto");
        
        System.out.print("Nombre del producto: ");
        producto.setNombre(input.next());
        
        System.out.println("");
        
        System.out.print("Precio del producto: ");
        producto.setPrecio(input.nextDouble());
        
        System.out.println("");
        
        System.out.print("Codigo de fabricante: ");
        producto.setCodigo_fabricante(input.nextInt());
        
        daoP.insertarProducto(producto);
                
    }
    
    public void opcion8() throws Exception{
        int id, opcion;
        boolean bandera = true;
        String pregunta;
        System.out.println("Escriba el ID del producto que se quiere modifcar");
        id = input.nextInt();
        
        Producto producto = daoP.buscarProductoPorId(id);
        
        System.out.println("\nInformacion del producto seleccionado:\n"
                + "Codigo: " + producto.getCodigo() + "; Nombre: " + producto.getNombre() + "; Precio: " + producto.getPrecio() + 
                "; Codigo del fabricante: " + producto.getCodigo_fabricante());
        
        System.out.println("\n*** EL ID DEL PRODUCTO NO ES MODIFICABLE ***");
        
        System.out.println("\n¿Qué datos desea cambiar del producto?");
        
        while(bandera){
            System.out.println("1- Nombre\n2- Precio\n3- Codigo del fabricante\n4- Aplicar cambios");
            opcion = input.nextInt();
            
            switch(opcion){
                case 1:
                    System.out.println("Nuevo nombre del producto:");
                    producto.setNombre(input.next());
                    break;
                    
                case 2:
                    System.out.println("Nuevo precio del producto:");
                    producto.setPrecio(input.nextInt());
                    break;
                    
                case 3:
                    System.out.println("Nuevo fabricante del producto:");
                    producto.setCodigo_fabricante(input.nextInt());
                    break;
                    
                case 4:
                    System.out.println("Los nuevos datos del producto son:");
                    System.out.println("Nombre: " + producto.getNombre() + "; Precio: " + producto.getPrecio() + 
                        "; Codigo del fabricante: " + producto.getCodigo_fabricante());
                    
                    System.out.println("¿Desea aplicar los cambios? [S]i o [N]o");
                    pregunta = input.next();
                    
                    if(pregunta.startsWith("S") || pregunta.startsWith("s")){
                        daoP.actualizarDatosProducto(producto);
                        bandera = false;
                    }
                    
                    break;
                default:
                    System.out.println("Opcion invalida, intente nuevamente");
            }
        }  
    }
}
