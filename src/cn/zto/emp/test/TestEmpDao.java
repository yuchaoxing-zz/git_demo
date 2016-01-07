package cn.zto.emp.test;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.zto.emp.dao.EmpDao;
import cn.zto.emp.eneity.EmpEntity;

public class TestEmpDao {

	//mybatis≤‚ ‘
	@Test
	public void testSelect(){
		EmpDao empDao=new EmpDao();
		List<EmpEntity> list=empDao.findAll();
		for (EmpEntity empEntity : list) {
			System.out.println(empEntity.getEmpName());
		}
	}
	
	//spring≤‚ ‘
	@Test
	public void testSelect2(){
		ApplicationContext ac = new ClassPathXmlApplicationContext(new String[]{"spring.xml"});
		EmpDao empDao = (EmpDao) ac.getBean("empDaoID");
		/*List<EmpEntity> list=empDao.findAll();
		for (EmpEntity empEntity : list) {
			System.out.println(empEntity.getEmpName());
		}*/
		List<EmpEntity> list=empDao.findByPage(0,3);
		for (EmpEntity empEntity : list) {
			System.out.println(empEntity.getEmpName());
		}
	}
}
