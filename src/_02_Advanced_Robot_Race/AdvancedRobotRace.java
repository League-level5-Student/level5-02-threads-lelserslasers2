package _02_Advanced_Robot_Race;

import java.util.Random;

import org.jointheleague.graphical.robot.Robot;

public class AdvancedRobotRace {
	// Re-do the robot race recipe from level 3 module 0. 
	// This time, use threads to make all of the robots go at the same time.
	
	static int winner = 0;
	
	public static void main(String[] args) {
	
		Thread[] threads = new Thread[5];
		Robot[] robots = new Robot[5];
		int[] pos = {200, 400, 600, 800, 1000};
	
		for (int i = 0; i < threads.length; i++) {
			int j = i;
			robots[i] = new Robot();
			threads[i] = new Thread(()->moveRobos(robots[j], pos[j], j));
			threads[i].start();
		}
		while (winner == 0) {
			System.out.println(" ");
		}
		System.out.println("There has been a winner, and it is number:");
		System.out.print(winner); System.out.println("!!!");
	}
	
	static void moveRobos(Robot robo, int x, int num) {
		
		robo.moveTo(x, 800);
		boolean notDon = true;
		while (notDon) {
			int movement = new Random().nextInt(100);
			robo.move(movement);
			
			if (robo.getY() < 200) {
				winner = num;
				notDon = false;
			}
		}
		
	}
}
