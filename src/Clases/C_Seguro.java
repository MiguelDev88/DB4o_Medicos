package Clases;


// @author Miguel

public class C_Seguro {
    
    private String codigo;
    private int precio;
    private String prestaciones;
    
    
    public C_Seguro() {}
    
    public C_Seguro(String codigo, int precio, String prestaciones){
        
        this.codigo=codigo;
        this.precio=precio;
        this.prestaciones=prestaciones;
                         
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public String getPrestaciones() {
        return prestaciones;
    }

    public void setPrestaciones(String prestaciones) {
        this.prestaciones = prestaciones;
    }

}
