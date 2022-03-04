package tienda.persistencia;

import java.util.ArrayList;
import java.util.List;
import tienda.entidades.Producto;

public final class ProductoDAO extends DAO{
    
    public List<Producto> mostrarProductoMasBarato() throws Exception{
        try {
            
            String sentenciaSQL = "SELECT nombre, MIN(precio) FROM producto;";
            consultas(sentenciaSQL);
            
            List<Producto> listaProductos = new ArrayList();
            
            while(resultado.next()){
                Producto producto = new Producto();
                producto.setNombre(resultado.getString(1));
                producto.setPrecio(resultado.getDouble(2));
                listaProductos.add(producto);
            }
            
            desconectarBase();
            return listaProductos;
            
        } catch (Exception e) {
            desconectarBase();
            throw e;
        }
    }
    
    public List<Producto> mostrarProductosEntrePrecio() throws Exception{
        try {
            
            String sentenciaSQL = "SELECT * FROM producto WHERE precio BETWEEN 120 AND 202;";
            consultas(sentenciaSQL);
            
            List<Producto> listaProductos = new ArrayList();
            
            while(resultado.next()){
                Producto producto = new Producto();
                producto.setCodigo(resultado.getInt(1));
                producto.setNombre(resultado.getString(2));
                producto.setPrecio(resultado.getDouble(3));
                producto.setCodigo_fabricante(resultado.getInt(4));
                listaProductos.add(producto);
            }
            
            desconectarBase();
            return listaProductos;
            
        } catch (Exception e) {
            desconectarBase();
            throw e;
        }
    }
    
    public List<Producto> mostrarNombrePrecio() throws Exception{
        try {
            
            String sentenciaSQL = "SELECT nombre, precio FROM producto;";
            consultas(sentenciaSQL);
            
            List<Producto> listaProductos = new ArrayList();
            
            while(resultado.next()){
                Producto producto = new Producto();
                producto.setNombre(resultado.getString(1));
                producto.setPrecio(resultado.getDouble(2));
                listaProductos.add(producto);
            }
            
            desconectarBase();
            return listaProductos;
            
        } catch (Exception e) {
            desconectarBase();
            throw e;
        }
    }
    
    public Producto buscarProductoPorId(int id) throws Exception{
        try {
            String sentenciaSQL = "SELECT * FROM producto WHERE codigo = " + id;
            consultas(sentenciaSQL);
            
            Producto producto = null;
            
            if(resultado.next()){
                producto = new Producto();
                producto.setCodigo(resultado.getInt(1));
                producto.setNombre(resultado.getString(2));
                producto.setPrecio(resultado.getDouble(3));
                producto.setCodigo_fabricante(resultado.getInt(4));
            }
            
            desconectarBase();
            
            return producto;
        } catch (Exception e) {
            desconectarBase();
            throw e;
        }
    }
    
    public List<Producto> mostrarProductoPorNombre(String nombre) throws Exception{
        try {
            
            String sentenciaSQL = "SELECT * FROM producto WHERE nombre LIKE '%" + nombre + "%';";
            consultas(sentenciaSQL);
            
            List<Producto> listaProductos = new ArrayList();
            
            while(resultado.next()){
                Producto producto = new Producto();
                producto.setCodigo(resultado.getInt(1));
                producto.setNombre(resultado.getString(2));
                producto.setPrecio(resultado.getDouble(3));
                producto.setCodigo_fabricante(resultado.getInt(4));
                listaProductos.add(producto);
            }
            
            desconectarBase();
            return listaProductos;
            
        } catch (Exception e) {
            desconectarBase();
            throw e;
        }
    }
    
    public List<Producto> mostrarProductos() throws Exception{
        try {
            
            String sentenciaSQL = "SELECT * FROM producto;";
            consultas(sentenciaSQL);
            
            List<Producto> listaProductos = new ArrayList();
            
            while(resultado.next()){
                Producto producto = new Producto();
                producto.setCodigo(resultado.getInt(1));
                producto.setNombre(resultado.getString(2));
                producto.setPrecio(resultado.getDouble(3));
                producto.setCodigo_fabricante(resultado.getInt(4));
                listaProductos.add(producto);
            }
            
            desconectarBase();
            return listaProductos;
            
        } catch (Exception e) {
            desconectarBase();
            throw e;
        }
    }
    
    // Este metodo modifica todo menos el codigo original del producto
    public void actualizarDatosProducto(Producto producto) throws Exception{
        try{
            if(producto == null){
                throw new Exception("Debe indicar un producto");
            }
            
            String sentenciaSQL = "UPDATE producto SET nombre = '" + producto.getNombre() + "', precio = " + producto.getPrecio() + 
                    ", codigo_fabricante = " + producto.getCodigo_fabricante() +" WHERE codigo = " + producto.getCodigo() + ";";
            
            insertarModificarEliminar(sentenciaSQL);
            
            System.out.println("*** DATOS ACTUALIZADOS CORRECTAMENTE ***");
            
        }catch(Exception ex){
            throw ex;
        }
    }
    
    
    public void insertarProducto(Producto producto) throws Exception{

        try{
            if(producto == null){
                throw new Exception("Debe indicar un producto");
            }
            
            String sentenciaSQL = "INSERT INTO producto(nombre, precio, codigo_fabricante) VALUES('" + producto.getNombre() + "', " + producto.getPrecio() + ", " +
                    producto.getCodigo_fabricante() + ");";
            
            insertarModificarEliminar(sentenciaSQL);
            
        }catch(Exception ex){
            throw ex;
        }
    }
}
