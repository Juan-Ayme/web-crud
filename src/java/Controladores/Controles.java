/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controladores;

import java.beans.*;
import java.io.Serializable;
import java.util.List;
import modelo.AlumnoDao;
import modelo.Estudiantes;


/**
 *
 * @author Maver
 */
public class Controles implements Serializable {
    
    AlumnoDao dao=new AlumnoDao();
    
    public List listarEstudiantes()
    {
        return  dao.listar();
    }
    public int guardarEs(String codigo, String nombre, String notaA, String notaB, String notaC, String asistencia)
    {
        return dao.guardar(new Estudiantes(codigo, nombre, Double.parseDouble(notaA) , Double.parseDouble(notaB), Double.parseDouble(notaC), Integer.parseInt(asistencia)));
    }
    public int eliminar(String codigo)
    {
        return dao.eliminar(codigo);
    }
    
    public int actualizarEs(String codigo, String nombre, String notaA, String notaB, String notaC, String asistencia)
    {
        return dao.actualizar(new Estudiantes(codigo, nombre, Double.parseDouble(notaA) , Double.parseDouble(notaB), Double.parseDouble(notaC), Integer.parseInt(asistencia)));
    }
    
    public Estudiantes listarEstudiante(String codigo)
    {
        return dao.listarCodigo(codigo);
    }
    
    public static final String PROP_SAMPLE_PROPERTY = "sampleProperty";
    
    private String sampleProperty;
    
    private PropertyChangeSupport propertySupport;
    
    public Controles() {
        propertySupport = new PropertyChangeSupport(this);
    }
    
    public String getSampleProperty() {
        return sampleProperty;
    }
    
    public void setSampleProperty(String value) {
        String oldValue = sampleProperty;
        sampleProperty = value;
        propertySupport.firePropertyChange(PROP_SAMPLE_PROPERTY, oldValue, sampleProperty);
    }
    
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertySupport.addPropertyChangeListener(listener);
    }
    
    public void removePropertyChangeListener(PropertyChangeListener listener) {
        propertySupport.removePropertyChangeListener(listener);
    }
    
}
