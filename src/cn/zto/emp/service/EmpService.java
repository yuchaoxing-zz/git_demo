package cn.zto.emp.service;

import java.util.List;

import cn.zto.emp.dao.EmpDao;
import cn.zto.emp.eneity.EmpEntity;
import cn.zto.emp.util.PageBean;
/**
 * ҵ���
 * @author ���
 *
 */
public class EmpService {
	//ע��empDao
	private EmpDao empDao=new EmpDao();
	public void setEmpDao(EmpDao empDao) {
		this.empDao = empDao;
	}
	
	//��ҳ��ѯ����Ա��
	public PageBean<EmpEntity> findByPage(int page){
		PageBean<EmpEntity> pageBean=new PageBean<EmpEntity>();
		//���õ�ǰҳ
		pageBean.setPage(page);
		//����ÿҳ��ʾ�ļ�¼��
		int limit=3;
		pageBean.setLimit(limit);
		//�����ܼ�¼��
		int totalCount=empDao.findByCount();
		pageBean.setTotalCount(totalCount);
		
		//������ҳ��
		int totalPage=0;
		if(totalCount%limit==0){
			totalPage=totalCount/limit;
		}else{
			totalPage=totalCount/limit+1;
		}
		pageBean.setTotalPage(totalPage);
		
		//����ÿҳ��ʾ�Ľ����
		//����ÿҳ�����￪ʼ
		int begin=(page-1)*limit;
		List<EmpEntity> list=empDao.findByPage(begin,limit);
		pageBean.setList(list);
		
		return pageBean;
	}
	
	
	//��ѯ����Ա��
	public List<EmpEntity> findAll(){
		return empDao.findAll();
	}
	
	//���Ա��
	public void addEmp(EmpEntity emp){
		empDao.addEmp(emp);
	}
	
	//ɾ��Ա��
	public void deleteEmp(int empId){
		empDao.deleteEmp(empId);
	}
	
	
	//�޸�Ա��
	public void updateEmp(EmpEntity emp){
		empDao.updateEmp(emp);
	}
	//����Ա��������ѯԱ��
	public List<EmpEntity> findByName(String empName) {
		return empDao.findByName(empName);
	}
}
