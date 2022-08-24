package com.parishand.models

import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import java.util.*
import javax.persistence.Column

abstract class AbstractTimestampModel(
    @CreatedDate
    @Column(name = "created_at")
    var createdAt: Date? = null,

    @LastModifiedDate
    @Column(name = "updated_at")
    var updateAt: Date? = null
)