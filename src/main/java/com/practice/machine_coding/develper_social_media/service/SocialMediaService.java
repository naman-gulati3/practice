package com.practice.machine_coding.develper_social_media.service;

import com.practice.machine_coding.develper_social_media.dto.Answer;
import com.practice.machine_coding.develper_social_media.dto.Question;
import com.practice.machine_coding.develper_social_media.dto.Topic;
import com.practice.machine_coding.develper_social_media.dto.User;
import com.practice.machine_coding.develper_social_media.dto.Votable;
import java.util.List;
import java.util.UUID;

public interface SocialMediaService {

  UUID postQuestion(User user, Question question);

  UUID postAnswer(User user, UUID questionId, Answer answer);

  int upVote(User user, Votable votable);

  int downVote(User user, Votable votable);

  List<Question> getFeed(User user, List<Topic> topicsToFilter);
}
