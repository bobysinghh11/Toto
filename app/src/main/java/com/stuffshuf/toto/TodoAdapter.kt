package com.stuffshuf.toto

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_list.view.*

class TodoAdapter(var context: Context,var todo:ArrayList<Todo>): RecyclerView.Adapter<TodoAdapter.TodoViewHolder>(){


    fun updateTasks(newTasks: ArrayList<Todo>) {
        todo.clear()
        todo.addAll(newTasks)
        notifyDataSetChanged()

    }
    companion object{
        val TITELE= "title"
        val DESC ="Desc"

    }


    var listItemClickList:ListItemClickList?=null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {

        val li=parent.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val itemvView=li.inflate(R.layout.item_list, parent, false)
        return TodoViewHolder(itemvView)
    }

    override fun getItemCount(): Int {

        return todo.size
    }

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        var todod=todo[position]
        holder.bind(todod)


holder.itemView.del.setOnClickListener {

    listItemClickList?.delButtonListener(todo[position], position)

    Log.d("Adapterss", "ab ${todo[position]}")
}





        holder.itemView.setOnClickListener {

            val intent=Intent(context, Main3Activity::class.java)
            intent.putExtra(TITELE, todod.title)
            intent.putExtra(DESC, todod.desc)
            intent.putExtra("id", todod.id)
            Log.d("Bobby", "ab ${todo[position].id}")


            context.startActivity(intent)
        }

        holder.itemView.del.setOnClickListener {


        }


    }

    class TodoViewHolder(itemvView: View): RecyclerView.ViewHolder(itemvView)
    {
        fun bind(todo: Todo)
        {
            with(itemView)
            {
                tvresult.text=todo.title
                tvresult2.text=todo.desc

            }
        }
    }


}