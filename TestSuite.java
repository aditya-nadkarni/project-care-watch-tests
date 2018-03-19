package watchTests;

import java.util.ArrayList;

public class TestSuite {
	private ArrayList<Test> tests = new ArrayList<Test>();
	private ArrayList<Test> failedTests = new ArrayList<Test>();
	private int totalTests = 0;
	private int testsPassed = 0;
	private int testsFailed = 0;
	private boolean allPassed = false;
	
	TestSuite(ArrayList<Test> tests){
		this.tests = tests;
		checkTests();
	}
	
	private void checkTests(){
		totalTests = tests.size();
		for(Test test : tests){
			if(test.didPass()){
				testsPassed++;
			}
			else{
				testsFailed++;
				failedTests.add(test);
			}
		}
		
		allPassed = (testsPassed == totalTests);
	}
	
	public void showTestSuite(){
		if(allPassed){
			System.out.println("*** PASSED ALL TESTS!!! ***");
			System.out.println();
			System.out.println("Passed " + testsPassed + "/" + totalTests + ".");
			System.out.println();
		}
		else{
			System.out.println("Tests passed: " + testsPassed);
			System.out.println();
			System.out.println("Tests failed: " + testsFailed);
			for (Test failure : failedTests){
				System.out.println("\t -> " + failure.getName());
			}
			System.out.println();
			System.out.println("Passed " + testsPassed + "/" + totalTests + ".");
			System.out.println();
		}
	}
}
