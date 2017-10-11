package com.martino.jasiu.learnkotlin.mainmenu.presentation.ui

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.design.widget.Snackbar
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.view.Menu
import android.view.MenuItem
import com.martino.jasiu.learnkotlin.R
import com.martino.jasiu.learnkotlin.db.dao.WordDao
import com.martino.jasiu.learnkotlin.general.presentation.CommonActivity
import com.martino.jasiu.learnkotlin.mainmenu.presentation.viewmodel.MainMenuActivityViewModel
import com.martino.jasiu.learnkotlin.manage.presentation.ui.ManageActivity
import kotlinx.android.synthetic.main.activity_main_menu.*
import kotlinx.android.synthetic.main.app_bar_main.*
import javax.inject.Inject


class MainMenuActivity : CommonActivity<MainMenuActivityViewModel>(), NavigationView.OnNavigationItemSelectedListener {

    @Inject
    lateinit var dao: WordDao

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_menu)
        setSupportActionBar(toolbar)

        var list = dao.findAllWords()

        initFloatingActionButton()
        initDrawer()

        nav_view.setNavigationItemSelectedListener(this@MainMenuActivity)
    }

    private fun initDrawer() {
        val toggle = ActionBarDrawerToggle(this, drawer_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()
    }

    private fun initFloatingActionButton() {
        fab.setOnClickListener { view ->
            Snackbar.make(view, "Function do not work, yet :D", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }
    }

    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        when (item.itemId) {
            R.id.action_settings -> return true
            else -> return super.onOptionsItemSelected(item)
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        when (item.itemId) {
            R.id.nav_settings -> {
                // Handle the camera action
            }
            R.id.nav_send -> {

            }
            R.id.nav_share -> {

            }
            R.id.nav_manage -> {
                startActivity(Intent(this@MainMenuActivity, ManageActivity::class.java))
            }
        }

        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }

}
