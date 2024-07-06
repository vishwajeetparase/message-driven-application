# Message-driven-application
Simple message-driven application in core Java that simulates a producer-consumer scenario using a message queue.


# Instructions to Run the Application and Tests:

Compile the Java files: Open a terminal in the project directory and run the following command to compile the Java files:
```
javac -cp .:log4j-1.2.17.jar message-driven-application/src/main/java/com/message/message_driven_application/*.java
```
Replace `log4j-1.2.17.jar` with the path to your log4j JAR file.

Run the Main class: Still in the terminal, run the following command to start the application:
```
java -cp .:log4j-1.2.17.jar message-driven-application/src/main/java/com/message/message_driven_application/Main
```

This will start the producer and consumer threads, and they will begin processing messages.

Running the Tests: To run the tests, if you’re using an IDE like IntelliJ IDEA or Eclipse, they have built-in support for running JUnit tests. Right-click on the test class or method and select ‘Run Test’.

Remember to check the `application.log` file after running the application and tests to see the logs from the producer and consumer. 

