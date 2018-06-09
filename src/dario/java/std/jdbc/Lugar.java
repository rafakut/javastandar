package dario.java.std.jdbc;

public class Lugar {

    private int id;
    private String nombreResponsable;
    private String direccion;
    private String router;

    public Lugar(String nombreResponsable, String direccion, String router) {
        this.nombreResponsable = nombreResponsable;
        this.direccion = direccion;
        this.router = router;
    }

    public Lugar(int id, String nombreResponsable, String direccion, String router) {
        this.id = id;
        this.nombreResponsable = nombreResponsable;
        this.direccion = direccion;
        this.router = router;
    }

    
    
    public String getNombreResponsable() {
        return nombreResponsable;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getRouter() {
        return router;
    }

    public int getId() {
        return id;
    }
    
    

    @Override
    public String toString() {
        return "Lugar{" + "nombreResponsable=" + nombreResponsable + ", direccion=" + direccion + ", router=" + router + '}';
    }
    
    
    
    
    
}
