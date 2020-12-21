package dormandmealfx;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class DormAndMealFx extends Application {
   // main method
   public static void main(String[] args) {
       Application.launch(args);
   }

   @SuppressWarnings("unchecked")
   @Override
   public void start(Stage primaryStage) {
       primaryStage.setTitle("Dorm and Meal Plan Calculator"); // sets the title
       Scene scene = new Scene(new Group());

       // dorm rates
       double[] drate = { 1500, 1600, 1200, 1800 };

       // meal plan rates
       double[] mrate = { 560, 1095, 1500 };

       // textfield
       TextField totalTextBox = new TextField();
       totalTextBox.setPrefWidth(70);
       totalTextBox.setEditable(false);

       GridPane grid = new GridPane();
       grid.setVgap(10);
       grid.setHgap(10);
       grid.setPadding(new Insets(5, 5, 5, 5));
       // Setting size for the pane
       grid.setMinSize(400, 200);
       grid.setAlignment(Pos.CENTER);

       // Create the ComboBox
       final ComboBox<String> dormBox = new ComboBox<>();
       // Add the Months to the ComboBox
       dormBox.getItems().addAll("Allen Hall $" + 1500, "Pike Hall $" + 1600, "Farthing Hall $" + 1200,
               "University Suites $" + 1800);
       // Create a combo box dormBox action event
       dormBox.setOnAction(new EventHandler<ActionEvent>() {
           @Override
           public void handle(ActionEvent e) {

               int dorm = 0;
               int meal = 0;
               double totall;

               // gets the dorm selected
               dorm = dormBox.getSelectionModel().getSelectedIndex();
               if (dorm > 0) {
                   meal = dormBox.getSelectionModel().getSelectedIndex();
               }

               // add selections
               totall = drate[dorm] + mrate[meal];
               totalTextBox.setText("$" + totall);

           }
       });

       // Create the ComboBox
       final ComboBox<String> mealBox = new ComboBox<>();
       // Add the Months to the ComboBox
       mealBox.getItems().addAll("7 Meals Per Week $" + 560, "14 Meal Per Week $" + 1095, "Unlimited Meals $" + 1500);

       // Create a combo box dormBox action event
       mealBox.setOnAction(new EventHandler<ActionEvent>() {
           @Override
           public void handle(ActionEvent e) {
               int dorm = 0;
               int meal = 0;
               double totall;

               // gets the dorm selected
               meal = mealBox.getSelectionModel().getSelectedIndex();
               if (meal > 0) {
                   dorm = dormBox.getSelectionModel().getSelectedIndex();
               }

               // add selections
               totall = drate[dorm] + mrate[meal];
               totalTextBox.setText("$" + totall);

           }
       });

       grid.add(dormBox, 0, 0);
       grid.add(mealBox, 0, 1);
       grid.add(new Label("Your total charges for the semester is: "), 0, 2);
       grid.add(totalTextBox, 0, 3);
       Group root = (Group) scene.getRoot();
       root.getChildren().add(grid);
       primaryStage.setScene(scene);
       primaryStage.show();
   }
}