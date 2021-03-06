package com.example.erpkotlin.repositories

import com.example.erpkotlin.models.ItemItem
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface ItemRepository : JpaRepository<ItemItem, Long>, JpaSpecificationExecutor<ItemItem> {

    @Query(value = "SELECT * FROM item_items WHERE id=?1 AND status = TRUE ;", nativeQuery = true)
    fun getById(id: Int): ItemItem?

    @Query(value = "SELECT * FROM item_items AND  status = TRUE ;", nativeQuery = true)
    fun getAll(): List<ItemItem>

    fun findItemItemByNameStartingWith(name: String): List<ItemItem>?
}