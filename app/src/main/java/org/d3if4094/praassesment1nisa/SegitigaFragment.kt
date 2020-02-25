package org.d3if4094.praassesment1nisa


import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import org.d3if4094.praassesment1nisa.databinding.FragmentSegitigaBinding


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class SegitigaFragment : Fragment() {

    private val KEY_LUAS = "luas persegi"
    private val KEY_KELILING = "keliling_persegi"
    lateinit var binding : FragmentSegitigaBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate<FragmentSegitigaBinding>(inflater, R.layout.fragment_segitiga, container, false)

        if (savedInstanceState != null){
            binding.tvLuasSegitiga.text = savedInstanceState.getString(KEY_LUAS,binding.tvLuasSegitiga.text.toString())
            binding.tvKelilingSegitiga.text = savedInstanceState.getString(KEY_KELILING, binding.tvKelilingSegitiga.text.toString())
        }

        binding.btnHitungSegitiga.setOnClickListener {
            if(binding.tfAlas.text.isEmpty() || binding.tfTinggi.text.isEmpty()){
                Toast.makeText(context, "gk boleh kosong", Toast.LENGTH_SHORT).show()
            }

            var luas : Double
            var keliling : Double
            var alas : Double
            var tinggi : Double

            alas  = binding.tfAlas.text.toString().toDouble()
            tinggi  = binding.tfTinggi.text.toString().toDouble()

            luas = (alas*tinggi)/2
            var miring = Math.sqrt(Math.pow(alas,2.0) + Math.pow(tinggi, 2.0))
            keliling = alas + tinggi + miring

            binding.tvLuasSegitiga.text = getString(R.string.luasS, luas.toString())
            binding.tvKelilingSegitiga.text = getString(R.string.kelilingS, keliling.toString())
        }

        binding.btnShareSegitiga.setOnClickListener {
            val intent = Intent(Intent.ACTION_SEND)
            intent.type = "plain/text"
            intent.putExtra(Intent.EXTRA_TEXT, binding.tvLuasSegitiga.text.toString())
            intent.putExtra(Intent.EXTRA_TEXT, binding.tvKelilingSegitiga.text.toString())
            startActivity(intent)
        }

        return binding.root
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(KEY_LUAS, binding.tvLuasSegitiga.text.toString())
        outState.putString(KEY_LUAS, binding.tvKelilingSegitiga.text.toString())
    }
}
