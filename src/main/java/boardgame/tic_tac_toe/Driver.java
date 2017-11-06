package boardgame.tic_tac_toe;

import boardgame.tic_tac_toe.core.ai.BaseAI;
import boardgame.tic_tac_toe.core.ai.PlayerInput;
import boardgame.tic_tac_toe.core.ai.RandomAI;
import boardgame.tic_tac_toe.core.ai.SequentialAI;
import boardgame.tic_tac_toe.core.TextSession;

import java.io.*;

public class Driver {
	public static final BaseAI PLAYER = new PlayerInput();
	public static final BaseAI RANDOM = new RandomAI();
	public static final BaseAI SEQUENTIAL = new SequentialAI();

	public static final String SEPERATOR = "====================================================================================\n";

	public static void main(String[] args) {
		TextSession session;

		PrintStream originalOut = System.out;

		try {
			System.setOut(new PrintStream(new FileOutputStream("out.txt")));
		} catch (FileNotFoundException ex) {
			System.setOut(originalOut);
		}

		printHeader("Random vs Random");
		for (int i = 0; i < 10; i++) {
			session = new TextSession(RANDOM, RANDOM);
			session.run();
			System.out.println(SEPERATOR);
		}

		printSpace();
		printHeader("Random vs Sequential");
		for (int i = 0; i < 10; i++) {
			session = new TextSession(RANDOM, SEQUENTIAL);
			session.run();
			System.out.println(SEPERATOR);
		}

		printSpace();
		printHeader("Sequential vs Random");
		for (int i = 0; i < 10; i++) {
			session = new TextSession(SEQUENTIAL, RANDOM);
			session.run();
			System.out.println(SEPERATOR);
		}

		printSpace();
		printHeader("Sequential vs Sequential");
		for (int i = 0; i < 10; i++) {
			session = new TextSession(SEQUENTIAL, SEQUENTIAL);
			session.run();
			System.out.println(SEPERATOR);
		}

		System.setOut(originalOut);

		printSpace();
		printHeader("Player vs Random");
		session = new TextSession(PLAYER, RANDOM);
		session.run();

		printSpace();
		printHeader("Random vs Player");
		session = new TextSession(RANDOM, PLAYER);
		session.run();

		printSpace();
		printHeader("Player vs Sequential");
		session = new TextSession(PLAYER, SEQUENTIAL);
		session.run();

		printSpace();
		printHeader("Sequential vs Player");
		session = new TextSession(SEQUENTIAL, PLAYER);
		session.run();

		printSpace();
		printHeader("Player vs Player");
		session = new TextSession(PLAYER, PLAYER);
		session.run();
	}

	public static void printHeader(String header) {
		System.out.println(SEPERATOR + header + "\n" + SEPERATOR);
	}

	public static void printSpace() {
		System.out.println("\n\n\n\n\n");
	}
}
