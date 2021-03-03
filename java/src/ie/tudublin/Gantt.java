package ie.tudublin;

import java.util.ArrayList;

import processing.core.PApplet;
import processing.data.TableRow;
import processing.data.Table;

public class Gantt extends PApplet {

	ArrayList<Task> tasks = new ArrayList<Task>();

	public void settings() {
		size(800, 600);
	}

	public void loadTasks() {
		Table table = loadTable("tasks.csv", "header");
		for (TableRow row : table.rows()) {
			Task t = new Task(row);
			tasks.add(t);
		}
	}

	public void printTasks() {
		for (Task t : tasks) {
			println(t);
		}
	}

	public void displayTasks() {
		float border = 0.1f * width;
		textAlign(CENTER, CENTER);

		for (int i = 1; i <= 30; i++) {
			float x = map(i, 1, 30, border, width - border);
			float y = map(i, 1, 30, border, height - border);

			stroke(0, 0, 255);
			line(x, border, x, height - border);
			fill(255);
			text(i, x, border / 2);
			text(i, border / 2, y);
		}

	}

	public void mousePressed() {
		println("Mouse pressed");
	}

	public void mouseDragged() {
		println("Mouse dragged");
	}

	public void setup() {
		colorMode(RGB);
		loadTasks();
		printTasks();
	}

	public void draw() {
		background(0);
		displayTasks();
	}
}
