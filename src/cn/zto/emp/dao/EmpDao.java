package cn.zto.emp.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import cn.zto.emp.eneity.EmpEntity;
/**
 * Dao����ɾ�Ĳ�Ա��
 * @author ���
 *
 */
public class EmpDao {

	//ע��sqlSessionFactory
	private SqlSessionFactory sqlSessionFactory;
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}
	
	/**
	 * ��ѯ����Ա��
	 * @return
	 */
	public List<EmpEntity> findAll(){
		SqlSession sqlSession = sqlSessionFactory.openSession();
		return sqlSession.selectList("EmpEntityNameSpace.findAll");
	}
	
	
	/**
	 * ���Ա��
	 * @param emp
	 */
	public void addEmp(EmpEntity emp){
		SqlSession sqlSession=sqlSessionFactory.openSession();
		sqlSession.insert("EmpEntityNameSpace.addEmp",emp);
	}
	
	/**
	 * ɾ��Ա��
	 * @param emp
	 */
	public void deleteEmp(int empId){
		SqlSession sqlSession = sqlSessionFactory.openSession();
		sqlSession.selectList("EmpEntityNameSpace.deleteEmp",empId);
	}
	
	/**
	 * �޸�Ա��
	 * @param emp
	 */
	public void updateEmp(EmpEntity emp){
		SqlSession sqlSession = sqlSessionFactory.openSession();
		sqlSession.selectList("EmpEntityNameSpace.updateEmp",emp);
	}
	
	/**
	 * ����Ա��������ѯԱ��
	 * @param empName
	 * @return
	 */
	public List<EmpEntity> findByName(String empName) {
		SqlSession sqlSession=sqlSessionFactory.openSession();
		return sqlSession.selectList("EmpEntityNameSpace.findByName",empName);
	}
	
	/**
	 * ��ѯ�ܼ�¼��
	 * @return
	 */
	public int findByCount() {
		SqlSession sqlSession=sqlSessionFactory.openSession();
		return sqlSession.selectOne("EmpEntityNameSpace.findByCount");
	}

	/**
	 * ���з�ҳ�ļ�¼��
	 * @param begin
	 * @param limit
	 * @return
	 */
	public List<EmpEntity> findByPage(int begin, int limit) {
		SqlSession sqlSession=sqlSessionFactory.openSession();
		Map<String,Object> map=new HashMap<String, Object>();
		map.put("begin", begin);
		map.put("limit", limit);
		return sqlSession.selectList("EmpEntityNameSpace.findByPage",map);
	}
}
