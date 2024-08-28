package com.mitroshenko.cleanarch.domain.domain.UseCase

import com.mitroshenko.cleanarch.domain.domain.models.UserName
import com.mitroshenko.cleanarch.domain.domain.repository.UserRepository

class GetUserNameUseCase(private val userRepository: UserRepository) {

    fun execute(): UserName {


        return userRepository.getName()
    }
}
