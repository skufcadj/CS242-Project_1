/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package theshapesareright;

import javafx.animation.RotateTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *
 * @author Yoel
 */
public class TheShapesAreRight extends Application {
    
    //Top level varialbes:
    int round = 1;
    
    @Override
    public void start(Stage primaryStage) {
        //Setup:
        
        Pane paneOne = new Pane();
        Pane paneTwo = new Pane();
        Pane paneThree = new Pane();
        Pane paneFour = new Pane();
 
        Scene sceneOne = new Scene(paneOne, 800, 600);
        Scene sceneTwo = new Scene(paneTwo, 800, 600);
        Scene sceneThree = new Scene(paneThree, 800, 600);
        Scene sceneFour = new Scene(paneFour, 800, 600);
        
        
        //-------------------------------------------------------------------------------------
        //Scene One Stuff:
        
        Image robImg = new Image("RobFace.png");
        
        
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
                primaryStage.setScene(sceneTwo);
                paneTwo.getChildren().add(robFaceOne); //Move the animated face and speech bubble to scene two!
                paneTwo.getChildren().add(robSpeech);
                robSpeech.setText("Time to select which types of colors and\n shapes you want to appear in the game!\nUse the dropdown lists to make\nyour choices. ");
               
            }
        });
        
        //---------------------------------------------------------------------------------------
        //Scene Two Stuff:
        Button scnThreeBtn = new Button();
        scnThreeBtn.relocate(400,400);
        paneTwo.getChildren().add(scnThreeBtn);
        scnThreeBtn.setText("Next");
        scnThreeBtn.setOnAction(new EventHandler<ActionEvent>() { //We start the game!
            @Override
            public void handle(ActionEvent event){
                primaryStage.setScene(sceneThree);
                paneThree.getChildren().add(robFaceOne); //Move the animated face and speech bubble to scene two!
                paneThree.getChildren().add(robSpeech);
                robSpeech.setText("You have SHAPES GO HERE.\nPLease Click and Drag to guess their order!");
            }
        });
        //---------------------------------------------------------------------------------------
        //Scene Three Stuff:
        
        //Mostly TBI
        Text roundTxt = new Text("Round: "+round);
        paneThree.getChildren().add(roundTxt);
        roundTxt.relocate(600, 10);
        
        Button guessBtn = new Button();
        paneThree.getChildren().add(guessBtn);
        guessBtn.relocate(600,400);
        guessBtn.setText("Guess this Order");
        scnThreeBtn.setOnAction(new EventHandler<ActionEvent>() { //We start the game!
            @Override
            public void handle(ActionEvent event){
                if(round<3){ //Rounds one and two
                    round++;
                    roundTxt.setText("Round: "+round);
                    //Reset Thnags and play again. DO IT HERE!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
                }else{ //round three
                    //The last round has finished. That's bretty nifty.
                    primaryStage.setScene(sceneFour);
                    paneThree.getChildren().add(robFaceOne); //Move the animated face and speech bubble to scene two!
                    paneThree.getChildren().add(robSpeech);
                    robSpeech.setText("You scored SCORE SCORE and SCORE on rounds One, Two, and Three.\nThe highest Score among these was SCORE, which is your final score!\nPlay again?");

                }
            }
        });
        
        
        //---------------------------------------------------------------------------------------
        //Scene Four Stuff:
        Button resetBtn = new Button("RESET");
        
        
        
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
