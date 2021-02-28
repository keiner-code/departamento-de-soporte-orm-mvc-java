/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import javax.swing.JOptionPane;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author KEINER
 */
//clase para gestionar la conexion de la base e datos para el login y el registro de ususario
public class LoginDAO {
    
    public void AgregarPersona(Login agregar){ //funcion para agregar los usuarios
        Transaction TR=null;
       // System.out.println(agregar.getNombre()+agregar.getApellido()+agregar.getContrasena()+agregar.getTipoCuenta());
        try {
            SessionFactory sesion = NewHibernateUtil.getSessionFactory();
            Session session;
            session = sesion.openSession();
            TR = session.beginTransaction();
            
            session.save(agregar);
            TR.commit();
            session.close();
            
                JOptionPane.showMessageDialog(null,"Usuario Agregado");
        } catch (RuntimeException e) {
            if(TR != null){
                TR.rollback();
                JOptionPane.showMessageDialog(null,"Ya Existe el usuario con la misma Cedula");
                e.printStackTrace();
            }
        }
    }
    
    public Login BuscarUsuario(String contraseña){ //funcion para buscar los usuarios
        Login usuario = null;
        Transaction TR = null;
       
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        
          try {
            TR = session.beginTransaction();
            String queryString = "from Login where contrasena = :id";
            Query query = session.createQuery(queryString);
            
            query.setString("id",contraseña);
            usuario = (Login) query.uniqueResult();
            
        } catch (RuntimeException e) {
            e.printStackTrace();
        }finally{
              session.flush();
              session.close();
          }
        return usuario;
    }
}
