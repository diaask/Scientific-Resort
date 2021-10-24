package com.app.remote.features.home.service

import com.app.domain.base.result.AResult
import com.app.remote.features.home.model.FactorsModel
import com.app.remote.features.home.model.HomeSliderModel
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.callbackFlow
import javax.inject.Inject


class HomeService @Inject constructor(private val firebaseDatabase: FirebaseDatabase) {

    suspend fun getHomeSlider() = callbackFlow {

        val postListener = object : ValueEventListener {
            override fun onCancelled(error: DatabaseError) {
                this@callbackFlow.trySend(AResult.failure(error.toException()))
            }

            override fun onDataChange(dataSnapshot: DataSnapshot) {
                val items = dataSnapshot.children.map { ds ->
                    ds.getValue(HomeSliderModel::class.java)
                }
                this@callbackFlow.trySend(AResult.success(items.filterNotNull()))
            }
        }
        firebaseDatabase.reference.child("slider")
            .addValueEventListener(postListener)

        awaitClose {
            firebaseDatabase.reference.child("slider")
                .removeEventListener(postListener)
        }
    }
    suspend fun getHomeFactors() = callbackFlow {

        val postListener = object : ValueEventListener {
            override fun onCancelled(error: DatabaseError) {
                this@callbackFlow.trySend(AResult.failure(error.toException()))
            }

            override fun onDataChange(dataSnapshot: DataSnapshot) {
                val items = dataSnapshot.children.map { ds ->
                    ds.getValue(FactorsModel::class.java)
                }
                this@callbackFlow.trySend(AResult.success(items.filterNotNull()))
            }
        }
        firebaseDatabase.reference.child("factors")
            .addValueEventListener(postListener)

        awaitClose {
            firebaseDatabase.reference.child("factors")
                .removeEventListener(postListener)
        }
    }

}