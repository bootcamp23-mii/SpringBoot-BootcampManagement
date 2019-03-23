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
@Table(name = "tb_t_employee_certification")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EmployeeCertification.findAll", query = "SELECT e FROM EmployeeCertification e")
    , @NamedQuery(name = "EmployeeCertification.findById", query = "SELECT e FROM EmployeeCertification e WHERE e.id = :id")
    , @NamedQuery(name = "EmployeeCertification.findByCertificateDate", query = "SELECT e FROM EmployeeCertification e WHERE e.certificateDate = :certificateDate")
    , @NamedQuery(name = "EmployeeCertification.findByCertificateNumber", query = "SELECT e FROM EmployeeCertification e WHERE e.certificateNumber = :certificateNumber")
    , @NamedQuery(name = "EmployeeCertification.findByIsdeleted", query = "SELECT e FROM EmployeeCertification e WHERE e.isdeleted = :isdeleted")})
public class EmployeeCertification implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "id")
    private String id;
    @Column(name = "certificateDate")
    @Temporal(TemporalType.DATE)
    private Date certificateDate;
    @Size(max = 100)
    @Column(name = "certificateNumber")
    private String certificateNumber;
    @Column(name = "isdeleted")
    private Short isdeleted;
    @JoinColumn(name = "certificate", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Certificate certificate;
    @JoinColumn(name = "employee", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Employee employee;

    public EmployeeCertification() {
    }

    public EmployeeCertification(String id) {
        this.id = id;
    }

    public EmployeeCertification(String id, Date certificateDate, String certificateNumber, Short isdeleted, Certificate certificate, Employee employee) {
        this.id = id;
        this.certificateDate = certificateDate;
        this.certificateNumber = certificateNumber;
        this.isdeleted = isdeleted;
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
        return certificateDate;
    }

    public void setCertificateDate(Date certificateDate) {
        this.certificateDate = certificateDate;
    }

    public String getCertificateNumber() {
        return certificateNumber;
    }

    public void setCertificateNumber(String certificateNumber) {
        this.certificateNumber = certificateNumber;
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
        if (!(object instanceof EmployeeCertification)) {
            return false;
        }
        EmployeeCertification other = (EmployeeCertification) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bm.bootcampmanagement.entities.EmployeeCertification[ id=" + id + " ]";
    }
    
}
