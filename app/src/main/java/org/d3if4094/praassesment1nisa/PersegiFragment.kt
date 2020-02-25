package org.d3if4094.praassesment1nisa


import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import kotlinx.android.synthetic.main.fragment_persegi.*
import org.d3if4094.praassesment1nisa.databinding.FragmentPersegiBinding


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class PersegiFragment : Fragment() {

    private val KEY_LUAS = "luas persegi"
    private val KEY_KELILING = "keliling_persegi"
    lateinit var binding : FragmentPersegiBinding

    @SuppressLint("StringFormatInvalid")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate<org.d3if4094.praassesment1nisa.databinding.FragmentPersegiBinding>(inflater, R.layout.fragment_persegi, container, false)

        if (savedInstanceState != null){
            binding.tvLuasPersegi.text = savedInstanceState.getString(KEY_LUAS,binding.tvLuasPersegi.text.toString())
            binding.tvKelilingPersegi.text = savedInstanceState.getString(KEY_KELILING, binding.tvKelilingPersegi.text.toString())
        }

        binding.btnHitungPersegi.setOnClickListener {
            if(binding.tfPanjang.text.isEmpty() || binding.tfLebar.text.isEmpty()){
                Toast.makeText(context, "gk boleh kosong", Toast.LENGTH_SHORT).show()
            }

            var luas : Double
            var keliling : Double
            var panjang : Double
            var lebar : Double

            panjang  = binding.tfPanjang.text.toString().toDouble()
            lebar  = binding.tfLebar.text.toString().toDouble()

            luas = panjang * lebar
            keliling = (2*panjang) + (2*lebar)

            binding.tvLuasPersegi.text = getString(R.string.luasP, luas.toString())
            binding.tvKelilingPersegi.text = getString(R.string.kelilingP, keliling.toString())
        }

        binding.btnSharePersegi.setOnClickListener {
            val intent = Intent(Intent.ACTION_SEND)
            intent.type = "text/plain"
            intent.putExtra(Intent.EXTRA_TEXT, binding.tvLuasPersegi.text.toString())
            intent.putExtra(Intent.EXTRA_TEXT, binding.tvKelilingPersegi.text.toString())
            startActivity(intent)
        }

        return binding.root
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(KEY_LUAS, binding.tvLuasPersegi.text.toString())
        outState.putString(KEY_LUAS, binding.tvKelilingPersegi.text.toString())
    }

}
