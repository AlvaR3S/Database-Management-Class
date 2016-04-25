-----------------------------------------------------------------------
--CREATED BY REYNALDO ALVAREZ-----------------------------
---------U.S. Military Operations------------------------
---------------------------------------------------------------

----------------------------table droppers----------------------------
DROP TABLE IF EXISTS missions;
DROP TABLE IF EXISTS hospitals;
DROP TABLE IF EXISTS patient;
DROP TABLE IF EXISTS allies;
DROP TABLE IF EXISTS base;
DROP TABLE IF EXISTS weapons;
DROP TABLE IF EXISTS vehicles;
DROP TABLE IF EXISTS departments;
DROP TABLE IF EXISTS injury;
DROP TABLE IF EXISTS soldiers;

-------------------------------------------------------------------------------------------------
-------------------------------Creating Tables of Military Operations-----------------------------------
-- soldiers --
CREATE TABLE soldiers (
  sid		char(3) not null unique,
  firstName	text not null,
  lastName	text not null,
  stateUS	text not null,
  ethnicity	text not null,
  gender	text not null,
  age		integer not null,
  healthy	text not null,
 primary key(sid)	
);

-- injury --
CREATE TABLE injury (
  iID	char(3) not null unique,
  description	text not null,
 primary key(iID)
);

-- Departments --
CREATE TABLE departments (
  depName	text not null unique,
 primary key(depName)	
);

-- Vehicles --
CREATE TABLE vehicles (
  vid		char(3) not null unique,
  vehicleType	text not null,
  priceUSD	numeric(15, 2),
  capacity	integer,
  depName	text not null references departments(depName), 
 primary key(vid)	
);

-- Weapons --
CREATE TABLE weapons (
  wid		char(3) not null unique,
  name		text not null,
  weaponType	text,
  ammoQty	integer,
  priceUSD	numeric(12, 2),
  depName	text not null references departments(depName), 
 primary key(wid)	
);

-- Base --
CREATE TABLE base (
  bid		char(3) not null unique,
  name		text not null,
  stateUS	text,
  soldierQty	integer,
  depName	text not null references departments(depName),
 primary key(bid)	
);

-- Patient --
CREATE TABLE patient (
.
  pid	char(3) not null unique,
  sid	char(3) not null references soldiers(sid),
  iID	char(3) not null references injury(iID),
 primary key(pid)
);

-- Hospitals --
CREATE TABLE hospitals (
  hid	char(3) not null unique,
  bid	char(3) not null references base(bid),
  pid	char(3) not null references patient(pid),
 primary key(hid)
);

-- Allies --
CREATE TABLE allies (
  allyCountry	text not null unique,
  aid		numeric(24, 2),
 primary key(allyCountry)
);

-- Missions --
CREATE TABLE missions (
  mid		char(3) not null unique,
  sid		char(3) not null references soldiers(sid),
  depName	text not null references departments(depName),
  vid		char(3) not null references vehicles(vid),
  wid		char(3) not null references weapons(wid),
  country	text not null,
  allyCountry	text not null references allies(allyCountry),
  serviceYrs	integer not null,
  description	text not null,
 primary key(mid)	
);
select * from missions;
------------------------------------------------------------------------------------
----------------------Inserts into military operations---------------------------------
--------------------------------------------------------------------------------

-- Allies --
INSERT INTO allies( allyCountry, aid )
  VALUES('France', 2300000000.00 );
  
INSERT INTO allies( allyCountry, aid )
  VALUES('Canada', 23255200.00);

INSERT INTO allies( allyCountry, aid )
  VALUES('Puerto Rico', 6500000000.00);

INSERT INTO allies( allyCountry, aid )
  VALUES('Philippines', 178000000.00);

INSERT INTO allies( allyCountry, aid )
  VALUES('Germany', 1400000000.00);

INSERT INTO allies( allyCountry, aid )
  VALUES('Australia', 711520424.00);

INSERT INTO allies( allyCountry, aid )
  VALUES('Japan', 700000000.00);
  
INSERT INTO allies( allyCountry, aid )
  VALUES('Mexico', 560600000);

INSERT INTO allies( allyCountry, aid )
  VALUES('Morocco', 1966100000.00);

INSERT INTO allies( allyCountry, aid )
  VALUES('Israel', 3075000000.00);

INSERT INTO allies( allyCountry, aid )
  VALUES('United Kingdom', 8300000000.00);

