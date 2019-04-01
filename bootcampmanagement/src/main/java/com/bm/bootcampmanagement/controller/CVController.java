/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bm.bootcampmanagement.controller;

import com.bm.bootcampmanagement.entities.Achievement;
import com.bm.bootcampmanagement.entities.Certificate;
import com.bm.bootcampmanagement.entities.Education;
import com.bm.bootcampmanagement.entities.Educationhistory;
import com.bm.bootcampmanagement.entities.Employee;
import com.bm.bootcampmanagement.entities.Employeecertification;
import com.bm.bootcampmanagement.entities.Employeelanguage;
import com.bm.bootcampmanagement.entities.Employeeskill;
import com.bm.bootcampmanagement.entities.Language;
import com.bm.bootcampmanagement.entities.Organization;
import com.bm.bootcampmanagement.entities.Skill;
import com.bm.bootcampmanagement.entities.Workexperience;
import com.bm.bootcampmanagement.services.EmployeeDAO;
import com.bm.bootcampmanagement.services.cv.AchievementDAO;
import com.bm.bootcampmanagement.services.cv.CertificateDAO;
import com.bm.bootcampmanagement.services.cv.DegreeDAO;
import com.bm.bootcampmanagement.services.cv.EducationDAO;
import com.bm.bootcampmanagement.services.cv.EducationHistoryDAO;
import com.bm.bootcampmanagement.services.cv.EmployeeCertificationDAO;
import com.bm.bootcampmanagement.services.cv.EmployeeLanguageDAO;
import com.bm.bootcampmanagement.services.cv.EmployeeSkillDAO;
import com.bm.bootcampmanagement.services.cv.LanguageDAO;
import com.bm.bootcampmanagement.services.cv.MajorDAO;
import com.bm.bootcampmanagement.services.cv.OrganizationDAO;
import com.bm.bootcampmanagement.services.cv.SkillDAO;
import com.bm.bootcampmanagement.services.cv.UniversityDAO;
import com.bm.bootcampmanagement.services.cv.WorkExperienceDAO;
import com.bm.bootcampmanagement.services.el.ProvinceDAO;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author gerydanu
 */
@Controller
//@RequestMapping("cv")
public class CVController {

    @Autowired
    EmployeeDAO daoEmp;

    @Autowired
    AchievementDAO adao;

    @Autowired
    OrganizationDAO odao;

    @Autowired
    EducationHistoryDAO edao;

    @Autowired
    EducationDAO eddao;

    @Autowired
    CertificateDAO cedao;

    @Autowired
    EmployeeCertificationDAO cdao;

    @Autowired
    LanguageDAO daoL;

    @Autowired
    EmployeeLanguageDAO daoEmpL;

    @Autowired
    ProvinceDAO daoLP;

    @Autowired
    SkillDAO daoS;

    @Autowired
    EmployeeSkillDAO daoEmpS;

    @Autowired
    WorkExperienceDAO daoW;

    @Autowired
    UniversityDAO udao;
    @Autowired
    MajorDAO mdao;
    @Autowired
    DegreeDAO ddao;

