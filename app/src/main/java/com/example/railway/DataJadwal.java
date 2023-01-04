package com.example.railway;

public class DataJadwal {
    private String nama_matakuliah;
    private String nama_ruangan;
    private String jam_mulai;
    private String program_studi;

    public String getNama_matakuliah() {
        return nama_matakuliah;
    }

    public String getNama_ruangan() {
        return nama_ruangan;
    }

    public String getJam_mulai() {
        return jam_mulai;
    }

    public String getProgram_studi() {
        return program_studi;
    }

    @Override
    public String toString() {
        return "DataJadwal{" +
                "nama_matakuliah='" + nama_matakuliah + '\'' +
                ", nama_ruangan='" + nama_ruangan + '\'' +
                ", jam_mulai='" + jam_mulai + '\'' +
                ", program_studi='" + program_studi + '\'' +
                '}';
    }
}
