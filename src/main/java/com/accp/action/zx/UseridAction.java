package com.accp.action.zx;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.accp.biz.zx.userBiz;
import com.accp.vo.zx.InfoVo;

@Controller
@RequestMapping("zx")
public class UseridAction {
	
	@Autowired
    private userBiz biz;
	
	//查询用户详情
	@GetMapping("queryByid")
	public String queryById(int id ,Model model) {
		InfoVo vo=biz.queryUserId(id);
	    model.addAttribute("vo",vo);
		
		return "indexgeren";
	}
	//修改用户信息
	public String updateUserinfo(InfoVo vo ,Model model,HttpSession session) {
		int count=biz.updateUserinfo(vo);
		
		return "indexgeren";
	}
	
}
