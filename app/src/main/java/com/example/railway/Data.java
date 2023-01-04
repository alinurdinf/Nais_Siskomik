package com.example.railway;

public class Data {
    private String nim;
    private String nama_matakuliah;
    private String semester;
    private String nilai;
    private String sks;

    public Data(String nim, String nama_matakuliah, String semester, String nilai, String sks) {
        this.nim = nim;
        this.nama_matakuliah = nama_matakuliah;
        this.semester = semester;
        this.nilai = nilai;
        this.sks = sks;
    }

    public String getNim() {
        return nim;
    }

    public String getNamaMatakuliah() {
        return nama_matakuliah;
    }

    public String getSemester() {
        return semester;
    }

    public String getNilai() {
        return nilai;
    }

    public String getSks() {
        return sks;
    }
}
