package com.mitroshenko.cleanarch.cleanarch.presentation.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.mitroshenko.cleanarch.R
import com.mitroshenko.cleanarch.domain.domain.UseCase.GetUserNameUseCase
import com.mitroshenko.cleanarch.domain.domain.UseCase.SaveUserNameUseCase
import com.mitroshenko.data.repository.data.repository.UserRepositoryImpl
import com.mitroshenko.data.repository.storage.sharedprefs.SharedPrefUserStorage

class MainActivity : AppCompatActivity() {

    private val userRepository by lazy(LazyThreadSafetyMode.NONE) {
        UserRepositoryImpl(
            userStorage = SharedPrefUserStorage(context = applicationContext)
        )
    }
    private val getUserNameUseCase by lazy(LazyThreadSafetyMode.NONE) {
        GetUserNameUseCase(
            userRepository = userRepository
        )
    }
    private val saveUserNameUseCase by lazy(LazyThreadSafetyMode.NONE) {
        SaveUserNameUseCase(
            userRepository = userRepository
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val dataTextView = findViewById<TextView>(R.id.dataTextView)
        val dataEditView = findViewById<EditText>(R.id.dataEditView)
        val sendButton = findViewById<Button>(R.id.sendButton)
        val receiveButton = findViewById<Button>(R.id.receiveButton)
        sendButton.setOnClickListener(){
            val text = dataEditView.text.toString()
            val params =
                com.mitroshenko.cleanarch.domain.domain.models.SaveUserNameParam(name = text)
            val result: Boolean = saveUserNameUseCase.execute(param = params)
            dataTextView.text = "Save result = $result"

        }
        receiveButton.setOnClickListener(){

            val userName: com.mitroshenko.cleanarch.domain.domain.models.UserName = getUserNameUseCase.execute()
            dataTextView.text = "${userName.firstName} ${userName.lastName}"
        }
    }
}