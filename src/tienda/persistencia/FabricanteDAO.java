package tienda.persistencia;

import java.util.ArrayList;
import java.util.List;
import tienda.entidades.Fabricante;

public final class FabricanteDAO extends DAO{
    
    public List<Fabricante> mostrarFabricantes() throws Exception{
        try {
            
            String sentenciaSQL = "SELECT * FROM fabricante;";
            consultas(sentenciaSQL);
            
            List<Fabricante> listaFabricantes = new ArrayList();
            
            while(resultado.next()){
                Fabricante fabricante = new Fabricante();
                fabricante.setCodigo(resultado.getInt(1));
                fabricante.setNombre(resultado.getString(2));
                listaFabricantes.add(fabricante);
            }
            
            desconectarBase();
            return listaFabricantes;
            
        } catch (Exception e) {
            desconectarBase();
            throw e;
        }
    }
    
    // Este metodo modifica todo menos el codigo original del fabricante
    public void actualizarDatosFabricante(Fabricante fabricante) throws Exception{
        try{
            if(fabricante == null){
                throw new Exception("Debe indicar un fabricante");
            }
            
            String sentenciaSQL = "UPDATE fabricante SET nombre = '" + fabricante.getNombre() + "' WHERE codigo = " 
                    + fabricante.getCodigo() + ";";
            
            insertarModificarEliminar(sentenciaSQL);
            
        }catch(Exception ex){
            throw ex;
        }
    }
    
    public void insertarFabricante(Fabricante fabricante) throws Exception{
        try{
            if(fabricante == null){
                throw new Exception("Debe indicar un fabricante");
            }
            
            String sentenciaSQL = "INSERT INTO fabricante(nombre) VALUES('" + fabricante.getNombre() + "');";
            
            insertarModificarEliminar(sentenciaSQL);
            
        }catch(Exception ex){
            throw ex;
        }
    }
}
