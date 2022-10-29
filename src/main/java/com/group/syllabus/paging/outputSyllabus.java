package com.group.syllabus.paging;

import com.group.syllabus.Dto.SyllabusDto;

import java.util.ArrayList;
import java.util.List;


public class outputSyllabus {
    private int page;
    private int totalPage;
    private List<SyllabusDto> listSyllabus = new ArrayList<>();

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public List<SyllabusDto> getListSyllabus(List<SyllabusDto> all) {
        return listSyllabus;
    }

    public void setListSyllabus(List<SyllabusDto> listSyllabus) {
        this.listSyllabus = listSyllabus;
    }
}
