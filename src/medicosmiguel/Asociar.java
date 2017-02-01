package medicosmiguel;
import Clases.*;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import java.io.BufferedReader;
import java.io.IOException;


// @author Miguel

public class Asociar {
    
    public static void asociar (ObjectContainer baseDatos, BufferedReader leer) throws IOException {
        
        C_Medico medico;
        C_Enfermo enfermo;
        ObjectSet resultado;
        int codigo;
        String dni;
        byte op=1;
        

        while(op!=0){
            op=Menu.menuAsociar(leer);
            switch(op){
                case 1:
                    System.out.println("Introducir código del Médico:");
                    codigo=Integer.parseInt(leer.readLine());
                    resultado=baseDatos.queryByExample(new C_Medico (codigo, null, null, null, null));
                    if(!resultado.isEmpty())
                    {
                        medico=(C_Medico)resultado.next();
                        asociarEnfermo(medico, baseDatos, leer);
                        baseDatos.store(medico);
                        baseDatos.commit();
                    }
                    else
                        System.out.println("\n Médico no encontrado \n");
                    break;
                case 2:
                    System.out.println("Introducir DNI del Enfermo:");
                    dni=leer.readLine();
                    resultado=baseDatos.queryByExample(new C_Enfermo (dni, null, null));
                    if(!resultado.isEmpty())
                    {
                        enfermo=(C_Enfermo)resultado.next();
                        asociarSeguro(enfermo, baseDatos, leer);
                        baseDatos.store(enfermo);
                        baseDatos.commit();
                    }
                    else
                        System.out.println("\n Enfermo no encontrado \n");
                    break;

            }
        }
    }
    
    
    public static void asociarEnfermo (C_Medico medico, ObjectContainer baseDatos, BufferedReader leer) throws IOException {
        
        
        C_Enfermo enfermo;
        String dni;
        ObjectSet resultado;
        byte op=1;
        
        
        while(op!=0){
            
            System.out.println("¿Desea asociar un Enfermo nuevo o uno existente?"
                    + "\n1.Nuevo"
                    + "\n2.Existente"
                    + "\n0.Finalizar");
            op=Byte.parseByte(leer.readLine());

            switch(op){
                case 1:
                    enfermo=Altas.nuevoEnfermo(leer);
                    if(baseDatos.queryByExample(enfermo).isEmpty())
                    {
                        asociarSeguro(enfermo, baseDatos, leer);
                        medico.getEnfermos().add(enfermo);
                        System.out.println("\n Enfermo Asociado \n");
                    }
                    else
                        System.out.println(" \n Enfermo ya existente en la BD \n");
                    break;
                case 2:
                    System.out.println("Introducir DNI del Enfermo a asociar:");
                    dni=leer.readLine();
                    
                    resultado=baseDatos.queryByExample(new C_Enfermo (dni, null, null));

                    if(!resultado.isEmpty())
                    {
                        enfermo=(C_Enfermo)resultado.next();
                        if(medico.getEnfermos().contains(enfermo))
                            System.out.println("\n Enfermo ya registrado en ese Médico \n");
                        else
                        {
                            medico.getEnfermos().add(enfermo);
                            System.out.println("\n Enfermo Asociado \n");
                        }
                    }
                    else
                        System.out.println("\n Enfermo no encontrado \n");

                    break;
            }
        }
        
    }
    
    public static void asociarSeguro (C_Enfermo enfermo, ObjectContainer baseDatos, BufferedReader leer) throws IOException {
        
        
        C_Seguro seguro;
        String codigo;
        ObjectSet resultado;
        byte op=1;
        
        
        while(op!=0){
            
            System.out.println("¿Desea asociar un Seguro nuevo o uno existente?"
                    + "\n1.Nuevo"
                    + "\n2.Existente"
                    + "\n0.Finalizar");
            op=Byte.parseByte(leer.readLine());

            switch(op){
                case 1:
                    seguro=Altas.nuevoSeguro(leer);
                    if(baseDatos.queryByExample(seguro).isEmpty() /*&& !enfermo.getSeguros().contains(seguro)*/)
                    {
                        enfermo.getSeguros().add(seguro);
                        System.out.println("\n Seguro Asociado \n");
                    }
                    else
                        System.out.println(" \n Seguro ya existente en la BD \n");
                    break;
                case 2:
                    System.out.println("Introducir código del seguro a asociar:");
                    codigo=leer.readLine();
                    
                    resultado=baseDatos.queryByExample(new C_Seguro (codigo, 0, null));

                    if(!resultado.isEmpty())
                    {
                        seguro=(C_Seguro)resultado.next();
                        if(enfermo.getSeguros().contains(seguro))
                            System.out.println("\n Seguro ya registrado en ese Enfermo \n");
                        else
                        {
                            enfermo.getSeguros().add(seguro);
                            System.out.println("\n Seguro Asociado \n");
                        }
                    }
                    else
                        System.out.println("\n Seguro no encontrado \n");

                    break;
            }
        }
    }
    
    public static void asociarMedico (C_Enfermo enfermo, ObjectContainer baseDatos, BufferedReader leer) throws IOException {
        
        
        C_Medico medico;
        ObjectSet resultado;
        int codigo;
        byte op=1;
        
        
        while(op!=0){

            System.out.println("Seleccione opción:"
                        + "\n1.Asignar Médico al Enfermo"
                        + "\n0.Finalizar");
            op=Byte.parseByte(leer.readLine()); 
            
            if(op==1) 
            {
                System.out.println("Introducir código Médico:");
                codigo=Integer.parseInt(leer.readLine());

                resultado=baseDatos.queryByExample(new C_Medico (codigo, null, null, null, null));

                if(!resultado.isEmpty())
                {
                    medico=(C_Medico)resultado.next();
                    if(medico.getEnfermos().contains(enfermo))
                        System.out.println("\n Enfermo ya registrado con este médico \n");
                    else
                    {
                        medico.getEnfermos().add(enfermo);
                        baseDatos.store(medico);
                        System.out.println("\n Enfermo Asociado \n");
                    }
                }
                else
                    System.out.println("\n Médico no encontrado \n");

                }
            }
        
        
    }
}
