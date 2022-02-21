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
Attributes— Long:SportId, String:LeagueName, LocalDate:StartDate, LocalDate:EndDate and SportType(BASEBALL,SOCCER,HANDBALL,BASKETBALL,CRICKET,RUGBY).

The possible entities: LeagueDetails, TeamDetails, PlayerDetails, VenueDetails.
•	LeagueDetails: This Entity holds the attributes like name of the league (leagueName), location of the league(venueName), winner of the league (teamWon), (prizeMoney).
•	TeamDetails: This Entity holds the attributes like Id,TeamName, owner of the team(teamOwner),
•	Coach of the team(teamCoach), number of players in team(teamSize).
•	PlayerDetails: This Entity holds the attributes like Id,playerName, age, nationality, dateOfBirth, gender,teamName.
•	VenueDetails: This entity holds the attributes like Id,venueName, venueCapacity, venueLocation.


JPA & Validation Test Cases:
<img width="1051" alt="TestCases_Screenshot " src="https://user-images.githubusercontent.com/97815128/154125764-872377e5-38ac-4c0a-854f-7893865f6718.png">
