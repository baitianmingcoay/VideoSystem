package com.white.mapper;

import com.white.entry.Admin;

public interface AdminMapper {
    int selectAdminByUserNameAndPassword(Admin admin);
}
