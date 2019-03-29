/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bm.bootcampmanagement.controller;

import com.bm.bootcampmanagement.entities.Accesscard;
import com.bm.bootcampmanagement.entities.Achievement;
import com.bm.bootcampmanagement.entities.Certificate;
import com.bm.bootcampmanagement.entities.Company;
import com.bm.bootcampmanagement.entities.Education;
import com.bm.bootcampmanagement.entities.Educationhistory;
import com.bm.bootcampmanagement.entities.Employee;
import com.bm.bootcampmanagement.entities.Employeeaccess;
import com.bm.bootcampmanagement.entities.Employeecertification;
import com.bm.bootcampmanagement.entities.Employeelocker;
import com.bm.bootcampmanagement.entities.Employeeskill;
import com.bm.bootcampmanagement.entities.Idcard;
import com.bm.bootcampmanagement.entities.Locker;
import com.bm.bootcampmanagement.entities.Organization;
import com.bm.bootcampmanagement.entities.Placement;
import com.bm.bootcampmanagement.repository.el.CompanyRepository;
import com.bm.bootcampmanagement.repository.el.EmployeeAccessRepository;
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
import com.bm.bootcampmanagement.services.el.AccessCardDAO;
import com.bm.bootcampmanagement.services.el.DistrictDAO;
import com.bm.bootcampmanagement.services.el.EmployeeAccessDAO;
import com.bm.bootcampmanagement.services.el.EmployeeLockerDAO;
import com.bm.bootcampmanagement.services.el.IdCardDAO;
import com.bm.bootcampmanagement.services.el.LockerDAO;
import com.bm.bootcampmanagement.services.el.PlacementDAO;
import com.bm.bootcampmanagement.services.el.VillageDAO;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
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
public class ELController {

    @Autowired
    EmployeeAccessRepository ear;

    @Autowired
    CompanyRepository cr;

    @Autowired
    AccessCardDAO acdao;

    @Autowired
    LockerDAO ldao;

    @Autowired
    IdCardDAO cardDAO;

    @Autowired
    EmployeeLockerDAO eldao;

    @Autowired
    EmployeeAccessDAO o;

    @Autowired
    PlacementDAO pdao;

    @Autowired
    EmployeeDAO daoEmp;

    @Autowired
    VillageDAO daoLV;

    @Autowired
    DistrictDAO daoLD;

    private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    @GetMapping("/el/Idcard")
    public String Idcard(Model model) {
        model.addAttribute("idcardData", cardDAO.findAll());
        model.addAttribute("empl", daoEmp.findAll());
        model.addAttribute("idcardSave", new Idcard());
        model.addAttribute("idcardEdit", new Idcard());
        model.addAttribute("idcardDelete", new Idcard());
        return "/el/Idcard";
    }

    @RequestMapping(value = "/el/idcardSave", method = RequestMethod.POST)  //@PostMapping("/regionsave")
    public String save(String id, @RequestParam("receivedate") String receivedate, @RequestParam("returndate") String returndate,
            @RequestParam("note") String note, @RequestParam("employee") String employee) throws ParseException {
        cardDAO.saveIdCard(new Idcard("id", dateFormat.parse(receivedate), dateFormat.parse(returndate), note, new Employee(employee)));
        return "redirect:/el/Idcard";
    }

    @RequestMapping(value = "/el/idcardEdit", method = RequestMethod.POST)
    public String edit(@RequestParam("id") String id, @RequestParam("receivedate") String receivedate, @RequestParam("returndate") String returndate,
            @RequestParam("note") String note, @RequestParam("employee") String employee) throws ParseException {
        cardDAO.saveIdCard(new Idcard(id, dateFormat.parse(receivedate), dateFormat.parse(returndate), note, new Employee(employee)));
        return "redirect:/el/Idcard";
    }

    @RequestMapping(value = "/el/idcardDelete", method = RequestMethod.GET)
    public String deletecard(@RequestParam(value = "cardid") String id) {
        cardDAO.deleteIdCardById(id);
        return "redirect:/el/Idcard";
    }

    @GetMapping("/el/Employeelocker")
    public String Employeelocker(Model model) {
//        Locker lock = (Locker) ldao.findAll();
//        List<Employeelocker> elok = (List<Employeelocker>) (Employeelocker) eldao.findAll();
//        for (Employeelocker employeelocker : elok) {
//            for (int i = 0; i < elok.size(); i++) {
//                if (lock.getId() == elok.get(i).getLocker().getId()) {
//
//                }
//
//            }
//        }
        model.addAttribute("emplockerData", eldao.findAll());
        model.addAttribute("datalock", ldao.findAll());
        model.addAttribute("empl", daoEmp.findAll());
        model.addAttribute("emplockerSave", new Employeelocker());
        model.addAttribute("emplockerEdit", new Employeelocker());
        model.addAttribute("emplockerDelete", new Employeelocker());
        return "/el/Employeelocker";
    }

    @RequestMapping(value = "/el/emplockerSave", method = RequestMethod.POST)
    public String save(String id, @RequestParam("receivedate") String receivedate, @RequestParam("returndate") String returndate,
            @RequestParam("notes") String notes, @RequestParam("locker") String locker, @RequestParam("employee") String employee) throws ParseException {
        boolean isNew = true;

        for (Employeelocker data : eldao.findAll()) {
            if (!employee.equalsIgnoreCase(data.getEmployee().getId())) {
                if (locker.equalsIgnoreCase(data.getLocker().getId())) {
                    isNew = false;
                }
            }
        }
        if (isNew) {
            eldao.saveEmployeeLocker(new Employeelocker("id", dateFormat.parse(receivedate), dateFormat.parse(returndate), notes, new Locker(locker), new Employee(employee)));
        }
        return "redirect:/el/Employeelocker";
    }

