package com.dicoding.jetpack.moviecatalog.utils

import com.dicoding.jetpack.moviecatalog.data.source.local.MovieEntity
import com.dicoding.jetpack.moviecatalog.data.source.remote.response.MovieResponse


object DataDummy {

    fun generateDummyMovies(): List<MovieEntity>{
        val movies = ArrayList<MovieEntity>()

        movies.add(
            MovieEntity(
                "001",
                "A Star Is Born",
                "Seorang bintang musik country yang karirnya mulai memudar, Jackson Maine (Bradley Cooper) menemukan sebuah talenta yang sangat berbakat di dalam diri dari seorang musisi muda bernama Ally (Lady Gaga). Maine berhasil mengorbitkan Ally menjadi seorang bintang muda yang menjanjikan. Namun keduanya terlibat hubungan yang lebih jauh dari sekedar mentor dan anak didik. Seiring dengan meroketnya karir dari Ally dan dirinya, Maine mengalami dilema mengenai masalah ini.",
                "Drama, Percintaan, Musik",
                "2018",
                "2h 16m",
           "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/wrFpXMNBRj2PBiN4Z5kix51XaIZ.jpg",
            false,
            false)
        )

        movies.add(
            MovieEntity(
                "002",
                "Alita: Battle Angel",
                "Ketika Alita terbangun tanpa ingatan tentang siapa dia di dunia masa depan yang tidak dia kenal, dia ditangkap oleh Ido, seorang dokter yang penuh kasih yang menyadari bahwa di suatu tempat dalam cangkang cyborg yang ditinggalkan ini adalah hati dan jiwa seorang wanita muda dengan luar biasa. lalu.",
                "Aksi, Cerita Fiksi, Petualangan",
                "2019",
                "2h 2m",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/xRWht48C2V8XNfzvPehyClOvDni.jpg",
                false,
                false
            )
        )

        movies.add(
            MovieEntity(
                "003",
                "Aquaman",
                "Once home to the most advanced civilization on Earth, Atlantis is now an underwater kingdom ruled by the power-hungry King Orm. With a vast army at his disposal, Orm plans to conquer the remaining oceanic people and then the surface world. Standing in his way is Arthur Curry, Orm's half-human, half-Atlantean brother and true heir to the throne.",
                "Aksi, Petualangan, Fantasi",
                "2018",
                "2h 23m",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/xLPffWMhMj1l50ND3KchMjYoKmE.jpg",
                false,
                false
            )
        )

        movies.add(
            MovieEntity(
                "004",
                "Bohemian Rhapsody ",
                "Singer Freddie Mercury, guitarist Brian May, drummer Roger Taylor and bass guitarist John Deacon take the music world by storm when they form the rock 'n' roll band Queen in 1970. Hit songs become instant classics. When Mercury's increasingly wild lifestyle starts to spiral out of control, Queen soon faces its greatest challenge yet – finding a way to keep the band together amid the success and excess.",
                "Musik, Drama, Sejarah",
                "2018",
                "2h 15m",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/lHu1wtNaczFPGFDTrjCSzeLPTKN.jpg",
                false,
                false
            )
        )

        movies.add(
            MovieEntity(
                "005",
                "Fast & Furious Presents: Hobbs & Shaw",
                "Hobbs & Shaw (2019) cinema film baru barat yang sangat seru Ini bercerita Luke Hobbs (Dwayne Johnson) terpaksa membentuk aliansi yang mustahil dengan Deckard Shaw (Jason Statham). Keduanya terpaksa bersatu membantu Hattie Shaw (Vanessa Kirby) untuk memburu senjata virus berbahaya dan Brixton (Idris Elba). Brixton adalah penjahat jenis baru yang berhasil mengubah dirinya menjadi manusia super. Keberadaanya menjadi ancaman bagi umat manusia.",
                "Aksi, Petualangan, Komedi",
                "2019",
                "2h 17m",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/qRyy2UmjC5ur9bDi3kpNNRCc5nc.jpg",
                false,
                false
            )
        )

        movies.add(
            MovieEntity(
                "006",
                "Mulan",
                "When the Emperor of China issues a decree that one man per family must serve in the Imperial Chinese Army to defend the country from Huns, Hua Mulan, the eldest daughter of an honored warrior, steps in to take the place of her ailing father. She is spirited, determined and quick on her feet. Disguised as a man by the name of Hua Jun, she is tested every step of the way and must harness her innermost strength and embrace her true potential.",
                "Petualangan, Fantasi",
                "2020",
                "1h 55m",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/aKx1ARwG55zZ0GpRvU2WrGrCG9o.jpg",
                false,
                false
            )
        )

        movies.add(
            MovieEntity(
                "007",
                "Mortal Kombat",
                "Washed-up MMA fighter Cole Young, unaware of his heritage, and hunted by Emperor Shang Tsung's best warrior, Sub-Zero, seeks out and trains with Earth's greatest champions as he prepares to stand against the enemies of Outworld in a high stakes battle for the universe.",
                "Fantasi, Aksi, Petualangan, Cerita Fiksi, Cerita Seru",
                "2021",
                "1h 50m",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/yiu9ISHAbbZATKl0FaMPh8is7Oa.jpg",
                false,
                false
            )
        )

        movies.add(
            MovieEntity(
                "008",
                "Nobody",
                "Hutch Mansell, seorang ayah di pinggiran kota, suami yang terlantar, tidak ada tetangga - \"bukan siapa-siapa\". Ketika dua pencuri masuk ke rumahnya pada suatu malam, kemarahan Hutch yang tidak diketahui sejak lama menyala dan mendorongnya ke jalur brutal yang akan mengungkap rahasia gelap yang dia perjuangkan untuk ditinggalkan.",
                "Aksi, Cerita Seru, Kejahatan",
                "2021",
                "1h 32m",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/oBgWY00bEFeZ9N25wWVyuQddbAo.jpg",
                false,
                false
            )
        )

        movies.add(
            MovieEntity(
                "009",
                "Breach",
                "A hardened mechanic must stay awake and maintain an interstellar ark fleeing the dying planet Earth with a few thousand lucky souls on board... the last of humanity. Unfortunately, humans are not the only passengers. A shapeshifting alien creature has taken residence, its only goal is to kill as many people as possible. The crew must think quickly to stop this menace before it destroys mankind.",
                "Cerita Fiksi, Aksi",
                "2020",
                "1h 32m",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/13B6onhL6FzSN2KaNeQeMML05pS.jpg",
                false,
                false
            )
        )

        movies.add(
            MovieEntity(
                "010",
                "The Unholy",
                "Alice, a young hearing-impaired girl who, after a supposed visitation from the Virgin Mary, is inexplicably able to hear, speak and heal the sick. As word spreads and people from near and far flock to witness her miracles, a disgraced journalist hoping to revive his career visits the small New England town to investigate. When terrifying events begin to happen all around, he starts to question if these phenomena are the works of the Virgin Mary or something much more sinister.",
                "Kengerian",
                "2021",
                "1h 39m",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/b4gYVcl8pParX8AjkN90iQrWrWO.jpg",
                false,
                false
            )
        )
        return movies
    }

