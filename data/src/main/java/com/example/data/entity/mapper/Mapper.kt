package com.example.data.entity.mapper

/**
 * Created by Artur on 10.09.2017.
 */
interface Mapper<E, D> {

    fun mapFromEntity(type: E): D

    fun mapToEntity(type: D): E

}