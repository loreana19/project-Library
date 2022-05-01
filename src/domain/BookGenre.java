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
public class BookGenre implements GenericEntity{
    private Long bookGenreID;
    private String name;

    public BookGenre() {
    }

    public BookGenre(Long bookGenreID, String name) {
        this.bookGenreID = bookGenreID;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getBookGenreID() {
        return bookGenreID;
    }

    public void setBookGenreID(Long bookGenreID) {
        this.bookGenreID = bookGenreID;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public String getTableName() {
        return "bookGenre";
    }

    @Override
    public String getColumnNamesForInsert() {
        return null;
    }

    @Override
    public String getInsertedValues() {
        return null;
    }

    @Override
    public String getWhereClauseDeleteEdit() {
        return null;
    }

    @Override
    public String getJoinClause() {
        return null;
    }

    @Override
    public String getColumnNamesForGetAll() {
        return " bg.BookGenreID, bg.Name";
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
        bookGenreID=id;
    }

    @Override
    public String getAlias() {
        return "bg";
    }
    
}
