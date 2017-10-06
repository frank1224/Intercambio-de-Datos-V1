package modeloAplicacion;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class FileManager implements AccesoDatos {

	private Connection connect;
	
	@Override
	public void addOne(String[] datos) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String[][] leeTodos() {
		String[][] auxiliar = null;
		
		
		// SELECT * de lugares
		try {
			String query = "Select * from proteccioncivil.instalacion";
			Statement stmt = connect.createStatement();
			ResultSet rset = stmt.executeQuery(query);
			ResultSetMetaData rmsd = rset.getMetaData();

			rset.last();
			int a = rmsd.getColumnCount();
			int b = rset.getRow();
			rset.beforeFirst();

			auxiliar = new String[b][a];
			for (int i = 0; i < b; i++) {
				if (rset.next()) {
					for (int j = 0; j < a; j++) {
						auxiliar[i][j] = rset.getString((j + 1));
					}
				}
			}
			rset.close();
			stmt.close();
		} catch (SQLException s) {
			s.printStackTrace();
		}
		// Recorrer y resultset y meter los datos en auxiliar
		// TODO Auto-generated method stub
		
		return auxiliar;
	}
	

	@Override
	public void escribeTodos(String[][] listaDatos) {
		Writer writer = null;

		try {
		    writer = new BufferedWriter(new OutputStreamWriter(
		          new FileOutputStream("datos.txt"), "utf-8"));
		    writer.write("Codigo: ");
		    ((BufferedWriter) writer).newLine();
		    writer.write("Nombre: ");
		    ((BufferedWriter) writer).newLine();
		    writer.write("Direccion: ");
		    ((BufferedWriter) writer).newLine();
		    writer.write("Telefono: ");
		    
		} catch (IOException ex) {
		  // report
		} finally {
		   try {writer.close();} catch (Exception ex) {/*ignore*/}
		}
	
		return;
		// TODO Auto-generalited method stub
		
	}

}
