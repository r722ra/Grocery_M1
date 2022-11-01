package com.example.groceryshopping

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val btn_login: Button =findViewById(R.id.btn_login)
        val tv_register: TextView =findViewById(R.id.tv_register)
        tv_register.setOnClickListener{
            startActivity(Intent(this@LoginActivity,RegisterActivity::class.java))
        }
        //val tv_register : TextView =findViewById(R.id.tv_register)
        val et_register_email:EditText=findViewById(R.id.login_email)
        val et_register_password:EditText=findViewById(R.id.login_password)
        btn_login.setOnClickListener{
            when{
                TextUtils.isEmpty(et_register_email.text.toString().trim{it<= ' '}) ->{
                    Toast.makeText(
                        this@LoginActivity,
                        "Please Enter email ",
                        Toast.LENGTH_SHORT
                    ).show()
                }

                TextUtils.isEmpty(et_register_password.text.toString().trim{ it <= ' '})->{
                    Toast.makeText(
                        this@LoginActivity,
                        "Please Enter Password",
                        Toast.LENGTH_SHORT

                    ).show()
                }
                else ->{
                    val email:String=et_register_email.text.toString().trim{ it <= ' ' }
                    val password:String=et_register_password.text.toString().trim{ it <= ' ' }

                    FirebaseAuth.getInstance().signInWithEmailAndPassword(email,password)
                        .addOnCompleteListener(
                            { task ->

                                if (task.isSuccessful){
                                    val firebaseUser: FirebaseUser =task.result!!.user!!

                                    Toast.makeText(
                                        this@LoginActivity,
                                        "You are registered successfully",
                                        Toast.LENGTH_SHORT
                                    ).show()

                                    val intent=
                                        Intent(this@LoginActivity,MainActivity::class.java)
                                    intent.flags=Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                                    intent.putExtra("user_id",FirebaseAuth.getInstance().currentUser!!.uid)
                                    intent.putExtra("email_id",email)
                                    startActivity(intent)
                                    finish()
                                }else{
                                    Toast.makeText(
                                        this@LoginActivity,
                                        task.exception!!.message.toString(),
                                        Toast.LENGTH_SHORT
                                    ).show()
                                }
                            })
                }
            }

        }



}

}