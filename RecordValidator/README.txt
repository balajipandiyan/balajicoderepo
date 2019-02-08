Assumption :

Test files should be kept in data folder of current user directory(../data)

Names of the test files have to be passed as command line arguments, provide space between each file names.(eg records.csv records.xml)

To Run program just import this project in eclipse or intellij and run as java application.

Created PrintStream to print the valaidation output to a specific file instead printing it in console.


Implementation: 

1)Created an Interface reader.Based on Implementation filetype we have to create implementation for each file type.Made the varaibles as final so that it state cant be 
changed amd makes it immutable.
2)Used JAXB to read XML file or unmarshalling for XML reader.Used  valueof commads to convert the value to integer or float so that memory will not be wasted.Duplicate 
validation done in processing the data.Good records are stored in HashMap.
3)CAV is flat file parsing.Duplicate validation done in processing the data.Good records are stored in HashMap.
4)Main class will call respective readers based on file extension.HashMap will have set of unique records.
5)Streamed the data from HashMap using Lamda expression and did the balance validation check by comparing end balance with adding start ballance and mutation, collected the balance mismatch records.

Output:

OutPut file will be generated in out folder of project directory,it will have list of records that failed validation and cause of validation failure.



