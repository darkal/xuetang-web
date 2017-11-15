package com.kuangyeyuan.xuetang.dao;

import com.kuangyeyuan.xuetang.entity.TopSearch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;


/**
 * Created by Darkal on 2016/6/20.
 */

@Repository
public interface TopSearchRepository extends JpaRepository<TopSearch,Integer> {
    TopSearch findByText(String text);

    @Transactional
    @Modifying
    @Query("update TopSearch s set s.count=s.count+1 where s.id=?1")
    void addViewCount(Integer id);
}