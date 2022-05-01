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
public class Author implements GenericEntity{
    private Long authorID;
    private String firstName;
    private String lastName;

    public Author() {
    }

    public Author(Long authorID, String firstName, String lastName) {
        this.authorID = authorID;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Long getAuthorID() {
        return authorID;
    }

    public void setAuthorID(Long authorID) {
        this.authorID = authorID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Override
    public String toString() {
        return firstName+" "+lastName;
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
        final Author other = (Author) obj;
        if (!Objects.equals(this.firstName, other.firstName)) {
            return false;
        }
        if (!Objects.equals(this.lastName, other.lastName)) {
            return false;
        }
        return true;
    }

    @Override
    public String getTableName() {
        return "author";
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
        return "*";
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
        authorID=id;
    }

    @Override
    public String getAlias() {
        return "a";
    }
    
    
    
}
