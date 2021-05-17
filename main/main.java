package main;

import server.*;

import java.sql.SQLException;

import db.*;

public class main {

	public static void main(String[] args) {
		
		JavaOracleTest.startDB();
		JavaHttpServer.startServer();
		//AdminGUI
		//Query Transaction(Mit Commit und Rollback)
				
				Runtime.getRuntime().addShutdownHook(new Thread() //this codes run when server is getting closed and removes connection
				{
				    @Override
				    public void run()
				    {
				        try {
							JavaOracleTest.connection.close();
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
				    }
				    
				});
	}

}
