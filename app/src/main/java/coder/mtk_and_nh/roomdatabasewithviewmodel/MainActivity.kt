package coder.mtk_and_nh.roomdatabasewithviewmodel

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import coder.mtk_and_nh.roomdatabasewithviewmodel.adapter.BookAdapter
import coder.mtk_and_nh.roomdatabasewithviewmodel.model.Book
import coder.mtk_and_nh.roomdatabasewithviewmodel.viewmodel.BookViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var bookViewModel : BookViewModel

    private val addBookActivityResultCode = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bookViewModel = ViewModelProviders.of(this).get(BookViewModel::class.java)
        val bookAdapter = BookAdapter()

        recyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = bookAdapter
        }

        bookViewModel.allBook.observe(
            this, Observer {
                    Log.d("Allbook", it.toString())
                    bookAdapter.addBookList(it)

            }
        )

        btnAdd.setOnClickListener {
            val intent = Intent(this, AddBookActivity::class.java)
            startActivityForResult(intent, addBookActivityResultCode)
        }

        btnDelete.setOnClickListener{
            bookViewModel.delete()
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == addBookActivityResultCode && resultCode == Activity.RESULT_OK){
            data?.getStringExtra(AddBookActivity.EXTRA_REPLY)?.let {
                Log.d("book", it)
                val book = Book (it)
                bookViewModel.insert(book)
            }
        }
    }
}