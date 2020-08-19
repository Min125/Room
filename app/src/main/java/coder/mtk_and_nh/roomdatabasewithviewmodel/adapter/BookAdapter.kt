package coder.mtk_and_nh.roomdatabasewithviewmodel.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coder.mtk_and_nh.roomdatabasewithviewmodel.R
import coder.mtk_and_nh.roomdatabasewithviewmodel.model.Book
import kotlinx.android.synthetic.main.item_book.view.*

class BookAdapter : RecyclerView.Adapter<BookAdapter.BookViewHolder>(){

    private var books  = emptyList<Book>()

    class BookViewHolder (itemView : View) : RecyclerView.ViewHolder (itemView){
        fun bind(book : Book) {
            itemView.txtBookName.text = book.bookName
        }
    }

    fun addBookList(bookList : List<Book>){
        this.books = bookList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.item_book,parent,false)
        return BookViewHolder(view)
    }

    override fun getItemCount(): Int {
        return books.size
    }

    override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
        holder.bind(books[position])
    }
}