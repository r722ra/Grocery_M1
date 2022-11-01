package com.example.groceryshopping

import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
//import kotlinx.android.synthetic.main.activity_register.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d("ERROR " , "ANY MESSAGE")

        //val userId=intent.getStringExtra("use_id")
        val emailId=intent.getStringExtra("email_id")
        val btn_logout: Button =findViewById(R.id. btn_logout)
        //val tv_user_id: TextView =findViewById(R.id.tv_user_id)
        val tv_email_id: TextView =findViewById(R.id.tv_email_id)
        val btn_maps: Button =findViewById(R.id. btn_maps)


        //tv_user_id.text="User ID :: $userId"
        //tv_email_id.text="Email ID :: $emailId"
        tv_email_id.text =emailId

        btn_logout.setOnClickListener{
//            Firebase.auth.signOut()
//            FirebaseAuth.getInstance().signOut()
            startActivity(Intent(this@MainActivity,LoginActivity::class.java))
            finish()
        }
        btn_maps.setOnClickListener{
            startActivity(Intent(this@MainActivity,MapsActivity::class.java))
            finish()
//
        }
    }

}
