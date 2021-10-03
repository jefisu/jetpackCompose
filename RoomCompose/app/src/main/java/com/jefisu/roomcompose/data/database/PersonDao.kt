package com.jefisu.roomcompose.data.database

import androidx.room.*
import com.jefisu.roomcompose.data.dto.Person

@Dao
interface PersonDao {

    @Insert
     fun save(movie: Person): Long

    @Query("SELECT * FROM movies")
     fun load(): List<Person>

    @Query("SELECT * FROM movies WHERE id = :id")
     fun getMovie(id: Int): Person

    @Update
     fun update(movie: Person)

    @Delete
     fun delete(movie: Person)
}