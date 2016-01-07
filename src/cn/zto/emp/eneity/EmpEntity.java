package cn.zto.emp.eneity;
/**
 * 员工实体类
 * @author 邢宇超
 *
 */
public class EmpEntity {

	private Integer empId;
	private String empName;
	private Double empSal;
	private String empSex;
	
	public EmpEntity(){}

	public EmpEntity(Integer empId, String empName, Double empSal, String empSex) {
		this.empId = empId;
		this.empName = empName;
		this.empSal = empSal;
		this.empSex = empSex;
	}

	public Integer getEmpId() {
		return empId;
	}

	public void setEmpId(Integer empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public Double getEmpSal() {
		return empSal;
	}

	public void setEmpSal(Double empSal) {
		this.empSal = empSal;
	}

	public String getEmpSex() {
		return empSex;
	}

	public void setEmpSex(String empSex) {
		this.empSex = empSex;
	}
	
	
}
