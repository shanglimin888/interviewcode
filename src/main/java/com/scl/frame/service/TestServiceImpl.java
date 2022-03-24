package com.scl.frame.service;

import com.scl.frame.dao.TestMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @description:
 * @author: shanglimin888@163.com
 * @time: 2021/11/24 16:22
 */
@Service
public class TestServiceImpl implements TestService {

    @Autowired
    private TestMapper tsmapper;

    @Override
    public List<Map<String, Object>> getUsers() {
        return tsmapper.getlist();
    }
}