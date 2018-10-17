package com.accp.dao.zx;

import org.apache.ibatis.annotations.Param;

import com.accp.pojo.Login;
import com.accp.vo.zx.InfoVo;
import com.accp.vo.zx.UserVo;



public interface IUserDao {
    //登录
	public Login queryUser(@Param("us") Login us);
	//注册
	public int addUser(@Param("us") UserVo us);
	
	
	//查询用户是否存在
	public Login queryEmail(@Param("email") String email);
	//登录进去查询user详情
	public InfoVo queryUserId(@Param("id") int id);
	//修改user表
	public int updateUserinfo(@Param("obj") InfoVo obj);
}
