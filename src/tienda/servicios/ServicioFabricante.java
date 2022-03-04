package tienda.servicios;

import java.util.List;
import java.util.Scanner;
import tienda.entidades.Fabricante;
import tienda.persistencia.FabricanteDAO;

public class ServicioFabricante {
    private Scanner input = new Scanner(System.in).useDelimiter("\n");
    private FabricanteDAO daoF = new FabricanteDAO();
    
    public void opcion7() throws Exception{
        Fabricante fabricante = new Fabricante();
        
        System.out.println("Para ingresar un fabricante debe de completar los siguientes datos"
                + " sobre el fabricante");
        
        System.out.print("Nombre del fabricante: ");
        fabricante.setNombre(input.next());
        
        System.out.println("");
        
        daoF.insertarFabricante(fabricante);
    }
    
    public void opcion9() throws Exception{
        int i = 1;
        List<Fabricante> listaF = daoF.mostrarFabricantes();
        
        for (Fabricante fabricante : listaF) {
            System.out.println("Fabricante " + i);
            i++;
            System.out.println("Codigo:" + fabricante.getCodigo() + "; Nombre: " + fabricante.getNombre() + "\n");
        }
    }
}
