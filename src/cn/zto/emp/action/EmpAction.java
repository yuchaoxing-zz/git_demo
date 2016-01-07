package cn.zto.emp.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.zto.emp.eneity.EmpEntity;
import cn.zto.emp.service.EmpService;
import cn.zto.emp.util.PageBean;

/**
 * 控制器
 * @author 邢宇超
 *
 */
@Controller
@RequestMapping(value="/emp")
public class EmpAction {
	//注入empService
	private EmpService empService;
	@Resource(name="empServiceID")
	public void setEmpService(EmpService empService) {
		this.empService = empService;
	}
	
	/**
	 * 根据姓名搜索员工
	 * @param name
	 * @return
	 */
	@RequestMapping(value="/findByName")
	public String findByName(Model model,String empName){
		List<EmpEntity> list=empService.findByName(empName);
		model.addAttribute("LIST", list);
		return "index";
	}
	
	@RequestMapping(value="/findByPage")
	public String findByPage(Model model,int page){
		PageBean<EmpEntity> pageBean=empService.findByPage(page);
		System.out.println("ok----------"+pageBean);
		for (EmpEntity emp : pageBean.getList()) {
			System.out.println("+++++++++++"+emp.getEmpName());
		}
		model.addAttribute("pageBean",pageBean);
		
		return "index";
	}
	
	/**
	 * 查询所有员工
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/findAll")
	public String findAll(Model model){
		List<EmpEntity> list=empService.findAll();
		model.addAttribute("LIST", list);
		return "index";
	}
	
	/**
	 * 添加员工
	 * @param emp
	 * @return
	 */
	@RequestMapping(value="/addEmp",method=RequestMethod.POST)
	public String addEmp(EmpEntity emp){
		empService.addEmp(emp);
		return "index";
	}
	
	/**
	 * 删除员工
	 * @param empId
	 * @return
	 */
	@RequestMapping(value="/deleteEmp")
	public String deleteEmp(int empId){
		empService.deleteEmp(empId);
		return "index";
	}
	
	/**
	 * 修改员工信息
	 * @param emp
	 * @return
	 */
	@RequestMapping(method=RequestMethod.POST,value="/updateEmp")
	public String updateEmp(EmpEntity emp){
		empService.updateEmp(emp);
		return "index";
	}
}
