Install below mentioned software 

1. Install Java 1.8.0_271
2. Install Android Studio # if you are running the scripts in Emulator
3. Install Appium Desktop version 1.15.1
4. Install Eclipse
5. Install TestNg for Eclipse
6. Install Selenium Server JAR
7. Appium Client Library
8. Chrome driver - Save it in local folder
9. Download maven latest verison -> UnZip and save it in local folder
10. Download Jenkins.war file

Environment Variable
Go to Path variable
1. Add the chrome driver local path 
2. Add Maven library
	Open command prompt (cmd)
		run --> mvn -v (maven version details and associated java version displayed)

Libraries imported
1. TestNG
2. Selenium – Java
3. Extends Reports
4. Common –IO
5. Log4J
6. Java – Client

Git Configuration
1. Open Eclispe
2. File -> Import -> Git -> Project from Git
3. Tap on clone URL -> Enter the Git URL taken from the repository
4. Tap on Finish

Project Configuration 
By default project will be build once it is imported. if incase of any issues due to network firewall few of the libraries would not download. Hence do below manual update
Right click the Project -> Go to Maven -> Update Project (Download the dependencies from the pom.xml.) 

TestRunner.xml
TestRunner file is a testng xml file where the type of configuration mentioned eg(mobile/web). configurations are taken from this file to the Test scripts

Test Reports
HTML report is generated for each execution and saved the same in src/reports folder 

Jenkins CICD(Framework capable of jenkins CICD)


Note: Appium desktop should be running on the jenkins machine
1. Open command prompt in jenkins.war file location 
2. Run -> java -jar jenkins.war command
3. Go to browser -> http://localhost:8080
4. By default the credentials are admin, admin
5. Create a Maven Project - > configuration -> add pom.xml in Build section
	ROOT POM -> path of pom xml
	Goal and options -> clean test
6. Apply the changes
7. Tap on Build Now
