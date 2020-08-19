package coder.mtk_and_nh.roomdatabasewithviewmodel.repository

import androidx.lifecycle.LiveData
import coder.mtk_and_nh.roomdatabasewithviewmodel.dao.BookDao
import coder.mtk_and_nh.roomdatabasewithviewmodel.model.Book

class BookRepository(private val bookDao : BookDao){

    val allBook: LiveData<List<Book>> = bookDao.getAllBook()

     suspend fun insert (book : Book)   {
        bookDao.insert(book)
    }

     suspend fun delete (){
        bookDao.delete()
    }

}