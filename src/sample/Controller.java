package sample;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.scene.image.Image;

import java.io.IOException;

public class Controller
{
    static Admin admin;

    @FXML
    TextField AccountID;
    @FXML
    PasswordField Password;
    @FXML
    Label Error;
    @FXML
    Label X;



    public void Login(ActionEvent event) throws Exception{
        System.out.println("In Login");
        int ANo = Integer.parseInt(AccountID.getText());
        String password  = Password.getText();
        System.out.println(admin.AccountList.toString());

        if (admin.Active == null) {

            if (admin.AccountList.contains(ANo)) {
                if (admin.map.get(ANo).Password.equals(password)) {
                    admin.Active = admin.map.get(ANo);

                    Stage primaryStage = new Stage();
                    //Parent root = FXMLLoader.load(getClass().getResource("UserPage.fxml"));
                    FXMLLoader loader = new FXMLLoader(
                            getClass().getResource("Fxml/UserPage.fxml")
                    );
                    loader.setController(this);
                    Parent root = loader.load();
                    primaryStage.setTitle("Welcome Page");
                    primaryStage.setScene(new Scene(root, 667, 400));
                    primaryStage.show();
                    AccountID.setText("");
                    Password.setText("");
                    X.setText(admin.Active.Name);
                } else {
                    Error.setText("Password is Wrong, Try Again");
                }
            } else {
                Error.setText("Account Does not Exist");
            }
        }

    }

    @FXML
    private javafx.scene.control.Button Logout;
    public void logout(ActionEvent event) throws Exception{
        Stage stage = (Stage) Logout.getScene().getWindow();
        stage.close();
        admin.Active=null;
    }

    @FXML
    TextField Amount;
    public void DepositMoney(ActionEvent event) throws Exception{
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("Fxml/DepositMoney.fxml"));
        primaryStage.setTitle("Welcome Page");
        primaryStage.setScene(new Scene(root,500, 300));
        primaryStage.show();

    }
    public void Deposit(ActionEvent event){
        System.out.println(admin.Active.Amount);
        admin.Active.Amount += Integer.parseInt(Amount.getText());
        Error.setText("Money Deposited");
        System.out.println(admin.Active.Amount);
    }

    @FXML
    Label CheckAmount;
    public void CheckBalance(ActionEvent event) throws  Exception{
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("Fxml/CheckBalance.fxml"));
        primaryStage.setTitle("Welcome Page");
        primaryStage.setScene(new Scene(root,500, 300));
        primaryStage.show();
    }
    public void Show(ActionEvent event){
        System.out.println(admin.Active.Amount);
        CheckAmount.setText("₹ " + admin.Active.Amount);
    }

    @FXML
    TextField WithdrawAmount;
    public void WithdrawMoney(ActionEvent event) throws  Exception{
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("Fxml/WithdrawMoney.fxml"));
        primaryStage.setTitle("Welcome Page");
        primaryStage.setScene(new Scene(root,500, 300));
        primaryStage.show();
    }
    public void Withdraw(ActionEvent event){
        int a = Integer.parseInt(WithdrawAmount.getText());
        if (a>admin.Active.Amount )
            Error.setText("In Sufficient Balance");
        else {
            admin.Active.Amount -= a;
            Error.setText("Money Withdrawn");
        }


    }

    @FXML
    TextField TransferAmount;
    @FXML
    TextField TranferID;
    public void TransferMoney(ActionEvent event) throws Exception{
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("Fxml/BalanceTransfer.fxml"));
        primaryStage.setTitle("Welcome Page");
        primaryStage.setScene(new Scene(root,500, 300));
        primaryStage.show();

    }
    public void Transfer(ActionEvent event) throws Exception{
            int tid = Integer.parseInt(TranferID.getText());
            if (tid == admin.Active.AccountID) {
                Error.setText("Dumb ASS You cant tranfer \n to your own account");
                TranferID.setText("");
                TransferAmount.setText("");
            }
            else {
                if (admin.AccountList.contains(tid)){

                    if (Integer.parseInt(TransferAmount.getText())<=admin.Active.Amount) {
                        admin.map.get(tid).Amount += Integer.parseInt(TransferAmount.getText());
                        Error.setText("Transferrd");
                    }
                    else
                        Error.setText("In Sufficient Balance");
                }
                else {
                    Error.setText("Account Does not Exist \n Re-Enter");
                }
            }

    }

    @FXML
    Label AccountId = new Label("");
    @FXML
    Label Name;
    @FXML
    Label CurrentBalance = new Label("");
    @FXML
    Image img;
    @FXML
    ImageView imgid;



    public void Information(ActionEvent event) throws Exception{

        Stage primaryStage = new Stage();
        //Parent root = FXMLLoader.load(getClass().getResource("UserPage.fxml"));
        FXMLLoader loader = new FXMLLoader(
                getClass().getResource("Fxml/Information.fxml")
        );
        loader.setController(this);
        Parent root = loader.load();
        primaryStage.setTitle("Welcome Page");
        primaryStage.setScene(new Scene(root, 519, 400));
        primaryStage.show();
        System.out.println("/home/hrishabh0901/Desktop/Main/Java/ATM/src/sample/Img/"+admin.Active.AccountID+".jpg");
        AccountId.setText(""+admin.Active.AccountID);
        Name.setText(admin.Active.Name);
        CurrentBalance.setText("₹ " + admin.Active.Amount);
        img = new Image(getClass().getResource("Img/"+admin.Active.AccountID+".jpg").toExternalForm());
        //System.out.println(img.toString());
        imgid.setImage(img);
    }



    public void ChangePassword(ActionEvent event) throws Exception{
        Stage primaryStage = new Stage();
        //Parent root = FXMLLoader.load(getClass().getResource("UserPage.fxml"));
        FXMLLoader loader = new FXMLLoader(
                getClass().getResource("Fxml/CP.fxml")
        );
        loader.setController(this);
        Parent root = loader.load();
        primaryStage.setTitle("Welcome Page");
        primaryStage.setScene(new Scene(root, 500, 300));
        primaryStage.show();
    }

    @FXML
    PasswordField OldP;
    @FXML
    PasswordField NewP;

    public void Change(ActionEvent event) throws Exception{

        System.out.println(admin.Active.Password + "  " + OldP.getText());
        if (admin.Active.Password.equals(OldP.getText())){
            admin.Active.Password = NewP.getText();
        }
        else {
            Error.setText("Wrong Password");
        }
    }


    @FXML
    public Button closeButton;
    @FXML
    public void handleCloseButtonAction(ActionEvent event) {
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
    }



}


