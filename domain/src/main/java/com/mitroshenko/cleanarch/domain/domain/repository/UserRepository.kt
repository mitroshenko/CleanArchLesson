package com.mitroshenko.cleanarch.domain.domain.repository

import com.mitroshenko.cleanarch.domain.domain.models.SaveUserNameParam
import com.mitroshenko.cleanarch.domain.domain.models.UserName

interface UserRepository {

    fun saveName(saveParam: SaveUserNameParam): Boolean

    fun getName(): UserName
    }