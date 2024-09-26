 #language: en
 #Project: orangeHRM - Choucair
 #Date: 18/09/2024
 #Autor: Miguel Rodriguez

 @Hiring
 Feature: Recruitment process

   As a recruiter,
   He want to carry out the process of hiring a new candidate,
   To finally validate the candidate's data and display his or her status as hired.

   Scenario Outline: Successfully adding and hiring a new candidate
     Given the recruiter is on the login page
     When he logs in with valid credentials
       | username   | password   |
       | <username> | <password> |
     And he navigates to the Recruitment item menu
     And he adds a new candidate with valid details
       | firstName   | middleName   | lastName   | vacancy   | email   | phone   | cv   | keywords   | notes   |
       | <firstName> | <middleName> | <lastName> | <vacancy> | <email> | <phone> | <cv> | <keywords> | <notes> |
     And he finishes the complete the hiring process
       | notes   | tittleInterview   | interviewer   |
       | <notes> | <tittleInterview> | <interviewer> |
     Then he should see the candidate as hired
       | firstName   |
       | <firstName> |

     Examples:
       | username | password | firstName | middleName | lastName | vacancy               | email              | phone      | cv                              | keywords | notes           | tittleInterview     | interviewer |
       | Admin    | admin123 | Angel      | Andres     | Alvarez  | Payroll Administrator | alvarez@gmail.com | 3023654789 | src/test/resources/files/CV.txt | QA       | Notes candidate | OrangeHRM Interview | P           |
       | Admin    | admin123 | Pedro      | Andres     | Alvarez  | Payroll Administrator | alvarez@gmail.com | 3023654789 | src/test/resources/files/CV.txt | QA       | Notes candidate | OrangeHRM Interview | P           |