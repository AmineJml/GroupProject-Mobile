# GroupProject-Mobile - Retweet
This project is done by Chloe Gemayel and Amine Jamal
Chloe Gemayel repo:
Amine Jamal repo:

<h2>Description
Retweet is a free social networking mobile app that allows users to share brief updates called tweet.
These tweets just include short text.

<h2>Stacks
PHP - Android Studio/Java 

<h2>SQL
<h4>Database retweetdb
<h5>Table structure for table tweets
Column	Type	Null	Default
User_id	int(255)	No	
Tweet_id	int(255)	No	
Is_deleted	bit(1)	No	
Tweet	varchar(255)	No	
Like_count	int(255)	No

<h5>Dumping data for table tweets
1	15	0	The greatest glory in living lies not in never falling, but in rising every time we fall. -Nelson Mandela	0
21	18	0	The way to get started is to quit talking and begin doing. -Walt Disney	0
22	19	1	Your time is limited, so don't waste it living someone else's life. Don't be trapped by dogma – which is living with the results of other people's thinking. -Steve Jobs	0
1	21	0	If life were predictable it would cease to be life, and be without flavor. -Eleanor Roosevelt	0

<h5>Table structure for table users
Column	Type	Null	Default
User_id	int(255)	No	
FName	varchar(25)	No	
LName	varchar(25)	No	
Username	varchar(25)	No	
Password	varchar(25)	No	

<h5>Dumping data for table users
1	Joe	Doe	Joe	123
21	Amine	Jamal	amine	password123
22	Alex	Bitar	Alexb	pass123
24	Amine	Jamal	AmineJ	123

<h2>Postman APIs
 Please find the test of each API in the following link https://orange-satellite-481308.postman.co/workspace/My-Workspace~08470639-accc-41c1-8f0d-0fd5d721de25/collection/23599479-a8c1452e-133f-45c3-9e40-10d528a97ce9?action=share&creator=23599479
 
