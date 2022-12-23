package com.heeyjinny.firebasefcm

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log
import com.google.firebase.messaging.FirebaseMessagingService

//1
//기본으로 Service()를 상속받고 있음
//FirebaseMessagingService()를 상속받도록 수정
//클래스 안 코드 모두 삭제
class MyFirebaseMessagingService : FirebaseMessagingService() {

    //2
    //토큰을 받을 수 있는 상태가 되면 호출되는
    //onNewToken()메서드 오버라이드
    //onNewToken(): 토큰이 생성될 때마다 안드로이드가 호출해줌
    //메서드 안에서 받은 토큰은 디바이스나 서버에 저장해두어야 함...
    //현재 프로젝트에서는 일단 로그로 토큰 출력 후 복사해서 사용함...
    override fun onNewToken(token: String) {
        Log.d("토큰", "$token")
    }

    //3
    //AndroidManifest.xml의 <service>태그 수정
    //intent-filter에 MESSAGING_EVENT설정
    //메시지가 수신되면 MyFirebaseMessagingService 동작
    //수신코드를 작성하지 않았어도 토큰을 기반으로 동작하기 때문에
    //해당 토큰을 가진 디바이스 상단에 별도의 메시지 알림이 보여짐

    //4
    //앱 실행 시 로그캣 창으로 실제 토큰 문자열이 출력됨
    //토큰 복사해두기...

    //5
    //토큰이 갱신되기 전까지 앱을 재실행해도 토큰출력 호출이되지 않음
    //토큰을 다시 출력하기위해 MainActivity.kt 코드 추가

}

