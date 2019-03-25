/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bm.bootcampmanagement.controller;

import com.bm.bootcampmanagement.entities.Batchclass;
import com.bm.bootcampmanagement.entities.District;
import com.bm.bootcampmanagement.entities.Employee;
import com.bm.bootcampmanagement.entities.Employeerole;
import com.bm.bootcampmanagement.entities.Participant;
import com.bm.bootcampmanagement.entities.Religion;
import com.bm.bootcampmanagement.entities.Village;
import com.bm.bootcampmanagement.services.BCrypt;
import com.bm.bootcampmanagement.services.DBFileStorageService;
import com.bm.bootcampmanagement.services.MailService;
import com.bm.bootcampmanagement.services.EmployeeDAO;
import com.bm.bootcampmanagement.services.UploadFileResponse;
import com.bm.bootcampmanagement.services.bm.BatchclassDAO;
import com.bm.bootcampmanagement.services.bm.ParticipantDAO;
import com.bm.bootcampmanagement.services.cv.EmployeeRoleDAO;
import com.bm.bootcampmanagement.services.cv.ReligionDAO;
import com.bm.bootcampmanagement.services.el.DistrictDAO;
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
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

/**
 *
 * @author FES
 */
@Controller
public class MainController {

    @Autowired
    EmployeeDAO daoEmp;
    @Autowired
    BatchclassDAO daoBC;
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
    public String checkLogin(@RequestParam("idEmp") String id, @RequestParam("passEmp") String password, HttpSession session,HttpServletRequest request,HttpServletResponse response) {
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
                    if (data.getEmployee().getId().equalsIgnoreCase(id)&&data.getRole().getId().equalsIgnoreCase("CVR0")) {
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
   
    @GetMapping("/registration")
    public String registration(Model model) {
        model.addAttribute("dataReligion", daoR.findAll());
        model.addAttribute("dataVillage", daoLV.findAll());
        model.addAttribute("dataDistrict", daoLD.findAll());
        return "/register";
    }
    
    @PostMapping("/insertRegister")
    public String saveEmployee(
            @RequestParam("name")String name,@RequestParam("birthplace")String birthplace
            ,@RequestParam("birthdate")String birthdate,@RequestParam("email")String email
            ,@RequestParam("gender")String gender,@RequestParam("religion")String religion
            ,@RequestParam("phone")String phone,@RequestParam("village")String village
            ,@RequestParam("marriedstatus")String marriedstatus,@RequestParam("address")String address
            ,@RequestParam("onboarddate")String onboarddate,@RequestParam("hiringlocation")String hiringlocation
    ){
        try {
            Employee emp = new Employee("c", name, dateFormat.parse(birthdate),
                    new Short(gender), new Short(marriedstatus), address, email,
                    phone, dateFormat.parse(onboarddate),
                    BCrypt.hashpw(phone, BCrypt.gensalt()), "Phone Number",
                    phone, null, new Short("0"), new District(birthplace),
                    new District(hiringlocation), new Religion(religion),
                    new Village(village));
            daoEmp.save(emp);
        } catch (ParseException ex) {
            java.util.logging.Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
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
    public String logout(HttpServletRequest request){
        request.getSession().removeAttribute("login");
        request.getSession().removeAttribute("isAdmin");
        request.getSession().removeAttribute("isTrainer");
        request.getSession().removeAttribute("isParticipant");
        return "redirect:/";
    }
}
