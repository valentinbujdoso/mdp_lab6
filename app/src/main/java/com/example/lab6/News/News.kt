package com.example.lab6.News

class News(val name:String, val url:String, val description:String) {
    companion object {
        fun createSample(): MutableList<News> {
            val newsList = mutableListOf<News>()

            newsList.add(
                News(
                    "News 1",
                    "https://images.unsplash.com/photo-1569965335962-2317ff2a7658?w=900&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxleHBsb3JlLWZlZWR8NXx8fGVufDB8fHx8fA%3D%3D",
                    "Ut fringilla ipsum eget consectetur fermentum. Pellentesque a tincidunt metus. Maecenas ac commodo risus. Proin aliquam ligula erat, nec ullamcorper diam congue sit amet. Proin suscipit leo nec turpis eleifend sagittis"
                )
            )
            newsList.add(
                News(
                    "News 2",
                    "https://images.unsplash.com/photo-1584890131712-18ee8e3ed49c?w=900&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxleHBsb3JlLWZlZWR8OXx8fGVufDB8fHx8fA%3D%3D",
                    "Cras maximus eleifend lacus at venenatis. Nullam porttitor, ex vel imperdiet vulputate, tellus odio semper metus, in congue augue ex ac nunc. Nullam suscipit iaculis finibus. "
                )
            )

            newsList.add(
                News(
                    "News 3",
                    "https://images.unsplash.com/photo-1569116011158-3ac1ba68ddba?w=900&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxleHBsb3JlLWZlZWR8MTN8fHxlbnwwfHx8fHw%3D",
                    "Nam porta id urna auctor aliquam. Sed eleifend augue ut ex ullamcorper, eu tincidunt lacus maximus. Phasellus fringilla, diam ac efficitur posuere, nulla lectus sagittis nisi, at dignissim turpis lacus at mauris. Phasellus varius, nisl eget egestas ornare, libero velit finibus diam, id varius nibh est a enim. Morbi tincidunt purus sit amet aliquam feugiat. Ut in eleifend urna, eget pharetra urna."
                )
            )

            newsList.add(
                News(
                    "News 4",
                    "https://images.unsplash.com/photo-1593341646782-e0b495cff86d?w=900&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxleHBsb3JlLWZlZWR8MTJ8fHxlbnwwfHx8fHw%3D",
                    "Nullam non vulputate felis, sed finibus eros. Etiam vestibulum dui quis sagittis finibus. Vestibulum eleifend at tortor eget aliquam. Duis at fringilla lacus."
                )
            )
            return newsList
        }
    }
}