package facetoproject.mywork;

public class Add {
	
	public int add(int a,int b){
		return a+b;
	}
	
	public long add(long a,long b){
		return a+b;
	}
	
	public float add(float a,float b){
		return a+b;
	}
	
	public double add(double a,double b){
		return a+b;
	}
	
	public String add(String a,String b){
		return a+b;
	}
	
	public static void main(String[] args) {
		Add a = new Add();
		System.out.println(a.add(1.0000001, 1.5));
	}
}
