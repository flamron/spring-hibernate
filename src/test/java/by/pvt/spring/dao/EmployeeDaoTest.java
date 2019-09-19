package by.pvt.spring.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.core.convert.Property;
import org.springframework.core.io.Resource;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@ContextConfiguration("classpath:application-context.xml")
@Transactional
@Commit
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

    @Value("classpath:application.properties")
    private Resource resource;

    @Test
    public void checkBeanNotNull() {
        assertNotNull(employeeDao);
    }

    @Test
    public void getAll() {
        assertNotNull(employeeDao.getAll());
    }

}