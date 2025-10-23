package com.garden.menagarden.data.repository

import com.garden.menagarden.data.model.Category
import com.garden.menagarden.data.model.MenuItem
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MenuRepositoryImpl @Inject constructor(
    private val firestore: FirebaseFirestore
) : MenuRepository {

    override suspend fun getCategories(): List<Category> {
        val snapshot = firestore.collection("categories").orderBy("order").get().await()
        return snapshot.toObjects(Category::class.java).mapIndexed { index, category ->
            category.copy(id = snapshot.documents[index].id)
        }
    }

    override suspend fun getMenuItems(): Map<String, List<MenuItem>> {
        val snapshot = firestore.collection("menuItems").orderBy("order").get().await()
        val menuItemList = snapshot.toObjects(MenuItem::class.java).mapIndexed { index, menuItem ->
            menuItem.copy(id = snapshot.documents[index].id)
        }
        return menuItemList.groupBy { it.category }
    }
}
