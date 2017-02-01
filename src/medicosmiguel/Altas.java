package medicosmiguel;
import Clases.*;
import com.db4o.ObjectContainer;
import java.io.*;


 // @author Miguel

public class Altas {
    
    
    public static void altas (ObjectContainer baseDatos,BufferedReader leer) throws IOException {
        
        byte op=1;
        

        while(op!=0){
            op=Menu.menuAltas(leer);
            switch(op){
                case 1:
                    altaMedico(baseDatos, leer);
                    break;
                case 2:
                    altaEnfermo(baseDatos, leer);
                    break;
                case 3:
                    altaSeguro(baseDatos, leer);
                    break;
            }
        }
        
    }
    
    public static void altaMedico (ObjectContainer baseDatos, BufferedReader leer) throws IOException {
        
        C_Medico medico;
        
        try{
            
            medico=nuevoMedico(leer);
            if(baseDatos.queryByExample(medico).isEmpty())
            {
                Asociar.asociarEnfermo(medico, baseDatos, leer);
                baseDatos.store(medico);
                baseDatos.commit();
                System.out.println("\n - Médico Registrado - \n");
            }
            else
                System.out.println("\n - Médico  ya Existente - \n");
            
        }catch(Exception e)
        {
            System.out.println("\n - Error en el alta del Médico - \n");
        }
        
    }
    
    public static void altaEnfermo (ObjectContainer baseDatos, BufferedReader leer) throws IOException {
        
        C_Enfermo enfermo;
        
        try{
            
            enfermo=nuevoEnfermo(leer);
            if(baseDatos.queryByExample(enfermo).isEmpty())
            {
                Asociar.asociarSeguro(enfermo, baseDatos, leer);
                Asociar.asociarMedico(enfermo, baseDatos, leer);
                baseDatos.store(enfermo);
                baseDatos.commit();
                System.out.println("\n - Enfermo Registrado - \n");
            }
            else
                System.out.println("\n - Enfermo  ya Existente - \n");
            
        }catch(Exception e)
        {
            System.out.println("\n - Error en el alta del Enfermo - \n");
        }
        
    }
    
    
    public static void altaSeguro (ObjectContainer baseDatos, BufferedReader leer) throws IOException {
        
        C_Seguro seguro;
        
        try{
            
            seguro=nuevoSeguro(leer);
            baseDatos.store(seguro);
            baseDatos.commit();
            System.out.println("\n - Seguro Registrado - \n");
            
        }catch(Exception e)
        {
            System.out.println("\n - Error en el alta del Seguro - \n");
        }
        
    }
    
    public static C_Medico nuevoMedico (BufferedReader leer) throws IOException {
        
        int codigo;
        String nombre, especialidad, direccion, telefono;
        
        
        System.out.println("Introducir Código del Médico");
        codigo=Integer.parseInt(leer.readLine());
        System.out.println("Introducir Nombre:");
        nombre=leer.readLine();
        System.out.println("Introducir Especialidad:");
        especialidad=leer.readLine();
        System.out.println("Introducir Dirección:");
        direccion=leer.readLine();
        System.out.println("Introducir Teléfono:");
        telefono=leer.readLine();
        
        C_Medico medico = new C_Medico(codigo, nombre, especialidad, direccion, telefono);
        
        return medico;
    }
    
    public static C_Enfermo nuevoEnfermo (BufferedReader leer) throws IOException {
        
        String dni, nombre, patologia;
        
        
        System.out.println("Introducir dni del Enfermo");
        dni=leer.readLine();
        System.out.println("Introducir Nombre:");
        nombre=leer.readLine();
        System.out.println("Introducir Patología:");
        patologia=leer.readLine();
        
        C_Enfermo enfermo = new C_Enfermo(dni, nombre, patologia);
        
        return enfermo;
    }
    
    public static C_Seguro nuevoSeguro (BufferedReader leer) throws IOException {
        
        String codigo, prestaciones;
        int precio;
        
        
        System.out.println("Introducir código del Seguro:");
        codigo=leer.readLine();
        System.out.println("Introducir Precio:");
        precio=Integer.parseInt(leer.readLine());
        System.out.println("Introducir Prestaciones:");
        prestaciones=leer.readLine();
        
        C_Seguro seguro=new C_Seguro(codigo, precio, prestaciones);
        
        return seguro;
    }
}
