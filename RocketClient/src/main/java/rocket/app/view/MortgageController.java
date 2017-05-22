package rocket.app.view;

import java.awt.Button;

import com.sun.xml.ws.org.objectweb.asm.Label;

import eNums.eAction;
import exceptions.LoanRequestException;
import exceptions.RateException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputControl;
import rocket.app.MainApp;
import rocketCode.Action;
import rocketData.LoanRequest;

public class MortgageController {

	
	private TextField txtNew;
	
	private MainApp mainApp;
	
	
	@FXML private Label lblCreditsScore;
	@FXML private Label lblTerm;
	@FXML private Label lblIncome;
	@FXML private Label lblRate;
	@FXML private Label lblAmount;
	@FXML private Label lblDownPayment;
	@FXML private Label lblPayment;
	@FXML private Label lblExpenses;
	@FXML private Label lblHouseCost;
	@FXML private TextField txtIncome;
	@FXML private TextField txtExpenses;
	@FXML private TextField txtCreditScore;
	@FXML private TextField txtDownPayment;
	@FXML private TextField txtHouseCost;
	@FXML private TextField txtRate;
	@FXML private Label lblMortgagePayment;
	@FXML private Button btnPayment = new Button("Payment");
	@FXML private ComboBox cmbTerm;
	private int Term;

	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;
	}
	
	
	@FXML
	public void btnCalculatePayment(ActionEvent event)
	{
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Message Here...");
		alert.setHeaderText("Look, an Information Dialog");
		alert.setContentText(txtNew.getText());
		alert.showAndWait().ifPresent(rs -> {
		    if (rs == ButtonType.OK) {
		        System.out.println("Pressed OK.");
		    }
		});
	}
	
	@SuppressWarnings("null")
	public void HandleLoanRequestDetails(LoanRequest lRequest)
	{
		double piti28 = (lRequest.getdIncome())*0.28;
		double piti36 = ((lRequest.getdIncome())*0.36)-lRequest.getdExpenses();
		
		double piti = 0;
		if(piti28<piti36){
			piti = piti28;
		}
		else{
			piti = piti36;
		}
		
		TextInputControl lblCalculation = null;
		if(lRequest.getdRate()==0){
			lblCalculation.setText("Your Credit Score is too low.");
		}
		else if(lRequest.getdPayment()> piti){
			lblCalculation.setText("House Cost too high.");
		}
		else{
			lblCalculation.setText("Your monthly payment: " + String.format("%.2f",lRequest.getdPayment()));
		}
	}

		//	 - RocketClient.HandleLoanRequestDetails
		//			lRequest is an instance of LoanRequest.
		//			after it's returned back from the server, the payment (dPayment)
		//			should be calculated.
		//			Display dPayment on the form, rounded to two decimal places
		
	
	
	public void HandleExceptions (Exception e)
	{
		if (e instanceof LoanRequestException){
			
		}
		else if (e instanceof RateException){
			
		}
	}
}
