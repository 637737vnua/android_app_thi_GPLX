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
    public boolean ans[] = new boolean[6];

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
        ViewHolder holder = null;
        if (convertView == null) {
            holder = new ViewHolder();
            LayoutInflater mInflater = (LayoutInflater) activity.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            convertView = mInflater.inflate(R.layout.custom_view_question, null);

            holder.txtQues = (TextView) convertView.findViewById(R.id.txtQuestion);
            holder.imgHinh = (ImageView) convertView.findViewById(R.id.imgQuestion);
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

        ListQuestion question = listQuestions.get(position);
        int number = position+1;

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

                switch (checkedId) {
                    case R.id.btnA:
                        ans[position] = question.getAns().equals("A");
                        showToast("Check btn A" + ans[position]);
                        break;
                    case R.id.btnB:
                        ans[position] = question.getAns().equals("B");
                        showToast("Check btn B" + ans[position]);
                        break;
                    case R.id.btnC:
                        ans[position] = question.getAns().equals("C");
                        showToast("Check btn C" + ans[position]);
                        break;
                    case R.id.btnD:
                        ans[position] = question.getAns().equals("D");
                        showToast("Check btn D" + ans[position]);
                        break;
                }
            }
        });

        if (holder.btnA.isChecked()) {
            ans[position] = question.getAns().equals("A");
        } else if (holder.btnB.isChecked()) {
            ans[position] = question.getAns().equals("B");
        } else if (holder.btnC.isChecked()) {
            ans[position] = question.getAns().equals("C");
        } else if (holder.btnD.isChecked()) {
            ans[position] = question.getAns().equals("D");
        }

        if (question.getHinhAnh() != 0) {
            holder.imgHinh.getLayoutParams().height = 300;
            holder.imgHinh.setImageResource(question.getHinhAnh());
        } else {
            holder.imgHinh.getLayoutParams().height = 0;
        }
        holder.txtQues.setText( "Câu " +number+": "+  question.getQues());

        holder.btnA.setText("A. "+getItem(position).getA());
        holder.btnB.setText("B. "+question.getB());

        if (question.getC().equals("null")) {
            holder.btnC.setButtonDrawable(null);
            holder.btnC.setText(" ");
        } else {
            holder.btnC.setButtonDrawable(R.drawable.custom_radio);
            holder.btnC.setText("C. "+question.getC());
        }

        if (question.getD().equals("null")) {
            holder.btnD.setButtonDrawable(null);
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
