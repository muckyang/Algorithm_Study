package Study_0416;
interface I1 {
	void i1();
}
interface I2 extends I1{
	void i2();
}
interface I3{
	void i3();
}

class A implements I3{
	public void i3(){};
}
class B extends A implements I2{
	public void i1(){};
	public void i2(){};
}
public class ex {
	
	public static void main(String[] args) {
		A a = new A();
		B b= new B();
		I1 k1 =b;
		I2 i2 =(I2) a;
		I3 k3 =b;
		
	}

	
}
