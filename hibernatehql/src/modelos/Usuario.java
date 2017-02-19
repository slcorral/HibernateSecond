/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author EMiSaRiO
 */
@Entity
@Table(name="usuarios")
public class Usuario implements Serializable {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    
    private long id;
    private String nombre;
    private String username;
    private String password;
    
    @OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
    private List<Permiso> permisos=new ArrayList<Permiso>();
    
    @OneToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
    private Direccion direccion;
    
    public long getId()
    {
        return id;
    }
    
    protected void setId(long id)
    {
        this.id=id;
    }
    
    public String getNombre()
    {
        return nombre;
    }
    
    public void setNombre(String nombre)
    {
        this.nombre=nombre;
    }
    
    public String getPassword()
    {
        return password;
    }
    
    public void setPassword(String password)
    {
        this.password=password;
    }
    
    public List<Permiso> getPermisos()
    {
        return permisos;
    }
    
    public void setPermisos(List<Permiso> permisos)
    {
        this.permisos=permisos;
    }
    
    public String getUsername()
    {
        return username;
    }
    
    public void setUsername(String username)
    {
        this.username=username;
    }
    
    public Direccion getDireccion()
    {
        return direccion;
    }
    
    public void setDireccion(Direccion direccion)
    {
        this.direccion=direccion;
        direccion.setUsuario(this);
    }
    
    
}
