/**
 * 
 */
package java8.impatient;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * @author Rishabh.Daim
 *
 */
@SuppressWarnings("restriction")
public class MyJavaFXApp extends Application{

	@Override
	public void start(Stage stage) throws Exception {
		
		final double rem = new Text("").getLayoutBounds().getHeight();
		
		Label msg = new Label("Hello, JavaFX!!");
		msg.setFont(new Font(100));
		Button red = new Button("RED");
		red.setOnAction(event -> msg.setTextFill(Color.RED));
		Slider slider = new Slider(10, 100, 50);
		slider.valueProperty().addListener(property -> msg.setFont(new Font(slider.getValue())));
		Text t1 = new Text("Shipping");
		Text t2 = new Text("Billing");
		t2.textProperty().bindBidirectional(t1.textProperty());
		Circle circle = new Circle(20, Color.BLACK);
		Button larger = new Button("Larger");
		Button smaller = new Button("Smaller");
		VBox box = new VBox(10, t1, msg, red, slider, t2);
		box.setPadding(new Insets(0.8 * rem));
		BorderPane borderPane = new BorderPane(box);
		borderPane.setLeft(smaller);
		borderPane.setRight(larger);
		borderPane.setBottom(circle);
		borderPane.setPadding(new Insets(1 * rem));
		Scene s = new Scene(borderPane);
		circle.centerXProperty().bind(Bindings.divide(s.widthProperty(), 2));
		smaller.disableProperty().bind(Bindings.lessThanOrEqual(slider.valueProperty(), 12));
		larger.disableProperty().bind(Bindings.greaterThanOrEqual(slider.valueProperty(), 99));
		stage.setScene(s);
		stage.setTitle("Hello!!");
		stage.show();
	}

}
