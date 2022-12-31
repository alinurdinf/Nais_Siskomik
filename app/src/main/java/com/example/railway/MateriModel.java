package com.example.railway;

import android.content.Intent;

import java.util.List;

public class MateriModel {
    private List<MateriModel.Result> result;

    public List<MateriModel.Result> getResult() {
        return result;
    }

    public void setResult(List<MateriModel.Result> result) {
        this.result = result;
    }

    public class Result {
        private String id;
        private String judul_materi, nama_dosen, materi ;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getJudul_materi() {
            return judul_materi;
        }

        public void setJudul_materi(String judul_materi) {
            this.judul_materi = judul_materi;
        }

        public String getNama_dosen() {
            return nama_dosen;
        }

        public void setNama_dosen(String nama_dosen) {
            this.nama_dosen = nama_dosen;
        }

        public String getMateri() {
            return materi;
        }

        public void setMateri(String materi) {
            this.materi = materi;
        }

        @Override
        public String toString() {
            return "Result{" +
                    "id=" + id +
                    ", judul_materi='" + judul_materi + '\'' +
                    ", nama_dosen='" + nama_dosen + '\'' +
                    ", materi='" + materi + '\'' +
                    '}';
        }

        public void startActivity(Intent i) {

        }
    }
}
