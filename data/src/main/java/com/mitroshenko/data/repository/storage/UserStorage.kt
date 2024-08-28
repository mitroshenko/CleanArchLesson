package com.mitroshenko.data.repository.storage

import com.mitroshenko.data.repository.storage.models.User

interface UserStorage {
    fun save(user: User): Boolean

    fun get(): User
}