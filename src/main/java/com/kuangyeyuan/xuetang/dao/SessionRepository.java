package com.kuangyeyuan.xuetang.dao;

import com.kuangyeyuan.xuetang.entity.SessionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * Created by Darkal on 2016/6/20.
 */

@Repository
public interface SessionRepository extends JpaRepository<SessionEntity,Integer> {

    @Query("select c.openid from SessionEntity c where c.session=?1")
    String findOpenId(String session);

    @Query("select c from SessionEntity c where c.session=?1")
    SessionEntity findBySession(String session);
}