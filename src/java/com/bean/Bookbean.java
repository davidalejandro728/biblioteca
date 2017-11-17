/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.bean;

import com.dbo.Dbcontroller;
import com.logic.Booklogic;
import com.models.Books;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
@ManagedBean
@ViewScoped
/**
 *
 * @author Lenovo
 */
public final class Bookbean {
    private Books book;
    private List<Books> listBook;
    private Books selectedBook;
    private Booklogic bookLogic;

    public Books getBook() {
        return book;
    }

    public void setBook(Books book) {
        this.book = book;
    }

    public List<Books> getListBook() {
        return listBook;
    }

    public void setListBook(List<Books> listBook) {
        this.listBook = listBook;
    }

    public Books getSelectedBook() {
        return selectedBook;
    }

    public void setSelectedBook(Books selectedBook) {
        this.selectedBook = selectedBook;
    }

    public Booklogic getBookLogic() {
        return bookLogic;
    }

    public void setBookLogic(Booklogic bookLogic) {
        this.bookLogic = bookLogic;
    }
    public void loadBooks(){
        listBook.addAll(bookLogic.loadBooks());
    
    }
       
    public Bookbean(){
    book= new Books();
    listBook = new ArrayList<>();
    bookLogic = new Booklogic();
    loadBooks();
    }
    public void addBooks(){
        bookLogic.addBooks(book);
        listBook.clear();
        loadBooks();
        }
    public void editBooks(Books selectedBook){
        bookLogic.editBooks(selectedBook);
        listBook.clear();
        loadBooks();
        }
    public void deleteBook(){
        bookLogic.deleteBook(book);
        listBook.clear();
        loadBooks();
        }
   
    
    
}