    private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    
    @GetMapping("cv/*")
    public String error() {
        return "redirect:/error";
    }

    
    @GetMapping("/cv/cv")
    public String cv(Model m, HttpServletRequest request) {
        if (request.getSession().getAttribute("login")==null) {
            return "index";
        }
        String empID = request.getSession().getAttribute("login").toString();
        m.addAttribute("achievementData", daoEmp.findById(empID).getAchievementList());
        m.addAttribute("achievementsave", new Achievement());
        m.addAttribute("achievementedit", new Achievement());
        m.addAttribute("achievementdelete", new Achievement());
        m.addAttribute("organizationData", daoEmp.findById(empID).getOrganizationList());
        m.addAttribute("organizationsave", new Organization());
        m.addAttribute("organizationedit", new Organization());
        m.addAttribute("organizationdelete", new Organization());
        m.addAttribute("educationData", daoEmp.findById(empID).getEducationhistoryList());
        m.addAttribute("educationsave", new Educationhistory());
        m.addAttribute("educationedit", new Educationhistory());
        m.addAttribute("educationdelete", new Educationhistory());
        m.addAttribute("certificateData", daoEmp.findById(empID).getEmployeecertificationList());
        m.addAttribute("certificatesave", new Employeecertification());
        m.addAttribute("certificateedit", new Employeecertification());
        m.addAttribute("certificatedelete", new Employeecertification());
        m.addAttribute("employeelanguageData", daoEmp.findById(empID).getEmployeelanguageList());
        m.addAttribute("employeelanguagesave", new Employeelanguage());
        m.addAttribute("employeelanguageedit", new Employeelanguage());
        m.addAttribute("employeelanguagedelete", new Employeelanguage());
        m.addAttribute("employeeskillData", daoEmp.findById(empID).getEmployeeskillList());
        m.addAttribute("employeeskillsave", new Employeeskill());
        m.addAttribute("employeeskilledit", new Employeeskill());
        m.addAttribute("employeeskilldelete", new Employeeskill());
        m.addAttribute("workexperienceData", daoEmp.findById(empID).getWorkexperienceList());
        m.addAttribute("workexperiencesave", new Workexperience());
        m.addAttribute("workexperienceedit", new Workexperience());
        m.addAttribute("workexperiencedelete", new Workexperience());
        m.addAttribute("dataedu", eddao.findAll());
        m.addAttribute("datacert", cedao.findAll());
        m.addAttribute("langData", daoL.findAll());
        m.addAttribute("emplangData", daoEmp.findById(empID).getEmployeelanguageList());
        m.addAttribute("skillData", daoS.findAll());
        m.addAttribute("empskillData", daoEmp.findById(empID).getEmployeeskillList());
        m.addAttribute("empskillsave", new Employeeskill());
        m.addAttribute("workexpData", daoEmp.findById(empID).getWorkexperienceList());
        m.addAttribute("university", udao.findAll());
        m.addAttribute("major", mdao.findAll());
        m.addAttribute("degree", ddao.findAll());
        m.addAttribute("province", daoLP.findAll());
        m.addAttribute("district", daoLP.findById("LP1").getDistrictList());
        return "/cv/cv";
    }

//    /cv depan dihapus
    @GetMapping("/cv/lihatcv")
    public String lihatcv(Model mod, HttpServletRequest request) {
        if (request.getSession().getAttribute("login")==null) {
            return "index";
        }
        String empID = request.getSession().getAttribute("login").toString();
        mod.addAttribute("employee", daoEmp.findById(empID));
        mod.addAttribute("education", daoEmp.findById(empID).getEducationhistoryList());
        mod.addAttribute("achievementData", daoEmp.findById(empID).getAchievementList());
        mod.addAttribute("organizationData", daoEmp.findById(empID).getOrganizationList());
        mod.addAttribute("certificateData", daoEmp.findById(empID).getEmployeecertificationList());
        mod.addAttribute("languageData", daoEmp.findById(empID).getEmployeelanguageList());
        mod.addAttribute("skillData", daoEmp.findById(empID).getEmployeeskillList());
        mod.addAttribute("workexperienceData", daoEmp.findById(empID).getWorkexperienceList());
        return "/cv/lihatCV";
    }

    @GetMapping("/cv/mycv")
    public String mycv(Model mod, HttpServletRequest request) {
        if (request.getSession().getAttribute("login")==null) {
            return "index";
        }
        String empID = request.getSession().getAttribute("login").toString();
        mod.addAttribute("employee", daoEmp.findById(empID));
        mod.addAttribute("education", daoEmp.findById(empID).getEducationhistoryList());
        mod.addAttribute("achievementData", daoEmp.findById(empID).getAchievementList());
        mod.addAttribute("organizationData", daoEmp.findById(empID).getOrganizationList());
        mod.addAttribute("certificateData", daoEmp.findById(empID).getEmployeecertificationList());
        mod.addAttribute("languageData", daoEmp.findById(empID).getEmployeelanguageList());
        mod.addAttribute("skillData", daoEmp.findById(empID).getEmployeeskillList());
        mod.addAttribute("workexperienceData", daoEmp.findById(empID).getWorkexperienceList());
        return "/cv/mycv";
    }

    /* SAVE and EDIT functions */
    @RequestMapping(value = "/cv/achievementsave", method = RequestMethod.POST)  //@PostMapping("/regionsave")
    public String savee(HttpServletRequest request, @RequestParam("sname") String name) {
        String id = request.getSession().getAttribute("login").toString();
        adao.save(new Achievement("ini", name, new Employee(id)));
        return "redirect:/cv/cv";
    }

