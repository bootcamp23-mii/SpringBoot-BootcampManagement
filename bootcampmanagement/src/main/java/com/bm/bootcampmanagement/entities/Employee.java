/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bm.bootcampmanagement.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author FES
 */
@Entity
@Table(name = "tb_m_employee")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Employee.findAll", query = "SELECT e FROM Employee e")
    , @NamedQuery(name = "Employee.findById", query = "SELECT e FROM Employee e WHERE e.id = :id")
    , @NamedQuery(name = "Employee.findByName", query = "SELECT e FROM Employee e WHERE e.name = :name")
    , @NamedQuery(name = "Employee.findByBirthdate", query = "SELECT e FROM Employee e WHERE e.birthdate = :birthdate")
    , @NamedQuery(name = "Employee.findByGender", query = "SELECT e FROM Employee e WHERE e.gender = :gender")
    , @NamedQuery(name = "Employee.findByMarriedstatus", query = "SELECT e FROM Employee e WHERE e.marriedstatus = :marriedstatus")
    , @NamedQuery(name = "Employee.findByAddress", query = "SELECT e FROM Employee e WHERE e.address = :address")
    , @NamedQuery(name = "Employee.findByEmail", query = "SELECT e FROM Employee e WHERE e.email = :email")
    , @NamedQuery(name = "Employee.findByPhone", query = "SELECT e FROM Employee e WHERE e.phone = :phone")
    , @NamedQuery(name = "Employee.findByOnboarddate", query = "SELECT e FROM Employee e WHERE e.onboarddate = :onboarddate")
    , @NamedQuery(name = "Employee.findByPassword", query = "SELECT e FROM Employee e WHERE e.password = :password")
    , @NamedQuery(name = "Employee.findBySecurityqestion", query = "SELECT e FROM Employee e WHERE e.securityqestion = :securityqestion")
    , @NamedQuery(name = "Employee.findBySecurityanswer", query = "SELECT e FROM Employee e WHERE e.securityanswer = :securityanswer")
    , @NamedQuery(name = "Employee.findByIsdeleted", query = "SELECT e FROM Employee e WHERE e.isdeleted = :isdeleted")
    , @NamedQuery(name = "Employee.findByBirthplace", query = "SELECT e FROM Employee e WHERE e.birthplace = :birthplace")
    , @NamedQuery(name = "Employee.findByHiringlocation", query = "SELECT e FROM Employee e WHERE e.hiringlocation = :hiringlocation")})
