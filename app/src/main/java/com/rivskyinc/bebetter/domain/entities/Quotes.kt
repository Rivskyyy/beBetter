package com.rivskyinc.bebetter.domain.entities

 class Quotes {
     var author: String? = null
     var id: String? = null
     var text: String? = null
     constructor() {

     }

     constructor(author: String?, id: String?, text: String?) {
         this.author = author
         this.id = id
         this.text = text

//    this.timestamp = timestamp
     }

     override fun toString(): String {
         return "Quotes(author='$author', id='$id', text='$text')"
     }
 }
