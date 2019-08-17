package com.example.erpkotlin.models

import com.example.erpkotlin.bases.BaseEntity
import javax.persistence.*

@Entity
@Table(name = "stock_change_item_quantities")
data class StockChangeItemQuantity (

        @Id
        @Column(name = "id")
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private var id: Int? = null,

        @Column(name = "item_id")
        var itemId: Int? = null,

        @Column(name = "new_qty")
        var newQty: Int? = null,

        @Column(name = "stock_warehouse_id")
        var stockWarehouseId: Int? = null

): BaseEntity() {
        constructor(id: Int):this(id,null)
}