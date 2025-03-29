package com.practice.lld.stack_overflow;

public interface StackOverflow {

  int addUser(User user);

  int postQuestion(Question question);

  int addComment(int authorId, Question question);

  User loginUser(String username, char[] password);

  int addAnswer(Question question, Answer answer);

  int upvote(Answer answer, int vote);
}
