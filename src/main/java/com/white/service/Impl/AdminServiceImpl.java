package com.white.service.Impl;

import com.white.entry.Admin;
import com.white.mapper.AdminMapper;
import com.white.service.AdminService;
import com.white.utils.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;

public class AdminServiceImpl implements AdminService {
    @Override
    public boolean isLogin(String username, String password) {
        SqlSession sqlSession = SqlSessionFactoryUtils.getSqlSessionFactory().openSession();
        AdminMapper mapper = sqlSession.getMapper(AdminMapper.class);
        Admin admin = new Admin();
        admin.setUsername(username);
        admin.setPassword(password);
        int result = mapper.selectAdminByUserNameAndPassword(admin);
        sqlSession.close();
        return result > 0 ? true : false;
    }
}
