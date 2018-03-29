package br.pro.hashi.ensino.desagil.rafaelogic.model;

public class OrGate extends Gate{
	
	private Emitter[] emitters;
	private NandGate nandGate1;
	private NandGate nandGate2;
	private NandGate nandGate3;

	public OrGate() {
		
		emitters = new Emitter[2];
		nandGate1 = new NandGate();
		nandGate2 = new NandGate();
		nandGate3 = new NandGate();

	}
	
	@Override
	public void connect(int pinIndex, Emitter emitter) {
		emitters[pinIndex] = emitter;
	}
	
	@Override
	public boolean read() {
		
		nandGate1.connect(0, emitters[0]);
		nandGate1.connect(1, emitters[0]);
		nandGate2.connect(0, emitters[1]);
		nandGate2.connect(1, emitters[1]);
		nandGate3.connect(0, nandGate1);
		nandGate3.connect(1, nandGate2);
		
		return nandGate3.read();
	}
	
}
