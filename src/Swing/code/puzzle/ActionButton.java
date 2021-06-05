package Swing.code.puzzle;

import java.awt.event.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import javax.swing.*;

class ActionButton extends MouseAdapter {

	private JLabel[] box;
	private int x, y, blankY = 200, blankX = 200;
	private int []locX = { 0, 100, 200, 0, 100, 200, 0, 100, 200 }, locY = { 0, 0, 0, 100, 100, 100, 200, 200, 200 };
	private int move = 0;
	// refresh Button
	private JLabel refresh;
	private JLabel moveLabel;
	private JLabel winLabel;

	public void addButton(JLabel[] box) {
		this.box = new JLabel[box.length];
		for (int i = 0; i < this.box.length; i++) {
			this.box[i] = new JLabel();
			this.box[i] = box[i];
			this.box[i].addMouseListener(this);
		}
	}

	public void addRefreshButton(JLabel btn) {
		refresh = btn;
		refresh.setName("Refresh");
		refresh.addMouseListener(this);
	}

	public void addMoveLabel(JLabel label) {
		moveLabel = label;
	}

	public void addWinLabel(JLabel label) {
		winLabel = label;
	}

	public void mousePressed(MouseEvent e) {

		Object obj = e.getSource();
		JLabel b = (JLabel) obj;
		int tempX , tempY;
		int index = 0;

		switch (b.getName()) {
		case "b0":
			index = 0;
			break;
		case "b1":
			index = 1;
			break;
		case "b2":
			index = 2;
			break;
		case "b3":
			index = 3;
			break;
		case "b4":
			index = 4;
			break;
		case "b5":
			index = 5;
			break;
		case "b6":
			index = 6;
			break;
		case "b7":
			index = 7;
			break;
		}
		x =  box[index].getX();
		y =  box[index].getY();

		tempX = blankX - x;
		tempY = blankY - y;
		if (((tempX == -100 || tempX == 100) && tempY == 0) || ((tempY == -100 || tempY == 100) && tempX == 0)) {
			box[index].setLocation(blankX, blankY);
			blankX = x;
			blankY = y;
			//
			move++;
			moveLabel.setText("Total Move : " + move);
		}
		//
		if (b.getName().equals("Refresh")) {
			System.out.println("Refresh Button clicked");
			refresh();
		} // restart end
		//
		win();
	}// mousePressed method end

	public void refresh() {
		move = 0;
		moveLabel.setText("Total Move : " + move);

		// Generate random numbers
		List<Integer> list = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8);
		Collections.shuffle(list);

		int blankIndex = list.get(list.size() - 1);   //  last data for blank index
		for (int i = 0; i < box.length; i++) {
			box[i].setLocation(locX[list.get(i)], locY[list.get(i)]);
		}
		blankX = locX[blankIndex];
		blankY = locY[blankIndex];
	}
	private void win() {
        int full = 0;
        for (int i = 0; i < locX.length - 1; i++) {
            if (box[i].getX() == locX[i] && box[i].getY() == locY[i]) {
                {
                    full += 1;
                }
            }
            if (full == 8) {
                winLabel.setText("Congratulations! You won.");
                box[8].setVisible(true);
                blankX = blankY = -1;
            } else {
                winLabel.setText("");
                box[8].setVisible(false);

            }
        }
    }
}