package Clases;
import java.util.ArrayList;
import java.util.List;

public class C_Medico  {
    
    private int codigo;
    private String nombre,especialidad,direccion,telefono;
    private List enfermos;
    
    
    public C_Medico () {}
    
    public C_Medico (int codigo, String nombre, String especialidad, String direccion, String telefono) {
        
        this.codigo=codigo;
        this.nombre=nombre;
        this.especialidad=especialidad;
        this.direccion=direccion;
        this.telefono=telefono;
        this.enfermos=new ArrayList();
        
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public List getEnfermos() {
        return enfermos;
    }

    public void setEnfermos(List enfermos) {
        this.enfermos = enfermos;
    }

}
