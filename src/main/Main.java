package main;

import controller.UserController;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;
import view.ViewEvent;
import view.ViewLogin;
import view.ViewRegister;
import model.User;

public class Main extends Application {

    private static Stage stage;
    private MenuBar menuBar;
    private Menu menu1, menu2;
    private MenuItem item1, item2;
    
    public static void redirect(Scene newScene) {
        stage.setScene(newScene);
        stage.centerOnScreen();
        stage.setResizable(false);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        stage = primaryStage;

        // Initialize the View and Controller
        ViewRegister registerView = new ViewRegister();
        ViewLogin loginView = new ViewLogin();
        ViewEvent eventView = new ViewEvent();
        UserController controller = new UserController(registerView, loginView, eventView);

        MenuBar firstMenuBar = new MenuBar();
        Menu menu1 = new Menu("Login");
        Menu menu2 = new Menu("Register");
        MenuItem item1 = new MenuItem("Go to Login page");
        MenuItem item2 = new MenuItem("Go to Register page");

        // Add items to the menus
        menu1.getItems().add(item1);
        menu2.getItems().add(item2);
        firstMenuBar.getMenus().addAll(menu1, menu2);

        // Event handlers for navigation
        item1.setOnAction(event -> {
            loginView.addMenuBar(firstMenuBar); // Attach MenuBar to login view
            redirect(loginView.getScene());
        });

        item2.setOnAction(event -> {
            registerView.addMenuBar(firstMenuBar); // Attach MenuBar to register view
            redirect(registerView.getScene());
        });

        // Initially attach MenuBar to login view
        loginView.addMenuBar(firstMenuBar);
        
        // Set the Scene and Stage
        primaryStage.setTitle("StellarFest");
        primaryStage.setScene(loginView.getScene());
        primaryStage.show();

    }

}
