package ss.week2;

public class TestLamp {
	
	public TestLamp(){}
	
	public void runTest(){
		ThreeWayLampenum lamp = new ThreeWayLampenum();
		
		System.out.println("The lamp should be off");
		System.out.println("The lamp now is " + lamp.getSetting());
		System.out.println("The setting is " + compareResult( "OFF", lamp.getSetting()));
		
		lamp.click();
		System.out.println("Click");

		System.out.println("The lamp should be low");
		System.out.println("The lamp now is " + lamp.getSetting());
		System.out.println("The setting is " + compareResult( "LOW", lamp.getSetting()));
		
		lamp.click();
		System.out.println("Click");

		System.out.println("The lamp should be medium");
		System.out.println("The lamp now is " + lamp.getSetting());
		System.out.println("The setting is " + compareResult( "MEDIUM", lamp.getSetting()));

		lamp.click();
		System.out.println("Click");

		System.out.println("The lamp should be high");
		System.out.println("The lamp now is " + lamp.getSetting());
		System.out.println("The setting is " + compareResult( "HIGH", lamp.getSetting()));

		lamp.click();
		System.out.println("Click");

		System.out.println("The lamp should be off");
		System.out.println("The lamp now is " + lamp.getSetting());
		System.out.println("The setting is " + compareResult( "OFF", lamp.getSetting()));
			}
	
	private String compareResult(String shouldBe, String isReally){
		return (shouldBe.equals(isReally))? "rigth":"wrong";
		
	}

	public static void main(String[] args) {
		TestLamp lamp = new TestLamp();
		lamp.runTest();			

		

	}

}
