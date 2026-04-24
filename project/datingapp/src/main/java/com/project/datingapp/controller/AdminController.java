package com.project.datingapp.controller;

import com.project.datingapp.config.AuthPath;
import com.project.datingapp.service.MerchantService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping(AuthPath.ADMIN_PREFIX)
public class AdminController {

  @Autowired
  private MerchantService merchantService;

  /**
   * 1. 顯示待審核商家列表
   * 路徑：/admin/merchants/verify
   */
  @GetMapping(AuthPath.MERCHANT_VERIFY)
  public String showVerifyPage(Model model) {
    model.addAttribute("merchants", merchantService.getUnverifiedMerchants());
    // 建議將 HTML 放在 admin 資料夾下，例如：return "admin/verify";
    return "admin/verify";
  }

  /**
   * 2. 執行審核通過
   * 路徑：/admin/merchants/verify/{id}
   */
  @PostMapping(AuthPath.MERCHANT_VERIFY + "/{id}")
  public String verifyMerchant(@PathVariable("id") long id, RedirectAttributes redirectAttributes) {
    try {
      merchantService.verifyMerchant(id);
      redirectAttributes.addFlashAttribute("successMessage", "商家審核已通過");
    } catch (Exception e) {
      redirectAttributes.addFlashAttribute("errorMessage", "審核失敗：" + e.getMessage());
    }

    // 使用封裝好的重導向字串
    return AuthPath.REDIRECT_ADMIN_VERIFY;
  }
}