package com.garden.menagarden

import android.content.ComponentName
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.telephony.PhoneNumberUtils
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.app_bar_main.*
import com.garden.menagarden.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {


    private lateinit var appBarConfiguration: AppBarConfiguration

    private lateinit var binding: ActivityMainBinding



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        

        // botón flotante para Whatsapp




        val fab : FloatingActionButton = findViewById(R.id.fab)
        fab.setOnClickListener {

            val smsNumber = "34952520541"
            val isWhatsappInstalled = "com.whatsapp".whatsappInstalledOrNot()


            if (isWhatsappInstalled) {
                val sendIntent = Intent("android.intent.action.MAIN")
                sendIntent.component = ComponentName("com.whatsapp", "com.whatsapp.Conversation")
                sendIntent.putExtra("jid", PhoneNumberUtils.stripSeparators(smsNumber) + "@s.whatsapp.net")//prefijo teléfono de país sin el +
                startActivity(sendIntent)

            } else {
                val uri = Uri.parse("market://details?id=com.whatsapp")
                val goToMarket = Intent(Intent.ACTION_VIEW, uri)
                Toast.makeText(this, "WhatsApp not Installed",
                    Toast.LENGTH_SHORT).show()
                startActivity(goToMarket)
            }

        }


        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        val navView: NavigationView = findViewById(R.id.nav_view)



        val navController = findNavController(R.id.nav_host_fragment)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        appBarConfiguration = AppBarConfiguration(setOf(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_menu, R.id.nav_cocktails,R.id.nav_reservar,R.id.nav_specialoffers), drawerLayout)

        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main_activity, menu)
        return true
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }


    //Botón flotante de Whatsapp. si el dispositivo no tiene instalado whatsapp

    private fun String.whatsappInstalledOrNot(): Boolean {
        val pm = packageManager
        return try {
            pm.getPackageInfo(this, PackageManager.GET_ACTIVITIES)
            true
        } catch (e: PackageManager.NameNotFoundException) {
            false
        }
    }

    // mostrar o esconder el floatingbutton // posteriormente llamada en los fragments

    fun showFloatingActionButton() {
        fab.show()
    }
    fun hideFloatingActionButton() {
        fab.hide()
    }



    override fun onOptionsItemSelected(item: MenuItem): Boolean {   // share button and exit appbar

        when (item.itemId) {

            R.id.action_rate -> {

                val uri = Uri.parse("https://play.google.com/store/apps/details?id=com.garden.menagarden")
                val goPlayStore = Intent(Intent.ACTION_VIEW, uri)
                startActivity(goPlayStore)
            }

            R.id.share -> {    // compartir información del App para facebook, whatsapp etc...

                val sendIntent = Intent().apply {

                    action = Intent.ACTION_SEND
                    putExtra(
                        Intent.EXTRA_TEXT,
                        "Descargar App Mena Garden en Play Store https://play.google.com/store/apps/details?id=com.garden.menagarden"
                    )
                    type = "text/plain"
                }

                val shareIntent = Intent.createChooser(sendIntent, null)
                startActivity(shareIntent)

            }

        }

        return super.onOptionsItemSelected(item)

    }


}