//Ruben Jacobo lab section 002
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class ReverseTTT implements MouseListener{  //implements the MouseListener class
	
	public MouseEvent e;
	
	
	
	JFrame frame = new JFrame(); //create a new frame and panel for the tic tac toe to go on
	JPanel panel = new JPanel();
	
	JComponent component = new drawComp(); //create a new component of type drawComp to draw the shapes on
	
	char slots[]= new char[]{'z','z','z','z','z','z','z','z','z'}; //array of chars to
													//keep track of square and diamond moves on the board
	drawComp g = new drawComp();  
	public int k=g.k; //keep the variables the same as the other classes
	public int h=g.h;
	
	public boolean userWin=false; //keeps track of winners 
	public boolean cpuWin=false;
	

	boolean emptySlots [] =g.emptySlots; //keep track of which slots on the board are taken
	
	public boolean p1Turn=g.p1Turn; //keep boolean name the same and connected with boolean in drawComp java class
	public int move; //keeps track of the amount of times a player or cpu has placed a shape on the board
	
	int player=1; //user will always be square and will go first
	int CPU=2; //computer will always be diamond and will go after the user

	
	
	
	
	public ReverseTTT() {
	
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //frame dimensions and behaviors
		frame.setTitle("Toe-Tac-Tic");
		frame.setSize(500, 500);
		
		
		frame.setLayout(new BorderLayout());
		
		frame.add(g);
		frame.setVisible(true);
		frame.setResizable(false);
		frame.addMouseListener(this); 
		
		
	}
	
		public void cpuTurn() {  //when called, this method will choose an open space on the board and draw a diamond 
			int picker = rePick();
			if(move==9) {} //do nothing if there are already 9 moves recorded(full board)
			else {
			g.h=picker; //set g to our random int picker which signifies an open slot on the board
			slots[picker]='d';
		
		}
		}
	
	
	//generates random number
		
		public int ranDub() {
	
			double rand=(Math.random()*8);
			int round = (int) Math.round(rand);
			
			
			return round;
		}
		
		
		public int rePick() {
			
			int round=ranDub();
			while (move<9) {
			if(emptySlots[round]==true) 
				{emptySlots[round]=false;
				System.out.println("filled slot at "+round); //print to the console where the user moves
				slots[round]='d'; //set the array slots at index round equal to the character 'd' to signify a diamond was placed
				move++;  //increment move to keep track of movements on the board
				
				break;}
			else {round=ranDub(); //call the random number method if the chosen int is a filled spot on the grid
			}   //keep doing this until the random number generated corresponds with an empty slot on the grid
			}
			
			 return round;
		
		
		}

		
		public void checker() { //checks all possibilities for winners of both square and diamond
		
		//checking for square winner
		if(slots[0]=='s' && slots[1]=='s' && slots[2]=='s') {
			cpuWin=true;
			
		}
		if(slots[3]=='s' && slots[4]=='s' && slots[5]=='s') {
			cpuWin=true;
			
		}
		if(slots[6]=='s' && slots[7]=='s' && slots[8]=='s') {
			cpuWin=true;
			
		}
		if(slots[0]=='s' && slots[3]=='s' && slots[6]=='s') {
			cpuWin=true;
			
		}
		if(slots[1]=='s' && slots[4]=='s' && slots[7]=='s') {
			cpuWin=true;
			
		}
		if(slots[2]=='s' && slots[5]=='s' && slots[8]=='s') {
			cpuWin=true;
			
		}
		if(slots[2]=='s' && slots[4]=='s' && slots[6]=='s') {
			cpuWin=true;
			
		}
		if(slots[0]=='s' && slots[4]=='s' && slots[8]=='s') {
			cpuWin=true;
			
		}
		
		
		
		//checking for diamond winner
		
		if(slots[0]=='d' && slots[1]=='d' && slots[2]=='d') {
			userWin=true;
			System.out.println("012");  //numbers print the winning or losing combination to the console 
		}
		if(slots[3]=='d' && slots[4]=='d' && slots[5]=='d') {
			userWin=true;
			System.out.println("345");
		}
		if(slots[6]=='d' && slots[7]=='d' && slots[8]=='d') {
			userWin=true;
			System.out.println("678");
		}
		if(slots[0]=='d' && slots[3]=='d' && slots[6]=='d') {
			userWin=true;
			System.out.println("036");
		}
		if(slots[1]=='d' && slots[4]=='d' && slots[7]=='d') {
			userWin=true;
			System.out.println("147");
		}
		if(slots[2]=='d' && slots[5]=='d' && slots[8]=='d') {
			userWin=true;
			System.out.println("258");
		}
		if(slots[2]=='d' && slots[4]=='d' && slots[6]=='d') {
			userWin=true;
			System.out.println("246");
		}
		if(slots[0]=='d' && slots[4]=='d' && slots[8]=='d') {
			userWin=true;
			System.out.println("048");
		}
		
		//check for a tie
		if(move==9 && userWin==false && cpuWin==false) { 
			JOptionPane.showMessageDialog(null, "Draw!"); //print message to the console and to a dialog box
			System.out.println("tie");
		}
		
		if(cpuWin==true) {
			JOptionPane.showMessageDialog(null, "you lost!");
			System.out.println("you lost!");
		}
		if(userWin==true) {
			JOptionPane.showMessageDialog(null, "you win!");
			System.out.println("you win!");
		}
		
	
		}




	@Override
	public void mouseClicked(MouseEvent e) {
		int x = e.getX(); //gets the coordinates of the click
		int y = e.getY();
		
	if(x <= 165 && y <= 184) {
		if(userWin==false && cpuWin==false) { //when there is a click and all the conditions are met, call these methods
		if(emptySlots[0]==true) {  
		g.k=0;
		slots[0]='s';			//to keep track of which slots are squares, set slots at this index to 's'
		move++;
		g.repaint();			//call the object drawComp g and paint the correct shape in the correct slot
		emptySlots[0]=false;    //set this spot to occupied so no one else draws anything here
		cpuTurn();  			//cpu will now place their diamond in an empty slot
		checker();				//program checks for any winners after cpu goes
		}
		}
	}
	if(x < 311 && x >= 165 && y <= 188 && y < 180) {
		if(userWin==false && cpuWin==false) {
		if(emptySlots[1]==true) {
		g.k=1;
		slots[1]='s';
		move++;
		g.repaint();
		emptySlots[1]=false;
		cpuTurn();
		checker();
		}
		}
	}
	if(x >= 317 && x >= 311 && y <= 187 && y < 182) {
		if(userWin==false && cpuWin==false) {
		if(emptySlots[2]==true) {
		g.k=2;
		slots[2]='s';
		move++;
		g.repaint();
		emptySlots[2]=false;
		cpuTurn();
		checker();
		}
		}
	}
	if(x <= 166 && x < 314 && y <= 320 && y >= 184) {
		if(userWin==false && cpuWin==false) {
		if(emptySlots[3]==true) {
		g.k=3;
		slots[3]='s';
		move++;
		g.repaint();
		emptySlots[3]=false;
		cpuTurn();
		checker();
		}
		}
	}
	if(x <= 307 && x >= 165 && y <= 317 && y >= 180) {
		if(userWin==false && cpuWin==false) {
		if(emptySlots[4]==true) {
		g.k=4;
		slots[4]='s';
		move++;
		g.repaint();
		emptySlots[4]=false;
		cpuTurn();
		checker();
		
		}}
	}
	if(x >= 312 && x >= 307 && y <= 320 && y > 182) {
		if(userWin==false && cpuWin==false) {
		if(emptySlots[5]==true) {
		g.k=5;
		slots[5]='s';
		move++;
		g.repaint();
		emptySlots[5]=false;
		cpuTurn();
		checker();
		}
		}
	}
	if(x <= 161 && x < 314 && y < 475 && y > 320) {
		if(userWin==false && cpuWin==false) {
		if(emptySlots[6]==true) {
		g.k=6;
		slots[6]='s';
		move++;
		g.repaint();
		emptySlots[6]=false;
		cpuTurn();
		checker();
		}
		}
	}
	if(x < 310 && x > 161 && y < 480 && y > 317) {
		if(userWin==false && cpuWin==false) {
		if(emptySlots[7]==true) {
		g.k=7;
		slots[7]='s';
		move++;
		g.repaint();
		emptySlots[7]=false;
		cpuTurn();
		checker();
		}
		}
	}
	if(x < 484 && x > 310 && y < 485 && y > 320) {
		if(userWin==false && cpuWin==false) {
		if(emptySlots[8]==true) {
		g.k=8;
		slots[8]='s';
		move++;
		g.repaint();
		emptySlots[8]=false;
		cpuTurn();
		checker();
		}
		}
	}
		
					}
					

	//unused methods


	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}




	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}




	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}




	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	

}
