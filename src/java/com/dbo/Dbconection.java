/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dbo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Lenovo
 */
public class Dbconection {
   public Connection conexion(){
    String url = "jdbc:mysql://localhost:3306/bibliotecabd?zeroDateTimeBehavior=convertToNull";
    String usuario ="root";
    String password ="";
    Connection conexion = null;
    try{
    Class.forName("com.mysql.jdbc.Driver");
    conexion = DriverManager.getConnection(url, usuario, password);
            
    } catch(ClassNotFoundException | SQLException e){
    System.out.println("ERROR"+ e.getMessage());
    }
    return conexion;
    }  
}
