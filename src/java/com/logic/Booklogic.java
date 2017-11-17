/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.logic;

import com.dbo.Dbcontroller;
import com.models.Books;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author Lenovo
 */
public class Booklogic {
    Dbcontroller dbc;
    
    public Booklogic(){
    
    dbc= new Dbcontroller();
    }
    public List<Books> loadBooks(){
    List<Books> books = new ArrayList<>();
    books.addAll(dbc.loadBooks());
    return books;
    
    }
    
    public void addBooks(Books book)
    {
    if(dbc.addBook(book))
    {
        System.out.println("Succesfull Add");
    }
    else{
            System.out.println("Failled");
    }
    
    }
    public void deleteBook(Books book)
    {
        if(dbc.deleteBook(book)){
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null,new FacesMessage("Succesful","Deleted Ok"));
        
        }else{
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null,new FacesMessage("Failed", "Deleted Fail"));
        }
    
    }
    public void editBooks(Books book)
    {
    if(dbc.editBook(book))
    {
        System.out.println("Succesfull Edit");
    }
    else{
            System.out.println("Failled");
    }
    
    }
   
    
}
