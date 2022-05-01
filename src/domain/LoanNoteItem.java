/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author LORA
 */
public class LoanNoteItem implements GenericEntity{
    private Long loanNoteItemID;
    private Long loanNoteID;
    private Date dateFrom;
    private Date dateTo;
    private BookCopy bookCopy;

    public LoanNoteItem() {
    }

    public LoanNoteItem(Long loanNoteItemID,Long loanNoteID, Date dateFrom, Date dateTo, BookCopy bookCopy) {
        this.loanNoteItemID = loanNoteItemID;
        this.loanNoteID=loanNoteID;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
        this.bookCopy = bookCopy;
    }

    public BookCopy getBookCopy() {
        return bookCopy;
    }

    public void setBookCopy(BookCopy bookCopy) {
        this.bookCopy = bookCopy;
    }

    public Long getLoanNoteItemID() {
        return loanNoteItemID;
    }

    public void setLoanNoteItemID(Long loanNoteItemID) {
        this.loanNoteItemID = loanNoteItemID;
    }

    public Long getLoanNoteID() {
        return loanNoteID;
    }

    public void setLoanNoteID(Long loanNoteID) {
        this.loanNoteID = loanNoteID;
    }

    public Date getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(Date dateFrom) {
        this.dateFrom = dateFrom;
    }

    public Date getDateTo() {
        return dateTo;
    }

    public void setDateTo(Date dateTo) {
        this.dateTo = dateTo;
    }

    @Override
    public String getTableName() {
        return "loannoteitem";
    }

    @Override
    public String getColumnNamesForInsert() {
        return " LoanNoteID, DateFrom, DateTo, BookID, BookCopyID ";
    }

    @Override
    public String getInsertedValues() {
       // return loanNoteID+", "+dateFrom+", "+dateTo+", "+bookCopy.getBook().getBookID()+", "+bookCopy.getBookCopyID()+" ";
        StringBuilder sb=new StringBuilder();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        sb.append(loanNoteID).append(", ")
           .append((dateFrom == null ? null : "\'" + sdf.format(dateFrom) + "\'")).append(", ")
           .append((dateTo == null ? null : "\'" + sdf.format(dateTo) + "\'")).append(", ")     
           .append(bookCopy.getBook().getBookID()).append(", ")
           .append(bookCopy.getBookCopyID()).append(" ");
        
        return sb.toString();
    }

    @Override
    public String getWhereClauseDeleteEdit() {
        StringBuilder sb = new StringBuilder();
        sb.append(" LoanNoteID=").append(loanNoteID).append(" and LoanNoteItemID=").append(loanNoteItemID).append(" ");
        return sb.toString();
    }

    @Override
    public String getJoinClause() {
        return " bookcopy bc ON bc.BookCopyID=lni.BookCopyID JOIN book b ON b.BookID=bc.BookID JOIN librarian lib ON lib.LibrarianID=b.LibrarianID JOIN BookGenre bg ON bg.BookGenreID=b.BookGenreID ";
    }

    @Override
    public String getColumnNamesForGetAll() {
        return " bg.*,lib.*, b.BookID, b.Name,bc.BookCopyID, bc.PublicityYear, bc.Available, lni.LoanNoteID, lni.LoanNoteItemID, lni.DateFrom, lni.DateTo";
    }

    @Override
    public String getWhereForGetAll() {
        return "loanNoteID="+loanNoteID+" ";
    }

    @Override
    public String getColumnNamesValuesUpdate() {
        StringBuilder sb=new StringBuilder();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        sb.append(" LoanNoteID=").append(loanNoteID).append(", ")
           .append(" DateFrom=").append((dateFrom == null ? null : "\'" + sdf.format(dateFrom) + "\'")).append(", ")
           .append(" DateTo=").append((dateTo == null ? null : "\'" + sdf.format(dateTo) + "\'")).append(", ")     
           .append(" BookID=").append(bookCopy.getBook().getBookID()).append(", ")
           .append(" BookCopyID=").append(bookCopy.getBookCopyID()).append(" ");
                
        
        return sb.toString();
    }

    @Override
    public void setId(Long id) {
        loanNoteItemID=id;
    }

    @Override
    public String getAlias() {
        return "lni";
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
        final LoanNoteItem other = (LoanNoteItem) obj;
        if (!Objects.equals(this.dateFrom, other.dateFrom)) {
            return false;
        }
        if (!Objects.equals(this.dateTo, other.dateTo)) {
            return false;
        }
        if (!Objects.equals(this.bookCopy, other.bookCopy)) {
            return false;
        }
        return true;
    }
    
}
