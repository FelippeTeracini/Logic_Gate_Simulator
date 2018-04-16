package br.pro.hashi.ensino.desagil.rafaelogic.view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JColorChooser;


import br.pro.hashi.ensino.desagil.rafaelogic.model.Gate;
import br.pro.hashi.ensino.desagil.rafaelogic.model.Source;

public class GateView extends Panel implements ActionListener, MouseListener{
	
	
	private static final long serialVersionUID = 1L;
	
	int size_img = 175;
	
	private Gate gate;
	
	private	JCheckBox inBox0;
	private	JCheckBox inBox1;
	
	private Color color;
	private Image image;
	
	private boolean out;
	
	public GateView(Gate gate){
		
		super(300, 300);
		
		
		this.gate = gate;
		
		inBox0 = new JCheckBox();
		inBox1 = new JCheckBox();
		
		int pos = size_img/ (this.gate.getSize()+1); //Logica de divisao em relação ao numerod e rows
		int addPos = 275/10; //parte inteira
		
		
		if (this.gate.getSize() >= 2){
			add(inBox0, 10, (pos*2)+addPos, 25, 25);
		}
		add(inBox1, 10, pos+addPos, 25, 25);
		
		
		
		inBox0.addActionListener(this);
		inBox1.addActionListener(this);
		
		color = Color.BLACK;
		
		String path = "/" + gate.toString() + ".png";
		URL url = getClass().getResource(path);
		image = new ImageIcon(url).getImage();
		
		addMouseListener(this);
		
		update();
	}
	
	private void update(){
		Source in0 = new Source();
		Source in1 = new Source();
		
		in0.turn(inBox0.isSelected());
		in1.turn(inBox1.isSelected());
		
		gate.connect(0, in0);
		gate.connect(1, in1);
		out = gate.read();
		
		if(out == true){
			color = Color.RED;
			repaint();
		}
		else{
			color = Color.BLACK;
			repaint();
		}
		
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		update();		
	}
	
	@Override
	public void mouseClicked(MouseEvent event) {

		int x = event.getX();
		int y = event.getY();

		if((Math.pow(x - (240+15), 2) + Math.pow(y - (110+15), 2)) < 225 && out == true){

			color = JColorChooser.showDialog(this, null, color);
			
			repaint();
		}
	}
	
	@Override
	public void mousePressed(MouseEvent event) {
	}
	@Override
	public void mouseReleased(MouseEvent event) {
	}
	@Override
	public void mouseEntered(MouseEvent event) {
	}
	@Override
	public void mouseExited(MouseEvent event) {
	}
	
	@Override
	public void paintComponent(Graphics g) {

		super.paintComponent(g);

		g.drawImage(image, 50, 40, 175, 175, null);

		g.setColor(color);
		g.drawOval(240, 110, 30, 30);
		g.fillOval(240, 110, 30, 30);

		getToolkit().sync();
    }
}
