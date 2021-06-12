package androidvnua.vnua.mucdethi;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.util.SparseIntArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;


import java.util.ArrayList;

import androidvnua.vnua.thi_gplx_21.R;

public class AdapterListQues extends ArrayAdapter<ListQuestion> {

    private Activity activity;
    private ArrayList<ListQuestion> listQuestions;
    Toast t = null;
    private SparseIntArray mSpCheckedState = new SparseIntArray();

    public AdapterListQues(Activity activity, ArrayList<ListQuestion> mAnswerList) {
        super(activity, R.layout.custom_view_question, mAnswerList);
        this.activity = activity;
        this.listQuestions = mAnswerList;
    }

    @Override
    public int getCount() {
        return listQuestions.size();
    }

    @Override
    public ListQuestion getItem(int position) {
        return listQuestions.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }


    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder holder=null;
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = LayoutInflater.from(activity)
                    .inflate( R.layout.custom_view_question, parent, false);
            holder.txtQues = (TextView) convertView.findViewById(R.id.txtQuestion);
            holder.rdGroup = (RadioGroup) convertView.findViewById(R.id.rdgQuestion);
            holder.btnA = (RadioButton) convertView.findViewById(R.id.btnA);
            holder.btnB = (RadioButton) convertView.findViewById(R.id.btnB);
            holder.btnC = (RadioButton) convertView.findViewById(R.id.btnC);
            holder.btnD = (RadioButton) convertView.findViewById(R.id.btnD);
            convertView.setTag(holder);

        } else {
            holder=(ViewHolder)convertView.getTag();
        }

        holder.rdGroup.setOnCheckedChangeListener(null);
        holder.rdGroup.clearCheck();

        if(mSpCheckedState.indexOfKey(position)>-1){
            holder.rdGroup.check(mSpCheckedState.get(position));
        }else{
            holder.rdGroup.clearCheck();
        }

        holder.rdGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @SuppressLint("ResourceType")
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId > -1){
                    mSpCheckedState.put(position, checkedId);
                }else{
                    if(mSpCheckedState.indexOfKey(position)>-1)
                        mSpCheckedState.removeAt(mSpCheckedState.indexOfKey(position));
                }
            }
        });

        ListQuestion question = listQuestions.get(position);
        int number = position+1;
        if (question.getHinhAnh() != 0) {
            int img = R.drawable.imagech;
            holder.imgHinh.setImageResource(img);
        } else {

        }
        holder.txtQues.setText( "Câu " +number+": "+  question.getQues());

        holder.btnA.setText("A. "+getItem(position).getA()+ question.getHinhAnh());
        holder.btnB.setText("B. "+question.getB());

        if (question.getC().equals("null")) {
            holder.btnC.setVisibility(View.GONE);
            holder.btnC.setText(" ");
        } else {
            holder.btnC.setButtonDrawable(R.drawable.custom_radio);
            holder.btnC.setText("C. "+question.getC());
        }

        if (question.getD().equals("null")) {
            holder.btnD.setVisibility(View.GONE);
            holder.btnD.setText(" ");
        } else {
            holder.btnD.setButtonDrawable(R.drawable.custom_radio);
            holder.btnD.setText("D. "+question.getD());
        }

        return convertView;
    }

    private static class ViewHolder {
        private TextView txtQues;
        private RadioButton btnA;
        private RadioButton btnB;
        private RadioButton btnC;
        private RadioButton btnD;
        private RadioButton btnE;
        private ImageView imgHinh;
        private RadioGroup rdGroup;
    }

    void showToast(String text) {

        if (t != null)
            t.cancel();

        t = Toast.makeText(activity, text, Toast.LENGTH_SHORT);
        t.show();
    }
}
