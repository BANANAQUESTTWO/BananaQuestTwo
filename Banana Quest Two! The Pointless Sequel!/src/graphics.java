import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Scanner;

/**
 * Created by Taylor Hudson on 1/5/2017.
 */
class graphics implements Runnable, KeyListener, WindowListener, MouseListener {
    public final String TITLE = "Banana Quest Two: The Pointless Sequel!";
    public final Dimension SIZE = new Dimension(1920, 1040);
    public JFrame frame;
    private boolean isRunning, isDone;
    private Image imgBuffer;
    private BufferedImage banana;
    private TexturePaint stoneOcta, grassOcta, dirty;
    private boolean change;
    @SuppressWarnings("unused")
    private Color BROWN;
    @SuppressWarnings("unused")
    private boolean AITurn, UserTurn;
    private Rectangle myRect;
    private Point current;
	private BufferedImage banana1;
	private BufferedImage banana2;
	private BufferedImage worldMap;
	private BufferedImage PC;
	private 	boolean titleScreen, levelOne, WorldMap;
	int wmx = 0;
	int wmy = 0;

    public void setChange(boolean change) {
        this.change = change;
    }

    private void loadImages() {

    	try{
    		banana1 = ImageIO.read(this.getClass().getResource("Banana1.png"));
    		banana2 = ImageIO.read(this.getClass().getResource("Banana2.png"));
    		worldMap = ImageIO.read(this.getClass().getResource("worldMap.png"));
    		PC = ImageIO.read(this.getClass().getResource("PC.png"));
    	}catch(Exception e){
    		
    	}
       
    }

