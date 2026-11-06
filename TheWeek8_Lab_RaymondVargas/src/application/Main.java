package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main extends Application{
	@Override
	public void start (Stage stage) {
		
		// 1.
		
		Label title = new Label("College Student Services");
		title.setStyle("-fx-font-size: 22px; -fx-font-weight: bold");
		
		Label userLabel = new Label("JavaFxLayouts Lab");
		
		HBox header = new HBox(title, new Region(), userLabel);
		
		HBox.setHgrow(header.getChildren().get(1), Priority.ALWAYS);
		header.setAlignment(Pos.CENTER_LEFT);
		header.setPadding(new Insets(15));
		header.setStyle("-fx-background-color: #dceeff;");
		
		// 2.
		
		Label menuTitle = new Label("MENU");
		menuTitle.setStyle("-fx-font-weight: bold;");
		Button dashboardButton = new Button("Dashboard");
		Button registrationButton = new Button("Registration");
		Button coursesButton = new Button ("Courses");
		Button helpButton = new Button("Help");
		
		VBox navigation = new VBox (12,
				menuTitle, dashboardButton, registrationButton,
				coursesButton, helpButton);
		
		HBox topBar = new HBox();
		topBar.setSpacing(10);
		topBar.setPadding(new Insets(10));
		
		VBox leftNav = new VBox();
		leftNav.setSpacing(15);
		leftNav.setPadding(new Insets(10));
		
		VBox centerForm = new VBox();
		centerForm.setSpacing(15);
		centerForm.setPadding(new Insets(10, 15, 10, 15));
		
		GridPane grid = new GridPane();
		grid.setHgap(10);
		grid.setVgap(12);
		grid.setPadding(new Insets(10));
		
		HBox actionButtons = new HBox();
		actionButtons.setSpacing(10);
				
		// 3.
		Label formTitle = new Label("Student Registration");
		formTitle.setStyle("-fx-font-size: 18px; -fx-font-weight: bold");
		
		TextField idField = new TextField();
		idField.setPromptText("e.g. 51001");
		
		TextField nameField = new TextField();
		nameField.setPromptText("Enter Full Name:");
		
		TextField emailField = new TextField();
		emailField.setPromptText("name@example.com");
		
		ComboBox<String> programBox = new ComboBox();
		programBox.getItems().addAll(
				"Computer Programming",
				"Cybersecurity",
				"Data Analytics",
				"Cloud Computing");
		programBox.setPromptText("Select a Program");
		
		GridPane form = new GridPane();
		form.setHgap(12);
		form.setVgap(14);
		form.add(new Label("Student ID:"), 0, 0);
		form.add(idField, 1, 0);
		form.add(new Label("Full Name:"), 0, 1);
		form.add(nameField, 1, 1);
		form.add(new Label("Email:"), 0, 2);
		form.add(emailField, 1, 2);
		form.add(new Label("Program:"), 0, 3);
		form.add(programBox, 1, 3);
		ColumnConstraints labelColumn = new ColumnConstraints();
		labelColumn.setMinWidth(100);
		ColumnConstraints inputColumn = new ColumnConstraints();
		inputColumn.setHgrow(Priority.ALWAYS);
		form.getColumnConstraints().addAll(labelColumn, inputColumn);
		
		// 4.
		Label statusLabel = new Label("Complete the form and select Register");
		Button registerButton = new Button("Register");
		Button clearButton = new Button("Clear");
		
		HBox actions = new HBox(10, registerButton, clearButton);
		actions.setAlignment(Pos.CENTER_LEFT);
		
		VBox centerContent = new VBox(18, formTitle, form, actions, statusLabel);
		centerContent.setPadding(new Insets(15));
		centerContent.setMaxWidth(620);
		
		registerButton.setOnAction(event -> {
			String id = idField.getText().trim();
			String name = nameField.getText().trim();
			String email = emailField.getText().trim();
			String program = programBox.getValue();
			
			if (id.isEmpty() ||name.isEmpty() || email.isEmpty() || program == null) {
				statusLabel.setText("Please complete every field.");
			} else if (!email.matches("^[^\\s@]+@[^\\s@]+\\.[^\\s@]+$")) {
				statusLabel.setText("Please enter a valid email address.");
			} else {
			    statusLabel.setText(
			        "Registration Successful! " +
			        name + " enrolled in " + program + "."
			    );
			}
		});
		
		clearButton.setOnAction(event -> {
			idField.clear();
			nameField.clear();
			emailField.clear();
			programBox.getSelectionModel().clearSelection();
			statusLabel.setText("Form cleared.");
		});
		
		// 5.
		
		BorderPane root = new BorderPane();
		root.setTop(header);
		root.setLeft(navigation);
		root.setCenter(centerContent);
		root.setStyle("-fx-background-color: white;");
		
		BorderPane.setMargin(centerContent, new Insets(5));
		
		Scene scene = new Scene(root, 850, 520);
		stage.setTitle("JavaFX layout Managers Lab");
		stage.setScene(scene);
		stage.show();
		}
	
	public static void main(String[] args) {
		launch(args);
	}
}