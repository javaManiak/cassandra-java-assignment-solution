# Cassandra CQL Statements

Use this file to include your DDL.  Also include any DML that you may have created.


## DDL
   - create the keyspace (oboe)
    
      create keyspace oboe with replication = {'class': 'SimpleStrategy', 'replication_factor': '1'}  AND durable_writes = true;

   - delete a keyspace (DB)
    
      drop keyspace oboe;

## Create tables
   
   - Location table
    
      create table locations (location uuid primary key, name text) with comment='Satellite scanned locations';
    
   - Bird (Result) table
    
      create table (birdid text primary key, location text, species text, traits text, scandate text) with comment = 'Scanned birds result';

## Drop tables
  
     drop table locations;
  
     drop table birds;

## DML (if any)

   - Populate dummy data into tables 


   - locations

    
		begin batch
		
			insert into locations(locationid, location, name) values(now(), '33N,84W', 'Atlanta');
			insert into locations(locationid, location, name) values(now(), '32N,96W', 'Dallas');
			insert into locations(locationid, location, name) values(now(), '29N,95W', 'Houston');
			insert into locations(locationid, location, name) values(now(), '32N,65W', 'Bermuda');
			
			insert into locations(locationid, location, name) values(now(), '40N,73W', 'New York');
			insert into locations(locationid, location, name) values(now(), '25N,80W', 'Miami');
			insert into locations(locationid, location, name) values(now(), '45N,75W', 'Ottwa');
			insert into locations(locationid, location, name) values(now(), '41N,87W', 'Chicago');
			
			insert into locations(locationid, location, name) values(now(), '38N,122W', 'San Francisco');
			insert into locations(locationid, location, name) values(now(), '49N,124W', 'Vancouver');	
			insert into locations(locationid, location, name) values(now(), '36N,140E', 'Tokyo');
			insert into locations(locationid, location, name) values(now(), '33S,151E', 'Sydney');
			
			insert into locations(locationid, location, name) values(now(), '64N,20W', 'Iceland');
			insert into locations(locationid, location, name) values(now(), '34S,23E', 'South Africa');

		apply batch;
		

   - birds


		begin batch
		
			insert into birds(birdid, birdLocation, birdSpecies, birdTraits, scandate) values(now(), '33N,84W', 'Humming bird', 'small, agile, hooked beak', '2024-09-18');
			insert into birds(birdid, birdLocation, birdSpecies, birdTraits, scandate) values(now(), '32N,96W', 'Special loon', 'blue eyes, swim and dive, webbed feet', '2024-03-27');
			insert into birds(birdid, birdLocation, birdSpecies, birdTraits, scandate) values(now(), '29N,95W', 'Common loon', 'red eyes, swim and dive, webbed feet', '2025-02-27');
			insert into birds(birdid, birdLocation, birdSpecies, birdTraits, scandate) values(now(), '32N,65W', 'Canadian goose', 'black eyes, migration, grey feathers', '2023-02-27');
			insert into birds(birdid, birdLocation, birdSpecies, birdTraits, scandate) values(now(), '40N,73W', 'Humming bird', 'small, agile, hooked beak', '2024-01-18');
			insert into birds(birdid, birdLocation, birdSpecies, birdTraits, scandate) values(now(), '25N,80W', 'Special loon', 'blue eyes, swim and dive, webbed feet', '2024-05-27');
			insert into birds(birdid, birdLocation, birdSpecies, birdTraits, scandate) values(now(), '45N,75W', 'Common loon', 'red eyes, swim and dive, webbed feet', '2025-02-22');
			insert into birds(birdid, birdLocation, birdSpecies, birdTraits, scandate) values(now(), '41N,87W', 'Canadian goose', 'black eyes, migration, grey feathers', '2025-01-27');
			insert into birds(birdid, birdLocation, birdSpecies, birdTraits, scandate) values(now(), '38N,122W', 'Humming bird', 'small, agile, hooked beak', '2022-09-18');
			insert into birds(birdid, birdLocation, birdSpecies, birdTraits, scandate) values(now(), '49N,124W', 'Special loon', 'blue eyes, swim and dive, webbed feet', '2021-08-27');
			insert into birds(birdid, birdLocation, birdSpecies, birdTraits, scandate) values(now(), '36N,140E', 'Common loon', 'red eyes, swim and dive, webbed feet', '2025-07-21');
			insert into birds(birdid, birdLocation, birdSpecies, birdTraits, scandate) values(now(), '33S,151E', 'Canadian goose', 'black eyes, migration, grey feathers', '2024-07-27');
			insert into birds(birdid, birdLocation, birdSpecies, birdTraits, scandate) values(now(), '64N,20W', 'Humming bird', 'small, agile, hooked beak', '2024-08-18');
			insert into birds(birdid, birdLocation, birdSpecies, birdTraits, scandate) values(now(), '34S,23E', 'Special loon', 'blue eyes, swim and dive, webbed feet', '2024-11-27');
		
		apply batch;
		
	    
   - Read the scan results for a specific location on a given day (from database table - birds)

       select * from birds where location = '49N,124W' and scandate = '2021-08-27' allow filtering;

   - Clean up tables (remove all records from the target tables)
    
       truncate locations;
   
       truncate birds;
       