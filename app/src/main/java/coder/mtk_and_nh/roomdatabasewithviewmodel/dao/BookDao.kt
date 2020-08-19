package coder.mtk_and_nh.roomdatabasewithviewmodel.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import coder.mtk_and_nh.roomdatabasewithviewmodel.model.Book

@Dao
interface BookDao {

    @Query("SELECT * FROM book_table ORDER BY book_name ASC")
    fun getAllBook () : LiveData<List<Book>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
     suspend fun insert (book: Book)

    @Query("DELETE FROM book_table")
    suspend fun delete()
}