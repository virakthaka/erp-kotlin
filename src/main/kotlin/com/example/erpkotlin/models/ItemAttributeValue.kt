package com.example.erpkotlin.models

import javax.persistence.*

@Entity
@Table(name = "item_attributes")
data class ItemAttributeValue (

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id", nullable = false, unique = true)
        var id: Int? = 0,

        @Column(name = "attribute_id")
        var attributeId: String? = null,

        @Column(name = "value")
        var value: String? = null
)