package com.scl.frame.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @description:
 * @author: shanglimin888@163.com
 * @time: 2021/11/24 16:22
 */
@Mapper
public interface TestMapper {

    @Select("select * from tb_user")
    public List<Map<String,Object>> getlist();
}
