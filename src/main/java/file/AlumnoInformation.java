package file;
import com.javi.poo.registroAsistencias.model.Persona;

public class AlumnoInformation extends Persona{
    public AlumnoInformation(String nombre, String apellido, int edad, String nacionalidad){
        this.setNombre(nombre);
        this.setApellido(apellido);
        this.setEdad(edad);
        this.setNacionalidad(nacionalidad);
    }
}