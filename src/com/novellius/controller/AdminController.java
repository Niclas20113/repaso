package com.novellius.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.novellius.pojo.Admin;
import com.novellius.service.AdminService;

@Controller
public class AdminController {

	@Autowired
	private AdminService adminService;

	@RequestMapping("/admin")
	public String showAdmin(Model model, @ModelAttribute("result") String result) {

		List<Admin> admins = adminService.finAllAd();
		model.addAttribute("admin", new Admin());
		model.addAttribute("result", result);
		model.addAttribute("admins", admins);
		return "admin";
	}

	@RequestMapping(value = "/admin/save", method = RequestMethod.POST)
	public String handleAdmin(@ModelAttribute("admin") Admin adminForm, RedirectAttributes ra) {

		if (adminService.saveOrUpdateAd(adminForm)) {
			ra.addFlashAttribute("result", "Changes made successfully");
		} else {
			ra.addFlashAttribute("result", "Error making the changes");
		}
		return "redirect:/admin";
	}

	@RequestMapping("/admin/{idAd}/update")
	public String showUpdateAd(Model model, @PathVariable("idAd") int idAd) {
		Admin adminUpdate = adminService.findByIdAd(idAd);
		model.addAttribute("admin", adminUpdate);
		return "admin";
	}

	@RequestMapping("admin/{idAd}/delete")
	public String showDelete(@PathVariable("idAd") int idAd, RedirectAttributes ra) {
		if (adminService.delete(idAd)) {
			ra.addFlashAttribute("result", "User deleted");
		}else {
			ra.addFlashAttribute("result", "Error removing user");
		}

		return "redirect:/admin";
	}

}
