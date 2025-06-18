package server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import server.mapper.EmployeeMapper;
import server.model.Employee;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeMapper employeeMapper;

    public List<Employee> findAll() {
        return employeeMapper.findAll();
    }

    public Boolean deleteByEmployeeId(Integer employeeId) {
        return employeeMapper.deleteByEmployeeId(employeeId);
    }

    public Boolean insertEmployee(Employee employee) {
        return employeeMapper.insertEmployee(employee);
    }

    public Boolean updateEmployeeByEmployeeId(Employee employee) {
        return employeeMapper.updateEmployeeByEmployeeId(employee);
    }

    public List<Employee> selectByEmployeeId(Integer employeeId) {
        return employeeMapper.selectByEmployeeId(employeeId);
    }

    public List<Employee> selectByEmployeeAccount(String employeeAccount) {
        return employeeMapper.selectByEmployeeAccount(employeeAccount);
    }

    public Employee employeeLogin(Employee employee) {
        return employeeMapper.selectByEmployeeAccountAndPassword(employee);
    }

    public Integer selectTotalCount() {
        return employeeMapper.selectTotalCount();
    }

    public List<Employee> findCoaches() {
        return employeeMapper.findCoaches();  // Gọi tới phương thức trong EmployeeMapper
    }

}
