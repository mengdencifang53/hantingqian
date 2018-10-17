package com.accp.dao.zx;

import org.apache.ibatis.annotations.Param;

import com.accp.pojo.Login;
import com.accp.pojo.User;
import com.accp.vo.zx.UserVo;

public interface IZxDao {

	public int addUser1(@Param("us") UserVo us);
}
