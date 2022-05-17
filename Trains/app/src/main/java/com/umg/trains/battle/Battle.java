package com.umg.trains.battle;

import android.os.CountDownTimer;

public class Battle {
    private final int playerId = 0;
    private final int enemyId = 1;
    private final Player[] players = new Player[2];
    private boolean gamOver;
    private int winner;
    private CountDownTimer timer;

    public Battle(Player player, Player enemy) {
        players[playerId] = player;
        players[enemyId] = enemy;
        gamOver = false;
    }

    public void startGame() {
        enemyAI();
    }

    public void stopGame() {
        timer.cancel();
        System.out.println(winner);
    }

    private void enemyAI() {
        int attackSpeed = players[enemyId].getTrain().getAttackSpeed();
        timer = new CountDownTimer(10000, 700 / attackSpeed) {
            @Override
            public void onTick(long l) {
                loadProgress(enemyId);
            }

            @Override
            public void onFinish() {
                if (!gamOver)
                    enemyAI();
            }
        }.start();
    }

    public void loadProgress(int player) {
        players[player].updateProgress(players[player].getTrain().getDamage());
        if (players[player].isLoaded()) {
            shoot(player);
            players[player].resetProgress();
        }
    }

    public void shoot(int attacker) {
        int victim = attacker == playerId ? enemyId : playerId;
        boolean playerDead = players[attacker].attack(players[victim]);

        if (playerDead) {
            winner = attacker;
            gamOver = true;
            stopGame();
        }
    }

}