    public graphics(){
       titleScreen = true;
       levelOne = false;
       WorldMap = false;
        loadImages();
        setChange(true);
        current = new Point(35,70);
        myRect = new Rectangle((int)current.getX(), (int)current.getY(), 23, 80); // x,y,h,w to move just change x and y
        BROWN = new Color(139,69,19);
        frame = new JFrame();
        frame.addKeyListener(this);
        frame.addWindowListener(this);
        frame.addMouseListener(this);
        frame.setSize(SIZE);
        frame.setTitle(TITLE);
        isRunning = true;
        isDone = false;
        frame.setVisible(true);
        frame.setLayout(null);
        imgBuffer = frame.createImage(SIZE.width, SIZE.height);

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int Key;
        Key = e.getKeyCode();


        
//         if(Key == KeyEvent.VK_UP){ // UP
//            if(myRect.getY()>(31)) {
//                myRect.setLocation((int) myRect.getX(), (int) myRect.getY() - 5);
//            }
//            else {
//                myRect.setLocation((int) myRect.getX(), 30);
//            }
//        }
//        else if(Key == KeyEvent.VK_LEFT){
//            if(myRect.getX()>10) {
//                myRect.setLocation((int) myRect.getX() - 5, (int) myRect.getY());
//            }
//            else {
//                myRect.setLocation(10, (int) myRect.getY());
//            }
//        }
//        else if(Key == KeyEvent.VK_DOWN){ // DOWN
//            if(myRect.getY()<(int)(950-myRect.getHeight()-10)) {
//                myRect.setLocation((int) myRect.getX(), (int) myRect.getY() + 5);
//            }
//            else {
//                myRect.setLocation((int) myRect.getX(), (int)(950-myRect.getHeight()-10));
//            }
//        }
//        else if(Key == KeyEvent.VK_RIGHT){
//            if(myRect.getX()<(int)(600-myRect.getWidth()-10)) {
//                myRect.setLocation((int) myRect.getX() + 5, (int) myRect.getY());
//            }
//            else {
//                myRect.setLocation((int)(600-myRect.getWidth()-10), (int) myRect.getY());
//            }
//        }
        
        if(Key == KeyEvent.VK_SPACE){
        	if(titleScreen == true){
        		titleScreen = false;
        		levelOne = true;
        	}
        	else if(levelOne == true){
            		titleScreen = false;
            		levelOne = false;
            		WorldMap = true;
        	}
        	
        }
        
        if(WorldMap == true && Key == KeyEvent.VK_RIGHT && wmx >= -800)
    	{
    		wmx -= 10;
    		WorldMap = false;
    		WorldMap = true;
    		System.out.print(wmx);
    		System.out.print(", ");
    		System.out.print(wmy);
    		System.out.println();
    	}
        
        if(WorldMap == true && Key == KeyEvent.VK_LEFT && wmx <= 930)
    	{
    		wmx += 10;
    		WorldMap = false;
    		WorldMap = true;
    		System.out.print(wmx);
    		System.out.print(", ");
    		System.out.print(wmy);
    		System.out.println();
    	}
        
        if(WorldMap == true && Key == KeyEvent.VK_UP  && wmy <= 460)
    	{
    		wmy += 10;
    		WorldMap = false;
    		WorldMap = true;
    		System.out.print(wmx);
    		System.out.print(", ");
    		System.out.print(wmy);
    		System.out.println();
    	}
        
        if(WorldMap == true && Key == KeyEvent.VK_DOWN && wmy >= -190)
    	{
    		wmy -= 10;
    		WorldMap = false;
    		WorldMap = true;
    		System.out.print(wmx);
    		System.out.print(", ");
    		System.out.print(wmy);
    		System.out.println();
    	}
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void windowOpened(WindowEvent e) {

    }

    @Override
    public void windowClosing(WindowEvent e) {
        frame.setVisible(false);
        frame.dispose();
        isRunning = false;
    }

    @Override
    public void windowClosed(WindowEvent e) {
        while(true){

            if(isDone){
                System.exit(0);
            }
            try{
                Thread.sleep(100);
            }
            catch(InterruptedException ie){
                ie.printStackTrace();
            }
        }
    }

    @Override
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowActivated(WindowEvent e) {

    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }

    @Override
    public void run() {
        while(isRunning){

            draw();

            if(change){
                setChange(false);

            }
            try{Thread.sleep(32);}
            catch(InterruptedException ie){
                ie.printStackTrace();
            }
        }
        isDone = true;
    }

    private void title(Graphics2D g2d){
    	g2d.setColor(Color.BLACK);
    	g2d.fillRect(0, 0, SIZE.width, SIZE.height);
    	g2d.setColor(Color.YELLOW);
    	g2d.setFont(g2d.getFont().deriveFont(g2d.getFont().getSize() * 10F));
    	g2d.drawString("Banana Quest Two", 450, 400);
    	g2d.setFont(g2d.getFont().deriveFont(g2d.getFont().getSize() * .5F));
    	g2d.drawString("The Pointless Sequel!", 650, 500);
    	g2d.drawImage(banana1, 1400, 250, null);
    	g2d.drawImage(banana2, 250, 250, null);
    	g2d.setFont(g2d.getFont().deriveFont(g2d.getFont().getSize() * 2F));
    	g2d.setFont(g2d.getFont().deriveFont(g2d.getFont().getSize() * .1F));
    	g2d.drawString("Press Space to begin.", 850, 800);
    }
    
    private void levelOne(Graphics2D g2d){
    	g2d.setColor(Color.BLACK);
    	g2d.fillRect(0, 0, SIZE.width, SIZE.height);
    	g2d.drawImage(banana1, 1400, 250, null);
    	g2d.drawImage(banana2, 250, 250, null);
    	g2d.setFont(g2d.getFont().deriveFont(g2d.getFont().getSize() * 2F));
    	g2d.setColor(Color.YELLOW);
    	g2d.drawString("Even after the events of the first Banana Quest...", 450, 300);
    	g2d.drawString("The Evil Dragon King, Mr. Hudson, continued his reign of terror on the world.", 450, 325);
    	g2d.drawString("He even did the unthinkable:", 450, 350);
    	g2d.drawString("He outlawed text-based adventures!", 450, 375);
    	g2d.drawString("Now you, the player, will have to save the world and bring back text-based adventeurs!", 450, 400);
    	wmx = 70;
    	wmy = 150;
    }
    
    private void WorldMap(Graphics2D g2d)
    {
    	g2d.fillRect(0, 0, SIZE.width, SIZE.height);
    	g2d.drawImage(worldMap, wmx, wmy, null);
    	g2d.drawImage(PC, 900, 450, null);
    }
    
    
    private void draw() {

        // TODO Auto-generated method stub
        Graphics2D g2d = (Graphics2D) imgBuffer.getGraphics();
       
        if (titleScreen)
        {
        	title(g2d);
        }
        else if(levelOne)
        {
        	levelOne(g2d);
        }
        else if(WorldMap)
        {
        	WorldMap(g2d);
        }
        
        if(isRunning)
            g2d = (Graphics2D) frame.getGraphics();
        g2d.drawImage(imgBuffer, 0,  0, SIZE.width, SIZE.height, 0, 0, SIZE.width, SIZE.height, null);
        g2d.dispose();
    }
}
