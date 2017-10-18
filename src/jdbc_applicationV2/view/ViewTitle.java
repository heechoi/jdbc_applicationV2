package jdbc_applicationV2.view;

import jdbc_applicationV2.content.AbstractContent;
import jdbc_applicationV2.content.TitleContent;
import jdbc_applicationV2.dto.Title;
import jdbc_applicationV2.list.AbstractList;
import jdbc_applicationV2.list.ListTitle;
import jdbc_applicationV2.service.TitleService;

@SuppressWarnings("serial")
public class ViewTitle extends AbstractView {
	private TitleService service;
	
	public ViewTitle(String title) {
		super(title);		
	}

	@Override
	protected AbstractList createList() {
		pList = new ListTitle(service);
		pList.loadData();
		return pList;
	}

	@SuppressWarnings("unchecked")
	@Override
	protected AbstractContent<Title> createContent() {
		pContent = new TitleContent();
		return (AbstractContent<Title>) pContent;
	}

	@Override
	protected void createService() {
		service = new TitleService();		
	}

	@Override
	protected void insertContent(Object content) {
		service.insertTitle((Title)content);
	}

	@Override
	protected void deleteContent(Object content) {
		service.deleteTitle((Title)content);
	}
}
