package de.iisys.drossner.algodat.sort.visual;

import javafx.application.Application;
import javafx.concurrent.Task;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.util.Random;


public class Main extends Application{

    public static final int XVAL = 1600;
    public static final int YVAL = 600;
    public static final int SCALE = 3;

    private int[] arr;
    private Canvas canvas;

    @Override
    public void start(Stage primaryStage) throws Exception {
        //Sorter sorter = new VizBubbleSorter();
       // Sorter sorter = new VizQuickSorter();
        Sorter sorter = new VizShellSorter();

        Pane root = new Pane();
        canvas = new Canvas(XVAL, YVAL);
        root.getChildren().addAll(canvas);

        initArr();

        primaryStage.setScene(new Scene(root));
        primaryStage.setTitle("SortViz");
        primaryStage.show();
        primaryStage.requestFocus();


        Task<Void> task = new Task<Void>() {
            @Override
            protected Void call() throws Exception {
                sorter.sort(arr, this::updateProgress);
                return null;
            }
        };
        task.setOnSucceeded(event -> repaint());
        task.progressProperty().addListener((observable, oldValue, newValue) -> repaint());
        new Thread(task).start();
    }

    private void initArr() {
        //generate Random int arr
        this.arr = new Random().ints(XVAL/SCALE, 0, YVAL/SCALE).toArray();
        repaint();
    }

    void repaint() {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.clearRect(0,0, XVAL, YVAL);
        for(int i = 0; i < arr.length; i++){
            gc.fillRect(i*SCALE, (YVAL-arr[i] * SCALE), SCALE, SCALE);
        }
    }
}
