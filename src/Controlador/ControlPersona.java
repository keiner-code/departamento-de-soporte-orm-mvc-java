/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;
import Vista.RegistrarseLogin;
import Vista.LoginVista;
import Modelo.*;
import Vista.*;
import departamento.de.soporte.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author KEINER
 */

//clase para el login y registro de usuarios
public class ControlPersona implements ActionListener{  //implementamos la (interfaz = que es una clase no tiene que ver con nada grafico) y heredamos toda la clase Actionlistener para capturar los click del mouse
    LoginVista loginvista = new LoginVista(); //instanciamos la parte grafica del login 
    RegistrarseLogin registrar = new RegistrarseLogin(); //instanciamos la clase registrarse
    LoginDAO logindao = new LoginDAO(); //instanciamos la conexion a la base de datos
    Login login = new Login(); //instanciamos la clase de los metodos getter y setter
    DepartamentoDeSoporte main = new DepartamentoDeSoporte(); // instanciamos el main 
    ControlSolicitudes solicitud = new ControlSolicitudes();
    int intentos=0; //contador

    public ControlPersona(RegistrarseLogin regi, LoginDAO logidao){ //constructor para el registro de usuarios
        this.logindao = logidao;
        this.registrar = regi;
        //this.loginvista = log;
        //loginvista.jButtoningresarlogin.addActionListener(this);
        registrar.jButton1reguistrarpersona.addActionListener(this);
        registrar.jButtonRegresar.addActionListener(this);
    }   //constructor
    public ControlPersona(LoginVista log,LoginDAO logdao){ //constructor para para iniciar session en el login 
        this.loginvista = log;
        this.logindao = logdao;
        loginvista.jButtoningresarlogin.addActionListener(this);
        loginvista.jButtonregistrarse.addActionListener(this);
    } //constructor
    
    //funcion para registrar los usuarios en la base de datos 
    public void AgregarPer(String nombre, String contraseña, String tipocuenta,String apellido){
        Empresa empresa = new Empresa();
        Login login = new Login();
        login.setNombre(nombre);    
        login.setContrasena(contraseña);
        login.setTipoCuenta(tipocuenta);
        login.setApellido(apellido); 
        logindao.AgregarPersona(login);
    }  
    
    //funcion para comprobar si el usuario existe en la base de datos 
    public void BuscarUsuario(String contr){
        Login usuario = new Login();
        
        usuario = logindao.BuscarUsuario(contr);
        
        if(usuario == null){
            JOptionPane.showMessageDialog(null,"El Usuario No existe");
                 intentos += 1; //contador sirve para si el usuario ingresa la contraseña o el nombre de usuario mal tres veces 
                 if(intentos == 3){//entra a esta condicion 
                     JOptionPane.showMessageDialog(null,"Si Ingresa El Usuario 0 La Contraseña !!Mal!! De Nuevo Sera Enviado A Registrarse");
                 }else if(intentos == 4){ //si la ingresa por cuarta ves mal sera enviado a que se registre
                     main.Registrarse();
                 }
        }else{
            JOptionPane.showMessageDialog(null,"Bienvenido "+usuario.getNombre()+" "+usuario.getApellido());//Esta parte es donde hasta el momento tenemos pensados donde pondaran las quejas y eso todavia no esta terminada
            main.GestionSolicitud();  
        }
    } 
    
    //funcion para comprobar si el usuario pone un numero en su nombre
    public boolean Letra(char ltr){
         boolean letra=false;
             if(ltr != 'a' && ltr != 'b' && ltr != 'c' && ltr != 'd' && ltr != 'e' && ltr != 'f' &&
                ltr != 'g' && ltr != 'h' && ltr != 'i' && ltr != 'j' && ltr != 'k' && ltr != 'l' &&
                ltr != 'm' && ltr != 'n' && ltr != 'ñ' && ltr != 'o' && ltr != 'p' && ltr != 'q' &&
                ltr != 'r' && ltr != 's' && ltr != 't' && ltr != 'u' && ltr != 'v' && ltr != 'w' &&
                ltr != 'x' && ltr != 'y' && ltr != 'z'){
                 letra = true;
             }
             return letra;
     }  

    @Override
    public void actionPerformed(ActionEvent e) { //aqui implemetamos el evento del click 
          if(e.getSource() == registrar.jButton1reguistrarpersona){ //si el usuario presiona el boton registrar 
              AgregarPer(registrar.jTextField1nombreRegistro.getText(), 
                         registrar.jTextField2contraseñaregistro.getText(),
                         registrar.jComboBox1tipodecuenta.getSelectedItem().toString(),
                         registrar.jTextField3Apellidoreguistro.getText());
              
          }else if(e.getSource() == loginvista.jButtoningresarlogin){ //si el usuario presiona el boton ingresar 
              String nombre = loginvista.jTextField1NombreLogin.getText();
              String contra = loginvista.jTextField2Contraseñalogin.getText();
                  int sw =0;
                  String admin = "admin",password = "1234567"; //la clave y la contraseña del adminsitrador
                  
                 if(nombre.equals(admin) && contra.equals(password)){ //si en el login se escribe la clave y la contraseña del administrado
                     main.Administrador();  //llamamos la parte grafica del administrador
                     loginvista.setVisible(false); //cerramos el login
                     sw =1; //ponemos el swich en uno para que no entre en la condicion de abajo
                 }
                
                 else if(nombre.isEmpty()){  //aqui validamos que el nombre no este vacio
                     JOptionPane.showMessageDialog(null,"Por Favor Ingrese El Nombre");
                 }else if(nombre.length() > 1 && nombre.length() < 2){ //aqui validamos que el usuario ingrese mas de dos letras
                     JOptionPane.showMessageDialog(null,"El Nombre Debe De Tener Mas De dos Caracteres");
                 }else if(true){ //aqui siempre entrara
                     char cadena; 
                      for (int i = 0; i < nombre.length(); i++) { //bucle para reccorer el nombre letra por letra
                         cadena = nombre.charAt(i);//convertimos de String a char  y lo enviamos a la funcion para comprobar que el
                         if(Letra(cadena)){ //usuario no aiga ingresado letra en el nombre
                            JOptionPane.showMessageDialog(null,"El Nombre Contiene Un Numero: ("+cadena+") Por Favor Ingrese Un Nombre Valido"); 
                         }
                     }
                 }
                  if(contra.isEmpty()){ //si la contraseña esta vacia 
                     JOptionPane.showMessageDialog(null,"Por Favor Ingrese La Contraseña ");
                 }else if(contra.length() <= 6){ //la contraseña debe de tener mas de 6 caracteres
                     JOptionPane.showMessageDialog(null,"La Contraseña Debe Tener Mas De 6 Caracteres");
                 }
                 else if(sw == 0){ //si todo esas condiciones se cumple llamamos la funcion Buscar usuario
                     BuscarUsuario(loginvista.jTextField2Contraseñalogin.getText()); //para ver si esta registrado
                 }    
          }else if(e.getSource() == loginvista.jButtonregistrarse){ //si el usuario presiona el boton registrar 
              loginvista.setVisible(false);
              main.Registrarse();
              
          }else if(e.getSource() == registrar.jButtonRegresar){ //si el usuario presiona el boton regresar lo lleva al login
              registrar.setVisible(false);
              main.Ingresar();
          }
    } 
}

