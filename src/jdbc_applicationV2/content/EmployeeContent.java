package jdbc_applicationV2.content;

import java.awt.GridLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.List;
import java.util.Vector;

import jdbc_applicationV2.common.ComboComponent;
import jdbc_applicationV2.common.SpinnerComponent;
import jdbc_applicationV2.common.TextFieldComponent;
import jdbc_applicationV2.dto.Department;
import jdbc_applicationV2.dto.Employee;
import jdbc_applicationV2.dto.Title;
import jdbc_applicationV2.service.EmployeeService;

@SuppressWarnings("serial")
public class EmployeeContent extends AbstractContent<Employee> {

	private TextFieldComponent pEmpNo;
	private TextFieldComponent pEmpName;
	private ComboComponent<Department> pDno;
	private ComboComponent<Employee> pManager;
	private SpinnerComponent pSalary;
	private ComboComponent<Title> pTitle;
	private EmployeeService service;
	
	public EmployeeContent(EmployeeService service) {
		this.service = service;
		
		setLayout(new GridLayout(0, 1, 0, 10));
		
		pEmpNo = new TextFieldComponent("사원 번호");
		add(pEmpNo);
		
		pEmpName = new TextFieldComponent("사원 명");
		add(pEmpName);
		
		pDno = new ComboComponent<>("부서");
		pDno.getCombo().addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange()==ItemEvent.SELECTED){
					setManagerModel();
				}
				
			}
		});
		add(pDno);
		
		pManager = new ComboComponent<>("관리자");
		add(pManager);
		
		pSalary = new SpinnerComponent("급여");
		pSalary.setDefaultValue(1500000, 1000000, 5000000, 100000);
		add(pSalary);
		
		pTitle = new ComboComponent<>("직책");
		add(pTitle);
		
		setDepartModel();
		setTitleModel();
		setManagerModel();
	}

	private void setManagerModel() {
		Department selectDno = pDno.getSelectedItem();
		
		List<Employee> lists = service.selectEmployeeByAllFromDno(selectDno.getDeptNo());
		Employee ceo = new Employee(4377);
		if (!lists.contains(ceo)){
			lists.add(service.selectEmployeeByNo(new Employee(4377)));
		}
		Vector<Employee> managers = new Vector<>(lists);
		pManager.setComboBoxModel(managers);				
	}

	private void setTitleModel() {
		List<Title> lists = service.selectTitleByAll();
		Vector<Title> titles = new Vector<>(lists);
		pTitle.setComboBoxModel(titles);		
	}

	public void setDepartModel(){
		List<Department> lists = service.selectDepartmentByAll();
		Vector<Department> depts = new Vector<>(lists);
		pDno.setComboBoxModel(depts);
	}
	
	@Override
	public Employee getContent(){
		int empNo = Integer.parseInt(pEmpNo.getTextValue());
		String empName = pEmpName.getTextValue();
		Title title = pTitle.getSelectedItem();
		Employee manager = pManager.getSelectedItem();
		int salary = pSalary.getSpinValue();
		Department dno = pDno.getSelectedItem();
		return new Employee(empNo, empName, title, manager, salary, dno);
	}
	
	@Override
	public void setContent(Employee employee){
		pEmpNo.setTextValue(employee.getEmpNo()+"");
		pEmpName.setTextValue(employee.getEmpName());
		pDno.setSelectedItem(employee.getDno());
		pManager.setSelectedItem(employee.getManager());
		pSalary.setSpinValue(employee.getSalary());
		pTitle.setSelectedItem(employee.getTitle());
	}
	
	@Override
	public void isEmptyCheck() throws Exception {
		pEmpNo.isEmptyCheck();
		pEmpName.isEmptyCheck();
		pDno.isEmptyCheck();
		pManager.isEmptyCheck();
		pSalary.isEmptyCheck();
		pTitle.isEmptyCheck();
	}

	@Override
	public void clear() {
		pEmpNo.setTextValue("");
		pEmpName.setTextValue("");
		pDno.setSelectedIndex(0);
		pManager.setSelectedIndex(0);
		pSalary.setSpinValue(1500000);
		pTitle.setSelectedIndex(0);		
	}
}