package com.ub.sec.studentgrader.client;

public class Normalize {

	 /*doNormalization - Does the normalization of the scores
	 * Input : 3 scores array, total students
	 * Output : Option 1 : //boolean flag which is true if Normalization is done successfully, else false
	 * 		  : Option 2 : Return normalizedScore Array, if null returned then error in the method
	 * Reference : http://home.apu.edu/~bsimmerok/WebTMIPs/Session7/TSes7.html
	 * 
	 * Example : 
	 * Number of students : 5
	 * professionalism      = {5,4,5,1,2}
	 * meetingParticipation = {5,4,5,1,2}
	 * workEvaluation       = {5,4,5,1,2}
	 * 
	 * Algorithm : 
	 * 1. Calculate maximum score for a student, index represents the student
	 * 2. Normalized score is calculated by  professionalism[i] + meetingParticipation[i] + workEvaluation[i]/ maxScore
	 * 2. return Normalized score array
	 * 
	 * Test Cases : 
	 * 1. Non equal length of 3 scores array
	 * 2. Negative values in any of 3 scores array
	 * 3. normalizedScore array should contain valid scores //TODO
	 * 4. Everyone gets Zero //TODO
	 * 
	 * */
	 double[] doNormalization(int[] professionalism,int[] meetingParticipation,int[] workEvaluation, int totalStudents) {
				 
		//normalizedScore array to be returned 
		double[] normalizedScore = new double[totalStudents];
		
		//variable for maximum store obtained by a student
		double maxScore = 0;
		  
		//check of all evaluations array have same lengths
		if(professionalism.length != totalStudents && meetingParticipation.length != totalStudents && workEvaluation.length != totalStudents) {
			return null;
		}
		
		//Negative values in any of 3 scores array
		for(int i=0;i<totalStudents;i++) {
			if(professionalism[i] < 0 || meetingParticipation[i] < 0 || workEvaluation[i] < 0) {
				return null;
			}
		}
		
		//step 1 : Calculate maximum score for a student, index represents the student
		for(int i=0;i<totalStudents;i++) {
			if (professionalism[i] + meetingParticipation[i] + workEvaluation[i] > maxScore) {
				maxScore = professionalism[i] + meetingParticipation[i] + workEvaluation[i];
			}
		}
		
		
		//step 2: do normalization for each student and assign it to normalizedScore array
		for(int i=0;i<totalStudents;i++) {
			//System.out.println(professionalism[i] + meetingParticipation[i] + workEvaluation[i] + " " + i + "\n");
			normalizedScore[i] = professionalism[i] + meetingParticipation[i] + workEvaluation[i];
		}
		
		//dividing values inside normalizedScore array by maxScore to make it in between 0 & 1
		for(int i=0;i<normalizedScore.length;i++) {
			normalizedScore[i] /= maxScore; 
		}
		
		return normalizedScore;
	}
	
}
