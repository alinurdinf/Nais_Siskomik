package com.example.railway;

import java.util.List;

public class NilaiModel {
    private List<NilaiModel.Result> result;

    public List<NilaiModel.Result> getResult() {
        return result;
    }

    public void setResult(List<NilaiModel.Result> result) {
        this.result = result;
    }

    public class Result {
        private String nim,nama_matakuliah,semester,nilai, sks;

        public String getNim() {
            return nim;
        }

        public void setNim(String nim) {
            this.nim = nim;
        }

        public String getNama_matakuliah() {
            return nama_matakuliah;
        }

        public void setNama_matakuliah(String nama_matakuliah) {
            this.nama_matakuliah = nama_matakuliah;
        }

        public String getSemester() {
            return semester;
        }

        public void setSemester(String semester) {
            this.semester = semester;
        }

        public String getNilai() {
            return nilai;
        }

        public void setNilai(String nilai) {
            this.nilai = nilai;
        }

        public String getSks() {
            return sks;
        }

        public void setSks(String sks) {
            this.sks = sks;
        }

        @Override
        public String toString() {
            return "Result{" +
                    "nim='" + nim + '\'' +
                    ", nama_matakuliah='" + nama_matakuliah + '\'' +
                    ", semester='" + semester + '\'' +
                    ", nilai='" + nilai + '\'' +
                    ", sks='" + sks + '\'' +
                    '}';
        }
    }
}
