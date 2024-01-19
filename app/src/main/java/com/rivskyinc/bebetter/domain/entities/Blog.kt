package com.rivskyinc.bebetter.domain.entities

class Blog {

    var category: String? = null
    var text: String? = null
    var thumbnail: String? = null
    var title: String? = null
    //    var timestamp : String? = null

    constructor() {

    }

    constructor(category: String?, text: String?, thumbnail: String?, title: String?) {
        this.category = category
        this.text = text
        this.thumbnail = thumbnail
        this.title =  title

    }

}