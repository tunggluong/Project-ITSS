package server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import server.mapper.AdminMapper;
import server.model.Admin;

@Service
public class AdminService {

    @Autowired
    private AdminMapper adminMapper;

    public Admin adminLogin(Admin admin) {
        return adminMapper.selectByAccountAndPassword(admin);
    }
}
