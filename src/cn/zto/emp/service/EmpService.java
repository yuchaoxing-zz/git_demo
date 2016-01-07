package cn.zto.emp.service;

import java.util.List;

import cn.zto.emp.dao.EmpDao;
import cn.zto.emp.eneity.EmpEntity;
import cn.zto.emp.util.PageBean;
/**
 * 业务层
 * @author 邢宇超
 *
 */
public class EmpService {
	//注入empDao
	private EmpDao empDao=new EmpDao();
	public void setEmpDao(EmpDao empDao) {
		this.empDao = empDao;
	}
	
	//分页查询所有员工
	public PageBean<EmpEntity> findByPage(int page){
		PageBean<EmpEntity> pageBean=new PageBean<EmpEntity>();
		//设置当前页
		pageBean.setPage(page);
		//设置每页显示的记录数
		int limit=3;
		pageBean.setLimit(limit);
		//设置总记录数
		int totalCount=empDao.findByCount();
		pageBean.setTotalCount(totalCount);
		
		//计算总页数
		int totalPage=0;
		if(totalCount%limit==0){
			totalPage=totalCount/limit;
		}else{
			totalPage=totalCount/limit+1;
		}
		pageBean.setTotalPage(totalPage);
		
		//设置每页显示的结果集
		//设置每页从哪里开始
		int begin=(page-1)*limit;
		List<EmpEntity> list=empDao.findByPage(begin,limit);
		pageBean.setList(list);
		
		return pageBean;
	}
	
	
	//查询所有员工
	public List<EmpEntity> findAll(){
		return empDao.findAll();
	}
	
	//添加员工
	public void addEmp(EmpEntity emp){
		empDao.addEmp(emp);
	}
	
	//删除员工
	public void deleteEmp(int empId){
		empDao.deleteEmp(empId);
	}
	
	
	//修改员工
	public void updateEmp(EmpEntity emp){
		empDao.updateEmp(emp);
	}
	//根据员工姓名查询员工
	public List<EmpEntity> findByName(String empName) {
		return empDao.findByName(empName);
	}
}
