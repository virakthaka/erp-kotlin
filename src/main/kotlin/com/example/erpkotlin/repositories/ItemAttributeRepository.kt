package com.example.erpkotlin.repositories

import com.example.erpkotlin.models.ItemAttribute
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface ItemAttributeRepository : JpaRepository<ItemAttribute, Long>{
    @Query(value = "SELECT * FROM item_attributes WHERE id=?1 AND status = TRUE ;", nativeQuery = true)
    fun getById(id: Int): ItemAttribute?

    @Query(value = "SELECT * FROM item_attributes AND  status = TRUE ;", nativeQuery = true)
    fun getAll(): List<ItemAttribute>
}