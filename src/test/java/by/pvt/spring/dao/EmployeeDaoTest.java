package by.pvt.spring.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@ContextConfiguration("classpath:application-context.xml")
public class EmployeeDaoTest {

    @Autowired
    private EmployeeDao employeeDao;

    @Autowired
    private ApplicationContext applicationContext;

    @Value("${db.username}")
    private String name;

    @Value("5")
    private Integer number;

    @Value("#{'${test.numbers}'.split(',')}")
    private List<Integer> numbers;

    @Test
    public void checkBeanNotNull() {
        assertNotNull(employeeDao);
    }

}