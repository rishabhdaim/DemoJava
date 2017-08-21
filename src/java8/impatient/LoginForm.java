/**
 * 
 */
package java8.impatient;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * @author Rishabh.Daim
 *
 */
@SuppressWarnings("restriction")
public class LoginForm extends Application {

	/* (non-Javadoc)
	 * @see javafx.application.Application#start(javafx.stage.Stage)
	 */
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		final double rem = new Text("").getLayoutBounds().getHeight();
		
		GridPane gridPane = new GridPane();
		
		Label userNameLabel = new Label("UserName");
		Label passwordLabel = new Label("Password");
		
		TextField userName = new TextField("UserName");
		PasswordField password = new PasswordField();
		
		Button ok = new Button("ok");
		Button cancel = new Button("cancel");
		
		HBox hBox = new HBox(ok, cancel);
		
		gridPane.add(userNameLabel, 0, 0);
		gridPane.add(userName, 1, 0);
		gridPane.add(passwordLabel, 0, 1);
		gridPane.add(password, 1, 1);
		
		gridPane.add(hBox, 0, 2, 2, 1);
		
		GridPane.setHalignment(userNameLabel, HPos.RIGHT);
		GridPane.setHalignment(passwordLabel, HPos.RIGHT);
		
		GridPane.setHalignment(userName, HPos.LEFT);
		GridPane.setHalignment(password, HPos.LEFT);
		
		hBox.setAlignment(Pos.CENTER);
		hBox.setPadding(new Insets(.8 * rem));
		
		gridPane.setHgap(1 * rem);
		gridPane.setVgap(1 * rem);
		gridPane.setPadding(new Insets(.8 * rem));
		
		//gridPane.setGridLinesVisible(true);
		
		primaryStage.setScene(new Scene(gridPane));
		primaryStage.setTitle("Login Form");
		primaryStage.show();
	}

}
