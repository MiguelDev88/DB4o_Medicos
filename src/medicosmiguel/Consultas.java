
package medicosmiguel;
import Clases.*;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.query.Query;
import java.io.*;


 // @author Miguel

public class Consultas { 
    
    public static void consultas (ObjectContainer baseDatos, BufferedReader leer) throws IOException {
        
        byte op=1;
        

        while(op!=0){
            op=Menu.menuConsultas(leer);
            switch(op){
                case 1:
                    consultaMedico(baseDatos, leer);
                    break;
                case 2:
                    consultaEnfermo(baseDatos, leer);
                    break;
                case 3:
                    verTodo(baseDatos);
                    break;
            }
        }
    }
    
    public static void consultaMedico (ObjectContainer baseDatos, BufferedReader leer) throws IOException {
        
        Query consulta=baseDatos.query();
        ObjectSet resultado;
        String especialidad;
        
        consulta.constrain(C_Medico.class);
        System.out.println("Introducir especialidad de los Médicos a consultar:");
        especialidad=leer.readLine();
        consulta.descend("especialidad").constrain(especialidad);
        resultado=consulta.execute();
        Visualizar.visualizarMedicos(resultado);

    }
    
    public static void consultaEnfermo (ObjectContainer baseDatos, BufferedReader leer) throws IOException {
        
        Query consulta=baseDatos.query();
        ObjectSet resultado;
        int codigo;
        
        
        consulta.constrain(C_Medico.class);
        System.out.println("Introducir código del Médico:");
        codigo=Integer.parseInt(leer.readLine());
        consulta.descend("codigo").constrain(codigo);
        resultado=consulta.execute();
        
        if(resultado.isEmpty())
            System.out.println("\n - No hay datos que mostrar - \n");
        
        else
        {
            Visualizar.visualizarEnfermosMedico(resultado);
        }

    }
    
    

    public static void verTodo(ObjectContainer baseDatos) {
        
        ObjectSet resultado;
        
        System.out.println(" --- MEDICOS REGISTRADOS");
        C_Medico medico=new C_Medico();
        resultado=baseDatos.queryByExample(medico);
        Visualizar.visualizarMedicos(resultado);
        
        System.out.println(" --- ENFERMOS REGISTRADOS");
        C_Enfermo enfermo=new C_Enfermo();
        resultado=baseDatos.queryByExample(enfermo);
        Visualizar.visualizarEnfermos(resultado);
        
        System.out.println(" --- SEGUROS REGISTRADOS");
        C_Seguro seguro=new C_Seguro();
        resultado=baseDatos.queryByExample(seguro);
        Visualizar.visualizarSeguros(resultado);
       
    }

}