    fun generateDummySeries(): List<MovieEntity>{
        val series = ArrayList<MovieEntity>()

        series.add(
            MovieEntity(
                "011",
                "Supernatural",
                "Dua bersaudara mencari ayah mereka yang hilang, pria yang melatih mereka untuk menjadi prajurit melawan kejahatan supernatural",
                "Drama, Misteri, Sci-fi & Fantasy",
                "2005 - 2020",
                "45m",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/KoYWXbnYuS3b0GyQPkbuexlVK9.jpg",
                false,
                true
            )
        )

        series.add(
            MovieEntity(
                "012",
                "The Falcon and the Winter Soldier",
                "Following the events of “Avengers: Endgame”, the Falcon, Sam Wilson and the Winter Soldier, Bucky Barnes team up in a global adventure that tests their abilities, and their patience.",
                "Sci-fi & Fantasy, Aksi & Petualangan, Drama, Kejahatan dan Politik",
                "2021",
                "45m",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/6kbAMLteGO8yyewYau6bJ683sw7.jpg",
                false,
                true
            )
        )

        series.add(
            MovieEntity(
                "013",
                "The Flash",
                "Setelah akselerator partikel menyebabkan badai aneh, Penyelidik CSI Barry Allen disambar petir dan jatuh koma. Beberapa bulan kemudian dia terbangun dengan kekuatan kecepatan super, memberinya kemampuan untuk bergerak melalui Central City seperti malaikat penjaga yang tak terlihat. Meskipun awalnya senang dengan kekuatan barunya, Barry terkejut menemukan bahwa dia bukan satu-satunya \"manusia meta\" yang diciptakan setelah ledakan akselerator - dan tidak semua orang menggunakan kekuatan baru mereka untuk kebaikan. Barry bermitra dengan S.T.A.R. Lab dan mendedikasikan hidupnya untuk melindungi yang tidak bersalah. Untuk saat ini, hanya beberapa teman dekat dan rekan yang tahu bahwa Barry secara harfiah adalah manusia tercepat, tetapi tidak lama sebelum dunia mengetahui apa yang menjadi Barry Allen ... The Flash.",
                "Drama, Sci-fi & Fantasy",
                "2014 - 2021",
                "45m",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/wHa6KOJAoNTFLFtp7wguUJKSnju.jpg",
                false,
                true
            )
        )

        series.add(
            MovieEntity(
                "014",
                "The Good Doctor",
                "A young surgeon with Savant syndrome is recruited into the surgical unit of a prestigious hospital. The question will arise: can a person who doesn't have the ability to relate to people actually save their lives",
                "Drama",
                "2017 - 2021",
                "45m",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/z1K4mJwISETia59rrnMdXxzoSrZ.jpg",
                false,
                true
            )
        )

        series.add(
            MovieEntity(
                "015",
                "Lucifer",
                "Bosan dan tidak bahagia sebagai Penguasa Neraka, Lucifer Morningstar meninggalkan tahtanya dan pensiun ke Los Angeles, di mana ia telah bekerja sama dengan detektif LAPD Chloe Decker untuk menjatuhkan penjahat. Tapi semakin lama dia menjauh dari dunia bawah, semakin besar ancaman bahwa yang terburuk dari umat manusia dapat melarikan diri.",
                "Kejahatan, Sci-fi & Fantasy",
                "2016 - 2020",
                "45m",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/vkGnVBSNpayJ1oCfyVaMvhrim95.jpg",
                false,
                true
            )
        )

        series.add(
            MovieEntity(
                "016",
                "WandaVision",
                "Wanda Maximoff dan Vision — dua makhluk bertenaga super yang menjalani kehidupan pinggiran kota yang ideal — mulai curiga bahwa semuanya tidak seperti yang terlihat.",
                "Sci-fi & Fantasy, Misteri, Drama",
                "2021",
                "45m",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/frobUz2X5Pc8OiVZU8Oo5K3NKMM.jpg",
                false,
                true
            )
        )

        series.add(
            MovieEntity(
                "017",
                "Game of Thrones",
                "Tujuh keluarga bangsawan berjuang untuk menguasai tanah mitos Westeros. Gesekan antara rumah-rumah mengarah ke perang skala penuh. Semua sementara kejahatan yang sangat kuno terbangun di utara terjauh. Di tengah-tengah perang, perintah militer yang diabaikan, Night's Watch, adalah yang berdiri di antara alam manusia dan kengerian es di luarnya.",
                "Sci-fi & Fantasy, Drama, Aksi & Petualangan",
                "2011 - 2020",
                "45m",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/u3bZgnGQ9T01sWNhyveQz0wH0Hl.jpg",
                false,
                true
            )
        )

        series.add(
            MovieEntity(
                "018",
                "Vikings",
                "The adventures of Ragnar Lothbrok, the greatest hero of his age. The series tells the sagas of Ragnar's band of Viking brothers and his family, as he rises to become King of the Viking tribes. As well as being a fearless warrior, Ragnar embodies the Norse traditions of devotion to the gods. Legend has it that he was a direct descendant of Odin, the god of war and warriors.",
                "Aksi & Petualangan, Drama",
                "2013 - 2020",
                "45m",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/oktTNFM8PzdseiK1X0E0XhB6LvP.jpg",
                false,
                true
            )
        )

        series.add(
            MovieEntity(
                "019",
                "Legacies",
                "In a place where young witches, vampires, and werewolves are nurtured to be their best selves in spite of their worst impulses, Klaus Mikaelson’s daughter, 17-year-old Hope Mikaelson, Alaric Saltzman’s twins, Lizzie and Josie Saltzman, among others, come of age into heroes and villains at The Salvatore School for the Young and Gifted.",
                "Sci-fi & Fantasy, Drama",
                "2018 - 2021",
                "45m",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/qTZIgXrBKURBK1KrsT7fe3qwtl9.jpg",
                false,
                true
            )
        )

        series.add(
            MovieEntity(
                "020",
                "Stranger Things",
                "Ketika seorang bocah lelaki menghilang, sebuah kota kecil mengungkap misteri yang melibatkan eksperimen rahasia, kekuatan gaib yang menakutkan, dan seorang gadis kecil yang aneh.",
                "Sci-fi & Fantasy, Misteri, Drama",
                "2016 - 2019",
                "45m",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/9URpkzaMMLK5bdJ1a5HBafzYEWj.jpg",
                false,
                true
            )
        )


        return series
    }

