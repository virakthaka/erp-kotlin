package com.example.erpkotlin.services.implementations

import com.example.erpkotlin.exceptions.ResourceNotAcceptableException
import com.example.erpkotlin.exceptions.ResourceNotFoundException
import com.example.erpkotlin.models.ItemTemplate
import com.example.erpkotlin.repositories.ItemTemplateRepository
import com.example.erpkotlin.services.ItemTemplateService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Page
import org.springframework.stereotype.Service

@Service
class ItemTemplateServiceImp:ItemTemplateService {

    @Autowired
    lateinit var itemTemplateRepository: ItemTemplateRepository

    override fun findAllList(q: String?, page: Int, size: Int): Page<ItemTemplate>? {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun findById(id: Int): ItemTemplate? {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun addNew(t: ItemTemplate): ItemTemplate? {
        checkExceptions(t)
        return itemTemplateRepository.save(t)
    }

    override fun updateObj(id: Int, t: ItemTemplate): ItemTemplate? {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun findAll(): List<ItemTemplate>? = itemTemplateRepository.findAll()

    private fun checkExceptionById (id: Int){
        if (itemTemplateRepository.getById(id) == null) throw ResourceNotFoundException("Item id =$id doesn't exits")
    }

    private fun checkExceptions (itemTemplate: ItemTemplate) {
        if (itemTemplate.name == null) throw ResourceNotAcceptableException("Invalid Item")
    }
}