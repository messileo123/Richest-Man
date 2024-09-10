package com.example.richestman

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.richestman.Model.Man
import com.example.richestman.adapter.ManAdapter
import com.example.richestman.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var manAdapter: ManAdapter
    val Man=ArrayList<Man>()
    override fun onCreate(savedInstanceState: Bundle?) {
        binding= ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.ManRv.layoutManager= LinearLayoutManager(this)
        Man.add((Man("steav jobs",60,5.01,R.drawable.ab,"steav")))
        Man.add((Man("steav jobs",60,5.01,R.drawable.aa,"steav")))

        Man.add((Man("steav jobs",60,5.01,R.drawable.ac,"steav")))
        Man.add((Man("steav jobs",60,5.01,R.drawable.ad,"steav")))
        Man.add((Man("steav jobs",60,5.01,R.drawable.ag,"steav")))
        Man.add((Man("steav jobs",60,5.01,R.drawable.ae,"steav")))

        manAdapter= ManAdapter(Man)
        binding.ManRv.adapter=manAdapter
        manAdapter.onclick={
            val intent=Intent(this,DetailsActivity::class.java)
            intent.putExtra("name",it.manName)
            intent.putExtra("age",it.manage)
            intent.putExtra("networth",it.networht)
            intent.putExtra("img",it.manImg)
            intent.putExtra("desc",it.manDesc)
            startActivity(intent)
        }
        binding.addBtn.setOnClickListener {
            showManAddDialog()
        }
        val ItemTouchHelper =ItemTouchHelper(object : ItemTouchHelper.SimpleCallback(
            0,
            ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT
        ){
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {
                return  false
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                Man.removeAt(viewHolder.adapterPosition)
                manAdapter.notifyItemRemoved(viewHolder.adapterPosition)
            }

        })

                ItemTouchHelper.attachToRecyclerView(binding.ManRv)
    }

    private fun showManAddDialog() {
        val dialogView = LayoutInflater.from(this).inflate(R.layout.add_item, null)
        val ManNameEt = dialogView.findViewById<EditText>(R.id.ManNameEt)
        val MAnAgeEt =
            dialogView.findViewById<com.google.android.material.textfield.TextInputEditText>(R.id.ageEt)
        val NetworhtEt =
            dialogView.findViewById<com.google.android.material.textfield.TextInputEditText>(R.id.ManEt)
        val MAnDesc =
            dialogView.findViewById<com.google.android.material.textfield.TextInputEditText>(R.id.ManDescEt)
        AlertDialog.Builder(this)
            .setTitle("Add Man")
            .setView(dialogView)
            .setPositiveButton("Add") { _, _ ->
                val name = ManNameEt.text.toString()
                val age = MAnAgeEt.text.toString().toInt()
                val networht = NetworhtEt.text.toString().toDouble()
                val desc = MAnDesc.text.toString()
                val man = Man(name, age, networht, 0, desc)
                Man.add(man)
                manAdapter.notifyItemInserted(Man.size - 1)
            }
            .setNegativeButton("Cancel") { _, _ -> }
            .show()
    }








}