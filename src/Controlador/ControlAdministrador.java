/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Vista.VistaAdministrador;
import Vista.LoginVista;
import java.awt.event.ActionListener;
import Modelo.*;
import Vista.*;
import departamento.de.soporte.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.JOptionPane;

/**
 *
 * @author KEINER
 */

//la clase del administrador
public class ControlAdministrador implements ActionListener{ //implementamos la (interfaz = que es una clase no tiene que ver con nada grafico) y heredamos toda la clase Actionlistener para capturar los click del mouse
    AdministradorDAO administrado = new AdministradorDAO();//instanciamos la conexion a la base de datos
    VistaAdministrador vista = new VistaAdministrador(); //instanciamos el jframe que es la parte grafica del administrador
    LoginVista login = new LoginVista(); // instanciamos la parte grafica del login 
    DepartamentoDeSoporte main = new DepartamentoDeSoporte(); //instanciamos la clase principal el main
    protected String contra;

    public ControlAdministrador(AdministradorDAO dao, VistaAdministrador vis){ //constructor que recibe dos parametros la clase de la conexion a la base de datos y la clase grafica de la misma
        this.administrado = dao;
        this.vista = vis;
        vista.jButtonRegistrar_empresa.addActionListener(this);
        vista.jButtonRegresarLogin.addActionListener(this);  
        vista.jButtonBuscar_por_codigo.addActionListener(this);
        vista.jButtonAsignar.addActionListener(this);
    }
    
    /*esta funcion se encarga de enviarle a la clase administradorDAO para reguistrar la empresa en la base de datos*/
    public void Agregar_Empresa(String codigo, String nombre, String tipo, String depar_queja,String queja1, 
                                String estado1,String queja2,String estado2,String queja3,String estado3){
        Empresa emp = new Empresa();
        
        emp.setNombreDeLaEmpresa(nombre);
        emp.setCodigo(codigo);
        emp.setTipoDeEmpresa(tipo);
        emp.setAreaDeLaQueja(depar_queja);
        emp.setQuejaOReclamo1(queja1);
        emp.setEstadoQueja1(estado1);
        emp.setQuejaOReclamo2(queja2);
        emp.setEstadoQueja2(estado2);
        emp.setQuejaOReclamo3(queja3);
        emp.setEstadoQueja3(estado3);
        administrado.AgregarEmpresa(emp);
    }
    
    public void Agrgar_Solicitud(String nombre_emp, String codigo_emp, String nombre_Func, String contr_func,int aleatorio, String estado){
        SolicitudesAtendidas sol = new SolicitudesAtendidas();
        //System.out.println("Nombre: "+nombre_emp+"\nCodigo: "+codigo_emp+"\nNombre_F: "+nombre_Func+"\ncontra: "+contr_func);
        sol.setNombreEmpresa(nombre_emp);
        sol.setCodigoEmpresa(codigo_emp);
        sol.setNombreFuncionario(nombre_Func);
        sol.setContrasenaFuncionario(contr_func);
        sol.setIdSolicitudesAtendidas(aleatorio);
        sol.setestadosolicitud1(estado);
        administrado.Asignar_Solicitud(sol);
         
    }
    
    //funcion para cerrar la session en el administrador 
     public void CerrarSesion(){
         vista.setVisible(false);
         main.Ingresar(); //llamamos este metodo para que se habra el login de nuevo
     }
     public int GenerarNumero(){
         int num=0;
            Random r = new Random();
            num = (int) (Math.random() * 9999) + 1;
         
         return num;
     }
     
