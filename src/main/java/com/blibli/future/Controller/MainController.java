package com.blibli.future.Controller;

import com.blibli.future.Model.User;
import com.blibli.future.repository.UserRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Nita on 02/09/2016.
 */

@Controller
public class MainController {
    @Autowired
    private UserRepository userRepo;

    private Logger log = Logger.getLogger(MainController.class.getName());;


    @RequestMapping("/")
    public String greeting(Model model) {

        String nama = "mas dwi priyohutomo :)";
        model.addAttribute("name", nama);
        return "index";
    }
    @RequestMapping("/register")
    public String greeting2(Model model) {
        String nama2 = "pengunjung kami :)";
        model.addAttribute("pengunjung", nama2);
        return "register" ;
    }
    @PostMapping("/register")
    public String registerNewUser(@ModelAttribute User newUser, Model model){
         userRepo.save(newUser) ;
         //redirect halaman /home


        model.addAttribute("newUser", newUser);
        return "index";

    }
    @RequestMapping("/login2")
    public String greeting4(Model model) {
        String nama3 = "pengunjung kami :)";
        model.addAttribute("pengunjung2", nama3);
        return "login2";
    }
    @RequestMapping("/login")
    public String greeting5() {
        return "login" ;
        }

    @RequestMapping("/care")
    public String greeting6() {
        return "care" ;

    }
    @RequestMapping("/kitchen")
    public String greeting7() {
        return "kitchen";
    }

    @RequestMapping("/merchant/product/upload")
    public String greeting8(){ return "merchant/upload"; }

    @RequestMapping("/merchant/allProduct")
    public String greeting9(){
        log.info("Tes 234");
        return "merchant/allProduct";
    }

}