-- soldiers --
INSERT INTO soldiers( sid, firstName, lastName, stateUS, ethnicity, gender, age, healthy )
  VALUES('s01', 'Lois', 'Mcdaniel', 'New York','European American', 'Female', 43, 'Yes');

INSERT INTO soldiers( sid, firstName, lastName, stateUS, ethnicity, gender, age, healthy )
  VALUES('s02', 'Tony', 'Martin', 'Illinois','European American', 'Male', 50, 'Yes');

INSERT INTO soldiers( sid, firstName, lastName, stateUS, ethnicity, gender, age, healthy )
  VALUES('s03', 'Brandon', 'Maldonado', 'North Dakota','Hispanic American', 'Male', 34, 'Yes');

INSERT INTO soldiers( sid, firstName, lastName, stateUS, ethnicity, gender, age, healthy )
  VALUES('s04', 'Lewis', 'Evans', 'Minnesota','Hispanic American', 'Male', 18, 'Yes');

INSERT INTO soldiers( sid, firstName, lastName, stateUS, ethnicity, gender, age, healthy )
  VALUES('s05', 'Cathy', 'Gibson', 'Connecticut','African American', 'Female', 24, 'No');

INSERT INTO soldiers( sid, firstName, lastName, stateUS, ethnicity, gender, age, healthy )
  VALUES('s06', 'Sara', 'Rogers', 'Iowa','European American', 'Female', 19, 'Yes');

INSERT INTO soldiers( sid, firstName, lastName, stateUS, ethnicity, gender, age, healthy )
  VALUES('s07', 'Pablo', 'Elliott', 'New Jersey','European American', 'Male', 18, 'Yes');

INSERT INTO soldiers( sid, firstName, lastName, stateUS, ethnicity, gender, age, healthy )
  VALUES('s08', 'Isaac', 'Ramirez', 'Kansas','Hispanic American', 'Male', 20, 'Yes');

INSERT INTO soldiers( sid, firstName, lastName, stateUS, ethnicity, gender, age, healthy )
  VALUES('s09', 'Kirk', 'Strickland', 'Ohio','European American', 'Male', 29, 'Yes');

INSERT INTO soldiers( sid, firstName, lastName, stateUS, ethnicity, gender, age, healthy )
  VALUES('s10', 'Reynaldo', 'Alvarez', 'Wyoming','African American', 'Male', 27, 'No');

INSERT INTO soldiers( sid, firstName, lastName, stateUS, ethnicity, gender, age, healthy )
  VALUES('s11', 'Troy', 'Mcdaniel', 'Massachusetts','Jewish American', 'Male', 26, 'Yes');

INSERT INTO soldiers( sid, firstName, lastName, stateUS, ethnicity, gender, age, healthy )
  VALUES('s12', 'Lisa', 'Pain', 'New York','European American', 'Female', 22, 'Yes');

INSERT INTO soldiers( sid, firstName, lastName, stateUS, ethnicity, gender, age, healthy )
  VALUES('s13', 'Amy', 'Tran', 'New York','European American', 'Female', 19, 'Yes');

INSERT INTO soldiers( sid, firstName, lastName, stateUS, ethnicity, gender, age, healthy )
  VALUES('s14', 'Reynaldo', 'Alvarez', 'New York','Cambodian', 'Male', 18, 'Yes');

INSERT INTO soldiers( sid, firstName, lastName, stateUS, ethnicity, gender, age, healthy )
  VALUES('s15', 'Sara', 'Burn', 'Idaho','European American', 'Female', 25, 'Yes');

INSERT INTO soldiers( sid, firstName, lastName, stateUS, ethnicity, gender, age, healthy )
  VALUES('s16', 'Tim', 'Walker', 'Texas','Chinese', 'Male', 33, 'Yes');

INSERT INTO soldiers( sid, firstName, lastName, stateUS, ethnicity, gender, age, healthy )
  VALUES('s17', 'Lisa', 'Mccoy', 'Florida','African American', 'Female', 60, 'No');

INSERT INTO soldiers( sid, firstName, lastName, stateUS, ethnicity, gender, age, healthy )
  VALUES('s18', 'Stephanie', 'Rodriguez', 'New Jersey','Korean', 'Female', 22, 'Yes');

INSERT INTO soldiers( sid, firstName, lastName, stateUS, ethnicity, gender, age, healthy )
  VALUES('s19', 'Michael', 'Jordan', 'Maine','Hispanic American', 'Male', 35, 'Yes');

