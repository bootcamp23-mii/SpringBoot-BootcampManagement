/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bm.bootcampmanagement.controller;

import com.bm.bootcampmanagement.entities.Accesscard;
import com.bm.bootcampmanagement.entities.Achievement;
import com.bm.bootcampmanagement.entities.Batchclass;
import com.bm.bootcampmanagement.entities.Company;
import com.bm.bootcampmanagement.entities.District;
import com.bm.bootcampmanagement.entities.Educationhistory;
import com.bm.bootcampmanagement.entities.Employee;
import com.bm.bootcampmanagement.entities.Employeeaccess;
import com.bm.bootcampmanagement.entities.Employeecertification;
import com.bm.bootcampmanagement.entities.Employeelocker;
import com.bm.bootcampmanagement.entities.Employeerole;
import com.bm.bootcampmanagement.entities.Idcard;
import com.bm.bootcampmanagement.entities.Locker;
import com.bm.bootcampmanagement.entities.Organization;
import com.bm.bootcampmanagement.entities.Participant;
import com.bm.bootcampmanagement.entities.Placement;
import com.bm.bootcampmanagement.entities.Religion;
import com.bm.bootcampmanagement.entities.Village;
import com.bm.bootcampmanagement.services.BCrypt;
import com.bm.bootcampmanagement.services.DBFileStorageService;
import com.bm.bootcampmanagement.services.MailService;
import com.bm.bootcampmanagement.services.EmployeeDAO;
import com.bm.bootcampmanagement.services.UploadFileResponse;
import com.bm.bootcampmanagement.services.bm.BatchclassDAO;
import com.bm.bootcampmanagement.services.bm.ParticipantDAO;
import com.bm.bootcampmanagement.services.cv.AchievementDAO;
import com.bm.bootcampmanagement.services.cv.EducationHistoryDAO;
import com.bm.bootcampmanagement.services.cv.EmployeeCertificationDAO;
import com.bm.bootcampmanagement.services.cv.EmployeeLanguageDAO;
import com.bm.bootcampmanagement.services.cv.EmployeeRoleDAO;
import com.bm.bootcampmanagement.services.cv.EmployeeSkillDAO;
import com.bm.bootcampmanagement.services.cv.OrganizationDAO;
import com.bm.bootcampmanagement.services.cv.ReligionDAO;
import com.bm.bootcampmanagement.services.cv.WorkExperienceDAO;
import com.bm.bootcampmanagement.services.el.DistrictDAO;
import com.bm.bootcampmanagement.services.el.EmployeeAccessDAO;
import com.bm.bootcampmanagement.services.el.EmployeeLockerDAO;
import com.bm.bootcampmanagement.services.el.IdCardDAO;
import com.bm.bootcampmanagement.services.el.PlacementDAO;
import com.bm.bootcampmanagement.services.el.VillageDAO;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

/**
 *
 * @author FES
 */
@Controller
public class MainController {
    
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
    BatchclassDAO daoBC;
    @Autowired
    EmployeeRoleDAO daoEmpR;
    @Autowired
    EmployeeLanguageDAO daoEmpL;
    @Autowired
    EmployeeSkillDAO daoEmpS;
    @Autowired
    WorkExperienceDAO daoW;
    @Autowired
    ParticipantDAO daoP;
    @Autowired
    ReligionDAO daoR;
    @Autowired
    VillageDAO daoLV;
    @Autowired
    DistrictDAO daoLD;
    @Autowired
    AchievementDAO adao;
    @Autowired
    OrganizationDAO odao;
    @Autowired
    EducationHistoryDAO edao;

    @Autowired
    EmployeeCertificationDAO cdao;
    @Autowired
    private static Logger log = LoggerFactory.getLogger(MainController.class);
    private SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

    @Autowired
    private MailService mailService;

