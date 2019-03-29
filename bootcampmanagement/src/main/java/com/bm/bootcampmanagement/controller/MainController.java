/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bm.bootcampmanagement.controller;

import com.bm.bootcampmanagement.entities.Accesscard;
import com.bm.bootcampmanagement.entities.Batchclass;
import com.bm.bootcampmanagement.entities.Company;
import com.bm.bootcampmanagement.entities.District;
import com.bm.bootcampmanagement.entities.Employee;
import com.bm.bootcampmanagement.entities.Employeeaccess;
import com.bm.bootcampmanagement.entities.Employeelocker;
import com.bm.bootcampmanagement.entities.Employeerole;
import com.bm.bootcampmanagement.entities.Idcard;
import com.bm.bootcampmanagement.entities.Locker;
import com.bm.bootcampmanagement.entities.Participant;
import com.bm.bootcampmanagement.entities.Placement;
import com.bm.bootcampmanagement.entities.Religion;
import com.bm.bootcampmanagement.entities.Role;
import com.bm.bootcampmanagement.entities.Village;
import com.bm.bootcampmanagement.repository.el.CompanyRepository;
import com.bm.bootcampmanagement.repository.el.EmployeeAccessRepository;
import com.bm.bootcampmanagement.services.BCrypt;
import com.bm.bootcampmanagement.services.DBFileStorageService;
import com.bm.bootcampmanagement.services.MailService;
import com.bm.bootcampmanagement.services.EmployeeDAO;
import com.bm.bootcampmanagement.services.UploadFileResponse;
import com.bm.bootcampmanagement.services.bm.BatchclassDAO;
import com.bm.bootcampmanagement.services.bm.ParticipantDAO;
import com.bm.bootcampmanagement.services.EmployeeRoleDAO;
import com.bm.bootcampmanagement.services.RoleDAO;
import com.bm.bootcampmanagement.services.cv.ReligionDAO;
import com.bm.bootcampmanagement.services.el.AccessCardDAO;
import com.bm.bootcampmanagement.services.el.DistrictDAO;
import com.bm.bootcampmanagement.services.el.EmployeeAccessDAO;
import com.bm.bootcampmanagement.services.el.EmployeeLockerDAO;
import com.bm.bootcampmanagement.services.el.IdCardDAO;
import com.bm.bootcampmanagement.services.el.LockerDAO;
import com.bm.bootcampmanagement.services.el.PlacementDAO;
import com.bm.bootcampmanagement.services.el.VillageDAO;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
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

