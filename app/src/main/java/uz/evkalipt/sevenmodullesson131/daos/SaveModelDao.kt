package uz.evkalipt.sevenmodullesson131.daos

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import uz.evkalipt.sevenmodullesson131.models.SaveModel

@Dao
interface SaveModelDao {

    @Insert
    fun addPhoto(saveModel: SaveModel)

    @Query("select * from SaveModel")
    fun getAllPhoto():List<SaveModel>

    @Delete
    fun deletePhoto(saveModel: SaveModel)
}