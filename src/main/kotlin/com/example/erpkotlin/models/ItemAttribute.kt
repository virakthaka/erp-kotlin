package com.example.erpkotlin.models

import javax.persistence.*

@Entity
@Table(name = "item_attributes")
data class ItemAttribute (

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id", nullable = false, unique = true)
        var id: Int? = 0,

        @Column(name = "name")
        var name: String? = null,

        @Column(name = "value")
        var value: String? = null
//        @ManyToMany(mappedBy = "itemAttributes")
//        var itemItems: List<ItemItem> = mutableListOf<ItemItem>()
)