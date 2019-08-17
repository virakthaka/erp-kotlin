package com.example.erpkotlin.models

import com.example.erpkotlin.bases.BaseEntity
import com.fasterxml.jackson.annotation.JsonProperty
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "item_items")
data class ItemItem (

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id", nullable = false, unique = true)
        var id: Int? = 0,

        @Column(name = "item_template_id")
        var itemTemplateId: Int? = null,

        @Column(name = "name")
        var name: String? = null,

        @Column(name = "code")
        var code: String? = null,

        @Column(name = "barcode")
        var barcode: String? = null,

        @Column(name = "extra_price")
        var extraPrice: Float? = 0.00f,

        @Column(name = "extra_cost")
        var extraCost: Float? = 0.00f,

        @Column(name = "sale_total")
        var saleTotal: Float? = 0.00f,

        @Column(name = "on_hand_quantity")
        var onHandQuantity: Int? = 0,

        @Column(name = "forecast_quantity")
        var forecastQuantity: Int? = 0,

        @Column(name = "note")
        var note: String? = null,

        override var createdAt: Date? = null,

        override var updatedAt: Date? = null,

        @Transient
        @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
        var attribute: String? = null

//        @ManyToMany(cascade = [CascadeType.ALL])
//        @JoinTable(
//                name = "item_item_item_attribute_rel",
//                joinColumns = [JoinColumn(name = "item_item_id", referencedColumnName = "id")],
//                inverseJoinColumns = [JoinColumn(name = "item_attribute_id", referencedColumnName = "id")])
//        var itemAttributes: List<ItemAttribute> = mutableListOf<ItemAttribute>()

): BaseEntity() {
        constructor(id: Int):this(id,null)
}