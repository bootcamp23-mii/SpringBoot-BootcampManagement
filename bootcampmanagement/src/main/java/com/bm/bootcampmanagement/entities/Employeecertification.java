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
@Table(name = "tb_t_employeecertification")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Employeecertification.findAll", query = "SELECT e FROM Employeecertification e")
    , @NamedQuery(name = "Employeecertification.findById", query = "SELECT e FROM Employeecertification e WHERE e.id = :id")
    , @NamedQuery(name = "Employeecertification.findByCertificatedate", query = "SELECT e FROM Employeecertification e WHERE e.certificatedate = :certificatedate")
    , @NamedQuery(name = "Employeecertification.findByCertificatenumber", query = "SELECT e FROM Employeecertification e WHERE e.certificatenumber = :certificatenumber")
    , @NamedQuery(name = "Employeecertification.findByIsdeleted", query = "SELECT e FROM Employeecertification e WHERE e.isdeleted = :isdeleted")})
public class Employeecertification implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "id")
    private String id;
    @Column(name = "certificatedate")
    @Temporal(TemporalType.DATE)
    private Date certificatedate;
    @Size(max = 100)
    @Column(name = "certificatenumber")
    private String certificatenumber;
    @Column(name = "isdeleted")
    private Short isdeleted;
    @JoinColumn(name = "certificate", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Certificate certificate;
    @JoinColumn(name = "employee", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Employee employee;

    public Employeecertification() {
    }

    public Employeecertification(String id) {
        this.id = id;
    }

    public Employeecertification(String id, Date certificatedate, String certificatenumber, Certificate certificate, Employee employee) {
        this.id = id;
        this.certificatedate = certificatedate;
        this.certificatenumber = certificatenumber;
        this.certificate = certificate;
        this.employee = employee;
    }

    
    

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getCertificateDate() {
        return certificatedate;
    }

    public void setCertificateDate(Date certificateDate) {
        this.certificatedate = certificateDate;
    }

    public String getCertificateNumber() {
        return certificatenumber;
    }

    public void setCertificateNumber(String certificateNumber) {
        this.certificatenumber = certificateNumber;
    }

    public Short getIsdeleted() {
        return isdeleted;
    }

    public void setIsdeleted(Short isdeleted) {
        this.isdeleted = isdeleted;
    }

    public Certificate getCertificate() {
        return certificate;
    }

    public void setCertificate(Certificate certificate) {
        this.certificate = certificate;
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
        if (!(object instanceof Employeecertification)) {
            return false;
        }
        Employeecertification other = (Employeecertification) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bm.bootcampmanagement.entities.Employeecertification[ id=" + id + " ]";
    }
    
}
