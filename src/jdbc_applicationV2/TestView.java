package jdbc_applicationV2;

import java.awt.EventQueue;

import jdbc_applicationV2.view.AbstractView;
import jdbc_applicationV2.view.ViewDepartment;
import jdbc_applicationV2.view.ViewEmployee;
import jdbc_applicationV2.view.ViewTitle;

public class TestView {
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AbstractView frame1 = new ViewTitle("직책관리");
					frame1.setVisible(true);
					
					AbstractView frame2 = new ViewDepartment("부서관리");
					frame2.setVisible(true);
					
					AbstractView frame3 = new ViewEmployee("사원관리");
					frame3.setVisible(true);
					
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