     //funcion para buscar la empresa en la base de datos claro si existe
     public void BuscarEmpre(String cod){
         Empresa emp = new Empresa(); //instanciamos la clase empresa 
          
             vista.jTextFieldnombre_empres.setText("");
             vista.jTextFieldtipo_empresa.setText("");
             vista.jComboBoxarea_empresa.setSelectedItem("");
             vista.jTextAreaqueja1.setText("");
             vista.jComboBoxestado_queja1.setSelectedItem(""); //limpiamos los jtext 
             vista.jTextAreaqueja2.setText("");
             vista.jComboBoxestado_queja2.setSelectedItem("");
             vista.jTextAreaqueja3.setText("");
             vista.jComboBoxestado_queja3.setSelectedItem("");
         
         emp = administrado.BuscarEmpres(cod); //instaciamos la funcion de la clase administrador dao para pasarle el objeto 
         if(emp == null){  //si en la base de datos no encuetra ese codigo
             JOptionPane.showMessageDialog(null,"El Codigo No Se Encuentra Registrado");//si el administrador digita un codigo que no esta en la base de datos
         }else{
             vista.jTextFieldnombre_empres.setText(emp.getNombreDeLaEmpresa());
             vista.jTextFieldtipo_empresa.setText(emp.getTipoDeEmpresa());
             vista.jComboBoxarea_empresa.setSelectedItem(emp.getAreaDeLaQueja());
             vista.jTextAreaqueja1.setText(emp.getQuejaOReclamo1());
             vista.jComboBoxestado_queja1.setSelectedItem(emp.getEstadoQueja1()); //mostramos todo los datos si el codigo existe
             vista.jTextAreaqueja2.setText(emp.getQuejaOReclamo2());
             vista.jComboBoxestado_queja2.setSelectedItem(emp.getEstadoQueja2());
             vista.jTextAreaqueja3.setText(emp.getQuejaOReclamo3());
             vista.jComboBoxestado_queja3.setSelectedItem(emp.getEstadoQueja3());
         }
     }
     public boolean Buscar_Funcion(String nombre){
         boolean validar = false;
         contra="";
         Login log = new Login();
         log = administrado.BuscarFuncionario(nombre);
         if(log == null){
             JOptionPane.showMessageDialog(null,"No Existe Ese Funcionario");
         }else{
             validar = true;
             contra = log.getContrasena();
         }
         return validar;//System.out.println("Nombre: "+log.getNombre()+"\nContraseña: "+log.getContrasena());
     }
     
     public void MuestraAsignado(){
         List<Login> login = new ArrayList<Login>();
        Login log = new Login();
         login = administrado.Mostrar_Funcionarios();
         vista.jComboBoxAsignarFuncionario.removeAllItems();
         for(int i=0; i< login.size(); i++) {
            String lista = String.valueOf(login.get(i));
            vista.jComboBoxAsignarFuncionario.addItem(lista);      
        }
     }

    @Override
    public void actionPerformed(ActionEvent e) {  //aqui implemetamos el evento del click 
        if(e.getSource() == vista.jButtonRegistrar_empresa){ // si el administrador presiona el boton registrar 
            Agregar_Empresa(vista.jTextFieldcodigo_empresa.getText(),//llamamos la fubcion agregraempresa con todos sus parametros 
                            vista.jTextFieldnombre_empres.getText(),
                            vista.jTextFieldtipo_empresa.getText(),
                            vista.jComboBoxarea_empresa.getSelectedItem().toString(),
                            vista.jTextAreaqueja1.getText(),
                            vista.jComboBoxestado_queja1.getSelectedItem().toString(),
                            vista.jTextAreaqueja2.getText(),
                            vista.jComboBoxestado_queja2.getSelectedItem().toString(),
                            vista.jTextAreaqueja3.getText(),
                            vista.jComboBoxestado_queja3.getSelectedItem().toString());
        }else if(e.getSource() == vista.jButtonRegresarLogin){ //si el administrador presion el boton cerrar sesion 
            CerrarSesion(); //llamamos esta fubcion
        }else if(e.getSource() == vista.jButtonBuscar_por_codigo){ //si el usuario presiona el boton buscar 
            BuscarEmpre(vista.jTextFieldcodigo_empresa.getText());//llamamos la funcion bucarempresa
        }else if(e.getSource() == vista.jButtonAsignar){
            String nom = vista.jComboBoxAsignarFuncionario.getSelectedItem().toString();
            if(Buscar_Funcion(nom)){
            Agrgar_Solicitud(vista.jTextFieldnombre_empres.getText(), 
                             vista.jTextFieldcodigo_empresa.getText(),
                             vista.jComboBoxAsignarFuncionario.getSelectedItem().toString(), 
                             contra,GenerarNumero(),vista.jComboBoxestado_queja1.getSelectedItem().toString());
                
        }
      }
    }
    
     
}
