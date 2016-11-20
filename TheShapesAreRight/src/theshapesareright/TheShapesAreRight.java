/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package theshapesareright;

import java.util.*;
import javafx.animation.RotateTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;





/**
 *
 * @author Yoel
 */
public class TheShapesAreRight extends Application {
    
    //Top level variables:
    int round = 1;
    List<String> shapes = new ArrayList<String>(); //The list of possible shapes
    List<String> colors = new ArrayList<String>(); //The list of possible shapes
    List<Shape> orderedList;
    List<Shape> randomList;
    ShapeList shapeList;
    List<Shape> userGuessList = new LinkedList<Shape>();
    List<Shape> sortedShapes;
    
    @Override
    public void start(Stage primaryStage) {
        //Setup, top level stuff, and things that need to be declared before anything else:
        shapes.add("Square");
        shapes.add("Triangle");
        shapes.add("Diamond");
        shapes.add("Circle");
        
        colors.add("Red");
        colors.add("Blue");
        colors.add("Green");
        colors.add("Yellow");

        
        ObservableList<String> shapesObs = FXCollections.observableList(shapes);
        ObservableList<String> colorsObs = FXCollections.observableList(colors);
        
        Pane paneOne = new Pane();
        Pane paneTwo = new Pane();
        Pane paneThree = new Pane();
        Pane paneFour = new Pane();
 
        Scene sceneOne = new Scene(paneOne, 800, 600);
        Scene sceneTwo = new Scene(paneTwo, 800, 600);
        Scene sceneThree = new Scene(paneThree, 800, 600);
        Scene sceneFour = new Scene(paneFour, 800, 600);
        
        ListView<Shape> inputListView = new ListView<Shape>(); //We declare this up here because it's going to be accessed by scene 2 items.
        paneThree.getChildren().add(inputListView);
        
        //-------------------------------------------------------------------------------------
        //Scene One Stuff:
        
        Image robImg = new Image("RobFace.png");
        
        
        Rectangle robBacking = new Rectangle(600,120);
        robBacking.setFill(Color.GOLD);
        robBacking.setStroke(Color.BLACK);
        robBacking.relocate(100,90);
        paneOne.getChildren().add(robBacking);
        
        ImageView robFaceOne = new ImageView(robImg);
        paneOne.getChildren().add(robFaceOne);
        robFaceOne.setX(100);
        robFaceOne.setY(100);
        robFaceOne.setFitHeight(100);
        robFaceOne.setFitWidth(100);
        RotateTransition robOneTilt = new RotateTransition();
        robOneTilt.setNode(robFaceOne);
        robOneTilt.setFromAngle(-30);
        robOneTilt.setToAngle(30);
        robOneTilt.setDuration(new Duration(1000));
        robOneTilt.setAutoReverse(true);
        robOneTilt.setCycleCount(Timeline.INDEFINITE);
        robOneTilt.play();
        
        
        ImageView robSliderTilt = new ImageView(robImg);
        robSliderTilt.setOpacity(.2);
        robSliderTilt.setRotate(-40);
        paneOne.getChildren().add(robSliderTilt);
        robSliderTilt.setX(200);
        robSliderTilt.setY(100);
        
        Text robSpeech = new Text("Hi, I'm Rob Schneider, and this is 'The Shapes are Right!'\nPlease select the number of shapes you want to play with \nby dragging the slider.\nThe Rob Slider.");
        paneOne.getChildren().add(robSpeech);
        robSpeech.relocate(200, 100);
        robSpeech.setStyle("-fx-font: 20 Impact;");
        
        Text shapeNum = new Text("3 Shapes");
        paneOne.getChildren().add(shapeNum);
        shapeNum.relocate(500,300);
        
        Slider robSlider = new Slider();
        paneOne.getChildren().add(robSlider);
        robSlider.relocate(350,300);
        robSlider.setMin(3);
        robSlider.setMax(11);
        robSlider.setMinorTickCount(0);
        robSlider.setMajorTickUnit(2);
        robSlider.setShowTickMarks(true);
        robSlider.setShowTickLabels(false);
        robSlider.setSnapToTicks(true);
        

    
        robSlider.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> ov,
                Number old_val, Number new_val) {
                    if((int)robSlider.getValue()%2 != 0){
                        shapeNum.setText((int)robSlider.getValue()+" Shapes");
                        robSliderTilt.setRotate((10*robSlider.getValue())-70);
                    }
            }
        });
        
        Button scnTwoBtn = new Button();
        paneOne.getChildren().add(scnTwoBtn);
        scnTwoBtn.setText("Next");
        scnTwoBtn.relocate(400,400);
        scnTwoBtn.setOnAction(new EventHandler<ActionEvent>() { //We start the game!
            @Override
            public void handle(ActionEvent event){
                paneTwo.getChildren().add(robBacking);
                primaryStage.setScene(sceneTwo);
                paneTwo.getChildren().add(robFaceOne); //Move the animated face and speech bubble to scene two!
                paneTwo.getChildren().add(robSpeech);
                robSpeech.setText("Time to select which types of colors and\n shapes you want to appear in the game!\nUse the dropdown lists to make\nyour choices. ");
               
            }
        });
        
        //---------------------------------------------------------------------------------------
        //Scene Two Stuff:
        ListView<String> shapesView = new ListView<String>();
        shapesView.setItems(shapesObs);
        shapesView.setMinWidth(100);
        shapesView.setPrefHeight(120);
        paneTwo.getChildren().add(shapesView);
        shapesView.relocate(100,300);
        shapesView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        
        ListView<String> colorsView = new ListView<String>();
        colorsView.setItems(colorsObs);
        colorsView.setMinWidth(100);
        colorsView.setPrefHeight(120);
        paneTwo.getChildren().add(colorsView);
        colorsView.relocate(500,300);
        colorsView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        

        Button scnThreeBtn = new Button();
        scnThreeBtn.relocate(400,400);
        paneTwo.getChildren().add(scnThreeBtn);
        scnThreeBtn.setText("Next");
        scnThreeBtn.setOnAction(new EventHandler<ActionEvent>() { //Go the scene three
            @Override
            public void handle(ActionEvent event){
                shapeList = new ShapeList((int)robSlider.getValue(), shapesView.getSelectionModel().getSelectedItems(), colorsView.getSelectionModel().getSelectedItems());
                orderedList = shapeList.getPermutation();
                randomList = shapeList.getCombination();
                paneThree.getChildren().add(robBacking);
                primaryStage.setScene(sceneThree);
                paneThree.getChildren().add(robFaceOne); //Move the animated face and speech bubble to scene three!
                paneThree.getChildren().add(robSpeech);
                robSpeech.setText("Your shapes are shown in the left coumn.\nPLease Click items in order to build your 'guess' list!\nWhen you're done, click the 'GUESS' button.");
                sortedShapes = shapeList.getPermutation();
                inputListView.setItems(FXCollections.observableArrayList(sortedShapes));
            }
        });
        //---------------------------------------------------------------------------------------
        //Scene Three Stuff:
        Text userGuessText = new Text();
        paneThree.getChildren().add(userGuessText);
        userGuessText.relocate(350,220);
        
        inputListView.setMinWidth(100);
        inputListView.setPrefHeight(330);
        inputListView.relocate(100,250);
        inputListView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        //inputListView.setEditable(true);
        inputListView.getSelectionModel().selectedItemProperty().addListener(
                new ChangeListener<Shape>(){
                    public void changed(ObservableValue<? extends Shape> observableValue, Shape oldValue, Shape newValue){
                        userGuessList.add(newValue); //NOT THE PROBLEM
                        System.out.println(newValue.toString()); //debug line NOT THE PROBLEM
                        userGuessText.setText(userGuessText.getText()+"\n"+newValue.toString()); //add to textfield on right NOT THE PROBLEM
                        //inputListView.getItems().remove(inputListView.getSelectionModel().getSelectedItem()); //Is this recursive?
                        System.out.println(inputListView.getItems().size());
                        //inputListView.getSelectionModel().clearSelection();
                        sortedShapes.remove(newValue);
                        inputListView.setItems(FXCollections.observableArrayList(sortedShapes));
                    }
        });
        
        Text roundTxt = new Text("Round: "+round);
        paneThree.getChildren().add(roundTxt);
        roundTxt.relocate(600, 10);
        
        Button guessBtn = new Button();
        paneThree.getChildren().add(guessBtn);
        guessBtn.relocate(600,400);
        guessBtn.setText("Guess this Order");
        guessBtn.setOnAction(new EventHandler<ActionEvent>() { //Guess an inputted order
            @Override
            public void handle(ActionEvent event){
                if(round<3){ //Rounds one and two
                    round++;
                    roundTxt.setText("Round: "+round);
                    //Reset Thnags and play again. DO IT HERE!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
                }else{ //round three
                    //The last round has finished. That's bretty nifty.
                    paneFour.getChildren().add(robBacking);
                    primaryStage.setScene(sceneFour);
                    paneFour.getChildren().add(robFaceOne); //Move the animated face and speech bubble to scene four!
                    paneFour.getChildren().add(robSpeech);
                    robSpeech.setText("You scored SCORE SCORE and SCORE on rounds One, Two, and Three.\nThe highest Score among these was SCORE, which is your final score!\nPlay again?");

                }
            }
        });
        
        
        //---------------------------------------------------------------------------------------
        //Scene Four Stuff:
        Button resetBtn = new Button("RESET");
        paneFour.getChildren().add(resetBtn);
        resetBtn.relocate(400,500);
        resetBtn.setOnAction(new EventHandler<ActionEvent>() { //We restart the game!
            @Override
            public void handle(ActionEvent event){
                userGuessList.clear();
                paneOne.getChildren().add(robBacking);
                primaryStage.setScene(sceneOne);
                round = 1;
                roundTxt.setText("Round: "+round);
                paneOne.getChildren().add(robFaceOne); //Move the animated face and speech bubble back to scene one!
                paneOne.getChildren().add(robSpeech);
                robSpeech.setText("Hi, I'm Rob Schneider, and this is 'The Shapes are Right!'\nPlease select the number of shapes you want to play with \nby dragging the slider.\nThe Rob Slider.");
            }
        });
        
        
        
        
        primaryStage.setTitle("Rob Scleider's Guessing Game");
        primaryStage.setScene(sceneOne);
        primaryStage.show();
       
        
        
    }


    public void sceneTwo() {
        
        
    }
    
    public void sceneThree(){
        
    }
    
    public void sceneFour(){
        
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
