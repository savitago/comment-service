package com.example.demo.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



@FeignClient(name = "like-service")
public interface LikeFeign {
    @GetMapping("/postsOrComments/{postOrCommentId}/likes/count")
    Integer getLikesCount(@PathVariable("postOrCommentId") String postOrCommentId);
}
