package br.pro.hashi.ensino.desagil.rafaelogic.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.BoxLayout;
import javax.swing.JCheckBox;
import javax.swing.JLabel;


import br.pro.hashi.ensino.desagil.rafaelogic.model.Gate;
import br.pro.hashi.ensino.desagil.rafaelogic.model.Source;

public class GateView extends JPanel implements ActionListener{

	private static final long serialVersionUID = 1L;
	
	private Gate gate;
	
	private	JCheckBox inBox0;
	private	JCheckBox inBox1;
	private JCheckBox outBox;
	
	public GateView(Gate gate){
		this.gate = gate;
		
		inBox0 = new JCheckBox();
		inBox1 = new JCheckBox();
		outBox = new JCheckBox();
		
		JLabel inLabel = new JLabel("Entrada:");
		JLabel outLabel = new JLabel("Saída:");
		
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		add(inLabel);
		if (this.gate.getSize() == 2){
			add(inBox0);
			
		}
		add(inBox1);
		add(outLabel);
		add(outBox);
		
		inBox0.addActionListener(this);
		inBox1.addActionListener(this);
		outBox.setEnabled(false);
		
		update();	
	}
	
	public void update(){
		Source in0 = new Source();
		Source in1 = new Source();
		boolean out;
		
		in0.turn(inBox0.isSelected());
		in1.turn(inBox1.isSelected());
		
		gate.connect(0, in0);
		gate.connect(1, in1);
		out = gate.read();
		
		outBox.setSelected(out);
		
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		update();		
	}
	
}
