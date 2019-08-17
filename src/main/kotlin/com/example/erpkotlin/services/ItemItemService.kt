package com.example.erpkotlin.services

import com.example.erpkotlin.bases.BaseService
import com.example.erpkotlin.models.ItemItem
import org.springframework.stereotype.Service

@Service
interface ItemItemService:BaseService<ItemItem> {
    fun findItemItemByNameStartingWith(name: String) : List<ItemItem>?
}