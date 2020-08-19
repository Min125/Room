package coder.mtk_and_nh.roomdatabasewithviewmodel

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import kotlinx.android.synthetic.main.activity_add_book.*
import android.content.Intent as Intent

class AddBookActivity : AppCompatActivity() {

    lateinit var bookName: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_book)



        btnSave.setOnClickListener{
            val replyIntent = Intent()
            bookName = edtBookName.text.toString()
            if (TextUtils.isEmpty(edtBookName.text)){
                setResult(Activity.RESULT_CANCELED,replyIntent)
            }else{
                bookName = edtBookName.text.toString()
                Log.d("book", bookName)
                replyIntent.putExtra(EXTRA_REPLY,bookName)
                setResult(Activity.RESULT_OK,replyIntent)
            }
            finish()
        }


    }

    companion object{
        const val EXTRA_REPLY = "REPLY_BOOK"
    }
}