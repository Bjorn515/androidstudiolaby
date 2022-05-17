package com.umg.trains;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.umg.trains.trains.ITrainAdapter;
import com.umg.trains.trains.Train;
import com.umg.trains.trains.TrainAdapter;
import com.umg.trains.trains.TrainStore;

public class ChooseTrain extends AppCompatActivity {

    private final ITrainAdapter actions = train -> {
        TrainStore.setPlayerTrain(train);
        Intent intent = new Intent(getApplicationContext(), GameActivity.class);
        System.out.println("call");
        startActivity(intent);
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_train);

        TrainAdapter adapter = new TrainAdapter(this, TrainStore.trains, actions);
        ListView trainsListView = (ListView) findViewById(R.id.trainsList);
        trainsListView.setAdapter(adapter);
    }


}