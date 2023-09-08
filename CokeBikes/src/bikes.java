import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class bikes extends Application {
	int count = 0;
	int bikeRemain;
	String[][] myLocNum = new String[3][2];

	public static void main(String[] args) {

		launch(args);
	}

	@Override
	public void init() throws Exception {
		super.init(); // call the super class method

	 String [] myLoc = {"Popes quay","College Of Commerce","UCC"};
		//String[] myLoc = new String[3];
		String record = " ";
		try {
			System.out.println("Loading bike locations from a file");
			FileReader textFile = new FileReader("Locations.txt");
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
			FileReader textFile = new FileReader("Locations.txt");
			BufferedReader textF = new BufferedReader(textFile);

			// while (record != null) {

			while (count < 3) {
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
		}}
	
	

	@Override
	public void start(Stage primaryStage) throws Exception {

		primaryStage.setTitle("Arrays for data storage");
		TextField Num1 = new TextField();
		Num1.setPromptText("How many bikes?");

		/*
		 * ToggleGroup group = new ToggleGroup();
		 * 
		 * RadioButton pq = new RadioButton(myLoc[0]); pq.setUserData(myLoc[0]);
		 * pq.setSelected(true); // Initialised selected pq.setToggleGroup(group);
		 * 
		 * RadioButton ccom = new RadioButton(myLoc[1]); ccom.setUserData(myLoc[1]);
		 * ccom.setToggleGroup(group);
		 * 
		 * RadioButton ucc = new RadioButton(myLoc[2]); ucc.setUserData(myLoc[2]);
		 * ucc.setToggleGroup(group);
		 */

		ToggleGroup group = new ToggleGroup();

		// RadioButton pq = new RadioButton(myLocNum[0][0] );
		RadioButton pq = new RadioButton(myLocNum[0][0] + " bikes remaining " + myLocNum[0][1]);

		pq.setUserData(myLocNum[0][0]);
		pq.setSelected(true); // Initialised selected
		pq.setStyle("-fx-base: lightgreen;");
		pq.setToggleGroup(group);

		RadioButton ccom = new RadioButton(myLocNum[1][0]+ " bikes remaining " + myLocNum[1][1]);
		ccom.setUserData(myLocNum[1][0]);
		ccom.setStyle("-fx-base: lightblue;");
		ccom.setToggleGroup(group);

		RadioButton ucc = new RadioButton(myLocNum[2][0] + " bikes remaining " + myLocNum[2][1]);
		ucc.setUserData(myLocNum[2][0]);
		ucc.setStyle("-fx-base: salmon;");
		ucc.setToggleGroup(group);

		group.selectedToggleProperty().addListener((obserableValue, old_toggle, new_toggle) -> {
			if (group.getSelectedToggle() != null) {
				System.out.println("Index #" + group.getToggles().indexOf(new_toggle) + " selected!");
				int num1 = Integer.parseInt(Num1.getText()); //# of bikes to rent
				int x = group.getToggles().indexOf(new_toggle);  //index number of array
				int bikes = Integer.parseInt(myLocNum[x][1]); //# of bikes remaining

				bikeRemain = bikes - num1;
				myLocNum[x][1] = String.valueOf(bikeRemain);

				System.out.println(num1 + " " + bikes + " " + myLocNum[x][1]);
				System.out.println("remaining bikes at " + group.getSelectedToggle().getUserData().toString() + " are "
						+ bikeRemain);
				System.out.println(
						"You have selected bike location:- " + group.getSelectedToggle().getUserData().toString());
			}
		});

		ComboBox<String> bloc = new ComboBox<>();
		Button b1 = new Button("Submit");

		bloc.getItems().addAll("Popes quay","College Of Commerce","UCC");

		bloc.setValue("UCC");
		System.out.println(bloc.getValue());

		
		b1.setOnAction(e -> System.out.println("This was printed from a button click " + bloc.getValue()));

		bloc.setOnAction(e -> System.out.println("Combo box creates its own action " + bloc.getValue()));

		ArrayList<String> locate = new ArrayList<String>();
		String record = " ";

		try {
			System.out.println("Loading locations from a file to a Combobox");
			FileReader textFile = new FileReader("Locations.txt");
			BufferedReader textF = new BufferedReader(textFile);

			while (record != null) {
				record = textF.readLine();
				locate.add(record);
				count += 1;
			}
		} catch (

		IOException e) {
			System.out.println("File Handle Exception");
		}
		System.out.println("There are " + count + " locations in the combobox");

		//ComboBox<String> loc = new ComboBox<String>(FXCollections.observableArrayList(locate));
		// ComboBox<String> list = new ComboBox<>();
		VBox vbox = new VBox(10);
		vbox.setPadding(new Insets(30, 30, 30, 30));
		vbox.getChildren().addAll(pq, ccom, ucc, Num1, bloc, b1);

		Scene scene = new Scene(vbox, 300, 400);
		primaryStage.setScene(scene);
		primaryStage.show();

	}

}