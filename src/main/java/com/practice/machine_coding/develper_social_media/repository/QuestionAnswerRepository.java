package com.practice.machine_coding.develper_social_media.repository;

import com.practice.machine_coding.develper_social_media.dto.Answer;
import com.practice.machine_coding.develper_social_media.dto.Question;
import com.practice.machine_coding.develper_social_media.dto.Topic;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class QuestionAnswerRepository {

  private final Map<Topic, List<Question>> questionsByTopic;

  private final Map<UUID, List<Answer>> answersByQuestion;

  public QuestionAnswerRepository() {
    this.questionsByTopic = new ConcurrentHashMap<>();
    this.answersByQuestion = new ConcurrentHashMap<>();
  }

  public UUID addQuestion(Question question) {
    for (Topic topic : question.getTopics()) {
      List<Question> topicWiseQuestions =
          questionsByTopic.getOrDefault(topic, new ArrayList<>());

      topicWiseQuestions.add(question);
      questionsByTopic.put(topic, topicWiseQuestions);
    }
    return UUID.randomUUID();
  }


  public List<Question> getQuestionsByTopic(List<Topic> topics) {
    List<Question> questions = new ArrayList<>();
    if (topics.isEmpty()) {
      for (List<Question> topicWiseQuestions : questionsByTopic.values()) {
        questions.addAll(topicWiseQuestions);
      }
    } else {
      for (var entry : questionsByTopic.entrySet()) {
        if (topics.contains(entry.getKey())) {
          questions.addAll(entry.getValue());
        }
      }
    }

    return questions;
  }

  public UUID postAnswer(UUID questionId, Answer answer) {
    List<Answer> answers = this.answersByQuestion.getOrDefault(questionId,
        new ArrayList<>());

    answers.add(answer);

    this.answersByQuestion.put(questionId, answers);

    for (Topic topic : answer.question().getTopics()) {
      this.questionsByTopic.get(topic).forEach(q -> q.addAnswer(answer));
    }

    return UUID.randomUUID();
  }
}
