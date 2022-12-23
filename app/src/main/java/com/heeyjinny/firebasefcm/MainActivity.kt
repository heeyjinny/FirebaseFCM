package com.heeyjinny.firebasefcm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.messaging.FirebaseMessaging

/**  파이어베이스 클라우드 메시징 서비스 사용하기  **/

//1
//app - java밑 패키지명 우클릭 - New - Service - Service
//MyFirebaseMessagingService - Finish

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //2
        //토큰을 다시 출력하기위한 코드
        FirebaseMessaging.getInstance().token.addOnCompleteListener(OnCompleteListener { task ->
            if (!task.isSuccessful){
                Log.e("토큰", "FCM registration token failed", task.exception)
                return@OnCompleteListener
            }
            val token = task.result.toString()
            Log.d("토큰", "재호출: $token")
        })

    }//onCreate
}//MainActivity