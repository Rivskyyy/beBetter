package com.rivskyinc.bebetter.domain.entities

 class Blog {

     var category: String? = null
     var text: String? = null
     var thumbnail: String? = null
     var title: String? = null
     var id : String? = null

     constructor() {

     }

     constructor(category: String?,
                 text: String?,
                 thumbnail: String?,
                 title: String?,
                 id : String?) {
         this.category = category
         this.text = text
         this.thumbnail = thumbnail
         this.title = title
         this.id = id
//    this.timestamp = timestamp
     }

     override fun toString(): String {
         return "Blog(category='$category'," +
                 " text='$text', " +
                 "thumbnail='$thumbnail," +
                 " title='$title', " +
                 "id='$id')"
     }
 }


