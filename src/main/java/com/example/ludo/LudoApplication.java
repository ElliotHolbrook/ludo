package com.example.ludo;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.TriangleMesh;
import javafx.stage.Stage;

import java.io.IOException;

public class LudoApplication extends Application {
    private int WINDOW_WIDTH = 500;
    private int WINDOW_HEIGHT = 650;
    private double finish_zone_width = WINDOW_WIDTH * (3.0 / 15);

    @Override
    public void start(Stage stage) throws IOException {
        BorderPane border = new BorderPane();
        VBox root = new VBox();
        border.setCenter(root);
        root.setStyle("-fx-background-color: lightgrey");
        Scene scene = new Scene(border);
        stage.setTitle("Ludo");
        stage.setWidth(WINDOW_WIDTH);
        stage.setHeight(WINDOW_HEIGHT);
        stage.setResizable(false);
        stage.setScene(scene);

        setUpBoardUI(root);
        setUpControlsUI(root);

        Menu fileMenu = new Menu("File");
        MenuItem newGame = new MenuItem("New Game");
        MenuItem exit = new MenuItem("Exit");
        fileMenu.getItems().addAll(newGame, exit);

        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().add(fileMenu);
        border.setTop(menuBar);

        stage.show();
    }

    private void setUpBoardUI(Pane root) {
        Board board = Board.getInstance();
        HBox board_root = new HBox();
        root.getChildren().add(board_root);
        board_root.setAlignment(Pos.TOP_LEFT);
        board_root.setStyle("-fx-background-color: grey");
        board_root.setPrefWidth(500);
        board_root.setPrefHeight(500);

        GridPane grid = new GridPane();
        grid.setMinSize(WINDOW_WIDTH, WINDOW_WIDTH);
        for(int i = 0; i < 15; i++) {
            ColumnConstraints column = new ColumnConstraints();
            column.setPercentWidth(100.0 / 15);
            grid.getColumnConstraints().add(column);

            RowConstraints row = new RowConstraints();
            row.setPercentHeight(100.0 / 15);
            grid.getRowConstraints().add(row);
        }

        grid.setGridLinesVisible(true);
        board_root.getChildren().add(grid);

        AnchorPane finish_zones = new AnchorPane();
        grid.add(finish_zones, 6, 6, 3, 3);
        finish_zones.setStyle("-fx-background-color: grey");


        HBox green_box = new HBox();
        green_box.setStyle("-fx-background-color: green");
        grid.add(green_box, 0, 0, 6, 6);
        addCircle(green_box);
        Polygon green_finish = new Polygon();
        green_finish.getPoints().addAll(new Double[]{
                0.0, 0.0,
                finish_zone_width / 2, finish_zone_width / 2,
                0.0, finish_zone_width,
        });
        green_finish.setFill(Color.GREEN);
        finish_zones.getChildren().add(green_finish);
        AnchorPane.setTopAnchor(green_finish, 0.0);
        AnchorPane.setLeftAnchor(green_finish, 0.0);


        HBox yellow_box = new HBox();
        yellow_box.setStyle("-fx-background-color: yellow");
        grid.add(yellow_box, 9, 0, 6, 6);
        addCircle(yellow_box);
        Polygon yellow_finish = new Polygon();
        yellow_finish.getPoints().addAll(new Double[]{
                0.0, 0.0,
                finish_zone_width / 2, finish_zone_width / 2,
                finish_zone_width, 0.0,
        });
        yellow_finish.setFill(Color.YELLOW);
        finish_zones.getChildren().add(yellow_finish);
        AnchorPane.setTopAnchor(yellow_finish, 0.0);
        AnchorPane.setLeftAnchor(yellow_finish, 0.0);

        HBox blue_box = new HBox();
        blue_box.setStyle("-fx-background-color: blue");
        grid.add(blue_box, 9, 9, 6, 6);
        addCircle(blue_box);
        Polygon blue_finish = new Polygon();
        blue_finish.getPoints().addAll(new Double[]{
                finish_zone_width, 0.0,
                finish_zone_width / 2, finish_zone_width / 2,
                finish_zone_width, finish_zone_width,
        });
        blue_finish.setFill(Color.BLUE);
        finish_zones.getChildren().add(blue_finish);
        AnchorPane.setTopAnchor(blue_finish, 0.0);
        AnchorPane.setLeftAnchor(blue_finish, finish_zone_width / 2);

        HBox red_box = new HBox();
        red_box.setStyle("-fx-background-color: red");
        grid.add(red_box, 0, 9, 6, 6);
        addCircle(red_box);
        Polygon red_finish = new Polygon();
        red_finish.getPoints().addAll(new Double[]{
                0.0, finish_zone_width,
                finish_zone_width / 2, finish_zone_width / 2,
                finish_zone_width, finish_zone_width,
        });
        red_finish.setFill(Color.RED);
        finish_zones.getChildren().add(red_finish);
        AnchorPane.setTopAnchor(red_finish, finish_zone_width / 2);
        AnchorPane.setLeftAnchor(red_finish, 0.0);

    }

    private void addCircle(HBox box) {
        int margin = 20;
        Circle circle = new Circle(0,0, ((WINDOW_WIDTH * (6.0 / 15.0)) - (2 * margin)) / 2);
        circle.setFill(Color.LIGHTGREY);
        HBox.setMargin(circle, new Insets(margin));
        box.getChildren().add(circle);
    }

    private void setUpControlsUI(Pane root) {
        HBox controls_root = new HBox();
        root.getChildren().add(controls_root);
        controls_root.setAlignment(Pos.TOP_LEFT);
        controls_root.setStyle("-fx-background-color: lightgray");
    }
}
