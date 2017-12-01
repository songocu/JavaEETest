package initialtest;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class TestFactory {
public static void main(String[] args) {
	JPanel pane = new JPanel();
	pane.setBorder(BorderFactory.createLineBorder(Color.black));
}
}
