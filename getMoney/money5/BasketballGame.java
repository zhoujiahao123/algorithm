package algorithm.getMoney.money5;

import java.util.Scanner;

public class BasketballGame {
    private String firstTeam;
    private String secondTeam;
    private int scoreOfFirstTeam;
    private int scoreOfSecondTeam;
    private String status;

    public BasketballGame(String firstTeam,String secondTeam){
        this.firstTeam = firstTeam;
        this.secondTeam = secondTeam;
        scoreOfSecondTeam = 0;
        scoreOfFirstTeam = 0;
        status = "process";
    }

    public void recordPoint(String name,int score){
        if(name.equals(firstTeam)){
            // If it is to give a team extra points
            scoreOfFirstTeam+=score;
        }else{
            // If it is for the second team to add points
            scoreOfSecondTeam+=score;
        }
    }
    public void changeTheStatus(){
        status = "finished";
    }
    public int getTheScoreByName(String name){
        if(name.equals(firstTeam)){
            return scoreOfFirstTeam;
        }else{
            return scoreOfSecondTeam;
        }
    }
    public String getStatus(){
        return status;
    }
    public String currentlyWinner(){
        if(scoreOfFirstTeam > scoreOfSecondTeam){
            return firstTeam;
        }else{
            return secondTeam;
        }
    }

    public static void main(String[] args) {
        BasketballGame game1 = new BasketballGame("team1","team2");// Generate a match
        System.out.println("Current game status£º"+game1.getStatus());
        Scanner input = new Scanner(System.in);
        while (true){
            System.out.println("Please enter the scoring team and score£º");
            String team = input.nextLine();
            int score = input.nextInt();
            game1.recordPoint(team,score);
            System.out.println("The team with the highest score in the current match£º"+game1.currentlyWinner());
            System.out.println("Team 1 score£º"+game1.getTheScoreByName("team1"));
            System.out.println("Team 2 score£º"+game1.getTheScoreByName("team2"));
            System.out.println("Whether the game is over£º");
            input.nextLine();
            String over = input.nextLine();
            if("yes".equals(over)){
                break;
            }
        }
        game1.changeTheStatus();
        System.out.println("Current game status£º"+game1.getStatus());
        System.out.println("Final winner£º"+game1.currentlyWinner());
    }
}
