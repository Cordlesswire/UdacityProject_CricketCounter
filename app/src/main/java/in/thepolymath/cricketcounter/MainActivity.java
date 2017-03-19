package in.thepolymath.cricketcounter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * Global variable declarations for the program
     */
    int runs = 0;
    int wickets = 0;
    int overs = 0;
    int balls = 0;
    int check = 0; //This will help us end the game once either the overs or the wickets are over.
    String text1 = "End of strike for Batting team. \nNote the score and tap Swap Strike to shift strikes.";
    String text2 = " ";
    String x = "Team A";
    String y = "Team B";

    /**
     * method for swapping team names and resetting the values
     */
    public void swapAndReset(View view) {
        String z = x;
        x = y;
        y = z;
        swapTeamA(x);
        swapTeamB(y);
        runs = 0;
        wickets = 0;
        overs = 0;
        balls = 0;
        check = 0;
        displayWickets(wickets);
        displayRuns(runs);
        displayOvers(overs);
        displayBalls(balls);
        strikeEnd(text2);
    }

    /**
     * method for changing the over after the if condition of the balls is reached i.e. Balls > 5
     */
    public void changeOver() {
        overs = overs + 1;
        displayOvers(overs);
        if (overs >= 50 && balls >= 0) {
            check = 1;
            displayOvers(50);
            displayBalls(0);
            strikeEnd(text1);
        }
    }

    /**
     * method to increase balls number by 1
     */
    public void noRuns(View view) {
        if (check == 0) {
            incBalls();
        }
    }

    /**
     * method to increase balls number by 1
     */
    public void incBalls() {
        if (check == 0) {
            balls = balls + 1;
        }
        if (balls > 5) {
            changeOver();
            balls = 0;
        }
        displayBalls(balls);
    }

    /**
     * method to add 6 to the runs total
     */
    public void six(View view) {
        if (check == 0) {
            runs = runs + 6;
        }
        incBalls();
        displayRuns(runs);
    }

    /**
     * method to add 4 to the runs total
     */
    public void four(View view) {
        if (check == 0) {
            runs = runs + 4;
        }
        incBalls();
        displayRuns(runs);
    }

    /**
     * method to add 1 to the runs total
     */
    public void one(View view) {
        if (check == 0) {
            runs = runs + 1;
        }
        incBalls();
        displayRuns(runs);
    }

    /**
     * method to add 2 to the runs total
     */
    public void two(View view) {
        if (check == 0) {
            runs = runs + 2;
        }
        incBalls();
        displayRuns(runs);
    }

    /**
     * method to add 3 to the runs total
     */
    public void three(View view) {
        if (check == 0) {
            runs = runs + 2;
        }
        incBalls();
        displayRuns(runs);
    }

    /**
     * method to add extra runs (wide or no-ball) to the runs total without increasing the number of balls
     */
    public void extras(View view) {
        if (check == 0) {
            runs = runs + 1;
        }
        displayRuns(runs);
    }

    /**
     * method to declare a batsman as out and add 1 to the wicket count
     */
    public void out(View view) {
        if (check == 0) {
            wickets = wickets + 1;
            incBalls();
        }
        displayWickets(wickets);
        if (wickets >= 10) {
            check = 1;
            strikeEnd(text1);
            displayWickets(10);
        }
    }


    public void displayWickets(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_a_wickets);
        scoreView.setText(String.valueOf(score));
    }

    public void displayOvers(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_b_overs);
        String over = String.format("%02d", score);
        scoreView.setText(String.valueOf(over));
    }

    public void displayRuns(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_a_runs);
        scoreView.setText(String.valueOf(score));
    }

    public void displayBalls(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_b_balls);
        scoreView.setText(String.valueOf(score));
    }

    public void strikeEnd(String text) {
        TextView scoreView = (TextView) findViewById(R.id.strikenotice);
        scoreView.setText(String.valueOf(text));
    }

    public void swapTeamA(String text) {
        TextView scoreView = (TextView) findViewById(R.id.teamNameA);
        scoreView.setText(String.valueOf(text));
    }

    public void swapTeamB(String text) {
        TextView scoreView = (TextView) findViewById(R.id.teamNameB);
        scoreView.setText(String.valueOf(text));
    }

}
