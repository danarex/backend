
package com.portfolio.dana.Entity;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;



@Entity
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
   
      //relacion y para que borre si la persona no existe
    @OneToMany(mappedBy="persona", cascade=CascadeType.ALL)
    private List<Educacion> educacion; 
    
      //relacion y para que borre si la persona no existe
    @OneToMany(mappedBy="persona", cascade=CascadeType.ALL)
    private List<Experiencia> experiencia; 
    
      //relacion y para que borre si la persona no existe
    @OneToMany(mappedBy="persona", cascade=CascadeType.ALL)
    private List<Proyectos> proyectos; 
    
      //relacion y para que borre si la persona no existe
    @OneToMany(mappedBy="persona", cascade=CascadeType.ALL)
    private List<Skills> skills; 
   
          //relacion y para que borre si la persona no existe
    @OneToMany(mappedBy="persona", cascade=CascadeType.ALL)
    private List<RedesSociales> redessociales; 
    public Persona(Long id, String nombre,String ubicacion, String apellido,String email, String img, String sobreMi) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.img = img;
        this.sobreMi = sobreMi;
        this.ubicacion = ubicacion;
    }

    public Persona() {
    }

   
    
    @NotNull
    @Size(min=1, max=25, message="No cumple con la longitud")
    private String nombre;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    
    
     public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
    
    public String getSobreMi() {
        return sobreMi;
    }

    public void setSobreMi(String sobreMi) {
        this.sobreMi = sobreMi;
    }
    
     public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }
    
    
    
    @NotNull
    @Size(min=1, max=25, message="No cumple con la longitud")
    private String apellido;
   
    @Size(min=1, max=100, message="No cumple con la longitud")
    private String img;
    
    @Size(min=10, max=25, message="No cumple con la longitud")
    private String email;
    
    @Size(min=1, max=200, message="No cumple con la longitud")
    private String sobreMi;
    
    @Size(min=1, max=200, message="No cumple con la longitud")
    private String ubicacion;


    
}
