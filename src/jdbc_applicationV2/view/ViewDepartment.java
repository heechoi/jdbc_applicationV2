package jdbc_applicationV2.view;

import jdbc_applicationV2.content.AbstractContent;
import jdbc_applicationV2.content.DepartmentContent;
import jdbc_applicationV2.dto.Department;
import jdbc_applicationV2.list.AbstractList;
import jdbc_applicationV2.list.ListDepartment;
import jdbc_applicationV2.service.DepartmentService;

@SuppressWarnings("serial")
public class ViewDepartment extends AbstractView {
	private DepartmentService service;
	
	public ViewDepartment(String title) {
		super(title);		
	}

	@Override
	protected AbstractList createList() {
		pList = new ListDepartment(service);
		pList.loadData();
		return pList;
	}

	@SuppressWarnings("unchecked")
	@Override
	protected AbstractContent<Department> createContent() {
		pContent = new DepartmentContent();
		return (AbstractContent<Department>) pContent;
	}

	@Override
	protected void createService() {
		service = new DepartmentService();		
	}

	@Override
	protected void insertContent(Object content) {
		service.insertDepartment((Department)content);
	}

	@Override
	protected void deleteContent(Object content) {
		service.deleteDepartment((Department)content);
	}

}
