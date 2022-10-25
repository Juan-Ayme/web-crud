package modelo;


import control.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class AlumnoDao
{
    PreparedStatement ps;
    int validar;
    
    public List listar()
    {
        String sql="select * from alumnos";
        ResultSet rs;
        
        List<Alumnos> alumnos=new ArrayList<>();
        
        try 
        {
            ps=Conexion.conectar().prepareStatement(sql);
            rs=ps.executeQuery();
            
            while(rs.next())
            {
               Alumnos alumno=new Alumnos();
               alumno.setCodigo(rs.getString(1));
               alumno.setNombre(rs.getString(2));
               alumno.setNotaA(rs.getDouble(3));
               alumno.setNotaB(rs.getDouble(4));
               alumno.setNotaC(rs.getDouble(5));
               alumno.setPromedio(promedio(alumno));
               alumno.setAsistencia(rs.getInt(7));
               
               alumnos.add(alumno);
               System.out.println("promedio: "+alumno.getPromedio());
            }
        } catch (Exception e) 
        {
            e.printStackTrace(System.out);
        }
        
        
        return alumnos;
    }

    public int guardar(Alumnos alumno)
    {
        String sql="insert into alumnos values(?,?,?,?,?,?,?)";
        try 
        {
            ps=Conexion.conectar().prepareStatement(sql);
            ps.setString(1, alumno.getCodigo());
            ps.setString(2, alumno.getNombre());
            ps.setDouble(3, alumno.getNotaA());
            ps.setDouble(4, alumno.getNotaB());
            ps.setDouble(5, alumno.getNotaC());
            ps.setDouble(6, promedio(alumno));
            ps.setInt(7, alumno.getAsistencia());
            validar=ps.executeUpdate();
            System.out.println("Creacion ");
            
        } catch (Exception e)
        {
            e.printStackTrace(System.out);
        }
        
        return validar;
    }
    
    public int eliminar(String codigo)
    {
        String sql="delete from alumnos where id_alumno=?";
        try 
        {
            ps=Conexion.conectar().prepareStatement(sql);
            ps.setString(1, codigo);
            validar=ps.executeUpdate();
            System.out.println("Se elimino correctamente");
            
        } catch (Exception e)
        {
            e.printStackTrace(System.out);
        }
        
        return validar;
    }
    
    public int actualizar(Alumnos alumno)
    {
        String sql="update alumnos set nombre=?, notaa=?,notab=?,notac=?,promedio=?,asistencia=? where id_alumno=?";
        
        try 
        {
            ps=Conexion.conectar().prepareStatement(sql);
            ps.setString(1, alumno.getNombre());
            ps.setDouble(2, alumno.getNotaA());
            ps.setDouble(3, alumno.getNotaB());
            ps.setDouble(4, alumno.getNotaC());
            ps.setDouble(5, promedio(alumno));
            ps.setInt(6, alumno.getAsistencia());
            ps.setString(7, alumno.getCodigo());
            validar=ps.executeUpdate();
            
            System.out.println("Actualizacion exitosa");
        } catch (Exception e)
        {
            e.printStackTrace(System.out);
        }
        
        return validar;
    }
    
    
    //metodos para las funciones principales
    public double promedio(Alumnos alumno)
    {
       double promedio=(alumno.getNotaA()+alumno.getNotaB()+alumno.getNotaC())/3;
       return  Math.round(promedio); 
    } 
    
    
    
    
//    public static void main(String [] args)
//    {
//        Alumnos a=new Alumnos("2A","jose",15.9,15.8,12,8);
//        AlumnoDao dao=new AlumnoDao();
//        dao.guardar(a);
//    }
    
}
