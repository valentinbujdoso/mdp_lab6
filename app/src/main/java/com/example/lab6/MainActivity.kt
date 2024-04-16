package com.example.lab6

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.example.lab6.Athlete.AthleteFragment
import com.example.lab6.Event.EventFragment
import com.example.lab6.History.HistoricalSportsArchiveFragment
import com.example.lab6.News.NewsFragment
import com.example.lab6.Sport.SportsFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator


class MainActivity : AppCompatActivity() {
    private lateinit var pager: ViewPager2
    private lateinit var tabLayout: TabLayout
    private lateinit var navView: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        pager = findViewById(R.id.viewPager)
        tabLayout = findViewById(R.id.tabs)
        navView = findViewById(R.id.bottomNav)

        navView.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.news -> {
                    tabLayout.selectTab(tabLayout.getTabAt(1))
                    true
                }

                R.id.event -> {
                    tabLayout.selectTab(tabLayout.getTabAt(3))
                    true
                }

                R.id.history -> {
                    tabLayout.selectTab(tabLayout.getTabAt(4))
                    true
                }

                else -> { true}
            }
        }

        val fragments = listOf(SportsFragment(), NewsFragment(), AthleteFragment(),
            EventFragment(), HistoricalSportsArchiveFragment(), AboutMeFragment())
        pager.orientation = ViewPager2.ORIENTATION_HORIZONTAL;
        pager.adapter = ViewPagerAdapter(fragments, supportFragmentManager)

        val titles = mutableListOf("Sports", "News", "Athletes", "Events", "Historical Sports Archive", "About Me")
        TabLayoutMediator(tabLayout, pager) { tab, position ->
            tab.text = (titles[position])
        }.attach()

        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                when (tab?.text) {
                    "Sports" -> {
                        pager.setCurrentItem(0, true)
                    }
                    "News" -> {
                        pager.setCurrentItem(1, true)
                    }
                    "Athletes" -> {
                        pager.setCurrentItem(2, true)
                    }
                    "Events" -> {
                        pager.setCurrentItem(3, true)
                    }
                    "Historical Sports Archive" -> {
                        pager.setCurrentItem(4, true)
                    }
                    "About Me" -> {
                        pager.setCurrentItem(5, true)
                    }
                }
            }
            override fun onTabUnselected(tab: TabLayout.Tab?) {
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
            }
        })
    }

    private inner class ViewPagerAdapter(private val fragments: List<Fragment>, fragmentManager: FragmentManager) :
        FragmentStateAdapter(fragmentManager, lifecycle) {

        override fun getItemCount(): Int = fragments.size

        override fun createFragment(position: Int): Fragment = fragments[position]
    }
}