package com.example.erpkotlin.services.implementations

import com.example.erpkotlin.exceptions.ResourceNotAcceptableException
import com.example.erpkotlin.exceptions.ResourceNotFoundException
import com.example.erpkotlin.models.ItemItem
import com.example.erpkotlin.repositories.ItemRepository
import com.example.erpkotlin.services.ItemItemService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Sort
import org.springframework.stereotype.Service
import javax.persistence.criteria.Predicate

@Service
class ItemItemServiceImp:ItemItemService {
    @Autowired
    lateinit var itemRepository: ItemRepository

    override fun findItemItemByNameStartingWith(name: String): List<ItemItem> ? {
        return itemRepository.findItemItemByNameStartingWith(name)
    }

    override fun findAllList(q: String?, page: Int, size: Int): Page<ItemItem>? {
        return itemRepository.findAll({ root, query, cb ->
            val predicates = ArrayList<Predicate>()
            if (q != null) {
                val itemItem = cb.like(root.get("itemItem"), "%$q%")
                predicates.add(cb.or(itemItem))
            }
            predicates.add(cb.equal(root.get<String>("status"), true))
            query.orderBy(cb.asc(root.get<String>("id")))
            cb.and(*predicates.toTypedArray())
        }, PageRequest.of(page, size, Sort.by(Sort.Direction.DESC, "id")))
    }

    override fun findById(id: Int): ItemItem? {
        checkExceptionById(id)
        return itemRepository.getById(id)
    }

    override fun addNew(t: ItemItem): ItemItem? {
        checkExceptions(t)
        t.name = t.name + " (" + t.attribute + ")"

        return itemRepository.save(t)
    }

    override fun updateObj(id: Int, t: ItemItem): ItemItem? {

        checkExceptionById(id)
        val getAccountType = itemRepository.getById(id)
        itemRepository.save(getAccountType!!)

        return getAccountType
    }

    override fun findAll(): List<ItemItem>? = itemRepository.findAll()

    private fun checkExceptionById (id: Int){
        if (itemRepository.getById(id) == null) throw ResourceNotFoundException("Item id =$id doesn't exits")
    }
    private fun checkExceptions (itemItem: ItemItem) {
        if (itemItem.itemTemplateId == null) throw ResourceNotAcceptableException("Invalid Item")
    }
}