    @RequestMapping(value = "/el/emplockerEdit", method = RequestMethod.POST)
    public String edit(@RequestParam("id") String id, @RequestParam("receivedate") String receivedate, @RequestParam("returndate") String returndate,
            @RequestParam("notes") String notes, @RequestParam("locker") String locker, @RequestParam("employee") String employee) throws ParseException {
        boolean isNew = true;
        for (Employeelocker data2 : eldao.findAll()) {
            if (locker.equalsIgnoreCase(data2.getLocker().getId())) {
                isNew = false;
            }
        }
        if (isNew) {
            eldao.saveEmployeeLocker(new Employeelocker(id, dateFormat.parse(receivedate), dateFormat.parse(returndate), notes, new Locker(locker), new Employee(employee)));
        }
        return "redirect:/el/Employeelocker";
    }

    @RequestMapping(value = "/el/emplockerDelete", method = RequestMethod.GET)
    public String delete(@RequestParam(value = "empid") String id) {
        eldao.deleteEmployeeLockerById(id);
        return "redirect:/el/Employeelocker";
    }

    @GetMapping("/el/Employeeaccess")
    public String Employeeaccess(Model model) {
        model.addAttribute("empaccessData", o.findAll());
        model.addAttribute("empl", daoEmp.findAll());
        model.addAttribute("epc", o.findAll());
        model.addAttribute("access", acdao.findAll());
        model.addAttribute("empaccessSave", new Employeeaccess());
        model.addAttribute("empaccessEdit", new Employeeaccess());
        model.addAttribute("empaccessDelete", new Employeeaccess());
        return "/el/Employeeaccess";
    }

    @RequestMapping(value = "/el/empaccessSave", method = RequestMethod.POST)
    public String savee(String id, @RequestParam("receivedate") String receivedate, @RequestParam("returndate") String returndate,
            @RequestParam("notes") String notes, @RequestParam("accesscard") String accesscard, @RequestParam("employee") String employee) throws ParseException {
        boolean isNew = true;

        for (Employeeaccess data : o.findAll()) {
            if (!employee.equalsIgnoreCase(data.getEmployee().getId())) {
                if (accesscard.equalsIgnoreCase(data.getAccesscard().getId())) {
                    isNew = false;
                }
            }
        }
        if (isNew) {
            o.saveEmployeeAccess(new Employeeaccess("id", dateFormat.parse(receivedate), dateFormat.parse(returndate), notes, new Accesscard(accesscard), new Employee(employee)));
        }
        return "redirect:/el/Employeeaccess";
    }

    @RequestMapping(value = "/el/empaccessEdit", method = RequestMethod.POST)
    public String editt(@RequestParam("id") String id, @RequestParam("receivedate") String receivedate, @RequestParam("returndate") String returndate,
            @RequestParam("notes") String notes, @RequestParam("accesscard") String accesscard, @RequestParam("employee") String employee) throws ParseException {
        boolean isNew = true;
        for (Employeeaccess data2 : o.findAll()) {
            if (accesscard.equalsIgnoreCase(data2.getAccesscard().getId())) {
                isNew = false;
            }
        }
        if (isNew) {
            o.saveEmployeeAccess(new Employeeaccess(id, dateFormat.parse(receivedate), dateFormat.parse(returndate), notes, new Accesscard(accesscard), new Employee(employee)));
            new Employeeaccess().getAccesscard().getAccessnumber();
        }
        return "redirect:/el/Employeeaccess";
    }

    @RequestMapping(value = "/el/empaccessDelete", method = RequestMethod.GET)
    public String deletee(@RequestParam(value = "epcid") String id) {
        o.deleteEmployeeAccessById(id);
        return "redirect:/el/Employeeaccess";
    }

    @GetMapping("/el/Placement")
    public String Placement(Model model) {
        model.addAttribute("placeData", pdao.findAll());
        model.addAttribute("empl", daoEmp.findAll());
        model.addAttribute("comp", cr.findAll());
        model.addAttribute("placeSave", new Placement());
        model.addAttribute("placeEdit", new Placement());
        model.addAttribute("placeDelete", new Placement());
        return "/el/Placement";
    }

    @RequestMapping(value = "/el/placeSave", method = RequestMethod.POST)
    public String save(String id, @RequestParam("description") String description, @RequestParam("address") String address, @RequestParam("department") String department,
            @RequestParam("startdate") String startdate, @RequestParam("finishdate") String finishdate, @RequestParam("company") String company, @RequestParam("employee") String employee) throws ParseException {
        pdao.savePlacement(new Placement("id", description, address, department, dateFormat.parse(startdate), dateFormat.parse(finishdate), new Company(company), new Employee(employee)));
        return "redirect:/el/Placement";
    }

    @RequestMapping(value = "/el/placeEdit", method = RequestMethod.POST)
    public String edit(@RequestParam("id") String id, @RequestParam("description") String description, @RequestParam("address") String address, @RequestParam("department") String department,
            @RequestParam("startdate") String startdate, @RequestParam("finishdate") String finishdate, @RequestParam("company") String company, @RequestParam("employee") String employee) throws ParseException {
        pdao.savePlacement(new Placement(id, description, address, department, dateFormat.parse(startdate), dateFormat.parse(finishdate), new Company(company), new Employee(employee)));
        return "redirect:/el/Placement";
    }

    @RequestMapping(value = "/el/placeDelete", method = RequestMethod.GET)
    public String deletepla(@RequestParam(value = "pladid") String id) {
        pdao.deletePlacementById(id);
        return "redirect:/el/Placement";
    }

}
