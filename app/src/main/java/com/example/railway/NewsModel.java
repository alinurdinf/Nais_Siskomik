package com.example.railway;

import java.util.List;

public class NewsModel {

    private List<NewsModel.Result> result;

    public List<NewsModel.Result> getResult() {
        return result;
    }

    public void setResult(List<NewsModel.Result> result) {
        this.result = result;
    }

    public class Result {
        private String id, title, desc_berita, content, penulis, image, tgl_berita;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getDesc_berita() {
            return desc_berita;
        }

        public void setDesc_berita(String desc_berita) {
            this.desc_berita = desc_berita;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getPenulis() {
            return penulis;
        }

        public void setPenulis(String penulis) {
            this.penulis = penulis;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public String getTgl_berita() {
            return tgl_berita;
        }

        public void setTgl_berita(String tgl_berita) {
            this.tgl_berita = tgl_berita;
        }

        @Override
        public String toString() {
            return "Result{" +
                    "id='" + id + '\'' +
                    ", title='" + title + '\'' +
                    ", desc_berita='" + desc_berita + '\'' +
                    ", content='" + content + '\'' +
                    ", penulis='" + penulis + '\'' +
                    ", image='" + image + '\'' +
                    ", tgl_berita='" + tgl_berita + '\'' +
                    '}';
        }
    }
}
