package androidvnua.vnua.CauTraLoiSai;

public class ObjCauTraLoiSai {
    private String CauHoiSai;
    private int IdCauHoiSai;

    public ObjCauTraLoiSai(String cauHoiSai, int idCauHoiSai) {
        CauHoiSai = cauHoiSai;
        IdCauHoiSai = idCauHoiSai;
    }

    public String getCauHoiSai() {
        return CauHoiSai;
    }

    public void setCauHoiSai(String cauHoiSai) {
        CauHoiSai = cauHoiSai;
    }

    public int getIdCauHoiSai() {
        return IdCauHoiSai;
    }

    public void setIdCauHoiSai(int idCauHoiSai) {
        IdCauHoiSai = idCauHoiSai;
    }
}
