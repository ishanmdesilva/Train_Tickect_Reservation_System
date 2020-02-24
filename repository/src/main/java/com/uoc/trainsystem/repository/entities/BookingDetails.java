/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uoc.trainsystem.repository.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.annotations.CreationTimestamp;

/**
 *
 * @author Lenovo
 */
@Entity
@Table(name = "booking_details")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BookingDetails.findAll", query = "SELECT b FROM BookingDetails b")})
public class BookingDetails implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @CreationTimestamp
    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @Basic(optional = false)
    @Column(name = "book_date")
    @Temporal(TemporalType.DATE)
    private Date bookDate;
    @Basic(optional = false)
    @Column(name = "number_of_tickets")
    private int numberOfTickets;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "total_ticket_price")
    private BigDecimal totalTicketPrice;
    @JoinColumn(name = "train_status_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private TrainStatus trainStatusId;
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private User userId;

    public BookingDetails() {
    }

    public BookingDetails(Integer id) {
        this.id = id;
    }

    public BookingDetails(Integer id, Date createdAt, Date bookDate, int numberOfTickets, BigDecimal totalTicketPrice) {
        this.id = id;
        this.createdAt = createdAt;
        this.bookDate = bookDate;
        this.numberOfTickets = numberOfTickets;
        this.totalTicketPrice = totalTicketPrice;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getBookDate() {
        return bookDate;
    }

    public void setBookDate(Date bookDate) {
        this.bookDate = bookDate;
    }

    public int getNumberOfTickets() {
        return numberOfTickets;
    }

    public void setNumberOfTickets(int numberOfTickets) {
        this.numberOfTickets = numberOfTickets;
    }

    public BigDecimal getTotalTicketPrice() {
        return totalTicketPrice;
    }

    public void setTotalTicketPrice(BigDecimal totalTicketPrice) {
        this.totalTicketPrice = totalTicketPrice;
    }

    public TrainStatus getTrainStatusId() {
        return trainStatusId;
    }

    public void setTrainStatusId(TrainStatus trainStatusId) {
        this.trainStatusId = trainStatusId;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BookingDetails)) {
            return false;
        }
        BookingDetails other = (BookingDetails) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.uoc.trainsystem.repository.entities.BookingDetails[ id=" + id + " ]";
    }
    
}
