package com.example.erpkotlin.models

import com.fasterxml.jackson.annotation.JsonProperty
import javax.persistence.*

@Entity
@Table(name = "item_templates")
data class ItemTemplate (

        @Id
        @Column(name = "id")
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Int? = null,

        @Column(name = "name", length = 50)
        var name: String? = null,

        @Column(name = "code", length = 50)
        var code: String? = null,

        @Column(name = "barcode", length = 12)
        var barcode: Int? = null,

        @Column(name = "standard_price")
        var standardPrice: Float? = null,

        @Column(name = "standard_cost")
        var standardCost: Float? = null,

        @get:JsonProperty("isSale")
        @Column(name = "is_sale")
        var isSale: Boolean? = null,

        @Column(name = "item_type_id")
        var itemTypeId: Int? = null,

        @Column(name = "item_category_id")
        var itemCategoryId: Int? = null,

        @Column(name = "sold_total")
        var soldTotal: Int? = null,

        @OneToMany(cascade = [CascadeType.ALL], orphanRemoval = true)
        @JoinColumn(name = "item_template_id")
        var itemItems: Set<ItemItem>? = null
)