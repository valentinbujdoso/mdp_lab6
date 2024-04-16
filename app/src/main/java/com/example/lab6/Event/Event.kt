package com.example.lab6.Event

class Event(val name:String,val description:String, val date:String) {
    companion object {
        fun createSample(): MutableList<Event> {
            val eventList = mutableListOf<Event>()
            eventList.add(
                Event(
                    "Event 1",
                    " Integer eu lacus laoreet, hendrerit nisi pulvinar, faucibus ligula.",
                    "Apr, 1 2024"
                )
            )
            eventList.add(
                Event(
                    "Event 2",
                    "Maecenas interdum vel lorem ut venenatis.",
                    "Apr, 2 2024"
                )
            )
            eventList.add(
                Event(
                    "Event 3",
                    "Pellentesque a venenatis massa. Morbi et cursus ante, vitae lacinia diam.",
                    "Apr, 3 2024"
                )
            )
            eventList.add(
                Event(
                    "Event 4",
                    "Aliquam ornare diam neque, in semper neque rutrum rutrum.",
                    "Apr, 4 2024"
                )
            )
            eventList.add(
                Event(
                    "Event 5",
                    "Aliquam maximus consectetur purus et ultrices.",
                    "Apr, 5 2024"
                )
            )

            return eventList
        }
    }
}