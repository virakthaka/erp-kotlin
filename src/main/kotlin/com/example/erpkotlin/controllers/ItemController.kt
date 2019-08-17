package com.example.erpkotlin.controllers

import com.example.erpkotlin.models.ItemAttribute
import com.example.erpkotlin.models.ItemItem
import com.example.erpkotlin.models.ItemTemplate
import com.example.erpkotlin.repositories.ItemAttributeRepository
import com.example.erpkotlin.repositories.ItemRepository
import com.example.erpkotlin.repositories.ItemTemplateRepository
import com.example.erpkotlin.services.ItemAttributeService
import com.example.erpkotlin.services.ItemItemService
import com.example.erpkotlin.services.ItemTemplateService
import com.example.erpkotlin.utils.ResponseObjectMap
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/item")
class ItemController {

    @Autowired
    lateinit var itemItemService: ItemItemService

    @Autowired
    lateinit var itemTemplateService: ItemTemplateService

    @Autowired
    lateinit var itemAttributeService: ItemAttributeService



    private val response = ResponseObjectMap()

    @GetMapping("/item.template")
    fun findAllItemTemplate(): MutableMap<String, Any> = response.responseObject(itemTemplateService.findAll())

    @PostMapping("/item.template")
    fun createItemTemplate(@RequestBody itemTemplate: ItemTemplate): MutableMap<String, Any> = response.responseObject(itemTemplateService.addNew(itemTemplate))

    @PutMapping("/item.template")
    fun updateAccountType(@PathVariable id:Int, @RequestBody itemTemplate: ItemTemplate): MutableMap<String,Any> = response.responseObject(itemTemplateService.updateObj(id, itemTemplate))

    @GetMapping("/item.attribute")
    fun findAllItemAttribute(): MutableMap<String, Any> = response.responseObject(itemAttributeService.findAll())

    @PostMapping("/item.attribute")
    fun createItemAttribute(@RequestBody itemAttribute: ItemAttribute): MutableMap<String, Any> = response.responseObject(itemAttributeService.addNew(itemAttribute))

    @GetMapping("/item.item")
    fun findAllItemItem(): MutableMap<String, Any> = response.responseObject(itemItemService.findAll())

    @PostMapping("/item.item")
    fun createItemItem(@RequestBody itemItem: ItemItem): MutableMap<String, Any> = response.responseObject(itemItemService.addNew(itemItem))


    @PutMapping("/item.item/{id}")
    fun updateItemItem(@PathVariable id:Int, @RequestBody itemItem: ItemItem): MutableMap<String,Any> = response.responseObject(itemItemService.updateObj(id, itemItem))

    @GetMapping("/item.item/find")
    fun findItemItem(@RequestParam name: String): MutableMap<String,Any> = response.responseObject(itemItemService.findItemItemByNameStartingWith(name))


}