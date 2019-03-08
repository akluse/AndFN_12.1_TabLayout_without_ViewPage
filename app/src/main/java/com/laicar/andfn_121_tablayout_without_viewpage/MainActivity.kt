package com.laicar.andfn_121_tablayout_without_viewpage

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.app.FragmentTransaction
import android.widget.FrameLayout
import android.widget.TableLayout
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var frameLayout: FrameLayout? = null
    var tabLayout: TabLayout? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        this.frameLayout = findViewById<FrameLayout>(R.id.frameLayout)
        tabLayout = findViewById<TabLayout>(R.id.tabLayout)

        val fragment = ChildFragment()
        val frameManager = supportFragmentManager
        val fragmentTransation = frameManager.beginTransaction()
        fragmentTransation.replace(R.id.frameLayout, fragment)
        fragmentTransation.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)

        fragmentTransation.commit()


        tabLayout?.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabReselected(p0: TabLayout.Tab?) {

            }

            override fun onTabUnselected(p0: TabLayout.Tab?) {

            }

            override fun onTabSelected(tab: TabLayout.Tab?) {
                val pos = tab?.position;
                when (pos) {
                    1 -> supportFragmentManager.beginTransaction()
                        .replace(R.id.frameLayout, BlankFragment()).commit()
                    0 ->supportFragmentManager.beginTransaction()
                        .replace(R.id.frameLayout,ChildFragment()).commit()
                }
            }

        })
    }
}
