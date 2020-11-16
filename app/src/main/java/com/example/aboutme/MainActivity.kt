package com.example.aboutme

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.example.aboutme.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding // переменная для привязки

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // привязка nickname r соответствующему полю
        //setContentView(R.layout.activity_main) переделаем этот способ формирования активити
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        //привязка переменной дата класса myName к полям в макете
//        findViewById<Button>(R.id.button_done).setOnClickListener{
//            addNickName(it)
        // теперь получаем доступ к элементам через binding
        binding.buttonDone.setOnClickListener{
            addNickName(it)
        }
     }

    private fun addNickName(view: View) {
//        val editText = findViewById<EditText>(R.id.nickname_edit)
//        val nickNameTextView = findViewById<TextView>(R.id.nickname_text)
    binding.apply {
        nicknameText.text = nicknameEdit.text
        invalidateAll() // заново воссоздаем выражения привязки с новыми данными
        nicknameEdit.visibility = View.GONE
        buttonDone.visibility = View.GONE
        nicknameText.visibility = View.VISIBLE
    }

        //hide the keyboard
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }
}