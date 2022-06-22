package ru.netology.pusher

import com.google.auth.oauth2.GoogleCredentials
import com.google.firebase.FirebaseApp
import com.google.firebase.FirebaseOptions
import com.google.firebase.messaging.FirebaseMessaging
import com.google.firebase.messaging.Message
import java.io.FileInputStream


fun main() {
    val options = FirebaseOptions.builder()
        .setCredentials(GoogleCredentials.fromStream(FileInputStream("fcm.json")))
        .setDatabaseUrl(DB_URL)
        .build()

    FirebaseApp.initializeApp(options)

//    val message = Message.builder()
//        .putData("action", "LIKE")
//        .putData("content", """{
//            "userId": 1,
//            "userName": "AAAAAA",
//            "postId": 2,
//            "postAuthor": "Netology"
//        }""".trimIndent())
//        .setToken(TOKEN)
//        .build()

    val message = Message.builder()
        .putData("action", "NEW_POST")
        .putData("content", """{
            "id": 1,
            "author": "Netology",
            "title": 2,
            "text": "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA"
        }""".trimIndent())
        .setToken(TOKEN)
        .build()

    FirebaseMessaging.getInstance().send(message)
}