    @Autowired
    private DBFileStorageService DBFileStorageService;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @PostMapping("/login")
//    @ResponseBody
    public String checkLogin(@RequestParam("idEmp") String id, @RequestParam("passEmp") String password, HttpSession session, HttpServletRequest request, HttpServletResponse response) {
        if (daoEmp.findById(id) != null) {
            Employee employee = daoEmp.findById(id);
            if (BCrypt.checkpw(password, employee.getPassword())) {
                request.getSession().setAttribute("login", employee);
                Iterable<Batchclass> batchclasses = daoBC.findAll();
                for (Batchclass data : batchclasses) {
                    if (data.getTrainer().equals(id)) {
                        System.out.println("masuk");
                        request.getSession().setAttribute("isTrainer", id);
                    }
                }
                Iterable<Employeerole> employeeroles = daoEmpR.findAll();
                for (Employeerole data : employeeroles) {
                    if (data.getEmployee().getId().equalsIgnoreCase(id) && data.getRole().getId().equalsIgnoreCase("CVR0")) {
                        request.getSession().setAttribute("isAdmin", id);
                    }
                }
                Iterable<Participant> participants = daoP.findAll();
                for (Participant data : participants) {
                    if (data.getId().equalsIgnoreCase(id)) {
                        request.getSession().setAttribute("isParticipant", id);
                    }
                }

                return "redirect:/dashboard";
            }
        }
        return "redirect:/index/";
    }

    @PostMapping("/register")
//    @ResponseBody
    public String register(Model model) {

        return "redirect:/register";
    }

    @GetMapping("/dashboard")
    public String dashboard() {
        return "/dashboard";
    }

    @GetMapping("/activation")
    public String activation(@RequestParam("id") String id, @RequestParam("ca") String password) {
        Employee emp = daoEmp.findById(id);
        if (password.equalsIgnoreCase(emp.getPassword())) {
            emp.setIsdeleted(new Short("0"));
            daoEmp.save(emp);
        }
        return "/dashboard";
    }

    @GetMapping("/registration")
    public String registration(Model model) {
        model.addAttribute("dataReligion", daoR.findAll());
        model.addAttribute("dataVillage", daoLV.findAll());
        model.addAttribute("dataDistrict", daoLD.findAll());
        return "/register";
    }

