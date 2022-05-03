package uz.evkalipt.sevenmodullesson131.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class SaveModel {

    @PrimaryKey(autoGenerate = true)
    var id:Int? = null
    @ColumnInfo(name = "url")
    var url:String? = null
    @ColumnInfo(name = "author")
    var author:String? = null
    @ColumnInfo(name = "likes")
    var likes:String? = null
    @ColumnInfo(name = "size")
    var size:String? = null

    constructor(url: String?, author: String?, likes: String?, size: String?) {
        this.url = url
        this.author = author
        this.likes = likes
        this.size = size
    }



    constructor()
    constructor(id: Int?, url: String?, author: String?, likes: String?, size: String?) {
        this.id = id
        this.url = url
        this.author = author
        this.likes = likes
        this.size = size
    }


}