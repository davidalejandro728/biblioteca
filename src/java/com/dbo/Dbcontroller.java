/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dbo;

import com.models.Books;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Lenovo
 */
public class Dbcontroller {

    public static Books readID() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    Dbconection con;
    Connection cn;
    PreparedStatement st;
    
    public Dbcontroller(){
    con = new Dbconection();
    }
    public List<Books> loadBooks(){
        
        List<Books> books = new ArrayList<>();
        ResultSet rs= null;
        try{
            cn=con.conexion();
            String query="SELECT *FROM editorial ORDER by title";
            st=cn.prepareCall(query);
            rs = st.executeQuery();
                    
                while(rs.next()){
                Books book = new Books();
                book.setId(rs.getInt("ID"));
                book.setIsbn(rs.getString("isbn"));
                book.setTitle(rs.getString("title"));
                book.setType(rs.getString("type"));
                book.setPrice(rs.getFloat("price"));
                
                books.add(book);
                }
                    if(!cn.isClosed())
                        {
                            cn.close();
                        }
                    st.close();
                    rs.close();
        } catch(SQLException es)
            {
                System.out.print(es.toString());
            }
        return books;
    
    }
    public boolean addBook(Books book)
         {boolean rg = false;  
            try{
            cn= con.conexion();
            String query = "INSERT INTO editorial(isbn,title,type,price)VALUES(?,?,?,?)";
            st= cn.prepareCall(query);
            st.setString(1, book.getIsbn());
            st.setString(2, book.getTitle());
            st.setString(3, book.getType());
            st.setFloat(4, book.getPrice());
            st.execute();
            rg = true;
                
                if(!cn.isClosed())
                    {
                        cn.close();
                    }
                st.close();
            }
                
         
         catch (SQLException es )
         {
                 System.out.print(es.toString());
         }
        return rg;
}
     public boolean deleteBook(Books book){
    boolean rg =false;
    try{
    cn= con.conexion();
    String query ="DELETE FROM editorial WHERE isbn = ?";
    st=cn.prepareCall(query);
    st.setString(1,book.getIsbn());
    st.execute();
    rg = true;
    
    if(!cn.isClosed()){
    cn.close();
    }
    st.close();
    }catch(SQLException es){
            System.out.print(es.toString());
            }
            
        return rg;
    
    }
    
   public boolean editBook(Books book)  
   {
       boolean rg= false;
       try{
           cn=con.conexion();
           String query ="UPDATE editorial SET isbn=?,title=?,type=?,price=? WHERE ID=?";
           st=cn.prepareCall(query);
           st.setString(1, book.getIsbn());
           st.setString(2, book.getTitle());
           st.setString(3, book.getType());
           st.setFloat(4, book.getPrice());
           st.setInt(5, book.getId());
           st.execute();
           rg=true;
            if(!cn.isClosed())
            {
                cn.close();
            
                }
                st.close();
    }catch(SQLException es){
            System.out.print(es.toString());
            }
            
        return rg;
}
   
}
   
   
   
   
