
package medicosmiguel;
import java.io.*;


//  @author Miguel
 
public class Menu {
    
    
    public static byte menuPrincipal (BufferedReader leer) throws IOException {
        
        byte op;
        
        System.out.println("¿Qué desea?"
                + "\n1.Altas"
                + "\n2.Asignación"
                + "\n3.Bajas"
                + "\n4.Consultas"
                + "\n0.Salir");
        op=Byte.parseByte(leer.readLine());
        
        return op;
        
        
    }
    
    public static byte menuAltas (BufferedReader leer) throws IOException {
        
        byte op;
        
        System.out.println("¿Qué desea dar de alta?"
                + "\n1.Medico"
                + "\n2.Enfermo"
                + "\n3.Seguro"
                + "\n0.Finalizar");
        op=Byte.parseByte(leer.readLine());
        
        return op;
        
    }
    
    public static byte menuAsociar (BufferedReader leer) throws IOException {
        
        byte op;
        
        System.out.println("¿Qué desea Asociar?"
                + "\n1.Enfermos a un médico"
                + "\n2.Seguros a un enfermo"
                + "\n0.Finalizar");
        op=Byte.parseByte(leer.readLine());
        
        return op;
        
    }
    
    public static byte menuBajas (BufferedReader leer) throws IOException {
        
        byte op;
        
        System.out.println("¿Qué desea dar de baja?"
                + "\n1.Medico"
                + "\n2.Enfermo"
                + "\n3.Seguro"
                + "\n0.Finalizar");
        op=Byte.parseByte(leer.readLine());
        
        return op;
        
    }
    
    public static byte menuConfirmar (BufferedReader leer) throws IOException {
        
        byte op;
        System.out.println("¿Seguro que desea eliminar este registro?"
                + "\n1.SI"
                + "\n2.NO");
        
        op=Byte.parseByte(leer.readLine());
        
        return op;
    }
    
    public static byte menuConsultas (BufferedReader leer) throws IOException {
    
        byte op;
        
        System.out.println("¿Qué desea consultar?"
                        + "\n1.Médicos por especialidad"
                        + "\n2.Enfermos de un médico"
                        + "\n3.Ver todo"
                        + "\n0.Finalizar");
        
        op=Byte.parseByte(leer.readLine());
        
        return op;
        
    }
    
}
