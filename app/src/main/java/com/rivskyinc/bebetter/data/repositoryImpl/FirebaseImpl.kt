package com.rivskyinc.bebetter.data.repositoryImpl

import com.google.firebase.database.FirebaseDatabase
import com.rivskyinc.bebetter.domain.FirebaseApi
import com.rivskyinc.bebetter.domain.entities.Blog
import com.rivskyinc.bebetter.domain.entities.Quotes
import kotlinx.coroutines.tasks.await

class FirebaseImpl() : FirebaseApi {

         val refPosts = FirebaseDatabase
             .getInstance("https://bebetter-703b7-default-rtdb.europe-west1.firebasedatabase.app")
             .getReference("Posts")
         val refQuotes = FirebaseDatabase
             .getInstance("https://bebetter-703b7-default-rtdb.europe-west1.firebasedatabase.app")
             .getReference("Quotes")

        override suspend fun getPosts(): MutableList<Blog>{
            try {
                val blogList = mutableListOf<Blog>()
                val dataSnapshot = refPosts.get().await()
                for (postSnapshot in dataSnapshot.children) {
                    val post = postSnapshot.getValue(Blog::class.java)
                    post?.let {
                        blogList.add(it)
                    }
                }
                return blogList ?: throw ApiException("Дані відсутні або невірні")

            } catch (e: Exception) {
                throw ApiException("Помилка отримання постів: ${e.message}")
            }
        }



        override suspend fun getQuote(): Quotes {
            try {
                val dataSnapshot = refQuotes.child("0").get().await()
                val quotes = dataSnapshot.getValue(Quotes::class.java)
                return quotes ?: throw ApiException("Дані відсутні або невірні")

            } catch (e: Exception) {
                throw ApiException("Помилка отримання цитат: ${e.message}")
            }
        }
    }
