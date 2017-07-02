package com.usaco_pg.customlistview

import android.content.Context
import android.graphics.BitmapFactory
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.ListAdapter
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

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
        val contents = listOf(
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

        val flowers = mutableListOf<FlowerData>()
        for (i in 0..names.count()-1) {
            flowers.add(FlowerData(names[i], contents[i], images[i]))
        }

        val adapter = FlowerAdapter(this, flowers)
        myListView.adapter = adapter as ListAdapter

    }

    data class ViewHolder(val nameTextView: TextView, val contentTextView: TextView, val profileImageView: ImageView)
    class FlowerAdapter(context: Context, flowers: List<FlowerData>) : ArrayAdapter<FlowerData>(context, 0, flowers) {

        val layoutInflater: LayoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            var view = convertView
            var holder: ViewHolder

            if (view == null) {
                view = layoutInflater.inflate(R.layout.listview_item, parent, false)
                holder = ViewHolder(
                        view?.findViewById(R.id.nameTextView) as TextView,
                        view?.findViewById(R.id.contentTextView) as TextView,
                        view?.findViewById(R.id.profileImgView) as ImageView
                )
                view?.tag = holder
            } else {
                holder = view?.tag as ViewHolder
            }

            val flower = getItem(position) as FlowerData
//            (view?.findViewById(R.id.nameTextView) as TextView).text = flower.name
//            (view?.findViewById(R.id.contentTextView) as TextView).text = flower.content
//            (view?.findViewById(R.id.profileImgView) as ImageView).setImageBitmap(BitmapFactory.decodeResource(context.resources, flower.imageId))
            holder.nameTextView.text = flower.name
            holder.contentTextView.text = flower.content
            holder.profileImageView.setImageBitmap(BitmapFactory.decodeResource(context.resources, flower.imageId))

            return view!!
        }
    }


}
