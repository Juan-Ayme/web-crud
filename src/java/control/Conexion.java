package control;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion 
{
    
    private static Connection conecta;
    private static final String DRIVER="org.postgresql.Driver";
    private static final String URL="jdbc:postgresql://localhost:5432/bd_alumnos";
    private static final String USER="postgres";
    private static final String PASSWORD="root";
    
    public static Connection conectar()
    {
        try 
        {
            Class.forName(DRIVER);
            conecta=DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (Exception e) 
        {
            e.printStackTrace(System.out);
        }
        return conecta;
    }
}
