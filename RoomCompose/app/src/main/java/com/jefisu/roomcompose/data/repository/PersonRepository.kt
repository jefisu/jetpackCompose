package com.jefisu.roomcompose.data.repository

import android.content.Context
import com.jefisu.roomcompose.data.database.PersonDatabase
import com.jefisu.roomcompose.data.dto.Person

class PersonRepository(context: Context) {

    private val mMovieDatabase = PersonDatabase.getInstance(context).dao()

     fun save(movie: Person): Boolean {
        return mMovieDatabase.save(movie) > 0
    }

     fun load(): List<Person> {
        return mMovieDatabase.load()
    }

     fun update(id: Int) {
        val movie = mMovieDatabase.getMovie(id)
         mMovieDatabase.update(movie)
    }

     fun delete(id: Int) {
        val movie = mMovieDatabase.getMovie(id)
         mMovieDatabase.delete(movie)
    }
}