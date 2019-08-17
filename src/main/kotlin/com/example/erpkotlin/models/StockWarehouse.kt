package com.example.erpkotlin.models

import com.example.erpkotlin.bases.BaseEntity
import javax.persistence.*

@Entity
@Table(name = "stock_warehouse")
data class StockWarehouse (

        @Id
        @Column(name = "id")
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Int? = null,

        @Column(name = "name", length = 50)
        var name: String? = null,
        
        @Column(name = "address", length = 200)
        var address: String? = null,
        
        @Column(name = "company_id")
        var companyId: Int? = null

): BaseEntity() {
        constructor(id: Int):this(id,null)
}