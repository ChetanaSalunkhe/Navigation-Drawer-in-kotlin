package com.chetana.navigationdrawer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.PointerIcon
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.appbarlayout.*

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener{

    override fun onNavigationItemSelected(menu_item: MenuItem): Boolean {

        when(menu_item.itemId){
            R.id.menu_gps ->{
                Toast.makeText(this,"GPS",Toast.LENGTH_SHORT).show()
            }

            R.id.menu_splash->{
                Toast.makeText(this,"Splash SCreen",Toast.LENGTH_SHORT).show()
            }

            R.id.menu_webpage->{
                Toast.makeText(this,"Implicit Intent",Toast.LENGTH_SHORT).show()
            }

        }

        drawerlayout.closeDrawer(GravityCompat.START)

      return true;
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toolBar : Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        val drawerlayout:DrawerLayout = findViewById(R.id.drawerlayout);

        val toggle = ActionBarDrawerToggle(this, drawerlayout, toolBar, R.string.navdraweropne, R.string.navdrawerclose)
        drawerlayout.addDrawerListener(toggle)
        toggle.isDrawerIndicatorEnabled = true
        toggle.isDrawerSlideAnimationEnabled = true

        val header = nav_view.getHeaderView(0);
        val imgprof : ImageView = header.findViewById(R.id.imgprof)
        imgprof.setImageResource(R.drawable.profile)

        nav_view.setNavigationItemSelectedListener(this)
    }

    override fun onBackPressed() {
        if(drawerlayout.isDrawerOpen(GravityCompat.START)){
            drawerlayout.closeDrawer(GravityCompat.START)

        }else{
            super.onBackPressed()
        }
    }
}

