package com.practice.dsa.greedy;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class NMeetingsInOneRoom {

  public static class Meeting {

    private final int startTime;
    private final int endTime;
    private final int position;

    public Meeting(int startTime, int endTime, int position) {
      this.startTime = startTime;
      this.endTime = endTime;
      this.position = position;
    }
  }

  public static int maxMeetings(int[] start, int[] end, int n) {
    List<Meeting> meetings = new ArrayList<>();
    List<Integer> answer = new ArrayList<>();

    for (int i = 0; i < n; i++) {
      meetings.add(new Meeting(start[i], end[i], i + 1));
    }

    meetings.sort(Comparator.comparingInt(m -> m.endTime));
    answer.add(meetings.get(0).position);
    int limit = meetings.get(0).endTime;

    for (int i = 1; i < n; i++) {
      Meeting meeting = meetings.get(i);
      if (meeting.startTime > limit) {
        limit = meeting.endTime;
        answer.add(meeting.position);
      }
    }
    return answer.size();
  }

  public static void main(String[] args) {
    // 1, 3, 0, 5, 8, 5
    // 2, 4, 6, 7, 9, 9
    System.out.println(maxMeetings(new int[]{1, 3, 0, 5, 8, 5}, new int[]{2, 4, 6, 7, 9, 9}, 6));
  }
}
