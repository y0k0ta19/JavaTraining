package ex11_03;

public class Attr <E>{
	private final String name;
	private Object value = null;
	
	public Attr(String name){
		this.name = name;
	}
	
	public Attr(String name, E value){
		this.name = name;
		this.value = value;
	}
	
	public String getName(){
		return name;
	}
	
	public Object getValue(){
		return value;
	}
	
	public Object setValue(E newValue){
		Object oldVal = value;
		value = newValue;
		return oldVal;
	}
	
	public String toString(){
		return name + "+'" + value + "'";
	}
}
