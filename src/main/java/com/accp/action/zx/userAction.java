package com.accp.action.zx;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.accp.biz.zx.userBiz;
import com.accp.pojo.Login;
import com.accp.pojo.User;
import com.accp.vo.zx.UserVo;



@RestController
@RequestMapping("zx")
public class userAction {
    @Autowired
	private userBiz biz;
    
    @RequestMapping(value="login",method=RequestMethod.POST)
    public Map<String ,Object>login(@RequestBody Login us,HttpSession session){
    	Map<String,Object> message=new HashMap<String,Object>();
    	Login u=biz.queryUser(us);
    	if(u!=null) {
    		message.put("code", "200");
    		message.put("data", u);
    		session.setAttribute("USER", u);
    	}else {
    		message.put("code", "500");
    	}
    	return message;
    	
    }
    @RequestMapping(value="queryUser/{email}",method=RequestMethod.GET)
    public Map<String,String>checkEmail(@PathVariable String email){
    	Map<String,String>message=new HashMap<String,String>();
    	Login ms=biz.queryEmail(email);
    	if(ms==null) {
    		message.put("code", "200");
    	}else {
    		message.put("code", "500");
    	}
    	return message;
    }
    
    @RequestMapping(value="addUser",method=RequestMethod.POST)
    public Map<String,String>addUser(@RequestBody UserVo us,HttpSession session)throws Exception{
    	Map<String,String> message=new HashMap<String,String>();
//    	try {
//			int count=biz.queryEmail(us.getUseremail());
//			if(count>0) {
//				message.put("code", "500");
//				return message;
//			}
    	   
		  int count=biz.addUser(us);
		  if(count>0) {
		  biz.addUser1(us);
		
			message.put("code", "200");
			session.setAttribute("USER", us);
			session.setAttribute("USER1", us.getUsername());
		  }
    		
//		} catch (Exception ex) {
//			// TODO: handle exception
//			message.put("code", "500");
//			message.put("msg", ex.getMessage());
//		}
    	return message;
    	
    }
}
