package by.pvt.spring.dao;

import by.pvt.spring.entity.Employee;
import lombok.Getter;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class EmployeeDao extends BaseDaoImpl<Long, Employee>{

}
