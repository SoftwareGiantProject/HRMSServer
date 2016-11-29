package rmihelper;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;

public class StartController implements Initializable{

	
	@FXML private MenuItem Start;
	@FXML private MenuItem Restart;
	@FXML private MenuItem Close;
	@FXML private MenuItem Clear;
	@FXML private MenuItem Export;
	@FXML private MenuItem About;
	@FXML private MenuItem Exit;
	@FXML private ScrollPane news;
	@FXML private TextArea message;
	
	RMIHelper helper = RMIHelper.getInstance();
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
	}

	@FXML
	public void handleStart(){
		helper.start();
	}
	
	@FXML
	public void handleRestart(){
		helper.restart();
	}
	
	@FXML
	public void handleOff(){
		helper.off();
	}
	
	@FXML
	public void handleExit(){
		sendMessage("Exit");
		helper.off();
		System.exit(0);
	}
	
	@FXML
	public void handleClear(){
		this.message.clear();
	}
	
	@FXML
	public void handleExport(){
		SimpleDateFormat df = new SimpleDateFormat("yyyy-mm-dd-HH-mm-ss");
		String time = df.format(new Date());
		String log = this.message.getText();
		try{
			File file = new File("C:/Users/looh/Documents/GitHub/HRMSServer/" + time + ".log");
			if(!file.exists()){
				file.createNewFile();
			}
			FileWriter f = new FileWriter(file);
			f.write(log +"\r\n");
			f.close();
			sendMessage("Export Successful!");
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	
	@FXML
	public void handleAbout(){
		sendMessage("服务器开发人员：Loohaze\r\n"
				+"服务器版本： v1.0 \r\n"
				+"最后更新日期： 2016-11-29\r\n"
				+"更新内容：");
	}
	
			
	public void sendMessage(String message){
		this.message.appendText("**********************************\r\n");
		SimpleDateFormat df = new SimpleDateFormat("yyyy-mm-dd-HH-mm-ss");
		String time = df.format(new Date());
		this.message.appendText(time);
		this.message.appendText("\r\n");
		this.message.appendText(message);
		this.message.appendText("\r\n");
		this.message.appendText("**********************************\r\n");
	}
}
