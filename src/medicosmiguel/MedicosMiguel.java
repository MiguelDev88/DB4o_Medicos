package medicosmiguel;
import Clases.*;
import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.config.EmbeddedConfiguration;
import java.io.*;


//  @author Miguel
 
public class MedicosMiguel {


    public static void main(String[] args) {
        
        BufferedReader leer=new BufferedReader (new InputStreamReader(System.in));
        ///////////////////////////////////////////////////////////////////////////
        EmbeddedConfiguration config = Db4oEmbedded.newConfiguration();
        config.common().objectClass(C_Medico.class).cascadeOnUpdate(true);
        config.common().objectClass(C_Seguro.class).cascadeOnUpdate(true);
        config.common().objectClass(C_Enfermo.class).cascadeOnUpdate(true);
        //config.common().objectClass(C_Medico.class).cascadeOnDelete(true);
        //config.common().objectClass(C_Seguro.class).cascadeOnDelete(true);
        //config.common().objectClass(C_Enfermo.class).cascadeOnDelete(true);
        ///////////////////////////////////////////////////////////////////////////
        ObjectContainer baseDatos=Db4oEmbedded.openFile(config,"BBDD_Hospital");
        byte op=0;
        
        do{
            try{
                op=Menu.menuPrincipal(leer);

                switch(op) {
                    case 1:
                        Altas.altas(baseDatos, leer);
                        break;
                    case 2:
                        Asociar.asociar(baseDatos, leer);
                        break;
                    case 3:
                        Bajas.bajas(baseDatos, leer);
                        break;
                    case 4:
                        Consultas.consultas(baseDatos, leer);
                        break;
                    case 0:
                        System.out.println("--- FIN DEL PROGRAMA ---");
                        baseDatos.close();
                        System.exit(0);
                        break;
                }
                
            }catch(Exception e){
            
                System.out.println(e.getMessage());
            
            }
        }while(op!=6);
    }
    
}
