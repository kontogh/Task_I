"# Task_I" 

SQl Script file with name sql_scrpt.sql to create database and table is attached in the same folder. 
Also URL, password and username in the application.properties file need to be reset. Application is 
deployed under port 8888, that also can be changed in properties file.

Endpoint for persisting csv content: api/recordentity. Using Postman to post the file in the body, 
under form-data checkbox in the KEY column should be value of "file1" and in the column Value a file 
can be added. If primary key whoud be repeated in other trials the the record with that PK will be updated. 

REQ-02 To get persited record by PK was made endpoint api/ recordentity that accept 1 or more 
parameters like: api/ recordentity?primaryKey=2 or api/ recordentity?primaryKey=2,3,4 

REQ-03 To delete persited record by PK was made endpoint 
api/ recordentity?primaryKey=value 

REQ-04 Records in the csv file that do not have PK will be ommited. Since updated_timestampt does 
not have to be present, if it is not valid with ISO8601 it won't be persisted in the column.
