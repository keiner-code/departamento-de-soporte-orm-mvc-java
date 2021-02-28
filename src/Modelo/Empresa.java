package Modelo;
// Generated 14-may-2018 17:34:17 by Hibernate Tools 4.3.1



/**
 * Empresa generated by hbm2java
 */
public class Empresa  implements java.io.Serializable {


     private String codigo;
     private String nombreDeLaEmpresa;
     private String tipoDeEmpresa;
     private String areaDeLaQueja;
     private String quejaOReclamo1;
     private String estadoQueja1;
     private String quejaOReclamo2;
     private String estadoQueja2;
     private String quejaOReclamo3;
     private String estadoQueja3;

    public Empresa() {
    }

	
    public Empresa(String codigo) {
        this.codigo = codigo;
    }
    public Empresa(String codigo, String nombreDeLaEmpresa, String tipoDeEmpresa, String areaDeLaQueja, String quejaOReclamo1, String estadoQueja1, String quejaOReclamo2, String estadoQueja2, String quejaOReclamo3, String estadoQueja3) {
       this.codigo = codigo;
       this.nombreDeLaEmpresa = nombreDeLaEmpresa;
       this.tipoDeEmpresa = tipoDeEmpresa;
       this.areaDeLaQueja = areaDeLaQueja;
       this.quejaOReclamo1 = quejaOReclamo1;
       this.estadoQueja1 = estadoQueja1;
       this.quejaOReclamo2 = quejaOReclamo2;
       this.estadoQueja2 = estadoQueja2;
       this.quejaOReclamo3 = quejaOReclamo3;
       this.estadoQueja3 = estadoQueja3;
    }
   
    public String getCodigo() {
        return this.codigo;
    }
    
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    public String getNombreDeLaEmpresa() {
        return this.nombreDeLaEmpresa;
    }
    
    public void setNombreDeLaEmpresa(String nombreDeLaEmpresa) {
        this.nombreDeLaEmpresa = nombreDeLaEmpresa;
    }
    public String getTipoDeEmpresa() {
        return this.tipoDeEmpresa;
    }
    
    public void setTipoDeEmpresa(String tipoDeEmpresa) {
        this.tipoDeEmpresa = tipoDeEmpresa;
    }
    public String getAreaDeLaQueja() {
        return this.areaDeLaQueja;
    }
    
    public void setAreaDeLaQueja(String areaDeLaQueja) {
        this.areaDeLaQueja = areaDeLaQueja;
    }
    public String getQuejaOReclamo1() {
        return this.quejaOReclamo1;
    }
    
    public void setQuejaOReclamo1(String quejaOReclamo1) {
        this.quejaOReclamo1 = quejaOReclamo1;
    }
    public String getEstadoQueja1() {
        return this.estadoQueja1;
    }
    
    public void setEstadoQueja1(String estadoQueja1) {
        this.estadoQueja1 = estadoQueja1;
    }
    public String getQuejaOReclamo2() {
        return this.quejaOReclamo2;
    }
    
    public void setQuejaOReclamo2(String quejaOReclamo2) {
        this.quejaOReclamo2 = quejaOReclamo2;
    }
    public String getEstadoQueja2() {
        return this.estadoQueja2;
    }
    
    public void setEstadoQueja2(String estadoQueja2) {
        this.estadoQueja2 = estadoQueja2;
    }
    public String getQuejaOReclamo3() {
        return this.quejaOReclamo3;
    }
    
    public void setQuejaOReclamo3(String quejaOReclamo3) {
        this.quejaOReclamo3 = quejaOReclamo3;
    }
    public String getEstadoQueja3() {
        return this.estadoQueja3;
    }
    
    public void setEstadoQueja3(String estadoQueja3) {
        this.estadoQueja3 = estadoQueja3;
    }

}


