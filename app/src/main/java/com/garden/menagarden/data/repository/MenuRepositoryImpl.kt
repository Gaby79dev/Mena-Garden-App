package com.garden.menagarden.data.repository

import com.garden.menagarden.data.model.Menu
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.getValue
import kotlinx.coroutines.tasks.await
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MenuRepositoryImpl @Inject constructor(
    private val database: FirebaseDatabase
) : MenuRepository {

    override suspend fun getMenu(): Menu {
        val snapshot = database.reference.get().await()
        return snapshot.getValue<Menu>() ?: Menu()
    }
}
