package com.example.railway;

import java.util.List;

import javax.xml.transform.Result;

public class KegiatanModel {

    private List<Result> result;

    public List<Result> getResult() {
        return result;
    }

    public void setResult(List<Result> result) {
        this.result = result;
    }

    private String nama_kegiatan;
    private String tgl_kegiatan;
    private String desc_kegiatan;

    public String getNama_kegiatan() {
        return nama_kegiatan;
    }

    public void setNama_kegiatan(String nama_kegiatan) {
        this.nama_kegiatan = nama_kegiatan;
    }

    public String getTgl_kegiatan() {
        return tgl_kegiatan;
    }

    public void setTgl_kegiatan(String tgl_kegiatan) {
        this.tgl_kegiatan = tgl_kegiatan;
    }

    public String getDesc_kegiatan() {
        return desc_kegiatan;
    }

    public void setDesc_kegiatan(String desc_kegiatan) {
        this.desc_kegiatan = desc_kegiatan;
    }

    @Override
    public String toString() {
        return "KegiatanModel{" +
                "result=" + result +
                ", nama_kegiatan='" + nama_kegiatan + '\'' +
                ", tgl_kegiatan='" + tgl_kegiatan + '\'' +
                ", desc_kegiatan='" + desc_kegiatan + '\'' +
                '}';
    }
}
