package watchTests;

public class Test {
	private String name;
	private boolean passed;
	
	public Test(){
		name = "";
		passed = false;
	}
	
	Test(String name){
		this.name = name;
	}
	
	Test(String name, boolean passed){
		this.name = name;
		this.passed = passed;
	}
	
	public String getName(){
		return name;
	}
	
	public boolean didPass(){
		return passed;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public void setPassed(boolean passed){
		this.passed = passed;
	}
}
