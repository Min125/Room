package coder.mtk_and_nh.roomdatabasewithviewmodel.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import coder.mtk_and_nh.roomdatabasewithviewmodel.Database.BookDatabase
import coder.mtk_and_nh.roomdatabasewithviewmodel.model.Book
import coder.mtk_and_nh.roomdatabasewithviewmodel.repository.BookRepository
import kotlinx.coroutines.launch

class BookViewModel(application: Application): AndroidViewModel(application){
    private val repository : BookRepository
    val allBook : LiveData<List<Book>>

    init {
        val bookDao = BookDatabase.getDatabase(
            application
        ).bookDao()

        repository = BookRepository(bookDao)
        allBook = repository.allBook
    }

    fun insert(book: Book)=viewModelScope.launch {
        repository.insert(book)
    }
    fun delete()=viewModelScope.launch {
        repository.delete()
    }
}