package uy.edu.ude.mynotepad.usecases

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import uy.edu.ude.mynotepad.entities.Word

@Dao
interface WordDao {

    @Query("SELECT * from word_table ORDER BY word ASC")
    fun getAlphabetizedWords(): LiveData<List<Word>>

    @Query("SELECT * from word_table ORDER BY word ASC")
    fun getWords(): List<Word>

    @Query("SELECT * from word_table where word like :name")
    fun getWordBy(name: String): List<Word>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(word: Word)

    @Query("DELETE FROM word_table")
    suspend fun deleteAll()
}