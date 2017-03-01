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
    private boolean change;
    @SuppressWarnings("unused")
        private boolean AITurn, UserTurn;
	private BufferedImage banana1;
	private BufferedImage banana2;
	private BufferedImage worldMap;
	private BufferedImage PC;
	private BufferedImage House;
	private BufferedImage Plantano;
	private BufferedImage fourthwall;
	private BufferedImage K2261;
	private 	boolean titleScreen, levelOne, WorldMap, Home, BCity, K226A1, Dialogue1, Dialogue2, Dialogue3, Dialogue4;
	int wmx = 0;
	int wmy = 0;
	int hx = 800;
	int hy = -120;
	int bcx = -220;
	int bcy = -190;
	int ka1x = 860;
	int ka1y = 460;

    public void setChange(boolean change) {
        this.change = change;
    }

    private void loadImages() {

    	try{
    		banana1 = ImageIO.read(this.getClass().getResource("Banana1.png"));
    		banana2 = ImageIO.read(this.getClass().getResource("Banana2.png"));
    		worldMap = ImageIO.read(this.getClass().getResource("worldMap.png"));
    		PC = ImageIO.read(this.getClass().getResource("PC.png"));
    		House = ImageIO.read(this.getClass().getResource("House.png"));
    		Plantano = ImageIO.read(this.getClass().getResource("Plantano.png"));
    		fourthwall = ImageIO.read(this.getClass().getResource("4thwall.jpg"));
    		K2261 = ImageIO.read(this.getClass().getResource("K226A1.png"));
    	}catch(Exception e){
    		
    	}
       
    }

    public graphics(){
       titleScreen = true;
       levelOne = false;
       WorldMap = false;
       Home = false;
       BCity = false;
       K226A1 = false;
       Dialogue1 = false;
       Dialogue2 = false;
       Dialogue3 = false;
       Dialogue4 = false;
        loadImages();
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
    		
    		if(wmy >= -100 && wmy <= 470 && wmx <= -170 && wmx >= -540)
            {
    			Home = true;
    			WorldMap = false;
            }
    		else if(wmy >= 380 && wmy <= 470 && wmx >= 50 && wmx <= 380)
            {
    			K226A1 = true;
    			WorldMap = false;
            }
    		else if(wmy >= 40 && wmx >= 550)
            {
    			BCity = true;
    			WorldMap = false;
            }
    		else
    		{
    			System.out.print(wmx);
            	System.out.print(", ");
            	System.out.print(wmy);
            	System.out.println();
    		}
    	}
        
        if(WorldMap == true && Key == KeyEvent.VK_LEFT && wmx <= 930)
    	{
    		wmx += 10;
    		WorldMap = false;
    		WorldMap = true;
    		
    		if(wmy >= -100 && wmy <= 470 && wmx <= -170 && wmx >= -540)
            {
    			Home = true;
    			WorldMap = false;
            }
    		else if(wmy >= 380 && wmy <= 470 && wmx >= 50 && wmx <= 380)
            {
    			K226A1 = true;
    			WorldMap = false;
            }
    		else if(wmy >= 40 && wmx >= 550)
            {
    			bcx = -850;
    			bcy = 170;
    			
    			BCity = true;
    			WorldMap = false;
            }
    		else
    		{
    			System.out.print(wmx);
            	System.out.print(", ");
            	System.out.print(wmy);
            	System.out.println();
    		}
    	}
        
        if(WorldMap == true && Key == KeyEvent.VK_UP  && wmy <= 460)
    	{
    		wmy += 10;
    		WorldMap = false;
    		WorldMap = true;

    		if(wmy >= -100 && wmy <= 470 && wmx <= -170 && wmx >= -540)
            {
    			Home = true;
    			WorldMap = false;
            }
    		else if(wmy >= 380 && wmy <= 470 && wmx >= 50 && wmx <= 380)
            {
    			K226A1 = true;
    			WorldMap = false;
            }
    		else if(wmy >= 40 && wmx >= 550)
            {
    			bcx = -220;
    			bcy = -210;
    			
    			BCity = true;
    			WorldMap = false;
            }
    		else
    		{
    			System.out.print(wmx);
            	System.out.print(", ");
            	System.out.print(wmy);
            	System.out.println();
    		}
    	}
        
        if(WorldMap == true && Key == KeyEvent.VK_DOWN && wmy >= -190)
    	{
    		wmy -= 10;
    		WorldMap = false;
    		WorldMap = true;

    		if(wmy >= -100 && wmy <= 470 && wmx <= -170 && wmx >= -540)
            {
            	Home = true;
            	WorldMap = false;
            }
    		else if(wmy >= 380 && wmy <= 470 && wmx >= 50 && wmx <= 380)
            {
    			K226A1 = true;
    			WorldMap = false;
            }
    		else if(wmy >= 40 && wmx >= 550)
            {
    			BCity = true;
    			WorldMap = false;
            }
    		else
    		{
    			System.out.print(wmx);
            	System.out.print(", ");
            	System.out.print(wmy);
            	System.out.println();
    		}
    	}
        
        if(Home == true && Key == KeyEvent.VK_RIGHT && hx > 330)
    	{
    		hx -= 10;
    		Home = false;
    		Home = true;
    		
    		System.out.print(hx);
        	System.out.print(", ");
        	System.out.print(hy);
        	System.out.println();
    	}
        
        if(Home == true && Key == KeyEvent.VK_LEFT  && hx < 640 && hy > 160 ||Home == true && Key == KeyEvent.VK_LEFT  && hx < 860 && hy < 160)
    	{
    		hx += 10;
    		Home = false;
    		Home = true;
    		
    		System.out.print(hx);
        	System.out.print(", ");
        	System.out.print(hy);
        	System.out.println();
    	}
        
        if(Home == true && Key == KeyEvent.VK_DOWN && hy > -120)
    	{
    		hy -= 10;
    		Home = false;
    		Home = true;
    		
    		System.out.print(hx);
        	System.out.print(", ");
        	System.out.print(hy);
        	System.out.println();
    	}
        
        if(Home == true && Key == KeyEvent.VK_DOWN && hy <= -120)
    	{
        	Home = false;
        	WorldMap = true;
        	
        	wmx = -360;
        	wmy = -110;
    	}
        
        if(Home == true && Key == KeyEvent.VK_UP && hx < 640 && hy < 310 || Home == true && Key == KeyEvent.VK_UP && hx > 640 && hy < 160)
    	{
    		hy += 10;
    		Home = false;
    		Home = true;
    		
    		System.out.print(hx);
        	System.out.print(", ");
        	System.out.print(hy);
        	System.out.println();
    	}
        
        if(Home == true && Key == KeyEvent.VK_UP && hy > -60 && hx > 400 && hx < 540)
    	{
    		hy -= 20;
    		
    		Dialogue1 = true;
    		Home = false;
    	}
        
        if(Home == true && Key == KeyEvent.VK_DOWN && hy > -60 && hx > 400 && hx < 540)
    	{
    		hy += 20;
    		
    		Dialogue1 = true;
    		Home = false;
    	}
        
        if(Home == true && Key == KeyEvent.VK_RIGHT && hy > -60 && hx > 400 && hx < 540)
    	{
    		hx += 20;
    		
    		Dialogue1 = true;
    		Home = false;
    	}
        
        if(Home == true && Key == KeyEvent.VK_LEFT && hy > -60 && hx > 400 && hx < 540)
    	{
    		hx -= 20;
    		
    		Dialogue1 = true;
    		Home = false;
    	}
        
        if(Key == KeyEvent.VK_SPACE && Dialogue1 == true)
        {
        	Dialogue1 = false;
        	Home = true;
        }
        
        if(BCity == true && Key == KeyEvent.VK_UP && bcy < 470)
        {
        	bcy += 10;
        	BCity = false;
        	BCity = true;
        	
        	System.out.print(bcx);
        	System.out.print(", ");
        	System.out.print(bcy);
        	System.out.println();
        }
        
        if(BCity == true && Key == KeyEvent.VK_DOWN)
        {
        	bcy -= 10;
        	BCity = false;
        	BCity = true;
        	
        	System.out.print(bcx);
        	System.out.print(", ");
        	System.out.print(bcy);
        	System.out.println();
        }
        
        if(BCity == true && Key == KeyEvent.VK_DOWN && bcy <= -210)
        {
        	wmx = 710;
        	wmy = 30;
        	BCity = false;
        	WorldMap = true;
        }
        
        if(BCity == true && Key == KeyEvent.VK_RIGHT)
        {
        	bcx -= 10;
        	BCity = false;
        	BCity = true;
        	
        	System.out.print(bcx);
        	System.out.print(", ");
        	System.out.print(bcy);
        	System.out.println();
        }
        
        if(BCity == true && Key == KeyEvent.VK_RIGHT && bcx <= -850)
        {
        	wmx = 540;
        	wmy = 180;
        	BCity = false;
        	WorldMap = true;
        }
        
        if(BCity == true && Key == KeyEvent.VK_LEFT && bcx < 940)
        {
        	bcx += 10;
        	BCity = false;
        	BCity = true;
        	
        	System.out.print(bcx);
        	System.out.print(", ");
        	System.out.print(bcy);
        	System.out.println();
        }
        
        if(BCity == true && Key == KeyEvent.VK_DOWN && bcy < 40 && bcx < -430 && bcx > -620)
    	{
    		bcy += 20;
    		
    		Dialogue2 = true;
    		BCity = false;
    	}
        
        if(BCity == true && Key == KeyEvent.VK_RIGHT && bcy < 40 && bcx < -430 && bcx > -620)
    	{
    		bcx += 20;
    		
    		Dialogue2 = true;
    		BCity = false;
    	}
        
        if(BCity == true && Key == KeyEvent.VK_LEFT && bcy < 40 && bcx < -430 && bcx > -620)
    	{
    		bcx -= 20;
    		
    		Dialogue2 = true;
    		BCity = false;
    	}
        
        if(Key == KeyEvent.VK_SPACE && Dialogue2 == true)
        {
        	Dialogue2 = false;
        	BCity = true;
        }
        
        if(BCity == true && Key == KeyEvent.VK_DOWN && bcy < 130 && bcx < 540 && bcx > 430)
    	{
    		bcy += 20;
    		
    		Dialogue3 = true;
    		BCity = false;
    	}
        
        if(BCity == true && Key == KeyEvent.VK_RIGHT && bcy < 130 && bcx < 540 && bcx > 430)
    	{
    		bcx += 20;
    		
    		Dialogue3 = true;
    		BCity = false;
    	}
        
        if(BCity == true && Key == KeyEvent.VK_LEFT && bcy < 130 && bcx < 540 && bcx > 430)
    	{
    		bcx -= 20;
    		
    		Dialogue3 = true;
    		BCity = false;
    	}
        
        if(Key == KeyEvent.VK_SPACE && Dialogue3 == true)
        {
        	Dialogue3 = false;
        	Dialogue4 = true;
        	try {
				Thread.sleep(2000);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
        }
        
        if(Key == KeyEvent.VK_SPACE && Dialogue4 == true)
        {
        	Dialogue4 = false;
        	BCity = true;
        }
        
        if(K226A1 == true && Key == KeyEvent.VK_RIGHT)
        {
        	ka1x -= 10;
        	K226A1 = false;
        	K226A1 = true;
        	
        	System.out.print(ka1x);
        	System.out.print(", ");
        	System.out.print(ka1y);
        	System.out.println();
        }
        
        if(K226A1 == true && Key == KeyEvent.VK_LEFT)
        {
        	ka1x += 10;
        	K226A1 = false;
        	K226A1 = true;
        	
        	System.out.print(ka1x);
        	System.out.print(", ");
        	System.out.print(ka1y);
        	System.out.println();
        }
        
        if(K226A1 == true && Key == KeyEvent.VK_DOWN)
        {
        	ka1y -= 10;
        	K226A1 = false;
        	K226A1 = true;
        	
        	System.out.print(ka1x);
        	System.out.print(", ");
        	System.out.print(ka1y);
        	System.out.println();
        }
        
        if(K226A1 == true && Key == KeyEvent.VK_UP)
        {
        	ka1y += 10;
        	K226A1 = false;
        	K226A1 = true;
        	
        	System.out.print(ka1x);
        	System.out.print(", ");
        	System.out.print(ka1y);
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
    	g2d.drawImage(banana1, 1300, 250, null);
    	g2d.drawImage(banana2, 250, 250, null);
    	g2d.setFont(g2d.getFont().deriveFont(g2d.getFont().getSize() * 2F));
    	g2d.setFont(g2d.getFont().deriveFont(g2d.getFont().getSize() * .1F));
    	g2d.drawString("Press Space to begin.", 850, 800);
    }
    
    private void levelOne(Graphics2D g2d){
    	g2d.setColor(Color.BLACK);
    	g2d.fillRect(0, 0, SIZE.width, SIZE.height);
    	g2d.drawImage(banana1, 1300, 250, null);
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
    	g2d.setColor(Color.BLACK);
    	g2d.fillRect(0, 0, SIZE.width, SIZE.height);
    	g2d.drawImage(worldMap, wmx, wmy, null);
    	g2d.drawImage(PC, 900, 450, null);
    }
    
    private void Home(Graphics2D g2d)
    {
    	g2d.setColor(Color.BLACK);
    	g2d.fillRect(0, 0, SIZE.width, SIZE.height);
    	g2d.drawImage(House, hx, hy, null);
    	g2d.drawImage(PC, 900, 450, null);
    }
    
    private void Dialogue1(Graphics2D g2d){
    	g2d.setColor(Color.BLACK);
    	g2d.fillRect(350, 700, 1200, 250);
    	g2d.drawImage(banana1, 1300, 600, null);
    	g2d.drawImage(banana2, 250, 600, null);
    	g2d.setFont(g2d.getFont().deriveFont(g2d.getFont().getSize() * 2F));
    	g2d.setColor(Color.YELLOW);
    	g2d.drawString("Your mom:", 450, 750);
    	g2d.drawString("\"All young children need to go on dangerous adventeurs to save the world!", 450, 775);
    	g2d.drawString("It said so on TV!", 450, 800);
    	g2d.drawString("Well then, off you go now!\"", 450, 825);
    }
    
    private void Plantano(Graphics2D g2d)
    {
    	g2d.setColor(Color.BLACK);
    	g2d.fillRect(0, 0, SIZE.width, SIZE.height);
    	g2d.drawImage(Plantano, bcx, bcy, null);
    	g2d.drawImage(PC, 900, 450, null);
    }
    
    private void Dialogue2(Graphics2D g2d){
    	g2d.setColor(Color.BLACK);
    	g2d.fillRect(350, 700, 1200, 250);
    	g2d.drawImage(banana1, 1300, 600, null);
    	g2d.drawImage(banana2, 250, 600, null);
    	g2d.setFont(g2d.getFont().deriveFont(g2d.getFont().getSize() * 2F));
    	g2d.setColor(Color.YELLOW);
    	g2d.drawString("Fat Guy:", 450, 750);
    	g2d.drawString("\"Technology is incredible!\"", 450, 775);
    }
    
    private void Dialogue3(Graphics2D g2d){
    	g2d.setColor(Color.BLACK);
    	g2d.fillRect(350, 700, 1200, 250);
    	g2d.drawImage(banana1, 1300, 600, null);
    	g2d.drawImage(banana2, 250, 600, null);
    	g2d.setFont(g2d.getFont().deriveFont(g2d.getFont().getSize() * 2F));
    	g2d.setColor(Color.YELLOW);
    	g2d.drawString("Beard Guy:", 450, 750);
    	g2d.drawString("\"Gee! This guy'd better hope bad dialogue doesn't count against his grade!\"", 450, 775);
    	g2d.drawString("\"Otherwise, I'm pretty sure this project's earned a zero!\"", 450, 800);
    	g2d.drawString("\"LOL!\"", 450, 825);
    }
    
    private void Dialogue4(Graphics2D g2d){
    	g2d.setColor(Color.BLACK);
    	g2d.fillRect(350, 700, 1200, 250);
    	g2d.drawImage(fourthwall, 600, 200, null);
    	g2d.drawImage(banana1, 1300, 600, null);
    	g2d.drawImage(banana2, 250, 600, null);
    	g2d.setFont(g2d.getFont().deriveFont(g2d.getFont().getSize() * 2F));
    	g2d.setColor(Color.YELLOW);
    	g2d.drawString("Brett:", 450, 750);
    	g2d.drawString("\"Aaaand... there goes the fourth wall.\"", 450, 775);
    	g2d.drawString("\"Thanks a lot!\"", 450, 800);
    }
    	
    	private void K226A1(Graphics2D g2d){
        	g2d.setColor(Color.BLACK);
        	g2d.fillRect(0, 0, SIZE.width, SIZE.height);
        	g2d.drawImage(K2261, ka1x, ka1y, null);
        	g2d.drawImage(PC, 900, 450, null);
    }
    
    	//Here you go Mr. Hudson, a comment.
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
        else if (Home)
        {
        	Home(g2d);
        }
        else if (Dialogue1)
        {
        	Dialogue1(g2d);
        }
        else if (BCity)
        {
        	Plantano(g2d);
        }
        else if (Dialogue2)
        {
        	Dialogue2(g2d);
        }
        else if (Dialogue3)
        {
        	Dialogue3(g2d);
        }
        else if (Dialogue4)
        {
        	Dialogue4(g2d);
        }
        else if (K226A1)
        {
        	K226A1(g2d);
        }
        
        if(isRunning)
            g2d = (Graphics2D) frame.getGraphics();
        g2d.drawImage(imgBuffer, 0,  0, SIZE.width, SIZE.height, 0, 0, SIZE.width, SIZE.height, null);
        g2d.dispose();
    }
}