//    @Autowired
//    EmployeeAccessRepository ear;
//    @Autowired
//    CompanyRepository cr;
//    @Autowired
//    AccessCardDAO acdao;
//    @Autowired
//    LockerDAO ldao;
//    @Autowired
//    IdCardDAO cardDAO;
//    @Autowired
//    EmployeeLockerDAO eldao;
//    @Autowired
//    EmployeeAccessDAO o;
//    @Autowired
//    PlacementDAO pdao;
    @Autowired
    EmployeeDAO daoEmp;
    @Autowired
    BatchclassDAO daoBC;
    @Autowired
    RoleDAO daoRl;
    @Autowired
    EmployeeRoleDAO daoEmpR;
    @Autowired
    ParticipantDAO daoP;
    @Autowired
    ReligionDAO daoR;
    @Autowired
    VillageDAO daoLV;
    @Autowired
    DistrictDAO daoLD;

    @Autowired
    private static Logger log = LoggerFactory.getLogger(MainController.class);
    private SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
    private SimpleDateFormat dateFormatuci = new SimpleDateFormat("yyyy-MM-dd");

    @Autowired
    private MailService mailService;

    @Autowired
    private DBFileStorageService DBFileStorageService;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/*")
    public String error() {
        return "redirect:/error";
    }

    @GetMapping("/error")
    public String errorpage() {
        return "/error";
    }

    @PostMapping("/login")
//    @ResponseBody
    public String checkLogin(@RequestParam("idEmp") String id, @RequestParam("passEmp") String password, HttpSession session, HttpServletRequest request, HttpServletResponse response) {
        if (daoEmp.findById(id) != null) {
            Employee employee = daoEmp.findById(id);
            if (BCrypt.checkpw(password, employee.getPassword())) {
                request.getSession().setAttribute("login", id);
                Iterable<Batchclass> batchclasses = daoBC.findAll();
                for (Batchclass data : batchclasses) {
                    if (data.getTrainer().getId().equals(id)) {
                        session.setAttribute("istrainer", id);
                    }
                }
                Iterable<Employeerole> employeeroles = daoEmpR.findAll();
                for (Employeerole data : employeeroles) {
                    if (data.getEmployee().getId().equalsIgnoreCase(id) && data.getRole().getId().equalsIgnoreCase("CVR0")) {
                        request.getSession().setAttribute("isadmin", id);
                    }
                }
                Iterable<Participant> participants = daoP.findAll();
                for (Participant data : participants) {
                    if (data.getId().equalsIgnoreCase(id)) {
                        request.getSession().setAttribute("isparticipant", id);
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
    public String dashboard(Model m, HttpServletRequest request) {
        String id = request.getSession().getAttribute("login").toString();
        m.addAttribute("employee", daoEmp.findById(id));
        return "/dashboard";
    }

    @GetMapping("/activation")
    public String activation(@RequestParam("id") String id, @RequestParam("ca") String password,Model model) {
        Employee emp = daoEmp.findById(id);
        if (password.equalsIgnoreCase(emp.getPassword())) {
            emp.setIsdeleted(new Short("0"));
            daoEmp.save(emp);
            model.addAttribute("idemp", id);
        }else
            return "redirect:/error";
        return "/activation";
    }

    @PostMapping("/newpassword")
    public String newpassString(@RequestParam("idemp")String id, @RequestParam("newpass")String pass) {
        Employee emp = daoEmp.findById(id);
        emp.setPassword(BCrypt.hashpw(pass, BCrypt.gensalt()));
        daoEmp.save(emp);
        return "redirect:/logout";
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
                    phone, dateFormatuci.parse(onboarddate),
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

    //upload foto
    @PostMapping("/uploadFile")
    public String uploadFile(@RequestParam("file") MultipartFile file, HttpServletRequest request) {
        Employee employee = DBFileStorageService.storeFile(file, request.getSession().getAttribute("login").toString());
//
//        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
//                .path("/downloadFile/")
//                .path(employee.getId())
//                .toUriString();
//
//        new UploadFileResponse(employee.getName(), fileDownloadUri,
//                file.getContentType(), file.getSize());
        return "redirect:/cv/cv";
    }

    @GetMapping("/downloadFile/{fileId}")
    public ResponseEntity<Resource> downloadFile(@PathVariable String fileId) {
        // Load file from database
        Employee employee = DBFileStorageService.getFile(fileId);

        return ResponseEntity.ok()
                .contentType(MediaType.IMAGE_JPEG)
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + employee.getName() + "\"")
                .body(new ByteArrayResource(employee.getPhoto()));
    }

    //tampilkanfoto
    @RequestMapping(value = "/lihatFile", method = RequestMethod.GET,
            produces = MediaType.IMAGE_JPEG_VALUE)
    public ResponseEntity<byte[]> getImage(HttpServletRequest request) throws IOException {
        Employee employee = DBFileStorageService.getFile(request.getSession().getAttribute("login").toString());

        return ResponseEntity
                .ok()
                .contentType(MediaType.IMAGE_JPEG)
                .body(employee.getPhoto());
    }

//    @RequestMapping("/get-text")
//    public @ResponseBody
//    String getText() {
//        return "Hello world";
//    }
    @GetMapping("/logout")
    public String logout(HttpServletRequest request) {
        request.getSession().removeAttribute("login");
        request.getSession().removeAttribute("isadmin");
        request.getSession().removeAttribute("istrainer");
        request.getSession().removeAttribute("isparticipant");
        return "redirect:/";
    }

    //    Employee Role
    @GetMapping("/employeerole")
    public String employeerole(Model m) {
        m.addAttribute("empData", daoEmp.findAll());
        m.addAttribute("roleData", daoRl.findAll());
        m.addAttribute("emproleData", daoEmpR.findAll());
        m.addAttribute("emprolesave", new Employeerole());
//        m.addAttribute("emproleedit", new Employeerole());
//        m.addAttribute("emproledelete", new Employeerole());
        return "/employeerole";
    }

    @RequestMapping(value = "/emprolesave", method = RequestMethod.POST) //@PostMapping("/regionsave")
    public String saveEmployeerole(
            @RequestParam("ername") String ername,
            @RequestParam("errole") String errole,
            @RequestParam("erstartdate") String erstartdate,
            @RequestParam("erenddate") String erenddate) {
//        daoEmpR.save(new Employeerole("id", dateFormat.parse(erstartdate), dateFormat.parse(erenddate), Short.MIN_VALUE, errole, employee));
        return "redirect:/employeerole";
    }

    @RequestMapping(value = "/emproleedit", method = RequestMethod.POST) //@PostMapping("/regionsave")
    public String editEmployeerole(@ModelAttribute("emproleedit") Employeerole employeerole) {
        daoEmpR.save(employeerole);
        return "redirect:/employeerole";

    }

    @GetMapping("/deleteEmpRole/{id}")
    public String saveEmployeerole(@PathVariable("id") String id, HttpServletRequest request) {
        List<Employeerole> list = (List<Employeerole>) daoEmpR.findAll();
        for (Employeerole data : list) {
            if (data.getId().equalsIgnoreCase(id)) {
                if (!data.getEmployee().getId().equalsIgnoreCase(request.getSession().getAttribute("login").toString())) {
                    return "redirect:/employeerole";
                }
                daoEmpR.save(new Employeerole(data.getId(), data.getStartdate(), data.getEnddate(), new Short("1"), new Role(data.getRole().getId()), new Employee(data.getEmployee().getId())));
            }
        }
        return "redirect:/employeerole";
    }
//    ENDOF Employee Role

//    @RequestMapping(value = "/achievementdelete", method = RequestMethod.GET)
//    public String deleteach(@RequestParam(value = "achid") String id) {
//        adao.delete(id);
//        return "redirect:/cv";
//    }
//
//    @RequestMapping(value = "/organizationdelete", method = RequestMethod.GET)
//    public String deleteorg(@RequestParam(value = "orgid") String id) {
//        odao.delete(id);
//        return "redirect:/cv";
//    }
//
//    @RequestMapping(value = "/certificatedelete", method = RequestMethod.GET)
//    public String deletecert(@RequestParam(value = "certid") String id) {
//        cdao.delete(id);
//        return "redirect:/cv";
//    }
//
//    @RequestMapping(value = "/educationdelete", method = RequestMethod.GET)
//    public String deleteedu(@RequestParam(value = "eduid") String id) {
//        edao.delete(id);
//        return "redirect:/cv";
//    }
//    @GetMapping("/lihatcv")
//    public String lihatcv(Model mod) {
//        mod.addAttribute("employee", daoEmp.findById("14201"));
//        mod.addAttribute("education", daoEmp.findById("14201").getEducationhistoryList());
//        mod.addAttribute("achievementData", daoEmp.findById("14201").getAchievementList());
//        mod.addAttribute("organizationData", daoEmp.findById("14201").getOrganizationList());
//        mod.addAttribute("certificateData", daoEmp.findById("14201").getEmployeecertificationList());
//        mod.addAttribute("languageData", daoEmp.findById("14201").getEmployeelanguageList());
//        mod.addAttribute("skillData", daoEmp.findById("14201").getEmployeeskillList());
//        mod.addAttribute("workexperienceData", daoEmp.findById("14201").getWorkexperienceList());
//        return "/lihatCV";
//    }
}
