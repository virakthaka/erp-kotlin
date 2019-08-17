package com.example.erpkotlin.repositories

import com.example.erpkotlin.models.StockWarehouse
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface StockWarehouseRepository : JpaRepository<StockWarehouse, Int>