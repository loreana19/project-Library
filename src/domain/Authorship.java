/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.io.Serializable;

/**
 *
 * @author LORA
 */
public class Authorship implements GenericEntity{
    private Book book;
    private Author author;
    private int serialNumber;

    public Authorship() {
    }

    public Authorship(Book book, Author author, int serialNumber) {
        this.book = book;
        this.author = author;
        this.serialNumber = serialNumber;
    }

    public int getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(int serialNumber) {
        this.serialNumber = serialNumber;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    @Override
    public String getTableName() {
        return "authorship";
    }

    @Override
    public String getColumnNamesForInsert() {
        return "BookID, AuthorID, SerialNumber";
    }

    @Override
    public String getInsertedValues() {
        StringBuilder sb=new StringBuilder();
        sb.append(book.getBookID()).append(", ")
                .append(author.getAuthorID()).append(", ")
                .append(serialNumber);
        
        return sb.toString();
    }

    @Override
    public String getWhereClauseDeleteEdit() {
        return null;
    }

    @Override
    public String getJoinClause() {
        return " book b ON b.BookID=ash.BookID JOIN author a ON a.AuthorID=ash.AuthorID JOIN librarian lib ON lib.LibrarianID=b.LibrarianID JOIN BookGenre bg ON bg.BookGenreID=b.BookGenreID";
    }

    @Override
    public String getColumnNamesForGetAll() {
        return " a.*, b.BookID, b.Name, lib.LibrarianID, lib.FirstName, lib.LastName, lib.Username, bg.BookGenreID, bg.Name, ash.SerialNumber ";
    }

    @Override
    public String getWhereForGetAll() {
        return null;
    }

    @Override
    public String getColumnNamesValuesUpdate() {
        return null;
    }

    @Override
    public void setId(Long id) {
    }

    @Override
    public String getAlias() {
        return "ash";
    }
    
    
}
