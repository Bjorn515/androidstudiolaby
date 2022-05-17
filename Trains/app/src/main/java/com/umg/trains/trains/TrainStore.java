package com.umg.trains.trains;

import com.umg.trains.R;

import java.util.ArrayList;
import java.util.Arrays;

public class TrainStore {

    private static Train playerTrain;

    public static ArrayList<Train> trains = new ArrayList<>(Arrays.asList(
            new Train(100, 100, 1, 20, 2, R.drawable.train1),
            new Train(150, 50, 2, 18, 1, R.drawable.train2),
            new Train(80, 50, 3, 15, 3, R.drawable.train3)
    ));

    public static Train getPlayerTrain() {
        return playerTrain;
    }

    public static void setPlayerTrain(Train train) {
        playerTrain = train;
    }
}
