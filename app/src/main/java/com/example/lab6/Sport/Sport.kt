package com.example.lab6.Sport

class Sport(val type: String, val name: String, val instruction: String) {
    companion object {
        fun createSample(): MutableList<Sport> {
            val sportList = mutableListOf<Sport>()

            sportList.add(
                Sport(
                    "Measure",
                    "Running",
                    "Mauris accumsan augue ligula, quis gravida diam fringilla sit amet. Praesent luctus nec arcu id interdum. Suspendisse elementum ac orci in faucibus."
                )
            )
            sportList.add(
                Sport(
                    "Precision",
                    "Golf",
                    "Donec at tincidunt magna. Praesent egestas risus nec ipsum vestibulum blandit. Suspendisse laoreet condimentum tempor. Nam facilisis enim risus."
                )
            )
            sportList.add(
                Sport(
                    "Combat",
                    "Box",
                    "Nulla aliquet dapibus dapibus. Nam tincidunt commodo justo convallis blandit. Vivamus dui odio, lacinia et laoreet in, mollis ut elit. Mauris blandit ligula vel volutpat placerat. "
                )
            )
            sportList.add(
                Sport(
                    "Play",
                    "Football",
                    "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aliquam sodales imperdiet elementum. Sed tristique purus semper leo fermentum finibus eu vel turpis. Integer eget augue id sem sollicitudin tristique vulputate sit amet nibh"
                )
            )
            sportList.add(
                Sport(
                    "Spectacle",
                    "Surfing",
                    "Aenean ultricies justo quis quam accumsan, quis iaculis turpis lobortis. Ut nec ante ut augue rutrum elementum non et nunc. Curabitur egestas est a mauris egestas, at pretium nunc accumsan"
                )
            )
            return sportList
        }
    }
}
