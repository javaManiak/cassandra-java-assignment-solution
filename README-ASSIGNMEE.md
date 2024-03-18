
## About this assignment
	
   1. I have committed some my personal time on this project, and 
      attempted to finish it on time.
      
   2. It turned out that the Cassandra installed on the Windows OS caused me some headaches at beginning; 
      eventually, I figured it out and got it working for me.
      
   3. Spring Boot was picked as development framework as it has many handy tools 
      ready to take off for the web service project.
     
   4. Restricted by dead lines and my own day job,I have to wrap it up at current stage without finishing the 
      REST API end point for search.

   5. I left out the unit tests in the original repository also, which should not be pardoned 
      (However, I would like to revisit them later).
         
   6. The current project is buildable from Maven as tested from my local machine (Java 17 SDK).

## Comments

   1. The restrict of Cassandra Windows version caused some troubles.

   2. The REST API end point, with searching on two columns, requires 
      some careful thinking about the ability with Cassandra NoSQL DB. 
      
      With careful research from the Internet, I suggest a few potential solutions to this:
      
	     1) searching with "ALLOW FILTERING" (may not practical in production due to table scanning).
	  
	     2) build secondary indexes on columns (needed in 'where' clause) to search/filter the result set.
      
         3) other methods.

   3. I have expanded a few more features on the front end.
    
		1) add/update and delete the records from the web page.
	
		2) put in a comprehensive dashboard on the home page 
		   for user to navigate between components and data manipulations 
		   from web page directly to the back-end DB.
			
## Some thoughts

   1. JavaScipt can be used to have basic statistics of the data and better user experience.
	
   2. The search API end points could be implemented using the certain libraries
      that are available from the Spring Boot Cassandra dependencies/repositories 
      (still researching on this and hope I will find the solution soon). 
		
   3. Likewise, there are many things could be done to improve the project - it's just a matter of time.
   
   4. I would like discuss about the solution if interested.
   
   5. Security (Authentication and Authorization) would be the next things to consider to add in for production.
   
	