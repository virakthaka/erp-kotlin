package com.example.erpkotlin.services.implementations

import com.example.erpkotlin.exceptions.ResourceNotAcceptableException
import com.example.erpkotlin.exceptions.ResourceNotFoundException
import com.example.erpkotlin.models.ItemAttribute
import com.example.erpkotlin.models.ItemItem
import com.example.erpkotlin.models.ItemTemplate
import com.example.erpkotlin.repositories.ItemAttributeRepository
import com.example.erpkotlin.services.ItemAttributeService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Page
import org.springframework.stereotype.Service

@Service
class ItemAttributeServiceImp: ItemAttributeService {

    @Autowired
    lateinit var itemAttributeRepository: ItemAttributeRepository

    override fun findAllList(q: String?, page: Int, size: Int): Page<ItemAttribute>? {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun findById(id: Int): ItemAttribute? {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun addNew(t: ItemAttribute): ItemAttribute? {
        checkExceptions(t)
        return itemAttributeRepository.save(t)
    }

    override fun updateObj(id: Int, t: ItemAttribute): ItemAttribute? {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun findAll(): List<ItemAttribute>? {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    private fun checkExceptionById (id: Int){
        if (itemAttributeRepository.getById(id) == null) throw ResourceNotFoundException("Item attribute id =$id doesn't exits")
    }
    private fun checkExceptions (itemAttribute: ItemAttribute) {
        if (itemAttribute.name == null) throw ResourceNotAcceptableException("Invalid Item attribute")
    }

}