    @RequestMapping(value = "/cv/achievementedit", method = RequestMethod.POST)  //@PostMapping("/regionsave")
    public String editach(@RequestParam("sid") String id, @RequestParam("sname") String name, @RequestParam("semployee") String semployee) {
        adao.save(new Achievement(id, name, new Employee(semployee)));
        return "redirect:/cv/cv";
    }

    @RequestMapping(value = "/cv/organizationsave", method = RequestMethod.POST)  //@PostMapping("/regionsave")
    public String saveorg(HttpServletRequest request, @RequestParam("oname") String oname, @RequestParam("position") String position,
            @RequestParam("periode") String periode) throws ParseException {
        String id = request.getSession().getAttribute("login").toString();
        odao.save(new Organization(id, oname, position, dateFormat.parse(periode), new Employee(id)));
        return "redirect:/cv/cv";
    }

    @RequestMapping(value = "/cv/organizationedit", method = RequestMethod.POST)  //@PostMapping("/regionsave")
    public String editorg(@RequestParam("oid") String oid, @RequestParam("ooname") String oname, @RequestParam("oposition") String position,
            @RequestParam("operiode") String periode, @RequestParam("oemployee") String employee) throws ParseException {
        odao.save(new Organization(oid, oname, position, dateFormat.parse(periode), new Employee(employee)));
        return "redirect:/cv/cv";
    }

    @RequestMapping(value = "/cv/educationsave", method = RequestMethod.POST)  //@PostMapping("/regionsave")
    public String saveedu(HttpServletRequest request, @RequestParam("gpa") String gpa, @RequestParam("education") String education) {
        String id = request.getSession().getAttribute("login").toString();
        edao.save(new Educationhistory(id, gpa, new Education(education), new Employee(id)));
        return "redirect:/cv/cv";
    }

    @RequestMapping(value = "/cv/educationedit", method = RequestMethod.POST)  //@PostMapping("/regionsave")
    public String saveedu(@RequestParam("ide") String ide, @RequestParam("gpae") String gpae, @RequestParam("educatione") String educatione) {
        edao.save(new Educationhistory(ide, gpae, new Education(educatione), new Employee("14201")));
        return "redirect:/cv/cv";
    }

    @RequestMapping(value = "/cv/certificatesave", method = RequestMethod.POST)  //@PostMapping("/regionsave")
    public String savecert(HttpServletRequest request, @RequestParam("datecert") String datec, @RequestParam("certnumber") String numc, @RequestParam("certificate") String certificate) throws ParseException {
        String id = request.getSession().getAttribute("login").toString();
        cdao.save(new Employeecertification(id, dateFormat.parse(datec), numc, new Certificate(certificate), new Employee(id)));
        return "redirect:/cv/cv";
    }

    @RequestMapping(value = "/cv/certificateedit", method = RequestMethod.POST)  //@PostMapping("/regionsave")
    public String editcert(@RequestParam("eid") String eid, @RequestParam("edatecert") String datec, @RequestParam("certnum") String numc, @RequestParam("ecertificate") String certificate, @RequestParam("employee") String employee) throws ParseException {
        cdao.save(new Employeecertification(eid, dateFormat.parse(datec), numc, new Certificate(certificate), new Employee(employee)));
        return "redirect:/cv/cv";
    }

    @RequestMapping(value = "/cv/languagesave", method = RequestMethod.POST)  //@PostMapping("/regionsave")
    public String savelang(@RequestParam("idlanga") String idlang, @RequestParam("scorea") String score, @RequestParam("isactivea") String isactive, HttpServletRequest request) {
        String id = request.getSession().getAttribute("login").toString();
        daoEmpL.save(new Employeelanguage(id, new Double(score), new Short(isactive), new Short("0"), new Language(idlang), new Employee(id)));
        return "redirect:/cv/cv";
    }

    @RequestMapping(value = "/cv/languageedit", method = RequestMethod.POST)  //@PostMapping("/regionsave")
    public String savelang(@RequestParam("elid") String id, @RequestParam("idlange") String idlang, @RequestParam("scoree") String score, @RequestParam("isactivee") String isactive, HttpServletRequest request) {
        String idemp = request.getSession().getAttribute("login").toString();
        daoEmpL.save(new Employeelanguage(id, new Double(score), new Short(isactive), new Short("0"), new Language(idlang), new Employee(idemp)));
        return "redirect:/cv/cv";
    }

