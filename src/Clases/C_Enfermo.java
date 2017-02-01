package Clases;
import java.util.ArrayList;
import java.util.List;

public class C_Enfermo {
    
    private String dni;
    private String nombre,patologia;
    private List seguros;

    
    public C_Enfermo () {}
    
    public C_Enfermo (String dni, String nombre, String patologia) {
        
        this.dni=dni;
        this.nombre=nombre;
        this.patologia=patologia;
        this.seguros= new ArrayList();
        
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPatologia() {
        return patologia;
    }

    public void setPatologia(String patologia) {
        this.patologia = patologia;
    }

    public List getSeguros() {
        return seguros;
    }

    public void setSeguros(List seguros) {
        this.seguros = seguros;
    }
    
}
