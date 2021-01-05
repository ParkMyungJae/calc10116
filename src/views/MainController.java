package views;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class MainController {
	@FXML
	private TextField text;
	
	@FXML
	public void num(ActionEvent event) {
		int i = 0;
		String value = ((Button) event.getSource()).getText();
		text.setText(text.getText() + value);
		
		String[] zero = text.getText().split("");
		
		for(i = 0; i < zero.length; i++) {
			if(!zero[i].equals("0")) {
				break;
			}
		}
		
		String number = "0";
		
		if(i < zero.length) {
			number = text.getText().substring(i, zero.length);
		}
		text.setText(number);
	}

	@FXML
	public void equal() {
		ScriptEngineManager sem = new ScriptEngineManager();
		ScriptEngine se = sem.getEngineByName("JavaScript");
		try {
			if(!text.getText().equals("")) {
				text.setText(se.eval(text.getText()).toString());
			}
		} catch (ScriptException e) {
//			e.printStackTrace();
			text.setText("ERROR");
		}
	}

	@FXML
	public void cancel(ActionEvent event) {
		text.setText("");
	}

	@FXML
	public void backspace() {
		text.setText(text.getText().substring(0, text.getText().length() - 1));
	}

	@FXML
	public void area(KeyEvent event) {
		if (event.getCode() == KeyCode.ENTER) {
			equal();
		}
	}
}