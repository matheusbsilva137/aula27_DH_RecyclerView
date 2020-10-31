package com.example.snackbar.ui

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.snackbar.R
import com.example.snackbar.domain.Gasto
import kotlinx.android.synthetic.main.fragment_detail_gastos.view.*
import kotlinx.android.synthetic.main.fragment_home.view.*

class DetailGastosFragment : Fragment() {
    private var msg = 1
    private var listaGastos = getListaGasto()
    private var adapter = DetailGastosAdapter(listaGastos)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater!!.inflate(R.layout.fragment_detail_gastos, container, false)
        //view.tvTitleDetailGastos.text = msg.toString()

        view.rcListaGastos.adapter = adapter
        view.rcListaGastos.layoutManager = LinearLayoutManager(context)
        view.rcListaGastos.setHasFixedSize(true)

        return view
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
            arguments?.getInt("key")?.let {
                msg = it
        }
    }

    companion object{
        @JvmStatic
        fun newInstance(msg: Int) = DetailGastosFragment().apply {
            arguments = Bundle().apply {
                putInt("key", msg)
            }
        }
    }

    fun getListaGasto(): ArrayList<Gasto>{
        val gasto1 = Gasto("Refrigerante", "Alimentação", "30/10/2020", 5.5)
        val gasto2 = Gasto("Bala", "Alimentação", "30/10/2020", 2.5)

        val listaGasto = arrayListOf(gasto1, gasto2)
        return listaGasto
    }
}