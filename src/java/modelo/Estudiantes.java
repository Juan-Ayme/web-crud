/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo;

/**
 *
 * @author Maver
 */
public class Estudiantes 
{
   private String codigo,nombre;
   private double notaA,notaB,notaC,Promedio;
   private int asistencia;

    
   public Estudiantes()
   {
       
   }
    public Estudiantes(String codigo, String nombre, double notaA, double notaB, double notaC, double Promedio, int asistencia) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.notaA = notaA;
        this.notaB = notaB;
        this.notaC = notaC;
        this.Promedio = Promedio;
        this.asistencia = asistencia;
    }
    public Estudiantes(String codigo, String nombre, double notaA, double notaB, double notaC, int asistencia) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.notaA = notaA;
        this.notaB = notaB;
        this.notaC = notaC;
        this.asistencia = asistencia;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getNotaA() {
        return notaA;
    }

    public void setNotaA(double notaA) {
        this.notaA = notaA;
    }

    public double getNotaB() {
        return notaB;
    }

    public void setNotaB(double notaB) {
        this.notaB = notaB;
    }

    public double getNotaC() {
        return notaC;
    }

    public void setNotaC(double notaC) {
        this.notaC = notaC;
    }

    public double getPromedio() {
        return Promedio;
    }

    public void setPromedio(double Promedio) {
        this.Promedio = Promedio;
    }

    public int getAsistencia() {
        return asistencia;
    }

    public void setAsistencia(int asistencia) {
        this.asistencia = asistencia;
    }
    
   
    
    
}