    @RequestMapping(value = "/cv/skillsave", method = RequestMethod.POST)  //@PostMapping("/regionsave")
    public String saveskill(@RequestParam("idskilla") String skill, @RequestParam("scorea") String score, HttpServletRequest request) {
        String idemp = request.getSession().getAttribute("login").toString();
        daoEmpS.save(new Employeeskill(idemp, new Double(score), new Short("0"), new Skill(skill), new Employee(idemp)));
        return "redirect:/cv/cv";
    }

    @RequestMapping(value = "/cv/skilledit", method = RequestMethod.POST)  //@PostMapping("/regionsave")
    public String saveskill(@RequestParam("sid") String id, @RequestParam("idskille") String skill, @RequestParam("scoree") String score, HttpServletRequest request) {
        String idemp = request.getSession().getAttribute("login").toString();
        daoEmpS.save(new Employeeskill(id, new Double(score), new Short("0"), new Skill(skill), new Employee(idemp)));
        return "redirect:/cv/cv";
    }

    @RequestMapping(value = "/cv/workexpsave", method = RequestMethod.POST)  //@PostMapping("/regionsave")
    public String saveworkexp(@RequestParam("worknamea") String name, @RequestParam("workdescriptiona") String desc, @RequestParam("workpositiona") String position, @RequestParam("workstartdatea") String startdate, @RequestParam("workenddatea") String enddate, HttpServletRequest request) {
        try {
            String idemp = request.getSession().getAttribute("login").toString();
            daoW.save(new Workexperience(idemp, name, desc, position, dateFormat.parse(startdate), dateFormat.parse(enddate), new Short("0"), new Employee(idemp)));
        } catch (Exception ex) {
            Logger.getLogger(CVController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "redirect:/cv/cv";
    }

    @RequestMapping(value = "/cv/workexpedit", method = RequestMethod.POST)  //@PostMapping("/regionsave")
    public String saveworkexp(@RequestParam("weid") String id, @RequestParam("worknamee") String name, @RequestParam("workdescriptione") String desc, @RequestParam("workpositione") String position, @RequestParam("workstartdatee") String startdate, @RequestParam("workenddatee") String enddate, HttpServletRequest request) {
        try {
            String idemp = request.getSession().getAttribute("login").toString();
            daoW.save(new Workexperience(id, name, desc, position, dateFormat.parse(startdate), dateFormat.parse(enddate), new Short("0"), new Employee(idemp)));
        } catch (ParseException ex) {
            Logger.getLogger(CVController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "redirect:/cv/cv";
    }

    /*   DELETE functions   */
    @RequestMapping(value = "/cv/achievementdelete", method = RequestMethod.GET)
    public String deleteach(@RequestParam(value = "achid") String id) {
        adao.delete(id);
        return "redirect:/cv/cv";
    }

    @RequestMapping(value = "/cv/organizationdelete", method = RequestMethod.GET)
    public String deleteorg(@RequestParam(value = "orgid") String id) {
        odao.delete(id);
        return "redirect:/cv/cv";
    }

    @RequestMapping(value = "/cv/certificatedelete", method = RequestMethod.GET)
    public String deletecert(@RequestParam(value = "certid") String id) {
        cdao.delete(id);
        return "redirect:/cv/cv";
    }

    @RequestMapping(value = "/cv/educationdelete", method = RequestMethod.GET)
    public String deleteedu(@RequestParam(value = "eduid") String id) {
        edao.delete(id);
        return "redirect:/cv/cv";
    }

    @RequestMapping(value = "/cv/languagedelete", method = RequestMethod.GET)
    public String deletelang(@RequestParam(value = "id") String id) {
        daoEmpL.delete(id);
        return "redirect:/cv/cv";
    }

    @RequestMapping(value = "/cv/skilldelete", method = RequestMethod.GET)
    public String deleteskill(@RequestParam(value = "id") String id) {
        daoEmpS.delete(id);
        return "redirect:/cv/cv";
    }

    @RequestMapping(value = "/cv/workexperiencedelete", method = RequestMethod.GET)
    public String deleteworkexp(@RequestParam(value = "id") String id) {
        daoW.delete(id);
        return "redirect:/cv/cv";
    }

}