    @PostMapping("/insertRegister")
    public String saveEmployee(
            @RequestParam("name") String name, @RequestParam("birthplace") String birthplace,
             @RequestParam("birthdate") String birthdate, @RequestParam("email") String email,
             @RequestParam("gender") String gender, @RequestParam("religion") String religion,
             @RequestParam("phone") String phone, @RequestParam("village") String village,
             @RequestParam("marriedstatus") String marriedstatus, @RequestParam("address") String address,
             @RequestParam("onboarddate") String onboarddate, @RequestParam("hiringlocation") String hiringlocation
    ) {
        try {
            Employee emp = new Employee("-", name, dateFormat.parse(birthdate),
                    new Short(gender), new Short(marriedstatus), address, email,
                    phone, dateFormat.parse(onboarddate),
                    BCrypt.hashpw(phone, BCrypt.gensalt()), "Phone Number",
                    phone, null, new Short("1"), new District(birthplace),
                    new District(hiringlocation), new Religion(religion),
                    new Village(village));
            daoEmp.save(emp);
            for (Employee data : daoEmp.findAll()) {
                if (data.getEmail().equalsIgnoreCase(email)) {
                    mailService.sendMail(email, "New Account for " + data.getName(), "Congratulation...", data.getName(), "Your account has been created. Please activation your account by click this link.", "http://localhost:8083/activation?id=" + data.getId() + "&ca=" + data.getPassword());
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return "redirect:/registration";
    }

    @GetMapping("/upload")
    public String upload() {
        return "/upload";
    }

    @PostMapping("/uploadFile")
    public String uploadFile(@RequestParam("file") MultipartFile file) {
        Employee employee = DBFileStorageService.storeFile(file);
//
        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/downloadFile/")
                .path(employee.getId())
                .toUriString();

        new UploadFileResponse(employee.getName(), fileDownloadUri,
                file.getContentType(), file.getSize());
        return "redirect:/";
    }

//    @PostMapping("/uploadMultipleFiles")
//    public List<UploadFileResponse> uploadMultipleFiles(@RequestParam("files") MultipartFile[] files) {
//        return Arrays.asList(files)
//                .stream()
//                .map(file -> uploadFile(file))
//                .collect(Collectors.toList());
//    }
    @GetMapping("/downloadFile/{fileId}")
    public ResponseEntity<Resource> downloadFile(@PathVariable String fileId) {
        // Load file from database
        Employee employee = DBFileStorageService.getFile(fileId);

        return ResponseEntity.ok()
                .contentType(MediaType.IMAGE_JPEG)
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + employee.getName() + "\"")
                .body(new ByteArrayResource(employee.getPhoto()));
    }

    @GetMapping("/lihatFile")
    public ResponseEntity<byte[]> getImage() throws IOException {
        Employee employee = DBFileStorageService.getFile("14304");

        return ResponseEntity
                .ok()
                .contentType(MediaType.IMAGE_JPEG)
                .body(employee.getPhoto());
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request) {
        request.getSession().removeAttribute("login");
        request.getSession().removeAttribute("isAdmin");
        request.getSession().removeAttribute("isTrainer");
        request.getSession().removeAttribute("isParticipant");
        return "redirect:/";
    }

    //    Employee Role
    @GetMapping("/employeerole")
    public String employeerole(Model m) {
        m.addAttribute("emproleData", daoEmpR.findAll());
//        m.addAttribute("emprolesave", new Employeerole());
//        m.addAttribute("emproleedit", new Employeerole());
//        m.addAttribute("emproledelete", new Employeerole());
        return "employeerole";
    }

    @RequestMapping(value = "/emprolesave", method = RequestMethod.POST) //@PostMapping("/regionsave")
    public String save(@ModelAttribute("emprolesave") Employeerole employeerole) {
        daoEmpR.save(employeerole);
        return "redirect:/employeerole";
    }

    @RequestMapping(value = "/emproleedit", method = RequestMethod.POST) //@PostMapping("/regionsave")
    public String edit(@ModelAttribute("emproleedit") Employeerole employeerole) {
        daoEmpR.save(employeerole);
        return "redirect:/employeerole";
    }

    @RequestMapping(value = "/emproledelete", method = RequestMethod.POST) //@PostMapping("/regiondelete")
    public String delete(@ModelAttribute("emproleedit") Employeerole employeerole) {
        daoEmpR.delete(employeerole.getId());
        return "redirect:/employeerole";
    }

    @RequestMapping(value = "/emproledelete/{id}", method = RequestMethod.GET) //@PostMapping("/regiondelete")
    public ModelAndView delete(@PathVariable String id, ModelMap model) {
        daoEmpR.delete(id);
        return new ModelAndView("redirect:/employeerole");
    }
//    ENDOF Employee Role

//    Employee Language
    @GetMapping("/employeelanguage")
    public String employeelanguage(Model m) {
        m.addAttribute("emplangData", daoEmpL.findAll());

        return "employeelanguage";
    }
//    ENDOF Employee Language

//    Employee Skill
    @GetMapping("/employeeskill")
    public String employeeskill(Model m) {
        m.addAttribute("empskillData", daoEmpS.findAll());

        return "employeeskill";
    }
//    ENDOF Employee Skill

//    Work Experience
    @GetMapping("/workexperience")
    public String workexperience(Model m) {
        m.addAttribute("workexpData", daoW.findAll());

        return "workexperience";
    }
//    ENDOF Work Experience

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
        return "/cv";
    }

    @RequestMapping(value = "/achievementsave", method = RequestMethod.POST)  //@PostMapping("/regionsave")
    public String savee(@RequestParam("sid") String id, @RequestParam("sname") String name) {
        adao.save(new Achievement(id, name));
        return "redirect:/cv";
    }
    
    @GetMapping("/Idcard")
    public String Idcard(Model model) {
        model.addAttribute("idcardData", cardDAO.findAll());
        model.addAttribute("idcardSave", new Idcard());
        model.addAttribute("idcardEdit", new Idcard());
        model.addAttribute("idcardDelete", new Idcard());
        return "/Idcard";
    }

    @RequestMapping(value = "/idcardSave", method = RequestMethod.POST)  //@PostMapping("/regionsave")
    public String save(String id, @RequestParam("receivedate") String receivedate, @RequestParam("returndate") String returndate,
            @RequestParam("note") String note, @RequestParam("employee") String employee) throws ParseException {
        cardDAO.saveIdCard(new Idcard("id", dateFormat.parse(receivedate), dateFormat.parse(returndate), note, new Employee(employee)));
        return "redirect:/Idcard";
    }

    @RequestMapping(value = "/idcardDelete", method = RequestMethod.GET)
    public String delete(@RequestParam("id")String id ){
        cardDAO.deleteIdCardById(id);
        return "redirect:/";
    }

    @GetMapping("/Employeelocker")
    public String Employeelocker(Model model) {
        model.addAttribute("emplockerData", eldao.findAll());
        model.addAttribute("emplockerSave", new Employeelocker());
        model.addAttribute("emplockerEdit", new Employeelocker());
        model.addAttribute("emplockerDelete", new Employeelocker());
        return "/Employeelocker";
    }

    @RequestMapping(value = "/emplockerSave", method = RequestMethod.POST)
    public String save(String id, @RequestParam("receivedate") String receivedate, @RequestParam("returndate") String returndate,
            @RequestParam("notes") String notes, @RequestParam("locker") String locker, @RequestParam("employee") String employee) throws ParseException {
        eldao.saveEmployeeLocker(new Employeelocker("id", dateFormat.parse(receivedate), dateFormat.parse(returndate), notes, new Locker(locker), new Employee(employee)));
        return "redirect:/Employeelocker";
    }

    @GetMapping("/Employeeaccess")
    public String Employeeaccess(Model model) {
        model.addAttribute("empaccessData", o.findAll());
        model.addAttribute("empaccessSave", new Employeeaccess());
        model.addAttribute("empaccessEdit", new Employeeaccess());
        model.addAttribute("empaccessDelete", new Employeeaccess());
        return "/Employeeaccess";
    }

    @RequestMapping(value = "/empaccessSave", method = RequestMethod.POST)
    public String savee(String id, @RequestParam("receivedate") String receivedate, @RequestParam("returndate") String returndate,
            @RequestParam("notes") String notes, @RequestParam("accesscard") String accesscard, @RequestParam("employee") String employee) throws ParseException {
        o.saveEmployeeAccess(new Employeeaccess("id", dateFormat.parse(receivedate), dateFormat.parse(returndate), notes, new Accesscard(accesscard).toString(), new Employee(employee)));
        return "redirect:/Employeeaccess";
    }

    @GetMapping("/Placement")
    public String Placement(Model model) {
        model.addAttribute("placeData", pdao.findAll());
        model.addAttribute("placeSave", new Placement());
        model.addAttribute("placeEdit", new Placement());
        model.addAttribute("placeDelete", new Placement());
        return "/Placement";
    }

    @RequestMapping(value = "/placeSave", method = RequestMethod.POST)
    public String save(String id, @RequestParam("description") String description, @RequestParam("address") String address, @RequestParam("department") String department,
            @RequestParam("startdate") String startdate, @RequestParam("finishdate") String finishdate, @RequestParam("company") String company, @RequestParam("employee") String employee) throws ParseException {
        pdao.savePlacement(new Placement("id", description, address, department, dateFormat.parse(startdate), dateFormat.parse(finishdate), new Company(company), new Employee(employee)));
        return "redirect:/Placement";
    }
}
