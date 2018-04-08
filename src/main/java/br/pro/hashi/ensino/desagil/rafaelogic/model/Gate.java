package br.pro.hashi.ensino.desagil.rafaelogic.model;

public abstract class Gate implements Emitter, Receiver {
	private String name;
	protected int size;
	
	protected Gate(String name){
		this.name = name;
		this.size= 2; // Tamanho padrão. Apenas alguns casos tem diferentes
	}

	public String toString() {
		return name;
	}
	public int getSize() {
		return size;
	}
}
