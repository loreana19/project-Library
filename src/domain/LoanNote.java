/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author LORA
 */
public class LoanNote implements GenericEntity{
    private Long loanNote;
    private Date date;
    private Librarian librarian;
    private Member member;
    private List<LoanNoteItem> listOfLoanNoteItems;

    public LoanNote() {
        List<LoanNoteItem> listOfLoanNoteItems=new ArrayList<>();
    }

    public LoanNote(Long loanNote, Date date, Librarian librarian, Member member, List<LoanNoteItem> listOfLoanNoteItems) {
        this.loanNote = loanNote;
        this.date = date;
        this.librarian = librarian;
        this.member = member;
        this.listOfLoanNoteItems = listOfLoanNoteItems;
    }

    public List<LoanNoteItem> getListOfLoanNoteItems() {
        return listOfLoanNoteItems;
    }

    public void setListOfLoanNoteItems(List<LoanNoteItem> listOfLoanNoteItems) {
        this.listOfLoanNoteItems = listOfLoanNoteItems;
    }
    

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public Long getLoanNote() {
        return loanNote;
    }

    public void setLoanNote(Long loanNote) {
        this.loanNote = loanNote;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Librarian getLibrarian() {
        return librarian;
    }

    public void setLibrarian(Librarian librarian) {
        this.librarian = librarian;
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
        final LoanNote other = (LoanNote) obj;
        if (!Objects.equals(this.loanNote, other.loanNote)) {
            return false;
        }
        if (!Objects.equals(this.date, other.date)) {
            return false;
        }
        return true;
    }

    @Override
    public String getTableName() {
        return "loannote";
    }

    @Override
    public String getColumnNamesForInsert() {
        return "CreateDate, LibrarianID, MemberID";
    }

    @Override
    public String getInsertedValues() {
        StringBuilder sb=new StringBuilder();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        sb.append((date == null ? null : "\'" + sdf.format(date) + "\'")).append(",")
                .append(librarian.getLibrarianID()).append(", ")
                .append(member.getMemberID()).append(" ");
        return sb.toString();
            
    }

    @Override
    public String getWhereClauseDeleteEdit() {
        StringBuilder sb = new StringBuilder();
        sb.append(" LoanNoteID=").append(loanNote).append(" ");
        return sb.toString();    }

    @Override
    public String getJoinClause() {
        return " librarian lib ON lib.LibrarianID=l.LibrarianID JOIN member m ON m.MemberID=l.MemberID";
    }

    @Override
    public String getColumnNamesForGetAll() {
        return "lib.*, m.MemberID, m.FirstName, m.LastName, m.Contact, LoanNoteID, CreateDate";
    }

    @Override
    public String getWhereForGetAll() {
        return null;
    }

    @Override
    public String getColumnNamesValuesUpdate() {
        StringBuilder sb=new StringBuilder();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        sb.append(" CreateDate=").append((date == null ? null : "\'" + sdf.format(date) + "\'")).append(",")
                .append(" LibrarianID=").append(librarian.getLibrarianID()).append(", ")
                .append(" MemberID=").append(member.getMemberID()).append(" ");
        return sb.toString();
    }

    @Override
    public void setId(Long id) {
        loanNote=id;
    }

    @Override
    public String getAlias() {
        return "l";
    }
    
}
