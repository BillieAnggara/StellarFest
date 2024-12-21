package main;

import controller.UserController;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;
import view.ViewCreateEvent;
import view.ViewEvent;
import view.ViewLogin;
import view.ViewRegister;
import model.User;

public class Main extends Application {

    private static Stage stage;
    
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
        ViewCreateEvent createEventView = new ViewCreateEvent();

        //MenuBar Login/register
        MenuBar uMenuBar = new MenuBar();
        Menu uMenu1 = new Menu("Login");
        Menu uMenu2 = new Menu("Register");
        MenuItem uItem1 = new MenuItem("Go to Login page");
        MenuItem uItem2 = new MenuItem("Go to Register page");

        uMenu1.getItems().add(uItem1);
        uMenu2.getItems().add(uItem2);
        uMenuBar.getMenus().addAll(uMenu1, uMenu2);

        uItem1.setOnAction(event -> {
            loginView.addMenuBar(uMenuBar);
            redirect(loginView.getScene());
        });

        uItem2.setOnAction(event -> {
            registerView.addMenuBar(uMenuBar);
            redirect(registerView.getScene());
        });
        
        //MenuBar content
        MenuBar contentMenuBar = new MenuBar();
        Menu cmenu1 = new Menu("Event");
        Menu cmenu2 = new Menu("Profile");
        MenuItem cItem1 = new MenuItem("View Event");
        MenuItem cItem2  = new MenuItem("Create Event");
        MenuItem cItem3 = new MenuItem("Change Profile");

        cmenu1.getItems().addAll(cItem1, cItem2);
        cmenu2.getItems().add(cItem3);
        contentMenuBar.getMenus().addAll(cmenu1, cmenu2);

        cItem1.setOnAction(event -> {
            eventView.addMenuBar(contentMenuBar);
            redirect(eventView.getScene());
        });

        cItem2.setOnAction(event -> {
            createEventView.addMenuBar(contentMenuBar);
            redirect(createEventView.getScene());
        });

        loginView.addMenuBar(uMenuBar);
        eventView.addMenuBar(contentMenuBar);
        
        // Set the Scene and Stage
        primaryStage.setTitle("StellarFest");
        primaryStage.setScene(loginView.getScene());
        primaryStage.show();

    }

}
