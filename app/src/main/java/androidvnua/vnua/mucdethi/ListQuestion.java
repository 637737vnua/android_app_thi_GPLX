package androidvnua.vnua.mucdethi;

public class ListQuestion {
    private String Ques;
    private String A;
    private String B;
    private String C;
    private String D;
    private int HinhAnh;
    private String Ans;

    public ListQuestion(String ques, String a, String b, String c, String d, int hinhAnh, String ans) {
        Ques = ques;
        A = a;
        B = b;
        C = c;
        D = d;
        HinhAnh = hinhAnh;
        Ans = ans;
    }

    public String getQues() {
        return Ques;
    }

    public void setQues(String ques) {
        Ques = ques;
    }

    public String getA() {
        return A;
    }

    public void setA(String a) {
        A = a;
    }

    public String getB() {
        return B;
    }

    public void setB(String b) {
        B = b;
    }

    public String getC() {
        return C;
    }

    public void setC(String c) {
        C = c;
    }

    public String getD() {
        return D;
    }

    public void setD(String d) {
        D = d;
    }

    public int getHinhAnh() {
        return HinhAnh;
    }

    public void setHinhAnh(int hinhAnh) {
        HinhAnh = hinhAnh;
    }

    public String getAns() {
        return Ans;
    }

    public void setAns(String ans) {
        Ans = ans;
    }
}
