package com.community.demo.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class PageDTO {
    private List<QuestionDTO> questionDTOList;
    private boolean showPrevious;
    private boolean showFirstPage;
    private boolean showNext;
    private boolean showEndPage;
    private int page;
    private int totalPage;
    private List<Integer> pages=new ArrayList<>();

    public void setPagination(int totalCount, int page, int size) {
        if(totalCount%size==0){
            totalPage=totalCount/size;
        }else{
            totalPage=totalCount/size+1;
        }

        this.page=page;

        pages.add(page);
        for(int i=1;i<=3;i++){
            if(page-i>0){
                pages.add(0,page-i); //0代表list头部，表示从头部插入
            }
            if(page+i<=totalPage){
                pages.add(page+i); //不写element就是从尾部插入；
            }
        }

        //是否展示上一页
        if(page==1){
            showNext=false;
        }else{
            showNext=true;
        }
        //是否展示下一页
        if(page==totalPage){
            showNext=false;
        }else{
            showNext=true;
        }
        //是否展示第一页
        if(pages.contains(1)){
            showFirstPage=false;
        }else{
            showFirstPage=true;
        }
        //是否展示最后一页
        if(pages.contains(totalPage)){
            showEndPage=false;
        }else{
            showEndPage=true;
        }

    }
}
