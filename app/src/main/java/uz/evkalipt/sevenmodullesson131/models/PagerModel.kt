package uz.evkalipt.sevenmodullesson131.models

import java.io.Serializable

class PagerModel : Serializable {

    var page: Int? = null
    var name: String? = null
    var list: List<String>? = null


    constructor()
    constructor(page: Int?, name: String?, list: List<String>?) {
        this.page = page
        this.name = name
        this.list = list
    }

}