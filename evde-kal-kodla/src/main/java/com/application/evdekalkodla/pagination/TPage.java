package com.application.evdekalkodla.pagination;


import lombok.Data;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import java.util.List;

@Data
public class TPage<T> {

    // https://dzone.com/articles/pagination-in-springboot-applications
    private int number; // suan kacinci sayfayi tutan property
    private int size; // kayitlari kacarli tutan property
    private Sort sort; // herhangi bir colon sıralama
    private int totalPages; // toplamda kac sayfayi tutan property
    private Long totalElements;  // toplamda kac kayit tutan property
    private List<T> content; // Burada data yi tutan property'i

    // spring in  Page<T> page, List<T> content leri kendi TPage<T> set ediyorum..
    public void setPage(Page page, List<T> list)
    {
        this.number=page.getNumber();
        this.size=page.getSize();
        this.sort=page.getSort();
        this.totalPages=page.getTotalPages();
        this.totalElements=page.getTotalElements();
        this.content = list;
        //this.content = content; // buradadaki contentide dataya set et..
    }
}
