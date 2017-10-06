package modeloAplicacion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import modeloAplicacion.Modelo;

public class BDManager implements AccesoDatos {

	private Connection connect;






@Override
public void addOne(java.lang.String[] datos) {
	// TODO Auto-generated method stub
	
}

@Override
public java.lang.String[][] leeTodos() {
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
public void escribeTodos(java.lang.String[][] listaDatos) {
	listaDatos.toString();
	// TODO Auto-generated method stub
	
}

}




