package _01_Olympic_Rings;

import java.awt.Color;

import org.jointheleague.graphical.robot.Robot;

public class OlympicRings_Threaded {
	// Make A Program that uses Threads and robots to draw the Olympic rings. One robot should draw one ring simultaneously with the other 4 robots.
	public static void main(String[] args) {
		
		Thread[] threads = new Thread[5];
		Robot[] robots = new Robot[5];
		int[] pos = {200, 200, 245, 155, 290, 200, 335, 155, 380,200};
 		
		for (int i = 0; i < threads.length; i++) {
			int j = i;
			robots[i] = new Robot(400, 400);
			Color col = Color.blue;
			if (i == 1) {
				col = Color.yellow;
			}
			else if (i == 2) {
				col = Color.black;
			}
			else if (i == 3) {
				col = Color.green;
			}
			else if (i == 4) {
				col = Color.red;
			}
			
			robots[i].setPenColor(col);
 			threads[i] = new Thread(()->moveRobos(robots[j], pos[j*2], pos[j*2 + 1]));
			threads[i].start();
		}
		
	}
	
	static void moveRobos(Robot robo, int x, int y) {
		
		robo.moveTo(x, y);
		robo.turn(180);
		robo.penDown();
		
		for (int i = 0; i < 360; i++) {
			robo.move(1);
			robo.turn(1);
		}
		robo.penUp();
		robo.moveTo(90000, 90000);
	}

}

