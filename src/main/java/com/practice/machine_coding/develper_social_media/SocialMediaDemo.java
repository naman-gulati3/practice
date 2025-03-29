package com.practice.machine_coding.develper_social_media;

import com.practice.machine_coding.develper_social_media.dto.Answer;
import com.practice.machine_coding.develper_social_media.dto.Question;
import com.practice.machine_coding.develper_social_media.dto.Topic;
import com.practice.machine_coding.develper_social_media.dto.User;
import com.practice.machine_coding.develper_social_media.repository.QuestionAnswerRepository;
import com.practice.machine_coding.develper_social_media.repository.UserRepository;
import com.practice.machine_coding.develper_social_media.service.SocialMediaService;
import com.practice.machine_coding.develper_social_media.service.SocialMediaServiceImpl;
import com.practice.machine_coding.develper_social_media.service.UserService;
import com.practice.machine_coding.develper_social_media.service.UserServiceImpl;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

public class SocialMediaDemo {

  public static void main(String[] args) {
    QuestionAnswerRepository questionAnswerRepository = new QuestionAnswerRepository();
    UserRepository userRepository = new UserRepository();

    UserService userService = new UserServiceImpl(userRepository);
    SocialMediaService socialMediaService =
        new SocialMediaServiceImpl(userRepository, questionAnswerRepository);

    User user1 = new User("Naman", "Software Engineer");
    User user2 = new User("xyz", "Plumber");
    User user3 = new User("manager", "Product Manager");
    userService.signUp(user1);
    userService.signUp(user2);
    userService.signUp(user3);

    List<Topic> topics = new ArrayList<>();
    Topic javaTopic = new Topic("Java");
    topics.add(javaTopic);
    topics.add(new Topic("Python"));

    userService.login(user1);

    Question question =
        new Question(user1, "What are java collections?", Instant.now(), List.of(javaTopic));
    UUID questionId = socialMediaService.postQuestion(user1, question);

    Answer answer = new Answer(question, user2, Instant.now());
    UUID answerId = socialMediaService.postAnswer(user2, questionId, answer);

    System.out.println(socialMediaService.getFeed(null, Collections.emptyList()));

    socialMediaService.upVote(user1, question);
    socialMediaService.upVote(user3, question);

    System.out.println(socialMediaService.getFeed(null, Collections.emptyList()));
  }
}