public class Employee implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "id")
    private String id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Column(name = "birthdate")
    @Temporal(TemporalType.DATE)
    private Date birthdate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "gender")
    private short gender;
    @Basic(optional = false)
    @NotNull
    @Column(name = "marriedstatus")
    private short marriedstatus;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 300)
    @Column(name = "address")
    private String address;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "email")
    private String email;
    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "phone")
    private String phone;
    @Basic(optional = false)
    @NotNull
    @Column(name = "onboarddate")
    @Temporal(TemporalType.DATE)
    private Date onboarddate;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "password")
    private String password;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "securityqestion")
    private String securityqestion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "securityanswer")
    private String securityanswer;
    @Lob
    @Column(name = "photo")
    private byte[] photo;
    @Column(name = "isdeleted")
    private Short isdeleted;
    @Size(max = 10)
    @Column(name = "birthplace")
    private String birthplace;
    @Size(max = 10)
    @Column(name = "hiringlocation")
    private String hiringlocation;
    @OneToMany(mappedBy = "employee", fetch = FetchType.LAZY)
    private List<Errorbank> errorbankList;
    @OneToMany(mappedBy = "employee", fetch = FetchType.LAZY)
    private List<Achievement> achievementList;
    @OneToMany(mappedBy = "employee", fetch = FetchType.LAZY)
    private List<Organization> organizationList;
    @OneToMany(mappedBy = "employee", fetch = FetchType.LAZY)
    private List<EmployeeCertification> employeeCertificationList;
    @OneToMany(mappedBy = "employee", fetch = FetchType.LAZY)
    private List<Placement> placementList;
    @OneToMany(mappedBy = "participant", fetch = FetchType.LAZY)
    private List<Evaluation> evaluationList;
    @OneToMany(mappedBy = "employee", fetch = FetchType.LAZY)
    private List<Educationhistory> educationhistoryList;
    @OneToMany(mappedBy = "employee", fetch = FetchType.LAZY)
    private List<Employeerole> employeeroleList;
    @OneToMany(mappedBy = "employee", fetch = FetchType.LAZY)
    private List<Employeeskill> employeeskillList;
    @OneToMany(mappedBy = "employee", fetch = FetchType.LAZY)
    private List<Workexperience> workexperienceList;
    @OneToMany(mappedBy = "employee", fetch = FetchType.LAZY)
    private List<Employeelocker> employeelockerList;
    @OneToMany(mappedBy = "trainer", fetch = FetchType.LAZY)
    private List<Batchclass> batchclassList;
    @OneToMany(mappedBy = "employee", fetch = FetchType.LAZY)
    private List<Employeeaccess> employeeaccessList;
    @OneToMany(mappedBy = "employee", fetch = FetchType.LAZY)
    private List<Employeelanguage> employeelanguageList;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "employee", fetch = FetchType.LAZY)
    private Participant participant;
    @JoinColumn(name = "religion", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Religion religion;
    @JoinColumn(name = "village", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Village village;
    @OneToMany(mappedBy = "employee", fetch = FetchType.LAZY)
    private List<Idcard> idcardList;

    public Employee() {
    }

    public Employee(String id) {
        this.id = id;
    }

    public Employee(String id, String name, Date birthdate, short gender, short marriedstatus, String address, String email, String phone, Date onboarddate, String password, String securityqestion, String securityanswer) {
        this.id = id;
        this.name = name;
        this.birthdate = birthdate;
        this.gender = gender;
        this.marriedstatus = marriedstatus;
        this.address = address;
        this.email = email;
        this.phone = phone;
        this.onboarddate = onboarddate;
        this.password = password;
        this.securityqestion = securityqestion;
        this.securityanswer = securityanswer;
    }
    
    public Employee(String id, String name, Date birthdate, short gender, short marriedstatus, String address, String email, String phone, Date onboarddate, String password, String securityqestion, String securityanswer, byte[] photo) {
        this.id = id;
        this.name = name;
        this.birthdate = birthdate;
        this.gender = gender;
        this.marriedstatus = marriedstatus;
        this.address = address;
        this.email = email;
        this.phone = phone;
        this.onboarddate = onboarddate;
        this.password = password;
        this.securityqestion = securityqestion;
        this.securityanswer = securityanswer;
        this.photo = photo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public short getGender() {
        return gender;
    }

    public void setGender(short gender) {
        this.gender = gender;
    }

    public short getMarriedstatus() {
        return marriedstatus;
    }

    public void setMarriedstatus(short marriedstatus) {
        this.marriedstatus = marriedstatus;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getOnboarddate() {
        return onboarddate;
    }

    public void setOnboarddate(Date onboarddate) {
        this.onboarddate = onboarddate;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSecurityqestion() {
        return securityqestion;
    }

    public void setSecurityqestion(String securityqestion) {
        this.securityqestion = securityqestion;
    }

    public String getSecurityanswer() {
        return securityanswer;
    }

    public void setSecurityanswer(String securityanswer) {
        this.securityanswer = securityanswer;
    }

    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }

    public Short getIsdeleted() {
        return isdeleted;
    }

    public void setIsdeleted(Short isdeleted) {
        this.isdeleted = isdeleted;
    }

    public String getBirthplace() {
        return birthplace;
    }

    public void setBirthplace(String birthplace) {
        this.birthplace = birthplace;
    }

    public String getHiringlocation() {
        return hiringlocation;
    }

    public void setHiringlocation(String hiringlocation) {
        this.hiringlocation = hiringlocation;
    }

    @XmlTransient
    public List<Errorbank> getErrorbankList() {
        return errorbankList;
    }

    public void setErrorbankList(List<Errorbank> errorbankList) {
        this.errorbankList = errorbankList;
    }

    @XmlTransient
    public List<Achievement> getAchievementList() {
        return achievementList;
    }

    public void setAchievementList(List<Achievement> achievementList) {
        this.achievementList = achievementList;
    }

    @XmlTransient
    public List<Organization> getOrganizationList() {
        return organizationList;
    }

    public void setOrganizationList(List<Organization> organizationList) {
        this.organizationList = organizationList;
    }

    @XmlTransient
    public List<EmployeeCertification> getEmployeeCertificationList() {
        return employeeCertificationList;
    }

    public void setEmployeeCertificationList(List<EmployeeCertification> employeeCertificationList) {
        this.employeeCertificationList = employeeCertificationList;
    }

    @XmlTransient
    public List<Placement> getPlacementList() {
        return placementList;
    }

    public void setPlacementList(List<Placement> placementList) {
        this.placementList = placementList;
    }

    @XmlTransient
    public List<Evaluation> getEvaluationList() {
        return evaluationList;
    }

    public void setEvaluationList(List<Evaluation> evaluationList) {
        this.evaluationList = evaluationList;
    }

    @XmlTransient
    public List<Educationhistory> getEducationhistoryList() {
        return educationhistoryList;
    }

    public void setEducationhistoryList(List<Educationhistory> educationhistoryList) {
        this.educationhistoryList = educationhistoryList;
    }

    @XmlTransient
    public List<Employeerole> getEmployeeroleList() {
        return employeeroleList;
    }

    public void setEmployeeroleList(List<Employeerole> employeeroleList) {
        this.employeeroleList = employeeroleList;
    }

    @XmlTransient
    public List<Employeeskill> getEmployeeskillList() {
        return employeeskillList;
    }

    public void setEmployeeskillList(List<Employeeskill> employeeskillList) {
        this.employeeskillList = employeeskillList;
    }

    @XmlTransient
    public List<Workexperience> getWorkexperienceList() {
        return workexperienceList;
    }

    public void setWorkexperienceList(List<Workexperience> workexperienceList) {
        this.workexperienceList = workexperienceList;
    }

    @XmlTransient
    public List<Employeelocker> getEmployeelockerList() {
        return employeelockerList;
    }

    public void setEmployeelockerList(List<Employeelocker> employeelockerList) {
        this.employeelockerList = employeelockerList;
    }

    @XmlTransient
    public List<Batchclass> getBatchclassList() {
        return batchclassList;
    }

    public void setBatchclassList(List<Batchclass> batchclassList) {
        this.batchclassList = batchclassList;
    }

    @XmlTransient
    public List<Employeeaccess> getEmployeeaccessList() {
        return employeeaccessList;
    }

    public void setEmployeeaccessList(List<Employeeaccess> employeeaccessList) {
        this.employeeaccessList = employeeaccessList;
    }

    @XmlTransient
    public List<Employeelanguage> getEmployeelanguageList() {
        return employeelanguageList;
    }

    public void setEmployeelanguageList(List<Employeelanguage> employeelanguageList) {
        this.employeelanguageList = employeelanguageList;
    }

    public Participant getParticipant() {
        return participant;
    }

    public void setParticipant(Participant participant) {
        this.participant = participant;
    }

    public Religion getReligion() {
        return religion;
    }

    public void setReligion(Religion religion) {
        this.religion = religion;
    }

    public Village getVillage() {
        return village;
    }

    public void setVillage(Village village) {
        this.village = village;
    }

    @XmlTransient
    public List<Idcard> getIdcardList() {
        return idcardList;
    }

    public void setIdcardList(List<Idcard> idcardList) {
        this.idcardList = idcardList;
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
        if (!(object instanceof Employee)) {
            return false;
        }
        Employee other = (Employee) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bm.bootcampmanagement.entities.Employee[ id=" + id + " ]";
    }
    
}