INSERT INTO soldiers( sid, firstName, lastName, stateUS, ethnicity, gender, age, healthy )
  VALUES('s20', 'Drake', 'Mill', 'California','African American', 'Male', 40, 'Yes');

-- Departments --
INSERT INTO departments( depName )
  VALUES('Army');

INSERT INTO departments( depName )
  VALUES('Navy');

INSERT INTO departments( depName )
  VALUES('Air Force');
  
 -- Weapons --
 INSERT INTO weapons( wid, name, weaponType, ammoQty, priceUSD, depName )
  VALUES('w01', 'Beretta M9', 'Semi-Automatic Pistol', 15, 20000, 'Army');

 INSERT INTO weapons( wid, name, weaponType, ammoQty, priceUSD, depName )
  VALUES('w02', 'M1 Thompson', 'Submachine Gun', 50, 50000, 'Army');
 
 INSERT INTO weapons( wid, name, weaponType, ammoQty, priceUSD, depName )
  VALUES('w03', 'Arsenal Shipka', 'Submachine Gun', 32, 80000, 'Air Force');

 INSERT INTO weapons( wid, name, weaponType, ammoQty, priceUSD, depName )
  VALUES('w04', 'Lebel Model', 'Bolt-Action Rifle', 10, 500, 'Navy');

 INSERT INTO weapons( wid, name, weaponType, ammoQty, priceUSD, depName )
  VALUES('w05', 'Accuracy International L115', 'Sniper Rifle', 5, 10000, 'Air Force');

 INSERT INTO weapons( wid, name, weaponType, ammoQty, priceUSD, depName )
  VALUES('w06', 'Barett M82', 'Anti-Material Rifle', 10, 90000, 'Army');

 INSERT INTO weapons( wid, name, weaponType, ammoQty, priceUSD, depName )
  VALUES('w07', 'General Electric M134', 'Minigun Six-Barrel Gatling Gun', 6000, 10000, 'Navy');

 INSERT INTO weapons( wid, name, weaponType, ammoQty, priceUSD, depName )
  VALUES('w08', 'Infantry Hand Grenades', 'Hand Grenades', 37, 1000, 'Army');

 INSERT INTO weapons( wid, name, weaponType, ammoQty, priceUSD, depName)
  VALUES('w09', 'Winchester Model 1912', 'Pump-Action Slide Shotgun', 12, 2000, 'Army');

 INSERT INTO weapons( wid, name, weaponType, ammoQty, priceUSD, depName )
  VALUES('w10', 'Harris M92', 'Bolt-Action Anti-Material Rifle', 5, 70000, 'Navy');

-- Vehicles --
 INSERT INTO vehicles( vid, vehicleType, priceUSD, capacity, depName )
  VALUES('v01', 'INS Vikramaditya', 2350000000, 2000, 'Army');
  
 INSERT INTO vehicles( vid, vehicleType, priceUSD, capacity, depName )
  VALUES('v02', 'B-2 Spirit Stealth Bomber', 2400000000, 2, 'Air Force');
  
 INSERT INTO vehicles( vid, vehicleType, priceUSD, capacity, depName )
  VALUES('v03', 'Virginia Class Submarine', 2500000000, 500, 'Navy');
  
 INSERT INTO vehicles( vid, vehicleType, priceUSD, capacity, depName )
  VALUES('v04', 'Varyag Aircraft Carrier', 2400000000, 1000, 'Air Force');
  
 INSERT INTO vehicles( vid, vehicleType, priceUSD, capacity, depName )
  VALUES('v05', 'USS America', 3400000000, 2000, 'Navy');

 INSERT INTO vehicles( vid, vehicleType, priceUSD, capacity, depName )
  VALUES('v06', 'Charles de Gaulle Aircraft Carrier', 4000000000, 5000, 'Air Force');

  -- Base --
 INSERT INTO base( bid, name, stateUS, soldierQty, depName)
  VALUES('b01', 'Eglin Air Force Base In Valparaiso', 'Chicago', 500, 'Air Force');

 INSERT INTO base( bid, name, stateUS, soldierQty, depName)
  VALUES('b02', 'Cheyenne Mountain Air Force Base', 'Colorado', 300, 'Air Force');

 INSERT INTO base( bid, name, stateUS, soldierQty, depName)
  VALUES('b03', 'US Military Academy Army Base', 'New York', 1000, 'Army');

 INSERT INTO base( bid, name, stateUS, soldierQty, depName)
  VALUES('b04', 'Carlisle Barracks Army Base', 'Pennsylvania', 600, 'Army');

 INSERT INTO base( bid, name, stateUS, soldierQty, depName)
  VALUES('b05', 'Fort Dix Base', 'New Jersey', 900, 'Navy');

