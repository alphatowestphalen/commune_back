package com.back.commune.utils;

import org.springframework.data.domain.Page;

import java.util.ArrayList;
import java.util.List;

public class ResponsePageable <ELEMENT> {

        private int page;
        private int totalPages;
        private long totalElements;
        private List<ELEMENT> data;

        public ResponsePageable(int page, int totalPages, long totalElements, List<ELEMENT> content) {
            super();
            this.page = page;
            this.totalPages = totalPages;
            this.totalElements = totalElements;
            this.data = content;
        }

        public ResponsePageable(Page<ELEMENT> page){
            this.page = page.getNumber()+1;
            this.totalPages = page.getTotalPages();
            this.totalElements = page.getTotalElements();
            if(page.hasContent())
                this.data = page.getContent();
            else this.data = new ArrayList<ELEMENT>();
        }

        public ResponsePageable() {
            super();
            // TODO Auto-generated constructor stub
        }

        public int getPage() {
            return page;
        }

        public void setPage(int page) {
            this.page = page;
        }

        public int getTotalPages() {
            return totalPages;
        }

        public void setTotalPages(int totalPages) {
            this.totalPages = totalPages;
        }

        public long getTotalElements() {
            return totalElements;
        }

        public void setTotalElements(long totalElements) {
            this.totalElements = totalElements;
        }

        public List<ELEMENT> getData() {
            return data;
        }

        public void setData(List<ELEMENT> data) {
            this.data = data;
        }
}
