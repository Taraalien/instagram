package com.kurdsoft.instagram.follower;


import com.kurdsoft.instagram.common.base.BaseEntity;
import com.kurdsoft.instagram.user.User;
import lombok.Data;
import org.hibernate.envers.Audited;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "tbl_follower")
@Audited
public class Follower extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
