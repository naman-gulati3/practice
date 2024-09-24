- Flipkart is starting a new question answer platform for developers. In this social media platform,
  we will enable users to ask any tech related questions and get some awesome answers.

Features:
Signup for new users and create a profile having some user details like name, profession etc.
Users should be able to login/logout. (For simplicity you can assume only one user can be logged in
at a time)
Users can subscribe/unsubscribe from topics (like ‘java’, python etc..).
Users should be able to filter their feeds on topics.
Users should be able to view details of a single question and their responses. Questions should have
basic information such as user / topics / timestamp.
Users can ask questions which must be attached to at least one topic. They can attach any number of
topics to the questions. Users can answer questions only if they have subscribed to that topic to
which the question belongs.
Only logged in users can ask and answer questions / but any user can view questions
Bonus:
Users can upvote questions/answers only if they have subscribed to that topic to which the question
belongs.
Responses to the questions are sorted based on number of votes
Other Notes:
Do not use any database or NoSQL store, use in-memory data-structure for now.
Do not create any UI for the application.
Write a driver class for demo purposes. Which will execute all the commands at one place in the code
and have test cases to test multiple users.
Please prioritize code compilation, execution and completion.
Work on the expected output first and then add good-to-have features of your own.
Solution provided:
I created three model classes - User, Question and Answer. I also created repository classes and
service classes to keep everything seperate. I created other classes too like constants to keep all
the constants, exception classes to keep track of all types of exceptions and utils class to help
print results in the Driver class.

Overall, this round went well and I got call for the next round. I used the singleton design pattern
in this due to the time constraints. We were allowed to use external packages like lombok, but I
tried to keep it simple.

Moreover, I missed some edge cases like the NullPointerException in case of null name and null
question, which the reviewer pointed out. Besides this, he was fine with the code. My code was
working and I was able to implement all the features. I also implemented all the test cases in the
Driver class, which smoothened my review process.

