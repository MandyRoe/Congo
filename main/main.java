package main;

import server.*;
import db.*;

public class main {

	public static void main(String[] args) {
		
		JavaOracleTest.startDB();
		JavaHttpServer.startServer();

	}

}
