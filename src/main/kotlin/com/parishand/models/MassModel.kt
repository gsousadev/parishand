package com.parishand.models

import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import java.util.*
import javax.persistence.*

@Entity(name = "missas")
data class MassModel(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int? = null,

    @Column(name = "descricao")
    var description: String,

    @ManyToOne(optional = false)
    @JoinColumn(name = "paroquia_id", )
    var parish: ParishModel? = null,

    @Column(name = "data_hora")
    var dateHour: String,

) : AbstractTimestampModel()