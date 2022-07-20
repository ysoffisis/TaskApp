package jp.techacademy.yoshitsugu.taskapp

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import com.google.android.material.snackbar.Snackbar
import jp.techacademy.yoshitsugu.taskapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var mTaskAdapter: TaskAdapter

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        val listView1 = findViewById<ListView>(R.id.listView1)

        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }

        mTaskAdapter = TaskAdapter(this)

        /*
        listView1.setOnItemClickListener {parent, view, position, id ->
            true
        }

        listView1.setOnItemLongClickListener{parent, view, position, id ->
            true
        }
         */

        reloadListView()
    }

    private fun reloadListView() {
        val listView1 = findViewById<ListView>(R.id.listView1)

        val taskList = mutableListOf<String>("aaa","bbb","ccc")

        mTaskAdapter.mTaskList = taskList
        listView1.adapter = mTaskAdapter
        mTaskAdapter.notifyDataSetChanged()
    }

    /*
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        return navController.navigateUp(appBarConfiguration)
                || super.onSupportNavigateUp()
    }
     */
}