-- injury --
INSERT INTO injury( iID, description )
  VALUES('i01', 'Broken leg');
  
INSERT INTO injury( iID, description )  
  VALUES('i02', 'Broken arm');

INSERT INTO injury( iID, description )
  VALUES('i03', 'Broken ankle');
  
INSERT INTO injury( iID, description )  
  VALUES('i04', 'Bullet wound in left kneecap');
  
INSERT INTO injury( iID, description )  
  VALUES('i05', 'Surgery for a new hang');
  
INSERT INTO injury( iID, description )
  VALUES('i06', 'Broken fingers');
  
INSERT INTO injury( iID, description ) 
  VALUES('i07', 'Severe blood body wound');
  
INSERT INTO injury( iID, description )  
  VALUES('i08', 'Disattached left leg');
  
INSERT INTO injury( iID, description )  
  VALUES('i09', 'Disabled from the waste down');
  
INSERT INTO injury( iID, description )  
  VALUES('i10', 'Grenade explosion damadge right hand');
  
INSERT INTO injury( iID, description )  
  VALUES('i11', 'Internal bleeding');
  
INSERT INTO injury( iID, description )  
  VALUES('i12', 'Ear drum surgery');
  
INSERT INTO injury( iID, description )  
  VALUES('i13', 'Broken foot');

INSERT INTO injury( iID, description )  
  VALUES('i14', 'Amnesia');

INSERT INTO injury( iID, description )  
  VALUES('i15', 'Lead poisoning');

INSERT INTO injury( iID, description )  
  VALUES('i16', 'unconscious');

INSERT INTO injury( iID, description )  
  VALUES('i17', 'Bullet wound in left shoulder');

INSERT INTO injury( iID, description )  
  VALUES('i18', 'Blurred eyesight');

INSERT INTO injury( iID, description )  
  VALUES('i19', 'Bent leg');

INSERT INTO injury( iID, description )  
  VALUES('i20', 'Disattached foot');
  
-- Patients --
INSERT INTO patient( pid, sid, iID )
  VALUES('p01', 's01', 'i01');

INSERT INTO patient( pid, sid, iID )
  VALUES('p02', 's02', 'i02');
  
INSERT INTO patient( pid, sid, iID )
  VALUES('p03', 's03', 'i03');
  
INSERT INTO patient( pid, sid, iID )
  VALUES('p04', 's04',  'i04');

INSERT INTO patient( pid, sid, iID )
  VALUES('p05', 's05', 'i05');

INSERT INTO patient( pid, sid, iID )
  VALUES('p06', 's06', 'i06');

INSERT INTO patient( pid, sid, iID )
  VALUES('p07', 's07', 'i07');

INSERT INTO patient( pid, sid, iID )
  VALUES('p08', 's08', 'i08');

INSERT INTO patient( pid, sid, iID )
  VALUES('p09', 's09', 'i09');

INSERT INTO patient( pid, sid, iID )
  VALUES('p10', 's10', 'i10');

INSERT INTO patient( pid, sid, iID )
  VALUES('p11', 's11', 'i11');

INSERT INTO patient( pid, sid, iID )
  VALUES('p12', 's12', 'i12');

INSERT INTO patient( pid, sid, iID )
  VALUES('p13', 's13', 'i13');

INSERT INTO patient( pid, sid, iID )
  VALUES('p14', 's14', 'i14');

INSERT INTO patient( pid, sid, iID )
  VALUES('p15', 's15', 'i15');

INSERT INTO patient( pid, sid, iID )
  VALUES('p16', 's16', 'i16');

INSERT INTO patient( pid, sid, iID )
  VALUES('p17', 's17', 'i17');

INSERT INTO patient( pid, sid, iID )
  VALUES('p18', 's18', 'i18');

INSERT INTO patient( pid, sid, iID )
  VALUES('p19', 's19', 'i19');

INSERT INTO patient( pid, sid, iID )
  VALUES('p20', 's20', 'i20');

