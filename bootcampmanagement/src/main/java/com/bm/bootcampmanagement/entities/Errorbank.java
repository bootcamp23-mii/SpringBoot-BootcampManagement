/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bm.bootcampmanagement.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author FES
 */
@Entity
@Table(name = "tb_t_errorbank")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Errorbank.findAll", query = "SELECT e FROM Errorbank e")
    , @NamedQuery(name = "Errorbank.findById", query = "SELECT e FROM Errorbank e WHERE e.id = :id")
    , @NamedQuery(name = "Errorbank.findBySubmitdate", query = "SELECT e FROM Errorbank e WHERE e.submitdate = :submitdate")
    , @NamedQuery(name = "Errorbank.findByIsdeleted", query = "SELECT e FROM Errorbank e WHERE e.isdeleted = :isdeleted")})
public class Errorbank implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "id")
    private String id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "submitdate")
    @Temporal(TemporalType.DATE)
    private Date submitdate;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "description")
    private String description;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "solution")
    private String solution;
    @Column(name = "isdeleted")
    private Short isdeleted;
    @JoinColumn(name = "classes", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Classes classes;
    @JoinColumn(name = "employee", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Employee employee;

    public Errorbank() {
    }

    public Errorbank(String id) {
        this.id = id;
    }

    public Errorbank(String id, Date submitdate) {
        this.id = id;
        this.submitdate = submitdate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getSubmitdate() {
        return submitdate;
    }

    public void setSubmitdate(Date submitdate) {
        this.submitdate = submitdate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSolution() {
        return solution;
    }

    public void setSolution(String solution) {
        this.solution = solution;
    }

    public Short getIsdeleted() {
        return isdeleted;
    }

    public void setIsdeleted(Short isdeleted) {
        this.isdeleted = isdeleted;
    }

    public Classes getClasses() {
        return classes;
    }

    public void setClasses(Classes classes) {
        this.classes = classes;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
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
        if (!(object instanceof Errorbank)) {
            return false;
        }
        Errorbank other = (Errorbank) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bm.bootcampmanagement.entities.Errorbank[ id=" + id + " ]";
    }
    
}
