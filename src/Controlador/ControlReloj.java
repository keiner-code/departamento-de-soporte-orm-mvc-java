/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;
import Vista.*;
import java.util.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Keiner
 */
public class ControlReloj implements Runnable{
     private String hora;
     private String minuto;
     private String segundo;
     private String ampm;
     Calendar calendario;
     Thread hilo;
     Reloj reloj_vista = new Reloj();
     
    public ControlReloj() {
    }
    
    
    public void Iniciar(){
       hilo = new Thread(this);
       hilo.start();   
       reloj_vista.setLocationRelativeTo(null);
       reloj_vista.setTitle("Tiempo De Respuesta");
       reloj_vista.setVisible(true);
    }

    @Override
    public void run() {
       Thread ct = Thread.currentThread();
         
           while(ct == hilo){
               Calcular();
               reloj_vista.jLabel1Relog.setText(hora+":"+minuto+":"+segundo+" "+ampm);
               try {
                   Thread.sleep(1000);
               } catch (Exception e) {
               }
          }
    }
    public void Hora(){
        Calcular();
        JOptionPane.showMessageDialog(null,"Hora Actual "+hora+":"+minuto+":"+segundo+" "+ampm);
        int hor=0,min=0;
        
        if(Integer.parseInt(minuto) < 44){
             min = Integer.parseInt(minuto)+15;
            JOptionPane.showMessageDialog(null,"Tiene hasta las: "+hora+":"+min+":"+segundo+" Para Atender Esta Solicitud");
        }else if(Integer.parseInt(minuto) == 45){ 
             hor = Integer.parseInt(hora) +1; 
            minuto = "01";
            JOptionPane.showMessageDialog(null,"Tiene hasta las: "+hor+":"+minuto+": "+segundo+" Para Atender Esta Solicitud");
        }else if(Integer.parseInt(minuto) == 46){
             hor = Integer.parseInt(hora) +1; 
            minuto = "02";
            JOptionPane.showMessageDialog(null,"Tiene hasta las: "+hor+":"+minuto+": "+segundo+" Para Atender Esta Solicitud");
        }else if(Integer.parseInt(minuto) == 47){
             hor = Integer.parseInt(hora) +1; 
            minuto = "03";
            JOptionPane.showMessageDialog(null,"Tiene hasta las: "+hor+":"+minuto+": "+segundo+" Para Atender Esta Solicitud");
        }else if(Integer.parseInt(minuto) == 48){
             hor = Integer.parseInt(hora) +1; 
            minuto = "04";
            JOptionPane.showMessageDialog(null,"Tiene hasta las: "+hor+":"+minuto+": "+segundo+" Para Atender Esta Solicitud");
        }else if(Integer.parseInt(minuto) == 49){
             hor = Integer.parseInt(hora) +1; 
            minuto = "05";
            JOptionPane.showMessageDialog(null,"Tiene hasta las: "+hor+":"+minuto+": "+segundo+" Para Atender Esta Solicitud");
        }else if(Integer.parseInt(minuto) == 50){
             hor = Integer.parseInt(hora) +1; 
            minuto = "06";
            JOptionPane.showMessageDialog(null,"Tiene hasta las: "+hor+":"+minuto+": "+segundo+" Para Atender Esta Solicitud");
        }else if(Integer.parseInt(minuto) == 51){
             hor = Integer.parseInt(hora) +1; 
            minuto = "07";
            JOptionPane.showMessageDialog(null,"Tiene hasta las: "+hor+":"+minuto+": "+segundo+" Para Atender Esta Solicitud");
        }else if(Integer.parseInt(minuto) == 52){
             hor = Integer.parseInt(hora) +1; 
            minuto = "08";
            JOptionPane.showMessageDialog(null,"Tiene hasta las: "+hor+":"+minuto+": "+segundo+" Para Atender Esta Solicitud");
        }else if(Integer.parseInt(minuto) == 53){
             hor = Integer.parseInt(hora) +1; 
            minuto = "09";
            JOptionPane.showMessageDialog(null,"Tiene hasta las: "+hor+":"+minuto+": "+segundo+" Para Atender Esta Solicitud");
        }else if(Integer.parseInt(minuto) == 54){
             hor = Integer.parseInt(hora) +1; 
            minuto = "10";
            JOptionPane.showMessageDialog(null,"Tiene hasta las: "+hor+":"+minuto+": "+segundo+" Para Atender Esta Solicitud");
        }else if(Integer.parseInt(minuto) == 55){
             hor = Integer.parseInt(hora) +1; 
            minuto = "11";
            JOptionPane.showMessageDialog(null,"Tiene hasta las: "+hor+":"+minuto+": "+segundo+" Para Atender Esta Solicitud");
        }else if(Integer.parseInt(minuto) == 56){
             hor = Integer.parseInt(hora) +1; 
            minuto = "12";
            JOptionPane.showMessageDialog(null,"Tiene hasta las: "+hor+":"+minuto+": "+segundo+" Para Atender Esta Solicitud");
        }else if(Integer.parseInt(minuto) == 57){
             hor = Integer.parseInt(hora) +1; 
            minuto = "13";
            JOptionPane.showMessageDialog(null,"Tiene hasta las: "+hor+":"+minuto+": "+segundo+" Para Atender Esta Solicitud");
        }else if(Integer.parseInt(minuto) == 58){
             hor = Integer.parseInt(hora) +1; 
            minuto = "14";
            JOptionPane.showMessageDialog(null,"Tiene hasta las: "+hor+":"+minuto+": "+segundo+" Para Atender Esta Solicitud");
        }else if(Integer.parseInt(minuto) == 59){
             hor = Integer.parseInt(hora) +1; 
            minuto = "15";
            JOptionPane.showMessageDialog(null,"Tiene hasta las: "+hor+":"+minuto+": "+segundo+" Para Atender Esta Solicitud");
        }
    }

   public void Calcular() {
       
        Calendar calendario = new GregorianCalendar();
        Date fechaHoraActual = new Date();
        calendario.setTime(fechaHoraActual);
        ampm = calendario.get(Calendar.AM_PM) == Calendar.AM?"AM":"PM";
        
        if(ampm.equals("PM")){
           int ho = calendario.get(Calendar.HOUR_OF_DAY)-12;
           hora = ho>9?""+ho:"0"+ho;
        }else{
            hora = calendario.get(Calendar.HOUR_OF_DAY)>9?""+calendario.get(Calendar.HOUR_OF_DAY):"0"+calendario.get(Calendar.HOUR_OF_DAY);
        }
        minuto = calendario.get(Calendar.MINUTE)>9?""+calendario.get(Calendar.MINUTE):"0"+calendario.get(Calendar.MINUTE);
        segundo = calendario.get(Calendar.SECOND)>9?""+calendario.get(Calendar.SECOND):"0"+calendario.get(Calendar.SECOND);
    }
    
    
    
}
