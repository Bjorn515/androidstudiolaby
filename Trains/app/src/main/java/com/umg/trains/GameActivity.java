package com.umg.trains;

import android.os.Bundle;
import android.os.Handler;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.umg.trains.battle.Battle;
import com.umg.trains.battle.Player;
import com.umg.trains.trains.Train;
import com.umg.trains.trains.TrainStore;
import com.umg.trains.utils.Utils;

public class GameActivity extends AppCompatActivity {

    Battle battle;
    final Handler handler = new Handler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        Train playerTrain = TrainStore.getPlayerTrain();
        Train enemyTrain = TrainStore.trains.get(Utils.getRandomNumber(0, TrainStore.trains.size() - 1));

        ImageView enemyTrainImage = findViewById(R.id.enemyTrain);
        enemyTrainImage.setImageResource(enemyTrain.getImage());

        ImageView playerTrainImage = findViewById(R.id.playerTrain);
        playerTrainImage.setImageResource(playerTrain.getImage());

        ProgressBar playerHPBar = findViewById(R.id.playerHPBar);
        ProgressBar playerArmour = findViewById(R.id.playerArmourBar);
        ProgressBar playerLoading = findViewById(R.id.playerLoading);

        ProgressBar enemyHPBar = findViewById(R.id.enemyHPBar);
        ProgressBar enemyLoading = findViewById(R.id.enemyLoading);
        ProgressBar enemyArmour = findViewById(R.id.enemyArmourBar);

        Player player = new Player(playerHPBar, playerArmour, playerLoading, playerTrain);
        Player enemy = new Player(enemyHPBar, enemyArmour, enemyLoading, enemyTrain);

        battle = new Battle(player, enemy);

        Button shootButton = findViewById(R.id.shootButton);
        battle.startGame();

        shootButton.setOnClickListener(view -> {
            battle.loadProgress(0);
            final Runnable r = new Runnable() {
                public void run() {
                    handler.postDelayed(this, 1000);
                    Toast.makeText(getApplicationContext(), "Przeciwnik trafiony", Toast.LENGTH_SHORT).show();
                }
            };

        });

    }


}