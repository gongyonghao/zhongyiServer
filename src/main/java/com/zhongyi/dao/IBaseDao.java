package com.zhongyi.dao;

import java.util.List;

public interface IBaseDao<T> {
    public void add(T t);
    public void delete(int id);
    public void update(T t);
    public T select(String id);
    public List<T> list();
}
