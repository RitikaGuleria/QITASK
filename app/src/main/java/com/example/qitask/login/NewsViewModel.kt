package com.example.qitask.login

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.example.Articles
import com.example.qitask.NewsRepository
import kotlinx.coroutines.launch

class NewsViewModel(private val repository: NewsRepository=NewsRepository.getInstance()): ViewModel()
{
    init {
        viewModelScope.launch {
            val news=getNews()
            newsState.value=news
        }
    }
    val newsState: MutableState<List<Articles>> = mutableStateOf(emptyList<Articles>())
    private suspend fun getNews(): List<Articles>{
        return repository.getNews().articles
    }
}