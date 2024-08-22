package com.digitalojt.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.digitalojt.web.service.InputOutputHistoryService;

@Controller
@RequestMapping("control")
public class outControlController extends AbstractController{
    
	@Autowired
	private InputOutputHistoryService inputOutputHistoryService;
	
	/**
	 * 出庫管理
	 */
	@GetMapping("/out")
	public String getOutHistories(Model model) {
		model.addAttribute("outHistories", inputOutputHistoryService.findAll());
		return "control/out";
	}
}
