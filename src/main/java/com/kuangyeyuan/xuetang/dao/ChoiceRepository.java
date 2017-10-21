package com.kuangyeyuan.xuetang.dao;

import com.kuangyeyuan.xuetang.entity.ChoiceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by darkal on 2017/8/29
 */
@Repository
public interface ChoiceRepository extends JpaRepository<ChoiceEntity,Integer> {
}
