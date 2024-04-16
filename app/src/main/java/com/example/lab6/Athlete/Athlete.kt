package com.example.lab6.Athlete

class Athlete(val name:String,val sport:String, val country:String,
              val performance:String, val medals:String, val facts:String
) {
    companion object {
        fun createSample(): MutableList<Athlete> {
            val athleteList = mutableListOf<Athlete>()
            athleteList.add(
                Athlete(
                    "Athlete 1",
                    "Sport 1",
                    "Hungary",
                    "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus ut mattis velit, ac sagittis dui. ",
                    "Gold",
                    "Proin efficitur molestie nisi, sit amet dignissim justo varius euismod. Cras sollicitudin iaculis lacus, sit amet rhoncus tellus hendrerit ac."
                )
            )

            athleteList.add(
                Athlete(
                    "Athlete 2",
                    "Sport 2",
                    "Hungary",
                    "Duis eu pretium ligula. Maecenas venenatis dolor at blandit auctor. Nam aliquam consectetur risus a porttitor. Aenean vel turpis arcu. Mauris congue bibendum lacus.",
                    "Gold",
                    "Nunc elementum dolor et erat interdum elementum. Pellentesque porta ligula a nunc lacinia mattis. Vivamus cursus leo eu enim auctor tincidunt. "
                )
            )

            athleteList.add(
                Athlete(
                    "Athlete 3",
                    "Sport 3",
                    "Hungary",
                    "Mauris elementum sollicitudin odio eu ultricies. Aenean ut sapien nibh.",
                    "Gold",
                    "Nam aliquam posuere magna, gravida iaculis purus mattis non. Maecenas nec quam et tellus consequat hendrerit eget vel urna."
                )
            )

            athleteList.add(
                Athlete(
                    "Athlete 4",
                    "Sport 4",
                    "Hungary",
                    "Aliquam nulla neque, lobortis id neque at, facilisis placerat tellus. Praesent eget metus id magna condimentum sagittis. Integer dignissim vehicula libero ut egestas.",
                    "Gold",
                    "Curabitur aliquet tincidunt tristique. Aliquam ac dolor a odio rhoncus ullamcorper. Nam eu laoreet tortor. Proin sed pellentesque quam. "
                )
            )

            athleteList.add(
                Athlete(
                    "Athlete 5",
                    "Sport 5",
                    "Hungary",
                    "Sed vulputate, erat a imperdiet efficitur, mauris arcu feugiat velit, vitae tincidunt sem ligula sed velit. In velit diam, gravida vitae condimentum a, lacinia vel purus.",
                    "Gold",
                    "Sed ante quam, euismod ac magna vitae, feugiat blandit nunc. Integer placerat tortor vel tellus pharetra, at consequat dui malesuada. Proin elementum sagittis lectus. "
                )
            )

            athleteList.add(
                Athlete(
                    "Athlete 6",
                    "Sport 6",
                    "Hungary",
                    "Etiam fermentum lobortis dolor, non semper mauris ornare eget. Proin venenatis efficitur sapien, id dignissim tellus aliquam et. Sed rhoncus nulla turpis, nec venenatis elit efficitur a. ",
                    "Gold",
                    "Quisque sed pretium erat. Praesent imperdiet, dui eget imperdiet egestas, odio dui viverra nulla, eu consectetur dui massa ac mi. Maecenas aliquet iaculis elit, id eleifend risus mollis sed"
                )
            )

            return athleteList
        }
    }
}