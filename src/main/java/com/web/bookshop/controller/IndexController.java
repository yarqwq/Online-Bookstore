package com.web.bookshop.controller;
import com.web.bookshop.model.Book;
import com.web.bookshop.model.User;
import com.web.bookshop.service.BookService;
import com.web.bookshop.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.UUID;
@Controller
@RequestMapping("/index")
public class IndexController {
    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public String loginConfirm(@RequestParam("username") String username,
                               @RequestParam("password") String password,
                               RedirectAttributes redirectAttributes) {
        // 登录验证
        User user = userService.findByUsername(username);
        if (user != null && user.getPassword().equals(password)) {
            redirectAttributes.addFlashAttribute("message", "登录成功！");
            return "redirect:/books"; // 重定向到获取书籍列表的方法
        } else {
            redirectAttributes.addFlashAttribute("message", "登录失败！");
            return "redirect:/index.html";
        }
    }
    @PostMapping("/register")
    public String registerUser(@RequestParam("username") String username,
                               @RequestParam("password") String password,
                               @RequestParam("email") String email,
                               @RequestParam("cellphone") String cellphone,
                               @RequestParam("address") String address,
                               RedirectAttributes redirectAttributes
                               ) {
        User user = userService.findByUsername(username);
        if (user != null) {
            redirectAttributes.addFlashAttribute("message", "账号已存在");
            return "redirect:/reg.html";
        }
        String uuid = UUID.randomUUID().toString();
        userService.createUser(new User(uuid, username, password, email, cellphone, address, false));
        redirectAttributes.addFlashAttribute("message", "注册成功！");
// 重定向到 index.html 页面
        return "redirect:/index.html";
        }
}