    fun generateRemoteDummyMovies() : List<MovieResponse>{

        val movies = ArrayList<MovieResponse>()

        movies.add(
                MovieResponse(
                        "001",
                        "A Star Is Born",
                        "Seorang bintang musik country yang karirnya mulai memudar, Jackson Maine (Bradley Cooper) menemukan sebuah talenta yang sangat berbakat di dalam diri dari seorang musisi muda bernama Ally (Lady Gaga). Maine berhasil mengorbitkan Ally menjadi seorang bintang muda yang menjanjikan. Namun keduanya terlibat hubungan yang lebih jauh dari sekedar mentor dan anak didik. Seiring dengan meroketnya karir dari Ally dan dirinya, Maine mengalami dilema mengenai masalah ini.",
                        "Drama, Percintaan, Musik",
                        "2018",
                        "2h 16m",
                        "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/wrFpXMNBRj2PBiN4Z5kix51XaIZ.jpg")
        )

        movies.add(
                MovieResponse(
                        "002",
                        "Alita: Battle Angel",
                        "Ketika Alita terbangun tanpa ingatan tentang siapa dia di dunia masa depan yang tidak dia kenal, dia ditangkap oleh Ido, seorang dokter yang penuh kasih yang menyadari bahwa di suatu tempat dalam cangkang cyborg yang ditinggalkan ini adalah hati dan jiwa seorang wanita muda dengan luar biasa. lalu.",
                        "Aksi, Cerita Fiksi, Petualangan",
                        "2019",
                        "2h 2m",
                        "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/xRWht48C2V8XNfzvPehyClOvDni.jpg"
                )
        )

        movies.add(
                MovieResponse(
                        "003",
                        "Aquaman",
                        "Once home to the most advanced civilization on Earth, Atlantis is now an underwater kingdom ruled by the power-hungry King Orm. With a vast army at his disposal, Orm plans to conquer the remaining oceanic people and then the surface world. Standing in his way is Arthur Curry, Orm's half-human, half-Atlantean brother and true heir to the throne.",
                        "Aksi, Petualangan, Fantasi",
                        "2018",
                        "2h 23m",
                        "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/xLPffWMhMj1l50ND3KchMjYoKmE.jpg"
                )
        )

        movies.add(
                MovieResponse(
                        "004",
                        "Bohemian Rhapsody ",
                        "Singer Freddie Mercury, guitarist Brian May, drummer Roger Taylor and bass guitarist John Deacon take the music world by storm when they form the rock 'n' roll band Queen in 1970. Hit songs become instant classics. When Mercury's increasingly wild lifestyle starts to spiral out of control, Queen soon faces its greatest challenge yet – finding a way to keep the band together amid the success and excess.",
                        "Musik, Drama, Sejarah",
                        "2018",
                        "2h 15m",
                        "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/lHu1wtNaczFPGFDTrjCSzeLPTKN.jpg"
                )
        )

        movies.add(
                MovieResponse(
                        "005",
                        "Fast & Furious Presents: Hobbs & Shaw",
                        "Hobbs & Shaw (2019) cinema film baru barat yang sangat seru Ini bercerita Luke Hobbs (Dwayne Johnson) terpaksa membentuk aliansi yang mustahil dengan Deckard Shaw (Jason Statham). Keduanya terpaksa bersatu membantu Hattie Shaw (Vanessa Kirby) untuk memburu senjata virus berbahaya dan Brixton (Idris Elba). Brixton adalah penjahat jenis baru yang berhasil mengubah dirinya menjadi manusia super. Keberadaanya menjadi ancaman bagi umat manusia.",
                        "Aksi, Petualangan, Komedi",
                        "2019",
                        "2h 17m",
                        "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/qRyy2UmjC5ur9bDi3kpNNRCc5nc.jpg"
                )
        )

        movies.add(
                MovieResponse(
                        "006",
                        "Mulan",
                        "When the Emperor of China issues a decree that one man per family must serve in the Imperial Chinese Army to defend the country from Huns, Hua Mulan, the eldest daughter of an honored warrior, steps in to take the place of her ailing father. She is spirited, determined and quick on her feet. Disguised as a man by the name of Hua Jun, she is tested every step of the way and must harness her innermost strength and embrace her true potential.",
                        "Petualangan, Fantasi",
                        "2020",
                        "1h 55m",
                        "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/aKx1ARwG55zZ0GpRvU2WrGrCG9o.jpg"
                )
        )

        movies.add(
                MovieResponse(
                        "007",
                        "Mortal Kombat",
                        "Washed-up MMA fighter Cole Young, unaware of his heritage, and hunted by Emperor Shang Tsung's best warrior, Sub-Zero, seeks out and trains with Earth's greatest champions as he prepares to stand against the enemies of Outworld in a high stakes battle for the universe.",
                        "Fantasi, Aksi, Petualangan, Cerita Fiksi, Cerita Seru",
                        "2021",
                        "1h 50m",
                        "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/yiu9ISHAbbZATKl0FaMPh8is7Oa.jpg"
                )
        )

        movies.add(
                MovieResponse(
                        "008",
                        "Nobody",
                        "Hutch Mansell, seorang ayah di pinggiran kota, suami yang terlantar, tidak ada tetangga - \"bukan siapa-siapa\". Ketika dua pencuri masuk ke rumahnya pada suatu malam, kemarahan Hutch yang tidak diketahui sejak lama menyala dan mendorongnya ke jalur brutal yang akan mengungkap rahasia gelap yang dia perjuangkan untuk ditinggalkan.",
                        "Aksi, Cerita Seru, Kejahatan",
                        "2021",
                        "1h 32m",
                        "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/oBgWY00bEFeZ9N25wWVyuQddbAo.jpg"
                )
        )

        movies.add(
                MovieResponse(
                        "009",
                        "Breach",
                        "A hardened mechanic must stay awake and maintain an interstellar ark fleeing the dying planet Earth with a few thousand lucky souls on board... the last of humanity. Unfortunately, humans are not the only passengers. A shapeshifting alien creature has taken residence, its only goal is to kill as many people as possible. The crew must think quickly to stop this menace before it destroys mankind.",
                        "Cerita Fiksi, Aksi",
                        "2020",
                        "1h 32m",
                        "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/13B6onhL6FzSN2KaNeQeMML05pS.jpg"
                )
        )

        movies.add(
                MovieResponse(
                        "010",
                        "The Unholy",
                        "Alice, a young hearing-impaired girl who, after a supposed visitation from the Virgin Mary, is inexplicably able to hear, speak and heal the sick. As word spreads and people from near and far flock to witness her miracles, a disgraced journalist hoping to revive his career visits the small New England town to investigate. When terrifying events begin to happen all around, he starts to question if these phenomena are the works of the Virgin Mary or something much more sinister.",
                        "Kengerian",
                        "2021",
                        "1h 39m",
                        "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/b4gYVcl8pParX8AjkN90iQrWrWO.jpg"
                )
        )
        return movies
    }