-- Hospitals --
INSERT INTO hospitals( hid, bid, pid )
 VALUES('h01', 'b01', 'p01');
 
INSERT INTO hospitals( hid, bid, pid )
 VALUES('h02', 'b02', 'p02');
 
INSERT INTO hospitals( hid, bid, pid )
 VALUES('h03', 'b03', 'p03');
 
INSERT INTO hospitals( hid, bid, pid )
 VALUES('h04', 'b04', 'p04');
 
INSERT INTO hospitals( hid, bid, pid )
 VALUES('h05', 'b05', 'p05');

-- Missions --
INSERT INTO missions( mid, sid, depName, vid, wid, country, allyCountry, serviceYrs, description )
 VALUES('m01', 's02', 'Navy', 'v03', 'w03', 'Brazil', 'Puerto Rico', 3, 'Search for anything in area and act on situation. REPORT CURRENT EVENTS AFTER.' );

INSERT INTO missions( mid, sid, depName, vid, wid, country, allyCountry, serviceYrs, description )
 VALUES('m02', 's03', 'Army', 'v02', 'w06', 'Iraq', 'France', 5, 'Provide defense and service to local civilians' );

INSERT INTO missions( mid, sid, depName, vid, wid, country, allyCountry, serviceYrs, description )
 VALUES('m03', 's04', 'Air Force', 'v04', 'w05', 'India', 'Philippines', 2, 'Scout for suspecious activity in border of land' );

INSERT INTO missions( mid, sid, depName, vid, wid, country, allyCountry, serviceYrs, description )
 VALUES('m04', 's05', 'Air Force', 'v06', 'w01', 'Chile', 'Morocco', 7, 'Scout enemy land for suspecious activity' );

INSERT INTO missions( mid, sid, depName, vid, wid, country, allyCountry, serviceYrs, description )
 VALUES('m05', 's06', 'Army', 'v01', 'w08', 'Saudi Arabia', 'Canada', 5, 'Destroy enemy facility' );

INSERT INTO missions( mid, sid, depName, vid, wid, country, allyCountry, serviceYrs, description )
 VALUES('m06', 's07', 'Army', 'v01', 'w09', 'Saudi Arabia', 'Germany', 1, 'Destroy enemy facility');

INSERT INTO missions( mid, sid, depName, vid, wid, country, allyCountry, serviceYrs, description )
 VALUES('m07', 's08', 'Navy', 'v05', 'w10', 'Pacific Ocean', 'Mexico', 2, 'Scout for illegal activity and report results' );

INSERT INTO missions( mid, sid, depName, vid, wid, country, allyCountry, serviceYrs, description )
 VALUES('m08', 's09', 'Air Force', 'v02', 'w07', 'China', 'Japan', 3, 'Assist with bombarding enemy bases' );

INSERT INTO missions( mid, sid, depName, vid, wid, country, allyCountry, serviceYrs, description )
 VALUES('m09', 's10', 'Air Force', 'v06', 'w03', 'Russia', 'United Kingdom', 5, 'Defend against attacking air forces. DO NOT LET THEM ADVANCE ONTO HOME TERF' );

INSERT INTO missions( mid, sid, depName, vid, wid, country, allyCountry, serviceYrs, description )
 VALUES('m10', 's11', 'Navy', 'v05', 'w07', 'Spain', 'Australia', 10, 'Push the neighboring army of sailors back for more territory' );
-------------------------------------------------------------------------------------------------------------------------------------------------------
---- CREATE VIEW --------------------------------------------------------------
---------------------------------------------------------------------------
CREATE VIEW SoldierMissionDepartments AS 
     SELECT firstName, lastName, missions.depName as soldierDepartment
     FROM soldiers 
     INNER JOIN missions 
     ON soldiers.sid = missions.sid
ORDER BY lastName;

------------------------

CREATE VIEW HospitalLocation AS 
     SELECT name, stateUS, hospitals.hid as hospitalID
     FROM base 
     INNER JOIN hospitals 
     ON base.bid = hospitals.bid
ORDER BY hospitals.hid;

-------------------------

CREATE VIEW NonSickSoldiers AS 
     SELECT firstName, lastName, patient.pid as SoldierPatientID, healthy
     FROM soldiers 
     INNER JOIN patient 
     ON soldiers.sid = patient.sid
     Where healthy='Yes'
ORDER BY lastName;

-- select * from NonSickSoldiers;

