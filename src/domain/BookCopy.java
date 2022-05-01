/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author LORA
 */
public class BookCopy implements GenericEntity{
    private Long bookCopyID;
    private int publicationYear;
    private boolean available;
    private Book book;

    public BookCopy() {
    }

    public BookCopy(Long bookCopyID, int publicationYear, boolean  available, Book book) {
        this.bookCopyID = bookCopyID;
        this.publicationYear = publicationYear;
        this.available=available;
        this.book = book;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
    

    public Long getBookCopyID() {
        return bookCopyID;
    }

    public void setBookCopyID(Long bookCopyID) {
        this.bookCopyID = bookCopyID;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }

    @Override
    public String toString() {
        return book.getName()+" "+publicationYear+" "+isAvailable();
    }

    @Override
    public String getTableName() {
        return "bookcopy";
    }

    @Override
    public String getColumnNamesForInsert() {
        return "PublicityYear, BookID, Available";
    }

    @Override
    public String getInsertedValues() {
        StringBuilder sb=new StringBuilder();
        sb.append(publicationYear).append(", ")
                .append(book.getBookID()).append(", ")
                .append(available);
        return  sb.toString();
    }

    @Override
    public String getWhereClauseDeleteEdit() {
        return "BookCopyID="+bookCopyID;
    }

    @Override
    public String getJoinClause() {
        return " book b ON b.BookID=bc.BookID JOIN librarian lib ON lib.LibrarianID=b.LibrarianID JOIN bookgenre bg ON bg.BookGenreID=b.BookGenreID";
    }

    @Override
    public String getColumnNamesForGetAll() {
        return "  b.BookID, b.Name, lib.LibrarianID, lib.FirstName, lib.LastName, lib.Username, bg.BookGenreID, bg.Name, bc.BookCopyID, bc.PublicityYear, bc.Available ";
    }

    @Override
    public String getWhereForGetAll() {
        return null;
    }

    @Override
    public String getColumnNamesValuesUpdate() {
        StringBuilder sb=new StringBuilder();
        sb.append(" PublicityYear=").append(publicationYear).append(", BookID=").append(book.getBookID()).append(", Available=").append(available).append(" ");
        return sb.toString();
    }

    @Override
    public void setId(Long id) {
        bookCopyID=id;
    }

    @Override
    public String getAlias() {
        return "bc";
      }

    @Override
    public int hashCode() {
        int hash = 5;
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
        final BookCopy other = (BookCopy) obj;
        if (this.publicationYear != other.publicationYear) {
            return false;
        }
        if (!Objects.equals(this.bookCopyID, other.bookCopyID)) {
            return false;
        }
        if (!Objects.equals(this.book, other.book)) {
            return false;
        }
        return true;
    }
    
    
}
