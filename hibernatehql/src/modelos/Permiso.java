/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author EMiSaRiO
 */
@Entity
@Table(name="permisos")
public class Permiso implements Serializable {
    
    public enum Estatus{PENDIENTE,ACTIVO,INACTIVO}
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    
    private long id;
    private String nombre;
    private Estatus estatus= Estatus.PENDIENTE;
    
    public Permiso()
    {
        
    }
    
    public Estatus getEstatus()
    {
        return estatus;
    }
    
    public void setEstatus(Estatus estatus)
    {
        this.estatus=estatus;
    }
    
    public long getId()
    {
        return id;
    }
    
    public void setId(long id)
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

}
