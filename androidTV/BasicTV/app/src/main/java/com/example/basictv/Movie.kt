package com.example.basictv

import java.io.Serializable

/**
 * Movie class represents video entity with title, description, image thumbs and video url.
 */
data class Movie(
    var id: Long = 0,
    var title: String? = null,
    var description: String? = null,
    var backgroundImg:  Int = 0,
    var cardImage:  Int = 0,
    var studio: String? = null
) : Serializable {

    override fun toString(): String {
        return "Movie{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", backgroundImageUrl='" + backgroundImg + '\'' +
                ", cardImageUrl='" + cardImage + '\'' +
                '}'
    }

    companion object {
        internal const val serialVersionUID = 727566175075960653L
    }
}