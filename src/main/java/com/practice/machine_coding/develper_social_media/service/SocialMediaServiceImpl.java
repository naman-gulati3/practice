package com.practice.machine_coding.develper_social_media.service;

import com.practice.machine_coding.develper_social_media.dto.Answer;
import com.practice.machine_coding.develper_social_media.dto.Question;
import com.practice.machine_coding.develper_social_media.dto.Topic;
import com.practice.machine_coding.develper_social_media.dto.User;
import com.practice.machine_coding.develper_social_media.dto.Votable;
import com.practice.machine_coding.develper_social_media.repository.QuestionAnswerRepository;
import com.practice.machine_coding.develper_social_media.repository.UserRepository;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.UUID;

public class SocialMediaServiceImpl implements SocialMediaService {

  private final UserRepository userRepository;

  private final QuestionAnswerRepository questionAnswerRepository;

  public SocialMediaServiceImpl(UserRepository userRepository,
      QuestionAnswerRepository questionAnswerRepository) {
    this.userRepository = userRepository;
    this.questionAnswerRepository = questionAnswerRepository;
  }

  @Override
  public UUID postQuestion(User loggedInUser, Question question) {
//    validateIfLoggedIn(question.getPublishedBy().getId());
    return this.questionAnswerRepository.addQuestion(question);

  }

  @Override
  public UUID postAnswer(User loggedInUser, UUID questionId, Answer answer) {
//    validateIfLoggedIn(answer.posedBy().getId());
    return this.questionAnswerRepository.postAnswer(questionId, answer);

  }

  @Override
  public int upVote(User user, Votable votable) {
//    validateIfLoggedIn(user.getId());
    return votable.upvote();
  }

  @Override
  public int downVote(User user, Votable votable) {
//    validateIfLoggedIn(user.getId());
    return votable.downVote();
  }

  @Override
  public List<Question> getFeed(User user, List<Topic> topicsToFilter) {
    List<Question> questions = new ArrayList<>();

    if (user != null) {
      List<Topic> userSubscribedTopics = topicsToFilter.stream()
          .filter(t -> user.getSubscribedTopics().contains(t)).toList();

      questions = this.questionAnswerRepository.getQuestionsByTopic(
          userSubscribedTopics);
    } else {
      questions = this.questionAnswerRepository.getQuestionsByTopic(
          topicsToFilter);
    }

    questions.sort(Comparator.comparingInt(Question::upvote));
    return questions;
  }

//  private void validateIfLoggedIn(int userId) {
//    Optional<User> userFromStore = userRepository.getUserById(userId);
//    if (userFromStore.isEmpty()) {
//      throw new IllegalArgumentException(
//          "User with id: %s does not exist".formatted(userId));
//    }
//    if (userFromStore.get().isLoggedOut()) {
//      throw new IllegalArgumentException(
//          "User: %s should be logged for posting answer".formatted(
//              userId));
//    }
//  }
}
