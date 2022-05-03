package uz.evkalipt.sevenmodullesson131.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import uz.evkalipt.sevenmodullesson131.daos.SaveModelDao
import uz.evkalipt.sevenmodullesson131.models.SaveModel

@Database(entities = [SaveModel::class], version = 1)
abstract class MyDatabase: RoomDatabase() {

    abstract fun saveModelDao():SaveModelDao

    companion object{
        private var instance:MyDatabase? = null

        fun getInstance(context: Context):MyDatabase{
            if (instance == null){
                instance = Room.databaseBuilder(context, MyDatabase::class.java, "pdp")
                    .fallbackToDestructiveMigration()
                    .allowMainThreadQueries()
                    .build()
            }
            return instance!!
        }
    }

}