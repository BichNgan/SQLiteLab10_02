package vlu.android.sqlitelab10_02.Model;

public class Khoa {
    String mKhoa;
    String tenKhoa;

    public Khoa() {
    }

    public Khoa(String mKhoa, String tenKhoa) {
        this.mKhoa = mKhoa;
        this.tenKhoa = tenKhoa;
    }

    public String getmKhoa() {
        return mKhoa;
    }

    public void setmKhoa(String mKhoa) {
        this.mKhoa = mKhoa;
    }

    public String getTenKhoa() {
        return tenKhoa;
    }

    public void setTenKhoa(String tenKhoa) {
        this.tenKhoa = tenKhoa;
    }
}
