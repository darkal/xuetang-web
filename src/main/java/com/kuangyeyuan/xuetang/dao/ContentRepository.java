package com.kuangyeyuan.xuetang.dao;

import com.kuangyeyuan.xuetang.entity.ContentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Darkal on 2016/6/22.
 * 汇总Repository
 */
@Repository
public interface ContentRepository extends JpaRepository<ContentEntity,Integer> {

//    @Query("select s from SummaryEntity s where s.id.date=?1")
//    List<SummaryEntity> findByDate(Date date);

    @Query("select s,c from ContentEntity s,CateEntity c where s.cateId=c.id and s.id=?1 and s.deleted = false order by s.sequence")
    Object[] findOneWithCate(int id);

    @Query(value = "select * from content_entity s where s.deleted = false and MATCH (title,author,content) AGAINST (?1)",nativeQuery = true)
    List<ContentEntity> searchContent(String keyword);

    @Query("select s,c from ContentEntity s,CateEntity c where s.cateId=c.id and s.deleted = false order by s.createTime")
    List<Object> findAllByTimeWithCate();

    @Query("select s from ContentEntity s where s.deleted = false order by s.sequence")
    List<ContentEntity> findAllBySequence();

    @Query("select s from ContentEntity s where s.type = 'list' and s.deleted = true order by s.sequence")
    List<ContentEntity> findAllWithVersion1();

    @Query("select s from ContentEntity s where s.cateId=?1 and s.deleted = false order by s.sequence")
    List<ContentEntity> findByCateId(int cateId);

    @Query("select s from ContentEntity s where s.contentCateId=?1 and s.deleted = false order by s.sequence")
    List<ContentEntity> findByContentCateId(int cateId);

    @Query("select s from ContentEntity s,CateEntity c where s.cateId=c.id and s.deleted = false and c.type=?1 order by s.sequence")
    List<ContentEntity> findByType(String type);

    @Transactional
    @Modifying
    @Query("update ContentEntity s set view_count=s.viewCount+1 where s.id=?1")
    void addViewCount(Integer id);

    @Transactional
    @Modifying
    @Override
    @Query("update ContentEntity s set deleted=true where s.id=?1")
    void delete(Integer id);
}
