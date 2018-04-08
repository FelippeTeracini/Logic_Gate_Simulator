package br.pro.hashi.ensino.desagil.rafaelogic.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.JCheckBox;
import javax.swing.JLabel;

import br.pro.hashi.ensino.desagil.rafaelogic.model.Gate;

public class GateView extends JPanel implements ActionListener{

	private static final long serialVersionUID = 1L;
	
	private Gate gate;
	
	private	JCheckBox in1;
	private	JCheckBox in2;
	private JCheckBox out;
	
	public GateView(Gate gate){
		this.gate = gate;
		
		in1 = new JCheckBox();
		in2 = new JCheckBox();
		out = new JCheckBox();
		
		JLabel in1Label = new JLabel("Entrada 1");
		JLabel in2Label = new JLabel("Entrada 2");
		JLabel outLabel = new JLabel("Saída");
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
}
