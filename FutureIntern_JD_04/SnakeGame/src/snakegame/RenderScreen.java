package snakegame;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class RenderScreen extends JPanel implements ActionListener {
    
    private Image apple;
    private Image sBody;
    private Image sHead;
    
    private final int fullBodySize = 2500;
    private final int pixel = 10;
    private final int random_Position = 29;

    private final int x[] = new int [fullBodySize];
    private final int y[] = new int [fullBodySize];
    
    private boolean leftDirection = false;
    private boolean rightDirection = true;
    private boolean upDirection = false;
    private boolean downDirection = false;
    
    private boolean inGame = true;
    private int score = 0;
    private int top_Scoree = 395;
    
    private int apple_x;
    private int apple_y;

    private int snakeBody;
    
    private Timer timer;

    RenderScreen(){
        
        addKeyListener(new Tadapter());
        setBackground(Color.BLACK);
        setPreferredSize(new Dimension(500 , 500));
        setFocusable(true);

        loadImage();

        initializeGame();

    }

    public void loadImage(){
        ImageIcon fr_Uit = new ImageIcon(ClassLoader.getSystemResource("snakegame/icon/apple.png"));
        apple = fr_Uit.getImage();

        ImageIcon bo_Dy = new ImageIcon(ClassLoader.getSystemResource("snakegame/icon/Sbody.png"));
        sBody = bo_Dy.getImage();

        ImageIcon he_Ad = new ImageIcon(ClassLoader.getSystemResource("snakegame/icon/Shead.png"));
        sHead = he_Ad.getImage();
    }

    public void initializeGame(){

        snakeBody = 3;

        for(int i = 0; i < snakeBody ; i++ ){
            y[i] = 50;
            x[i] = 50 - i * pixel;

        }
        
        locateApple();
        
        timer = new Timer(140, this);
        timer.start();

    }
    
    
    public void locateApple(){
        int r = (int) (Math.random() * random_Position);
        apple_x = r * pixel;
        
        r = (int) (Math.random() * random_Position);
        apple_y = r * pixel;
        
    }
    
    
    
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        
        draw(g);
    }
    
    public void draw(Graphics g){
        if(inGame){
        
            g.drawImage(apple, apple_x, apple_y, this);
        
        for (int i = 0; i < snakeBody; i++){
            if(i == 0){
                g.drawImage(sHead, x[i],y[i],this);
            }
            else{
                g.drawImage(sBody, x[i], y[i], this);
            }
        }
        
        Toolkit.getDefaultToolkit().sync();
        }else{
            
            gameOver(g);
        }
        
    }
    
    public void gameOver(Graphics g){
        
        if( top_Scoree < score){
            
            top_Scoree = score;
        }
            
        
        String msg = "GAME OVER !  :(";
        String final_score = "YOUR SCORE:  " + (Integer.toString(score));
        String top_score = "TOP SCORE:  " + (Integer.toString(top_Scoree));
        Font font = new Font("SAN_SERIF", Font.BOLD, 30);
        FontMetrics metrices = getFontMetrics(font);
        g.setFont(font);
        g.setColor(Color.RED);
        g.drawString(msg, (500 - metrices.stringWidth(msg)) / 2, (500 / 2));
        Font font2 = new Font("SAN_SERIF", Font.BOLD, 15);
        FontMetrics metrices1 = getFontMetrics(font2);
        g.setFont(font2);
        g.setColor(Color.RED);
        g.drawString(final_score, (500 - metrices1.stringWidth(final_score)) / 2, 300 );
        g.drawString(top_score, (500 - metrices1.stringWidth(final_score)) / 2, 350 );
        
    }
    
    public void SnakeMovement(){
        for (int i = snakeBody; i > 0; i--){
        x[i] = x[i-1];
        y[i] = y[i-1];
        }
        
        if(leftDirection){
            x[0] = x[0] - pixel;
        }
        
        if(rightDirection){
            x[0] = x[0] + pixel;
        }
         
        if(upDirection){
           y[0] = y[0] - pixel;
        }
          
        if(downDirection){
           y[0] = y[0] + pixel;
        }
    }
    
    public void appleDetection(){
        if ((x[0] == apple_x)  &&  y[0] == apple_y){
            snakeBody ++;
            score += 5;
            locateApple();
        }
    }
    
    public void checkGameOver(){
        for (int i = snakeBody; i > 0; i--){
            if((i > 4) && (x[0] == x[i]) && (y[0] == y[i])){
                inGame = false;
            }
        }
        
        if(y[0] >= 500)
            inGame = false;
        if(x[0] >= 500)
            inGame = false;
        if(y[0] < 0)
            inGame = false;
        if(x[0] < 0)
            inGame = false;
        
        
        if(!inGame)
            timer.stop();
    }
    
    @Override
    public void actionPerformed(ActionEvent ae){
        
        if(inGame){
            appleDetection();
            checkGameOver();
            SnakeMovement();
        }
        
        repaint();
    }
    
    public class Tadapter extends KeyAdapter{
        @Override
        public void keyPressed(KeyEvent e) {
        
            int keyPress = e.getKeyCode();
            
            if(keyPress == KeyEvent.VK_LEFT && (!rightDirection)){
                leftDirection = true;
                upDirection = false;
                downDirection = false;
            } 
            
            if(keyPress == KeyEvent.VK_RIGHT && (!leftDirection)){
                rightDirection = true;
                upDirection = false;
                downDirection = false;
            } 
             
            if(keyPress == KeyEvent.VK_UP && (!downDirection)){
                leftDirection = false;
                rightDirection = false;
                upDirection = true;
            } 
              
            if(keyPress == KeyEvent.VK_DOWN && (!upDirection)){
                leftDirection = false;
                rightDirection = false;
                downDirection = true;
            } 
            
            
        }
    }
}


