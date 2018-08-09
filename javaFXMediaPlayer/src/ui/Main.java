////changes made in se lab

package ui;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.StackPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.File;

public class Main extends Application //implements Runnable
{
    Scene scene;
    BorderPane layout;
    File videoFile;
    Media video;
    MediaPlayer videoPlayer;
    MediaView videoView;
    //////////////////////////////////////////
    int seLab;
    Button togglePlayButton;
    Boolean ispaused = false;

    @Override
    public void start(Stage window)
    {
        double w = window.getWidth();
        double h = window.getHeight();

        //Buttons
        togglePlayButton = new Button("play/pause");
        //togglePlayButton.setAlignment(Pos.BOTTOM_CENTER);
        togglePlayButton.setOnAction(
                e ->
                {
                    if(ispaused)
                    {
                        videoPlayer.play();
                        ispaused = false;
                    }

                    else
                    {
                        videoPlayer.pause();
                        ispaused = true;
                    }
                }
        );

        //video Source and video view Setup
        videoFile = new File("HD Epic Sax Gandalf.mp4");
        video = new Media(videoFile.toURI().toString());
        videoPlayer = new MediaPlayer(video);
        videoView = new MediaView(videoPlayer);

        layout = new BorderPane();
        //layout.setAlignment(Pos.BOTTOM_CENTER);
        try
        {
            //layout.getChildren().addAll(videoView,togglePlayButton);
            layout.setCenter(videoView);
            layout.setBottom(togglePlayButton);
        }

        catch(Exception e)
        {
            e.printStackTrace();
        }

        scene = new Scene(layout,video.getWidth(),video.getHeight());
        window.setScene(scene);
        window.setTitle(video.getSource());
        window.setMinWidth(300);
        window.setMinHeight(200);
        window.show();

        videoPlayer.play();

    }


    public static void main(String args[])
    {
        launch(args);
    }
}
