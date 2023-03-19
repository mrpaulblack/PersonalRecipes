package com.github.mrpaulblack.personalrecipes.di

import android.app.Application
import com.github.mrpaulblack.personalrecipes.data.IRepository
import com.github.mrpaulblack.personalrecipes.data.Repository
import com.github.mrpaulblack.personalrecipes.ui.recipe.RecipeViewModel
import com.github.mrpaulblack.personalrecipes.ui.recipeslist.RecipesListViewModel
import com.github.mrpaulblack.personalrecipes.ui.search.SearchViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.startKoin
import org.koin.dsl.module


class PersonalRecipes : Application() {
    private val appModule = module {
        single<IRepository> { Repository() }

        viewModel { RecipeViewModel(get()) }
        viewModel { RecipesListViewModel(get()) }
        viewModel { SearchViewModel(get()) }
    }

    override fun onCreate() {
        super.onCreate()

        startKoin {
            modules(appModule)
        }
    }
}
