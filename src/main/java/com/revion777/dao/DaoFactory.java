package com.revion777.dao;

import java.io.Serializable;
import java.util.List;

/**
 * Фабрика объектов для работы с базой данных
 * Унифицированный интерфейс управления персистентным состоянием объектов
 * @param <T> тип объекта персистенции
 * @param <PK> тип первичного ключа
 */
public interface DaoFactory<T, PK extends Serializable> {

    /** Возвращает объект соответствующий записи с первичным ключом key или null */
    public T findById(int key);

    /** Создает новую запись и соответствующий ей объект */
    public void save(T object);

    /** Сохраняет состояние объекта в базе данных */
    public void update(T object);

    /** Удаляет запись об объекте из базы данных */
    public void delete(T object);

/*    *//** Возвращает список объектов соответствующих Object записям в базе данных *//*
    public T findObjectById(int key);*/

    /** Возвращает список объектов соответствующих всем записям в базе данных */
    public List<T> findAll();
}