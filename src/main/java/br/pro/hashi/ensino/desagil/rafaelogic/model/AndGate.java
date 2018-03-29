package br.pro.hashi.ensino.desagil.rafaelogic.model;

public class AndGate extends Gate{

	private NandGate nandGate1;
	private NandGate nandGate2;

	public AndGate() {
		nandGate1 = new NandGate();
		nandGate2 = new NandGate();
		nandGate2.connect(0, nandGate1);
		nandGate2.connect(1, nandGate1);
	}
	
	@Override
	public void connect(int pinIndex, Emitter emitter) {
		nandGate1.connect(pinIndex, emitter);
	}
	
	@Override
	public boolean read() {
		return nandGate2.read();
	}

}
