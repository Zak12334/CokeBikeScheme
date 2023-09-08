
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javafx.application.Application;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.Window;

public class RegistrationFormApplication extends Application {
//	ListView<String> listview;
	int count = 0;
	int bikeRemain;
	String[][] myLocNum = new String[5][2];

	int newcount = 0;
	double bikeCost;
	String[][] myTopUp = new String[5][2];

	public static void main(String[] args) {

		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("Coke Bikes Registration Form");

		// Create the registration form grid pane
		GridPane gridPane = createRegistrationForm();
		// Add UI controls to the registration form grid pane
		addUIControls(gridPane);
		// Create a scene with registration form grid pane as the root node
		Scene scene = new Scene(gridPane, 950, 800);
		// Set the scene in primary stage
		primaryStage.setScene(scene);
		primaryStage.show();
		gridPane.setStyle("-fx-base: black;");

	}

	private GridPane createRegistrationForm() {

		GridPane gridPane = new GridPane();

		// Position the pane at the center of the screen, both vertically and
		// horizontally
		gridPane.setAlignment(Pos.CENTER);

		// Set a padding of 40px on each side
		gridPane.setPadding(new Insets(40, 40, 40, 40));

		// Set the horizontal gap between columns
		gridPane.setHgap(10);

		// Set the vertical gap between rows
		gridPane.setVgap(10);

		ColumnConstraints columnOneConstraints = new ColumnConstraints(100, 100, Double.MAX_VALUE);
		columnOneConstraints.setHalignment(HPos.RIGHT);

		ColumnConstraints columnTwoConstrains = new ColumnConstraints(200, 200, Double.MAX_VALUE);
		columnTwoConstrains.setHgrow(Priority.ALWAYS);

		gridPane.getColumnConstraints().addAll(columnOneConstraints, columnTwoConstrains);

		return gridPane;
	}

