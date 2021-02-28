/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author KEINER
 */
//clase que gestiona la conexion a la base de datos
public class AdministradorDAO {
    
    public void AgregarEmpresa(Empresa empresa){  //funcion para agregar la empresa a la base de datos
        Transaction TR = null; //creamos una transacion y la inicializamos a null
        
         try { //creamos un try para controlar las excepciones 
             SessionFactory sesion = NewHibernateUtil.getSessionFactory(); //creamos  una nueva session a la base de datos 
             Session session; //instanciamos la session 
             session = sesion.openSession(); //abrimos la session a la base de datos 
             TR = session.beginTransaction(); //hacemos la transacion osea la consulata o el registro
             
              session.save(empresa); //guardamos la sesion osea registramos la empresa 
              TR.commit(); // ...
              session.close(); //cerramos la session 
                   JOptionPane.showMessageDialog(null,"Empresa Agregar Con Exito");
        } catch (RuntimeException e) {
            if(TR != null){ //si el registro falla
                TR.rollback();
                JOptionPane.showMessageDialog(null,"No Se Pudo Agregar La Empresa");
                e.printStackTrace();
            }
        }
    }
    //funcion para buscar empres aen la base de datos 
    public Empresa BuscarEmpres(String codigo){
        Empresa empresa = null;
        Transaction TR = null;
          
          Session sesion = NewHibernateUtil.getSessionFactory().openSession();
          try {
            TR = sesion.beginTransaction();
            String querString = "from Empresa where codigo = :codigo"; //hacemos la consulta en la base de datos
            Query query = sesion.createQuery(querString);
            query.setString("codigo",codigo);
            empresa = (Empresa) query.uniqueResult();
            
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
              sesion.flush();
              sesion.close();
          }
        
        return empresa;
    }
    
    public Login BuscarFuncionario(String nombre){
        Login login = null;
        Transaction TR = null;
        
        Session sesion = NewHibernateUtil.getSessionFactory().openSession();
        try {
            TR  = sesion.beginTransaction();
            String queryString = "from Login where nombre = :nombre";
            Query query = sesion.createQuery(queryString);
            query.setString("nombre",nombre);
            login = (Login) query.uniqueResult();
            
        } catch (RuntimeException e) {
            e.printStackTrace();
        }finally{
            sesion.flush();
            sesion.close();
        }
        return login;
    }
    
    public List<Login> Mostrar_Funcionarios(){
        SessionFactory sesion = NewHibernateUtil.getSessionFactory();
        Session session;
        
            session = sesion.openSession();
            session.beginTransaction();
            List<Login> array = (List<Login>) session.createQuery("select nombre from Login").list();
            session.getTransaction().commit();
       
        return array;
    }
    
    public void Asignar_Solicitud(SolicitudesAtendidas soli){
        Transaction TR = null; //creamos una transacion y la inicializamos a null
        
         try { //creamos un try para controlar las excepciones 
             SessionFactory sesion = NewHibernateUtil.getSessionFactory(); //creamos  una nueva session a la base de datos 
             Session session; //instanciamos la session 
             session = sesion.openSession(); //abrimos la session a la base de datos 
             TR = session.beginTransaction(); //hacemos la transacion osea la consulata o el registro
             
              session.save(soli); //guardamos la sesion osea registramos la empresa 
              TR.commit(); // ...
              session.close(); //cerramos la session 
                   JOptionPane.showMessageDialog(null,"Solicitud Asignada Con Exito");
        } catch (RuntimeException e) {
            if(TR != null){ //si el registro falla
                TR.rollback();
                JOptionPane.showMessageDialog(null,"No Se Pudo Asignar La Solicitud");
                e.printStackTrace();
            }
        }
    }
}