--DROP VIEW NonSickSoldiers;
-----------------------------------------------------------------------------------------------------
--------- Reporting ---------------------------------------------
------------------------------------------------------------------------------------------------------
SELECT TRUNC ( 
   CAST( 
	( SELECT COUNT(age) AS soldiersTotal 
	  FROM soldiers 
	  INNER JOIN missions 
	  ON soldiers.sid = missions.sid 
	  WHERE age < 23 ) as decimal(5,2) ) 
	/
	( SELECT COUNT(sid) AS allSoldiersOnMission
	  FROM missions ) * 100 ) as Percent_Under_25

----------------------------------------------------------------------
SELECT TRUNC ( 
   CAST( 
	( SELECT COUNT(age) AS soldiersTotal 
	  FROM soldiers  
	  WHERE age > 30 ) as decimal(5,2) ) 
	/
	( SELECT COUNT(sid) AS allSoldiers
	  FROM soldiers ) * 100 ) as percent_over_30
-------------------------------------------------------------------------
------------------------------------------------------------------------
-------- Stored Procedure -----------------------------
--------------------------------------------------------------
CREATE OR REPLACE FUNCTION add_soldier() RETURNS trigger AS 
$BODY$
   BEGIN 
	IF NEW.healthy= 'Yes' THEN 
	     INSERT INTO soldiers(sid) VALUES (NEW.sid);
	END IF; 
	RETURN NEW; 
   END; 
$BODY$ 
LANGUAGE plpgsql; 
--------------------------------------------------------------------
CREATE OR REPLACE FUNCTION weaponsUsed (IN sid varchar(3)) 
RETURNS TABLE("First Name" text, "Last Name" text, “Gun” text) AS
$BODY$ 
BEGIN
	RETURN QUERY SELECT DISTINCT soldiers.firstName as first_name, soldiers.lastName as last_name, weapons.name as Gun
	FROM soldiers
	INNER JOIN missions
	ON soldiers.sid = missions.sid
	INNER JOIN weapons
	ON missions.wid = weapons.wid 
	WHERE weapons.wid IN ( SELECT weapons.wid
				FROM weapons);
END; 
$BODY$ 
LANGUAGE PLPGSQL;

select weaponsUsed('s01');

-----------------------------------------------------------------------------------
CREATE OR REPLACE FUNCTION vehicleUsed (IN sid varchar(3)) 
RETURNS TABLE("First Name" text, "Last Name" text, “Vehicle” text) AS
$BODY$ 
BEGIN
RETURN QUERY SELECT DISTINCT soldiers.firstName as first_name, soldiers.lastName as last_name, vehicles.vehicleType as Vehicle
	FROM soldiers
	INNER JOIN missions
	ON soldiers.sid = missions.sid
	INNER JOIN vehicles
	ON missions.vid = vehicles.vid 
	WHERE vehicles.vehicleType IN ( SELECT vehicles.vehicleType
					FROM vehicles);
END; 
$BODY$ 
LANGUAGE PLPGSQL;


select vehicleUsed('s01');
--------------------------------------------------------------------------
--------------------------------------------------------------
-----------------------TRIGGERS----------------------------------------
----------------------------------------------
CREATE TRIGGER add_soldier	
AFTER INSERT ON	soldiers	
FOR EACH ROW	
EXECUTE	PROCEDURE add_soldier();

INSERT INTO soldiers( sid, firstName, lastName, stateUS, ethnicity, gender, age, healthy )
  VALUES('s22', 'Doug', 'Rick', 'California','African American', 'Male', 40, 'null');

SELECT sid, healthy FROM soldiers;
---------------------------------------------------------------------------------------
----------------------------------------------------------------------
-----------------Security-------------------------------------------------------
----------------------------------------------
-- Marshall --
CREATE ROLE marshall;
GRANT ALL ON ALL TABLES
IN SCHEMA PUBLIC
TO marshall;

-- Cadets --
CREATE ROLE cadet;
GRANT SELECT ON soldiers, patient,
		base, weapons,
		vehicles, 
		hospitals 
		
TO cadet;
GRANT INSERT, UPDATE ON	soldiers, patient,
			base, weapons,
			vehicles, 
			hospitals 

TO cadet;

-- President --
CREATE ROLE President;
GRANT ALL ON ALL TABLES
IN SCHEMA PUBLIC
TO President;

SELECT mid, allyCountry, depName
FROM missions;