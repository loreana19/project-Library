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
public class Librarian implements GenericEntity{
    private Long librarianID;
    private String firstName;
    private String lastName;
    private String username;
    private String password;

    public Librarian() {
    }

    public Librarian(Long librarianID, String firstName, String lastName, String username, String password) {
        this.librarianID = librarianID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getLibrarianID() {
        return librarianID;
    }

    public void setLibrarianID(Long librarianID) {
        this.librarianID = librarianID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return firstName+" "+lastName;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.librarianID);
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
        final Librarian other = (Librarian) obj;
        if (!Objects.equals(this.librarianID, other.librarianID)) {
            return false;
        }
        return true;
    }

    @Override
    public String getTableName() {
        return "librarian";
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
        return " lib.LibrarianID, lib.FirstName, lib.LastName, lib.Username, lib.Password ";
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
        librarianID=id;
    }

    @Override
    public String getAlias() {
        return "lib";
    }
    
    
}
