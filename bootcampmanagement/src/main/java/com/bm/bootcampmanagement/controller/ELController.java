/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bm.bootcampmanagement.controller;

import com.bm.bootcampmanagement.entities.Accesscard;
import com.bm.bootcampmanagement.entities.Achievement;
import com.bm.bootcampmanagement.entities.Batchclass;
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
import com.bm.bootcampmanagement.entities.Participant;
import com.bm.bootcampmanagement.entities.Placement;
import com.bm.bootcampmanagement.repository.el.CompanyRepository;
import com.bm.bootcampmanagement.repository.el.EmployeeAccessRepository;
import com.bm.bootcampmanagement.services.EmployeeDAO;
import com.bm.bootcampmanagement.services.bm.BatchclassDAO;
import com.bm.bootcampmanagement.services.bm.ParticipantDAO;
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
import java.util.ArrayList;
import java.util.List;
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
    
    @Autowired
    BatchclassDAO daoBC;
    
    @Autowired
    ParticipantDAO daoP;

    private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    
    @GetMapping("/el/*")
    public String error() {
        return "redirect:/error";
    }

    
    @GetMapping("/el/Idcard")
    public String Idcard(Model model, HttpServletRequest request) {
        if (request.getSession().getAttribute("login") == null) {
            return "redirect:../logout";
        }
        String trainer = request.getSession().getAttribute("login").toString();
        List<Employee> empList = (List<Employee>) daoEmp.findAll();
        List<Batchclass> batchclassList = (List<Batchclass>) daoBC.findAll();
        List<Employee> dataEmployee = new ArrayList<>();
        boolean selectBatchclass = request.getParameter("bc") != null;
        for (int i = 0; i < empList.size(); i++) {
            boolean isTrainer = false, inClass = false;
            for (Batchclass batchclass : batchclassList) {
                if (batchclass.getTrainer().getId().equalsIgnoreCase(empList.get(i).getId())) {
                    isTrainer = true;
                }
            }
            if (selectBatchclass) {
                if (empList.get(i).getParticipant() != null) {
                    if (request.getParameter("bc").equalsIgnoreCase(empList.get(i).getParticipant().getBatchclass().getId())) {
                        inClass = true;
                    }
                }
            }
            if (empList.get(i).getIsdeleted().intValue() == 0 && !isTrainer) {
                if (inClass) {
                    dataEmployee.add(empList.get(i));
                }
            }
        }
        List<Participant> participantList = (List<Participant>) daoP.findAll();
        List<Participant> dataParticipant = new ArrayList<>();
        for (Participant data : participantList) {
            boolean isParticipant = true;
            if (selectBatchclass) {
                if (!request.getParameter("bc").equalsIgnoreCase(data.getBatchclass().getId())) {
                    isParticipant = false;
                }
            }
            if (data.getIsdeleted() == 0 && isParticipant) {
                dataParticipant.add(data);
            }
        }
        List<Batchclass> dataBatchclass = new ArrayList<>();
        for (Batchclass data : batchclassList) {
            if (data.getIsdeleted() == 0 && data.getTrainer().getId().equalsIgnoreCase(request.getSession().getAttribute("login").toString())) {
                dataBatchclass.add(data);
            }
        }
        model.addAttribute("dataBatchclass", dataBatchclass);
        model.addAttribute("idcardData", cardDAO.findAll());
        model.addAttribute("empl", dataEmployee);
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
    public String Employeelocker(Model model, HttpServletRequest request) {
        if (request.getSession().getAttribute("login") == null) {
            return "redirect:../logout";
        }
        String trainer = request.getSession().getAttribute("login").toString();
        List<Employee> empList = (List<Employee>) daoEmp.findAll();
        List<Batchclass> batchclassList = (List<Batchclass>) daoBC.findAll();
        List<Employee> dataEmployee = new ArrayList<>();
        boolean selectBatchclass = request.getParameter("bc") != null;
        for (int i = 0; i < empList.size(); i++) {
            boolean isTrainer = false, inClass = false;
            for (Batchclass batchclass : batchclassList) {
                if (batchclass.getTrainer().getId().equalsIgnoreCase(empList.get(i).getId())) {
                    isTrainer = true;
                }
            }
            if (selectBatchclass) {
                if (empList.get(i).getParticipant() != null) {
                    if (request.getParameter("bc").equalsIgnoreCase(empList.get(i).getParticipant().getBatchclass().getId())) {
                        inClass = true;
                    }
                }
            }
            if (empList.get(i).getIsdeleted().intValue() == 0 && !isTrainer) {
                if (inClass) {
                    dataEmployee.add(empList.get(i));
                }
            }
        }
        List<Participant> participantList = (List<Participant>) daoP.findAll();
        List<Participant> dataParticipant = new ArrayList<>();
        for (Participant data : participantList) {
            boolean isParticipant = true;
            if (selectBatchclass) {
                if (!request.getParameter("bc").equalsIgnoreCase(data.getBatchclass().getId())) {
                    isParticipant = false;
                }
            }
            if (data.getIsdeleted() == 0 && isParticipant) {
                dataParticipant.add(data);
            }
        }
        List<Batchclass> dataBatchclass = new ArrayList<>();
        for (Batchclass data : batchclassList) {
            if (data.getIsdeleted() == 0 && data.getTrainer().getId().equalsIgnoreCase(request.getSession().getAttribute("login").toString())) {
                dataBatchclass.add(data);
            }
        }
        model.addAttribute("dataBatchclass", dataBatchclass);
        model.addAttribute("emplockerData", eldao.findAll());
        model.addAttribute("datalock", ldao.findAll());
        model.addAttribute("empl", dataEmployee);
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
    public String Employeeaccess(Model model, HttpServletRequest request) {
        if (request.getSession().getAttribute("login") == null) {
            return "redirect:../logout";
        }
        String trainer = request.getSession().getAttribute("login").toString();
        List<Employee> empList = (List<Employee>) daoEmp.findAll();
        List<Batchclass> batchclassList = (List<Batchclass>) daoBC.findAll();
        List<Employee> dataEmployee = new ArrayList<>();
        boolean selectBatchclass = request.getParameter("bc") != null;
        for (int i = 0; i < empList.size(); i++) {
            boolean isTrainer = false, inClass = false;
            for (Batchclass batchclass : batchclassList) {
                if (batchclass.getTrainer().getId().equalsIgnoreCase(empList.get(i).getId())) {
                    isTrainer = true;
                }
            }
            if (selectBatchclass) {
                if (empList.get(i).getParticipant() != null) {
                    if (request.getParameter("bc").equalsIgnoreCase(empList.get(i).getParticipant().getBatchclass().getId())) {
                        inClass = true;
                    }
                }
            }
            if (empList.get(i).getIsdeleted().intValue() == 0 && !isTrainer) {
                if (inClass) {
                    dataEmployee.add(empList.get(i));
                }
            }
        }
        List<Participant> participantList = (List<Participant>) daoP.findAll();
        List<Participant> dataParticipant = new ArrayList<>();
        for (Participant data : participantList) {
            boolean isParticipant = true;
            if (selectBatchclass) {
                if (!request.getParameter("bc").equalsIgnoreCase(data.getBatchclass().getId())) {
                    isParticipant = false;
                }
            }
            if (data.getIsdeleted() == 0 && isParticipant) {
                dataParticipant.add(data);
            }
        }
        List<Batchclass> dataBatchclass = new ArrayList<>();
        for (Batchclass data : batchclassList) {
            if (data.getIsdeleted() == 0 && data.getTrainer().getId().equalsIgnoreCase(request.getSession().getAttribute("login").toString())) {
                dataBatchclass.add(data);
            }
        }
        model.addAttribute("dataBatchclass", dataBatchclass);
        model.addAttribute("empaccessData", o.findAll());
        model.addAttribute("empl", dataEmployee);
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
    public String Placement(Model model, HttpServletRequest request) {
        if (request.getSession().getAttribute("login") == null) {
            return "redirect:../logout";
        }
        String trainer = request.getSession().getAttribute("login").toString();
        List<Employee> empList = (List<Employee>) daoEmp.findAll();
        List<Batchclass> batchclassList = (List<Batchclass>) daoBC.findAll();
        List<Employee> dataEmployee = new ArrayList<>();
        boolean selectBatchclass = request.getParameter("bc") != null;
        for (int i = 0; i < empList.size(); i++) {
            boolean isTrainer = false, inClass = false;
            for (Batchclass batchclass : batchclassList) {
                if (batchclass.getTrainer().getId().equalsIgnoreCase(empList.get(i).getId())) {
                    isTrainer = true;
                }
            }
            if (selectBatchclass) {
                if (empList.get(i).getParticipant() != null) {
                    if (request.getParameter("bc").equalsIgnoreCase(empList.get(i).getParticipant().getBatchclass().getId())) {
                        inClass = true;
                    }
                }
            }
            if (empList.get(i).getIsdeleted().intValue() == 0 && !isTrainer) {
                if (inClass) {
                    dataEmployee.add(empList.get(i));
                }
            }
        }
        List<Participant> participantList = (List<Participant>) daoP.findAll();
        List<Participant> dataParticipant = new ArrayList<>();
        for (Participant data : participantList) {
            boolean isParticipant = true;
            if (selectBatchclass) {
                if (!request.getParameter("bc").equalsIgnoreCase(data.getBatchclass().getId())) {
                    isParticipant = false;
                }
            }
            if (data.getIsdeleted() == 0 && isParticipant) {
                dataParticipant.add(data);
            }
        }
        List<Batchclass> dataBatchclass = new ArrayList<>();
        for (Batchclass data : batchclassList) {
            if (data.getIsdeleted() == 0 && data.getTrainer().getId().equalsIgnoreCase(request.getSession().getAttribute("login").toString())) {
                dataBatchclass.add(data);
            }
        }
        model.addAttribute("dataBatchclass", dataBatchclass);
        model.addAttribute("placeData", pdao.findAll());
        model.addAttribute("comp", cr.findAll());
        model.addAttribute("empl", dataEmployee);
        model.addAttribute("placeSave", new Placement());
        model.addAttribute("placeEdit", new Placement());
        model.addAttribute("placeDelete", new Placement());
        return "/el/Placement";
    }

    @RequestMapping(value = "/el/placeSave", method = RequestMethod.POST)
    public String save(String id, @RequestParam("description") String description, @RequestParam("department") String department,
            @RequestParam("startdate") String startdate, @RequestParam("finishdate") String finishdate, @RequestParam("company") String company, @RequestParam("employee") String employee) throws ParseException {
        pdao.savePlacement(new Placement("id", description, " ", department, dateFormat.parse(startdate), dateFormat.parse(finishdate), new Company(company), new Employee(employee)));
        return "redirect:/el/Placement";
    }

    @RequestMapping(value = "/el/placeEdit", method = RequestMethod.POST)
    public String edit(@RequestParam("id") String id, @RequestParam("description") String description, @RequestParam("department") String department,
            @RequestParam("startdate") String startdate, @RequestParam("finishdate") String finishdate, @RequestParam("company") String company, @RequestParam("employee") String employee) throws ParseException {
        pdao.savePlacement(new Placement(id, description, " ", department, dateFormat.parse(startdate), dateFormat.parse(finishdate), new Company(company), new Employee(employee)));
        return "redirect:/el/Placement";
    }

    @RequestMapping(value = "/el/placeDelete", method = RequestMethod.GET)
    public String deletepla(@RequestParam(value = "pladid") String id) {
        pdao.deletePlacementById(id);
        return "redirect:/el/Placement";
    }

}
