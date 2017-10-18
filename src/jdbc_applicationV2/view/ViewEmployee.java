package jdbc_applicationV2.view;

import jdbc_applicationV2.content.AbstractContent;
import jdbc_applicationV2.content.EmployeeContent;
import jdbc_applicationV2.dto.Employee;
import jdbc_applicationV2.list.AbstractList;
import jdbc_applicationV2.list.ListEmployee;
import jdbc_applicationV2.service.EmployeeService;

@SuppressWarnings("serial")
public class ViewEmployee extends AbstractView {
	private EmployeeService service;
	private ListEmployee pList;
	
	public ViewEmployee(String title) {
		super(title);		
	}

	@Override
	protected AbstractList createList() {
		pList = new ListEmployee(service);
		pList.loadData();
		return pList;
	}

	@SuppressWarnings("unchecked")
	@Override
	protected AbstractContent<Employee> createContent() {
		pContent = new EmployeeContent(service);
		return (AbstractContent<Employee>) pContent;
	}

	@Override
	protected void createService() {
		service = new EmployeeService();
	}

	@Override
	protected void insertContent(Object content) {
		service.insertEmployee((Employee)content);
	}

	@Override
	protected void deleteContent(Object content) {
		service.deleteEmployee((Employee)content);
	}

}
