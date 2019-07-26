package com.stuffshuf.toto


import androidx.room.*

@Dao
interface TodoDao {
    @Insert
    fun insertRow(todo: Todo)

    @Insert
    fun inserAll(todoList: ArrayList<Todo>)


    @Query("Select * FROM Todo")
    fun getAllTodo(): List<Todo>

    @Query("Delete FROM Todo WHERE id = :id")
    fun getAllTodoWithDone(id:Int)

    @Delete
    fun delete(todo: Todo)

    @Query("DELETE FROM Todo WHERE id = :userId")
     fun deleteByUserId(userId: Int)

    @Delete
    fun deleteId(todo: Todo)

    @Query("Delete FROM Todo WHERE id=1")
    fun deleteAll()

//    @Query("Delete FROM Todo")
//    fun deleteAll():List<Todo>
//
//    @Update
//    fun updateTaska(todo: Todo)
//
//    @Query("Select * FROM Todo ORDER BY status ASC")
//    fun sortTask():List<Todo>
//
//    @Query("Select * FROM Todo WHERE title LIKE :task")
//    fun SearchTodo(task:String):List<Todo>

}

