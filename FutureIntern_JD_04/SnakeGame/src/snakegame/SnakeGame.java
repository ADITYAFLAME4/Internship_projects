package snakegame;
import javax.swing.*;

public class SnakeGame extends JFrame{

    SnakeGame() {
        super("Welcome to Snake Game");

        add(new RenderScreen());

        pack();

        setLocationRelativeTo(null);
        setResizable(false);
//        setVisible(true);
    }

    public static void main(String[] args) {

        new SnakeGame().setVisible(true);

        // Scanner scanner = new Scanner(System.in);

        

        // scanner.close();
    }
   
    
}
