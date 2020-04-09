package com.zhongyi.dao.impl;

import com.zhongyi.dao.IBaseDao;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import javax.annotation.Resource;
import java.lang.reflect.ParameterizedType;
import java.util.List;

public class BaseDao<T> implements IBaseDao<T> {
    private SqlSessionFactory sqlSessionFactory;
    @Resource
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    protected SqlSession openSession() {
        return sqlSessionFactory.openSession();
    }

    private Class<?> clz;
    private Class<?> getClz() {
        if(clz == null) {
            clz = (Class<?>)((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        }
        return clz;
    }

    @Override
    public void add(T t) {
        openSession().insert(getClz().getName() + ".add", t);
    }

    @Override
    public void delete(int id) {
        openSession().delete(getClz().getName() + ".delete", id);
    }

    @Override
    public void update(T t) {
        openSession().update(getClz().getName() + ".update", t);
    }

    @Override
    public T select(String id) {
        // TODO Auto-generated method stub
        return openSession().selectOne(getClz().getName() + ".select", id);
    }

    @Override
    public List<T> list() {
        // TODO Auto-generated method stub
        return openSession().selectList(getClz().getName() + ".list");
    }
}
