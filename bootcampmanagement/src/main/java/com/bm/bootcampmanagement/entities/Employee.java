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
    , @NamedQuery(name = "Employee.findByBirthDate", query = "SELECT e FROM Employee e WHERE e.birthDate = :birthDate")
    , @NamedQuery(name = "Employee.findByGender", query = "SELECT e FROM Employee e WHERE e.gender = :gender")
    , @NamedQuery(name = "Employee.findByMarriedStatus", query = "SELECT e FROM Employee e WHERE e.marriedStatus = :marriedStatus")
    , @NamedQuery(name = "Employee.findByAddress", query = "SELECT e FROM Employee e WHERE e.address = :address")
    , @NamedQuery(name = "Employee.findByEmail", query = "SELECT e FROM Employee e WHERE e.email = :email")
    , @NamedQuery(name = "Employee.findByPhone", query = "SELECT e FROM Employee e WHERE e.phone = :phone")
    , @NamedQuery(name = "Employee.findByOnboardDate", query = "SELECT e FROM Employee e WHERE e.onboardDate = :onboardDate")
    , @NamedQuery(name = "Employee.findByPassword", query = "SELECT e FROM Employee e WHERE e.password = :password")
    , @NamedQuery(name = "Employee.findBySecurityQestion", query = "SELECT e FROM Employee e WHERE e.securityQestion = :securityQestion")
    , @NamedQuery(name = "Employee.findBySecurityAnswer", query = "SELECT e FROM Employee e WHERE e.securityAnswer = :securityAnswer")
    , @NamedQuery(name = "Employee.findByIsdeleted", query = "SELECT e FROM Employee e WHERE e.isdeleted = :isdeleted")})
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
    @Column(name = "birthDate")
    @Temporal(TemporalType.DATE)
    private Date birthDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "gender")
    private short gender;
    @Basic(optional = false)
    @NotNull
    @Column(name = "marriedStatus")
    private short marriedStatus;
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
    @Column(name = "onboardDate")
    @Temporal(TemporalType.DATE)
    private Date onboardDate;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "password")
    private String password;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "securityQestion")
    private String securityQestion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "securityAnswer")
    private String securityAnswer;
    @Lob
    @Column(name = "photo")
    private byte[] photo;
    @Column(name = "isdeleted")
    private Short isdeleted;
    @OneToMany(mappedBy = "employee", fetch = FetchType.LAZY)
    private List<IdCard> idCardList;
    @OneToMany(mappedBy = "employee", fetch = FetchType.LAZY)
    private List<EmployeeLanguage> employeeLanguageList;
    @OneToMany(mappedBy = "employee", fetch = FetchType.LAZY)
    private List<EmployeeSkill> employeeSkillList;
    @OneToMany(mappedBy = "employee", fetch = FetchType.LAZY)
    private List<Achievement> achievementList;
    @OneToMany(mappedBy = "trainer", fetch = FetchType.LAZY)
    private List<BatchClass> batchClassList;
    @OneToMany(mappedBy = "employee", fetch = FetchType.LAZY)
    private List<Organization> organizationList;
    @OneToMany(mappedBy = "employee", fetch = FetchType.LAZY)
    private List<EmployeeCertification> employeeCertificationList;
    @OneToMany(mappedBy = "employee", fetch = FetchType.LAZY)
    private List<Placement> placementList;
    @OneToMany(mappedBy = "employee", fetch = FetchType.LAZY)
    private List<EmployeeRole> employeeRoleList;
    @OneToMany(mappedBy = "participant", fetch = FetchType.LAZY)
    private List<Evaluation> evaluationList;
    @OneToMany(mappedBy = "employee", fetch = FetchType.LAZY)
    private List<EmployeeLocker> employeeLockerList;
    @OneToMany(mappedBy = "employee", fetch = FetchType.LAZY)
    private List<ErrorBank> errorBankList;
    @OneToMany(mappedBy = "employee", fetch = FetchType.LAZY)
    private List<EmployeeAccess> employeeAccessList;
    @OneToMany(mappedBy = "employee", fetch = FetchType.LAZY)
    private List<WorkExperience> workExperienceList;
    @OneToMany(mappedBy = "employee", fetch = FetchType.LAZY)
    private List<EducationHistory> educationHistoryList;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "employee", fetch = FetchType.LAZY)
    private Participant participant;
    @JoinColumn(name = "religion", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Religion religion;
    @JoinColumn(name = "birthPlace", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private District birthPlace;
    @JoinColumn(name = "village", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Village village;
    @JoinColumn(name = "hiringLocation", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private District hiringLocation;

    public Employee() {
    }

    public Employee(String id) {
        this.id = id;
    }

    public Employee(String id, String name, Date birthDate, short gender, short marriedStatus, String address, String email, String phone, Date onboardDate, String password, String securityQestion, String securityAnswer) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
        this.gender = gender;
        this.marriedStatus = marriedStatus;
        this.address = address;
        this.email = email;
        this.phone = phone;
        this.onboardDate = onboardDate;
        this.password = password;
        this.securityQestion = securityQestion;
        this.securityAnswer = securityAnswer;
    }

    public Employee(String id, String name, Date birthDate, short gender, short marriedStatus, String address, String email, String phone, Date onboardDate, String password, String securityQestion, String securityAnswer, byte[] photo, Short isdeleted, Religion religion, District birthPlace, Village village, District hiringLocation) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
        this.gender = gender;
        this.marriedStatus = marriedStatus;
        this.address = address;
        this.email = email;
        this.phone = phone;
        this.onboardDate = onboardDate;
        this.password = password;
        this.securityQestion = securityQestion;
        this.securityAnswer = securityAnswer;
        this.photo = photo;
        this.isdeleted = isdeleted;
        this.participant = null;
        this.religion = religion;
        this.birthPlace = birthPlace;
        this.village = village;
        this.hiringLocation = hiringLocation;
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

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public short getGender() {
        return gender;
    }

    public void setGender(short gender) {
        this.gender = gender;
    }

    public short getMarriedStatus() {
        return marriedStatus;
    }

    public void setMarriedStatus(short marriedStatus) {
        this.marriedStatus = marriedStatus;
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

    public Date getOnboardDate() {
        return onboardDate;
    }

    public void setOnboardDate(Date onboardDate) {
        this.onboardDate = onboardDate;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSecurityQestion() {
        return securityQestion;
    }

    public void setSecurityQestion(String securityQestion) {
        this.securityQestion = securityQestion;
    }

    public String getSecurityAnswer() {
        return securityAnswer;
    }

    public void setSecurityAnswer(String securityAnswer) {
        this.securityAnswer = securityAnswer;
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

    @XmlTransient
    public List<IdCard> getIdCardList() {
        return idCardList;
    }

    public void setIdCardList(List<IdCard> idCardList) {
        this.idCardList = idCardList;
    }

    @XmlTransient
    public List<EmployeeLanguage> getEmployeeLanguageList() {
        return employeeLanguageList;
    }

    public void setEmployeeLanguageList(List<EmployeeLanguage> employeeLanguageList) {
        this.employeeLanguageList = employeeLanguageList;
    }

    @XmlTransient
    public List<EmployeeSkill> getEmployeeSkillList() {
        return employeeSkillList;
    }

    public void setEmployeeSkillList(List<EmployeeSkill> employeeSkillList) {
        this.employeeSkillList = employeeSkillList;
    }

    @XmlTransient
    public List<Achievement> getAchievementList() {
        return achievementList;
    }

    public void setAchievementList(List<Achievement> achievementList) {
        this.achievementList = achievementList;
    }

    @XmlTransient
    public List<BatchClass> getBatchClassList() {
        return batchClassList;
    }

    public void setBatchClassList(List<BatchClass> batchClassList) {
        this.batchClassList = batchClassList;
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
    public List<EmployeeRole> getEmployeeRoleList() {
        return employeeRoleList;
    }

    public void setEmployeeRoleList(List<EmployeeRole> employeeRoleList) {
        this.employeeRoleList = employeeRoleList;
    }

    @XmlTransient
    public List<Evaluation> getEvaluationList() {
        return evaluationList;
    }

    public void setEvaluationList(List<Evaluation> evaluationList) {
        this.evaluationList = evaluationList;
    }

    @XmlTransient
    public List<EmployeeLocker> getEmployeeLockerList() {
        return employeeLockerList;
    }

    public void setEmployeeLockerList(List<EmployeeLocker> employeeLockerList) {
        this.employeeLockerList = employeeLockerList;
    }

    @XmlTransient
    public List<ErrorBank> getErrorBankList() {
        return errorBankList;
    }

    public void setErrorBankList(List<ErrorBank> errorBankList) {
        this.errorBankList = errorBankList;
    }

    @XmlTransient
    public List<EmployeeAccess> getEmployeeAccessList() {
        return employeeAccessList;
    }

    public void setEmployeeAccessList(List<EmployeeAccess> employeeAccessList) {
        this.employeeAccessList = employeeAccessList;
    }

    @XmlTransient
    public List<WorkExperience> getWorkExperienceList() {
        return workExperienceList;
    }

    public void setWorkExperienceList(List<WorkExperience> workExperienceList) {
        this.workExperienceList = workExperienceList;
    }

    @XmlTransient
    public List<EducationHistory> getEducationHistoryList() {
        return educationHistoryList;
    }

    public void setEducationHistoryList(List<EducationHistory> educationHistoryList) {
        this.educationHistoryList = educationHistoryList;
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

    public District getBirthPlace() {
        return birthPlace;
    }

    public void setBirthPlace(District birthPlace) {
        this.birthPlace = birthPlace;
    }

    public Village getVillage() {
        return village;
    }

    public void setVillage(Village village) {
        this.village = village;
    }

    public District getHiringLocation() {
        return hiringLocation;
    }

    public void setHiringLocation(District hiringLocation) {
        this.hiringLocation = hiringLocation;
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
