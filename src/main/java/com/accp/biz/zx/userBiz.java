package com.accp.biz.zx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.accp.dao.zx.IUserDao;
import com.accp.dao.zx.IZxDao;
import com.accp.pojo.Login;
import com.accp.pojo.User;
import com.accp.vo.zx.InfoVo;
import com.accp.vo.zx.UserVo;



@Service
@Transactional(propagation=Propagation.SUPPORTS,isolation=Isolation.READ_COMMITTED,readOnly=true)
public class userBiz {
    @Autowired
	private IUserDao dao;
    
    @Autowired
    private IZxDao zxdao;
    
    public Login queryUser(Login us) {
    	return dao.queryUser(us);
    	
    }
    
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED, readOnly = false)
    public int addUser(UserVo us) {
    	
    	return dao.addUser(us);
    	
    }
    
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED, readOnly = false)
    public int addUser1(UserVo us) {
    	
    	return zxdao.addUser1(us);
    	
    }
    
    public Login queryEmail(String email) {
    	return dao.queryEmail(email);
    }
    //查询个人资料
    public InfoVo queryUserId(int id) {
    	return dao.queryUserId(id);
    }
    @Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.READ_COMMITTED,readOnly=false)
    public int updateUserinfo(InfoVo vo) {
    	return dao.updateUserinfo(vo);
    }
}
