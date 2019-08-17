package com.example.erpkotlin.models

import com.example.erpkotlin.bases.BaseEntity
import javax.persistence.*

@Entity
@Table(name = "stock_move")
data class StockMove (

        @Id
        @Column(name = "id")
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Int? = null,

        @Column(name = "name", length = 50)
        var name: String? = null,

        @Column(name = "item_id")
        var itemId: Int? = null,

        @Column(name = "item_qty")
        var itemQty: Int? = null,

        @Column(name = "note", length = 500)
        var note: String? = null,

        @Column(name = "state", length = 10)
        var state: String? = null,

        @Column(name = "is_refund")
        var is_refund: Boolean? = null

): BaseEntity() {
        constructor(id: Int):this(id,null)
}