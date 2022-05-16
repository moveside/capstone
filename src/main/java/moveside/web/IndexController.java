package moveside.web;


import lombok.RequiredArgsConstructor;
import moveside.domain.Entity.ESL;
import moveside.domain.Entity.Store;
import moveside.domain.Repository.EslRepository;
import moveside.service.MenuService;
import moveside.service.PostsService;
import moveside.service.StoreService;
import moveside.web.dto.PostsResponseDto;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.StringWriter;
import java.util.Arrays;
import java.util.List;

@RequiredArgsConstructor
@Controller
public class IndexController {

    private final PostsService postsService;
    private final HttpSession httpSession;
    private final StoreService storeService;
    private final MenuService menuService;
    private final EslRepository eslRepository;
    @GetMapping("/menu")
    public String Menu(Model model,HttpServletRequest request) {

        HttpSession session = request.getSession();
        Store store = (Store)session.getAttribute("loginMember");
        System.out.println(store.getName());
        model.addAttribute("menus", menuService.findAllDesc(store.getName()));
        return "menu";
    }
    @GetMapping("/login")
    public String Login(Model model, HttpServletRequest request) {
        HttpSession loginSession = request.getSession();
        List<String> store_code = storeService.findAllCode();

        String input = request.getParameter("code");
        for(String el : store_code) {
            System.out.println(el);
            if(el.equals(input)) {
                Store loginMember = storeService.findStore(input);
                loginSession.setAttribute("loginMember",loginMember);
                model.addAttribute("test","ttt");
            }
        }
        return "login";
    }






    @GetMapping("/download")
    public ResponseEntity<byte[]> download() throws IOException {
        List<ESL> esl = eslRepository.findAll();


        String[] cols = {"tag_id","seat_no","menuName","menuCost","openTime","closeTime"};
        String filename = "test_esl";

        byte[] CSVData= null;
        CSVPrinter csvPrinter = null;
        StringWriter sw = new StringWriter();
        csvPrinter = new CSVPrinter(sw, CSVFormat.DEFAULT.withHeader(cols));
        for (ESL el : esl) {
            System.out.println(el.getMenuCost());
            List<String> data = Arrays.asList(
                    String.valueOf(el.getTag_id()),
                    String.valueOf(el.getSeat_no()),
                    el.getMenuName(),
                    el.getMenuCost(),
                    el.getOpenTime(),
                    el.getCloseTime()
            );
            csvPrinter.printRecord(data);
        }
        sw.flush();
        CSVData = sw.toString().getBytes("UTF-8");

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
        model.addAttribute("posts",postsService.findAllDesc());

        return "index";
    }

    @GetMapping("/posts/save")
    public String postsSave() {
        return "posts-save";
    }

    @GetMapping("/posts/update/{id}")
    public String postsUpdate(@PathVariable Long id,Model model){
        PostsResponseDto dto = postsService.findById(id);
        model.addAttribute("post",dto);

        return "posts-update";
    }
}
