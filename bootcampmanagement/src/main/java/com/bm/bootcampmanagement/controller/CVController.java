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
import com.bm.bootcampmanagement.entities.Employeeskill;
import com.bm.bootcampmanagement.entities.Organization;
import com.bm.bootcampmanagement.services.EmployeeDAO;
import com.bm.bootcampmanagement.services.cv.AchievementDAO;
import com.bm.bootcampmanagement.services.cv.CertificateDAO;
import com.bm.bootcampmanagement.services.cv.EducationDAO;
import com.bm.bootcampmanagement.services.cv.EducationHistoryDAO;
import com.bm.bootcampmanagement.services.cv.EmployeeCertificationDAO;
import com.bm.bootcampmanagement.services.cv.EmployeeLanguageDAO;
import com.bm.bootcampmanagement.services.cv.EmployeeSkillDAO;
import com.bm.bootcampmanagement.services.cv.LanguageDAO;
import com.bm.bootcampmanagement.services.cv.OrganizationDAO;
import com.bm.bootcampmanagement.services.cv.SkillDAO;
import com.bm.bootcampmanagement.services.cv.WorkExperienceDAO;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
    SkillDAO daoS;
    
    @Autowired
    EmployeeSkillDAO daoEmpS;
    
    @Autowired
    WorkExperienceDAO daoW;
    
    private SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");    
    
    @GetMapping("/cv")
    public String cv(Model m) {
        m.addAttribute("achievementData", adao.findAll());
        m.addAttribute("achievementsave", new Achievement());
        m.addAttribute("achievementedit", new Achievement());
        m.addAttribute("achievementdelete", new Achievement());
        m.addAttribute("organizationData", odao.findAll());
        m.addAttribute("organizationsave", new Organization());
        m.addAttribute("organizationedit", new Organization());
        m.addAttribute("organizationdelete", new Organization());
        m.addAttribute("educationData", edao.findAll());
        m.addAttribute("educationsave", new Educationhistory());
        m.addAttribute("educationedit", new Educationhistory());
        m.addAttribute("educationdelete", new Educationhistory());
        m.addAttribute("certificateData", cdao.findAll());
        m.addAttribute("certificatesave", new Employeecertification());
        m.addAttribute("certificateedit", new Employeecertification());
        m.addAttribute("certificatedelete", new Employeecertification());
        m.addAttribute("dataedu", eddao.findAll());
        m.addAttribute("datacert", cedao.findAll());
        m.addAttribute("emplangData", daoEmpL.findAll());
        m.addAttribute("empskillData", daoEmpS.findAll());
        m.addAttribute("skillData", daoS.findAll());
        m.addAttribute("empskillsave", new Employeeskill());
        m.addAttribute("workexpData", daoW.findAll());
        return "/cv";
    }
    
    @GetMapping("/lihatcv")
    public String lihatcv(Model mod) {
        mod.addAttribute("employee", daoEmp.findById("14201"));
        mod.addAttribute("education", daoEmp.findById("14201").getEducationhistoryList());
        mod.addAttribute("achievementData", daoEmp.findById("14201").getAchievementList());
        mod.addAttribute("organizationData", daoEmp.findById("14201").getOrganizationList());
        mod.addAttribute("certificateData", daoEmp.findById("14201").getEmployeecertificationList());
        mod.addAttribute("languageData", daoEmp.findById("14201").getEmployeelanguageList());
        mod.addAttribute("skillData", daoEmp.findById("14201").getEmployeeskillList());
        mod.addAttribute("workexperienceData", daoEmp.findById("14201").getWorkexperienceList());
        return "/lihatCV";
    }
    
    
    @RequestMapping(value = "/achievementsave", method = RequestMethod.POST)  //@PostMapping("/regionsave")
    public String savee(@RequestParam("sid") String id, @RequestParam("sname") String name) {
        adao.save(new Achievement(id, name, new Employee("14201")));
        return "redirect:/cv";
    }

    @RequestMapping(value = "/achievementedit", method = RequestMethod.POST)  //@PostMapping("/regionsave")
    public String editach(@RequestParam("sid") String id, @RequestParam("sname") String name, @RequestParam("semployee") String semployee) {
        adao.save(new Achievement(id, name, new Employee(semployee)));
        return "redirect:/cv";
    }

    @RequestMapping(value = "/organizationsave", method = RequestMethod.POST)  //@PostMapping("/regionsave")
    public String saveorg(@RequestParam("oname") String oname, @RequestParam("position") String position,
            @RequestParam("periode") String periode) throws ParseException {
        odao.save(new Organization("id", oname, position, dateFormat.parse(periode), new Employee("14201")));
        return "redirect:/cv";
    }

    @RequestMapping(value = "/organizationedit", method = RequestMethod.POST)  //@PostMapping("/regionsave")
    public String editorg(@RequestParam("oid") String oid, @RequestParam("ooname") String oname, @RequestParam("oposition") String position,
            @RequestParam("operiode") String periode, @RequestParam("oemployee") String employee) throws ParseException {
        odao.save(new Organization(oid, oname, position, dateFormat.parse(periode), new Employee(employee)));
        return "redirect:/cv";
    }

    @RequestMapping(value = "/educationsave", method = RequestMethod.POST)  //@PostMapping("/regionsave")
    public String saveedu(@RequestParam("gpa") String gpa, @RequestParam("education") String education) {
        edao.save(new Educationhistory("id", gpa, new Education(education), new Employee("14201")));
        return "redirect:/cv";
    }

    @RequestMapping(value = "/educationedit", method = RequestMethod.POST)  //@PostMapping("/regionsave")
    public String saveedu(@RequestParam("ide") String ide, @RequestParam("gpae") String gpae, @RequestParam("educatione") String educatione) {
        edao.save(new Educationhistory(ide, gpae, new Education(educatione), new Employee("14201")));
        return "redirect:/cv";
    }

    @RequestMapping(value = "/certificatesave", method = RequestMethod.POST)  //@PostMapping("/regionsave")
    public String savecert(@RequestParam("datecert") String datec, @RequestParam("certnumber") String numc, @RequestParam("certificate") String certificate) throws ParseException {
        cdao.save(new Employeecertification("id", dateFormat.parse(datec), numc, new Certificate(certificate), new Employee("14201")));
        return "redirect:/cv";
    }

    @RequestMapping(value = "/certificateedit", method = RequestMethod.POST)  //@PostMapping("/regionsave")
    public String editcert(@RequestParam("eid") String eid, @RequestParam("edatecert") String datec, @RequestParam("certnum") String numc, @RequestParam("ecertificate") String certificate, @RequestParam("employee") String employee) throws ParseException {
        cdao.save(new Employeecertification(eid, dateFormat.parse(datec), numc, new Certificate(certificate), new Employee(employee)));
        return "redirect:/cv";
    }
    
    /*   DELETE functions   */
    @RequestMapping(value = "/achievementdelete", method = RequestMethod.GET)
    public String deleteach(@RequestParam(value = "achid") String id) {
        adao.delete(id);
        return "redirect:/cv";
    }
    
    @RequestMapping(value = "/organizationdelete", method = RequestMethod.GET)
    public String deleteorg(@RequestParam(value = "orgid") String id) {
        odao.delete(id);
        return "redirect:/cv";
    }

    @RequestMapping(value = "/certificatedelete", method = RequestMethod.GET)
    public String deletecert(@RequestParam(value = "certid") String id) {
        cdao.delete(id);
        return "redirect:/cv";
    }

    @RequestMapping(value = "/educationdelete", method = RequestMethod.GET)
    public String deleteedu(@RequestParam(value = "eduid") String id) {
        edao.delete(id);
        return "redirect:/cv";
    }
    
    @RequestMapping(value = "/languagedelete", method = RequestMethod.GET)
    public String deletelang(@RequestParam(value = "langid") String id) {
        daoL.delete(id);
        return "redirect:/cv";
    }

    @RequestMapping(value = "/skilldelete", method = RequestMethod.GET)
    public String deleteskill(@RequestParam(value = "skillid") String id) {
        daoS.delete(id);
        return "redirect:/cv";
    }

    @RequestMapping(value = "/workexperiencedelete", method = RequestMethod.GET)
    public String deleteworkexp(@RequestParam(value = "workexpid") String id) {
        daoW.delete(id);
        return "redirect:/cv";
    }
    
}
