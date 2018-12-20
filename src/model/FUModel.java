package model;

import java.io.Serializable;

public class FUModel implements Serializable{
	private int flag;
	Object oo;
	public int getFlag() {
		return flag;
	}
	public void setFlag(int flag) {
		this.flag = flag;
	}
	public Object getOo() {
		return oo;
	}
	public void setOo(Object oo) {
		this.oo = oo;
	}
	public FUModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public FUModel(int flag, Object oo) {
		super();
		this.flag = flag;
		this.oo = oo;
	}
}
