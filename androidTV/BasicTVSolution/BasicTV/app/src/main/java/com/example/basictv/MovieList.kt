package com.example.basictv

object MovieList {
    val MOVIE_CATEGORY = arrayOf(
        "Action",
        "Comedy",
    )

    val list: List<Movie> by lazy {
        setupMovies()
    }
    private var count: Long = 0

    private fun setupMovies(): List<Movie> {
        val title = arrayOf(
            "Avengers",
            "James Bond",
            "Ice Age",
            "Minions"
            )

        val description = "Fusce id nisi turpis. Praesent viverra bibendum semper. " +
                "Donec tristique, orci sed semper lacinia, quam erat rhoncus massa, non congue tellus est " +
                "quis tellus. Sed mollis orci venenatis quam scelerisque accumsan. Curabitur a massa sit " +
                "amet mi accumsan mollis sed et magna. Vivamus sed aliquam risus. Nulla eget dolor in elit " +
                "facilisis mattis. Ut aliquet luctus lacus. Phasellus nec commodo erat. Praesent tempus id " +
                "lectus ac scelerisque. Maecenas pretium cursus lectus id volutpat."
        val studio = arrayOf(
            "Awesome Studio",
            "Shitty Movies",
            "Awesome Studio",
            "Shitty Movies",

            )
        val bgImageUrl = arrayOf(
            R.drawable.action,
            R.drawable.action2,
            R.drawable.comedy,
            R.drawable.comedy2

        )
        val cardImageUrl = arrayOf(
            R.drawable.action,
            R.drawable.action2,
            R.drawable.comedy,
            R.drawable.comedy2

        )

        val list = title.indices.map {
            buildMovieInfo(
                title[it],
                description,
                studio[it],
                cardImageUrl[it],
                bgImageUrl[it]
            )
        }

        return list
    }

    private fun buildMovieInfo(
        title: String,
        description: String,
        studio: String,
        cardImageUrl: Int,
        backgroundImageUrl: Int
    ): Movie {
        val movie = Movie()
        movie.id = count++
        movie.title = title
        movie.description = description
        movie.studio = studio
        movie.cardImage = cardImageUrl
        movie.backgroundImg = backgroundImageUrl
        return movie
    }
}