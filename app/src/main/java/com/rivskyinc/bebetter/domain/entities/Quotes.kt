package com.rivskyinc.bebetter.domain.entities

class Quotes {
    var author: String? = null
    var id: String? = null
    var text: String? = null
    //    var timestamp : String? = null

    constructor() {

    }

    constructor(author: String?, id: String?, thumbnail: String?, text: String?) {
        this.author = author
        this.id = id
        this.text = text

    }
}

