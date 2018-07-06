package dld;

import java.util.ArrayList;
import java.util.Collection;




class Weaponl {
	private int id;
	private String name;
	public Weaponl() {}
	public Weaponl(int id,String name) {
		this.id = id;
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		System.out.println("重写的equals方法");
		Weaponl w = (Weaponl) obj;
		System.out.println(this.getName() + "he " + w.getName());
		return this.getId() == w.getId() && this.getName() == w.getName();
		
	
	}
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		System.out.println("重写的方法");
		
		return this.getId();
	}
	
}
public class Test {
	public static void main(String[] args) {
		Collection c = new ArrayList();	
		Weaponl w1 = new Weaponl(1,"jj");
		Weaponl w2 = new Weaponl(2,"hh");
		Weaponl w3 = new Weaponl(3,"kk");
		c.add(w1);
		c.add(w2);
		c.add(w3);
		System.out.println(c);
		boolean ret = c.contains(new Weaponl(1,"jj"));
		System.out.println(ret);
	}

}

