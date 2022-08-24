package com.parishand.models

import io.swagger.v3.oas.annotations.media.Schema
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.util.Date
import javax.persistence.*

@Entity(name = "paroquias")
@Schema(description = "Model de representação de paróquias")
data class ParishModel(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) var id: Int? = null,

    @Column(name = "nome", unique = true) var name: String,

    @Column(name = "endereco") var address: String,

    @Column(name = "cep") var zipCode: String,

    @Column(name = "cnpj") var cnpj: String,

) : AbstractTimestampModel()