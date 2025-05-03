package Tablas;

import java.util.Date;

public class EMPLOYEES {

	int employee_id;
	String first_name;
	String last_name;
	String email;
	String phone;
	int manager_id;
	Date hire_date;
	String job_title;
	int fk_employees_manager;

	// Constructor vacio

	public EMPLOYEES() {
		super();
	}

	// constructor con pk
	public EMPLOYEES(int employee_id, String first_name, String last_name, String email, String phone, Date hire_date,
			int manager_id, String job_title, int fk_employees_manager) {
		super();
		this.employee_id = employee_id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.email = email;
		this.phone = phone;
		this.hire_date = hire_date;
		this.manager_id = manager_id;
		this.job_title = job_title;
		this.fk_employees_manager = fk_employees_manager;
	}

	// constructor sin pk
	public EMPLOYEES(String first_name, String last_name, String email, String phone, Date hire_date, int manager_id,
			String job_title, int fk_employees_manager) {
		super();
		this.first_name = first_name;
		this.last_name = last_name;
		this.email = email;
		this.phone = phone;
		this.hire_date = hire_date;
		this.manager_id = manager_id;
		this.job_title = job_title;
		this.fk_employees_manager = fk_employees_manager;
	}
	// setters y getters

	public int getEmployee_id() {
		return employee_id;
	}

	public void setEmployee_id(int employee_id) {
		this.employee_id = employee_id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Date getHire_date() {
		return hire_date;
	}

	public void setHire_date(Date hire_date) {
		this.hire_date = hire_date;
	}

	public int getManager_id() {
		return manager_id;
	}

	public void setManager_id(int manager_id) {
		this.manager_id = manager_id;
	}

	public String getJob_title() {
		return job_title;
	}

	public void setJob_title(String job_title) {
		this.job_title = job_title;
	}

	public int getFk_employees_manager() {
		return fk_employees_manager;
	}

	public void setFk_employees_manager(int fk_employees_manager) {
		this.fk_employees_manager = fk_employees_manager;
	}
	// Resumen propiedades con toString

	@Override
	public String toString() {
		return "EMPLOYEES [employee_id=" + employee_id + ", first_name=" + first_name + ", last_name=" + last_name
				+ ", email=" + email + ", phone=" + phone + ", manager_id=" + manager_id + ", hire_date=" + hire_date
				+ ", job_title=" + job_title + ", fk_employees_manager=" + fk_employees_manager + "]";
	}

}
