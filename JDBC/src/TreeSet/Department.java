package TreeSet;

public class Department implements Comparable<Department>
{
	private int deptno;
	private String dnmae;
	private float avgsal;
	public Department(int deptno, String dnmae, float avgsal) {
		super();
		this.deptno = deptno;
		this.dnmae = dnmae;
		this.avgsal = avgsal;
	}
	public int getDeptno() {
		return deptno;
	}
	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}
	public String getDnmae() {
		return dnmae;
	}
	public void setDnmae(String dnmae) {
		this.dnmae = dnmae;
	}
	public float getAvgsal() {
		return avgsal;
	}
	public void setAvgsal(float avgsal) {
		this.avgsal = avgsal;
	}
	@Override
	public String toString() {
		return "Departments [deptno=" + deptno + ", dnmae=" + dnmae + ", avgsal=" + avgsal + "]";
	}
	@Override
	public int compareTo(Department o) {
		 if(this.avgsal > o.avgsal)
		 {
			 return -1;
		 }
		 else if(this.avgsal < o.avgsal)
		 {
			 return 1;
		 }
		 else
		 {
			 return this.deptno- o.deptno;
		 }
	}
	
	

}
