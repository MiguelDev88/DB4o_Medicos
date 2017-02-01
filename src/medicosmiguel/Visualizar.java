package medicosmiguel;
import Clases.*;
import com.db4o.ObjectSet;
import java.util.Iterator;

 
// @author Miguel
 
public class Visualizar {
    
    public static void visualizarMedicos (ObjectSet resultado) {
        
        C_Medico medico;
        
        System.out.println("-----------------------------------------------------------");
        System.out.println("   CODIGO      NOMBRE     ESPECIALIDAD      NºDE ENFERMOS");
        
        while(resultado.hasNext())
        {
            medico=(C_Medico)resultado.next();
            System.out.printf("%12d%11s%18s%15s%n",medico.getCodigo(), medico.getNombre(),medico.getEspecialidad(),medico.getEnfermos().size());
        }
        
        System.out.println("-----------------------------------------------------------");
        
        
    }
    public static void visualizarEnfermos (ObjectSet resultado) {
        
        C_Enfermo enfermo;

        System.out.println("----------------------------------------------");
        System.out.println("    DNI      NOMBRE     PATOLOGIA     SEGUROS   ");
        
        while(resultado.hasNext())
        {
            enfermo=(C_Enfermo)resultado.next();
            System.out.printf("%10s%11s%14s%12s%n",enfermo.getDni(),enfermo.getNombre(),enfermo.getPatologia(),enfermo.getSeguros().size());

        }
        
        System.out.println("----------------------------------------------");
        
    }
    
    public static void visualizarSeguros (ObjectSet resultado) {
        
        C_Seguro seguro;
        
        
        System.out.println("--------------------------------------");
        System.out.println("   CODIGO    PRECIO    PRESTACIONES  ");
            
        while(resultado.hasNext())
        {
            seguro=(C_Seguro)resultado.next();
            System.out.printf("%11s%11s%16s%n",seguro.getCodigo(),seguro.getPrecio(),seguro.getPrestaciones());

        }
        System.out.println("--------------------------------------");
        
    }
    
    public static void visualizarEnfermosMedico (ObjectSet resultado) {
        
        C_Enfermo enfermo;
        C_Seguro seguro;
        
        Iterator enfermos=((C_Medico)resultado.next()).getEnfermos().iterator();
        
        System.out.println("---------------------------------");
        System.out.println("    DNI     NOMBRE   PATOLOGIA  ");
            
        while(enfermos.hasNext())
        {
            enfermo=(C_Enfermo)enfermos.next();
            System.out.printf("%10s%10s%13s%n",enfermo.getDni(),enfermo.getNombre(),enfermo.getPatologia());
            Iterator seguros=enfermo.getSeguros().iterator();
            
            System.out.println("SEGUROS:");
            System.out.println("--------------------------------------");
            System.out.println("   CODIGO    PRECIO    PRESTACIONES  ");
            
            while(seguros.hasNext())
            {   
                seguro=(C_Seguro)seguros.next();
                System.out.printf("%11s%11s%16s%n",seguro.getCodigo(),seguro.getPrecio(),seguro.getPrestaciones());
            }
            System.out.println("--------------------------------------");
        }
        
        System.out.println("----------------------------------");
        
    }
    
}
