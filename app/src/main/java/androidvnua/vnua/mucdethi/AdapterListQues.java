package androidvnua.vnua.mucdethi;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.List;

import androidvnua.vnua.thi_gplx_21.R;

public class AdapterListQues extends BaseAdapter {

    private final Context context;
    private final int layout;
    private final List<ListQuestion> listQuestions;
    public boolean ansMe[];

    public AdapterListQues(Context context, int layout, List<ListQuestion> listQuestions) {
        this.context = context;
        this.layout = layout;
        this.listQuestions = listQuestions;
    }

    @Override
    public int getCount() {
        return listQuestions.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    private class viewHolder {
        TextView Q;
        RadioButton A, B, C, D;
        RadioGroup rdgList;
        ImageView imgHinh;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        viewHolder holder;
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(layout, null);
            holder = new viewHolder();
            holder.Q = (TextView) convertView.findViewById(R.id.txtQuestion);
            holder.imgHinh = (ImageView) convertView.findViewById(R.id.imgQuestion);
            holder.A = (RadioButton) convertView.findViewById(R.id.btnA);
            holder.B = (RadioButton) convertView.findViewById(R.id.btnB);
            holder.C = (RadioButton) convertView.findViewById(R.id.btnC);
            holder.D = (RadioButton) convertView.findViewById(R.id.btnD);
            holder.rdgList = (RadioGroup) convertView.findViewById(R.id.rdgQuestion);
            convertView.setTag(holder);
        }else {
            holder = (viewHolder) convertView.getTag();
        }

        ListQuestion question = listQuestions.get(position);
        int number = position+1;

        ansMe = new boolean[listQuestions.size()];

        if (question.getHinhAnh() != 0) {
            holder.imgHinh.getLayoutParams().height = 260;
            holder.imgHinh.setImageResource(question.getHinhAnh());
        } else {
            holder.imgHinh.getLayoutParams().height = 1;
        }

        holder.Q.setText( "Câu " +number+": "+  question.getQues());
        holder.A.setText("A. "+question.getA());
        holder.B.setText("B. "+question.getB());
        if (question.getC().equals("null")) {
            holder.C.setVisibility(View.GONE);
            holder.C.setText(" ");
        } else {
            holder.C.setButtonDrawable(R.drawable.custom_radio);
            holder.C.setText("C. "+question.getC());
        }

        if (question.getD().equals("null")) {
            holder.D.setVisibility(View.GONE);
            holder.D.setText(" ");
        } else {
            holder.D.setButtonDrawable(R.drawable.custom_radio);
            holder.D.setText("D. "+question.getD());
        }

        return convertView;
    }
}
