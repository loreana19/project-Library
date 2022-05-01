/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author LORA
 */
public class Book implements GenericEntity{
    private Long bookID;
    private String name;
    private Librarian librarian;
    private BookGenre bookGenre;
    private List<Author> authors;
    private List<BookCopy> bookcopies;

    public Book() {
    }

    public Book(Long bookID, String name, Librarian librarian, BookGenre bookGenre, List<Author> authors, List<BookCopy> bookcopies) {
        this.bookID = bookID;
        this.name = name;
        this.librarian = librarian;
        this.bookGenre = bookGenre;
        this.authors = authors;
        this.bookcopies = bookcopies;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public List<BookCopy> getBookcopies() {
        return bookcopies;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    public void setBookcopies(List<BookCopy> bookcopies) {
        this.bookcopies = bookcopies;
    }

   

    public BookGenre getBookGenre() {
        return bookGenre;
    }

    public void setBookGenre(BookGenre bookGenre) {
        this.bookGenre = bookGenre;
    }

    public Long getBookID() {
        return bookID;
    }

    public void setBookID(Long bookID) {
        this.bookID = bookID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Librarian getLibrarian() {
        return librarian;
    }

    public void setLibrarian(Librarian librarian) {
        this.librarian = librarian;
    }

    @Override
    public String toString() {
        return name;
        
    }

    @Override
    public int hashCode() {
        int hash = 3;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Book other = (Book) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.bookID, other.bookID)) {
            return false;
        }
        return true;
    }

    @Override
    public String getTableName() {
        return "book";
    }

    @Override
    public String getColumnNamesForInsert() {
        return "Name, LibrarianID, BookGenreID";
    }

    @Override
    public String getInsertedValues() {
        StringBuilder sb=new StringBuilder();
        sb.append("'").append(name).append("'").append(", ")
                .append(librarian.getLibrarianID()).append(", ")
                .append(bookGenre.getBookGenreID());
        return sb.toString();
    }

    @Override
    public String getWhereClauseDeleteEdit() {
        return "BookID="+bookID;
    }

    @Override
    public String getJoinClause() {
        return " librarian lib ON lib.LibrarianID=b.LibrarianID JOIN bookgenre bg ON bg.BookGenreID=b.BookGenreID ";
    }

    @Override
    public String getColumnNamesForGetAll() {
        return " b.BookID, b.Name, lib.LibrarianID, lib.FirstName, lib.LastName, lib.Username, bg.BookGenreID, bg.Name ";
    }

    @Override
    public String getWhereForGetAll() {
        
        return null;
    }

    @Override
    public String getColumnNamesValuesUpdate() {
        StringBuilder sb=new StringBuilder();
        sb.append(" name='").append(name).append("' ,")
                .append(" LibrarianID=").append(librarian.getLibrarianID()).append(", ")
                .append(" BookGenreID=").append(bookGenre.getBookGenreID()).append(" ");
        return sb.toString();
        
    }

    @Override
    public void setId(Long id) {
        bookID=id;
    }

    @Override
    public String getAlias() {
        return "b";
    }
    
    
    
}
