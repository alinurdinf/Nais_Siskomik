package com.example.railway;

public class DataTugas {
    private String nama_tugas;
    private String desc_tugas;
    private String tgl_tugas;
    private String dl_tugas;
    private String status;

    public DataTugas(String nama_tugas, String desc_tugas, String tgl_tugas, String dl_tugas, String status){
        this.nama_tugas = nama_tugas;
        this.desc_tugas = desc_tugas;
        this.tgl_tugas = tgl_tugas;
        this.dl_tugas = dl_tugas;
        this.status = status;

    }

    public String getStatus() {
        return status;
    }

    public String getNama_tugas() {
        return nama_tugas;
    }

    public String getDesc_tugas() {
        return desc_tugas;
    }

    public String getTgl_tugas() {
        return tgl_tugas;
    }

    public String getDl_tugas() {
        return dl_tugas;
    }

    @Override
    public String toString() {
        return "DataTugas{" +
                "nama_tugas='" + nama_tugas + '\'' +
                ", desc_tugas='" + desc_tugas + '\'' +
                ", tgl_tugas='" + tgl_tugas + '\'' +
                ", dl_tugas='" + dl_tugas + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}


