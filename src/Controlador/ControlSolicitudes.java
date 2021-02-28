/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.*;
import Vista.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Keiner
 */
public class ControlSolicitudes implements ActionListener{
    SolicitudesDAO dao = new SolicitudesDAO();
    GestionSolicitud vista = new GestionSolicitud();
    LoginVista vistalogin = new LoginVista();
    ControlReloj Controreloj = new ControlReloj();

    public ControlSolicitudes(SolicitudesDAO sol, GestionSolicitud vis){
        this.dao = sol;
        this.vista = vis;
        vista.jButtonMostrarSolAtendidas.addActionListener(this);
        vista.jButtonAtender.addActionListener(this);
    } 

    public ControlSolicitudes() {
    }    
    public void Muestra_Sol_Atendidas(String Contra){
        List<SolicitudesAtendidas> solicitud = new ArrayList<SolicitudesAtendidas>();
        SolicitudesAtendidas soli = new SolicitudesAtendidas();
        solicitud = dao.Mostrar_Solicitudes_Atendidas(Contra);
        
       DefaultTableModel Dtabla = (DefaultTableModel) vista.jTableSolicitudAtendida.getModel(); //jTableSolicitudAtendida.getModel();
        for (SolicitudesAtendidas sol : solicitud){
            //System.out.println("Nombre Empresa: "+sol.getNombreEmpresa()+"\nCodigo Empresa: "+sol.getCodigoEmpresa());
           Object[] objetos = new Object[]{sol.getIdSolicitudesAtendidas(),
                                            sol.getNombreEmpresa(),
                                            sol.getCodigoEmpresa(),
                                            sol.getNombreFuncionario(),
                                            sol.getContrasenaFuncionario(),
                                            sol.getestadosolicitud1()};
                                            
           Dtabla.addRow(objetos);
        }
    }
    
    public void MostrarSolicitudes(){
        List<SolicitudesAtendidas> soli = new ArrayList<SolicitudesAtendidas>();
        SolicitudesAtendidas sol = new SolicitudesAtendidas();
        soli = dao.ListarSolicitudes();
        
        DefaultTableModel tabla = (DefaultTableModel) vista.jTableSolicitudes.getModel();
        for(SolicitudesAtendidas Sol: soli){
            Object[] objeto = new Object[]{Sol.getIdSolicitudesAtendidas(),
                                            Sol.getNombreEmpresa(),
                                            Sol.getCodigoEmpresa(),
                                            Sol.getNombreFuncionario(),
                                          //Sol.getContrasenaFuncionario(),
                                            Sol.getestadosolicitud1()};
            tabla.addRow(objeto);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == vista.jButtonMostrarSolAtendidas){
            Muestra_Sol_Atendidas(vista.jTextFieldgestionContrase.getText());
        }else if(e.getSource() == vista.jButtonAtender){
            JOptionPane.showMessageDialog(null,"Usted Tendra 15 Minutos Para Atender Esta Solicitud");
            Controreloj.Hora();
            Controreloj.Iniciar();
        }
    }
}
