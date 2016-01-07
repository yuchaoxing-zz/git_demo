package cn.zto.emp.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import cn.zto.emp.eneity.EmpEntity;
/**
 * Dao层增删改查员工
 * @author 邢宇超
 *
 */
public class EmpDao {

	//注入sqlSessionFactory
	private SqlSessionFactory sqlSessionFactory;
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}
	
	/**
	 * 查询所有员工
	 * @return
	 */
	public List<EmpEntity> findAll(){
		SqlSession sqlSession = sqlSessionFactory.openSession();
		return sqlSession.selectList("EmpEntityNameSpace.findAll");
	}
	
	
	/**
	 * 添加员工
	 * @param emp
	 */
	public void addEmp(EmpEntity emp){
		SqlSession sqlSession=sqlSessionFactory.openSession();
		sqlSession.insert("EmpEntityNameSpace.addEmp",emp);
	}
	
	/**
	 * 删除员工
	 * @param emp
	 */
	public void deleteEmp(int empId){
		SqlSession sqlSession = sqlSessionFactory.openSession();
		sqlSession.selectList("EmpEntityNameSpace.deleteEmp",empId);
	}
	
	/**
	 * 修改员工
	 * @param emp
	 */
	public void updateEmp(EmpEntity emp){
		SqlSession sqlSession = sqlSessionFactory.openSession();
		sqlSession.selectList("EmpEntityNameSpace.updateEmp",emp);
	}
	
	/**
	 * 根据员工姓名查询员工
	 * @param empName
	 * @return
	 */
	public List<EmpEntity> findByName(String empName) {
		SqlSession sqlSession=sqlSessionFactory.openSession();
		return sqlSession.selectList("EmpEntityNameSpace.findByName",empName);
	}
	
	/**
	 * 查询总记录数
	 * @return
	 */
	public int findByCount() {
		SqlSession sqlSession=sqlSessionFactory.openSession();
		return sqlSession.selectOne("EmpEntityNameSpace.findByCount");
	}

	/**
	 * 带有分页的记录集
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
