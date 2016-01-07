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
 * ������
 * @author ���
 *
 */
@Controller
@RequestMapping(value="/emp")
public class EmpAction {
	//ע��empService
	private EmpService empService;
	@Resource(name="empServiceID")
	public void setEmpService(EmpService empService) {
		this.empService = empService;
	}
	
	/**
	 * ������������Ա��
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
	 * ��ѯ����Ա��
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
	 * ���Ա��
	 * @param emp
	 * @return
	 */
	@RequestMapping(value="/addEmp",method=RequestMethod.POST)
	public String addEmp(EmpEntity emp){
		empService.addEmp(emp);
		return "index";
	}
	
	/**
	 * ɾ��Ա��
	 * @param empId
	 * @return
	 */
	@RequestMapping(value="/deleteEmp")
	public String deleteEmp(int empId){
		empService.deleteEmp(empId);
		return "index";
	}
	
	/**
	 * �޸�Ա����Ϣ
	 * @param emp
	 * @return
	 */
	@RequestMapping(method=RequestMethod.POST,value="/updateEmp")
	public String updateEmp(EmpEntity emp){
		empService.updateEmp(emp);
		return "index";
	}
}
