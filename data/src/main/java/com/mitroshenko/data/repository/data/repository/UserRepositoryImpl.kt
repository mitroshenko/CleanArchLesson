package com.mitroshenko.data.repository.data.repository

import com.mitroshenko.data.repository.storage.models.User
import com.mitroshenko.data.repository.storage.UserStorage
import com.mitroshenko.cleanarch.domain.domain.models.SaveUserNameParam
import com.mitroshenko.cleanarch.domain.domain.models.UserName
import com.mitroshenko.cleanarch.domain.domain.repository.UserRepository


class UserRepositoryImpl(private val userStorage: UserStorage): UserRepository {

    override fun saveName(saveParam: SaveUserNameParam): Boolean {
        val user = mapToStorage(saveParam)
        val result = userStorage.save(user)
        return result
    }

    override fun getName(): UserName {
        val user = userStorage.get()
        return mapToDomain(user)
    }

    private fun mapToStorage(saveParam: SaveUserNameParam): User {
        return User(firstName = saveParam.name, lastName = "")
    }

    private fun mapToDomain(user: User): UserName{
        return UserName(firstName = user.firstName, lastName = user.lastName)
    }
}