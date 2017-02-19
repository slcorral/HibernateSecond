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
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author EMiSaRiO
 */
@Entity
@Table(name="direcciones")
public class Direccion implements Serializable {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    
    private long id;
    private String calle;
    private String codigoPostal;
    
    @OneToOne(mappedBy="direccion")
    private Usuario usuario;
    
    public Direccion()
    {
        
    }
    
    public String getCalle()
    {
        return calle;
    }
    
    public void setCalle(String calle)
    {
        this.calle=calle;
    }
    
    public String getCodigoPostal()
    {
        return codigoPostal;
    }
    
    public void setCodigoPostal(String codigoPostal)
    {
        this.codigoPostal=codigoPostal; 
    }
    
    public long getId()
    {
        return id;
    }
    
    protected void setId(long id)
    {
        this.id=id;
    }
    
    public Usuario getUsuario()
    {
        return usuario;
    }
    
    public void setUsuario(Usuario usuario)
    {
        this.usuario=usuario;
    }
   
}
