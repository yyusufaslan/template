package com.template.model.post;

import com.template.model.user.User;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by yusufaslan on 30.05.2017.
 */
@Entity
@NoArgsConstructor
@Data
public class Post implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String postBody;

    private String postImage;

    private Date postDate;

    @ManyToOne
    @JoinColumn(name = "post_sender_id")
    private User postSender;

}