	private void addUIControls(GridPane gridPane) {
		// Add Header
		Label headerLabel = new Label("Register");
		headerLabel.setFont(Font.font("Arial", FontWeight.BOLD, 24));
		gridPane.add(headerLabel, 0, 0, 2, 1);
		GridPane.setHalignment(headerLabel, HPos.CENTER);
		GridPane.setMargin(headerLabel, new Insets(20, 0, 20, 0));

		// Add Name Label
		Label nameLabel = new Label("First Name : ");
		gridPane.add(nameLabel, 0, 1);

		// Add Name Text Field
		TextField nameField = new TextField();
		nameField.setPromptText("First Name");
		nameField.setPrefHeight(40);
		gridPane.add(nameField, 1, 1);
		nameField.setStyle("-fx-base: white;");

		// Add Last Name Field
		Label nameLabel2 = new Label("Last Name : ");
		gridPane.add(nameLabel2, 0, 2);

		TextField lastName = new TextField();
		lastName.setPromptText("Last Name");
		lastName.setPrefHeight(40);
		gridPane.add(lastName, 1, 2);
		lastName.setStyle("-fx-base: white;");

		// Add DOB Field
		Label dobLabel = new Label("Day : ");
		gridPane.add(dobLabel, 0, 4);
		ComboBox<String> dobField = new ComboBox<>();
		dobField.setValue("");
		System.out.println(dobField.getValue());

		dobField.getItems().addAll("2007", "2006", "2005", "2004", "2003", "2002", "2001", "1999", "1998", "1997",
				"1996", "1995", "1994", "1993", "1992", "1991", "1990", "1989", "1988", "1987", "1986", "1985", "1984",
				"1983", "1982", "1981", "1980");

		dobField.setPromptText("Date of Birth");
		dobField.setEditable(true);
		dobField.setVisibleRowCount(8);
		gridPane.add(dobField, 1, 5);
		dobField.setStyle("-fx-base: white;");

		// Add day of birth
		Label dobLabel2 = new Label("Day : ");
		gridPane.add(dobLabel2, 0, 3);
		ComboBox<String> dobField2 = new ComboBox<>();
		dobField2.setValue("");
		System.out.println(dobField2.getValue());
		dobField2.getItems().addAll("January", "Febuary", "March", "April", "May", "June", "July", "August",
				"September", "October", "November", "Decemner");
		dobField2.setPromptText("Date of Birth");
		dobField2.setEditable(true);
		dobField2.setVisibleRowCount(8);
		gridPane.add(dobField2, 1, 4);
		dobField2.setStyle("-fx-base: white;");

		// Add DAY

		Label dobLabel3 = new Label("Year : ");
		gridPane.add(dobLabel3, 0, 5);
		ComboBox<String> dobField3 = new ComboBox<>();
		dobField3.setValue("");
		System.out.println(dobField3.getValue());
		dobField3.getItems().addAll("1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15",
				"16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31");
		dobField3.setPromptText("Date of Birth");
		dobField3.setEditable(true);
		dobField3.setVisibleRowCount(8);
		gridPane.add(dobField3, 1, 3);
		dobField3.setStyle("-fx-base: white;");

		// Add Gender Label

		Label Gender = new Label("Gender");
		gridPane.add(Gender, 0, 8);
		ComboBox<String> gender = new ComboBox<>();
		gender.getItems().addAll("Female");
		gender.getItems().addAll("Male");
		gender.setValue("");
		System.out.println(gender.getValue());
		gender.setPromptText("Male");
		gender.setEditable(true);
		gender.setVisibleRowCount(5);
		gridPane.add(gender, 1, 8);
		gender.setStyle("-fx-base: white;");

		// Add Email Label
		Label emailLabel = new Label("Email: ");
		gridPane.add(emailLabel, 0, 6);
		// Add Email Text Field
		TextField emailField = new TextField();
		emailField.setPromptText("Example@hotmail.com");
		emailField.setPrefHeight(40);
		gridPane.add(emailField, 1, 6);
		emailField.setStyle("-fx-base: white;");

		// Add mobile num Label
		Label moNumber = new Label("Mobile number : ");
		gridPane.add(moNumber, 0, 7);
		// Add mobile number Field
		TextField mobNumber = new TextField();
		mobNumber.setPromptText("12334566");
		mobNumber.setPrefHeight(40);
		gridPane.add(mobNumber, 1, 7);
		mobNumber.setStyle("-fx-base: white;");

		// Add address Field
		Label address = new Label("Address");
		gridPane.add(address, 0, 9);
		TextField addressLine = new TextField();
		addressLine.setPromptText("Address");
		addressLine.setPrefHeight(40);
		gridPane.add(addressLine, 1, 9);
		addressLine.setStyle("-fx-base: white;");

		// Add country Field
		Label countyLabel = new Label("County");
		gridPane.add(countyLabel, 0, 10);
		ComboBox<String> county = new ComboBox<>();
		county.getItems().addAll("Cork", "Clare", "Kerry");
		county.setValue("");
		System.out.println(county.getValue());
		county.setStyle("-fx-base: white;");
		county.setPromptText("County");
		county.setEditable(true);
		county.setVisibleRowCount(3);
		gridPane.add(county, 1, 10);

		// Add country list Field
		Label countryLabel2 = new Label("If not Ireland");
		gridPane.add(countryLabel2, 0, 11);
		ComboBox<String> country = new ComboBox<>();
		country.getItems().addAll("USA", "ITALY", "GERMANY", "NETHERLANDS", "ARGENTINA");
		country.setValue("");
		System.out.println(country.getValue());
		country.setPromptText("Select Country");
		country.setEditable(true);
		country.setVisibleRowCount(4);
		gridPane.add(country, 1, 11);
		country.setStyle("-fx-base: white;");

		// Add create Pin field
		Label pin = new Label("Create a Pin");
		gridPane.add(pin, 0, 12);
		TextField enterPin1 = new TextField();
		enterPin1.setPromptText("Create your 4 digit pin");
		gridPane.add(enterPin1, 1, 12);
		enterPin1.setStyle("-fx-base: white;");

		// Add terms and conditions check box
		Label termsConditions = new Label("Terms/Condtions: ");
		gridPane.add(termsConditions, 0, 13);
		CheckBox terms = new CheckBox();
		gridPane.add(terms, 1, 13);
		terms.setStyle("-fx-base: white;");

		// Add signUp button
		Button signupButton = new Button("Sign Up");
		signupButton.setPrefHeight(40);
		signupButton.setDefaultButton(true);
		signupButton.setPrefWidth(100);
		gridPane.add(signupButton, 0, 14, 3, 1);
		GridPane.setHalignment(signupButton, HPos.CENTER);
		GridPane.setMargin(signupButton, new Insets(20, 0, 20, 0));
		signupButton.setStyle("-fx-base: white;");

		Label adm = new Label("Enter your 4 Digit Pin");
		TextField adminPin = new TextField();
		adminPin.setPromptText("Enter your 4 Digit Pin");
		adminPin.setPrefHeight(40);
		adminPin.setStyle("-fx-base: white;");

		Button admin = new Button("Admin");
		admin.setPrefHeight(40);
		admin.setDefaultButton(true);
		admin.setPrefWidth(100);
		gridPane.add(admin, 0, 20, 3, 1);
		GridPane.setHalignment(admin, HPos.CENTER);
		GridPane.setMargin(admin, new Insets(20, 0, 20, 0));
		Button adminsignIn = new Button("SignIn");
		admin.setStyle("-fx-base: blue;");

		// Manager Screen

		Label man = new Label("Enter your 4 Digit Pin");
		TextField manPin = new TextField();
		manPin.setPromptText("Enter your 4 Digit Pin");
		manPin.setPrefHeight(40);
		manPin.setStyle("-fx-base: white;");

		Button manager = new Button("Manager");
		manager.setPrefHeight(40);
		manager.setDefaultButton(true);
		manager.setPrefWidth(100);
		gridPane.add(manager, 0, 20, 15, 1);
		GridPane.setHalignment(manager, HPos.CENTER);
		GridPane.setMargin(manager, new Insets(20, 0, 20, 0));
		// Button adminsignIn = new Button("SignIn");
		manager.setStyle("-fx-base: white;");
		Button mansignIn = new Button("Sign In");
		Button revenue = new Button("Today's Revenue");
		manager.setStyle("-fx-base: green;");

		// Sign In 4 digit textField
		Label account = new Label("");
		gridPane.add(account, 0, 14);
		TextField fourdigitpin = new TextField();
		fourdigitpin.setPromptText("Enter your 4 Digit Pin");
		fourdigitpin.setPrefHeight(40);
		gridPane.add(fourdigitpin, 1, 15);
		fourdigitpin.setStyle("-fx-base: white;");

		// Add sigin button
		Label signIn = new Label("Have an account?");
		gridPane.add(signIn, 0, 15);

		Button signinButton = new Button("Sign In");
		signinButton.setPrefHeight(40);
		signinButton.setDefaultButton(true);
		signinButton.setPrefWidth(100);
		gridPane.add(signinButton, 0, 16, 4, 2);
		GridPane.setHalignment(signinButton, HPos.CENTER);
		GridPane.setMargin(signinButton, new Insets(20, 0, 20, 0));
		signinButton.setStyle("-fx-base: white;");

		// Report Damaged Bike
		Label problem = new Label("Report Damages");
		gridPane.add(problem, 0, 19);
		TextField bike = new TextField();
		bike.setPromptText("Please enter the serial Number of the bike");
		bike.setEditable(true);
		gridPane.add(bike, 1, 19);
		bike.setStyle("-fx-base: white;");

		// damaged bike
		// Label pqprob = new Label("damaged bike reported at Pope's Quay");
		Button report = new Button("Submit");
		report.setPrefHeight(40);
		report.setDefaultButton(true);
		report.setPrefWidth(100);
		gridPane.add(report, 0, 20);
		GridPane.setHalignment(report, HPos.CENTER);
		GridPane.setMargin(report, new Insets(20, 0, 20, 0));
		report.setStyle("-fx-base: brown;");

		// screen for report
		report.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {

				if (bike.getText().isEmpty()) {

					showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Form Error!",
							"Please enter the serial number of the damaged bike! ");
					return;
				}

				else {
					showAlert(Alert.AlertType.CONFIRMATION, gridPane.getScene().getWindow(), "",
							"Thank you we will get right on that ");
				}

			}

		});
		// Help Button for sign In/Sign Up screen
		Button help = new Button("Help?");
		help.setPrefHeight(40);
		help.setDefaultButton(true);
		help.setPrefWidth(100);
		gridPane.add(help, 5, 20, 2, 1);
		GridPane.setHalignment(help, HPos.CENTER);
		GridPane.setMargin(help, new Insets(20, 0, 22, 0));
		help.setStyle("-fx-base: red;");

		// displays FAQ answer
		help.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {

				showAlert(Alert.AlertType.INFORMATION, gridPane.getScene().getWindow(), "FAQ",
						"Please Sign Up or if you have an account sign in with your 4 digit code: ");

				return;
			}
		});

		// Screen for bike rental
		TextField pinCode = new TextField();
		pinCode.setPromptText("Enter Pin to unlock bike(s)?");

		// button to unlock bike
		Button unlock = new Button("Unlock Bike");
		pinCode.setStyle("-fx-base: white;");
		unlock.setStyle("-fx-base: lightgreen;");
		// button to lock bike
		Button lock = new Button("Lock Bike");
		lock.setStyle("-fx-base: white;");

		// button to to up
		Label top = new Label("current Amount: 0");
		Button topUp = new Button("Top Up By €10");
		topUp.setStyle("-fx-base: white");

		Button logout = new Button("LogOut");
		logout.setStyle("-fx-base: red;");

		// rent bike
		Button rent = new Button("Rent a Bike");
		// damages button
		Button damages = new Button("Damaged Bikes");
		damages.setStyle("-fx-base: white");
		Button bikeShortage = new Button("Bike Shortge");
		bikeShortage.setStyle("-fx-base: white;");
		rent.setPrefHeight(40);
		rent.setDefaultButton(true);
		rent.setPrefWidth(100);
		gridPane.add(rent, 0, 20);
		GridPane.setHalignment(rent, HPos.CENTER);
		GridPane.setMargin(rent, new Insets(20, 0, 20, 0));

		// Button to return a bike
		Button ret = new Button("Return a Bike");
		ret.setPrefHeight(40);
		ret.setDefaultButton(true);
		ret.setPrefWidth(100);

		// locations for bikes
		String[] myLoc = { "Popes quay", "College Of Commerce", "UCC", "CIT", "Grand Parade" };

		String record = " ";
		try {
			System.out.println("Loading bike locations from a file");
			FileReader textFile = new FileReader("bikeLocations.txt");
			BufferedReader textF = new BufferedReader(textFile);

			// while (record != null) {
			while (count < 3) {
				record = textF.readLine();
				myLoc[count] = record;
				count += 1;

			}
		} catch (

		IOException e) {
			System.out.println("File Handle Exception");
		}

		int count = 0;

		try {
			System.out.println("Loading bike locations from a file");
			FileReader textFile = new FileReader("bikeLocations.txt");
			BufferedReader textF = new BufferedReader(textFile);

			// while (record != null) {

			while (count < 5) {
				record = textF.readLine();
				myLocNum[count][0] = record;
				myLocNum[count][1] = "10";
				System.out.println("Location at index " + count + " " + myLocNum[count][0]);
				System.out.println("Number of bikes at " + myLocNum[count][1]);

				count += 1;
			}
		} catch (

		IOException e) {
			System.out.println("File Handle Exception");
		}

		TextField Num1 = new TextField();
		Num1.setPromptText("How many bikes?");
		Num1.setStyle("-fx-base: white;");

		ToggleGroup group = new ToggleGroup();

		// Locations & bikes remaining

		RadioButton pq = new RadioButton(myLocNum[0][0] + " bikes remaining " + myLocNum[0][1]);
		pq.setUserData(myLocNum[0][0]);
		pq.setStyle("-fx-base: lightgreen;");
		pq.setToggleGroup(group);

		// pq.setAlignment(Pos.CENTER);

		RadioButton ccom = new RadioButton(myLocNum[1][0] + " bikes remaining " + myLocNum[1][1]);
		ccom.setUserData(myLocNum[1][0]);
		ccom.setStyle("-fx-base: lightblue;");
		ccom.setToggleGroup(group);
		// .setAlignment(Pos.CENTER);

		RadioButton ucc = new RadioButton(myLocNum[2][0] + " bikes remaining " + myLocNum[2][1]);
		ucc.setUserData(myLocNum[2][0]);
		ucc.setStyle("-fx-base: salmon;");
		ucc.setToggleGroup(group);
		// ucc.setAlignment(Pos.CENTER);

		RadioButton cit = new RadioButton(myLocNum[3][0] + " bikes remaining " + myLocNum[2][1]);
		cit.setUserData(myLocNum[2][0]);
		cit.setStyle("-fx-base: lightyellow;");
		cit.setToggleGroup(group);

		// cit.setAlignment(Pos.CENTER);

		RadioButton gp = new RadioButton(myLocNum[4][0] + " bikes remaining " + myLocNum[2][1]);
		gp.setUserData(myLocNum[2][0]);
		gp.setStyle("-fx-base: lightpink;");
		gp.setToggleGroup(group);
		// gp.setAlignment(Pos.CENTER);

		group.selectedToggleProperty().addListener((obserableValue, old_toggle, new_toggle) -> {
			if (group.getSelectedToggle() != null) {
				System.out.println("Index #" + group.getToggles().indexOf(new_toggle) + " selected!");
				int num1 = Integer.parseInt(Num1.getText()); // # of bikes to rent
				int x = group.getToggles().indexOf(new_toggle); // index number of array
				int bikes = Integer.parseInt(myLocNum[x][1]); // # of bikes remaining

				bikeRemain = bikes - num1;
				myLocNum[x][1] = String.valueOf(bikeRemain);

				System.out.println(num1 + " " + bikes + " " + myLocNum[x][1]);
				System.out.println("remaining bikes at " + group.getSelectedToggle().getUserData().toString() + " are "
						+ bikeRemain);
				System.out.println(
						"You have selected bike location: " + group.getSelectedToggle().getUserData().toString());
			}
		});

		ArrayList<String> locate = new ArrayList<String>();
		String record1 = " ";

		try {
			System.out.println("Loading locations from a file to a Combobox");
			FileReader textFile = new FileReader("bikeLocations.txt");
			BufferedReader textF = new BufferedReader(textFile);

			while (record1 != null) {
				record1 = textF.readLine();
				locate.add(record1);
				count += 1;
			}
		} catch (

		IOException e) {
			System.out.println("File Handle Exception");
		}
		System.out.println("There are " + count + " locations in the combobox");

		String[] myBike = { "30 mins is free", "1 hour is 50c", "2 hours is €2", "3 hours is €7", "4 hours" };

		String newRecord = " ";
		try {
			System.out.println("Loading bike locations from a file");
			FileReader textFile2 = new FileReader("bikeLocations.txt");
			BufferedReader newtextF = new BufferedReader(textFile2);

			// while (record != null) {
			while (newcount < 3) {
				newRecord = newtextF.readLine();
				myBike[newcount] = newRecord;
				newcount += 1;
			}
		} catch (

		IOException e) {
			System.out.println("File Handle Exception");
		}

		int newcount = 0;

		try {
			System.out.println("Loading bike locations from a file");
			FileReader textFile2 = new FileReader("bikeCost.txt");
			BufferedReader textF = new BufferedReader(textFile2);

			// while (record != null) {

			while (newcount < 5) {
				newRecord = textF.readLine();
				myTopUp[newcount][0] = newRecord;
				myTopUp[newcount][1] = "25";
				System.out.println("Location at index " + newcount + " " + myTopUp[newcount][0]);
				// System.out.println("Number of bikes at " + myBikes[newcount][1]);

				newcount += 1;
			}
		} catch (

		IOException e) {
			System.out.println("File Handle Exception");
		}

		// how many hours
		Label Hours = new Label("Pick How many Hours");
		Hours.setFont(Font.font("Arial", FontWeight.BOLD, 15));

		// TextField Num2 = new TextField();
		// Num2.setStyle("-fx-base: white;");

		// hours to rent
		ToggleGroup bikeGroup = new ToggleGroup();
		RadioButton cost = new RadioButton(myTopUp[0][0]);
		cost.setUserData(myTopUp[0][0]);
		cost.setSelected(false); // Initialised selected
		cost.setToggleGroup(bikeGroup);
		cost.setStyle("-fx-base: lightgreen;");

		RadioButton cost2 = new RadioButton(myTopUp[1][0]);
		cost2.setUserData(myTopUp[1][0]);
		cost2.setSelected(false); // Initialised selected
		cost2.setStyle("-fx-base: lightblue;");
		cost2.setToggleGroup(bikeGroup);

		RadioButton cost3 = new RadioButton(myTopUp[2][0]);
		cost3.setUserData(myTopUp[2][0]);
		cost3.setSelected(false);
		cost3.setStyle("-fx-base:  salmon;");
		cost3.setToggleGroup(bikeGroup);

		RadioButton cost4 = new RadioButton(myTopUp[3][0]);
		cost4.setUserData(myTopUp[3][0]);
		cost4.setSelected(false);
		cost4.setStyle("-fx-base:  white;");
		cost4.setToggleGroup(bikeGroup);

		RadioButton cost5 = new RadioButton(myTopUp[4][0]);
		cost5.setUserData(myTopUp[4][0]);
		cost5.setSelected(false);
		cost5.setStyle("-fx-base:  white;");
		cost5.setToggleGroup(bikeGroup);

		bikeGroup.selectedToggleProperty().addListener((obserableValue, old2_toggle, new2_toggle) -> {
			if (bikeGroup.getSelectedToggle() != null) {
				System.out.println("Index #" + bikeGroup.getToggles().indexOf(new2_toggle) + " selected!");
				// double num2 = Double.parseDouble(Num2.getText()); // # of hours to rent
				int y = bikeGroup.getToggles().indexOf(new2_toggle); // index number of array
				double costs = Double.parseDouble(myTopUp[y][1]); // amount

				System.out.println("You have selected: " + bikeGroup.getSelectedToggle().getUserData().toString());

			}

		});

		ArrayList<String> money = new ArrayList<String>();
		String record2 = " ";

		try {
			System.out.println("Loading locations from a file to a Combobox");
			FileReader textFile2 = new FileReader("bikeCost.txt");
			BufferedReader newtextF = new BufferedReader(textFile2);

			while (record2 != null) {
				record2 = newtextF.readLine();
				money.add(record2);
				count += 1;
			}
		} catch (

		IOException e) {
			System.out.println("File Handle Exception");
		}
		System.out.println("There are " + newcount + " locations in the combobox");

		// pin allocation array
		int[][] myLocNum1 = new int[5][4];
		int count1 = 0;

		myLocNum1[count1][0] = 3333;
		myLocNum1[count1][1] = 1111;
		myLocNum1[count1][2] = 2222;
		myLocNum1[count1][3] = 1234;
		// myLocNum1[count1][4] = 1111;

		count1 += 1;

		// Rent and return screen
		Stage scene1 = new Stage();
		VBox newBox = new VBox(10);
		newBox.setPadding(new Insets(50, 50, 20, 20));
		newBox.getChildren().addAll(rent, ret);
		newBox.setStyle("-fx-base: black;");

		// verrify pin
		signinButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				for (int row = 0; row < myLocNum[row].length; row++) {

					int Pnum = Integer.parseInt(fourdigitpin.getText());

					if (Pnum == myLocNum1[row][0]) {
						System.out.println("Pin entered was recognised");

					} else if (!(Pnum == myLocNum1[row][0])) {
						System.out.println("Pin entered was not recognised");

						return;
					}

					// what the rent button does when clicked
					rent.setOnAction(new EventHandler<ActionEvent>() {
						@Override
						public void handle(ActionEvent e) {

							// int Pnum = Integer.parseInt(fourdigitpin.getText());
							Stage scene1 = new Stage();
							scene1.setTitle("Rent a Bike");
							VBox rentBox = new VBox(10);
							rentBox.setPadding(new Insets(50, 50, 20, 20));
							rentBox.setAlignment(Pos.BASELINE_LEFT);

							for (int row = 0; row < myLocNum[row].length; row++) {
								int Pnum = Integer.parseInt(fourdigitpin.getText());
								System.out.println(myLocNum[row][0]);
								System.out.println(Pnum);
							}

							rentBox.getChildren().addAll(help, Num1, ccom, pq, ucc, cit, gp, pinCode, unlock, logout);

							// displays message to help the user
							help.setOnAction(new EventHandler<ActionEvent>() {
								@Override
								public void handle(ActionEvent e) {

									showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "FAQ",
											("Please choose location and number of bikes you would like to rent: "));

								}

							});
							Scene scene3 = new Scene(rentBox, 500, 550);
							scene1.initModality(Modality.APPLICATION_MODAL);
							scene1.setScene(scene3);
							scene1.show();
							rentBox.setStyle("-fx-base: grey;");

							unlock.setOnAction(new EventHandler<ActionEvent>() {
								@Override
								public void handle(ActionEvent e) {

//									for (int row = 0; row < myLocNum.length; row++) {
									// int Pnum = Integer.parseInt(pinCode.getText());

									if (pinCode.getText().isEmpty()) {
										showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Form Error!",
												"Please Your Pin to unlock Bike");
										return;

									}

									// if (Pnum == myLocNum[row][0]) {

									Alert alert = new Alert(AlertType.CONFIRMATION);
									alert.setTitle("Unclocked");
									alert.setHeaderText("Your Bike is now unlcoked!");
									if (alert.showAndWait().get() == ButtonType.OK) {

									}

								}

							});

							logout.setOnAction(new EventHandler<ActionEvent>() {
								@Override
								public void handle(ActionEvent e) {

									Alert alert = new Alert(AlertType.CONFIRMATION);
									alert.setTitle("Logout");
									alert.setHeaderText("You're about to logout!");
									alert.setContentText("Are you sure you want to log out?");

									if (alert.showAndWait().get() == ButtonType.OK) {
										System.out.println("You successfully logged out");
										scene1.close();

									}

								}
							});

						}

					});

					Scene scene4 = new Scene(newBox, 300, 250);
					scene1.setTitle("Rent/Return");
					newBox.setAlignment(Pos.CENTER);
					scene1.initModality(Modality.APPLICATION_MODAL);
					scene1.setScene(scene4);
					scene1.show();
				}

			}

		});

		// what the return screen does
		ret.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {

				Stage scene1 = new Stage();
				scene1.setTitle("Return a Bike");
				VBox retBox = new VBox(10);
				retBox.setPadding(new Insets(50, 50, 20, 20));
				retBox.setAlignment(Pos.BASELINE_LEFT);
				retBox.setStyle("-fx-base: grey;");

				retBox.getChildren().addAll(help, cost, cost2, cost3, cost4, cost5, pinCode, lock, logout);

				Scene scene = new Scene(retBox, 500, 550);
				scene1.initModality(Modality.APPLICATION_MODAL);
				scene1.setScene(scene);
				scene1.show();

				help.setOnAction(new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent e) {

						showAlert(Alert.AlertType.INFORMATION, gridPane.getScene().getWindow(), "FAQ",
								("Please put in your code in order to lock the bike: "));

						return;
					}

				});

				lock.setOnAction(new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent e) {

						if (pinCode.getText().isEmpty()) {
							showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Form Error!",
									"Please Your Pin to unlock Bike");
							return;

						}

						Alert alert = new Alert(AlertType.CONFIRMATION);
						alert.setTitle("Unclocked");
						alert.setHeaderText("Your Bike is now Locked!");
						if (alert.showAndWait().get() == ButtonType.OK) {

						}

					}

				});

				logout.setOnAction(new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent e) {

						Alert alert = new Alert(AlertType.CONFIRMATION);
						alert.setTitle("Logout");
						alert.setHeaderText("You're about to logout!");
						alert.setContentText("Are you sure you want to log out?");

						if (alert.showAndWait().get() == ButtonType.OK) {
							System.out.println("You successfully logged out");
							scene1.close();

						}

					}

				});

			}
		});

		// Card Details
		Label label = new Label("Enter your Card Details");
		TextField textUser = new TextField();
		textUser.setPromptText("Enter your Cardholder Name");
		textUser.setStyle("-fx-base: white");

		TextField textUser2 = new TextField();
		textUser2.setPromptText("Enter your Card Number");
		TextField textUser3 = new TextField();
		textUser2.setStyle("-fx-base: white");

		ComboBox<String> Expiry = new ComboBox<>();

		Expiry.setValue("");
		System.out.println(Expiry.getValue());

		Expiry.getItems().addAll("2021", "2022", "2023", "2024", "2025", "2026");

		Expiry.setPromptText("Expiry Year");
		Expiry.setEditable(true);
		Expiry.setVisibleRowCount(8);
		Expiry.setStyle("-fx-base: white");

		ComboBox<String> Exp = new ComboBox<>();

		Exp.setValue("");
		System.out.println(Exp.getValue());

		Exp.getItems().addAll("January", "Febuary", "March", "April", "May", "June", "July", "August", "September",
				"October", "November", "Decemner");

		Exp.setPromptText("Expiry Month");
		Exp.setEditable(true);
		Exp.setVisibleRowCount(8);
		Exp.setStyle("-fx-base: white");
		// gridPane.add(Exp, 1, 3);

		ComboBox<String> expiry = new ComboBox<>();

		expiry.setValue("");
		System.out.println(expiry.getValue());

		expiry.getItems().addAll("1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16",
				"17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31");

		expiry.setPromptText("Expiry Day");
		expiry.setEditable(true);
		expiry.setVisibleRowCount(8);
		expiry.setStyle("-fx-base: white");

		textUser3.setPromptText("Enter your CVV code");
		textUser3.setStyle("-fx-base: white");

		ToggleGroup group1 = new ToggleGroup();

		RadioButton money1 = new RadioButton("Anual Subscription €10");

		RadioButton money2 = new RadioButton("3 Day Pass  €3");
		money1.setToggleGroup(group1);
		money2.setToggleGroup(group1);
		money1.setStyle("-fx-base: lightblue");
		money2.setStyle("-fx-base: yellow");

		ToggleGroup group2 = new ToggleGroup();
		RadioButton visaDebit = new RadioButton("Visa Debit");

		RadioButton visaCredit = new RadioButton("Visa Credit");
		visaCredit.setToggleGroup(group2);
		visaDebit.setToggleGroup(group2);
		visaCredit.setStyle("-fx-base: lightblue;");
		visaDebit.setStyle("-fx-base: yellow;");

		Button submit = new Button();
		submit.setText("Submit");
		submit.setStyle("-fx-base: white");

		// validation for card details
		submit.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent e) {
				if (!textUser.getText().matches("[a-zA-Z\\s']+")) {
					showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Form Error!",
							"Please enter a valid Name ");
					return;
				}

				if (!textUser2.getText().matches("^4[0.9]{15}$")) {
					showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Form Error!",
							"Please enter a valid Card Number ");
					return;
				}

				if (expiry.getValue().isEmpty()) {
					showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Form Error!",
							"Please enter a expiry date ");
					return;
				}
				if (Expiry.getValue().isEmpty()) {
					showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Form Error!",
							"Please enter a expiry date ");
					return;
				}
				if (Exp.getValue().isEmpty()) {
					showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Form Error!",
							"Please enter a expiry date ");
					return;
				}
				if (textUser3.getText().isEmpty()) {
					showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Form Error!",
							"Please enter your CVV ");
					return;
				}
				if (!(money1.isSelected())) {
					showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Form Error!",
							"Please Select Subscription Type ");
					return;
				}
				if (!(visaDebit.isSelected())) {
					showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Form Error!",
							"Please Select card Type ");
					return;
				}
				if (!(visaCredit.isSelected())) {
					showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Form Error!",
							"Please Select card Type ");
					return;
				}
				// allows user to submit card details
				submit.setOnAction(new EventHandler<ActionEvent>() {

					@Override
					public void handle(ActionEvent e) {

						if (topUp.isPressed()) {
							showAlert(Alert.AlertType.CONFIRMATION, scene1.getScene().getWindow(), "!", "");
							return;
						}

						Scene scene4 = new Scene(newBox, 300, 250);
						scene1.setTitle("Rent/Return");
						newBox.setAlignment(Pos.CENTER);
						scene1.initModality(Modality.APPLICATION_MODAL);
						scene1.setScene(scene4);
						scene1.show();
					}
				});
				// alllows user to rent a bike
				rent.setOnAction(new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent e) {

						Stage scene1 = new Stage();
						scene1.setTitle("Rent a Bike");
						VBox newBox = new VBox(10);
						newBox.setPadding(new Insets(50, 50, 20, 20));
						newBox.setAlignment(Pos.BASELINE_LEFT);

						newBox.getChildren().addAll(help, Num1, ccom, pq, ucc, cit, gp, cost, cost2, cost3, cost4,
								cost5, pinCode, unlock, logout);

						Scene scene3 = new Scene(newBox, 500, 550);
						scene1.initModality(Modality.APPLICATION_MODAL);
						scene1.setScene(scene3);
						scene1.show();
						newBox.setStyle("-fx-base: grey;");

						logout.setOnAction(new EventHandler<ActionEvent>() {
							@Override
							public void handle(ActionEvent e) {

								Alert alert = new Alert(AlertType.CONFIRMATION);
								alert.setTitle("Logout");
								alert.setHeaderText("You're about to logout!");
								alert.setContentText("Are you sure you want to log out?");

								if (alert.showAndWait().get() == ButtonType.OK) {
									System.out.println("You successfully logged out");
									scene1.close();

								}

							}

						});
						// unlock bike
						unlock.setOnAction(new EventHandler<ActionEvent>() {
							@Override
							public void handle(ActionEvent e) {

								for (int row = 0; row < myLocNum.length; row++) {
									int Pnum = Integer.parseInt(pinCode.getText());
									// int Pnum = Integer.parseInt(fourdigitpin.getText());

									if (pinCode.getText().isEmpty()) {
										showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Form Error!",
												"Please Your Pin to unlock Bike");
										return;

									}

									if (Pnum == myLocNum1[row][0]) {

										Alert alert = new Alert(AlertType.CONFIRMATION);
										alert.setTitle("Unclocked");
										alert.setHeaderText("Your Bike is now unlcoked!");

										if (alert.showAndWait().get() == ButtonType.OK) {

										}

									}

								}
							}

						});
					}

				});
			}
		});
		// top up screen after sigining up
		topUp.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				int topUp = 0;

				topUp = topUp + 10;
				top.setText("Current amount : €" + topUp++);

			}
		});
		// admin signin screen
		admin.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent e) {

				Stage window2 = new Stage();
				window2.setTitle("Admin");
				VBox newBox = new VBox(10);
				newBox.setPadding(new Insets(50, 50, 20, 20));
				newBox.setAlignment(Pos.CENTER);

				newBox.getChildren().addAll(adm, adminPin, adminsignIn);

				Scene scene4 = new Scene(newBox, 300, 250);
				window2.initModality(Modality.APPLICATION_MODAL);
				window2.setScene(scene4);
				window2.show();
				newBox.setStyle("-fx-base: lightblue");

			}

		});

		// Admin after sign in
		adminsignIn.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent e) {

				Stage window3 = new Stage();
				window3.setTitle("Todays Reports");
				VBox adminBox = new VBox(10);
				adminBox.setAlignment(Pos.CENTER);
				adminBox.setStyle("-fx-base: black");

				for (int row = 1; row < myLocNum1[row].length; row++) {

					int adminPnum = Integer.parseInt(adminPin.getText());

					if (adminPnum == myLocNum1[row][1]) {
						System.out.println("admin pin recognised");
					} else {
						System.out.println("admin pin not recognised");
					}
					adminBox.getChildren().addAll(damages, bikeShortage, logout);

					Scene report = new Scene(adminBox, 300, 250);
					window3.initModality(Modality.APPLICATION_MODAL);
					window3.setScene(report);
					window3.show();

					logout.setOnAction(new EventHandler<ActionEvent>() {
						@Override
						public void handle(ActionEvent e) {

							Alert alert = new Alert(AlertType.CONFIRMATION);
							alert.setTitle("Logout");
							alert.setHeaderText("You're about to logout!");
							alert.setContentText("Are you sure you want to log out?");

							if (alert.showAndWait().get() == ButtonType.OK) {
								System.out.println("You successfully logged out");
								window3.close();

							}

						}
					});

				}

			}

		});

		// allows admin to check damaged bikes
		damages.setOnAction(e -> {

			showAlert(Alert.AlertType.INFORMATION, gridPane.getScene().getWindow(), "Welcome Back!",
					"No Damaged bikes were reported");
		});
		// allows admin to check bike shortages
		bikeShortage.setOnAction(e -> {

			showAlert(Alert.AlertType.INFORMATION, gridPane.getScene().getWindow(), "Welcome Back!",
					"No bike shortages ");

		});

		// maanager screen sign in
		manager.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent e) {

				Stage window4 = new Stage();
				window4.setTitle("Manager");
				VBox manBox = new VBox(10);
				manBox.setPadding(new Insets(50, 50, 20, 20));
				manBox.setAlignment(Pos.CENTER);

				manBox.getChildren().addAll(man, manPin, mansignIn);

				Scene scene4 = new Scene(manBox, 300, 250);
				window4.initModality(Modality.APPLICATION_MODAL);
				window4.setScene(scene4);
				window4.show();
				manBox.setStyle("-fx-base: lightblue");

			}

		});
		// Manager screen 2 after logged in
		mansignIn.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent e) {

				Stage window4 = new Stage();
				window4.setTitle("Todays Reports");
				VBox manBox = new VBox(10);
				manBox.setAlignment(Pos.CENTER);
				manBox.setStyle("-fx-base: black");

				for (int row = 2; row < myLocNum1[row].length; row++) {

					int manAdmin = Integer.parseInt(manPin.getText());

					if (!(manAdmin == myLocNum1[row][2])) {
						System.out.println("Signed in as amanger");

					} else {
						System.out.println("Manager not recognised");

					}
				}

				manBox.getChildren().addAll(revenue, logout);

				Scene report = new Scene(manBox, 300, 250);
				window4.initModality(Modality.APPLICATION_MODAL);
				window4.setScene(report);
				window4.show();

				logout.setOnAction(new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent e) {

						Alert alert = new Alert(AlertType.CONFIRMATION);
						alert.setTitle("Logout");
						alert.setHeaderText("You're about to logout!");
						alert.setContentText("Are you sure you want to log out?");

						if (alert.showAndWait().get() == ButtonType.OK) {
							System.out.println("You successfully logged out");
							window4.close();

						}

					}
				});

			}

		});
		// allows manager to check revenue
		revenue.setOnAction(e -> {

			showAlert(Alert.AlertType.INFORMATION, gridPane.getScene().getWindow(), "Welcome Back!",
					"No customers today");
		});

		// Validation of signUp
		signupButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent e) {

				if (!nameField.getText().matches("[a-zA-Z\\s']+")) {
					showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Form Error!",
							"Please enter a valid name ");
					return;
				}

				if (!lastName.getText().matches("[a-zA-Z\\s']+")) {
					showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Form Error!",
							"Please enter a valid last name");
					return;
				}
				if (!emailField.getText().matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
					showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Form Error!",
							"Please enter a valid email address");
					return;
				}
