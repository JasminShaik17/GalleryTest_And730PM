package cubex.mahesh.gallerytest

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.CheckBox
import android.widget.CompoundButton
import android.widget.VideoView
import java.io.File

class MyAdapter:BaseAdapter
{
    var path:String? = null
    var file:File? = null
    var files:Array<File>? = null
    var inflater:LayoutInflater? = null

    constructor(mainActivity: MainActivity)
    {
        path = "/storage/emulated/0/WhatsApp/Media/WhatsApp Video/"
        file = File(path)
        if(!file!!.exists()){
            path="/storage/sdcard0/WhatsApp/Media/WhatsApp Video/"
            file = File(path)
        }
        files = file!!.listFiles()
        inflater = LayoutInflater.from(mainActivity)
    }
    override fun getView(position: Int, convertView: View?,
                         parent: ViewGroup?): View {
        var v = inflater!!.inflate(R.layout.indiview,null)

        var vview = v.findViewById<VideoView>(R.id.vview)
        var cb = v.findViewById<CheckBox>(R.id.cb1)

        var indi_file = files!!.get(position)
        vview.setVideoPath(indi_file.path)
        cb.setText(indi_file.name)
        cb.setOnCheckedChangeListener(
                object : CompoundButton.OnCheckedChangeListener {
                    override fun onCheckedChanged(buttonView: CompoundButton?, isChecked: Boolean) {
                        if(isChecked){
                            vview.start()
                        }else{
                            vview.pause()
                        }
                    }

                })


            return  v
    }

    override fun getItem(position: Int): Any {
        return 0
    }

    override fun getItemId(position: Int): Long {
        return  0
    }

    override fun getCount(): Int {
        return  files!!.size
    }

}