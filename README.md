Sports league is my business domain model. The domain model is intentionally unaware of the potential support for various leagues and therefore only model entities that exist within an individual league.

Enhanced the POJO by modifying the fields. Created a HTML form with field validations & violations within a JSP Page.

Using JDBC Configured Database to the web app for real time CRUD operations.

I have created Sport Entity. Attributes— Long:SportId, String:LeagueName and SportType(BASEBALL,SOCCER,HANDBALL,BASKETBALL,CRICKET,RUGBY).
The possible entities: LeagueDetails, TeamDetails, PlayerDetails, VenueDetails. • LeagueDetails: This Entity holds the attributes like LeagueId,name of the league (leagueName), LocalDate:StartDate, LocalDate:EndDate, winner of the league (teamWon), (prizeMoneyDetails) • TeamDetails: This Entity holds the attributes like TeamId,TeamName, owner of the team(teamOwner), Coach of the team(teamCoach), • PlayerDetails: This Entity holds the attributes like playerId, playerName, age, nationality, dateOfBirth, gender. • VenueDetails: This entity holds the attributes like venueId,venueName, venueCapacity, venueLocation.

