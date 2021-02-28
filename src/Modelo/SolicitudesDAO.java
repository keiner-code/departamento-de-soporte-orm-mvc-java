/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author Keiner
 */
public class SolicitudesDAO {
    
    
    public List<SolicitudesAtendidas> Mostrar_Solicitudes_Atendidas(String contra){
        SessionFactory sesion = NewHibernateUtil.getSessionFactory();
        Session session;
        
          session = sesion.openSession();
          session.beginTransaction();
          List<SolicitudesAtendidas> lista = (List<SolicitudesAtendidas>) session.createQuery("from SolicitudesAtendidas where contrasenaFuncionario = '"+contra+"' and estadosolicitud1 = 'No Atendida'").list();
          session.getTransaction().commit();
          return lista;
          
    }
    
    public List<SolicitudesAtendidas> ListarSolicitudes(){
        
        SessionFactory sesion = NewHibernateUtil.getSessionFactory();
        Session session;
        
            session = sesion.openSession();
            session.beginTransaction();
            List<SolicitudesAtendidas> Lista = (List<SolicitudesAtendidas>) session.createQuery("from SolicitudesAtendidas").list();
            session.getTransaction().commit();
        return Lista;
    }
}
