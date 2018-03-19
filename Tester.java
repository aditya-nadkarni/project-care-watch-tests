package watchTests;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Tester {
	public static void main(String[] args){
		Tester tester = new Tester();
        
        String fileName = "/Users/adityanadkarni/documents/college/Sophomore Year/Winter 2018/CS48/project-care/sampleWatchOutputs.txt";
		
		TestSuite suite1 = tester.testSuite1(fileName);
		
		suite1.showTestSuite();
		System.out.println("Done.");
		
//		File file = new File("/Users/adityanadkarni/documents/college/Sophomore Year/Winter 2018/CS48/project-care/sampleWatchOutputs.txt");
//		Scanner sc = null;
//		try {
//			sc = new Scanner(file);
//			while(sc.hasNextLine()){
//				String line = sc.nextLine();
//				while(sc.hasNextLine() && !line.contains("<*>")){
//					line = sc.nextLine();
//				}
//				
//				System.out.println(line);
//			}
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}
	
	public TestSuite testSuite1(String filePath){
		ArrayList<Test> testList = new ArrayList<Test>();
		ArrayList<Integer> heartRatesSampled = new ArrayList<Integer>();
		ArrayList<Double> heartRatesSaved = new ArrayList<Double>();
		
		File file = new File(filePath);
		Scanner sc = null;
		try {
			sc = new Scanner(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String line = sc.nextLine();
		while(sc.hasNextLine() && !line.contains("<*>")){
					line = sc.nextLine();
				}
		if(!line.equals("<*> Ready")){
			testList.add(new Test("readyTest", false));
		}
		else{
			testList.add(new Test("readyTest", true));
		}
		
		line = sc.nextLine();
		while(sc.hasNextLine() && !line.contains("<*>")){
					line = sc.nextLine();
				}
		if(!line.equals("<*> Ready to select time.")){
			testList.add(new Test("readyToSelectTimeTest", false));
		}
		else{
			testList.add(new Test("readyToSelectTimeTest", true));
		}
		
		line = sc.nextLine();
		while(sc.hasNextLine() && !line.contains("<*>")){
			line = sc.nextLine();
		}
		if(!line.equals("<*> Time selected: 0")){
			System.out.println(line);
			testList.add(new Test("timeSelectedTest", false));
		}
		else{
			testList.add(new Test("timeSelectedTest", true));
		}
		
		line = sc.nextLine();
		while(sc.hasNextLine() && !line.contains("<*>")){
					line = sc.nextLine();
				}
		if(!line.equals("<*> Ready to select intensity.")){
			testList.add(new Test("readyToSelectIntensityTest", false));
		}
		else{
			testList.add(new Test("readyToSelectIntensityTest", true));
		}
		
		line = sc.nextLine();
		while(sc.hasNextLine() && !line.contains("<*>")){
					line = sc.nextLine();
				}
		if(!line.equals("<*> Intensity Selected: 0")){
			testList.add(new Test("intensitySelectedTest", false));
		}
		else{
			testList.add(new Test("intensitySelectedTest", true));
		}
		
		line = sc.nextLine();
		while(sc.hasNextLine() && !line.contains("<*>")){
					line = sc.nextLine();
				}
		if(!line.equals("<*> Time passed in: 10.0")){
			testList.add(new Test("timePassedTest", false));
		}
		else{
			testList.add(new Test("timePassedTest", true));
		}
		
		line = sc.nextLine();
		while(sc.hasNextLine() && !line.contains("<*>")){
					line = sc.nextLine();
				}
		if(!line.equals("<*> Intensity passed in: 1")){
			testList.add(new Test("intensityPassedTest", false));
		}
		else{
			testList.add(new Test("intensityPassedTest", true));
		}
		
		line = sc.nextLine();
		while(sc.hasNextLine() && !line.contains("<*>")){
					line = sc.nextLine();
				}
		if(!line.equals("<*> Starting workout.")){
			testList.add(new Test("startingWorkoutTest", false));
		}
		else{
			testList.add(new Test("startingWorkoutTest", true));
		}
		
		line = sc.nextLine();
		while(sc.hasNextLine() && !line.contains("<*>")){
					line = sc.nextLine();
				}
		if(!line.equals("<*> Warm up time: 2.0")){
			testList.add(new Test("warmUpTimeTest", false));
		}
		else{
			testList.add(new Test("warmUpTimeTest", true));
		}
		
		line = sc.nextLine();
		while(sc.hasNextLine() && !line.contains("<*>")){
					line = sc.nextLine();
				}
		if(!line.equals("<*> Cool Down time: 8.0")){
			testList.add(new Test("coolDownTimeTest", false));
		}
		else{
			testList.add(new Test("coolDownTimeTest", true));
		}
		
		line = sc.nextLine();
		while(sc.hasNextLine() && !line.contains("<*>")){
					line = sc.nextLine();
				}
		if(!line.equals("<*> Workout started.")){
			testList.add(new Test("workoutStartedTest", false));
		}
		else{
			testList.add(new Test("workoutStartedTest", true));
		}
		
		//Tests during workout
		line = sc.nextLine();
		while(sc.hasNextLine() && !line.contains("<*>")){
					line = sc.nextLine();
				}
		int splitIndex = line.lastIndexOf(':');
		String label = line.substring(0, splitIndex+1);
		String value = line.substring(splitIndex+1, line.length());
		value = value.trim();
		int heartRateValue = Integer.parseInt(value);
		if(!label.equals("<*> Heart Rate:")){
			testList.add(new Test("startedSamplingHeartRateTest", false));
		}
		else{
			testList.add(new Test("startedSamplingHeartRateTest", true));
			heartRatesSampled.add(heartRateValue);
		}
		
		int cycle = 0;
		do{
			//get heart rate data sampled
			splitIndex = line.lastIndexOf(':');
			label = line.substring(0, splitIndex+1);
//			if(!label.equals("<*> Heart Rate:")){
//				testList.add(new Test("followedFlow", false));
//				break;
//			}
			value = line.substring(splitIndex+1, line.length());
			value = value.trim();
			heartRateValue = Integer.parseInt(value);
			
			//check time passed with warm up/cool down
			line = sc.nextLine();
			while(!line.contains("<*>")){
				line = sc.nextLine();
			}
			splitIndex = line.lastIndexOf(':');
			String timeString = null;
			double time = 0;
			if(line.substring(0, splitIndex+1).equals("<*> Time Passed:")){
				timeString = line.substring(splitIndex+1, line.length());
				timeString = timeString.trim();
				time = Double.parseDouble(timeString);
			}
			line = sc.nextLine();
			while(!line.contains("<*>")){
				line = sc.nextLine();
			}
			
			double zone = 0;
			if(time <= 2.0 || time >= 8.0){
				if(line.equals("<*> Is in warm-up/cool-down.")){
					testList.add(new Test("correctWarmUpCoolDown" + cycle, true));
					line = sc.nextLine();
					while(!line.contains("<*>")){
						line = sc.nextLine();
					}
					splitIndex = line.lastIndexOf(':');
					String zoneString;
					if(line.substring(0, splitIndex+1).equals("<*> Zone:")){
						zoneString = line.substring(splitIndex+1, line.length());
						zoneString = zoneString.trim();
						zone = Double.parseDouble(zoneString);
					}
					
				}
				else{
					testList.add(new Test("correctWarmUpCoolDown" + cycle, false));
				}
			}
			else{
				if(line.equals("<*> Doing actual workout.")){
					testList.add(new Test("actualWorkoutStarted" + cycle, true));
					line = sc.nextLine();
					while(!line.contains("<*>")){
						line = sc.nextLine();
					}
					splitIndex = line.lastIndexOf(':');
					String zoneString;
					if(line.substring(0, splitIndex+1).equals("<*> Zone:")){
						zoneString = line.substring(splitIndex+1, line.length());
						zoneString = zoneString.trim();
						zone = Double.parseDouble(zoneString);
					}
				}
				else{
					testList.add(new Test("actualWorkoutStarted" + cycle, false));
				}
			}
			line = sc.nextLine();
			while(!line.contains("<*>")){
				line = sc.nextLine();
			}
			line = sc.nextLine();
			while(!line.contains("<*>")){
				line = sc.nextLine();
			}
			line = sc.nextLine();
			while(!line.contains("<*>")){
				line = sc.nextLine();
			}
			
			//Check pace
			line = sc.nextLine();
			while(!line.contains("<*>")){
				line = sc.nextLine();
			}
			if(heartRateValue < zone){
				if(line.trim().equals("<*> Going too SLOW.")){
					testList.add(new Test("rightZone" + cycle, true));
				}
				else{
					testList.add(new Test("rightZone" + cycle, false));
				}
			}
			else if(heartRateValue > zone){
				System.out.println("Heart rate: " + heartRateValue);
				System.out.println("Zone: " + zone);
				if(line.equals("<*> Going too FAST!!!")){
					testList.add(new Test("rightZone" + cycle, true));
				}
				else{
					testList.add(new Test("rightZone" + cycle, false));
				}
			}
			
			line = sc.nextLine();
			while(!line.contains("<*>")){
				line = sc.nextLine();
			}
			
			cycle++;
		} while(!line.equals("<*> Ending workout."));
		
		if(line.trim().equals("<*> Ending workout.")){
			testList.add(new Test("endedWorkout", true));
		}
		
		//Get the heart rates saved by the workout
		line = sc.nextLine();
		while(sc.hasNextLine() && !line.contains("<*>")){
			line = sc.nextLine();
		}
		if(line.trim().equals("<*> HeartRateSamples:")){
			testList.add(new Test("gotHeartRates", true));
		}
		else{
			testList.add(new Test("gotHeartRates", false));
		}
		
		line = sc.nextLine();
		while(sc.hasNextLine() && !line.contains("<*>")){
					line = sc.nextLine();
		}
		do{
			double heartRateSaved = Double.parseDouble(line.substring(4).trim());
			heartRatesSaved.add(heartRateSaved);
			line = sc.nextLine();
			while(!line.contains("<*>")){
				line = sc.nextLine();
			}
		} while(!line.equals("<*> Workout Saved!"));
		
		if(line.equals("<*> Workout Saved!")){
			testList.add(new Test("workoutSavedTest", true));
		}
		else{
			testList.add(new Test("workoutSavedTest", false));
		}
		
		
		return new TestSuite(testList);
	}
}
