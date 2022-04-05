ITMD 4515 - Lab 3 Sanjay Reddy Muthyala

Lab 3 - Updates:
    Enhanced the POJO by modifying the fields.
    Created a HTML form with field validations & violations within a JSP Page.
    Validated fields using a "Validator".
    Using JDBC Configured Database to the web app for real time CRUD operations.


ITMD 4515 - Lab 4 Sanjay Reddy Muthyala

Lab 4 - Updates:
1. Paragraph that describes the business domain you have chosen to work with, and why.

Sports league is my business domain model. The domain model is intentionally unaware of the potential support for various leagues and therefore only model entities that exist within an individual league.

2.Write a second paragraph answering the following questions: There is only one entity required for Lab 4, but what other entities from your business domain can you think of? How might they relate to one another?

I have created Sport Entity as part of lab-4. 
Attributes— Long:SportId, String:LeagueName and SportType(BASEBALL,SOCCER,HANDBALL,BASKETBALL,CRICKET,RUGBY).

The possible entities: LeagueDetails, TeamDetails, PlayerDetails, VenueDetails.
•	LeagueDetails: This Entity holds the attributes like LeagueId,name of the league (leagueName), LocalDate:StartDate, LocalDate:EndDate, winner of the league (teamWon), (prizeMoneyDetails)
•	TeamDetails: This Entity holds the attributes like TeamId,TeamName, owner of the team(teamOwner),	Coach of the team(teamCoach), 
•	PlayerDetails: This Entity holds the attributes like playerId, playerName, age, nationality, dateOfBirth, gender.
•	VenueDetails: This entity holds the attributes like venueId,venueName, venueCapacity, venueLocation.


JPA & Validation Test Cases:
<img width="1051" alt="TestCases_Screenshot " src="https://user-images.githubusercontent.com/97815128/154125764-872377e5-38ac-4c0a-854f-7893865f6718.png">


ITMD 4515 - Lab 8

Usernames & Passwords:
	
	i) admin group: 
		username: admin, password: admin
	
	ii)Manager group:
		username: manager1, password: manager1
	
	iii)User group:
		username: player1, password: player1

Authentication:
	
	i) Login page:
	 
	ii)welcome page:
	 

    iii)Trying to login as manager:
 
	
	iv)Manager Welcome Access:
	 

	v)Admin content forbidden:
	 


	vi)User content forbidden:
	 

	 

![image](https://user-images.githubusercontent.com/97815128/161846709-86e28637-cb50-4937-8a46-3428589a80ed.png)

![image](https://user-images.githubusercontent.com/97815128/161846930-44352807-7a21-44cd-ac4b-c65bb71350ad.png)

