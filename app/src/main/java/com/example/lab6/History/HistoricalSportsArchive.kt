package com.example.lab6.History

class HistoricalSportsArchive(val name:String, val description:String, val date:String) {
    companion object {
        fun createSample(): MutableList<HistoricalSportsArchive> {
            val historicalSportsArchiveList = mutableListOf<HistoricalSportsArchive>()
            historicalSportsArchiveList.add(
                HistoricalSportsArchive(
                    "History 1",
                    "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Curabitur vel.",
                    "Apr, 1 2024"
                )
            )
            historicalSportsArchiveList.add(
                HistoricalSportsArchive(
                    "History 2",
                    "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Maecenas vestibulum.",
                    "Apr, 2 2024"
                )
            )
            historicalSportsArchiveList.add(
                HistoricalSportsArchive(
                    "History 3",
                    "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec justo. ",
                    "Apr, 3 2024"
                )
            )
            historicalSportsArchiveList.add(
                HistoricalSportsArchive(
                    "History 4",
                    "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean ac. ",
                    "Apr, 4 2024"
                )
            )
            historicalSportsArchiveList.add(
                HistoricalSportsArchive(
                    "Histroy 5",
                    "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Praesent commodo.",
                    "Apr, 5 2024"
                )
            )

            return historicalSportsArchiveList
        }
    }
}