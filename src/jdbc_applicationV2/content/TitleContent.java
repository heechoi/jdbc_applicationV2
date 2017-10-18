package jdbc_applicationV2.content;

import java.awt.GridLayout;

import jdbc_applicationV2.common.TextFieldComponent;
import jdbc_applicationV2.dto.Title;

@SuppressWarnings("serial")
public class TitleContent extends AbstractContent<Title> {

	private TextFieldComponent pTitleNo;
	private TextFieldComponent pTitleName;

	public TitleContent() {
		setLayout(new GridLayout(0, 1, 0, 10));
		
		pTitleNo = new TextFieldComponent("직책 번호");
		add(pTitleNo);
		
		pTitleName = new TextFieldComponent("직책 명");
		add(pTitleName);
	}

	@Override
	public Title getContent(){
		int titleNo = Integer.parseInt(pTitleNo.getTextValue());
		String titleName = pTitleName.getTextValue();
		return new Title(titleNo, titleName);
	}
	
	@Override
	public void setContent(Title title){
		pTitleNo.setTextValue(title.getTitleNo()+"");
		pTitleName.setTextValue(title.getTitleName());
	}
	
	@Override
	public void isEmptyCheck() throws Exception {
		pTitleNo.isEmptyCheck();
		pTitleName.isEmptyCheck();
	}
	
	@Override
	public void clear(){
		pTitleNo.setTextValue("");
		pTitleName.setTextValue("");
	}
}










