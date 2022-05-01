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
public class Member implements GenericEntity{
    private Long memberID;
    private String firstName;
    private String lastName;
    private String contact;
    private Librarian librarian;

    public Member() {
        
    }

    public Member(Long memberID, String firstName, String lastName, String contact, Librarian librarian) {
        this.memberID = memberID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.contact = contact;
        this.librarian = librarian;
    }

    public Librarian getLibrarian() {
        return librarian;
    }

    public void setLibrarian(Librarian librarian) {
        this.librarian = librarian;
    }

    public Long getMemberID() {
        return memberID;
    }

    public void setMemberID(Long memberID) {
        this.memberID = memberID;
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

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
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
        final Member other = (Member) obj;
        if (!Objects.equals(this.firstName, other.firstName)) {
            return false;
        }
        if (!Objects.equals(this.lastName, other.lastName)) {
            return false;
        }
        if (!Objects.equals(this.contact, other.contact)) {
            return false;
        }
        return true;
    }

    @Override
    public String getTableName() {
        return "member";
    }

    @Override
    public String getColumnNamesForInsert() {
        return "FirstName, LastName,Contact,LibrarianID";
    }

    @Override
    public String getInsertedValues() {
        StringBuilder sb=new StringBuilder();
        sb.append("'").append(firstName).append("'").append(",")
                .append("'").append(lastName).append("'").append(", ")
                .append("'").append(contact).append("'").append(", ")
                .append(librarian.getLibrarianID());
                
        return sb.toString();
    }

   
    public void setId(Long id) {
        memberID=id;
    }

    

    @Override
    public String getWhereClauseDeleteEdit() {
        return "MemberID="+memberID;
    }

    @Override
    public String getJoinClause() {
        return " librarian lib ON lib.LibrarianID=m.LibrarianID ";
    }

    @Override
    public String getColumnNamesForGetAll() {
        return " lib.LibrarianID, lib.FirstName, lib.LastName, lib.Username, lib.Password, m.MemberID, m.FirstName, m.LastName, m.Contact ";
    }

    @Override
    public String getWhereForGetAll() {
        return null;
    }

    @Override
    public String getColumnNamesValuesUpdate() {
        StringBuilder sb=new StringBuilder();
        sb.append(" FirstName='").append(firstName).append("', ")
                .append(" LastName='").append(lastName).append("', ")
                .append(" Contact='").append(contact).append("', ")
                .append(" LibrarianID=").append(librarian.getLibrarianID()).append(" ");
        return sb.toString();
    }

    @Override
    public String getAlias() {
        return "m";
    }
    
    
    
}