    fun generateRemoteDummySeries(): List<MovieResponse>{
        val series = ArrayList<MovieResponse>()

        series.add(
                MovieResponse(
                        "011",
                        "Supernatural",
                        "Dua bersaudara mencari ayah mereka yang hilang, pria yang melatih mereka untuk menjadi prajurit melawan kejahatan supernatural",
                        "Drama, Misteri, Sci-fi & Fantasy",
                        "2005 - 2020",
                        "45m",
                        "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/KoYWXbnYuS3b0GyQPkbuexlVK9.jpg"
                )
        )

        series.add(
                MovieResponse(
                        "012",
                        "The Falcon and the Winter Soldier",
                        "Following the events of “Avengers: Endgame”, the Falcon, Sam Wilson and the Winter Soldier, Bucky Barnes team up in a global adventure that tests their abilities, and their patience.",
                        "Sci-fi & Fantasy, Aksi & Petualangan, Drama, Kejahatan dan Politik",
                        "2021",
                        "45m",
                        "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/6kbAMLteGO8yyewYau6bJ683sw7.jpg"
                )
        )

        series.add(
                MovieResponse(
                        "013",
                        "The Flash",
                        "Setelah akselerator partikel menyebabkan badai aneh, Penyelidik CSI Barry Allen disambar petir dan jatuh koma. Beberapa bulan kemudian dia terbangun dengan kekuatan kecepatan super, memberinya kemampuan untuk bergerak melalui Central City seperti malaikat penjaga yang tak terlihat. Meskipun awalnya senang dengan kekuatan barunya, Barry terkejut menemukan bahwa dia bukan satu-satunya \"manusia meta\" yang diciptakan setelah ledakan akselerator - dan tidak semua orang menggunakan kekuatan baru mereka untuk kebaikan. Barry bermitra dengan S.T.A.R. Lab dan mendedikasikan hidupnya untuk melindungi yang tidak bersalah. Untuk saat ini, hanya beberapa teman dekat dan rekan yang tahu bahwa Barry secara harfiah adalah manusia tercepat, tetapi tidak lama sebelum dunia mengetahui apa yang menjadi Barry Allen ... The Flash.",
                        "Drama, Sci-fi & Fantasy",
                        "2014 - 2021",
                        "45m",
                        "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/wHa6KOJAoNTFLFtp7wguUJKSnju.jpg"
                )
        )

        series.add(
                MovieResponse(
                        "014",
                        "The Good Doctor",
                        "A young surgeon with Savant syndrome is recruited into the surgical unit of a prestigious hospital. The question will arise: can a person who doesn't have the ability to relate to people actually save their lives",
                        "Drama",
                        "2017 - 2021",
                        "45m",
                        "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/z1K4mJwISETia59rrnMdXxzoSrZ.jpg"
                )
        )

        series.add(
                MovieResponse(
                        "015",
                        "Lucifer",
                        "Bosan dan tidak bahagia sebagai Penguasa Neraka, Lucifer Morningstar meninggalkan tahtanya dan pensiun ke Los Angeles, di mana ia telah bekerja sama dengan detektif LAPD Chloe Decker untuk menjatuhkan penjahat. Tapi semakin lama dia menjauh dari dunia bawah, semakin besar ancaman bahwa yang terburuk dari umat manusia dapat melarikan diri.",
                        "Kejahatan, Sci-fi & Fantasy",
                        "2016 - 2020",
                        "45m",
                        "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/vkGnVBSNpayJ1oCfyVaMvhrim95.jpg"
                )
        )

        series.add(
                MovieResponse(
                        "016",
                        "WandaVision",
                        "Wanda Maximoff dan Vision — dua makhluk bertenaga super yang menjalani kehidupan pinggiran kota yang ideal — mulai curiga bahwa semuanya tidak seperti yang terlihat.",
                        "Sci-fi & Fantasy, Misteri, Drama",
                        "2021",
                        "45m",
                        "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/frobUz2X5Pc8OiVZU8Oo5K3NKMM.jpg"
                )
        )

        series.add(
                MovieResponse(
                        "017",
                        "Game of Thrones",
                        "Tujuh keluarga bangsawan berjuang untuk menguasai tanah mitos Westeros. Gesekan antara rumah-rumah mengarah ke perang skala penuh. Semua sementara kejahatan yang sangat kuno terbangun di utara terjauh. Di tengah-tengah perang, perintah militer yang diabaikan, Night's Watch, adalah yang berdiri di antara alam manusia dan kengerian es di luarnya.",
                        "Sci-fi & Fantasy, Drama, Aksi & Petualangan",
                        "2011 - 2020",
                        "45m",
                        "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/u3bZgnGQ9T01sWNhyveQz0wH0Hl.jpg"
                )
        )

        series.add(
                MovieResponse(
                        "018",
                        "Vikings",
                        "The adventures of Ragnar Lothbrok, the greatest hero of his age. The series tells the sagas of Ragnar's band of Viking brothers and his family, as he rises to become King of the Viking tribes. As well as being a fearless warrior, Ragnar embodies the Norse traditions of devotion to the gods. Legend has it that he was a direct descendant of Odin, the god of war and warriors.",
                        "Aksi & Petualangan, Drama",
                        "2013 - 2020",
                        "45m",
                        "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/oktTNFM8PzdseiK1X0E0XhB6LvP.jpg"
                )
        )

        series.add(
                MovieResponse(
                        "019",
                        "Legacies",
                        "In a place where young witches, vampires, and werewolves are nurtured to be their best selves in spite of their worst impulses, Klaus Mikaelson’s daughter, 17-year-old Hope Mikaelson, Alaric Saltzman’s twins, Lizzie and Josie Saltzman, among others, come of age into heroes and villains at The Salvatore School for the Young and Gifted.",
                        "Sci-fi & Fantasy, Drama",
                        "2018 - 2021",
                        "45m",
                        "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/qTZIgXrBKURBK1KrsT7fe3qwtl9.jpg"
                )
        )

        series.add(
                MovieResponse(
                        "020",
                        "Stranger Things",
                        "Ketika seorang bocah lelaki menghilang, sebuah kota kecil mengungkap misteri yang melibatkan eksperimen rahasia, kekuatan gaib yang menakutkan, dan seorang gadis kecil yang aneh.",
                        "Sci-fi & Fantasy, Misteri, Drama",
                        "2016 - 2019",
                        "45m",
                        "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/9URpkzaMMLK5bdJ1a5HBafzYEWj.jpg"
                )
        )


        return series
    }
}