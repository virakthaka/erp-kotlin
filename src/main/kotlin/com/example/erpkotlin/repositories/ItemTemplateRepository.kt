package com.example.erpkotlin.repositories

import com.example.erpkotlin.models.ItemTemplate
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface ItemTemplateRepository : JpaRepository<ItemTemplate, Long>,JpaSpecificationExecutor<ItemTemplate> {

    @Query(value = "SELECT * FROM item_templates WHERE id=?1 AND status = TRUE ;", nativeQuery = true)
    fun getById(id: Int): ItemTemplate?

    @Query(value = "SELECT * FROM item_templates AND  status = TRUE ;", nativeQuery = true)
    fun getAll(): List<ItemTemplate>
}