//
				if (!mobNumber.getText().matches("^(\\+\\d{1,2}\\s)?\\(?\\d{3}\\)?[\\s.-]?\\d{3}[\\s.-]?\\d{4}$")) {
					showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Form Error!",
							"Please enter a valid number ");
					return;
				}

				if (gender.getValue().isEmpty()) {
					showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Form Error!",
							"Please enter your Gender");
					return;
				}
//
				if (dobField.getValue().isEmpty()) {
					showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Form Error!",
							"Please enter your  Date of Birth");
					return;
				}

				if (dobField2.getValue().isEmpty()) {
					showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Form Error!",
							"Please enter your Date of Birth");
					return;
				}

				if (dobField3.getValue().isEmpty()) {
					showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Form Error!",
							"Please enter your Date of Birth");
					return;
				}
				if (addressLine.getText().isEmpty()) {
					showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Form Error!",
							"Please enter your address");
					return;
				}

				if (county.getValue().isEmpty()) {
					showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Form Error!",
							"Please select a county");
					return;
				}

				if (!country.getValue().isEmpty()) {
					showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Form Error!",
							"Please select a country");
					return;
				}
				if (enterPin1.getText().isEmpty()) {
					showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Form Error!",
							"Please enter 4 digit pin");
					return;
				}

				if (!(terms.isSelected())) {
					showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Form Error!",
							"Please accept the Terms and Conditions, The National Transport Authority is providing a service "
									+ "(the \"Service\") enabling access to self-service hire bicycles in the cities of Galway, Limerick and Cork "
									+ "under public bike share schemes operated as Coca-Cola Zero® Bikes.\r\n" + "\r\n"
									+ "The Service is operated on behalf of the National Transport Authority by Telfourth Limited, "
									+ "trading as An Rothar Nua.\r\n" + "\r\n"
									+ "These terms and conditions set out the agreement between you and the National Transport Authority "
									+ "in relation to the opening and operation of an account with "
									+ "the National Transport Authority for the use of the Coca-Cola Zero® Bikes.\r\n"
									+ "\r\n" + "Coca-Cola Zero is a registered trademark of the Coca-Cola Company.\r\n"
									+ "\r\n"
									+ "The Authority would draw your attention to the fact that amounts are payable by you "
									+ "in connection with this Agreement.  For further details of the amounts that may be payable, "
									+ "please see clauses 6, 7, 10 and 13 €150 deposit will also be chahrged if bikes are dmaged in your person.");
					return;
				}

				// stage for credt card details.
				Stage stage = new Stage();
				stage.initModality(Modality.APPLICATION_MODAL);
				VBox box = new VBox(10);
				Scene scene2 = new Scene(box, 500, 500);
				box.setStyle("-fx-base: orange;");

				// TRIED TO USE THIS CODE TO VALIDATE NEW CUSTOMER PIN BUT IT DIDNT WORK FOR ME

