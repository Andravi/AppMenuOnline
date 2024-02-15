package com.andravitestes.appcardapioonline

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.andravitestes.appcardapioonline.adapter.AdapterPlate
import com.andravitestes.appcardapioonline.databinding.ActivityMainBinding
import com.andravitestes.appcardapioonline.model.Plate
import com.andravitestes.appcardapioonline.plate_enum.PlateEnum


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private var finalPrice: Float = 0f

    private val appetizerList: MutableList<Plate> = mutableListOf()

    val mainPLateList: MutableList<Plate> = mutableListOf()

    val drinkList: MutableList<Plate> = mutableListOf()

    val dessertList: MutableList<Plate> = mutableListOf()

    private fun calculateFinalPrice(price: Float) {
        finalPrice += price
        updateTotalPrice()

    }

    @SuppressLint("SetTextI18n")
    private fun updateTotalPrice() {
        binding.textTotalPrice.text =
            "Total: R$ ${String.format("%.2f", this.finalPrice)}".replace('.', ',')
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Appetizers

        val recycleViewAppetizers =  PlateRecycleView(
            this,
            findViewById(R.id.recycleView_appetizers),
            appetizerList,
            30,
            onCheckboxChanged = this::calculateFinalPrice
        )

        // Main Plates
        val recycleViewMainPlates = PlateRecycleView(
            this,
            findViewById(R.id.recycleView_main_plates),
            mainPLateList,
            0,
            1,
            onCheckboxChanged = this::calculateFinalPrice
        )

        // Drinks
        val recycleViewDrinks = PlateRecycleView(
            this,
            findViewById(R.id.recycleView_drinks),
            drinkList,
            5,
            onCheckboxChanged = this::calculateFinalPrice
        )

        // Desserts
        val recycleViewDesserts = PlateRecycleView(
            this,
            findViewById(R.id.recycleView_desserts),
            dessertList,
            30,
            onCheckboxChanged = this::calculateFinalPrice
        )

        // Fill Lists
        this.initPlateLists()


        // onclieck button
        binding.buttonFinishOrder!!.setOnClickListener() {
            if (this.finalPrice > 0){
                Toast.makeText(this, "Seu pedido foi enviado para o balcão do restaurante.", Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(this, "Selecione pelo menos uma refeição antes de pedir.", Toast.LENGTH_SHORT).show()
            }
        }


    }

    private fun initPlateLists() {
        dessertList.add(Plate("Pudim", 15f,  R.drawable.pudim))
        dessertList.add(Plate("Soverte", 15.75f, R.drawable.sorverte))
        dessertList.add(Plate("Mousse de Morango", 20f, R.drawable.mousse_de_morango))
        dessertList.add(Plate("Palha italiana", 12.99f, R.drawable.palha_italiana))

        drinkList.add(
            Plate(
                "Refri do São geraldo",
                5f,
                R.drawable.refri_geraldo,
                description = "Suave com sabor de caju natural da indonésia.",
                type = PlateEnum.DRINKS
            )
        )
        drinkList.add(
            Plate(
                "Limonada",
                3.5f,
                R.drawable.limonada,
                description = "Aguá com limão taití.",
                type = PlateEnum.DRINKS
            )
        )

        mainPLateList.add(
            Plate(
                "Frango Recheado",
                35f,
                R.drawable.frango_recheado,
                description = "Frango grelhado com cebola, bacon e queijo.",
                waitTime = "40min",
                type = PlateEnum.MAIN_PLATE
            )
        )
        mainPLateList.add(
            Plate(
                "Moqueca de Peixe",
                44.99f,
                R.drawable.moqueca_peixe,
                description = "Moqueca com peixe cozido em leite de coco e azeite de dendê.",
                waitTime = "70min",
                type = PlateEnum.MAIN_PLATE
            )
        )
        mainPLateList.add(
            Plate(
                "Filé Mignon",
                53.75f,
                R.drawable.file_mignon,
                description = "Medalhão de filé mignon com molho de cogumelos e risoto com açafrão.",
                waitTime = "60min",
                type = PlateEnum.MAIN_PLATE
            )
        )
        mainPLateList.add(
            Plate(
                "Risoto de Camarão",
                25.65f,
                R.drawable.risoto_camarao,
                description = "Risoto com camarões grelhados e toque cítrico do limão siciliano.",
                waitTime = "60min",
                type = PlateEnum.MAIN_PLATE
            )
        )

        appetizerList.add(Plate("Bruschettas", 10.5f, R.drawable.bruschettas))
        appetizerList.add(Plate("Ceviche", 12f, R.drawable.ceviche))
        appetizerList.add(Plate("Espetinho Caprese", 15f, R.drawable.espetinho_caprese))
        appetizerList.add(Plate("Coxinha", 4.99f, R.drawable.coxinha))
    }
}
