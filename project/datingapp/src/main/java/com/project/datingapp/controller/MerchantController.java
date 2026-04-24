package com.project.datingapp.controller;

import com.project.datingapp.config.AuthPath;
import com.project.datingapp.dto.MerchantRegisterDTO;
import com.project.datingapp.service.MerchantService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/merchant") // 建議加上路徑前綴
public class MerchantController {

    @Autowired
    private MerchantService merchantService;

    /**
     * 顯示商家註冊頁面
     * 路徑：/merchant/register
     */
    @GetMapping(AuthPath.REGISTER)
    public String showRegistrationForm(Model model) {
        // 傳入空物件讓表單綁定
        model.addAttribute("merchantForm", new MerchantRegisterDTO());
        return "merchant/register";
    }

    /**
     * 商家後台首頁（發佈課程頁）
     * 路徑：/merchant/main
     */
    @GetMapping(AuthPath.MAIN)
    public String merchantMainPage() {
        // 對應你剛才要的課程發佈頁：resources/templates/merchant/main.html
        return "merchant/main";
    }

    /**
     * 處理商家註冊表單
     * 路徑：/merchant/register (POST)
     */
    @PostMapping(AuthPath.REGISTER)
    public String registerMerchant(
            @ModelAttribute("merchantForm") MerchantRegisterDTO dto,
            RedirectAttributes redirectAttributes) {

        try {
            merchantService.register(dto);
            redirectAttributes.addFlashAttribute("successMessage", "商家註冊成功，請等待管理員審核");
            return AuthPath.REDIRECT_LOGIN;
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", e.getMessage());
            return "redirect:" + AuthPath.MERCHANT_PREFIX + AuthPath.REGISTER;
        }
    }
}