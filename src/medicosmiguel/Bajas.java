package medicosmiguel;
import Clases.*;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import java.io.*;


 // @author Miguel

public class Bajas {
    
    
    public static void bajas (ObjectContainer baseDatos,BufferedReader leer) throws IOException {
        
        byte op=1;
        
        while(op!=0){
            op=Menu.menuBajas(leer);
            switch(op){
                case 1:
                    bajaMedico(baseDatos, leer);
                    break;
                case 2:
                    bajaEnfermo(baseDatos, leer);
                    break;
                case 3:
                    bajaSeguro(baseDatos, leer);
                    break;
            }
        }
    }
    
    public static void bajaMedico (ObjectContainer baseDatos, BufferedReader leer) throws IOException {
        
        ObjectSet resultado;
        C_Medico medico;
        int codigo;
        

        System.out.println("Introducir código del Médico a eliminar:");
        codigo=Integer.parseInt(leer.readLine());
        resultado=baseDatos.queryByExample(new C_Medico (codigo, null, null, null, null));

        if(!resultado.isEmpty())
        {
            medico=(C_Medico)resultado.next();
            if(Menu.menuConfirmar(leer)==1)
            {
                baseDatos.delete(medico);
                System.out.println("\n - Médico Eliminado - \n");
            }
        }
        else
            System.out.println("\n Médico no encontrado \n");
        
    }
    
    public static void bajaEnfermo (ObjectContainer baseDatos, BufferedReader leer) throws IOException {
        
        ObjectSet resultado;
        C_Enfermo enfermo;
        String dni;
        
        
        System.out.println("Introducir DNI del Enfermo a eliminar:");
        dni=leer.readLine();
        resultado=baseDatos.queryByExample(new C_Enfermo (dni, null, null));

        if(!resultado.isEmpty())
        {
            enfermo=(C_Enfermo)resultado.next();
            if(Menu.menuConfirmar(leer)==1)
            {
                baseDatos.delete(enfermo);
                limpiarMedico(baseDatos, enfermo);
                baseDatos.commit();
                System.out.println("\n - Enfermo Eliminado - \n");
            }
        }
        else
            System.out.println("\n Enfermo no encontrado \n");
        
    }
    
    public static void bajaSeguro (ObjectContainer baseDatos, BufferedReader leer) throws IOException {
        
        ObjectSet resultado;
        C_Seguro seguro;
        String codigo;
        
        
        System.out.println("Introducir código del seguro a eliminar:");
        codigo=leer.readLine();
        resultado=baseDatos.queryByExample(new C_Seguro (codigo, 0, null));

        if(!resultado.isEmpty())
        {
            seguro=(C_Seguro)resultado.next();
            if(Menu.menuConfirmar(leer)==1)
            {
                baseDatos.delete(seguro);
                limpiarEnfermo(baseDatos, seguro);
                baseDatos.commit();
                System.out.println("\n - Seguro Eliminado - \n");
            }
        }
        else
            System.out.println("\n Seguro no encontrado \n");
        
    }   
    
    public static void limpiarMedico (ObjectContainer baseDatos, C_Enfermo enfermo) throws IOException {
        
        ObjectSet resultado;
        C_Medico medico;
        
        resultado=baseDatos.queryByExample(new C_Medico ());

        while(resultado.hasNext())
        {
            medico=(C_Medico)resultado.next();
            if(medico.getEnfermos().contains(enfermo))
            {
                medico.getEnfermos().remove(enfermo);
                baseDatos.store(medico);
            }
            
        }
    }   
    
    public static void limpiarEnfermo (ObjectContainer baseDatos, C_Seguro seguro) throws IOException {
        
        ObjectSet resultado;
        C_Enfermo enfermo;
        
        resultado=baseDatos.queryByExample(new C_Enfermo ());

        while(resultado.hasNext())
        {
            enfermo=(C_Enfermo)resultado.next();
            if(enfermo.getSeguros().contains(seguro))
            {
                enfermo.getSeguros().remove(seguro);
                baseDatos.store(enfermo);
            }
            
        }
    } 
}
    