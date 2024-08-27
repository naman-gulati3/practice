package com.practice.lld.linkedin;

import java.time.Instant;
import java.util.List;

public record JobPosting(String id, String title, String description, List<String> requirements,
                         String location, Instant postedAt) {

}
