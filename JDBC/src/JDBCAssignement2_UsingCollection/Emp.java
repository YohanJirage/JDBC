package JDBCAssignement2_UsingCollection;

import java.util.Objects;

public class Emp  
{
	
	private int empno ;
	private String ename;
	private String job;
	private float sal;
	private int deptno;
	
	
	public Emp(int empno, String ename, String job, float sal,int deptno) {
		super();
		this.empno = empno;
		this.ename = ename;
		this.job = job;
		this.sal = sal;
		this.deptno= deptno;
	}


	public int getEmpno() {
		return empno;
	}


	public void setEmpno(int empno) {
		this.empno = empno;
	}


	public String getEname() {
		return ename;
	}


	public void setEname(String ename) {
		this.ename = ename;
	}


	public String getJob() {
		return job;
	}


	public void setJob(String job) {
		this.job = job;
	}


	public float getSal() {
		return sal;
	}


	public void setSal(float sal) {
		this.sal = sal;
	}


 


	public int getDeptno() {
		return deptno;
	}


	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}


	@Override
	public String toString() {
		return "Emp [empno=" + empno + ", ename=" + ename + ", job=" + job + ", sal=" + sal + ", deptno=" + deptno
				+ "]";
	}


//	@Override
//	public int compareTo(Emp o) {
//		if(this.ename.compareTo(o.ename) > 1)
//			return 1;
//		else if(this.ename.compareTo(o.ename) < 1)
//			return -1;
//		else 
//		return this.empno - o.empno;
//	}


	@Override
	public int hashCode() {
		if(this.deptno == 10)
			return 1;
		if(this.deptno == 20)
			return 2;
		if(this.deptno == 30)
			return 3;
		if(this.deptno == 40)
			return 4;
		if(this.deptno == 50)
			return 5;
		
		return Objects.hash(deptno);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Emp other = (Emp) obj;
//		return deptno == other.deptno;
		return false;
	}
	
}