//				for (int count1 = 3; count1 < myLocNum1[count1].length; count1++) {
//
//					int newcustPin = Integer.parseInt(enterPin1.getText());
//
//					if (newcustPin == myLocNum1[count1][3]) {
//
//						System.out.println("Pin accepted");
////						showAlert(Alert.AlertType.CONFIRMATION, gridPane.getScene().getWindow(),
////								" Registration Sucessful!", " Welcome " + nameField.getText());
//						
//						//return;
//
//					} else {
//						
//						System.out.println("Pin not accepted");
//						
//						return;
////						showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), " Registration Unsucessful!",
////								"  " + nameField.getText());
//						// System.out.println("Pin accepted");
//						
//
//					}
//				}

				box.setAlignment(Pos.BASELINE_LEFT);
				stage.setTitle("Payment Details");
				box.getChildren().add(visaDebit);
				box.getChildren().add(visaCredit);
				box.getChildren().add(label);
				box.getChildren().add(textUser);
				box.getChildren().add(textUser2);
				box.getChildren().add(Exp);
				box.getChildren().add(Expiry);
				box.getChildren().add(expiry);
				box.getChildren().add(textUser3);
				box.getChildren().add(money1);
				box.getChildren().add(money2);
				box.getChildren().add(topUp);
				box.getChildren().add(top);
				box.getChildren().add(submit);
				stage.setScene(scene2);
				stage.show();

				showAlert(Alert.AlertType.CONFIRMATION, gridPane.getScene().getWindow(), " Registration Sucessful!",
						" Welcome " + nameField.getText());

			}

		});

	}

	private void showAlert(Alert.AlertType alertType, Window owner, String title, String message) {
		Alert alert = new Alert(alertType);
		alert.setTitle(title);
		alert.setHeaderText(null);
		alert.setContentText(message);
		alert.initOwner(owner);
		alert.show();
	}

}