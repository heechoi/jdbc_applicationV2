package jdbc_applicationV2.service;

import java.sql.SQLException;
import java.util.List;

import javax.swing.JOptionPane;

import jdbc_applicationV2.dao.SqlDao;
import jdbc_applicationV2.dao.TitleDao;
import jdbc_applicationV2.dto.Title;

public class TitleService {
	private SqlDao<Title> titleDao;
	
	public TitleService() {
		this.titleDao = TitleDao.getInstance();
	}
	
	public void insertTitle(Title title){
		try {
			titleDao.insertItem(title);
			showMessage("추가 완료");
		} catch (SQLException e) {
			e.printStackTrace();
			showMessage(e.getMessage());
		}
	}
	
	private void showMessage(String msg) {
		JOptionPane.showMessageDialog(null, msg);		
	}
	
	public void updateTitle(Title title){
		try {
			titleDao.updateItem(title);
			showMessage("수정 완료");
		} catch (SQLException e) {
			e.printStackTrace();
			showMessage(e.getMessage());
		}
	}

	public void deleteTitle(Title title){
		try {
			titleDao.deleteItem(title);
			showMessage("삭제 완료");
		} catch (SQLException e) {
			e.printStackTrace();
			showMessage(e.getMessage());
		}
	}
	
	public Title selectTitleByNo(Title title){
		try {
			return titleDao.selectItemByNo(title);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public List<Title> selectTitleByAll(){
		try {
			return titleDao.selectItemByAll();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
