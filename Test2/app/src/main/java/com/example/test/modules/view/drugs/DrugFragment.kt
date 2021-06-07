package com.example.test.modules.view.drugs

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.test.R
import com.example.test.adapter.DrugAdapter
import com.example.test.commons.base.BaseFragment
import com.example.test.databinding.FragmentDrugBinding
import com.example.test.model.Drug
import kotlinx.android.synthetic.main.header_title.view.*

class DrugFragment : BaseFragment<FragmentDrugBinding, DrugViewModel>(DrugViewModel::class.java),
    DrugAdapter.DrugClickListener {
    val listDrug: MutableList<Drug> = mutableListOf()
    private lateinit var mDrugAdapter: DrugAdapter
    override fun initComponent(viewBinding: FragmentDrugBinding) {

        viewBinding.header.title.text = "Medicine"
        viewBinding.header.btnLeft.setOnClickListener {
            activity?.onBackPressed()
        }
        viewBinding.header.btnLeft.setImageResource(R.drawable.ic_baseline_arrow_back_ios_new_24)

        val recycler: RecyclerView = viewBinding.drugRecyclerView

        listDrug.add(
            Drug(
                "1", "Paracetamol", "vien", "ngay dung 2-3 vien do bac si Dinh Manh quyet dinh",
                "Paracetamol thường được chỉ định điều trị trong các trường hợp đau và sốt từ nhẹ đến vừa như đau đầu, đau cơ, đau khớp, đau lưng, đau răng, hạ sốt... Thuốc cũng có tác dụng giảm đau đối với người bị viêm khớp nhẹ, trường hợp viêm nặng hơn như viêm sưng khớp cơ thì việc sử dụng Paracetamol sẽ không hiệu quả.\n" +
                        "\n" +
                        "Khi sử dụng Paracetamol trong điều trị, thuốc hầu như không gây tác động đến hệ tim mạch và hô hấp, không làm ảnh hưởng đến sự cân bằng acid – base trong cơ thể, không gây kích ứng hay chảy máu dạ dày như một số loại thuốc có cùng tác dụng."
            )
        )
        listDrug.add(
            Drug(
                "1", "Paracetamol", "vien", "ngay dung 2-3 vien do bac si Dinh Manh quyet dinh",
                "Paracetamol thường được chỉ định điều trị trong các trường hợp đau và sốt từ nhẹ đến vừa như đau đầu, đau cơ, đau khớp, đau lưng, đau răng, hạ sốt... Thuốc cũng có tác dụng giảm đau đối với người bị viêm khớp nhẹ, trường hợp viêm nặng hơn như viêm sưng khớp cơ thì việc sử dụng Paracetamol sẽ không hiệu quả.\n" +
                        "\n" +
                        "Khi sử dụng Paracetamol trong điều trị, thuốc hầu như không gây tác động đến hệ tim mạch và hô hấp, không làm ảnh hưởng đến sự cân bằng acid – base trong cơ thể, không gây kích ứng hay chảy máu dạ dày như một số loại thuốc có cùng tác dụng."
            )
        )
        listDrug.add(
            Drug(
                "1", "Paracetamol", "vien", "ngay dung 2-3 vien do bac si Dinh Manh quyet dinh",
                "Paracetamol thường được chỉ định điều trị trong các trường hợp đau và sốt từ nhẹ đến vừa như đau đầu, đau cơ, đau khớp, đau lưng, đau răng, hạ sốt... Thuốc cũng có tác dụng giảm đau đối với người bị viêm khớp nhẹ, trường hợp viêm nặng hơn như viêm sưng khớp cơ thì việc sử dụng Paracetamol sẽ không hiệu quả.\n" +
                        "\n" +
                        "Khi sử dụng Paracetamol trong điều trị, thuốc hầu như không gây tác động đến hệ tim mạch và hô hấp, không làm ảnh hưởng đến sự cân bằng acid – base trong cơ thể, không gây kích ứng hay chảy máu dạ dày như một số loại thuốc có cùng tác dụng."
            )
        )
        listDrug.add(
            Drug(
                "1",
                "Paracetamol",
                "vien",
                "ngay dung 2-3 vien do bac si Dinh Manh quyet dinh",
                "Dung de ha sot"
            )
        )
        listDrug.add(
            Drug(
                "1",
                "Paracetamol",
                "vien",
                "ngay dung 2-3 vien do bac si Dinh Manh quyet dinh",
                "Dung de ha sot"
            )
        )
        listDrug.add(
            Drug(
                "1",
                "Paracetamol",
                "vien",
                "ngay dung 2-3 vien do bac si Dinh Manh quyet dinh",
                "Dung de ha sot"
            )
        )
        mDrugAdapter = DrugAdapter(listDrug)
        mDrugAdapter.mListener = this
        recycler.adapter = mDrugAdapter
        recycler.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
    }

    override val layoutRes: Int
        get() = R.layout.fragment_drug

    override fun itemOnClick(position: Int, drug: Drug) {
        replaceFragment(DrugDetailFragment(drug), "drugdetailfragment", true)
    }
}
