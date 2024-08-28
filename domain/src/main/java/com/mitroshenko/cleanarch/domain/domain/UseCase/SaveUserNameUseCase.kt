package com.mitroshenko.cleanarch.domain.domain.UseCase

import com.mitroshenko.cleanarch.domain.domain.models.SaveUserNameParam
import com.mitroshenko.cleanarch.domain.domain.repository.UserRepository

class SaveUserNameUseCase(private val userRepository: UserRepository) {
    fun execute(param: SaveUserNameParam): Boolean {
        val result: Boolean =userRepository.saveName(saveParam = param)
        return result
    }
}
