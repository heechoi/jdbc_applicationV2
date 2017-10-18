package jdbc_applicationV2.list;

import java.util.List;

import javax.swing.SwingConstants;

import jdbc_applicationV2.dto.Title;
import jdbc_applicationV2.service.TitleService;

@SuppressWarnings("serial")
public class ListTitle extends AbstractList {
	private TitleService service;

	public ListTitle(TitleService service) {
		this.service = service;
	}

	@Override
	protected void setAlignWidth() {
		setAlign(SwingConstants.CENTER, 0, 1);
		setCellWidth(100, 150);
	}

	@Override
	protected Object[][] getData() {
		List<Title> lists = service.selectTitleByAll();

		Object[][] data = new Object[lists.size()][];
		for (int i = 0; i < lists.size(); i++) {
			data[i] = lists.get(i).toArray();
		}
		return data;
	}

	@Override
	protected String[] getColumnNames() {
		return new String[] { "직책 번호", "직책 명" };
	}

	@Override
	public Object getSelectedItem() {
		int seletedIndex = table.getSelectedRow();
		int titleNo = (int) table.getValueAt(seletedIndex, 0);
		return service.selectTitleByNo(new Title(titleNo));
	}

}
