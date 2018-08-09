package com.usaco_pg.customlistview

import android.content.Context
import android.graphics.BitmapFactory
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.list_item.view.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val names = listOf(
                "あじさい",
                "蓮",
                "ネモフィラ",
                "バラ",
                "ふじ")
        val descriptions = listOf(
                "アジサイ（紫陽花、学名 Hydrangea macrophylla）は、アジサイ科アジサイ属の落葉低木の一種である。広義には「アジサイ」の名はアジサイ属植物の一部の総称でもある。",
                "ハス（蓮、学名：Nelumbo nucifera）は、インド原産のハス科多年性水生植物。",
                "ネモフィラはムラサキ科ネモフィラ属（Nemophila）に分類される植物の総称。または、ルリカラクサ（瑠璃唐草、学名：Nemophila menziesii）のこと。",
                "バラ（薔薇）は、バラ科バラ属の総称である。あるいは、そのうち特に園芸種（園芸バラ・栽培バラ）を総称する。ここでは、後者の園芸バラ・栽培バラを扱うこととする。 バラ属の成形は、灌木、低木、または木本性のつる植物で、葉や茎に棘を持つものが多い。",
                "フジ（藤、学名: Wisteria floribunda）は、マメ科フジ属のつる性落葉木本。一般名称としての藤には、つるが右巻き（上から見て時計回り）と左巻きの二種類がある。")
        val images = listOf(
                R.drawable.hydrangea,
                R.drawable.lotus,
                R.drawable.nemophila,
                R.drawable.rose,
                R.drawable.wisteria)

        val flowers = List(names.size) { i -> FlowerData(names[i], descriptions[i], images[i])}
        val adapter = FlowerListAdapter(this, flowers)
        myListView.adapter = adapter

        myListView.setOnItemClickListener { adapterView, view, position, id ->
            val name = view.findViewById<TextView>(R.id.nameTextView).text
            Toast.makeText(this, "clicked: $name", Toast.LENGTH_LONG).show()
        }
    }

    data class FlowerData(val name: String, val desc: String, val imageId: Int)

    data class ViewHolder(val nameTextView: TextView, val descTextView: TextView, val flowerImgView: ImageView)

    class FlowerListAdapter(context: Context, flowers: List<FlowerData>) : ArrayAdapter<FlowerData>(context, 0, flowers) {
        private val layoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            var view = convertView
            var holder: ViewHolder

            if (view == null) {
                view = layoutInflater.inflate(R.layout.list_item, parent, false)
                holder = ViewHolder(
                        view?.nameTextView!!,
                        view.descTextView,
                        view.flowerImgView
                )
                view.tag = holder
            } else {
                holder = view.tag as ViewHolder
            }

            val flower = getItem(position) as FlowerData
            holder.nameTextView.text = flower.name
            holder.descTextView.text = flower.desc
            holder.flowerImgView.setImageBitmap(BitmapFactory.decodeResource(context.resources, flower.imageId))

            return view
        }
    }
}
