
package domain;

public class Persona {
    private String nombrePersona;
    private String apellidoPersona;

    public Persona() {
    }
    
    public Persona(String nombrePersona, String apellidoPersona){
        this.nombrePersona = nombrePersona;
        this.apellidoPersona = apellidoPersona;
    }

    public void setNombrePersona(String nombrePersona) {
        this.nombrePersona = nombrePersona;
    }

    public void setApellidoPersona(String apellidoPersona) {
        this.apellidoPersona = apellidoPersona;
    }

    public String getNombreApellidoPersona() {
        return nombrePersona + " " + apellidoPersona;
    }
    
    @Override
    public String toString() {
        return nombrePersona + " " + apellidoPersona;
    }
    
    
    
}
