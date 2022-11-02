package com.example.paasta

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_login.*

class Login : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        et_pwd.setOnEditorActionListener { v, actionId, event ->
            if (actionId == EditorInfo.IME_ACTION_DONE) {
                Signin(v)
                true
            } else false
        }

        //불러오기
        var pref = this.getPreferences(0)
        et_email.setText(pref.getString("이메일", ""))
        et_pwd.setText(pref.getString("비밀번호", ""))
    }

    fun Signin(v : View){
        //키보드 숨김
        var imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(v.windowToken, 0)

        //백엔드로 입력정보 비교하기
        if(et_email.text.toString() == "asdf1234@gmail.com" && et_pwd.text.toString() == "qwe123") {
            Toast.makeText(this, "로그인 성공", Toast.LENGTH_SHORT).show()

            startActivity(Intent(this, MainActivity::class.java))
            //setContentview(R.layout.activity_main)

            /*var intent = Intent(this, MainActivity::class.java)
            intent.putExtra("이메일", "asdf1234@gmail.com")
            startActivity(intent)*/

            //저장
            var editor = this.getPreferences(0).edit()
            editor.putString("이메일", "asdf1234@gmail.com").apply()
            editor.putString("비밀번호", "qwe123").apply()

        }
        else Toast.makeText(this, "로그인 실패", Toast.LENGTH_SHORT).show()
    }

    fun Signup(v : View){
        startActivity(Intent(this, Signup::class.java))
    }

}