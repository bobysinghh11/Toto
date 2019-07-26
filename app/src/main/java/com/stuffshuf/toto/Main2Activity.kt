package com.stuffshuf.toto

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import kotlinx.android.synthetic.main.activity_main2.*
import kotlinx.android.synthetic.main.content_main.*
import kotlinx.android.synthetic.main.item_list.*
import kotlinx.android.synthetic.main.item_list.view.*
import java.util.*
import kotlin.collections.ArrayList

class Main2Activity : AppCompatActivity() {


    var list = arrayListOf<Todo>()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val db = Room.databaseBuilder(
            this,
            AppDatabase::class.java,
            "todo.db"
        ).allowMainThreadQueries()
            .fallbackToDestructiveMigration()
            .build()


        list = db.todoDao().getAllTodo() as ArrayList<Todo>

        val todoAdapter = TodoAdapter(this,list)

        lvTodolist.adapter = TodoAdapter(this,list)

        var titlee = intent.getStringExtra(TodoAdapter.TITELE)
        var desce = intent.getStringExtra(TodoAdapter.DESC)

        Log.d("titleee", "tt $titlee")

        db.todoDao().insertRow(
            Todo(
                title = titlee,
                desc = desce

            )
        )

        list = db.todoDao().getAllTodo() as ArrayList<Todo>
       // Log.d("list", "l $list")
//        todoAdapter.updateTasks(list)
        lvTodolist.layoutManager = GridLayoutManager(
            this,
            1,
            GridLayoutManager.VERTICAL,
            false
        )
        todoAdapter.updateTasks(list)





       todoAdapter.listItemClickList=object :ListItemClickList{
           override fun delButtonListener(todo: Todo, position: Int) {
               db.todoDao().delete(todo)
               list=db.todoDao().getAllTodo() as ArrayList<Todo>
               todoAdapter.updateTasks(list)
               lvTodolist.adapter=todoAdapter
               Log.d("del", "d $todo")
           }

       }

        }
    }


//   class TodoAdapter(var todo: ArrayList<Todo>) : RecyclerView.Adapter<TodoAdapter.TodoViewHolder>() {
//
//        fun updateTasks(newTasks: ArrayList<Todo>) {
//            todo.clear()
//            todo.addAll(newTasks)
//            notifyDataSetChanged()
//        }
//
//        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
//
//            val li = parent.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
//            val itemvView = li.inflate(R.layout.item_list, parent, false)
//            return TodoViewHolder(itemvView)
//        }
//
//        override fun getItemCount(): Int {
//
//            return todo.size
//        }
//
//        override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
//            val todod = todo[position]
//            holder.itemView.tvresult.text = todod.title
//            holder.itemView.tvresult2.text = todod.desc
//
//
//
//
//        }
//
//      inner  class TodoViewHolder(itemvView: View) : RecyclerView.ViewHolder(itemvView)
//
//
//    }
//}

