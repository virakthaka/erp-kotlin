package com.example.erpkotlin.repositories

import com.example.erpkotlin.models.StockChangeItemQuantity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface StockChangeItemQuantityRepository : JpaRepository<StockChangeItemQuantity, Int>