package moveside.web;


import lombok.RequiredArgsConstructor;
import moveside.domain.Entity.ESL;
import moveside.domain.Entity.Store;
import moveside.domain.Repository.EslRepository;
import moveside.service.EslService;
import moveside.service.MenuService;
import moveside.service.StoreService;
import moveside.web.dto.EslListResponseDto;
import moveside.web.dto.MenuListResponseDto;
import moveside.web.dto.StoreLoginDto;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.StringWriter;
import java.nio.charset.Charset;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;


@RequiredArgsConstructor
@RestController
public class IndexController {

    private final HttpSession httpSession;
    private final StoreService storeService;
    private final MenuService menuService;
    private final EslRepository eslRepository;
    private final EslService eslService;
    @GetMapping("/menu")
    public ResponseEntity<List<MenuListResponseDto>> Menu(Model model, HttpServletRequest request) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));
        HttpSession session = request.getSession();
//        Store store = (Store)session.getAttribute("loginMember");
//        model.addAttribute("menus", menuService.findAllDesc(store.getName()));
        return new ResponseEntity<>(menuService.findAllASC(),headers,HttpStatus.OK);
    }
    @GetMapping("/esl")
    public ResponseEntity<List<EslListResponseDto>> ESL(Model model, HttpServletRequest request) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));
        HttpSession session = request.getSession();
//        Store store = (Store)session.getAttribute("loginMember");
//        model.addAttribute("menus", menuService.findAllDesc(store.getName()));
        return new ResponseEntity<>(eslService.findAllESL(),headers,HttpStatus.OK);
    }
    @GetMapping("/login")
    public String Login(Model model, HttpServletRequest request) {
        HttpSession loginSession = request.getSession();
        List<String> store_code = storeService.findAllCode();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));

        String input = request.getParameter("code");
        for(String el : store_code) {
            System.out.println(el);
            if(el.equals(input)) {
                Store loginMember = storeService.findStore(input);
                loginSession.setAttribute("loginMember",loginMember);
                return el;
            }
        }
        return "NULL";
    }
    @GetMapping("/download")
    public ResponseEntity<byte[]> download() throws IOException {
        List<ESL> esl = eslRepository.findAll();

        String[] cols = {"tag_id","openTime","closeTime","breakTime1","breakTime2","explain","menuName1","menuName2","menuCost1","menuCost2"};
        String filename = "Import_";

        byte[] CSVData= null;
        CSVPrinter csvPrinter = null;
        StringWriter sw = new StringWriter();
        csvPrinter = new CSVPrinter(sw, CSVFormat.DEFAULT.withHeader(cols));
        for (ESL el : esl) {
            List<String> data = Arrays.asList(
                    String.valueOf(el.getId()),
                    el.getOpenTime(),
                    el.getCloseTime(),
                    el.getBreakTime1(),
                    el.getBreakTime2(),
                    el.getExp(),
                    el.getMenuName1(),
                    el.getMenuName2(),
                    el.getMenuCost1(),
                    el.getMenuCost2()
            );
            csvPrinter.printRecord(data);
        }

        sw.flush();
        CSVData = sw.toString().getBytes("UTF-8");

        LocalDate now = LocalDate.now();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        filename += now.format(formatter);
        LocalTime nowTime = LocalTime.now();
        formatter = DateTimeFormatter.ofPattern("HHmmss");
        filename += nowTime.format(formatter);



        HttpHeaders header = new HttpHeaders();
        header.add("Content-Type", "text/csv; charset=MS932");
        header.setContentDispositionFormData("filename",filename+".csv");
        header.setContentLength(CSVData.length);
        return new ResponseEntity<>(CSVData,header,HttpStatus.OK);
    }
    @GetMapping("/menu/save")
    public String menuSave() {
        return "menu-save";
    }



    @GetMapping("/")
    public String index(Model model) {

        return "index";
    }


    @GetMapping("/esl/update/{id}")
    public String esl_update() { return "ESL-save";}
}
