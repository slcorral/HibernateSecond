/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author EMiSaRiO
 */
public class Main {
    
    private Session sesion;
    
    public Main()
    {
        obtenNombres();
        obtenNombresYPasswords();
    }
    
    public static void main(String[] args)
    {
        new Main();
    }
    
    private void iniciaOperacion()
    {
        //SessionFactory sessionFacto0ry= new AnnotationConfiguration().configure().buildSessionFactory();
        SessionFactory sessionFactory=null;
        sesion= sessionFactory.openSession();
        sesion.getTransaction().begin();
    }
    
    
    private void terminaOperacion()
    {
        sesion.getTransaction().commit();
        sesion.close();
    }
    
    
    private void obtenNombres()
    {
        iniciaOperacion();
        
        Query query=sesion.createQuery("Select u.nombre from Usuario as u");
        
        List<String> listaResultados= query.list();
        
        for(int i=0;i<listaResultados.size();i++)
        {    
            System.out.println("Nombre "+ i +": "+listaResultados.get(i)); 
        }
        
        terminaOperacion();
        
    }
    
    private void obtenNombresYPasswords()
    {
        iniciaOperacion();
        
        Query query=sesion.createQuery("Select u.nombre,u.password FROM Usuario as u");
        
        List<Object[]> listaResultados=query.list();
        
        for(int i=0;i<listaResultados.size();i++)
        {
            System.out.println("Nombre "+ i +": "+listaResultados.get(i)[0]+ ", password: "+listaResultados.get(i)[1]);
 
        }
        
        terminaOperacion();
        
    }
    
    private void obtenNombresYPasswordsComoLista()
    {
        iniciaOperacion();
        
        Query query= sesion.createQuery("SELECT new list(u.nombre, u.password) FROM Usuario as u ");
        
        List<List> listaResultados= query.list();
        
        for(int i=0;i<listaResultados.size();i++)
        {
            
            System.out.println("Nombre "+ i+ ": "+ listaResultados.get(i).get(0)+ ", password: "+
                    listaResultados.get(i).get(1));
        }
        
        terminaOperacion();
        
    }
    
}
