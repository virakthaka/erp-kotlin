package com.example.erpkotlin.bases

import com.fasterxml.jackson.annotation.JsonIgnore
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.util.*
import javax.persistence.*

@MappedSuperclass
@EntityListeners(AuditingEntityListener::class)
open class BaseEntity {

    @JsonIgnore
    @Column(name = "created_at")
    open var createdAt: Date? = null

    @JsonIgnore
    @Column(name = "updated_at")
    open var updatedAt: Date? = null

    @JsonIgnore
    @Column(name = "created_by")
    val createdBy: Int? = null

    @JsonIgnore
    @Column(name = "updated_by")
    val updatedBy: Int? = null

    /**
     *Auto get current date when records created
     */
    @PrePersist
    protected fun onCreate() {
        createdAt = Date()
        updatedAt = Date()
    }

    /**
     *Auto get current date when records updated
     */
    @PreUpdate
    protected fun onUpdate() {
        updatedAt = Date()
    }
}
