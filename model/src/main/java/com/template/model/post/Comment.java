package com.template.model.post;

import com.template.model.user.User;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by yusufaslan on 30.05.2017.
 */
@Entity
@NoArgsConstructor
@Data
public class Comment {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String commentBody;

  @ManyToOne
  @JoinColumn(name = "comment_sender_id")
  private User commentSender;

  private Date commentDate;
  @ManyToOne
  @JoinColumn(name = "comment_post_id")
  private Post commentOfPost;

}