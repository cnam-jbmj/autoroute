package controler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import app.FormAutoroute;
import vue.InitWindow;

public class InitControler implements ActionListener {
	
	public InitWindow vue;
	private FormAutoroute form;

	public InitControler(InitWindow vue) {
		this.vue = vue;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton button = (JButton)e.getSource();
		if(button.getText() == "Simuler") {
			
			this.form = this.vue.extractData();
			this.vue.dispose();
		}
		
		if(button.getText() == "Fermer") {
			System.exit(0);
		}
	}

	public FormAutoroute getForm() {
		return form;
	}
	
}
