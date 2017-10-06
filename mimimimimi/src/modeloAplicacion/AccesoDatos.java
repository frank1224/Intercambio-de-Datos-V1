package modeloAplicacion;

import java.io.BufferedWriter;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import vistaAplicacion.V_RegistrarLugar;

public interface AccesoDatos {

	public void addOne(String [] datos );
	
	public String[][] leeTodos();
	
	public void escribeTodos(String[][] listaDatos);
	

}
