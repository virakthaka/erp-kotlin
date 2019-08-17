package com.example.erpkotlin.bases

import org.springframework.data.domain.Page

interface BaseService<T> {
    fun findAllList(q: String?, page: Int, size: Int): Page<T>?
    fun findById(id: Int): T?
    fun addNew(t: T): T?
    fun updateObj(id: Int, t: T): T?
    fun findAll(): List<T>?
}