 #language: en
 #Project: orangeHRM - Choucair
 #Date: 18/09/2024
 #Autor: Miguel Rodriguez

 @Hiring
 Feature: Recruitment process

   As a recruiter,
   He want to carry out the process of hiring a new candidate,
   To finally validate the candidate's data and display his or her status as hired.

   Scenario: Successfully adding and hiring a new candidate
     Given the recruiter is on the login page
     When he logs in with valid credentials
     And he navigates to the Recruitment item menu
     And he adds a new candidate with valid details
     And he finishes the complete the hiring process
     Then he should see the candidate as hired