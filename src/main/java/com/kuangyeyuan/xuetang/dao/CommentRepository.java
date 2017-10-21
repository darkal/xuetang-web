package com.kuangyeyuan.xuetang.dao;

import com.kuangyeyuan.xuetang.entity.CateEntity;
import com.kuangyeyuan.xuetang.entity.CommentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Darkal on 2016/6/20.
 */



@Repository
public interface CommentRepository extends JpaRepository<CommentEntity,Integer> {

//    List<VisitCountEntity> findByVisitCountPK

    @Query("select c from CommentEntity c where c.deleted = false order by time desc")
    List<CommentEntity> findAllDesc();

    @Query("select c from CommentEntity c where c.videoId=?1 and c.top=0 and c.deleted = false order by top desc ,time desc")
    List<CommentEntity> findAllNormalComment(Integer videoId);

    @Query("select c from CommentEntity c where c.videoId=?1 and c.top=1 and c.deleted = false order by top desc ,time desc")
    List<CommentEntity> findAllTopComment(Integer videoId);

    @Query("select count(1) from CommentEntity c where c.videoId=?1 and c.deleted = false")
    int findAllCommentNum(Integer videoId);

    @Transactional
    @Modifying
    @Query("update CommentEntity c set deleted=true where c.id=?1")
    void delete(Integer id);

    @Transactional
    @Modifying
    @Query("update CommentEntity c set top=true where c.id=?1")
    void top(Integer id);
}